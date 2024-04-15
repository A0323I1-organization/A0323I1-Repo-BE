package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.config.ConfigVNPAY;
import a0323i1_cinema_professtional_be.dto.payment.PaymentDTO;
import a0323i1_cinema_professtional_be.dto.ticket.TicketDetail;
import a0323i1_cinema_professtional_be.entity.Invoice;
import a0323i1_cinema_professtional_be.service.invoice.InvoiceService;
import a0323i1_cinema_professtional_be.service.sendemail.SendEmailService;
import a0323i1_cinema_professtional_be.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class PaymentController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private TicketService ticketService;

    @Autowired
    private SendEmailService sendEmailService;

    @GetMapping("/pay")
    public ResponseEntity<PaymentDTO> getPay() throws UnsupportedEncodingException {

        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        long amount = 10000 * 100;
        String bankCode = "NCB";

        String vnp_TxnRef = ConfigVNPAY.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";

        String vnp_TmnCode = ConfigVNPAY.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");

        vnp_Params.put("vnp_BankCode", bankCode);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", orderType);

        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", ConfigVNPAY.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = ConfigVNPAY.hmacSHA512(ConfigVNPAY.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = ConfigVNPAY.vnp_PayUrl + "?" + queryUrl;

        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setURL(paymentUrl);
        paymentDTO.setStatus("ok");
        paymentDTO.setMessage("successful");
        return ResponseEntity.status(HttpStatus.OK).body(paymentDTO);
    }

    @GetMapping("/payment-infor")
    public ResponseEntity<List<TicketDetail>> transaction(
            @RequestParam(value = "vnp_PayDate") String date,
            @RequestParam(value = "vnp_Amount") String amount,
            @RequestParam(value = "vnp_OrderInfo") String order,
            @RequestParam(value = "vnp_BankCode") String bankCode,
            @RequestParam(value = "vnp_ResponseCode") String responseCode,
            @CookieValue(value = "listSeat") String seatIdsString,
            @CookieValue(value = "customerId") int customerId) {

        if (responseCode.equals("00")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
            dateTime = dateTime.withSecond(0);
            invoiceService.createInvoice(dateTime, customerId, 1);
            Invoice invoice = invoiceService.getInvoiceByCustomerId(dateTime, 1);
            List<Integer> seatIds = Arrays.stream(seatIdsString.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            ticketService.createTicket(invoice.getInvoiceId(), seatIds);
            System.out.println(seatIds);
            List<TicketDetail> ticketDetail = ticketService.getTicket(invoice.getInvoiceId(), seatIds);
            sendEmailService.sendEmailWithQRCode("nguyenhuynhbaolong8@gmail.com", "Confirm ticket",
                    "Vui lòng đem mã qr ra quầy vé để nhận vé", String.valueOf(invoice.getInvoiceId()),
                    300, 300);
            return new ResponseEntity<>(ticketDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
