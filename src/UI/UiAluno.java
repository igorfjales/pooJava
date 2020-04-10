package UI;

import Controlador.Fachada;
import Modelo.Boletim;
import Modelo.Professor;
import Modelo.Trabalho;
import excecoes.AlunoException;
import excecoes.ProfessorException;
import excecoes.SalaException;

import java.util.Scanner;

class UiAluno {
    private static Scanner s = new Scanner(System.in);

    void MenuAluno() {
        int menu;
        do {
            System.out.println("Digite: \n1: Para checar as notas. " +
                    "\n2: Para mostrar os trabalhos.\n3: Para pesquisar Professor " +
                    "\n4: Alugar Sala. \n5: Devolver Sala. \n0: Para sair.  ");
            menu = s.nextInt();
            switch (menu) {
                case 1:
                    checarNotas();
                    break;
                case 2:
                    MostrarTrabalhos();
                    break;
                case 3:
                    PesquisarProfessor();
                    break;
                case 4:
                    alugarSala();
                    break;
                case 5:
                    DevolverSala();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Obrigado por utilizar. ");
                    break;
            }

        } while (menu != 0);


    }

    private void DevolverSala() {
        try {
            System.out.println("Digite o codigo da sala que você deseja devolver: ");
            int codigo = s.nextInt();
            Fachada.getInstancia().devolverSala(codigo);
            System.out.println("Sala devolvida com sucesso!");
        } catch (SalaException e) {
            System.out.println(e.getMessage());
        }
    }

    private void MostrarTrabalhos() {
        String codigo;

        System.out.println("Digite o codigo do trabalho que voce deseja consultar: ");
        codigo = s.next();

        try {
            Trabalho t;
            t = Fachada.getInstancia().mostrarTrabalhos(codigo);


            System.out.println("Conteúdo do trabalho: " + t.getConteudo());
            System.out.println("Prazo: " + t.getPrazo());
            System.out.println("Codigo do trabalho: " + t.getCodigo());

        } catch (AlunoException | ProfessorException e) {
            System.out.println(e.getMessage());
        }

    }

    private void PesquisarProfessor() {
        try {
            System.out.println("Digite o codigo do professor: ");
            Professor p;
            p = Fachada.getInstancia().pesquisarProfessorCodigo(s.next());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Disciplina: " + p.getDisciplina());
            System.out.println("Sexo: " + p.getSexo());
            System.out.println("Idade: " + p.getIdade());
        } catch (AlunoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void alugarSala() {
        try {
            System.out.println("Qual tipo de sala vai ser usada? \n1: Auditorio\n2: Informática\n3: Comum ");
            int tipo = s.nextInt();
            int codigo = Fachada.getInstancia().alugarSala(tipo);
            System.out.println("Sala alugada com sucesso. \n" +
                    "O código da sala é: " + codigo);
        } catch (SalaException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void checarNotas() {
        System.out.println("Qual matéria voce deseja ver as notas:\n1-Matemática" +
                "\n2-Português\n3-Biologia\n4-Química\n5-Física ");
        int materia = s.nextInt();
        System.out.println("Digite seu código de aluno:");
        String codigo = s.next();
        Boletim boletim;
        Double[] n;
        try {
            boletim = Fachada.getInstancia().checarNotas(materia, codigo);
            switch (materia) {
                case 1:
                    n = boletim.getMatematica().getNota();
                    for (int i = 0; i < boletim.getMatematica().getNota().length; i++) {
                        System.out.println((i + 1) + "ª Unidade: " + n[i]);
                    }
                    if (boletim.getMatematica().getMedia() != null) {
                        System.out.println("Media: " + boletim.getMatematica().getMedia());
                        if (boletim.getMatematica().isAprovado()) {
                            System.out.println("Estado: Aprovado por média. ");
                        } else {
                            System.out.println("Estado: Reprovado. ");
                        }
                    } else {
                        System.out.println("Média disponível apenas com as 3 notas. ");
                    }
                    break;
                case 2:
                    n = boletim.getPortugues().getNota();
                    for (int i = 0; i < boletim.getPortugues().getNota().length; i++) {
                        System.out.println((i + 1) + "ª Unidade: " + n[i]);
                    }
                    if (boletim.getPortugues().getMedia() != null) {
                        System.out.println("Media: " + boletim.getPortugues().getMedia());
                        if (boletim.getPortugues().isAprovado()) {
                            System.out.println("Estado: Aprovado por média. ");
                        } else {
                            System.out.println("Estado: Reprovado. ");
                        }
                    } else {
                        System.out.println("Média disponível apenas com as 3 notas. ");
                    }
                    break;
                case 3:
                    n = boletim.getBiologia().getNota();
                    for (int i = 0; i < boletim.getBiologia().getNota().length; i++) {
                        System.out.println((i + 1) + "ª Unidade: " + n[i]);
                    }
                    if (boletim.getBiologia().getMedia() != null) {
                        System.out.println("Media: " + boletim.getBiologia().getMedia());
                        if (boletim.getBiologia().isAprovado()) {
                            System.out.println("Estado: Aprovado por média. ");
                        } else {
                            System.out.println("Estado: Reprovado. ");
                        }
                    } else {
                        System.out.println("Média disponível apenas com as 3 notas. ");
                    }
                    break;
                case 4:
                    n = boletim.getQuimica().getNota();
                    for (int i = 0; i < boletim.getQuimica().getNota().length; i++) {
                        System.out.println((i + 1) + "ª Unidade: " + n[i]);
                    }
                    if (boletim.getQuimica().getMedia() != null) {
                        System.out.println("Media: " + boletim.getQuimica().getMedia());
                        if (boletim.getQuimica().isAprovado()) {
                            System.out.println("Estado: Aprovado por média. ");
                        } else {
                            System.out.println("Estado: Reprovado. ");
                        }
                    } else {
                        System.out.println("Média disponível apenas com as 3 notas. ");
                    }
                    break;
                case 5:
                    n = boletim.getFisica().getNota();
                    for (int i = 0; i < boletim.getFisica().getNota().length; i++) {
                        System.out.println((i + 1) + "ª Unidade: " + n[i]);
                    }
                    if (boletim.getFisica().getMedia() != null) {
                        System.out.println("Media: " + boletim.getFisica().getMedia());
                        if (boletim.getFisica().isAprovado()) {
                            System.out.println("Estado: Aprovado por média. ");
                        } else {
                            System.out.println("Estado: Reprovado. ");
                        }
                    } else {
                        System.out.println("Média disponível apenas com as 3 notas. ");
                    }
                    break;
                default:
                    System.out.println("Insira uma matéria válida!");
                    break;
            }
        } catch (AlunoException e) {
            System.out.println(e.getMessage());

        }
    }
}