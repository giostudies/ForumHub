package com.br.alura.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.repository.TopicoRepository;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> findAll() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> findById(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico save(Topico topico) {
        return topicoRepository.save(topico);
    }

    public void deleteById(Long id) {
        topicoRepository.deleteById(id);
    }
}
