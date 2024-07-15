package com.br.alura.forum.dto;


import com.br.alura.forum.modelo.Curso;
import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.repository.CursoRepository;

public class TopicoForm {

    private String titulo;
    private String mensagem;
    private String nomeCurso;

    // Getters and setters

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
