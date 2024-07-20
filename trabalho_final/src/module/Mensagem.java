package module;

import java.io.Serializable;

public class Mensagem implements Serializable {
	private String mensagem;
	
	
	public String toString() {
		return mensagem;
	}


	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
