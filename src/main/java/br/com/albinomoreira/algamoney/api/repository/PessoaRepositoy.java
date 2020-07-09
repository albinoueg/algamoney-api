package br.com.albinomoreira.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.albinomoreira.algamoney.api.model.Pessoa;

public interface PessoaRepositoy extends JpaRepository<Pessoa, Long>{

}
