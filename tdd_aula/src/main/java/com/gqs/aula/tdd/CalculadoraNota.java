package com.gqs.aula.tdd;

public class CalculadoraNota {

    public static final double NOTA_MINIMA_APROVACAO = 70;
    public static final double FREQUENCIA_MINIMA = 75;
    public static final double SOMA_MINIMA_PARA_AI = 40;
    public static final double NOTA_MAXIMA_AI = 30;
    public static final double NOTA_MINIMA = 0;

    public double calcularNotaFinal(double a1, double a2, double a3) {
        validarNota(a1, 30, "A1");
        validarNota(a2, 30, "A2");
        validarNota(a3, 40, "A3");
        return a1 + a2 + a3;
    }

    public boolean estaAprovadoPorNota(double notaFinal) {
        return notaFinal >= NOTA_MINIMA_APROVACAO;
    }

    public String situacao(double notaFinal, double frequencia) {
        if (estaAprovadoPorNota(notaFinal) && frequencia >= FREQUENCIA_MINIMA) {
            return "APROVADO";
        }
        return "REPROVADO";
    }

    public boolean podeFazerAI(double a1, double a2, double a3, double frequencia) {
        double notaFinal = a1 + a2 + a3;
        boolean naoAprovado = notaFinal < NOTA_MINIMA_APROVACAO;
        boolean frequenciaSuficiente = frequencia >= FREQUENCIA_MINIMA;
        boolean somaComA3Suficiente = (a1 + a3 >= SOMA_MINIMA_PARA_AI) || (a2 + a3 >= SOMA_MINIMA_PARA_AI);
        return naoAprovado && frequenciaSuficiente && somaComA3Suficiente;
    }

    private void validarNota(double nota, double notaMaxima, String nomeAvaliacao) {
        if (nota < 0 || nota > notaMaxima) {
            throw new IllegalArgumentException(
                nomeAvaliacao + " deve estar entre 0 e " + notaMaxima);
        }
    }

                public double aplicarAI(double a1, double a2, double a3, double notaAI) {
        validarNota(notaAI, NOTA_MAXIMA_AI, "AI");
        double menor = Math.min(a1, a2);
        if (notaAI <= menor) {
            return a1 + a2 + a3;
        }
        if (a1 <= a2) {
            return notaAI + a2 + a3;
        }
        return a1 + notaAI + a3;
    }

    
    
}