/*
Usei a lib Array para simplismente printar o meus arrays

Usei a lib ArrayLib para criar em primeira instancia um array de tamanho 
indefinido já que quero que o usuário entre com os dados
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class merge{
    public static void main(String[] args) {
        ArrayList<Integer> vetor = new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        boolean resp = true;
        char resp_user = ' ';
        
        //Peco a entrada de dados para o meu usuário e vou adicionando ao meu ArrayList
        while(resp != false){
            System.out.println("Digite um numero inteiro que deseja colocar no array: ");
            vetor.add(ler.nextInt());

            System.out.println("Deseja inserir um novo numero (Y/N)?");
            resp_user = ler.next().charAt(0);

            resp_user = Character.toLowerCase(resp_user);

            if (resp_user == 'n'){
                resp = false;
            }
        }

        //Crio um vetor comum a partir do meu ArrayList
        int [] array = new int[vetor.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = vetor.get(i);
        }

        int inicio = 0;
        int fim = array.length - 1;

        System.out.println("Primeiro vetor/Desordenado");
        print_vetor(array);

        merge_recursive(array, inicio, fim);

        System.out.println("Segundo vetor/Ordenado");
        print_vetor(array);
    }

    //funcao feita somnete para imprimir o vetor usando o toString da lib Arrays
    static void print_vetor(int[] vetor){
        System.out.println(Arrays.toString(vetor));
    }

    //funcao recursiva
    static void merge_recursive(int[] array, int inicio, int fim){
        if(inicio < fim){
            int meio = inicio + (fim - inicio) / 2;

            merge_recursive(array, inicio, meio);

            merge_recursive(array, meio + 1, fim);

            merge_troca(array, inicio, meio, fim);
        }
    }

    //fucao auxiliar para ajudar nas trocas e juncao do array
    static void merge_troca(int[] array, int inicio, int meio, int fim){
        int[] vet_aux = new int[array.length];

        for(int i = inicio; i <= fim; i++){
            vet_aux[i] = array[i];
        }

        int i = inicio;
        int m = meio + 1;
        int i_aux = inicio;

        while(i <= meio && m <= fim){
            if(vet_aux[i] <= vet_aux[m]){
                array[i_aux] = vet_aux[i];
                i++;
            } else{
                array[i_aux] = vet_aux[m];
                m++;
            }
            i_aux++;
        }

        while(i <= meio){
            array[i_aux] = vet_aux[i];
            i_aux++;
            i++;
        }
    }
}