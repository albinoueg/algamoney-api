package br.com.albinomoreira.algamoney.api.config.property;

public class Seguranca {

	private boolean enableHttps;
	private String origemPermitida = "http://localhost:8000";

	public boolean isEnableHttps() {
		return enableHttps;
	}

	public void setEnableHttps(boolean enableHttps) {
		this.enableHttps = enableHttps;
	}

	public String getOrigemPermitida() {
		return origemPermitida;
	}

	public void setOrigemPermitida(String origemPermitida) {
		this.origemPermitida = origemPermitida;
	}
		
}
