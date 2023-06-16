package Programa;

public class Funcionario extends Pessoa {
	
	//Classe Funcionario que extende Pessoa
	
	private double salario;
	private String cargo;
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, int idade, String email, String telefone, String endereco, double salario,String cargo) { //Construtor da classe Funcionario
		super(nome, idade, email, telefone, endereco);
		this.salario = salario;
		this.cargo = cargo;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public void imprimirPessoa() { //Metodo que imprime um funcionario (uso do polimorfismo)
        System.out.println("------ FUNCIONÁRIO ENCONTRADO ------");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
        System.out.println("E-mail: " + this.getEmail());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Salário: R$ " + this.getSalario());
        System.out.println("Cargo: " + this.getCargo());
	}
}
