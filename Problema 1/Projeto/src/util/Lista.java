package util;
/**
 * @since 16 de dezembro de 2015
 * @author Gustavo Henrique
 *
 */
public class Lista implements ILista {// Lista encadeada, implementa a interface ILista.

	private No inicio;
	private No fim;
	int qCelulas = 0;
	
	/**
	 * Método que retorna true se a lista estiver vazia e false se não.
	 * 
	 * @return true caso a lista esteja vazia, false caso a lista não esteja vazia.
	 */
	
	@Override
	public boolean estaVazia() {
		return inicio == null;// Verifica se o primeiro nó é nulo, se sim retorna true se não retorna false.
	}

	/**
	 * Método que retorna o tamanho da lista.
	 * @return int - Quantidade de nós na lista.
	 */
	@Override
	public int obterTamanho() {
		return qCelulas;// Retorna a quantidade de nós da lista.
	}

	/**
	 * Método que insere no inicio da lista.
	 * @param Object objeto.
	 */
	@Override
	public void inserirInicio(Object objeto) {
		No novo = new No(inicio, objeto);// Insere no inicio da lista e se o inicio for nulo faz o ultimo nó referenciar o primeiro.
		inicio = novo;
		if(qCelulas == 0){
			fim = inicio;
		}
		qCelulas++;
	}
	/**
	 * Método que recebe um objeto e o insere no fim da lista.
	 * @param Object objeto.
	 */
	@Override
	public void inserirFinal(Object objeto) {
		if(qCelulas == 0){
			inserirInicio(objeto);
		}
		else{
			No novo = new No(objeto);
			fim.setProximo(novo);
			fim = novo;
			fim.setProximo(null);
			qCelulas++;
		}
	}
	/**
	 * Método que remove um objeto do inicio da lista e retorna o objeto removido, caso a lista esteja vazia retorna null.
	 * @return Object - Retorna o objeto removido, null - caso a lista esteja vazia.
	 */

	@Override
	public Object removerInicio() {// Remove um objeto do inicio da lista.
		if(estaVazia()){
			return null;// Retorna nulo caso a lista esteja vazia.
		}
		else{
			No remover = inicio;
			inicio = inicio.getProximo();
			qCelulas--;
			if(qCelulas == 0)
				fim = null;
			return remover;// Retorna o objeto removido.
		}
	}
	/**
	 * Método que remove um objeto do fim da lista e retorna o objeto removido, caso a lista esteja vazia retorna null.
	 * @return Object - Retorna o objeto removido, null - Caso a lista esteja vazia.
	 */

	@Override
	public Object removerFinal() {
		Object objeto;
		if(estaVazia()){
			objeto = null;
		}
		if(qCelulas == 1){
			objeto = removerInicio();
		}
		else{
			No penultima = inicio;
			for(int i = 0; i < qCelulas - 2; i++){
				penultima = penultima.getProximo();
			}
			objeto = fim.getObjeto();
			penultima.setProximo(null);
			fim = penultima;
			qCelulas--;
		}
		return objeto;
	}
	/**
	 * Método que remover um objeto na posição indicada na lista e retorna o objeto removido, caso a posição não exista retorna nulo.
	 * @param index - Posição da lista
	 * @return Object - Objeto removido, null - Caso a posição não exista.
	 */

	@Override
	public Object remover(int index) {
		Object objeto = null;
		if(index == 0){// Caso a posição seja a primeira, remove do inicio.
			objeto = removerInicio();
		}
		else if(index == qCelulas - 1){// Caso a posição seja a ultima, remove do fim.
			objeto = removerFinal();
		}
		else if(index > qCelulas - 1 || index < 0){// Caso a posição não exista retorna null.
			return null;
		}
		else{// Caso a posição exista, remove o nó respectivo e retorna o objeto do nó.
			int posicao = 0;
			No remover, anterior;
			remover = anterior = inicio;
			while(posicao != index){
				anterior = remover;
				remover = remover.getProximo();
				posicao++;
			}
			anterior.setProximo(remover.getProximo());
			qCelulas--;
			objeto = remover.getObjeto();
		}
		return objeto;
	}
	/**
	 * Método que retorna um objeto do nó na posição passada, caso a posição não exista retorna null.
	 * @param int index - Posição na lista que deseja recuperar.
	 * @return Object objeto - Objeto da posição passada, null - Posição inexistente na lista.
	 */

	@Override
	public Object recuperar(int index) {
		Object objeto = null;
		Iterado it = new Iterado(inicio);
		int cont = 0;

		if(estaVazia()){
			return null;// Retorna null caso a lista esteja vazia.
		}
		else if(index == 0){
			return inicio.getObjeto();// Retorna o objeto no inicio da lista.
		}
		else if(index == qCelulas - 1){
			return fim.getObjeto();// Retorna o objeto do fim da lista.
		}
		else if(index > qCelulas - 1 || index < 0){
			return null;// Retorna null caso a posição não exista.
		}
		else{
			for(cont = 0; cont <= index; cont++){
				objeto = it.obterProximo();
			}
			return objeto;// Retorna o objeto na posição indicada.
		}
	}

	/**
	 * Retorna o iterador da lista.
	 * @return Iterado iterador - Iterador da lista.
	 */
	@Override
	public Iterado iterador() {
		Iterado iterador = new Iterado(inicio);// Cria um iterador que tem como referência o inicio da lista. 
		return iterador;// Retorna o iterador criado.
	}

	/**
	 * Método que troca os objetos com os indices passados.
	 * @param index1
	 * @param index2
	 */
	public void swap(int index1, int index2){// Recebe as posições da lista que deseja trocar os objetos.
		No atual = inicio;
		No atual2 = inicio;
		int cont;
		Object obj;

		for(cont = 0; cont <index1; cont++){
			atual = atual.getProximo();// Identifica o nó que esta na posição index1;
		}
		for(cont = 0; cont <index2; cont++){
			atual2 = atual2.getProximo();// Identifica o nó que esta na posição index2;
		}
		obj = atual.getObjeto();// Guarda o objeto para não perder a referência.
		atual.setObjeto(atual2.getObjeto());// Troca o objeto do nó do índice index1 pelo de índice index2.
		atual2.setObjeto(obj);// Pega o objeto guardado e coloca no nó da posição index2.
	}

	/**
	 * Método que ordena a lista em forma decrescente, usando a interface Comparable para comparar.
	 * 
	 */

	public void ordenarLista(){

		Comparable objetoCompara, objetoCompara2; // Declara objetos do tipo Comparable, que possui o método comparable.
		int cont = 0, cont2 = 0;

		if(estaVazia()){
			return;// Finaliza caso a lista esteja vazia.
		}
		for(cont = qCelulas - 1; cont > 0; cont--){
			for(cont2 = 0; cont2 < cont; cont2++){
				objetoCompara = (Comparable)recuperar(cont2);// Recupera o objeto do nó na posição cont2.
				objetoCompara2 = (Comparable)recuperar(cont2+1);// Recuperar o objeto do nó na posição cont2 + 1.
				if(objetoCompara.comparable(objetoCompara2) < 0){// Compara usando a interface, que compara a quantidade(double) dos objetos comparados.
					swap(cont2, cont2 + 1);// Utiliza o swap, para trocar a posição dos objetos.
				}
			}
		}
	}
}
