package com.dti.lembretes.service;

import com.dti.lembretes.dto.LembreteDTO;
import com.dti.lembretes.model.Lembrete;
import com.dti.lembretes.repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LembreteService {
    @Autowired
    private LembreteRepository lembreteRepository;

    public void criaLembrete(LembreteDTO lembreteDTO) {
        Date data = convertStringToDate(lembreteDTO.dataDoLembrete());
        Lembrete lembrete = new Lembrete(lembreteDTO.nomeDoLembrete(), data);
        this.lembreteRepository.criaLembrete(lembrete);
    }

    public void deletaLembrete(String nomeDoLembrete) {
        this.lembreteRepository.deletaLembrete(nomeDoLembrete);
    }

    public List<Lembrete> listaDeLembretes() {
        return new ArrayList<>(this.lembreteRepository.getAll());
    }

    private Date convertStringToDate(String data) {
        return new SimpleDateFormat("dd/MM/yyyy").parse(data, new java.text.ParsePosition(0));
    }

}
