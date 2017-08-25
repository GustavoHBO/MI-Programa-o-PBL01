package util;

public class No {
	
	private Object objeto;
	private No proximo;
	
	public No(No proximo, Object objeto){
		this.proximo= proximo;
		this.objeto = objeto;
	}
	
	public No(Object objeto){
		this.objeto = objeto;
	}
	
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	public Object getObjeto() {
		return objeto;
	}
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
}
