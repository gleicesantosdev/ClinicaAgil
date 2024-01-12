import java.util.ArrayList;
import java.util.Scanner;

public class Pacientes {
    String Nome;
    String Telefone;

    public Pacientes(String nome, String telefone) {
        this.Nome= nome;
        this.Telefone = telefone;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }
}
