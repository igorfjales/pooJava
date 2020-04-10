package UI;

import Controlador.Fachada;
import Modelo.Aluno;
import Modelo.Trabalho;
import excecoes.ProfessorException;

import java.util.Scanner;

class UiProfessor {

    private Scanner s = new Scanner(System.in);

    void MenuProfessor() {

        int menu;
        do {
            System.out.println("Digite: \n1: Para alterar notas dos alunos. " +
                    "\n2: Para mandar trabalhos. \n3: Para remover trabalhos. " +
                    "\n4: Pesquisar aluno pelo codigo. \n5: Remover trabalho pelo prazo. " +
                    "\n6: Substituir trabalho. \n7: Passar todos os alunos com média maior que 7. \n0: Sair. ");
            menu = s.nextInt();

            switch (menu) {

                case 1:
                    AlterarNotas();
                    break;
                case 2:
                    MandarTrabalho();
                    break;

                case 3:
                    RemoverTrabalhoC();
                    break;
                case 4:
                    PesquisarAlunoCodigo();
                    break;
                case 5:
                    RemoverTrabalhoP();
                    break;
                case 6:
                    TrocarTrabalho();
                    break;
                case 7:
                    PassarAlunosAno();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Digite uma opção válida: ");
                    break;
            }
        } while (menu != 0);
    }

    private void PassarAlunosAno() {
        Fachada.getInstancia().passarAlunosAno();
        System.out.println("Alunos atualizados. \n");
    }

    Trabalho CriarTrabalho() {
        Trabalho trabalho = new Trabalho();
        System.out.println("Digite o codigo que do trabalho: ");
        trabalho.setCodigo(s.next());

        System.out.println("Digite o conteúdo do trabalho que você deseja mandar: ");
        trabalho.setConteudo(s.next());

        System.out.println("Digite o prazo em dias para que o trabalho seja entregue: ");
        trabalho.setPrazo(s.nextInt());


        return trabalho;
    }

    private void TrocarTrabalho() {
        try {
            Trabalho trabalho = CriarTrabalho();
            Fachada.getInstancia().substituirT(trabalho);
            System.out.println("Trabalho substituido com sucesso. \n");
        } catch (ProfessorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverTrabalhoC() {
        String codigo;
        System.out.println("Digite o codigo do trabalho para ser removido: ");
        codigo = s.next();

        try {
            Fachada.getInstancia().removerTrabalho(codigo);
            System.out.println("Trabalho removido com sucesso. \n");
        } catch (ProfessorException e) {
            System.out.println(e.getMessage());
        }

    }

    private void RemoverTrabalhoP() {
        int prazo;
        System.out.println("Digite o prazo dos trabalhos que devem ser removidos: ");
        prazo = s.nextInt();

        try {
            Fachada.getInstancia().removerTrabalho(prazo);
            System.out.println("Trabalho removido com sucesso. \n ");
        } catch (ProfessorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void MandarTrabalho() {

        Trabalho trabalho = CriarTrabalho();
        try {
            Fachada.getInstancia().mandarTrabalho(trabalho);
            System.out.println("Trabalho inserido com sucesso. \n");
        } catch (ProfessorException e) {
            System.out.println(e.getMessage());
        }


    }

    private void AlterarNotas() {
        String codigo;

        System.out.println("Digite o codigo do aluno desejado para alterar sua nota: ");
        codigo = s.next();

        System.out.println("Digite a displina para mudar a nota:\n1-Matemática" +
                "\n2-Português\n3-Biologia\n4-Química\n5-Física ");
        int materia = s.nextInt();

        System.out.println("Digite a nota: ");
        double nota = s.nextDouble();

        System.out.println("Digite a nota que você deseja mudar, 1, 2 ou 3. ");
        int unidade = s.nextInt();

        try {
            Fachada.getInstancia().alterarNotas(codigo, nota, unidade, materia);
            System.out.println("Nota alterada com sucesso. \n");
        } catch (ProfessorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void PesquisarAlunoCodigo() {
        try {
            System.out.println("Insira o código: ");
            Aluno t;
            t = Fachada.getInstancia().pesquisarAlunoCodigo(s.next());
            System.out.println("Nome: " + t.getNome());
            System.out.println("Idade: " + t.getIdade());
            System.out.println("Sexo: " + t.getSexo());
            System.out.println("Serie: " + t.getSerie() + "\n");
        } catch (ProfessorException e) {
            System.out.println(e.getMessage());
        }
    }
}
