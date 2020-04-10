package Repositorio;

import Modelo.Endereco;
import Modelo.Professor;

import java.util.ArrayList;
import java.util.List;

public class RepProfessor implements IRepProfessor {

    private static RepProfessor instancia;
    private List<Professor> listaProfessor;

    private RepProfessor() {
        listaProfessor = new ArrayList<>();
    }

    public static RepProfessor getInstancia() {
        if (instancia == null) {
            instancia = new RepProfessor();
        }
        return instancia;
    }

    @Override
    public void inserirProfessor(Professor professor) {
        listaProfessor.add(professor);
    }

    public void trocarProfessor(String codigo, Professor novoProfessor) {
        for (int i = 0; i < listaProfessor.size(); i++) {
            if (listaProfessor.get(i) != null && listaProfessor.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaProfessor.remove(i);
                listaProfessor.add(novoProfessor);
            }
        }
    }

    @Override
    public Professor pesquisarProfessorCodigo(String codigo) {
        for (Professor professor : listaProfessor) {
            if (professor != null && professor.getCodigo().equalsIgnoreCase(codigo)) {
                professor.setCpf(null);
                professor.setCargaH(0);
                professor.setSalario(0);
                return professor;
            }
        }
        return null;
    }

    @Override
    public Professor pesquisarProfessorCodigo(String codigo, String cpf) {
        for (Professor professor : listaProfessor) {
            if (professor != null && professor.getCodigo().equalsIgnoreCase(codigo) && professor.getCodigo().equalsIgnoreCase(cpf)) {
                return professor;
            }
        }
        return null;
    }

    public boolean existeProfessor(String codigo) {
        for (Professor professor : listaProfessor) {
            if (professor != null && professor.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removerProfessorCodigo(String codigo) {
        for (int i = 0; i < listaProfessor.size(); i++) {
            if (listaProfessor.get(i) != null && listaProfessor.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaProfessor.remove(i);
            }
        }
    }

    @Override
    public void aumentarSalario(String codigo) {
        for (Professor professor : listaProfessor) {
            if (professor != null && professor.getCodigo().equalsIgnoreCase(codigo)) {
                professor.setSalario(professor.getSalario() + (professor.getSalario() * 0.1));
            }
        }
    }

    public void aumentarSalario(String codigo, double quantidade) {
        for (Professor professor : listaProfessor) {
            if (professor != null && professor.getCodigo().equalsIgnoreCase(codigo)) {
                professor.setSalario(professor.getSalario() + quantidade);
            }
        }
    }

    public void removerEnderecoP(String codigo) {
        for (int i = 0; i < listaProfessor.size(); i++) {
            if (listaProfessor.get(i) != null && listaProfessor.get(i).getCodigo().equalsIgnoreCase(codigo) && listaProfessor.get(i).getEndereco() != null) {
                listaProfessor.get(i).setEndereco(null);
            }
        }
    }

    @Override
    public boolean trocarEnderecoP(String codigo, Endereco endereco) {
        for (Professor professor : listaProfessor) {
            if (professor != null && professor.getCodigo().equalsIgnoreCase(codigo) && professor.getEndereco() != null) {
                professor.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }


    public boolean inserirEnderecoProfessor(Endereco endereco, String codigo) {
        for (Professor professor : listaProfessor) {
            if (professor != null && professor.getCodigo().equalsIgnoreCase(codigo) && professor.getEndereco() == null) {
                professor.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }
}
