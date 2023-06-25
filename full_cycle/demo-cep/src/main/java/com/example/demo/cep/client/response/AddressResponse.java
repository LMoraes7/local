package com.example.demo.cep.client.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AddressResponse(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ddd) {

    @JsonCreator
    @JsonIgnoreProperties(ignoreUnknown = true)
    public AddressResponse(
            @JsonProperty("cep") final String cep,
            @JsonProperty("logradouro") final String logradouro,
            @JsonProperty("complemento") final String complemento,
            @JsonProperty("bairro") final String bairro,
            @JsonProperty("localidade") final String localidade,
            @JsonProperty("uf") final String uf,
            @JsonProperty("ddd") final String ddd
    ) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ddd = ddd;
    }
}
