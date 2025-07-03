package br.gov.fatec.itu.gerenciador_contatos_back.services;

import java.util.List;

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

    public Contato save(Contato contato) {
        return repository.save(contato);
    }

    public void update(Contato contato, long id) {
        Contato aux = repository.getReferenceById(id);

        aux.setNomeCompleto(contato.getNomeCompleto());
        aux.setTelefone(contato.getTelefone());
        aux.setEmail(contato.getEmail());
        aux.setEndereco(contato.getEndereco());
        aux.setDataNascimento(contato.getDataNascimento());
        aux.setCategoria(contato.getCategoria());
        aux.setApelido(contato.getApelido());
        aux.setCidade(contato.getCidade());
        aux.setEmpresa(contato.getEmpresa());
        aux.setNotasAdicionais(contato.getNotasAdicionais());
        aux.setContatofavorito(contato.getContatofavorito());

        repository.save(aux);
    }    

    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }
}
