package aula;

public class Aluno {
	  private String nome;
	  private int idade;
	  private int mes;
	  private int ano;

	  public Aluno(String nome, int idade, int mes, int ano) {
	    this.setNome(nome);
	    this.setIdade(idade);
	    this.setMes(mes);
	    this.setAno(ano);
	  }

	  public String getNome() {
	    return this.nome;
	  }

	  public boolean setNome(String nome) {
	    if(nome == null || nome.isEmpty()) {
	      return false;
	    }
	    if(nome.length() < 5 || nome.length() > 50) {
	      return false;
	    }
	    this.nome = nome;
	    return true;
	  }

	  public int getIdade() {
	    return this.idade;
	  }

	  public boolean setIdade(int idade) {
	    if(idade < 1 || idade > 150) {
	      return false;
	    }
	    this.idade = idade;
	    return true;
	  }

	  public int getMes() {
	    return this.mes;
	  }

	  public boolean setMes(int mes) {
	    if(mes >= 1 && mes <= 12) {
	      this.mes = mes;
	      return true;
	    }
	    return false;
	  }

	  public int getAno() {
	    return this.ano;
	  }

	  public boolean setAno(int ano) {
	    if(ano >= 1900 && ano <= 2024) {
	      this.ano = ano;
	      return true;
	    }
	    return false;
	  }

	  @Override
	  public String toString() {

		  return String.format(this.getNome() + this.getIdade(), this.ehMaior());
	  }

	  private String ehMaior() {
	    return this.getIdade() >= 18 ? "é maior de idade" : "é menor de idade";
	  }
	}