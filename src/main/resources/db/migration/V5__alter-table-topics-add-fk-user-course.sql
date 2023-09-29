ALTER TABLE topicos ADD CONSTRAINT fk_topicos_usuario_id FOREIGN KEY(author) REFERENCES usuarios(id);
ALTER TABLE topicos ADD CONSTRAINT fk_topicos_curso_id FOREIGN KEY(curso) REFERENCES cursos(id);