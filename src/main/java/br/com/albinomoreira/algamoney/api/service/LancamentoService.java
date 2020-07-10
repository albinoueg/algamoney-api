package br.com.albinomoreira.algamoney.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.albinomoreira.algamoney.api.model.Lancamento;
import br.com.albinomoreira.algamoney.api.model.Pessoa;
import br.com.albinomoreira.algamoney.api.repository.LancamentoRepository;
import br.com.albinomoreira.algamoney.api.repository.PessoaRepositoy;
import br.com.albinomoreira.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepositoy pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento save(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo())
				.orElseThrow(() -> new PessoaInexistenteOuInativaException());
		if(pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
		return lancamentoRepository.save(lancamento);
	}
}
