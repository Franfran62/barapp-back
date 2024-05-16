package com.barapp.barapp.Service.impl;

import com.barapp.barapp.Dto.CategorieDto;
import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Projection.ListeProjection;
import com.barapp.barapp.Repository.CategorieRepository;
import com.barapp.barapp.Service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService implements IGenericService<Categorie, Integer> {
    @Autowired
    private CategorieRepository categorieRepository;
    @Override
    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Optional<Categorie> getOneById(Integer id) {
        return categorieRepository.findById(id);
    }

    public Categorie save(CategorieDto CategorieDto) {
        Categorie categorie = new Categorie();
        categorie.setNom(CategorieDto.getNom());
        return categorieRepository.save(categorie);
    }

    @Override
    public Boolean deleteById(Integer id) {
        try {
            categorieRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ListeProjection> getListeOfCategorie() {
        return categorieRepository.getListeOfCategorie();
    }
}
