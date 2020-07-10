package br.com.albinomoreira.algamoney.api.repository.lancamento;

import java.util.List;

import br.com.albinomoreira.algamoney.api.model.Lancamento;
import br.com.albinomoreira.algamoney.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
