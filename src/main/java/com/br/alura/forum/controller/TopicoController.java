package com.br.alura.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.service.TopicoService;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> listar() {
        return topicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> buscarPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoService.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(topico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Topico> criar(@RequestBody Topico topico) {
        Topico novoTopico = topicoService.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTopico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizar(@PathVariable Long id, @RequestBody Topico topicoAtualizado) {
        Optional<Topico> topico = topicoService.findById(id);
        if (topico.isPresent()) {
            topicoAtualizado.setId(id);
            topicoService.save(topicoAtualizado);
            return ResponseEntity.ok(topicoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Topico> topico = topicoService.findById(id);
        if (topico.isPresent()) {
            topicoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
