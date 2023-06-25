package br.com.moraes.clean.architecture.domain.error;

public enum ErrorInformation {

//  Entidade já existente no Repositório de Dados
    STUD_0001("error.information.stud.0001");

    public final String reason;

    ErrorInformation(final String reason) {
        this.reason = reason;
    }
}
