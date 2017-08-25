package model;

import java.util.Date;

public class Doador {

	private String nome;
	private String tipo;
	private String numCadastro;
	private Date dt_nascimento;// Declarado dt_nascimento, mas pode armazenar a data de fundação da empresa(caso seja juridico).
	private String endereco;
	private double percentualTotal = 0;
	private double percentualMonetario = 0;
	private double percentualNmonetario = 0;
	private int quantDoacoes = 0;
	
	public Doador(String numCadastro, String nome, Date dt_nascimento, String rua, int numero, String bairro, String cep, String cidade, String uf, String pais, String tipo){
		this.nome = nome;
		this.tipo = tipo;
		this.numCadastro = numCadastro;
		this.dt_nascimento = dt_nascimento;
		this.endereco = rua + ", " + numero + ", " + bairro + ", " + cep + ", " + cidade + ", " + uf + ", " + pais;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumCadastro() {
		return numCadastro;
	}
	public void setNumCadastro(String cpf_cnpj) {
		this.numCadastro = cpf_cnpj;
	}
	public Date getDate() {
		return dt_nascimento;
	}
	public void setDate(Date date) {
		this.dt_nascimento = date;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String rua, int numero, String bairro, String cep, String cidade, String uf, String pais) {
		this.endereco = rua + ", " + numero + ", " + bairro + ", " + cep + ", " + cidade + ", " + uf + ", " + pais;
	}
	public int getQuantDoacoes() {
		return quantDoacoes;
	}
	public void setQuantDoacoes(int quantDoacoes) {
		this.quantDoacoes = quantDoacoes;
	}

	public double getPercentualTotal() {
		return percentualTotal;
	}

	public void setPercentualTotal(double percentualTotal) {
		this.percentualTotal = percentualTotal;
	}

	public double getPercentualMonetario() {
		return percentualMonetario;
	}

	public void setPercentualMonetario(double percentualMonetario) {
		this.percentualMonetario = percentualMonetario;
	}

	public double getPercentualNmonetario() {
		return percentualNmonetario;
	}

	public void setPercentualNmonetario(double percentualNmonetario) {
		this.percentualNmonetario = percentualNmonetario;
	}
}
