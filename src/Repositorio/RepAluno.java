package Repositorio;

import Modelo.Aluno;
import Modelo.Boletim;
import Modelo.Endereco;

import java.util.ArrayList;
import java.util.List;

public class RepAluno implements IRepAluno {
    private static RepAluno instancia;
    private List<Aluno> listaAluno;

    private RepAluno() {
        listaAluno = new ArrayList<>();
    }

    public static RepAluno getInstancia() {
        if (instancia == null) {
            instancia = new RepAluno();
        }
        return instancia;
    }

    @Override

    public void inserirAluno(Aluno aluno) {
        listaAluno.add(aluno);
    }

    @Override

    public Aluno pesquisarAlunoCodigo(String codigo) {
        for (Aluno aluno : listaAluno) {
            if (aluno != null && aluno.getCodigo().equalsIgnoreCase(codigo)) {
                aluno.setCpf(null);
                return aluno;
            }
        }
        return null;
    }

    @Override
    public Aluno pesquisarAlunoCodigo(String codigo, String cpf) {
        for (Aluno aluno : listaAluno) {
            if (aluno != null && aluno.getCodigo().equalsIgnoreCase(codigo) && aluno.getCpf().equalsIgnoreCase(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    public void removerEnderecoA(String codigo) {
        for (int i = 0; i < listaAluno.size(); i++) {
            if (listaAluno.get(i) != null && listaAluno.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaAluno.get(i).setEndereco(null);
            }
        }
    }

    @Override
    public boolean trocarEnderecoA(String codigo, Endereco endereco) {
        for (Aluno aluno : listaAluno) {
            if (aluno != null && aluno.getCodigo().equalsIgnoreCase(codigo) && aluno.getEndereco() != null) {
                aluno.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }

    @Override
    public void removerAlunoCodigo(String codigo) {
        for (int i = 0; i < listaAluno.size(); i++) {
            if (listaAluno.get(i) != null && listaAluno.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaAluno.remove(i);
            }
        }
    }

    public boolean existeAluno(String codigo) {
        for (Aluno aluno : listaAluno) {
            if (aluno != null && aluno.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void alterarNotas(String codigo, double nota, int unidade, int materia) {
        for (Aluno aluno : listaAluno) {
            if (aluno != null && aluno.getCodigo().equalsIgnoreCase(codigo)) {
                if (unidade == 1) {
                    switch (materia) {
                        case 1:
                            aluno.getBoletim().getMatematica().setNota1(nota);
                            break;
                        case 2:
                            aluno.getBoletim().getPortugues().setNota1(nota);
                            break;
                        case 3:
                            aluno.getBoletim().getBiologia().setNota1(nota);
                            break;
                        case 4:
                            aluno.getBoletim().getQuimica().setNota1(nota);
                            break;
                        case 5:
                            aluno.getBoletim().getFisica().setNota1(nota);
                            break;
                    }
                } else if (unidade == 2) {
                    switch (materia) {
                        case 1:
                            aluno.getBoletim().getMatematica().setNota2(nota);
                            break;
                        case 2:
                            aluno.getBoletim().getPortugues().setNota2(nota);
                            break;
                        case 3:
                            aluno.getBoletim().getBiologia().setNota2(nota);
                            break;
                        case 4:
                            aluno.getBoletim().getQuimica().setNota2(nota);
                            break;
                        case 5:
                            aluno.getBoletim().getFisica().setNota2(nota);
                            break;
                    }
                } else if (unidade == 3) {
                    switch (materia) {
                        case 1:
                            aluno.getBoletim().getMatematica().setNota3(nota);
                            break;
                        case 2:
                            aluno.getBoletim().getPortugues().setNota3(nota);
                            break;
                        case 3:
                            aluno.getBoletim().getBiologia().setNota3(nota);
                            break;
                        case 4:
                            aluno.getBoletim().getQuimica().setNota3(nota);
                            break;
                        case 5:
                            aluno.getBoletim().getFisica().setNota3(nota);
                            break;
                    }
                }
            }
        }
        alterarMedia(codigo, materia);
    }

    private void alterarMedia(String codigo, int materia) {
        for (Aluno aluno : listaAluno) {
            if (aluno != null && aluno.getCodigo().equalsIgnoreCase(codigo)) {
                switch (materia) {
                    case 1:
                        if ((aluno.getBoletim().getMatematica().getNota1() != null) && (aluno.getBoletim().getMatematica().getNota2() != null) && (aluno.getBoletim().getMatematica().getNota3() != null)) {
                            aluno.getBoletim().getMatematica().setMedia((aluno.getBoletim().getMatematica().getNota1() + aluno.getBoletim().getMatematica().getNota2() + aluno.getBoletim().getMatematica().getNota3()) / 3);
                        }
                        if ((aluno.getBoletim().getMatematica().getMedia() != null) && aluno.getBoletim().getMatematica().getMedia() >= 7) {
                            aluno.getBoletim().getMatematica().setAprovado(true);
                        } else {
                            aluno.getBoletim().getMatematica().setAprovado(false);
                        }
                        break;
                    case 2:
                        if ((aluno.getBoletim().getPortugues().getNota1() != null) && (aluno.getBoletim().getPortugues().getNota2() != null) && (aluno.getBoletim().getPortugues().getNota3() != null)) {
                            aluno.getBoletim().getPortugues().setMedia((aluno.getBoletim().getPortugues().getNota1() + aluno.getBoletim().getPortugues().getNota2() + aluno.getBoletim().getPortugues().getNota3()) / 3);
                        }
                        if ((aluno.getBoletim().getPortugues().getMedia() != null) && aluno.getBoletim().getPortugues().getMedia() >= 7) {
                            aluno.getBoletim().getPortugues().setAprovado(true);
                        } else {
                            aluno.getBoletim().getPortugues().setAprovado(false);
                        }
                        break;
                    case 3:
                        if ((aluno.getBoletim().getBiologia().getNota1() != null) && (aluno.getBoletim().getBiologia().getNota2() != null) && (aluno.getBoletim().getBiologia().getNota3() != null)) {
                            aluno.getBoletim().getBiologia().setMedia((aluno.getBoletim().getBiologia().getNota1() + aluno.getBoletim().getBiologia().getNota2() + aluno.getBoletim().getBiologia().getNota3()) / 3);
                        }
                        if ((aluno.getBoletim().getBiologia().getMedia() != null) && aluno.getBoletim().getBiologia().getMedia() >= 7) {
                            aluno.getBoletim().getBiologia().setAprovado(true);
                        } else {
                            aluno.getBoletim().getBiologia().setAprovado(false);
                        }
                        break;
                    case 4:
                        if ((aluno.getBoletim().getQuimica().getNota1() != null) && (aluno.getBoletim().getQuimica().getNota2() != null) && (aluno.getBoletim().getQuimica().getNota3() != null)) {
                            aluno.getBoletim().getQuimica().setMedia((aluno.getBoletim().getQuimica().getNota1() + aluno.getBoletim().getQuimica().getNota2() + aluno.getBoletim().getQuimica().getNota3()) / 3);
                        }
                        if ((aluno.getBoletim().getQuimica().getMedia() != null) && aluno.getBoletim().getQuimica().getMedia() >= 7) {
                            aluno.getBoletim().getQuimica().setAprovado(true);
                        } else {
                            aluno.getBoletim().getQuimica().setAprovado(false);
                        }
                        break;
                    case 5:
                        if ((aluno.getBoletim().getFisica().getNota1() != null) && (aluno.getBoletim().getFisica().getNota2() != null) && (aluno.getBoletim().getFisica().getNota3() != null)) {
                            aluno.getBoletim().getFisica().setMedia((aluno.getBoletim().getFisica().getNota1() + aluno.getBoletim().getFisica().getNota2() + aluno.getBoletim().getFisica().getNota3()) / 3);
                        }
                        if ((aluno.getBoletim().getFisica().getMedia() != null) && aluno.getBoletim().getFisica().getMedia() >= 7) {
                            aluno.getBoletim().getFisica().setAprovado(true);
                        } else {
                            aluno.getBoletim().getFisica().setAprovado(false);
                        }
                        break;
                }
            }
        }
    }

    public Aluno checarNotas(String codigo) {
        for (Aluno aluno : listaAluno) {
            if (aluno != null && aluno.getCodigo().equalsIgnoreCase(codigo)) {
                return aluno;
            }
        }
        return null;
    }

    public boolean inserirEnderecoAluno(Endereco endereco, String codigo) {
        for (Aluno aluno : listaAluno) {
            if (aluno != null && aluno.getCodigo().equalsIgnoreCase(codigo) && aluno.getEndereco() == null) {
                aluno.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }

    @Override
    public void passarAlunosAno() {
        for (Aluno aluno : listaAluno) {
            if (aluno != null && aluno.getSerie() <= 2) {
                if (aluno.getBoletim().getFisica().isAprovado() && aluno.getBoletim().getQuimica().isAprovado() &&
                        aluno.getBoletim().getBiologia().isAprovado() && aluno.getBoletim().getPortugues().isAprovado()
                        && aluno.getBoletim().getMatematica().isAprovado()) {
                    aluno.setSerie(aluno.getSerie() + 1);
                    aluno.setBoletim(new Boletim());
                }
            } else {
                listaAluno.remove(aluno);
            }
        }
    }

    @Override
    public boolean checarSerie(Aluno a) {
        if (a.getSerie() <= 1 || a.getSerie() >= 3) {
            return false;
        }
        return true;
    }
}
