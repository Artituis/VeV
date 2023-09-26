package com.example;

public class CentroDistribuicao {
    public enum SITUACAO {
        NORMAL, SOBRAVISO, EMERGENCIA
    }

    public enum TIPOPOSTO {
        COMUM, ESTRATEGICO
    }

    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    private int tAditivo;
    private int tGasolina;
    private int tAlcool;

    private SITUACAO situacao;

    public CentroDistribuicao(int tAditivo, int tGasolina, int tAlcool) {
        if (tAditivo < 0 || tAditivo > MAX_ADITIVO || tGasolina < 0 || tGasolina > MAX_GASOLINA || tAlcool < 0
                || tAlcool > MAX_ALCOOL) {
            throw new IllegalArgumentException();
        }
        this.tAditivo = tAditivo;
        this.tGasolina = tGasolina;
        this.tAlcool = tAlcool;
        defineSituacao();
    }

    public void defineSituacao() {
        if (tAditivo < 0 || tAditivo > MAX_ADITIVO || tGasolina < 0 || tGasolina > MAX_GASOLINA || tAlcool < 0
                || tAlcool > MAX_ALCOOL) {
            throw new IllegalArgumentException();
        }

        if (tAditivo < 0.25 * MAX_ADITIVO || tGasolina < 0.25 * MAX_GASOLINA || tAlcool < 0.25 * MAX_ALCOOL) {
            situacao = SITUACAO.EMERGENCIA;
        } else if (tAditivo < 0.5 * MAX_ADITIVO || tGasolina < 0.5 * MAX_GASOLINA || tAlcool < 0.5 * MAX_ALCOOL) {
            situacao = SITUACAO.SOBRAVISO;
        } else {
            situacao = SITUACAO.NORMAL;
        }

    }

    public SITUACAO getSituacao() {
        return situacao;
    }

    public int gettGasolina() {
        return tGasolina;
    }

    public int gettAditivo() {
        return tAditivo;
    }

    public int gettAlcool() {
        return tAlcool;
    }

    public int recebeAditivo(int qtdade) {
        if (qtdade < 0) {
            return -1;
        }
        if (tAditivo + qtdade > MAX_ADITIVO) {
            int sobrou = tAditivo + qtdade - MAX_ADITIVO;
            tAditivo = MAX_ADITIVO;
            defineSituacao();

            return qtdade - sobrou;
        }
        tAditivo += qtdade;
        defineSituacao();
        return qtdade;
    }

    public int recebeGasolina(int qtdade) {
        if (qtdade < 0) {
            return -1;
        }
        if (tGasolina + qtdade > MAX_GASOLINA) {
            int sobrou = tGasolina + qtdade - MAX_GASOLINA;
            tGasolina = MAX_GASOLINA;
            defineSituacao();

            return qtdade - sobrou;
        }
        tGasolina += qtdade;
        defineSituacao();

        return qtdade;
    }

    public int recebeAlcool(int qtdade) {
        if (qtdade < 0) {
            return -1;
        }
        if (tAlcool + qtdade > MAX_ALCOOL) {
            int sobrou = tAlcool + qtdade - MAX_ALCOOL;
            tAlcool = MAX_ALCOOL;
            defineSituacao();
            return qtdade - sobrou;
        }
        tAlcool += qtdade;
        defineSituacao();

        return qtdade;
    }

    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {

        int qtdadeAditivo = (int) (qtdade * 0.05);
        int qtdadeGasolina = (int) (qtdade * 0.7);
        int qtdadeAlcool = (int) (qtdade * 0.25);

        if (qtdade < 0 || tipoPosto == null) {
            return new int[] { -7 };
        }

        if (tipoPosto == TIPOPOSTO.COMUM && situacao == SITUACAO.EMERGENCIA) {
            return new int[] { -14 };
        } else if ((tipoPosto == TIPOPOSTO.COMUM && situacao == SITUACAO.SOBRAVISO)
                || situacao == SITUACAO.EMERGENCIA) {
            qtdadeAditivo = (int) (qtdadeAditivo * 0.5);
            qtdadeGasolina = (int) (qtdadeGasolina * 0.5);
            qtdadeAlcool = (int) (qtdadeAlcool * 0.5);
        }

        if (qtdadeAditivo > tAditivo || qtdadeGasolina > tGasolina || qtdadeAlcool > tAlcool) {
            return new int[] { -21 };
        } else {
            tAditivo -= qtdadeAditivo;
            tGasolina -= qtdadeGasolina;
            tAlcool -= qtdadeAlcool;
            defineSituacao();

            return new int[] { tAditivo, tGasolina, tAlcool };
        }

    }
}