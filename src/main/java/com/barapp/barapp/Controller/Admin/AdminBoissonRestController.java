package com.barapp.barapp.Controller.Admin;

import com.barapp.barapp.Dto.BoissonDto;
import com.barapp.barapp.Model.Entity.Boisson;
import com.barapp.barapp.Service.impl.BoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin/boisson")
public class AdminBoissonRestController {

    @Autowired
    private BoissonService boissonService;

    @PutMapping
    public ResponseEntity<Boisson> createOne(@RequestBody BoissonDto boissonDto) {
        return new ResponseEntity<>(boissonService.save(boissonDto), HttpStatus.CREATED) ;
    }

    public ResponseEntity<Boolean> patchHonneur(@RequestBody Integer id)  {
        return  new ResponseEntity<>(boissonService.patchHonneur(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boisson> findById(@PathVariable Integer id) {
        Optional<Boisson> boisson = boissonService.getOneById(id);
        return new ResponseEntity<>(boisson.orElse(null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<Boolean>(boissonService.deleteById(id), HttpStatus.OK);
    }
}
