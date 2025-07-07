package br.gov.fatec.itu.gerenciador_contatos_back.controllers;

import java.lang.reflect.AccessFlag.Location;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.itu.gerenciador_contatos_back.entities.Contato;
import br.gov.fatec.itu.gerenciador_contatos_back.services.ContatoService;

@CrossOrigin
@RestController
@RequestMapping("contatos")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @GetMapping
    public ResponseEntity<List<Contato>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Contato> getById(@PathVariable long id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Contato> save(@RequestBody Contato contato) {
        if (contato.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Contato salvo = service.save(contato);
        URI location = URI.create("/contatos/" + salvo.getId());
        return ResponseEntity.created(location).body(salvo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Contato> update(@PathVariable long id, @RequestBody Contato contato) {
        Contato atualizado = service.update(contato, id);
        return ResponseEntity.ok(atualizado);
    }

}
