package com.dti.lembretes.repository;

import com.dti.lembretes.model.Lembrete;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LembreteRepository {
    private Map<String, Lembrete> lembretes;

    public LembreteRepository() {
        this.lembretes = new HashMap<>();
    }

    public Collection<Lembrete> getAll() {
        return this.lembretes.values();
    }

    public String criaLembrete(Lembrete lembrete) {
        this.lembretes.put(lembrete.getNomeDoLembrete(), lembrete);
        return lembrete.getNomeDoLembrete();
    }

    public void deletaLembrete(String nomeDoLembrete) {
        this.lembretes.remove(nomeDoLembrete);
    }

}
