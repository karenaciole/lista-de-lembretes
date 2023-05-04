package com.dti.lembretes.dto;

public record LembreteDTO(String nomeDoLembrete, String dataDoLembrete) {

    /**   O método isDataValida() é responsável por validar a entrada da data do lembrete.
     *   A data deve ser inserida no formato dd/MM/yyyy.
     *   @return true se a data for válida, false caso contrário.
     */
    public boolean isDataValida() {
        return this.dataDoLembrete.matches("\\d{2}/\\d{2}/\\d{4}");
    }
}


