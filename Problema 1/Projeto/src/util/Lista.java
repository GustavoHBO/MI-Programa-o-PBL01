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
	 * M�todo que retorna true se a lista estiver vazia e false se n�o.
	 * 
	 * @return true caso a lista esteja vazia, false caso a lista n�o esteja vazia.
	 */
	
	@Override
	public boolean estaVazia() {
		return inicio == null;// Verifica se o primeiro n� � nulo, se sim retorna true se n�o retorna false.
	}

	/**
	 * M�todo que retorna o tamanho da lista.
	 * @return int - Quantidade de n�s na lista.
	 */
	@Override
	public int obterTamanho() {
		return qCelulas;// Retorna a quantidade de n�s da lista.
	}

	/**
	 * M�todo que insere no inicio da lista.
	 * @param Object objeto.
	 */
	@Override
	public void inserirInicio(Object objeto) {
		No novo = new No(inicio, objeto);// Insere no inicio da lista e se o inicio for nulo faz o ultimo n� referenciar o primeiro.
		inicio = novo;
		if(qCelulas == 0){
			fim = inicio;
		}
		qCelulas++;
	}
	/**
	 * M�todo que recebe um objeto e o insere no fim da lista.
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
	 * M�todo que remove um objeto do inicio da lista e retorna o objeto removido, caso a lista esteja vazia retorna null.
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
	 * M�todo que remove um objeto do fim da lista e retorna o objeto removido, caso a lista esteja vazia retorna null.
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
	 * M�todo que remover um objeto na posi��o indicada na lista e retorna o objeto removido, caso a posi��o n�o exista retorna nulo.
	 * @param index - Posi��o da lista
	 * @return Object - Objeto removido, null - Caso a posi��o n�o exista.
	 */

	@Override
	public Object remover(int index) {
		Object objeto = null;
		if(index == 0){// Caso a posi��o seja a primeira, remove do inicio.
			objeto = removerInicio();
		}
		else if(index == qCelulas - 1){// Caso a posi��o seja a ultima, remove do fim.
			objeto = removerFinal();
		}
		else if(index > qCelulas - 1 || index < 0){// Caso a posi��o n�o exista retorna null.
			return null;
		}
		else{// Caso a posi��o exista, remove o n� respectivo e retorna o objeto do n�.
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
	 * M�todo que retorna um objeto do n� na posi��o passada, caso a posi��o n�o exista retorna null.
	 * @param int index - Posi��o na lista que deseja recuperar.
	 * @return Object objeto - Objeto da posi��o passada, null - Posi��o inexistente na lista.
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
			return null;// Retorna null caso a posi��o n�o exista.
		}
		else{
			for(cont = 0; cont <= index; cont++){
				objeto = it.obterProximo();
			}
			return objeto;// Retorna o objeto na posi��o indicada.
		}
	}

	/**
	 * Retorna o iterador da lista.
	 * @return Iterado iterador - Iterador da lista.
	 */
	@Override
	public Iterado iterador() {
		Iterado iterador = new Iterado(inicio);// Cria um iterador que tem como refer�ncia o inicio da lista. 
		return iterador;// Retorna o iterador criado.
	}

	/**
	 * M�todo que troca os objetos com os indices passados.
	 * @param index1
	 * @param index2
	 */
	public void swap(int index1, int index2){// Recebe as posi��es da lista que deseja trocar os objetos.
		No atual = inicio;
		No atual2 = inicio;
		int cont;
		Object obj;

		for(cont = 0; cont <index1; cont++){
			atual = atual.getProximo();// Identifica o n� que esta na posi��o index1;
		}
		for(cont = 0; cont <index2; cont++){
			atual2 = atual2.getProximo();// Identifica o n� que esta na posi��o index2;
		}
		obj = atual.getObjeto();// Guarda o objeto para n�o perder a refer�ncia.
		atual.setObjeto(atual2.getObjeto());// Troca o objeto do n� do �ndice index1 pelo de �ndice index2.
		atual2.setObjeto(obj);// Pega o objeto guardado e coloca no n� da posi��o index2.
	}

	/**
	 * M�todo que ordena a lista em forma decrescente, usando a interface Comparable para comparar.
	 * 
	 */

	public void ordenarLista(){

		Comparable objetoCompara, objetoCompara2; // Declara objetos do tipo Comparable, que possui o m�todo comparable.
		int cont = 0, cont2 = 0;

		if(estaVazia()){
			return;// Finaliza caso a lista esteja vazia.
		}
		for(cont = qCelulas - 1; cont > 0; cont--){
			for(cont2 = 0; cont2 < cont; cont2++){
				objetoCompara = (Comparable)recuperar(cont2);// Recupera o objeto do n� na posi��o cont2.
				objetoCompara2 = (Comparable)recuperar(cont2+1);// Recuperar o objeto do n� na posi��o cont2 + 1.
				if(objetoCompara.comparable(objetoCompara2) < 0){// Compara usando a interface, que compara a quantidade(double) dos objetos comparados.
					swap(cont2, cont2 + 1);// Utiliza o swap, para trocar a posi��o dos objetos.
				}
			}
		}
	}
}
