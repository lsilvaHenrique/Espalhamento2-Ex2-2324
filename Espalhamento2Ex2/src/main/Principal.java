package main;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    private List<List<Integer>> tabela;

    public Principal() {
        tabela = new ArrayList<>();
        tabela.add(new ArrayList<>());  // Posição 0 para os números pares
        tabela.add(new ArrayList<>());  // Posição 1 para os números ímpares
    }

    public void inserirNumero(int numero) {
        int posicao = hash(numero);
        tabela.get(posicao).add(numero);
    }

    public List<Integer> getNumerosPares() {
        return tabela.get(0);
    }

    public List<Integer> getNumerosImpares() {
        return tabela.get(1);
    }

    private int hash(int numero) {
        if (numero % 2 == 0) {
            return 0;  // Posição na tabela para os números pares
        } else {
            return 1;  // Posição na tabela para os números ímpares
        }
    }

    public static void main(String[] args) {
    	Principal tabela = new Principal();

        // Gerar vetor de teste com números aleatórios
        int[] numeros = new int[100];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100);
        }

        // Inserir os números na tabela de espalhamento
        for (int numero : numeros) {
            tabela.inserirNumero(numero);
        }

        // Imprimir os números pares
        List<Integer> pares = tabela.getNumerosPares();
        System.out.println("Números pares:");
        for (int numero : pares) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // Imprimir os números ímpares
        List<Integer> impares = tabela.getNumerosImpares();
        System.out.println("Números ímpares:");
        for (int numero : impares) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}

