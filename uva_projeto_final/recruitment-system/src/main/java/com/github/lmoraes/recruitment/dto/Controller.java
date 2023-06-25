package com.github.lmoraes.recruitment.dto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public class Controller {

    @PostMapping("/candidatura/{candidaturaId}/etapa/{etapaId}/tipo/{tipo}")
    public void realizar(
            @PathVariable(required = true) String candidaturaId,
            @PathVariable(required = true) String etapaId,
            @PathVariable(required = true) String tipo,
            @RequestParam(required = false) Map<String, MultipartFile> params,
            @RequestBody(required = false) RealizarEtapaDto dto
    ) {

    }
}
