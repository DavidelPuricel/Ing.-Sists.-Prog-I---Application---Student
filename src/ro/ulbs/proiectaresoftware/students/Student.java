package ro.ulbs.proiectaresoftware.students;
import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    int numarMatricol;
    String nume;
    String prenume;
    String formatieDeStudiu;

    public Student(int numarMatricol, String nume, String prenume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.nume = nume;
        this.prenume = prenume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    @Override
    public int compareTo(Student altul){
        return this.nume.compareTo(altul.nume);
    }

    @Override
    public String toString() {
        return String.format("%13d %12s %10s %17s", numarMatricol, nume, prenume, formatieDeStudiu);
    }
}