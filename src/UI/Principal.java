package UI;

import java.util.Scanner;

class Principal {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int menu;

        do {
            System.out.println("Digite: \n1: Menu aluno. " +
                    "\n2: Menu funcionário. \n3: Menu Dono\n0: Sair. ");
            menu = s.nextInt();

            switch (menu) {

                case 1:
                    UiAluno uiAluno = new UiAluno();
                    uiAluno.MenuAluno();
                    break;

                case 2:
                    UiFuncionario uiFuncionario = new UiFuncionario();
                    uiFuncionario.MenuFuncionario();
                    break;
                case 3:
                    UiDono uiDono = new UiDono();
                    uiDono.MenuDono();
                case 0:
                    System.out.println("Obrigado por utilizar o programa. ");
                    break;

                default:
                    System.out.println("Insira uma opção válida. ");
            }
        } while (menu != 0);
    }

}