import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {
    Pacientes pacientes;
    LocalDateTime datahora;
    String especialidade;

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Consulta(Pacientes pacientes, LocalDateTime datahora, String especialidade) {
        this.pacientes = pacientes;
        this.datahora = datahora;
        this.especialidade = especialidade;



    }
}
