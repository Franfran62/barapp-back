package com.barapp.barapp.Controller.Admin;

import com.barapp.barapp.Dto.CommandeEditDto;
import com.barapp.barapp.Dto.CommandeReadDto;
import com.barapp.barapp.Model.Entity.Commande;
import com.barapp.barapp.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/commande")
public class AdminCommandeRestController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public ResponseEntity<List<Commande>> getAllForBarmaker(){
        return new ResponseEntity<>(commandeService.getAllForAdmin(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommandeReadDto> getCommand(@PathVariable Integer id)  {
        Optional<CommandeReadDto> commande = commandeService.getOneById(id);
        return new ResponseEntity<>(commande.orElse(null), HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<Boolean> updateProduits(@RequestBody CommandeEditDto commandeEditDto)  {
        return new ResponseEntity<>(commandeService.updateProduits(commandeEditDto), HttpStatus.OK);
    }
}
