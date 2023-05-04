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
        return ResponseEntity.ok("Lembrete: " + this.lembreteService.criaLembrete(lembreteDTO) + " criado com sucesso!");
    }

    @GetMapping("/lembretes")
    public ResponseEntity<?> listaDeLembretes() {
        return ResponseEntity.ok(this.lembreteService.listaLembretesPorData());
    }

    @DeleteMapping("/lembrete/{nomeDoLembrete}")
    public ResponseEntity<?> deletaLembrete(@Validated @PathVariable String nomeDoLembrete) {
        this.lembreteService.deletaLembrete(nomeDoLembrete);
        return ResponseEntity.ok().build();
    }

}

