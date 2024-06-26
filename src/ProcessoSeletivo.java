import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String candidatos[] = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        } while (continuarTentando && tentativasRealizadas <= 3);

        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMO TENTATIVAS "
                    + tentativasRealizadas + " REALIZADA");

    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;

    }

    static void imprimirSelecionados() {
        String candidatos[] = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };
        System.out.println("Imprimindo a lista de candidatos com o índice do elemento \n");

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("Nome: " + candidatos[i] + " Índice: " + (i + 1) + "\n\n");
        }
    }

    static void selecaoCandidatos() {

        String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA",
                "DANIELA", "JORGE" };
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.00;

        while (candidatosSelecionados < 5) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário: " + salarioPretendido);

            if (salarioBase > salarioPretendido) {
                candidatosSelecionados++;
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga!! \n");
            } else
                System.out.println("O candidato" + candidato + " não foi selecionado para a vaga!! \n");

            candidatoAtual++;

        }

    }

    static void analisarCandidato(double salarioPretendido) {

        double salarioBase = 2000.00;

        if (salarioPretendido < salarioBase)
            System.out.println("Ligar para o Candidato!");
        else if (salarioBase == salarioPretendido)
            System.out.println("Ligar para o Candidato, com contra proposta!");
        else
            System.out.println("Aguardando resultado dos demais candidatos!");

    }

    static double valorPretendido() {

        return ThreadLocalRandom.current().nextDouble(1800, 2200);

    }
}
