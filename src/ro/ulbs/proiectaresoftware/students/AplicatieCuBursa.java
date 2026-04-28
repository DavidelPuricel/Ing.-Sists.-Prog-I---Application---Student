package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;

public class AplicatieCuBursa {
    public static void main(String[] args) {
        AplicatieCuBursa instanta = new AplicatieCuBursa();
        List<StudentBursier> lista = instanta.genereaza();

        for (StudentBursier student : lista) {
            System.out.println(student);
        }

        System.out.println("");
        System.out.println("List<StudentBursier> sortata");
        List<StudentBursier> sortata = instanta.sorteaza(lista);
        for (StudentBursier student : sortata) {
            System.out.println(student);
        }
    }

    public List<StudentBursier> genereaza() {
        List<StudentBursier> lista = new ArrayList<>();
        lista.add(new StudentBursier(1024, "Mihalcea", "Ioan", "ISM141/1", 9.80f, 801.10));
        lista.add(new StudentBursier(1025, "Popa", "Andrei", "ISM141/2", 8.70f, 725.50));
        lista.add(new StudentBursier(1029, "Popescu", "Bianca", "TI131/1", 8.90f, 745.50));
        lista.add(new StudentBursier(1026, "Prodan", "Anamaria", "TI131/1", 9.10f, 780.80));
        lista.add(new StudentBursier(1029, "Popescu", "Bianca", "TI131/1", 9.10f, 100.00));
        return lista;
    }

    public List<StudentBursier> sorteaza(List<StudentBursier> lst) {
        if (lst == null) return null;
        List<StudentBursier> sortata = new ArrayList<>(lst);

        sortata.sort((s1, s2) -> {
            int res = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
            if (res != 0) return res;
            res = s1.getNume().compareTo(s2.getNume());
            if (res != 0) return res;
            res = s1.getPrenume().compareTo(s2.getPrenume());
            if (res != 0) return res;
            res = Float.compare(s1.getNota(), s2.getNota());
            if (res != 0) return res;
            return Double.compare(s1.getCuantumBursa(), s2.getCuantumBursa());
        });

        return sortata;
    }
}