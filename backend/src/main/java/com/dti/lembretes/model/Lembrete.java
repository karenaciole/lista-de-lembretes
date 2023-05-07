package com.dti.lembretes.model;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.UUID;

@Data
public class Lembrete {
    
    private String id = UUID.randomUUID().toString();
    @NonNull
    private String nomeDoLembrete;
    @NonNull
    private Date dataDoLembrete;

}
