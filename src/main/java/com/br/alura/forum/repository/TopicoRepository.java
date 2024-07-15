package com.br.alura.forum.repository;

import com.br.alura.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
