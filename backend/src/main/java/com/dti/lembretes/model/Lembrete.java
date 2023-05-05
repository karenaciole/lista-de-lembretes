package com.dti.lembretes.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
public class Lembrete {
    @NonNull
    private String nomeDoLembrete;
    @NonNull
    private Date dataDoLembrete;

}
