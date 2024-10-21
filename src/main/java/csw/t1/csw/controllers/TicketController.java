package csw.t1.csw.controllers;

import csw.t1.csw.dto.ticket.RequestTicketDTO;
import csw.t1.csw.dto.ticket.ResponseTicketDTO;
import csw.t1.csw.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping
@RestController
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping("/create-ticket")
    public ResponseEntity<ResponseTicketDTO> createTicket(@RequestBody @Valid RequestTicketDTO dto) {
        return service.createTicket(dto);
    }

    @GetMapping("/get-tickets/by-event/{id}")
    public ResponseEntity<List<ResponseTicketDTO>> getTicketsByEvent(@PathVariable Long id) {
        return service.getTicketsByEvent(id);
    }
}