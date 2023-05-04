package com.dti.lembretes.controller;

import com.dti.lembretes.dto.LembreteDTO;
import com.dti.lembretes.service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LembreteController {
    @Autowired
    private LembreteService lembreteService;

    @PostMapping("/lembrete")
    public ResponseEntity<?> criaLembrete(@Validated @RequestBody LembreteDTO lembreteDTO) {
        this.lembreteService.criaLembrete(lembreteDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/lembretes")
    public ResponseEntity<?> listaDeLembretes() {
        return ResponseEntity.ok(this.lembreteService.listaDeLembretes());
    }

}

