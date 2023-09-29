package com.alura.foro.service;


import com.alura.foro.domain.dto.DataPostTopico;
import com.alura.foro.domain.dto.DataResponseTopico;
import com.alura.foro.domain.dto.DataUpdateTopico;
import com.alura.foro.domain.modelo.Topico;
import com.alura.foro.infra.errors.ValidacionDeIntegridad;
import com.alura.foro.repository.CursoRepository;
import com.alura.foro.repository.TopicoRepository;
import com.alura.foro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicoService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    public DataResponseTopico postTopico(DataPostTopico dataPostTopico){

        if(dataPostTopico.author()!=null && !usuarioRepository.existsById(dataPostTopico.author())){
            throw new ValidacionDeIntegridad("este id para el usuario no fue encontrado");
        }
        if(dataPostTopico.curso()!=null && !usuarioRepository.existsById(dataPostTopico.curso())){
            throw new ValidacionDeIntegridad("este id para el curso no fue encontrado");
        }

        var author = usuarioRepository.findById(dataPostTopico.author()).get();
        var course = cursoRepository.findById(dataPostTopico.curso()).get();
        topicoRepository.existsByTituloAndMensaje(dataPostTopico.titulo(), dataPostTopico.mensaje());
        var topico = new Topico(dataPostTopico.titulo(), dataPostTopico.mensaje(), LocalDateTime.now(), author, course);
        topicoRepository.save(topico);

        return new DataResponseTopico(topico);
    }
    public void getAllTopico(){

    }
    public void getIdTopico(){

    }
    public void deleteTopico(Long id){
        if (!topicoRepository.findById(id).isPresent()) {
            throw new ValidacionDeIntegridad("El topico no se encontro en la base de datos");
        }
        var topic = topicoRepository.getReferenceById(id);
        topic.deleteTopico();
    }

    public DataResponseTopico updateTopico(DataUpdateTopico dataUpdateTopico){
        if(dataUpdateTopico.curso()!=null && !usuarioRepository.existsById(dataUpdateTopico.curso())){
            throw new ValidacionDeIntegridad("este id para el curso no fue encontrado");
        }
        var topico = topicoRepository.getReferenceById(dataUpdateTopico.id());
        var curso= cursoRepository.findById(dataUpdateTopico.curso()).get();
        topico.updateTopico(dataUpdateTopico.titulo(), dataUpdateTopico.mensaje(), dataUpdateTopico.statusTopico(), curso);
        return new DataResponseTopico(topico);
    }


}
