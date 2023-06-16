package Programa;

public class Impressao { // Classe que organiza a impressão dos metodos

	public void exibirMenu() { // Método para apenas exibir o menu geral
		System.out.println("------ MENU ------");
		System.out.println("1. Cadastrar pessoa");
		System.out.println("2. Listar pessoas");
		System.out.println("3. Buscar e exibir pessoa");
		System.out.println("4. Listar pessoas ordenadas");
		System.out.println("5. Buscar e remover pessoa");
		System.out.println("6. Buscar e modificar pessoa");
		System.out.println("0. Sair");
		System.out.print("Digite a opção desejada: ");
	}
	public void modificarCliente() {// Método para apenas exibir o menu de modificação cliente
		System.out.println();
		System.out.println("------ MENU ------");
		System.out.println("1. Modificar nome");
		System.out.println("2. Modificar idade");
		System.out.println("3. Modificar e-mail");
		System.out.println("4. Modificar telefone");
		System.out.println("5. Modificar endereço");
		System.out.print("Digite a opção desejada: ");
	}
	public void modificarFuncionario() {// Método para apenas exibir o menu de modificação funcionario
		System.out.println();
		System.out.println("------ MENU ------");
		System.out.println("1. Modificar nome");
		System.out.println("2. Modificar idade");
		System.out.println("3. Modificar e-mail");
		System.out.println("4. Modificar telefone");
		System.out.println("5. Modificar endereço");
		System.out.println("6. Modificar salário");
		System.out.println("7. Modificar cargo");
		System.out.print("Digite a opção desejada: ");
	}
}
