package controller;

import java.util.Date;

import model.Doacoes;
import model.Doador;
import model.Produto;
import util.Iterado;
import util.Iterador;
import util.Lista;

public class Controller {

	private Lista listaDoacoes = new Lista();
	private Lista listaDoadores = new Lista();
	private Lista listaProdutos = new Lista();

	private Iterado iterar;


	public Controller(){

	}
	/*
	 * Método que recebe as informações do produto. Cria o produto com as informações dadas e adiciona na listaProdutos.
	 * 
	 * @param nome - nome do produto.
	 * @param tipo - tipo do produto.
	 * @param dt_criacao - data de criação.
	 * @return produto.
	 */
	public Produto cadastrarProduto(String nome, String tipo, Date dt_criacao){
		Produto produto = new Produto(nome, tipo, dt_criacao);// Cria um produto.
		listaProdutos.inserirInicio(produto);// Insere o objeto no inicio da lista.
		return produto;// Retorna o produto criado.
	}

	/**
	 * Recebe os seguintes parâmetros e retorna o produto editado com o mesmo idProduto passado, caso não exista retorna null.
	 * 
	 * @param idProduto - id do produto.
	 * @param nome - nome do produto.
	 * @param tipo - tipo do produto.
	 * @param dt_criacao - data da criação.
	 * @return produto
	 */

	public Produto editarProduto(Integer idProduto, String nome, String tipo, Date dt_criacao) {
		if(!(listaProdutos.estaVazia())){
			Produto produto;
			iterar = listaProdutos.iterador();
			while(iterar.temProximo()){
				produto = (Produto) iterar.obterProximo();
				if(produto.getId() == idProduto){
					produto.setData(dt_criacao);
					produto.setNome(nome);
					produto.setTipo(tipo);
					return produto;
				}
			}
		}
		return null;
	}

	/**
	 * Recebe um numero inteiro e retorna o produto com a id correspondente ao numero recebido, se não existir o produto retorna null.
	 * 
	 * @param id - id do produto.
	 * @return produto
	 */

	public Produto obterProduto(int id) {
		Produto produto = null;
		if(!(listaProdutos.estaVazia())){
			iterar = listaProdutos.iterador();
			while(iterar.temProximo()){
				produto = (Produto) iterar.obterProximo();
				if(produto.getId() == id){
					return produto;
				}
			}
		}
		return null;
	}

	/**
	 * Método que retorna o iterador da lista.
	 * @return Iterador.
	 */
	public Iterador listarProdutos(){
		return listaProdutos.iterador();// Retorna o iterador da lista.
	}

	/**
	 * Remove o produto que ainda não tenha sido doado na posição passada.
	 * @param Integer idProduto
	 * @return true - Caso o produto seja removido, false - Caso o produto não seja removido.
	 */
	public boolean removerProduto(Integer idProduto) {

		if(listaProdutos.estaVazia()){// Retorna false caso a lista esteja vazia.
			return false;
		}
		int posicao = 0;
		iterar = listaProdutos.iterador();// Pega o iterador da lista de produtos.
		if(iterar.temProximo()){
			Produto produto;
			while(iterar.temProximo()){
				produto = (Produto) iterar.obterProximo();
				if(produto.getId() == idProduto && produto.getqDoacoes() == 0){// Verifica se encontrou o doador e ver se tem alguma doação realizada.
					return listaProdutos.remover(posicao) != null;// Retorna o doador removido.
				}
				posicao++;// Incrementa posição.
			}
		}
		return false;// Return false caso não encontre o produto ou produto que ja tenha sido doado.
	}

