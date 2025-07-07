package br.gov.fatec.itu.gerenciador_contatos_back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.fatec.itu.gerenciador_contatos_back.entities.Contato;
import br.gov.fatec.itu.gerenciador_contatos_back.repositories.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<Contato> getAll() {
        return repository.findAll();
    }

    public Optional<Contato> getById(long id) {
        return repository.findById(id);
    }

    public Contato save(Contato contato) {
        return repository.save(contato);
    }

    public Contato update(Contato contato, long id) {
        Contato aux = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contato não encontrado"));

        aux.setNomeCompleto(contato.getNomeCompleto());
        aux.setTelefone(contato.getTelefone());
        aux.setEmail(contato.getEmail());
        aux.setEndereco(contato.getEndereco());
        aux.setDataNascimento(contato.getDataNascimento());
        aux.setCategoria(contato.getCategoria());
        aux.setApelido(contato.getApelido());
        aux.setCidade(contato.getCidade());
        aux.setEmpresa(contato.getEmpresa());
        aux.setSite(contato.getSite());
        aux.setNotasAdicionais(contato.getNotasAdicionais());
        aux.setContatofavorito(contato.getContatofavorito());

        return repository.save(aux);
    }

    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }
}
