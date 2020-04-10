package Repositorio;

import Modelo.Trabalho;

import java.util.ArrayList;
import java.util.List;

public class RepTrabalho implements IRepTrabalho {

    private static RepTrabalho instancia;
    private List<Trabalho> listaTrabalho;

    private RepTrabalho() {
        listaTrabalho = new ArrayList<>();
    }

    public static RepTrabalho getInstancia() {
        if (instancia == null) {
            instancia = new RepTrabalho();
        }
        return instancia;
    }

    @Override
    public void mandarTrabalho(Trabalho trabalho) {
        listaTrabalho.add(trabalho);

    }

    public boolean existeTrabalho(int prazo) {
        for (Trabalho trabalho : listaTrabalho) {
            if (trabalho != null && trabalho.getPrazo() == prazo) {
                return true;
            }
        }
        return false;
    }

    public boolean existeTrabalho(String codigo) {
        for (Trabalho trabalho : listaTrabalho) {
            if (trabalho != null && trabalho.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removerTrabalho(String codigo) {
        for (int i = 0; i < listaTrabalho.size(); i++) {
            if (listaTrabalho.get(i) != null && listaTrabalho.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaTrabalho.remove(i);
            }
        }

    }

    @Override
    public void removerTrabalho(int prazo) {
        for (int i = 0; i < listaTrabalho.size(); i++) {
            if (listaTrabalho.get(i) != null && listaTrabalho.get(i).getPrazo() == prazo) {
                listaTrabalho.remove(i);
            }
        }
    }

    @Override
    public Trabalho mostrarTrabalho(String codigo) {
        for (Trabalho trabalho : listaTrabalho) {
            if (trabalho != null && trabalho.getCodigo().equalsIgnoreCase(codigo)) {
                return trabalho;
            }
        }
        return null;
    }

    @Override
    public void substituirT(Trabalho t) {
        for (int i = 0; i < listaTrabalho.size(); i++) {
            if (listaTrabalho.get(i) != null && t.getCodigo().equalsIgnoreCase(listaTrabalho.get(i).getCodigo())) {
                listaTrabalho.remove(i);
                listaTrabalho.add(t);
            }
        }
    }

}


