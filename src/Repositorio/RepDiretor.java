package Repositorio;

import Modelo.Diretor;
import Modelo.Endereco;

import java.util.ArrayList;
import java.util.List;

public class RepDiretor implements IRepDiretor {

    private static RepDiretor instancia;
    private List<Diretor> listaDiretor;

    private RepDiretor() {
        listaDiretor = new ArrayList<>();
    }

    public static RepDiretor getInstancia() {
        if (instancia == null) {
            instancia = new RepDiretor();
        }
        return instancia;
    }

    public void substituirDiretor(String codigo, Diretor novoDiretor) {
        for (int i = 0; i < listaDiretor.size(); i++) {
            if (listaDiretor.get(i) != null && listaDiretor.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaDiretor.remove(i);

                listaDiretor.add(novoDiretor);
            }
        }
    }

    public void inserirDiretor(Diretor diretor) {
        listaDiretor.add(diretor);
    }

    public boolean existeDiretor(String codigo) {
        for (Diretor diretor : listaDiretor) {
            if (diretor != null && diretor.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removerDiretorCodigo(String codigo) {
        for (int i = 0; i < listaDiretor.size(); i++) {
            if (listaDiretor.get(i) != null && listaDiretor.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaDiretor.remove(i);
            }
        }
    }

    public void removerEnderecoD(String codigo) {
        for (int i = 0; i < listaDiretor.size(); i++) {
            if (listaDiretor.get(i) != null && listaDiretor.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaDiretor.get(i).setEndereco(null);
            }
        }
    }

    @Override
    public Diretor PesquisarDiretorCodigo(String codigo, String cpf) {
        for (Diretor diretor : listaDiretor) {
            if (diretor != null && diretor.getCodigo().equalsIgnoreCase(codigo) && diretor.getCodigo().equalsIgnoreCase(cpf)) {
                return diretor;
            }
        }
        return null;
    }

    @Override
    public boolean TrocarEndD(String codigo, Endereco endereco) {
        for (Diretor diretor : listaDiretor) {
            if (diretor != null && diretor.getCodigo().equalsIgnoreCase(codigo) && diretor.getEndereco() != null) {
                diretor.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean inserirEnderecoDiretor(Endereco endereco, String codigo) {
        for (Diretor diretor : listaDiretor) {
            if (diretor != null && diretor.getCodigo().equalsIgnoreCase(codigo) && diretor.getEndereco() == null) {
                diretor.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }

    @Override
    public void AtualizarSalarioDiretor(String codigo, Double novoSalario) {
        for (Diretor diretor : listaDiretor) {
            if (diretor != null && diretor.getCodigo().equalsIgnoreCase(codigo)) {
                diretor.setSalario(novoSalario);
            }
        }
    }

    @Override
    public void aumentarSalarioD(String codigo) {
        for (Diretor diretor : listaDiretor) {
            if (diretor != null && diretor.getCodigo().equalsIgnoreCase(codigo)) {
                diretor.setSalario(diretor.getSalario() + (diretor.getSalario() * 0.1));
            }
        }
    }
}


