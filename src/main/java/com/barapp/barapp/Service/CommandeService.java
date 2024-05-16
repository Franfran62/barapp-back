package com.barapp.barapp.Service;

import com.barapp.barapp.Dto.CommandeCreateDto;
import com.barapp.barapp.Dto.CommandeEditDto;
import com.barapp.barapp.Dto.CommandeReadDto;
import com.barapp.barapp.Model.Entity.Commande;
import com.barapp.barapp.Model.Model.Produit;
import com.barapp.barapp.Model.Model.StatutBoisson;
import com.barapp.barapp.Model.Model.StatutCommande;
import com.barapp.barapp.Projection.CommandeClientProjection;
import com.barapp.barapp.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    private static int count;
    private int i;

    public List<CommandeClientProjection> getAllForClient() {
        return commandeRepository.getCommandesForClientView();
    }

    public List<Commande> getAllForAdmin() {
        return commandeRepository.findAll();
    }

    public Optional<CommandeReadDto> getOneById(Integer id) {

        Optional<Commande> commande = commandeRepository.findById(id);

        if (!commande.isEmpty())  {
            CommandeReadDto commandeReadDto = new CommandeReadDto();
            commandeReadDto.setPrix(commande.get().getPrix());
            commandeReadDto.setDate(commande.get().getDate());
            commandeReadDto.setStatut(commande.get().getStatut());
            commandeReadDto.setProduits(commande.get().getProduits());
            commandeReadDto.setNumero(commande.get().getNumero());

            return Optional.ofNullable(commandeReadDto);
        }

        return Optional.empty();
    }

    public Commande save(CommandeCreateDto commandeCreateDto) {

        Commande commande = new Commande();

        if (count > 999) {
            count = 0;
        }

        commande.setNumero(count);
        count++;

        commande.setDate(new Date());
        commande.setPrix(commandeCreateDto.getPrix());
        commande.setProduits(commandeCreateDto.getProduits());
        commande.setStatut(StatutCommande.COMMANDE.getValue());
        commande.setNbProduit(commandeCreateDto.getProduits().size());
        Commande newCommande = commandeRepository.save(commande);

        return commande;
    }

    public Boolean updateProduits(CommandeEditDto commandeEditDto) {
        Optional<Commande> commande = commandeRepository.findById(commandeEditDto.getId());

        if (commande.isPresent()) {
            Commande commande1 = commande.get();
            commande1.setProduits(commandeEditDto.getProduits());
            commande1.setStatut(this.updateStatutCommande(commande1));

            commandeRepository.save(commande1);
            return true;
        }
        return false;
    }

    private String updateStatutCommande(Commande commande) {

        if (Objects.equals(commande.getStatut(), StatutCommande.EN_PREPARATION.getValue())) {

            List<Produit> produits = commande.ConvertProduits();
            i = 0;
            produits.forEach(produit -> {
                if (Objects.equals(produit.getStatut(), StatutBoisson.TERMINNE.getValue())) {
                    i++;
                }
            });

            if (produits.size() == i) {
                return StatutCommande.TERMINEE.getValue();
            }
        }

        return StatutCommande.EN_PREPARATION.getValue();
    }
}
