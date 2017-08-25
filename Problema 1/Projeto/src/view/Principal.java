package view;

import java.io.IOException;
import java.util.Date;

import controller.Controller;
import model.Doacoes;
import model.Doador;
import model.Produto;
import util.Console;
import util.Iterador;
import util.PegaData;

public class Principal {

	static Controller controle = new Controller();

	public static void main(String args[]) throws NumberFormatException, IOException{

		int opcao = 0;

		while(opcao != 15){

			System.out.println("Sistemade Apoio Comunitário da cidade de Mariana - MG\n\n");

			System.out.println("Escolha dentre as opções abaixo: \n");
			System.out.println("1 - Cadastrar Produto");
			System.out.println("2 - Alterar Produto");
			System.out.println("3 - Remover Produto");
			System.out.println("4 - Listar Produtos");
			System.out.println("5 - Cadastrar Doador");
			System.out.println("6 - Alterar Doador");
			System.out.println("7 - Remover Doador");
			System.out.println("8 - Listar Doadores");
			System.out.println("9 - Inserir Doação");
			System.out.println("10 - Alterar Doação");
			System.out.println("11 - Remover Doação");
			System.out.println("12 - Listar Doações");
			System.out.println("13 - Listar Doações de um Doador");
			System.out.println("14 - Listar Doadores e respectivo percentual de doação");
			System.out.println("15 - Sair");


			opcao = Console.readInt();
			switch(opcao){
			case 1:
				cadastrarProduto();
				break;
			case 2:
				alterarProduto();
				break;
			case 3:
				removerProduto();
				break;
			case 4:
				listarProdutos();
				break;
			case 5:
				cadastrarDoador();
				break;
			case 6:
				alterarDoador();
				break;
			case 7:
				removerDoador();
				break;
			case 8:
				listarDoadores();
				break;
			case 9:
				inserirDoacao();
				break;
			case 10:
				alterarDoacao();
				break;
			case 11:
				removerDoacao();
				break;
			case 12:
				listarDoacoes();
				break;
			case 13:
				listarDoacoesDoador();
				break;
			case 14:
				listarDoacoesePercentual();
				break;
			case 15:
				opcao = 15;
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
		}
	}

	private static void cadastrarProduto() throws IOException {
		String nome, tipo = "";// Iniciei a variável para não aparecer erro na ide.
		Date data;
		int opcao = 0;

		System.out.println("Cadastrar Produto: \n\n");
		System.out.println("Digite o nome do produto: ");
		nome = Console.readString();
		System.out.println("Escolha o tipo: ");
		System.out.println("1 - Alimento\t2 - Vestuário");
		System.out.println("3 - Limpeza\t4 - Monetária\n5 - Outros");
		do{
			opcao = Console.readInt();
		}while(opcao < 1 || opcao > 5);

		switch (opcao){
		case 1:
			tipo = "Alimento";
			break;
		case 2:
			tipo = "Vestuário";
			break;
		case 3:
			tipo = "Limpeza";
			break;
		case 4:
			tipo = "Monetária";
			break;
		case 5:
			tipo = "Outros";
			break;
		}
		System.out.println("Digite a data atual: ");
		data = PegaData.pegaData();
		if(controle.cadastrarProduto(nome, tipo, data) == null){
			System.out.println("O cadastro não pode ser realizado!");
		}
		else{
			System.out.println("Cadastro realizado!");
		}
	}

	private static void alterarProduto() throws NumberFormatException, IOException {
		String nome, tipo = "";
		Date data;
		int id = 0, opcao = 0;

		System.out.println("Alterar Produto: \n\n");
		System.out.println("Digite o id do produto: ");
		id = Console.readInt();
		if(controle.obterProduto(id) == null){
			System.out.println("O produto não existe! ");
			return;
		}
		System.out.println("Digite o nome do produto: ");
		nome = Console.readString();
		System.out.println("Escolha o tipo: ");
		System.out.println("1 - Alimento\t2 - Vestuário");
		System.out.println("3 - Limpeza\t4 - Monetária\n5 - Outros");
		do{
			opcao = Console.readInt();
		}while(opcao < 1 || opcao > 5);

		switch (opcao){
		case 1:
			tipo = "Alimento";
			break;
		case 2:
			tipo = "Vestuário";
			break;
		case 3:
			tipo = "Limpeza";
			break;
		case 4:
			tipo = "Monetária";
			break;
		case 5:
			tipo = "Outros";
			break;
		}
		System.out.println("Digite a data atual: ");
		data = PegaData.pegaData();
		if(controle.editarProduto(id, nome, tipo, data) == null){
			System.out.println("Não foi possivel concluir a alteração!");
		}
		else{
			System.out.println("Alteração concluida!");
		}
	}

	private static void removerProduto() throws NumberFormatException, IOException {
		int id = 0;

		System.out.println("Remover Produto: \n\n");
		System.out.println("Digite a id do produto: ");
		id = Console.readInt();
		if(controle.removerProduto(id)){
			System.out.println("Produto removido com sucesso!");
		}
		else{
			System.out.println("Não foi possivel remover o produto!");
		}
	}

	private static void listarProdutos() {
		Iterador iterador = controle.listarProdutos();
		Produto produto;

		if(!(iterador.temProximo())){
			System.out.println("Lista Vazia!");
		}

		while(iterador.temProximo()){
			produto = (Produto) iterador.obterProximo();
			System.out.printf("%d - %s\n",produto.getId(), produto.getNome());
		}

	}

	private static void cadastrarDoador() throws IOException {
		String nome, numCadastro, tipoString = "", rua, bairro, pais, cep, cidade, uf;// Tipo de String foi inicializado para inibir mensagens de erro do eclipse.
		int tipo = 0, numero;
		Date data;
		boolean verificacao;

		System.out.println("Cadastrar Doador: \n\n");
		System.out.println("Digite o nome do doador: ");
		nome = Console.readString();
		System.out.println("Escolha o tipo: ");
		do{
			System.out.println("1 - Fisico\t\t2 - Juridico");
			tipo = Console.readInt();
			switch(tipo){
			case 1:
				tipoString = "Fisico";
				break;
			case 2:
				tipoString = "Juridico";
				break;
			default:
				System.out.println("Tipo invalido!");
			}
		}while(tipo != 1 && tipo != 2);
		if(tipo == 1){
			System.out.println("Digite o seu CPF: XXX.XXX.XXX-XX");
			numCadastro = Console.readString();
			System.out.println("Digite a data de nascimento: ");
			data = PegaData.pegaData();
		}
		else{
			System.out.println("Digite o seu CNPJ: XXX.XXX.XXX-XXXX/XX");
			numCadastro = Console.readString();
			System.out.println("Digite a data de fundação: ");
			data = PegaData.pegaData();
		}
		System.out.println("Endereço: ");
		System.out.print("Rua: ");
		rua = Console.readString();
		System.out.print("Bairro: ");
		bairro = Console.readString();
		System.out.print("Cidade: ");
		cidade = Console.readString();
		System.out.print("CEP: ");
		cep = Console.readString();
		System.out.print("Numero: ");
		numero = Console.readInt();
		System.out.print("UF: ");
		uf = Console.readString();
		System.out.print("Pais: ");
		pais = Console.readString();
		verificacao = controle.cadastrarDoador(numCadastro, nome, data, rua, numero, bairro, cep, cidade, uf, pais, tipoString) == null;
		if(verificacao){
			System.out.println("Não foi possivel realizar o cadastro!");
		}
		else{
			System.out.println("Cadastro realizado!");
		}
	}

	/*
	 * Copiei o código de cadastrar o usuário, por usar apenas 2 vezes não achei que seria necessário criar um método que recebe esses dados.
	 */
	private static void alterarDoador() throws IOException {
		String nome, numCadastro, tipoString = "", rua, bairro, pais, cep, cidade, uf;// Tipo de String foi inicializado para inibir mensagens de erro do eclipse.
		int tipo = 0, numero;
		Date data;
		boolean verificacao;

		System.out.println("Alterar Doador: \n\n");
		System.out.println("Digite o nome do doador: ");
		nome = Console.readString();
		System.out.println("Escolha o tipo: ");
		do{
			System.out.println("1 - Físico\t\t2 - Juridico");
			tipo = Console.readInt();
			switch(tipo){
			case 1:
				tipoString = "Físico";
				break;
			case 2:
				tipoString = "Juridico";
				break;
			default:
				System.out.println("Tipo invalido!");
			}
		}while(tipo != 1 && tipo != 2);
		if(tipo == 1){
			System.out.println("Digite o seu CPF: XXX.XXX.XXX-XX");
			numCadastro = Console.readString();
			System.out.println("Digite a data de nascimento: ");
			data = PegaData.pegaData();
		}
		else{
			System.out.println("Digite o seu CNPJ: XXX.XXX.XXX-XXXX/XX");
			numCadastro = Console.readString();
			System.out.println("Digite a data de fundação: ");
			data = PegaData.pegaData();
		}
		System.out.println("Endereço: ");
		System.out.print("Rua: ");
		rua = Console.readString();
		System.out.print("Bairro: ");
		bairro = Console.readString();
		System.out.print("Cidade: ");
		cidade = Console.readString();
		System.out.print("CEP: ");
		cep = Console.readString();
		System.out.print("Numero: ");
		numero = Console.readInt();
		System.out.print("UF: ");
		uf = Console.readString();
		System.out.print("Pais: ");
		pais = Console.readString();
		verificacao = controle.editarDoador(numCadastro, nome, data, rua, numero, bairro, cep, cidade, uf, pais, tipoString) == null;
		if(verificacao){
			System.out.println("Não foi possivel editar o cadastro!");
		}
		else{
			System.out.println("Cadastro editado!");
		}
	}

	private static void removerDoador() throws IOException {
		String numCadastro;

		System.out.println("Remover Doador:\n\n ");
		System.out.println("Insira o CPF/CNPJ do doador: ");
		numCadastro = Console.readString();
		if(controle.removerDoador(numCadastro)){
			System.out.println("Doador removido com sucesso!");
		}
		else{
			System.out.println("Não foi possivel remover o doador!");
		}
	}

	private static void listarDoadores() {
		Iterador iterador = controle.listarDoadores();
		Doador doador;

		if(!(iterador.temProximo())){
			System.out.println("Lista Vazia!");
		}

		while(iterador.temProximo()){
			doador = (Doador) iterador.obterProximo();
			System.out.printf("%s - %s\n",doador.getNome(), doador.getNumCadastro());
		}

	}

	private static boolean inserirDoacao() throws NumberFormatException, IOException {
		Doador doador;
		Produto produto;
		double quantidade;
		Date dt_doacao;
		String numCadastro;
		int idProduto;

		System.out.println("Inserir Doação:\n\n");
		System.out.println("Insira o numero de cadastro do doador: ");
		numCadastro = Console.readString();
		doador = controle.obterDoador(numCadastro);
		if(doador == null){
			System.out.println("Não existe doador com esse numero de cadastro!");
			return false;// Finalizo caso o numero de cadastro não corresponda a nenhum usuário. 
		}

		System.out.println("Insira a id do produto que deseja doar: ");
		idProduto = Console.readInt();
		produto = controle.obterProduto(idProduto);
		if(produto == null){
			System.out.println("Não existe produtos com essa id!");
			return false;// Finalizo caso o numero do id não corresponda a nenhum produto.
		}

		System.out.println("Digite a quantidade: ");
		quantidade = Console.readDouble();

		dt_doacao = PegaData.pegaData();

		return controle.efetuarDoacao(doador, produto, quantidade, dt_doacao) != null;
	}

	private static boolean alterarDoacao() throws NumberFormatException, IOException {
		Produto produto;
		Doador doador;
		Number quantidade;
		Date dt_doacao;
		int idDoacao = 0, idProduto = 0;
		String numCadastro;

		if (controle.getListaDoacoes().estaVazia()){
			System.out.println("Não existe doações para serem editadas!");
			return false;
		}
		else{
			System.out.println("Alterar Doacoes: \n\n");
			System.out.println("Digite o id da doação: ");
			idDoacao = Console.readInt();

			System.out.println("Digite o numero de cadastro do doador: ");
			numCadastro = Console.readString();
			doador = controle.obterDoador(numCadastro);
			if(doador == null){
				System.out.println("Não existe doador com esse numero de cadastro!");
				return false;
			}

			System.out.println("Digite a id do produto: ");
			idProduto = Console.readInt();
			produto = controle.obterProduto(idProduto);
			if(produto == null){
				System.out.println("Não exite produto com esse id!");
				return false;
			}

			System.out.println("Digite a quantidade: ");
			do{
				quantidade = Console.readDouble();
			}while((double)quantidade > 0 );// Permite apenas que seja inserido apenas valores maior que 0.

			dt_doacao = PegaData.pegaData();

			return controle.alterarDoacao(idDoacao, doador, produto, quantidade, dt_doacao) != null;
		}

	}

	private static void removerDoacao() throws NumberFormatException, IOException {
		int idDoacao = 0;

		if(controle.getListaDoacoes().estaVazia()){
			System.out.println("Lista vazia!");
		}
		else{
			System.out.println("Remover Doação: \n\n");
			System.out.println("Digite a id da doacao: ");
			idDoacao = Console.readInt();
			if(controle.removerDoacao(idDoacao)){
				System.out.println("Doação removida com sucesso!");
			}
			else{
				System.out.println("A doação não pode ser removida!");
			}
		}
	}

	private static void listarDoacoes() throws IOException {
		Doacoes doacao;
		Doador doador;
		Iterador iterador;
		String numCadastro;

		iterador = (Iterador)controle.listarDoacoesOrdenadas(false, null);

		if(iterador.temProximo()){
			System.out.println("\t\tLista de Produtos Não Monetários: ");
			while(iterador.temProximo()){
				doacao = (Doacoes)iterador.obterProximo();
				if(!doacao.isTipo()){
					System.out.println(doacao.getQuantidade() + " - " + doacao.getProduto().getNome() + ", " + doacao.getProduto().getTipo());
				}
			}
		}
		else{
			System.out.println("Não exite produtos não monetários!");
		}

		iterador = (Iterador)controle.listarDoacoesOrdenadas(false, null);

		if(iterador.temProximo()){
			System.out.println("\t\tLista de Produtos Monetários: ");
			while(iterador.temProximo()){
				doacao = (Doacoes)iterador.obterProximo();
				if(doacao.isTipo()){
					System.out.println(doacao.getQuantidade() + " - " + doacao.getProduto().getNome() + ", " + doacao.getProduto().getTipo());
				}
			}
		}
		else{
			System.out.println("Não exite produtos monetários!");
		}
	}

	private static void listarDoacoesDoador() throws IOException {
		Doacoes doacao;
		Doador doador;
		Iterador iterador;
		String numCadastro;

		if(controle.getListaDoadores().estaVazia()){
			System.out.println("Lista de doadores vazia!");
			return;
		}

		System.out.println("Listar Doações do Doador: \t\t");
		System.out.println("Digite o CPF/CNPJ do doador:");
		numCadastro = Console.readString();
		doador = (Doador)controle.obterDoador(numCadastro);

		if(doador == null){
			System.out.println("Doador não encontrado!");
			return;
		}
		else{
			controle.getListaDoacoes().ordenarLista();
			iterador = controle.getListaDoacoes().iterador();
			System.out.println("Lista de produtos não monetários: ");
			while(iterador.temProximo()){
				doacao = (Doacoes)iterador.obterProximo();
				if(doador.equals(doacao.getDoador()) && !doacao.isTipo()){
					System.out.printf("%d - %s\t%f\n", doacao.getId(), doacao.getProduto().getNome(), doacao.getQuantidade());
				}
			}
			iterador = controle.getListaDoacoes().iterador();
			System.out.println("Lista de produtos monetários: ");
			while(iterador.temProximo()){
				doacao = (Doacoes)iterador.obterProximo();
				if(doador.equals(doacao.getDoador()) && doacao.isTipo()){
					System.out.printf("%d - %s\t%f\n", doacao.getId(), doacao.getProduto().getNome(), doacao.getQuantidade());
				}
			}
		}

	}

	private static void listarDoacoesePercentual() {
		Iterador iterador, iterador2;
		Doacoes doacao;
		Doador doador;
		int qDoacoes = controle.getListaDoacoes().obterTamanho();
		int qDm = 0, qDnM = 0;
		
		iterador = controle.listarDoadores();
		controle.calcularPercentualDoadores();
		
		if(!(iterador.temProximo())){
			System.out.println("Lista vazia!");
		}
		else{
			System.out.println("Listar todos os doadores e percentual: ");
			while(iterador.temProximo()){
				doador = (Doador)iterador.obterProximo();
				System.out.println(doador.getNome());
				controle.getListaDoacoes().ordenarLista();
				iterador2 = controle.getListaDoacoes().iterador();
				System.out.println("Lista de produtos não monetários: ");
				while(iterador2.temProximo()){
					doacao = (Doacoes)iterador2.obterProximo();
					if(doador.equals(doacao.getDoador()) && !doacao.isTipo()){
						System.out.printf("%d - %s\t%f\n", doacao.getId(), doacao.getProduto().getNome(), doacao.getQuantidade());
						qDnM++;
					}
				}
				System.out.println("Percentual " + doador.getPercentualNmonetario() + "%");
				iterador2 = controle.getListaDoacoes().iterador();
				System.out.println("Lista de produtos monetários: ");
				while(iterador2.temProximo()){
					doacao = (Doacoes)iterador2.obterProximo();
					if(doador.equals(doacao.getDoador()) && doacao.isTipo()){
						System.out.printf("%d - %s\t%f\n", doacao.getId(), doacao.getProduto().getNome(), doacao.getQuantidade());
						qDm++;
					}
				}
				System.out.println("Percentual " + doador.getPercentualMonetario() + "%");
			}
		}

	}
}
