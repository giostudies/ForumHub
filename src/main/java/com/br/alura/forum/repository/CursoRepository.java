package com.br.alura.forum.repository;

import com.br.alura.forum.modelo.Curso;

public interface CursoRepository {
    Curso findByNome(String nomeCurso);
}
