package Repositorio;

import Modelo.SalaAuditorio;
import Modelo.SalaComum;
import Modelo.SalaInformatica;

public class RepSala implements IRepSala {

    private static RepSala instancia;
    private SalaComum[] arraySalaC = new SalaComum[3];
    private SalaAuditorio[] arraySalaA = new SalaAuditorio[3];
    private SalaInformatica[] arraySalaI = new SalaInformatica[3];

    private RepSala() {
        for (int i = 0; i <= 2; i++) {
            arraySalaC[i] = new SalaComum();
            arraySalaA[i] = new SalaAuditorio();
            arraySalaI[i] = new SalaInformatica();
        }
    }


    public static IRepSala getInstancia() {
        if (instancia == null) {
            instancia = new RepSala();
        }
        return instancia;
    }


    @Override
    public int alugarSala(int codigo) {
        switch (codigo) {
            case 1:
                for (int i = 0; i <= 2; i++) {
                    if (!arraySalaA[i].getOcupada()) {
                        arraySalaA[i].setOcupada(true);
                        arraySalaA[i].setCodigo(i);
                        return arraySalaA[i].getCodigo();
                    }
                }
                break;
            case 2:
                int j = 3;
                for (int i = 0; i <= 2; i++) {
                    if (!arraySalaI[i].getOcupada()) {
                        arraySalaI[i].setOcupada(true);
                        arraySalaI[i].setCodigo(j);
                        return arraySalaI[i].getCodigo();
                    }
                    j++;
                }
                break;
            case 3:
                int k = 5;
                for (int i = 0; i <= 2; i++) {
                    if (!arraySalaC[i].getOcupada()) {
                        arraySalaC[i].setOcupada(true);
                        arraySalaC[i].setCodigo(k);
                        return arraySalaC[i].getCodigo();
                    }
                    k++;
                }
                break;
        }
        return 0;
    }

    @Override
    public void devolverSala(int codigo, int opcao) {
        switch (opcao) {
            case 1:
                for (int i = 0; i <= 2; i++) {
                    if (arraySalaA[i].getOcupada() && arraySalaA[i].getCodigo() == codigo) {
                        arraySalaA[i].setOcupada(false);
                        break;
                    }
                }
            case 2:
                for (int i = 0; i <= 2; i++) {
                    if (arraySalaI[i].getOcupada() && arraySalaI[i].getCodigo() == codigo) {
                        arraySalaI[i].setOcupada(false);
                        break;
                    }
                }
            case 3:
                for (int i = 0; i <= 2; i++) {
                    if (arraySalaC[i].getOcupada() && arraySalaC[i].getCodigo() == codigo) {
                        arraySalaC[i].setOcupada(false);
                        break;
                    }
                }
        }
    }

    public boolean verificaSala(int codigo) {
        switch (codigo) {
            case 1:
                for (int i = 0; i <= 2; i++) {
                    if (!arraySalaA[i].getOcupada()) {
                        return true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i <= 2; i++) {
                    if (!arraySalaI[i].getOcupada()) {
                        return true;
                    }
                }
                break;
            case 3:
                for (int i = 0; i <= 2; i++) {
                    if (!arraySalaC[i].getOcupada()) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }


}


