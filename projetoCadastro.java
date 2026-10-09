import java.util.Scanner;

public class CadastroUsuario {

    static class Usuario {
        private String nome;
        private String mesAniversario;
        private String cidade;

        public Usuario(String nome, String mesAniversario, String cidade) {
            this.nome = nome;
            this.mesAniversario = mesAniversario;
            this.cidade = cidade;
        }

        public String getNome() {
            return nome;
        }

        public String getMesAniversario() {
            return mesAniversario;
        }

        public String getCidade() {
            return cidade;
        }
    }

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        List<Usuario> listaUsuarios = new ArrayList<>();
        int opcao = -1;

        do {
            System.out.println("\n=================================");
            System.out.println("       SISTEMA DE CADASTRO       ");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("0 - Encerrar");
            System.out.println("=================================");
            System.out.print("Escolha uma opção: ");

            if (Scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                Scanner.nextLine();
            } else {
                System.out.println("\n[ERRO] Opção inválida! Por favor, digite apenas números.");
                Scanner.nextLine(); 
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n--- NOVO CADASTRO ---");
                    System.out.print("Digite o seu nome: ");
                    String nome = Scanner.nextLine().trim();

                    System.out.print("Digite o seu mês de aniversário: ");
                    String mesAniversario = Scanner.nextLine().trim();

                    System.out.print("Digite a cidade onde você mora: ");
                    String cidade = Scanner.nextLine().trim();

                    if (!nome.isEmpty() && !mesAniversario.isEmpty() && !cidade.isEmpty()) {
                        listaUsuarios.add(new Usuario(nome, mesAniversario, cidade));
                        System.out.println("\n[SUCESSO] Usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("\n[ERRO] Todos os campos devem ser preenchidos. Cadastro não realizado.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE USUÁRIOS CADASTRADOS ---");
                    if (listaUsuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado até o momento.");
                    } else {
                        for (int i = 0; i < listaUsuarios.size(); i++) {
                            Usuario u = listaUsuarios.get(i);
                            System.out.println("\nUsuário #" + (i + 1));
                            System.out.println("  Nome: " + u.getNome());
                            System.out.println("  Mês de Aniversário: " + u.getMesAniversario());
                            System.out.println("  Cidade onde mora: " + u.getCidade());
                        }
                    }
                    break;

                case 0:
                    System.out.println("\nEncerrando o programa... Até logo!");
                    break;

                default:
                    System.out.println("\n[ERRO] Opção inválida! Escolha uma das opções do menu (1, 2 ou 0).");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}