package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.TicketProjection;
import a0323i1_cinema_professtional_be.service.ticket.TicketService;
import a0323i1_cinema_professtional_be.utils.ExportPDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/findAllTicket")
    public ResponseEntity<List<TicketProjection>> findAllTicket(){
        return new ResponseEntity<>(ticketService.finAllTicket(), HttpStatus.OK);
    }

    @GetMapping("/findAllTicketPage/{pageNo}")
    public ResponseEntity<Page<TicketProjection>> findAllTicketPage(@PathVariable("pageNo") int pageNo){
        return new ResponseEntity<>(ticketService.findAllTicketPages(pageNo), HttpStatus.OK);
    }

    @GetMapping("/searchTicketList")
    public ResponseEntity<List<TicketProjection>> searchTicketList(@RequestParam("keyword") String keyword){
        return new ResponseEntity<>(ticketService.searchTicketList(keyword),HttpStatus.OK);
    }
    @GetMapping("/findById")
    public ResponseEntity<TicketProjection> findById(int id){
        return new ResponseEntity<>(ticketService.findById(id),HttpStatus.OK);
    }

    @GetMapping(value = "/exportPdf",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> ticketReports(@RequestParam("id") int id) throws IOException {
        TicketProjection ticket = ticketService.findById(id);

        ByteArrayInputStream bis = ExportPDF.ticketReport(ticket);
        HttpHeaders  headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=ticket.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
    }

}
