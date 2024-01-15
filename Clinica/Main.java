package Clinica;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    static ArrayList<Pacientes> pacientes = new ArrayList<>();
    static ArrayList<Consulta> consultas = new ArrayList<>(); //consultas
    static Scanner scanner = new Scanner(System.in);

    public Main(String[] args) { // main
        while (true) {
            System.out.println("1. Cadastrar um Paciente");
            System.out.println("2. Marcar uma Consulta");
            System.out.println("3. Cancelar uma Consulta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: "); // print
            int opcao = scanner.nextInt(); // variavel opcao
            scanner.nextLine();

            //menu de opcoes da clinica
            switch (opcao) {
                case 1 -> cadastrarPacientes();
                case 2 -> marcarConsulta();
                case 3 -> cancelarConsulta();
                case 4 -> System.exit(0);
                default -> System.out.println("Opção inexistente");
            }
        }
    }

    //cadastro dos pacientes, add informações
    public static void cadastrarPacientes() {
        System.out.println("Digite o nome do paciente");
        String nome = scanner.nextLine(); //
        System.out.println("Digite o telefone do paciente com o DDD");
        String telefone = scanner.nextLine(); //

        pacientes.add(new Paciente(nome, telefone));
        System.out.println("Paciente cadastrado com sucesso");
    }

    public static void marcarConsulta() {
        if (pacientes.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
            return;
        }
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).nome);
        }
        System.out.print("Escolha um paciente: ");
        int pacienteEscolhido = scanner.nextInt() - 1;
        scanner.nextLine();
        if (pacienteEscolhido < 0 || pacienteEscolhido >= pacientes.size()) {
            System.out.println("Número de paciente inválido.");
            return;
        }
        System.out.print("Digite a data da consulta (formato dd/MM/yyyy): ");
        String data = scanner.nextLine();
        System.out.print("Digite a hora da consulta (formato HH:mm): ");
        String hora = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(data + " " + hora, formatter);

        // Verifica se a consulta é retroativa
        if (dataHora.isBefore(LocalDateTime.now())) {
            System.out.println("Não é possível marcar consultas retroativas.");
            return;
        }

        // Verifica se a data e hora já estão agendadas
        for (Consulta consulta : consultas) {
            if (consulta.dataHora.equals(dataHora)) {
                System.out.println("Já existe uma consulta marcada para esta data e hora.");
                return;
            }
        }

        System.out.print("Digite a especialidade da consulta: ");
        String especialidade = scanner.nextLine();
        consultas.add(new Consulta(pacientes.get(pacienteEscolhido), dataHora, especialidade));
        System.out.println("Consulta marcada com sucesso");
    }

    public static void cancelarConsulta() {
        if (consultas.isEmpty()) {
            System.out.println("Não há consultas marcadas.");
            return;
        }
        for (int i = 0; i < consultas.size(); i++) {
            System.out.println((i + 1) + ". Consulta do paciente " + consultas.get(i).paciente.nome);
        }
        System.out.print("Escolha uma consulta para cancelar: ");
        int consultaEscolhida = scanner.nextInt() - 1;
        scanner.nextLine();
        if (consultaEscolhida < 0 || consultaEscolhida >= consultas.size()) {
            System.out.println("Número de consulta inválido.");
            return;
        }
        System.out.println("Você escolheu cancelar a consulta do paciente " + consultas.get(consultaEscolhida).paciente.nome + " no dia " + consultas.get(consultaEscolhida).dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " às " + consultas.get(consultaEscolhida).dataHora.format(DateTimeFormatter.ofPattern("HH:mm")) + " com a especialidade " + consultas.get(consultaEscolhida).especialidade);
        System.out.print("Você confirma o cancelamento? (s/n): ");
        String confirmacao = scanner.nextLine();
        if (confirmacao.equalsIgnoreCase("s")) {
            consultas.remove(consultaEscolhida);
            System.out.println("Consulta cancelada com sucesso");
        }
    }
}