	/**
	 * Método que cadastra um doador e o insere no inicio da lista.
	 * @param String numCadastro.
	 * @param String nome.
	 * @param Date dt_nascimento.
	 * @param String rua.
	 * @param int numero.
	 * @param String bairro.
	 * @param String cep.
	 * @param String cidade.
	 * @param String uf.
	 * @param String pais.
	 * @param String tipo.
	 * @return Doador doador - Retorna o objeto cadastrado.
	 */
	public Doador cadastrarDoador(String numCadastro, String nome, Date dt_nascimento, String rua, int numero, String bairro, String cep, String cidade, String uf, String pais, String tipo) {
		Doador doador = new Doador(numCadastro, nome, dt_nascimento, rua, numero, bairro, cep, cidade, uf, pais, tipo);
		if(obterDoador(numCadastro) == null){//Verifica se existe algum doador com o mesmo cpf/cnpj cadastrado.
			listaDoadores.inserirInicio(doador);// Insere o doador no inicio da lista.
			return doador;// Retorna o doador criado.
		}
		return null;// Retorna nulo caso exista um doador com mesmo cpf ou cnpj.
	}

	/**
	 * Método que edita o doador com o cpf/cnpj passado e retorna o doador caso exista ou nulo caso não.
	 * @param String numCadastro
	 * @param String nome
	 * @param Date dt_nascimento
	 * @param String rua
	 * @param int numero
	 * @param String bairro
	 * @param String cep
	 * @param String cidade
	 * @param String uf
	 * @param String pais
	 * @param String tipo
	 * @return Doador doador - Retorna o doador editado.
	 */
	public Doador editarDoador(String numCadastro, String nome, Date dt_nascimento, String rua, int numero, String bairro, String cep, String cidade, String uf, String pais, String tipo) {
		Doador doador = null;
		if(!(listaDoadores.estaVazia())){// Verifica se a lista esta vazia.
			iterar = listaDoadores.iterador();// Recebe o iterador da lista.
			while(iterar.temProximo()){
				doador = (Doador) iterar.obterProximo();// Obtem o doador.
				if(doador.getNumCadastro().equals(numCadastro)){// Verifica se o doador tem o mesmo numero de cadastro passado.
					doador.setNome(nome);// Altera o nome do doador.
					doador.setTipo(tipo);// Altera o tipo do doador.
					doador.setDate(dt_nascimento);// Altera a data de nascimento ou fundação do doador.
					doador.setEndereco(rua, numero, bairro, cep, cidade, uf, pais);// Altera o endereço do doador.
					return doador;// Retorna o doador alterado.
				}
			}
		}
		return doador;// Retorna um doador nulo caso não encontre o doador com o numero de cadastro passado.
	}

	/**
	 * Retorna o doador com o numero de cadastro, se não existir retorna nulo.
	 * @param String numCadastro
	 * @return Doador doador - Retorna o doador caso encontre, se não, retorna nulo.
	 */
	public Doador obterDoador(String numCadastro) {
		Doador doador = null;
		if(!(listaDoadores.estaVazia())){// Verifica se a lista esta vazia.
			iterar = listaDoadores.iterador();// Obtem o iterador da lista.
			while(iterar.temProximo()){
				doador = (Doador) iterar.obterProximo();// Obtem o doador.
				if(doador.getNumCadastro().equals(numCadastro)){// Verifica se o doador tem o mesmo número de cadastro.
					return doador;// Caso exista retorna o doador.
				}
			}
		}
		return null;//Retorna nulo caso não encontre.
	}

	/**
	 * Remove o doador com o numero de cadastro, caso exista remove e retorna true, se não, retorna false.
	 * @param String numCadastro
	 * @return true - Caso o doador seja removido, false - Caso o doador não seja encontrado.
	 */
	public boolean removerDoador(String numCadastro) {
		int posicao = 0;
		if(!(listaDoadores.estaVazia())){// Verifica se a lista está vazia.
			Doador doador;
			iterar = listaDoadores.iterador();// Obtem o iterador da lista.
			while(iterar.temProximo()){
				doador =  (Doador)iterar.obterProximo();// Obtem o doador.
				if(doador.getNumCadastro().equals(numCadastro) && doador.getQuantDoacoes() == 0){// Verifica se o doador possui o mesmo número de cadastro e verifica se existe alguma doação. 
					return listaDoadores.remover(posicao) != null;// Remove o doador e retorna true.
				}
				posicao++;
			}
		}
		return false;// Retorna false se não encontrar o doador.
	}	

