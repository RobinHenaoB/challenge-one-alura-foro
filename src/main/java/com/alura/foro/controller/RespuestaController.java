package com.alura.foro.controller;


import com.alura.foro.domain.dto.DataListRespuesta;
import com.alura.foro.domain.dto.DataListTopico;
import com.alura.foro.domain.dto.DataPostRespuesta;
import com.alura.foro.domain.dto.DataUpdateRespuesta;
import com.alura.foro.service.RespuestaService;
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
@RequestMapping("/respuestas")
public class RespuestaController {
    @Autowired
    private RespuestaService respuestaService;

    @PostMapping
    @Transactional
    @Operation(
            summary = "Registra una nueva respuesta",
            tags = {"respuesta", "post"}
    )
    public ResponseEntity postRespuesta(@RequestBody @Valid DataPostRespuesta dataPostRespuesta) {
        var response = respuestaService.postRespuesta(dataPostRespuesta);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(
            summary = "ver todos las respuestas activos",
            tags = {"respuesta", "get"}
    )
    public ResponseEntity<Page<DataListRespuesta>> getAllTopico(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var response = respuestaService.getAllRespuesta(pageable);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    @Operation(
            summary = "Actualiza datos de la respuesta",
            tags = {"respuesta", "put"}
    )
    public ResponseEntity updateRespuesta(@RequestBody @Valid DataUpdateRespuesta dataUpdateRespuesta) {
        var response = respuestaService.updateRespuesta(dataUpdateRespuesta);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(
            summary = "Eliminar una respuesta",
            tags = {"respuesta", "delete"}
    )
    public ResponseEntity deleteRespuesta(@PathVariable @Min(1) Long id) {
        respuestaService.deleteRespuesta(id);
        return ResponseEntity.noContent().build();
    }
}
