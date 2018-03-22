package com.richardcsantana.controller;

import com.richardcsantana.model.Dado;
import com.richardcsantana.repository.DadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/dado")
@RequiredArgsConstructor
public class DadoController {

    private final DadoRepository dadoRepository;

    @PostMapping
    public Dado create(@RequestBody Dado dado) {
        return dadoRepository.save(dado);
    }

    @PutMapping(path = "/{id}")
    public Dado create(@PathVariable Long id, @RequestBody Dado dado) {
        Optional<Dado> optDado = dadoRepository.findById(id);
        Dado result = null;
        if (optDado.isPresent()) {
            BeanUtils.copyProperties(dado, optDado, "id");
            result = dadoRepository.save(optDado.get());
        }
        return result;
    }
}
