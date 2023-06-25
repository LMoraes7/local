package com.example.demo.cep.client;

import com.example.demo.cep.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCepClient", url = "${url.via-cep}")
public interface ViaCepClient {

    @GetMapping("/ws/{cep}/json/")
    AddressResponse getAddress(@PathVariable(name = "cep") final String cep);
}
