package com.dti.lembretes.utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DataValidation {


    /**
     * Verifica se a data está no formato dd/MM/yyyy
     * @param data informada no input
     * @return true se a data estiver no formato dd/MM/yyyy
     */
    public boolean isDataValida(String data) {
        return data.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})");
    }

    public boolean verificaSeDataEhPosteriorADataAtual(String data) {
        Date dataAtual = new Date(System.currentTimeMillis());
        Date dataDoLembrete = new SimpleDateFormat("dd/MM/yyyy").parse(data.toString(), new java.text.ParsePosition(0));
        return dataDoLembrete.after(dataAtual);
    }
}
