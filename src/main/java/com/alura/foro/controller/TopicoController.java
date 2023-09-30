package com.alura.foro.controller;


import com.alura.foro.domain.dto.DataListTopico;
import com.alura.foro.domain.dto.DataPostTopico;
import com.alura.foro.domain.dto.DataUpdateTopico;
import com.alura.foro.repository.RespuestaRepository;
import com.alura.foro.repository.TopicoRepository;
import com.alura.foro.service.TopicoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;
    @Autowired
    private TopicoRepository topicRepository;
    @Autowired
    private RespuestaRepository responseRepository;

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

    @GetMapping
    @Operation(
            summary = "ver todos los topicos activos",
            tags = {"topic", "get"}
    )
    public ResponseEntity<Page<DataListTopico>> getAllTopico(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var response = topicoService.getAllTopico(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "ver un topico y sus respuestas asociadas",
            tags = {"topic", "get"}
    )
    public ResponseEntity<Object> getIdTopico(@PathVariable @Min(1) Long id){
        var respuesta = topicoService.getIdTopico(id);
        return ResponseEntity.ok(respuesta);
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
