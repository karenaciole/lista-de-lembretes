package com.dti.lembretes.service;

import com.dti.lembretes.dto.LembreteDTO;
import com.dti.lembretes.model.Lembrete;
import com.dti.lembretes.repository.LembreteRepository;
import com.dti.lembretes.utils.DataValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class LembreteService {
    @Autowired
    private LembreteRepository lembreteRepository;

    public void criaLembrete(LembreteDTO lembreteDTO) {
        if (!checaDataValida(lembreteDTO.dataDoLembrete()))
            throw new IllegalArgumentException("Data inválida!");

        Date data = convertStringToDate(lembreteDTO.dataDoLembrete());
        Lembrete lembrete = new Lembrete(lembreteDTO.nomeDoLembrete(), data);

        this.lembreteRepository.criaLembrete(lembrete);
    }

    public void deletaLembrete(String id) {
        this.lembreteRepository.deletaLembrete(id);
    }

    public List<Lembrete> listaDeLembretes() {
        return new ArrayList<>(this.lembreteRepository.getAll());
    }

    public List<Lembrete> listaLembretesPorData() {
        List<Lembrete> ordenadoPorData = new ArrayList<>(this.lembreteRepository.getAll());
        ordenadoPorData.sort(Comparator.comparing(Lembrete::getDataDoLembrete));
        return ordenadoPorData;
    }

    private Date convertStringToDate(String data) {
        return new SimpleDateFormat("dd/MM/yyyy").parse(data, new java.text.ParsePosition(0));
    }

    private boolean checaDataValida(String data) {
        DataValidation dataValidation = new DataValidation();
        return dataValidation.isDataValida(data) && dataValidation.verificaSeDataEhPosteriorADataAtual(data);
    }

}
