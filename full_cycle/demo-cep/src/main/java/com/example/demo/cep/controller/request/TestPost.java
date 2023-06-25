package com.example.demo.cep.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestPost {
    @NotBlank
    private String oi;
    @NotBlank
    private String hello;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public TestPost(String oi, String hello) {
        this.oi = oi;
        this.hello = hello;
    }

    public String getOi() {
        return oi;
    }

    public void setOi(String oi) {
        this.oi = oi;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
