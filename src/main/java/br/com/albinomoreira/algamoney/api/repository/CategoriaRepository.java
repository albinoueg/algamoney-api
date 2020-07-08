package br.com.albinomoreira.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.albinomoreira.algamoney.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
