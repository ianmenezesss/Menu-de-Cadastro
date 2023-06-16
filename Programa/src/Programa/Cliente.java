package Programa;

public class Cliente extends Pessoa{
	
	//Classe Cliente que extende Pessoa

	public Cliente() {
		super();
	}

	public Cliente(String nome, int idade, String email, String telefone, String endereco) { //Construtor da classe Cliente
		super(nome, idade, email, telefone, endereco);
	}
	
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
    
    @Override
	public void imprimirPessoa() {  //Metodo que imprime um cliente (uso do polimorfismo)
		System.out.println("------ CLIENTE ENCONTRADO ------");
		System.out.println("Nome: " + this.getNome());
		System.out.println("Idade: " + this.getIdade());
		System.out.println("E-mail: " + this.getEmail());
		System.out.println("Telefone: " + this.getTelefone());
		System.out.println("Endereço: " + this.getEndereco());
	}
}
