package ro.ulbs.proiectaresoftware.students;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport {
    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linie;

            while ((linie = reader.readLine()) != null) {
                String[] valori = linie.split(",");

                int numarMatricol = Integer.parseInt(valori[0]);
                String prenume = valori[1];
                String nume = valori[2];
                String formatieDeStudiu = valori[3];
                float medie = Float.parseFloat(valori[4]);

                Student student = new Student(numarMatricol, prenume, nume, formatieDeStudiu, medie);
                studenti.add(student);
            }
        } catch (IOException e) {
            System.out.println("Eroare la citire.");
        }

        return studenti;
    }
}