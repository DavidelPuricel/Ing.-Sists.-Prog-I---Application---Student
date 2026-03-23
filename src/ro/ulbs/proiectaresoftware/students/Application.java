package ro.ulbs.proiectaresoftware.students;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");
        List<Student> lista = new ArrayList<Student>();
        lista.add(s1);
        lista.add(s2);
        lista.add(s3);
        lista.add(s4);
        lista.add(s5);
        System.out.println(String.format("%10s %12s %11s %14s", "numarMatricol", "prenume", "nume", "formatieDeStudiu"));
        for (Student student : lista) {
            System.out.println(student);
        }

        Path pathIn = Paths.get("src/ro/ulbs/proiectaresoftware/students/studenti_in.txt");
        Path pathOut = Paths.get("src/ro/ulbs/proiectaresoftware/students/studenti_out.txt");

        List<Student> listaDinFisier = new ArrayList<>();

        try{
            List<String> linii = Files.readAllLines(pathIn);
            for(String linie : linii){
                if(!linie.trim().isEmpty()){
                    String[] date = linie.split(",");
                    if(date.length == 4){
                        Student s =new Student(Integer.parseInt(date[0]),date[2],date[1],date[3]);
                        listaDinFisier.add(s);
                    }
                }
            }

            Collections.sort(listaDinFisier);
            List<String> deSalvat = new ArrayList<>();
            for(Student s : listaDinFisier){
                deSalvat.add(s.toString());
            }
            Files.write(pathOut, deSalvat);
            System.out.println("\nStudetii au fost sortati si salvati in fisier");


        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
