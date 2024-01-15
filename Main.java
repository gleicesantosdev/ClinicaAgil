import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    static ArrayList<Pacientes> pacientes = new ArrayList<>();
    static ArrayList<Consulta> consulta = new Arraylist<>();
    static Scanner scanner = new Scanner(System.in);

    public static void maim (String[] args){
        while(true) {
            System.out.println("1. Cadastrar um Paciente");
            System.out.println("2. Marcar uma Consulta");
            System.out.println("3. Cancelar uma Consulta");
            System.out.println("4. Sair");
            System.out.println("5. Escolha uma opção: ");
            int opção = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPacientes();
                    break;
                case 2:
                    marcarConsulta();
                case 3:
                    cancelarConsulta();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inexistente");
                    break;
            }
        }
    }


}
