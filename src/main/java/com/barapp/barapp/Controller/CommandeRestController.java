package com.barapp.barapp.Controller;

import com.barapp.barapp.Dto.CommandeCreateDto;
import com.barapp.barapp.Model.Entity.Commande;
import com.barapp.barapp.Projection.CommandeClientProjection;
import com.barapp.barapp.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande")
public class CommandeRestController {

    private final SimpMessagingTemplate template;

    @Autowired
    public CommandeRestController(SimpMessagingTemplate template) {
        this.template = template;
    }
    @Autowired
    private CommandeService commandeService;
    @GetMapping
    public ResponseEntity<List<CommandeClientProjection>> getAllForClient(){
        return new ResponseEntity<>(commandeService.getAllForClient(), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Integer> createOne(@RequestBody CommandeCreateDto commandeCreateDto) {
        Commande newCommande = commandeService.save(commandeCreateDto);

        this.template.convertAndSend("/socket/admin", newCommande);
        return new ResponseEntity<>(newCommande.getNumero(), HttpStatus.CREATED) ;
    }
}
