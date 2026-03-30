package ro.ulbs.proiectaresoftware.students;
import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    int numarMatricol;
    String nume;
    String prenume;
    String formatieDeStudiu;
    float nota;

    public Student(int numarMatricol, String nume, String prenume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.nume = nume;
        this.prenume = prenume;
        this.formatieDeStudiu = formatieDeStudiu;
    }
    public void setNota(float nota){
        this.nota=nota;

    }
    public float getNota(){
        return nota;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(!(obj instanceof Student)) return false;
        Student student=(Student)obj;
        return numarMatricol==student.numarMatricol;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(numarMatricol);
    }

    @Override
    public int compareTo(Student altul){
        int rezGrupa = this.formatieDeStudiu.compareTo(altul.formatieDeStudiu);
        if (rezGrupa != 0) {
            return rezGrupa;
        }
        return this.nume.compareTo(altul.nume);
    }

    @Override
    public String toString() {
        return String.format("%13d %12s %10s %17s", numarMatricol, nume, prenume, formatieDeStudiu);
    }
}