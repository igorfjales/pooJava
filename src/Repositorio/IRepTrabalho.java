package Repositorio;

import Modelo.Trabalho;

public interface IRepTrabalho {

    void mandarTrabalho(Trabalho trabalho);

    boolean existeTrabalho(String codigo);

    void removerTrabalho(String codigo);

    void removerTrabalho(int prazo);

    Trabalho mostrarTrabalho(String codigo);

    void substituirT(Trabalho t);
}