	/**
	 * Método que retorna o iterador da lista listarDoadores.
	 * @return Iterado - Iterador da lista.
	 */
	public Iterado listarDoadores() {
		return listaDoadores.iterador();
	}

	/**
	 * Método que efetua uma doação, e retorna a doação criada.
	 * @param Doador doador
	 * @param Produto produto
	 * @param Number quantidade
	 * @param Date dt_doacao
	 * @return Doacoes doacao - Retorna a doação.
	 */
	/*
	 *	Renomeei a classe de Doacao para Doacoes, para poder usar a minha classe Doacoes.
	 */
	public Doacoes efetuarDoacao(Doador doador, Produto produto, Number quantidade, Date dt_doacao){
		Doacoes doacao = new Doacoes(doador, produto, quantidade, dt_doacao);// Cria uma doação com os parametros recebidos.
		doador.setQuantDoacoes(doador.getQuantDoacoes() + 1);// Adiciona uma doação ao doador.
		produto.setqDoacoes(produto.getqDoacoes() + 1);// Adiciona uma doação ao produto.
		if(produto.getTipo().equals("Monetária")){// Verifica se o produto é do tipo 'Monetário'.
			doacao.setTipo(true);// Altera o tipo da doação para true.
		}
		else{// Se não for 'Monetário'.
			doacao.setTipo(false);// Altera o tipo da doação para false.
		}
		listaDoacoes.inserirInicio(doacao);// Insere a doação no inicio da lista.
		return doacao;// Retorna a doação criada.
	}

	/**
	 * Método que altera a doação com o id passado e retorna a doação editada caso exista ou nulo caso não.
	 * @param Integer idDoacao.
	 * @param Doador doador.
	 * @param Produto produto.
	 * @param Number quantidade.
	 * @param Date dt_doacao.
	 * @return Doação doação - Retorna a doação editada, null - Retorna null caso a doação não seja encontrada.
	 */
	public Doacoes alterarDoacao(Integer idDoacao, Doador doador, Produto produto, Number quantidade, Date dt_doacao){
		Doacoes doacao = null;
		if(!(listaDoacoes.estaVazia())){// Verifica se a lista está vazia.
			iterar = listaDoadores.iterador();// Obtem o iterador da lista.
			while(iterar.temProximo()){
				doacao = (Doacoes) iterar.obterProximo();// Obtem a doação.
				if(doacao.getId() == idDoacao){// Verifica se a doação possui a mesma id.
					doacao.setData(dt_doacao);// Altera a data da doação.
					doacao.setDoador(doador);// Altera o doador.
					doacao.setProduto(produto);// Altera o produto.
					doacao.setQuantidade((double) quantidade);// Altera a quantidade da doação.
					return doacao;// Retorna a doação editada.
				}
			}
		}
		return null;// Retona nulo caso não encontre a doação.
	}

	/**
	 * Método que remove a doação com o id cadastrado e retorna true caso remova ou false caso não.
	 * @param int idDoacao.
	 * @return true - Caso remova, false - Caso não remova.
	 */
	public boolean removerDoacao(int idDoacao){
		int posicao = 0;
		if(!(listaDoacoes.estaVazia())){// Verifica se a lista está vazia.
			Doacoes doacao;
			iterar = listaDoacoes.iterador();// Obtem o iterador da lista.
			while(iterar.temProximo()){
				doacao = (Doacoes) iterar.obterProximo();// Obtem o doação.
				if(doacao.getId() == idDoacao){// Verifica se a doação possui a mesma id.
					doacao.getDoador().setQuantDoacoes(doacao.getDoador().getQuantDoacoes() - 1);// Decrementa a quantidade de doações feitas pelo doador.
					doacao.getProduto().setqDoacoes(doacao.getProduto().getqDoacoes() - 1);// Decrementa a quantidade de vezes doadas do produto.
					return listaDoacoes.remover(posicao) != null; // Remove a doação e retorna true caso remova ou false caso não.
				}
				posicao++;
			}
		}
		return false;// Retorna false caso não encontre a doação.
	}

