package br.com.eyHerois.model;

public class ResponseModel {
	public ResponseModel() {}
	
	public ResponseModel(int codigo, String message) {
		this.codigo = codigo;
		this.message = message;
	}
	
	private int codigo;
	private String message;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
