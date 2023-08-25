package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        // analisarCandidato(8000);
        // selecaoCandidatos();
        // selecaoCandidatos();
        // imprimirSelecionados();

        String[] candidatos = {"Rafa", "Maria", "Pedro", "Ruan", "Felipe"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);

        }
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu=atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }else {
                System.out.println("Contato realizado com sucesso");
            }

        }while (continuarTentando && tentativasRealizadas<3);
        if (atendeu){
            System.out.println("Conseguimos contato com o " + candidato + "na " + tentativasRealizadas + " tentativas");
        }else {
            System.out.println("Não conseguimos contato com " + candidato +", numero maximo de tentativas " + tentativasRealizadas + " realizadas");
        }


    }


    //Metodo auxiliar
    static boolean atender(){
        return new Random().nextInt(3)==1;

        }


    static void imprimirSelecionados(){
        String [] candidatos = {"Rafa", "Maria", "Pedro"};
        System.out.println("Imprimindo a lista de candidatos informando o indice");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de n°: " + (indice+1) + " é " + candidatos[indice]);
            
        }

        for (String candidato: candidatos) {
            System.out.println("O canditado selecionado foi o: " + candidato);
            
        }
    }

    static void selecaoCandidatos (){
        String [] candidatos = {"Rafa", "Maria", "Pedro", "Ruan", "Felipe"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;


        while (candidatosSelecionados < 3 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendito = valorPretendito();

            System.out.println("O candidato: " +candidato+ " Solicitou este valor de salario: " + salarioPretendito);
            if (salarioBase >= salarioPretendito){
                System.out.println("O candiato: " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendito(){
        return ThreadLocalRandom.current().nextDouble(1800,2000);
    }

    static void analisarCandidato(double salarioPretendido){

        double salarioBase = 2000.00;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        }else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");

        }else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }

    }
}
