package com.example.demo.cep.controller;

import com.example.demo.cep.client.ViaCepClient;
import com.example.demo.cep.client.response.AddressResponse;
import com.example.demo.cep.controller.request.TestPost;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
@Validated
public class CepController {

    private final ViaCepClient viaCepClient;

    public CepController(final ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    @GetMapping
    public AddressResponse cep(@RequestParam(name = "cep") final String cep) {
        return this.viaCepClient.getAddress(cep);
    }

    @PostMapping
    public void testPost(@RequestBody(required = false) @Valid TestPost testPost) {
        System.out.println(testPost);
    }
}
