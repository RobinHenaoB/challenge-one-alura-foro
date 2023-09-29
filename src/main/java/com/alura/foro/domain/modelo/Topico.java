package com.alura.foro.domain.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Table(name="topicos")
@Entity(name= "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion;

	@Column(name = "estatus")
	@Enumerated(EnumType.STRING)
	private StatusTopico statusTopico;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "author")
	private Usuario author;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso")
	private Curso curso;

	@OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
	private List<Respuesta> respuestas = new ArrayList<>();

	private Boolean activo;

	public Topico(String titulo, String mensaje, LocalDateTime fechaCreacion, Usuario author, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.fechaCreacion = fechaCreacion;
		this.statusTopico = StatusTopico.NO_RESPONDIDO;
		this.author = author;
		this.curso = curso;
		this.activo = true;
	}

	public void updateTopico(String titulo, String mensaje, StatusTopico statusTopico, Curso curso) {
		if (titulo != null) {
			this.titulo = titulo;
		}
		if (mensaje != null) {
			this.mensaje = mensaje;
		}
		if(statusTopico != null) {
			this.statusTopico = statusTopico;
		}
		if(curso != null) {
			this.curso = curso;
		}
	}

	public void deleteTopico() {
		this.activo = false;
	}


}
