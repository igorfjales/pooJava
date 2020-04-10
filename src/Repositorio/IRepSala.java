package Repositorio;

public interface IRepSala {

    int alugarSala(int tipo);

    boolean verificaSala(int codigo);

    void devolverSala(int codigo, int opcao);
}
