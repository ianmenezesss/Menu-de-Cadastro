package Programa;

public abstract class Pessoa {
	
	// Classe pessoa abstrata (apenas para a coerência do programa com a realidade)
	
    protected String nome;
    protected int idade;
    protected String email;
    protected String telefone;
    protected String endereco;
    
    public Pessoa() {}

	public Pessoa(String nome, int idade, String email, String telefone, String endereco) {  //Construtor da classe Pessoa
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
	
	protected abstract void imprimirPessoa();  // Metodo geral que imprime pessoa

  // Getters e Setters
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
