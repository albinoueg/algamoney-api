package br.com.albinomoreira.algamoney.api.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.albinomoreira.algamoney.api.event.RecursoCriadoEvent;
import br.com.albinomoreira.algamoney.api.exceptionhandler.ErrorMessages;
import br.com.albinomoreira.algamoney.api.model.Lancamento;
import br.com.albinomoreira.algamoney.api.repository.LancamentoRepository;
import br.com.albinomoreira.algamoney.api.repository.filter.LancamentoFilter;
import br.com.albinomoreira.algamoney.api.service.LancamentoService;
import br.com.albinomoreira.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private LancamentoService LancamentoService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping
	public List<Lancamento> pesquisar(LancamentoFilter lancamentoFilter){
		return lancamentoRepository.filtrar(lancamentoFilter);
		
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> findById(@PathVariable Long codigo){
		
		return lancamentoRepository.findById(codigo)
		.map(lancamento -> ResponseEntity.ok(lancamento))
		.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public ResponseEntity<Lancamento> salvar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response){
		Lancamento lancamentoSalvo = LancamentoService.save(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	@ExceptionHandler({ PessoaInexistenteOuInativaException.class })
	public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex){
		
		String mensagemUsuario = messageSource.getMessage("pessoa.inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = Optional.ofNullable(ex.getCause()).orElse(ex).toString();
		
		List<ErrorMessages> erros = Arrays.asList(new ErrorMessages(mensagemUsuario, mensagemDesenvolvedor));
		
		return ResponseEntity.badRequest().body(erros);
	}

}
