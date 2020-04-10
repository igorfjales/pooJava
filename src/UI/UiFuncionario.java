package UI;

import java.util.Scanner;

class UiFuncionario {
    private static Scanner s = new Scanner(System.in);

    void MenuFuncionario() {
        int menu;
        do {
            System.out.println("Digite: \n1: Professor \n2: Diretor\n0: Sair ");
            menu = s.nextInt();
            switch (menu) {

                case 1:
                    UiProfessor uiProfessor = new UiProfessor();
                    uiProfessor.MenuProfessor();
                    break;

                case 2:
                    UiDiretor uiDiretor = new UiDiretor();
                    uiDiretor.MenuDiretor();

                case 0:
                    break;
                default:
                    System.out.println("Digite uma opção válida. ");
                    break;
            }
        } while (menu != 0);
    }
}
