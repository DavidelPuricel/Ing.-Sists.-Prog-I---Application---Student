package ro.ulbs.proiectaresoftware.students;
import java.util.ArrayList;
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
    }
}
