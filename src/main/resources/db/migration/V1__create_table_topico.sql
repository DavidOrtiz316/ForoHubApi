CREATE TABLE topico (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensaje VARCHAR(1000) NOT NULL,
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) DEFAULT "activo",
    autor_id INT,
    curso_id INT,
    respuesta_id INT,
    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (curso_id) REFERENCES curso(id),
    FOREIGN KEY (respuesta_id) REFERENCES respuesta(id)
);