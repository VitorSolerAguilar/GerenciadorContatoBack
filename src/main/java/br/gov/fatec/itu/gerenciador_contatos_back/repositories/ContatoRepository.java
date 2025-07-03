package br.gov.fatec.itu.gerenciador_contatos_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.itu.gerenciador_contatos_back.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
    
}