	/**
	 * Retorna o iterador da lista que contenha as informações passadas ou null caso não exista.
	 * @param boolean monetario.
	 * @param Doador doador.
	 * @return Iterado - Retorna o iterador da lista contendo apenas os tipos passados, null - Caso a lista esteja vazia.
	 */
	public Iterado listarDoacoesOrdenadas(boolean monetario, Doador doador){

		Lista lista = copiarLista(listaDoacoes.iterador());// Copia a lista.
		Doacoes doacao;
		Iterado iterador;
		int cont = 0;

		lista.ordenarLista();// Ordena a lista.
		/*
		 * Tentei fazer esse metodo retornar exatamente o iterador de cada lista, mas estava ocorrendo erros cujo quais não consegui identificar,
		 * Então fiz ele apenas retornar a lista inteira, e a seleção é feita na view.
		 */
		if(doador == null){
			return lista.iterador();
		}
		else if(monetario){
			iterador = lista.iterador();
			while(iterador.temProximo()){
				doacao = (Doacoes)iterador.obterProximo();
				if(doacao.getDoador().equals(doador) && monetario){
					lista.remover(cont);
				}
				cont++;
			}
		}
		else{
			iterador = lista.iterador();
			while(iterador.temProximo()){
				doacao = (Doacoes)iterador.obterProximo();
				if(doacao.getDoador().equals(doador) && !monetario){
					lista.remover(cont);
				}
				cont++;
			}
		}
		
		return lista.iterador();
	}


	/**
	 * Calcula os percentuais de doação e os atribui ao doador.
	 */
	public void calcularPercentualDoadores(){

		Iterador iterador = listaDoacoes.iterador();
		Doacoes doacao = null;
		int qMonetario = 0, qDmonetario = 0, qDoacoes = 0;
		int qNmonetario = 0, qDnMonetario = 0;
		int cont;

		while(iterador.temProximo()){
			doacao = (Doacoes)iterador.obterProximo();
			if(doacao.isTipo()){
				qMonetario++;// Faz a contagem total de doações monetárias.
			}
			else{
				qNmonetario++;// Faz a contagem total de doações não monetárias.
			}
		}
		for(cont = 0; cont < listaDoacoes.obterTamanho(); cont++){
			iterador = listaDoadores.iterador();

			while(iterador.temProximo()){
				doacao = (Doacoes)iterador.obterProximo();
				if(doacao.getDoador().getTipo().equals("Monetária")){
					qDmonetario++;// Faz a contagem do total de doações monetárias do doador.
				}
				else{
					qDnMonetario++;// Faz a contagem do total de doações não monetárias do doador.
				}
			}
			qDoacoes = doacao.getDoador().getQuantDoacoes();
			doacao.getDoador().setPercentualMonetario((100 * qDmonetario) / qMonetario);// Atribui os valores contados.
			doacao.getDoador().setPercentualNmonetario((100 * qDnMonetario) / qDnMonetario);
		}
	}

	/**
	 * Método que retorna a lista de doadores.
	 * @return Lista.
	 */
	public Lista getListaDoadores() {
		return listaDoadores;// Retorna a lista.
	}

	/**
	 * Método que retorna a lista de doações.
	 * @return Lista.
	 */
	public Lista getListaDoacoes() {
		return listaDoacoes;// Retorna a lista.
	}

	/**
	 * Método que retorna a lista de produtos
	 * @return Lista.
	 */
	public Lista getListaProdutos(){
		return listaProdutos;// Retorna a lista.
	}

	/**
	 * Copia a lista passada.
	 * @param Iterado iterador.
	 * @return Lista.
	 */
	public Lista copiarLista(Iterado iterador){
		Lista lista = new Lista();// Cria uma nova lista.
		while(iterador.temProximo()){// Percorre a lista e copia todos os objetos.
			lista.inserirInicio(iterador.obterProximo());
		}
		return lista;// Retorna a lista criada.
	}
}