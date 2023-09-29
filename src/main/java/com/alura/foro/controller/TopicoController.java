package com.alura.foro.controller;


import com.alura.foro.domain.dto.DataPostTopico;
import com.alura.foro.domain.dto.DataUpdateTopico;
import com.alura.foro.service.TopicoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    @Operation(
            summary="Guarda un nuevo topico",
            tags={"topic","post"}
    )
    public ResponseEntity postTopico(@RequestBody @Valid DataPostTopico dataPostTopico){
        var response =topicoService.postTopico(dataPostTopico);
        return  ResponseEntity.ok(response);
    }


    public void getAllTopico(){

    }

    public void getIdTopico(){

    }

    @PutMapping
    @Transactional
    @Operation(
            summary = "Actualiza los datos de topico",
            tags = {"topic", "put"}
    )
    public ResponseEntity updateTopico(@RequestBody @Valid DataUpdateTopico dataUpdateTopico){
        var response = topicoService.updateTopico(dataUpdateTopico);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(
            summary = "Elimina un topico",
            tags = {"topic", "delete"}
    )
    public ResponseEntity deleteTopico(@PathVariable @Min(1) Long id){
        topicoService.deleteTopico(id);
        return ResponseEntity.noContent().build();
    }






}
