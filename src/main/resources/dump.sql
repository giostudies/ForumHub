-- Criação do banco de dados
CREATE DATABASE forumhub;

-- Seleção do banco de dados
USE forumhub;

-- Criação da tabela 'usuarios'
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- Criação da tabela 'cursos'
CREATE TABLE cursos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

-- Criação da tabela 'topicos'
CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('NAO_RESPONDIDO', 'NAO_SOLUCIONADO', 'SOLUCIONADO', 'FECHADO') DEFAULT 'NAO_RESPONDIDO',
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

-- Criação da tabela 'respostas'
CREATE TABLE respostas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autor_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,
    solucao BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    FOREIGN KEY (topico_id) REFERENCES topicos(id)
);
