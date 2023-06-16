package Programa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Programa {
	
	private static List<Pessoa> pessoas = new ArrayList<>();// Estrutura de dados para armazenar os objetos
	
	//Classe principal de execução do programa
	
	public static void main(String[] args){

		Impressao imprimir = new Impressao(); // Instanciando a  classe impressora
		OperacoesPessoas operacoes = new OperacoesPessoas();  //Instanciando as operações
		operacoes.cadastrarAutomaticamente(pessoas);  //Aplicação cadastra as pessoas

		//Recebendo a opção do usuário e fazendo as operações
		
		Scanner scanner = new Scanner(System.in);
		int opcao;
		do {   
			imprimir.exibirMenu();  //Aplicação exibe o menu
			try {  // Estrutura para capturar exceções no programa
			opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer

			switch (opcao) {
			case 1:
				operacoes.cadastrarPessoa(pessoas);
				break;
			case 2:
				operacoes.listarPessoas(pessoas);
				break;
			case 3:
				operacoes.buscarEExibirPessoa(pessoas);
				break;
			case 4:
				operacoes.listarPessoasOrdenadas(pessoas);
				break;
			case 5:
				operacoes.buscarERemoverPessoa(pessoas);
				break;
			case 6:
				operacoes.buscarEModificarPessoa(pessoas);
				break;
			case 0:
				System.out.println("Encerrando o programa em ...");
				for (int i=3;i>0;i--) {  //Contagem regressiva usando java threads 
					System.out.println(i);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
					System.out.println("Programa encerrado!");
				break;
			default:
				System.out.println("Opção inválida. Digite um número válido.");
				break;
			}

			}catch (InputMismatchException e) {  //Capturando a exceção de entrar com um valor string
                System.out.println("Opção inválida. Digite um número válido.");
                opcao = 100; //Definir uma opção inválida default para continuar o loop
			}      
			System.out.println();
		} while (opcao != 0);
	}
}