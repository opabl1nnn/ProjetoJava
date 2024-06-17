import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    visualizarFuncionario();
                    break;
                case 4:
                    excluirFuncionario();
                    break;
                case 5:
                    editarFuncionario();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Listar Funcionários");
        System.out.println("3. Visualizar Funcionário por ID");
        System.out.println("4. Excluir Funcionário por ID");
        System.out.println("5. Editar Funcionário por ID");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n===== Cadastro de Funcionário =====");
        System.out.println("Escolha o tipo de funcionário a ser cadastrado:");
        System.out.println("1. Gerente");
        System.out.println("2. Diretor");
        System.out.println("3. Operador");
        System.out.print("Digite o número correspondente: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = null;

        switch (tipo) {
            case 1:
                funcionario = cadastrarGerente();
                break;
            case 2:
                funcionario = cadastrarDiretor();
                break;
            case 3:
                funcionario = cadastrarOperador();
                break;
            default:
                System.out.println("Tipo de funcionário inválido.");
                return;
        }

        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static Gerente cadastrarGerente() {
        System.out.print("Nome do gerente: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do gerente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Salário base do gerente: ");
        double salarioBase = scanner.nextDouble();
        System.out.print("Bônus do gerente: ");
        double bonus = scanner.nextDouble();

        return new Gerente(nome, idade, salarioBase, bonus);
    }

    private static Diretor cadastrarDiretor() {
        System.out.print("Nome do diretor: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do diretor: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Salário base do diretor: ");
        double salarioBase = scanner.nextDouble();
        System.out.print("Participação nos lucros do diretor: ");
        double participacaoLucros = scanner.nextDouble();

        return new Diretor(nome, idade, salarioBase, participacaoLucros);
    }

    private static Operador cadastrarOperador() {
        System.out.print("Nome do operador: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do operador: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Salário base do operador: ");
        double salarioBase = scanner.nextDouble();
        System.out.print("Horas extras do operador: ");
        double horasExtras = scanner.nextDouble();

        return new Operador(nome, idade, salarioBase, horasExtras);
    }

    private static void listarFuncionarios() {
        System.out.println("\n===== Lista de Funcionários =====");
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    private static void visualizarFuncionario() {
        System.out.print("\nDigite o ID do funcionário que deseja visualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Funcionario funcionario = encontrarFuncionarioPorID(id);

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
        } else {
            System.out.println("\n===== Funcionário Encontrado =====");
            System.out.println(funcionario);
        }
    }

    private static void excluirFuncionario() {
        System.out.print("\nDigite o ID do funcionário que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = encontrarFuncionarioPorID(id);

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
        } else {
            funcionarios.remove(funcionario);
            System.out.println("Funcionário excluído com sucesso.");
        }
    }

    private static void editarFuncionario() {
        System.out.print("\nDigite o ID do funcionário que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = encontrarFuncionarioPorID(id);

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
        } else {
            System.out.println("Funcionário encontrado:");
            System.out.println(funcionario);

            System.out.println("\nDigite os novos dados do funcionário:");

            if (funcionario instanceof Gerente) {
                editarGerente((Gerente) funcionario);
            } else if (funcionario instanceof Diretor) {
                editarDiretor((Diretor) funcionario);
            } else if (funcionario instanceof Operador) {
                editarOperador((Operador) funcionario);
            }

            System.out.println("Funcionário editado com sucesso.");
        }
    }

    private static void editarGerente(Gerente gerente) {
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo salário base: ");
        double salarioBase = scanner.nextDouble();
        System.out.print("Novo bônus: ");
        double bonus = scanner.nextDouble();

        gerente.setNome(nome);
        gerente.setIdade(idade);
        gerente.setSalarioBase(salarioBase);
        gerente.setBonus(bonus);
    }

    private static void editarDiretor(Diretor diretor) {
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo salário base: ");
        double salarioBase = scanner.nextDouble();
        System.out.print("Nova participação nos lucros: ");
        double participacaoLucros = scanner.nextDouble();

        diretor.setNome(nome);
        diretor.setIdade(idade);
        diretor.setSalarioBase(salarioBase);
        diretor.setParticipacaoLucros(participacaoLucros);
    }

    private static void editarOperador(Operador operador) {
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo salário base: ");
        double salarioBase = scanner.nextDouble();
        System.out.print("Novas horas extras: ");
        double horasExtras = scanner.nextDouble();

        operador.setNome(nome);
        operador.setIdade(idade);
        operador.setSalarioBase(salarioBase);
        operador.setHorasExtras(horasExtras);
    }

    private static Funcionario encontrarFuncionarioPorID(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionarios.indexOf(funcionario) + 1 == id) {
                return funcionario;
            }
        }
        return null;
    }
}
