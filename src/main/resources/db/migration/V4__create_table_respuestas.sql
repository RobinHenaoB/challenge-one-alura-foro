CREATE TABLE respuestas(
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje VARCHAR(500) NOT NULL,
    topico BIGINT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    author VARCHAR(100) NOT NULL,
    solucion TINYINT NOT NULL,
    activo TINYINT NOT NULL,

  PRIMARY KEY (id)
 );