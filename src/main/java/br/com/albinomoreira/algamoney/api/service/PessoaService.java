package br.com.albinomoreira.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.albinomoreira.algamoney.api.model.Pessoa;
import br.com.albinomoreira.algamoney.api.repository.PessoaRepositoy;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepositoy pessoaRepositoy;

	public Pessoa atualizar(Pessoa pessoa, long codigo) {
		Pessoa pessoaSalva = pessoaRepositoy.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		
		return pessoaRepositoy.save(pessoaSalva);
	}
	
	public void atualizarStatus(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = pessoaRepositoy.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		pessoaSalva.setAtivo(ativo);
		pessoaRepositoy.save(pessoaSalva);
	}
}
