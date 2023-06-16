package Programa;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OperacoesPessoas {
    public void cadastrarPessoa(List<Pessoa> pessoas) { //Método para cadastrar uma pessoa manualmente
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ CADASTRO ------");
        System.out.println("1. Cliente ");
        System.out.println("2. Funcionário ");
        System.out.print("Escolha o tipo de pessoa para cadastro: ");
        int tipoCadastro = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        
        if (tipoCadastro == 1) {
            // Cadastro de Cliente
            Cliente cliente = new Cliente(nome, idade, email, telefone, endereco);
            System.out.println("Cliente cadastrado com sucesso!");
            pessoas.add(cliente);
        } else if (tipoCadastro == 2) {
            // Cadastro de Funcionário
            System.out.print("Salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer
            
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();
            
            Funcionario funcionario = new Funcionario(nome, idade, email, telefone, endereco, salario, cargo);
            System.out.println("Funcionário cadastrado com sucesso!");
            pessoas.add(funcionario);
        } else {
            System.out.println("Opção inválida!");
        }        
    }

    public void listarPessoas(List<Pessoa> pessoas) {   //Método para listar as pessoas cadastradas (exibindo apenas 3 atributos)
        System.out.println("------ LISTA DE PESSOAS ------");
        System.out.println("Nome\tIdade\tE-mail");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome() + "\t" + pessoa.getIdade() + "\t" + pessoa.getEmail());
        }
    }

    public void buscarEExibirPessoa(List<Pessoa> pessoas) {   //Método para buscar e exibir uma pessoa a partir do nome
        Scanner scanner = new Scanner(System.in);
		

        System.out.print("Digite o nome da pessoa: ");
        String nomeBusca = scanner.nextLine();

        boolean encontrada = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomeBusca)) {
            	if(pessoa instanceof Cliente) {
            		Cliente cliente = (Cliente) pessoa; // Pessoa vira Cliente usando downcasting
            		cliente.imprimirPessoa();
                    encontrada = true;
                    break;
                	}else if(pessoa instanceof Funcionario) {
                		Funcionario funcionario = (Funcionario) pessoa; // Pessoa vira funcionário usando downcasting
                		funcionario.imprimirPessoa();
                        encontrada = true;
                        break;
                	}
                }
            }
            if (!encontrada) {
                System.out.println("Pessoa não encontrada!");
            }
        }

    public void listarPessoasOrdenadas(List<Pessoa> pessoas) {   //Método para listar as pessoas cadastradas em ordem alfabética por nome
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            Collections.sort(pessoas, new PessoaComparator());

            System.out.println("------ PESSOAS ORDENADAS POR NOME ------");
            System.out.println("Nome\tIdade\tE-mail");

            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa.getNome() + "\t" + pessoa.getIdade() + "\t" + pessoa.getEmail());
            }
        }
    }

    public void buscarERemoverPessoa(List<Pessoa> pessoas) {  //Método para buscar e remover uma pessoa a partir do nome
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da pessoa: ");
        String nomeBusca = scanner.nextLine();

        boolean encontrada = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomeBusca)) {
				if (pessoa instanceof Cliente) {
	           		Cliente cliente = (Cliente) pessoa; // Pessoa vira Cliente usando downcasting
            		cliente.imprimirPessoa();
					System.out.print("Deseja remover esse cliente? (S/N): ");
					String confirmacao = scanner.nextLine();
					if (confirmacao.equalsIgnoreCase("S")) {
						pessoas.remove(cliente);
						System.out.println("Cliente removida com sucesso!");
					} else {
						System.out.println("Remoção cancelada.");
					}
					encontrada = true;
					break;
				} else if (pessoa instanceof Funcionario) {
            		Funcionario funcionario = (Funcionario) pessoa; // Pessoa vira funcionário usando downcasting
            		funcionario.imprimirPessoa();
					System.out.print("Deseja remover esse funcionario? (S/N): ");
					String confirmacao = scanner.nextLine();
					if (confirmacao.equalsIgnoreCase("S")) {
						pessoas.remove(funcionario);
						System.out.println("Funcionario removida com sucesso!");
					} else {
						System.out.println("Remoção cancelada.");
					}
					encontrada = true;
					break;
				}
				if (!encontrada) {
					System.out.println("Pessoa não encontrada!");
				}
			}
		}
	}

    public void buscarEModificarPessoa(List<Pessoa> pessoas) {   //Método para buscar e modificar uma pessoa a partir do nome
        Scanner scanner = new Scanner(System.in);
        Impressao imprimir = new Impressao();

        System.out.print("Digite o nome da pessoa: ");
        String nomeBusca = scanner.nextLine();

        boolean encontrada = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomeBusca)) {
                if(pessoa instanceof Cliente) {
                   	Cliente cliente = (Cliente) pessoa; //Pessoa vira Cliente usando downcasting
                	cliente.imprimirPessoa();
                    System.out.print("Deseja modificar esse cliente? (S/N): ");
                    String confirmacao = scanner.nextLine();
                    if (confirmacao.equalsIgnoreCase("S")) {
                    	int modificacao;
                    	imprimir.modificarCliente();
                    	try {  // Estrutura para capturar exceções no programa
                    		modificacao = scanner.nextInt();
                			scanner.nextLine(); // Limpar o buffer
                			
                			switch(modificacao) {
                			case 1:
                                System.out.print("Digite o novo nome: ");
                                String novoNome = scanner.nextLine();
                                cliente.setNome(novoNome);
                                System.out.println("Cliente modificado com sucesso!");
                                break;
                			case 2:
                                System.out.print("Digite a nova idade: ");
                                int novaIdade = scanner.nextInt();
                                cliente.setIdade(novaIdade);
                                System.out.println("Cliente modificado com sucesso!");
                				break;
                			case 3:
                                System.out.print("Digite o novo e-mail: ");
                                String novoEmail = scanner.nextLine();
                                cliente.setEmail(novoEmail);
                                System.out.println("Cliente modificado com sucesso!");
                                break;
                			case 4:
                                System.out.print("Digite o novo telefone: ");
                                String novoTelefone = scanner.nextLine();
                                cliente.setTelefone(novoTelefone);
                                System.out.println("Cliente modificado com sucesso!");
                                break;
                			case 5:
                                System.out.print("Digite o novo endereço: ");
                                String novoEndereco = scanner.nextLine();
                                cliente.setEndereco(novoEndereco);
                                System.out.println("Cliente modificado com sucesso!");
                                break;
                			default:
                				System.out.println("Opção inválida. Digite um número válido.");
                				break;	
                			}
            			}catch (InputMismatchException e) {  //Capturando a exceção de entrar com um valor string
                            System.out.println("Opção inválida. Digite um número válido.");
                            scanner.nextLine(); //Limpar o buffer
            			}      
                    } else {
                        System.out.println("Modificação cancelada.");
                    }
                    encontrada = true;
                    break;
                }else if(pessoa instanceof Funcionario) {
                		Funcionario funcionario = (Funcionario) pessoa; // Pessoa vira funcionário usando downcasting
                		funcionario.imprimirPessoa();
                        System.out.print("Deseja modificar esse funcionario? (S/N): ");
                        String confirmacao = scanner.nextLine();
                        if (confirmacao.equalsIgnoreCase("S")) {
                        	int modificacao;
                        	imprimir.modificarFuncionario();
                        	try {  // Estrutura para capturar exceções no programa
                        		modificacao = scanner.nextInt();
                    			scanner.nextLine(); // Limpar o buffer
                    			
                    			switch(modificacao) {
                    			case 1:
                                    System.out.print("Digite o novo nome: ");
                                    String novoNome = scanner.nextLine();
                                    funcionario.setNome(novoNome);
                                    System.out.println("Funcionario modificado com sucesso!");
                                    break;
                    			case 2:
                                    System.out.print("Digite a nova idade: ");
                                    int novaIdade = scanner.nextInt();
                                    funcionario.setIdade(novaIdade);
                                    System.out.println("Funcionario modificado com sucesso!");
                    				break;
                    			case 3:
                                    System.out.print("Digite o novo e-mail: ");
                                    String novoEmail = scanner.nextLine();
                                    funcionario.setEmail(novoEmail);
                                    System.out.println("Funcionario modificado com sucesso!");
                                    break;
                    			case 4:
                                    System.out.print("Digite o novo telefone: ");
                                    String novoTelefone = scanner.nextLine();
                                    funcionario.setTelefone(novoTelefone);
                                    System.out.println("Funcionario modificado com sucesso!");
                                    break;
                    			case 5:
                                    System.out.print("Digite o novo endereço: ");
                                    String novoEndereco = scanner.nextLine();
                                    funcionario.setEndereco(novoEndereco);
                                    System.out.println("Funcionario modificado com sucesso!");
                                    break;
                    			case 6:
                                    System.out.print("Digite o novo salário: ");
                                    int novoSalario = scanner.nextInt();
                                    funcionario.setSalario(novoSalario);
                                    System.out.println("Funcionario modificado com sucesso!");
                    				break;
                    			case 7:
                                    System.out.print("Digite o novo cargo: ");
                                    String novoCargo = scanner.nextLine();
                                    funcionario.setCargo(novoCargo);
                                    System.out.println("Funcionario modificado com sucesso!");
                                    break;
                    			default:
                    				System.out.println("Opção inválida. Digite um número válido.");
                    				break;	
                    			}
                			}catch (InputMismatchException e) {  //Capturando a exceção de entrar com um valor string
                                System.out.println("Opção inválida. Digite um número válido.");
                                scanner.nextLine(); //Limpar o buffer
                			}     
                        } else {
                            System.out.println("Modificação cancelada.");
                        }
                        encontrada = true;
                        break;
                    }
                }
            } 
            if (!encontrada) {
                System.out.println("Pessoa não encontrada!");
            }
        }
    
	public void cadastrarAutomaticamente(List<Pessoa> pessoas) {   //Método para cadastrar automaticamente pelo menos 7 objetos
		Pessoa pessoa1 = new Funcionario("João", 25, "joao@gmail.com", "123456789", "Rua A", 1300, "Segurança");
		pessoas.add(pessoa1);

		Pessoa pessoa2 = new Funcionario("Maria", 30, "maria@gmail.com", "987654321", "Rua B", 1500, "Supervisor");
		pessoas.add(pessoa2);

		Pessoa pessoa3 = new Funcionario("Pedro", 35, "pedro@gmail.com", "456789123", "Rua C", 2500, "Gerente");
		pessoas.add(pessoa3);

		Pessoa pessoa4 = new Cliente("Ana", 28, "ana@gmail.com", "321654987", "Rua D");
		pessoas.add(pessoa4);

		Pessoa pessoa5 = new Cliente("Carlos", 32, "carlos@gmail.com", "789123456", "Rua E");
		pessoas.add(pessoa5);

		Pessoa pessoa6 = new Cliente("Mariana", 27, "mariana@gmail.com", "654987321", "Rua F");
		pessoas.add(pessoa6);

		Pessoa pessoa7 = new Cliente("Lucas", 29, "lucas@gmail.com", "147258369", "Rua G");
		pessoas.add(pessoa7);
	 }
   }
