package br.com.albinomoreira.algamoney.api.exceptionhandler;

public class ErrorMessages {

	private String mensagemUsuario;
	private String mensagemDesenvolvedor;
	
	public ErrorMessages(String mensagemUsuario, String mensagemDesenvolvedor) {
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
}
