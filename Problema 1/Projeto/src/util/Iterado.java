package util;

public class Iterado implements Iterador{

	private No inicio;
	private int pulos =0;
	
	public Iterado(No inicio){
		this.inicio = inicio;
	}
	@Override
	public boolean temProximo() {
		return inicio != null;
	}

	@Override
	public Object obterProximo() {
		if(temProximo()){
			Object objeto = inicio.getObjeto();
			inicio = inicio.getProximo();
			pulos++;
			return objeto;
		}
		return null;
	}
	public int getPulos(){
		return pulos;
	}
	public void setObjetoAtual(Object objeto){
		inicio.setObjeto(objeto);
	}
	
}
