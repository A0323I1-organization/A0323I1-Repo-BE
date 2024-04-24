package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.ticket.TicketProjection;
import a0323i1_cinema_professtional_be.exception.ApiResponse;
import a0323i1_cinema_professtional_be.exception.ResourceNotFoundException;
import a0323i1_cinema_professtional_be.service.ticket.TicketService;
import a0323i1_cinema_professtional_be.utils.ExportPDF;
import com.google.api.gax.rpc.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000",allowedHeaders = "*")
@RequestMapping("/api/ticket")
@Slf4j
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/findAllTicket")
    public ResponseEntity<List<TicketProjection>> findAllTicket(){
        return new ResponseEntity<>(ticketService.finAllTicket(), HttpStatus.OK);
    }

    @GetMapping("/searchTicketList")
    public ResponseEntity<List<TicketProjection>> searchTicketList(@RequestParam("keyword") String keyword){
        return new ResponseEntity<>(ticketService.searchTicketList(keyword),HttpStatus.OK);
    }
    @GetMapping("/findById")
    public ResponseEntity<TicketProjection> findById(int id){
        return new ResponseEntity<>(ticketService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/searchForStartAndEndDates/{pageNo}")
    public ResponseEntity<ApiResponse<Page<TicketProjection>>> searchForStartAndEndDates(@RequestParam(name = "startDate", defaultValue = "",required = false) String startDate, @RequestParam(name = "endDate", defaultValue = "",required = false) String endDate, @PathVariable("pageNo") int pageNo){
        Page<TicketProjection> resultForStartAndEndDates = ticketService.searchForStartAndEndDates(startDate,endDate,pageNo);
        if(resultForStartAndEndDates.isEmpty()) {
                throw new ResourceNotFoundException("Resource not found. Please check the requested.");
        } else {
            return new ResponseEntity<>(ApiResponse.<Page<TicketProjection>>builder()
                    .results(resultForStartAndEndDates)
                    .success(true)
                    .build(),HttpStatus.OK);
        }
    }
    @GetMapping("/findAllTicketPage/{pageNo}")
    public ResponseEntity<Page<TicketProjection>> findAllTicketPage(@PathVariable("pageNo") int pageNo){
        return new ResponseEntity<>(ticketService.findAllTicketPages(pageNo), HttpStatus.OK);
    }
    @GetMapping(value = "/exportPdf/{id}",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> ticketReports(@PathVariable("id") int id) throws IOException {
        TicketProjection ticket = ticketService.findById(id);
        if (ticket == null){
            throw new ResourceNotFoundException("Ticket","id",id);
        }
        ByteArrayInputStream bis = ExportPDF.ticketReport(ticket);

        HttpHeaders  headers = new HttpHeaders();

        headers.add("Content-Disposition","attachment;filename=ticket.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));

    }

}
