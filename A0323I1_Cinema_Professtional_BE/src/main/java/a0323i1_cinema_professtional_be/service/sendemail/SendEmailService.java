package a0323i1_cinema_professtional_be.service.sendemail;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.mail.internet.MimeMessage;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender mailSender;

    public SendEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmailWithQRCode(String to, String subject, String body, String qrData, int qrWidth, int qrHeight) {
        try {

            BufferedImage qrImage = generateQrCodeImage(qrData, qrWidth, qrHeight);


            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);


            helper.setTo(to);
            helper.setSubject(subject);


            String content = "<p>" + body + "</p><br><img src='cid:qr_code.png'/>";
            helper.setText(content, true);


            ByteArrayOutputStream qrOutputStream = new ByteArrayOutputStream();
            ImageIO.write(qrImage, "png", qrOutputStream);
            byte[] qrByteArray = qrOutputStream.toByteArray();
            helper.addInline("qr_code.png", new ByteArrayResource(qrByteArray), "image/png");


            mailSender.send(message);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private BufferedImage generateQrCodeImage(String data, int width, int height) throws WriterException, IOException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, width, height);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return bufferedImage;
    }

}
