package com.alura.foro.domain.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Table(name="respuestas")
@Entity(name= "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topico")
	private Topico topico;

	private LocalDateTime fechaCreacion = LocalDateTime.now();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author")
	private Usuario author;

	private Boolean solucion = false;
	private Boolean activo;

	public Respuesta(String mensaje, Topico topico, LocalDateTime fechaCreacion, Usuario author) {
		this.mensaje = mensaje;
		this.topico = topico;
		this.fechaCreacion = fechaCreacion;
		this.author = author;
		this.solucion = true;
		this.activo = true;
	}

	public void updateRespuesta(String mensaje) {
		if (mensaje != null) {
			this.mensaje = mensaje;
		}
	}

	public void deleteRespuesta() {
		this.activo = false;
	}
}
