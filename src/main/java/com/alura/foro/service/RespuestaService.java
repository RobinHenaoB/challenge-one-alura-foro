package com.alura.foro.service;


import com.alura.foro.domain.dto.*;
import com.alura.foro.domain.modelo.Respuesta;
import com.alura.foro.repository.RespuestaRepository;
import com.alura.foro.repository.TopicoRepository;
import com.alura.foro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespuestaService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    RespuestaRepository respuestaRepository;

    public Page<DataListRespuesta> getAllRespuesta(Pageable pageable){
        var page = respuestaRepository.findByActivoTrue(pageable).map(DataListRespuesta::new);
        return page;
    }

    public DataResponseRespuesta postRespuesta(DataPostRespuesta dataPostRespuesta) {
        var topico = topicoRepository.findById(dataPostRespuesta.topico()).get();
        var author = usuarioRepository.findById(dataPostRespuesta.author()).get();
        var response = new Respuesta(dataPostRespuesta.mensaje(),topico, LocalDateTime.now(), author);
        respuestaRepository.save(response);
        return new DataResponseRespuesta(response);
    }

    public DataResponseRespuesta updateRespuesta(DataUpdateRespuesta dataUpdateRespuesta) {
        var response = respuestaRepository.getReferenceById(dataUpdateRespuesta.id());
        response.updateRespuesta(dataUpdateRespuesta.mensaje());
        return new DataResponseRespuesta(response);
    }

    public void deleteRespuesta(Long id) {
        var response = respuestaRepository.getReferenceById(id);
        response.deleteRespuesta();
    }

}
