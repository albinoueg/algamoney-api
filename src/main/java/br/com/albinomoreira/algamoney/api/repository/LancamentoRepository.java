package br.com.albinomoreira.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.albinomoreira.algamoney.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
