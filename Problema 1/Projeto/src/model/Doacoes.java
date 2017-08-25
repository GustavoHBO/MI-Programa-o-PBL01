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
	private static int idd = 1;// Contador, determina a id de cada doa��o criada.

	/**
	 * Construtor - Cria um objeto do tipo Doacoes.
	 * @param doador
	 * @param produto
	 * @param quantidade
	 * @param dt_doacao
	 */
	public Doacoes(Doador doador, Produto produto, Number quantidade, Date dt_doacao){// Cria um objeto com as seguintes informa��es
		this.doador = doador;// Determina o doador.
		this.produto = produto;// Determina o produto.
		this.quantidade = quantidade;// Determina a quantidade.
		this.dt_doacao = dt_doacao;// Determina a data de doa��o.
		this.id = idd++;// Determina a id de cadastro.
	}

	/**
	 * M�todo implementado da interface Comparable. Compara os atributos quantidade e retorna 1 caso o objeto recebido seja menor que o atual, retorna 0 caso
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
	 * M�todo que retorna o doador.
	 * @return Doador.
	 */
	public Doador getDoador() {
		return doador;// Retorna o doador.
	}

	/**
	 * M�todo que altera o doador pelo recebido.
	 * @param Doador doador.
	 */
	public void setDoador(Doador doador) {
		this.doador = doador;// Altera o doador.
	}

	/**
	 * M�todo que retorna o produto.
	 * @return Doador.
	 */
	public Produto getProduto() {
		return produto;// Retorna o produto.
	}

	/**
	 * M�todo que altera o produto.
	 * @param Produto produto
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;// Altera o produto.
	}

	/**
	 * M�todo que altera a data.
	 * @param Date data.
	 */
	public void setData(Date data) {
		this.dt_doacao = data;// Altera a data.
	}

	/**
	 * M�todo que retorna a quantidade de doa��es.
	 * @return Number quantidade.
	 */
	public Number getQuantidade() {
		return quantidade;// Retorna a quantidade de doa��es.
	}

	/**
	 * M�todo que altera a quantidade de doa��es.
	 * @param double quantidade.
	 */
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;// Altera a quantidade de doa��es.
	}

	/**
	 * M�todo que retorna a id da doa��o.
	 * @return int id.
	 */
	public int getId() {
		return id;// Retorna a id da doa��o.
	}
	/**
	 * Retorna o tipo da doa��o, true para monet�rio ou false para n�o monet�rio.
	 * @return boolean
	 */
	public boolean isTipo() {
		return tipo;// Retorna o tipo da doa��o.
	}

	/**
	 * Altera o tipo de doa��o, true para monet�rio ou false para n�o monet�rio.
	 * @param boolean tipo.
	 */
	public void setTipo(boolean tipo) {
		this.tipo = tipo;// Altera o tipo da doa��o.
	}
}
