package model;

import java.util.Date;
import util.Comparable;

/**
 * Classe Doacoes.
 * @author Gustavo Henrique
 * @since 16 de dezembro de 2016.
 */

public class Doacoes implements Comparable {

	private Doador doador;
	private Produto produto;
	private Date dt_doacao;
	private Number quantidade;
	private final int id;
	private boolean tipo;
	private static int idd = 1;// Contador, determina a id de cada doação criada.

	/**
	 * Construtor - Cria um objeto do tipo Doacoes.
	 * @param doador
	 * @param produto
	 * @param quantidade
	 * @param dt_doacao
	 */
	public Doacoes(Doador doador, Produto produto, Number quantidade, Date dt_doacao){// Cria um objeto com as seguintes informações
		this.doador = doador;// Determina o doador.
		this.produto = produto;// Determina o produto.
		this.quantidade = quantidade;// Determina a quantidade.
		this.dt_doacao = dt_doacao;// Determina a data de doação.
		this.id = idd++;// Determina a id de cadastro.
	}

	/**
	 * Método implementado da interface Comparable. Compara os atributos quantidade e retorna 1 caso o objeto recebido seja menor que o atual, retorna 0 caso
	 * os valores sejam iguais e retorna -1 caso o atual seja menor que o recebido.
	 * @param Object - objeto.
	 * @return 1 - Caso o atual seja maior que o recebido, -1 - Caso o atual seja menor que o recebido, 0 - Caso o atual seja igual ao recebido.
	 */
	public int comparable(Object object){

		Doacoes doacao = (Doacoes)object;
		if((double)doacao.getQuantidade() < (double)quantidade){
			return 1;// Retorna 1 caso o atual seja maior que o recebido.
		}
		else if((double)doacao.getQuantidade() > (double)quantidade){
			return -1;// Retorna -1 caso o atual seja menor que o recebido.
		}
		else{
			return 0;// Retorna 0 caso o atual seja igual ao recebido.
		}
	}

	/**
	 * Método que retorna o doador.
	 * @return Doador.
	 */
	public Doador getDoador() {
		return doador;// Retorna o doador.
	}

	/**
	 * Método que altera o doador pelo recebido.
	 * @param Doador doador.
	 */
	public void setDoador(Doador doador) {
		this.doador = doador;// Altera o doador.
	}

	/**
	 * Método que retorna o produto.
	 * @return Doador.
	 */
	public Produto getProduto() {
		return produto;// Retorna o produto.
	}

	/**
	 * Método que altera o produto.
	 * @param Produto produto
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;// Altera o produto.
	}

	/**
	 * Método que altera a data.
	 * @param Date data.
	 */
	public void setData(Date data) {
		this.dt_doacao = data;// Altera a data.
	}

	/**
	 * Método que retorna a quantidade de doações.
	 * @return Number quantidade.
	 */
	public Number getQuantidade() {
		return quantidade;// Retorna a quantidade de doações.
	}

	/**
	 * Método que altera a quantidade de doações.
	 * @param double quantidade.
	 */
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;// Altera a quantidade de doações.
	}

	/**
	 * Método que retorna a id da doação.
	 * @return int id.
	 */
	public int getId() {
		return id;// Retorna a id da doação.
	}
	/**
	 * Retorna o tipo da doação, true para monetário ou false para não monetário.
	 * @return boolean
	 */
	public boolean isTipo() {
		return tipo;// Retorna o tipo da doação.
	}

	/**
	 * Altera o tipo de doação, true para monetário ou false para não monetário.
	 * @param boolean tipo.
	 */
	public void setTipo(boolean tipo) {
		this.tipo = tipo;// Altera o tipo da doação.
	}
}
