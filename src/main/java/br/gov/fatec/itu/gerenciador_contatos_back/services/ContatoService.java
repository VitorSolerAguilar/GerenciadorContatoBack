package br.gov.fatec.itu.gerenciador_contatos_back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.fatec.itu.gerenciador_contatos_back.entities.Contato;
import br.gov.fatec.itu.gerenciador_contatos_back.repositories.ContatoRepository;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository repository;

    public List<Contato> getAll(){
        return repository.findAll();
    }
    
    public Contato save(Contato contato){
        return repository.save(contato);
    }

}
