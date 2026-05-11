package ro.ulbs.proiectaresoftware.students;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.util.*;

public class Application {
//    public static void writeToFile(String filename, Collection<? extends Student> lista) {
//        List<String> linii = new ArrayList<>();
//        for (Student s : lista) {
//            linii.add(s.toString());
//        }
//        try {
//            java.nio.file.Files.write(java.nio.file.Paths.get(filename), linii);
//        } catch (java.io.IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {



        List<Student> students = Arrays.asList(
                new Student(1029, "Andrei", "Popescu", "TI131/1", 10.0F),
                new Student(1029, "Marius", "Ionescu", "TI131/1", 9.20F),
                new Student(1029, "Andreea", "Popa", "TI131/2", 10.0F),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20F),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12F),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22F)
        );

        students.stream() //definita in interfata Collection
                .filter(s->s.getNota()==10)
                .forEach(s-> System.out.println(s));
        System.out.println();

        students.stream()
                .filter(s->s.getNota()<5)
                .forEach(s-> System.out.println(s));

        students.stream()
                .map(s->{
                    if(s.getNota()<4)s.setNota(4);
                    return s.getNota();
                        })
                .forEach(s-> System.out.println(s));

        float suma = students.stream()
                .map(Student::getNota)
                .reduce(0.0F, (acumulator, nota)->acumulator+nota);

        System.out.println("Suma notelor este: "+suma);
        System.out.println("media este: "+(suma/students.size()));







//        Set<Student> studentiInitiali = new HashSet<>(Arrays.asList(
//                new Student(101, "Popescu", "Ion", "A", 9.5f),
//                new Student(102, "Ionescu", "Ana", "A", 8.0f),
//                new Student(103, "Vasilescu", "Dan", "A", 7.5f),
//                new Student(104, "Georgescu", "Maria", "A", 10.0f)
//        ));
//
//        System.out.println("Studenti initiali:");
//        studentiInitiali.forEach(System.out::println);
//
//        // Impartim in doua formatii noi
//        Set<Student> studentiNoi = imparteInDouaFormatii(studentiInitiali, "TI 211_1", "TI 211_2");
//
//        System.out.println("\nStudenti dupa impartirea in formatii noi:");
//        for (Student s : studentiNoi) {
//            System.out.println(s);
//        }
//    }
//
//    // 7.6.3 b) Metoda care "muta" un student creand o instanta noua
//    public static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
//        // Deoarece Student este imutabil, returnam un obiect NOU cu aceleasi date, dar formatie noua
//        return new Student(st.getNumarMatricol(), st.getNume(), st.getPrenume(), nouaFormatieDeStudiu, st.getNota());
//    }
//
//    // Metoda pentru impartirea listei in doua
//    public static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String f1, String f2) {
//        List<Student> listaSursa = new ArrayList<>(studenti);
//        Set<Student> rezultat = new HashSet<>();
//
//        int mijloc = (listaSursa.size() + 1) / 2;
//
//        for (int i = 0; i < listaSursa.size(); i++) {
//            String formatieAleasa = (i < mijloc) ? f1 : f2;
//            // Apelam metoda de schimbare care produce obiecte noi
//            rezultat.add(schimbaFormatia(listaSursa.get(i), formatieAleasa));
//        }
//        return rezultat;

//        List<StudentBursier> bursieri = new ArrayList<>();
//        bursieri.add(new StudentBursier(1025, "Popa", "Andrei", "ISM141/2", 8.70f, 725.50));
//        bursieri.add(new StudentBursier(1024, "Mihalcea", "Ioan", "ISM141/1", 9.80f, 801.10));
//        bursieri.add(new StudentBursier(1026, "Prodan", "Anamaria", "TI131/1", 8.90f, 745.50));
//        bursieri.add(new StudentBursier(1029, "Popescu", "Bianca", "TI131/1", 9.10f, 780.80));
//
//        writeToFile("src/ro/ulbs/proiectaresoftware/students/bursieri_out.txt", bursieri);
//        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
//        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
//        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
//        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
//        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");
//        List<Student> lista = new ArrayList<Student>();
//        lista.add(s1);
//        lista.add(s2);
//        lista.add(s3);
//        lista.add(s4);
//        lista.add(s5);
//        System.out.println(String.format("%10s %12s %11s %14s", "numarMatricol", "prenume", "nume", "formatieDeStudiu"));
//        for (Student student : lista) {
//            System.out.println(student);
//        }
//
//        Path pathIn = Paths.get("src/ro/ulbs/proiectaresoftware/students/studenti_in.txt");
//        //Path pathOut = Paths.get("src/ro/ulbs/proiectaresoftware/students/studenti_out.txt");
//        Path pathOutSorted = Paths.get("src/ro/ulbs/proiectaresoftware/students/studenti_out_sorted.txt");
//
//        List<Student> listaDinFisier = new ArrayList<>();
//
//        try{
//            List<String> linii = Files.readAllLines(pathIn);
//            for(String linie : linii){
//                if(!linie.trim().isEmpty()){
//                    String[] date = linie.split(",");
//                    if(date.length == 4){
//                        Student s =new Student(Integer.parseInt(date[0]),date[2],date[1],date[3]);
//                        listaDinFisier.add(s);
//                    }
//                }
//            }
//
////            Collections.sort(listaDinFisier);
////            List<String> deSalvat = new ArrayList<>();
////            for(Student s : listaDinFisier){
////                deSalvat.add(s.toString());
////            }
////            Files.write(pathOut, deSalvat);
////            System.out.println("\nStudetii au fost sortati si salvati in fisier");
//
//            Collections.sort(listaDinFisier);
//
//            List<String> deSalvatSorted = new ArrayList<>();
//            for (Student s : listaDinFisier) {
//                deSalvatSorted.add(s.toString());
//            }
//
//            Files.write(pathOutSorted, deSalvatSorted);
//            System.out.println("Studentii au fost sortati si afisati in noul fisier");
//
//
//        }catch (IOException e){
//            e.printStackTrace();
//
//        }

//        HashMap<Integer, Student> mapStudenti = new HashMap<>();
//
//        mapStudenti.put(1024, new Student(1024, "Mihalcea", "Ioan", "ISM141/1"));
//        mapStudenti.put(1025, new Student(1025, "Popa", "Andrei", "ISM141/2"));
//        mapStudenti.put(1026, new Student(1026, "Popescu", "Bianca", "TI131/2"));
//        mapStudenti.put(1027, new Student(1027, "Prodan", "Anamaria", "TI131/1"));
//
//        try (Scanner scanner = new Scanner(Paths.get("src/ro/ulbs/proiectaresoftware/students/note_anon.txt"))) {
//            while (scanner.hasNextLine()) {
//                String linie = scanner.nextLine();
//                if (linie.trim().isEmpty()) continue;
//
//                String[] date = linie.split(",");
//                int id = Integer.parseInt(date[0].trim());
//                float notaValoare = Float.parseFloat(date[1].trim());
//
//                Student s = mapStudenti.get(id);
//                if (s != null) {
//                    s.setNota(notaValoare);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Rezultate procesare note:");
//        for (Student s : mapStudenti.values()) {
//            System.out.println(s);
//        }
//
//        float notaM = gasesteNota("Bianca", "Popescu", mapStudenti);
//        float notaN = gasesteNota("Ioan", "Mihalcea", mapStudenti);
//
//        System.out.println("notaM (Bianca Popescu): " + notaM);
//        System.out.println("notaN (Ioan Mihalcea): " + notaN);
//    }
//
//    public static float gasesteNota(String prenume, String nume, Map<Integer, Student> date) {
//        Map<String, Student> cautareDupaNume = new HashMap<>();
//
//        for (Student s : date.values()) {
//            String cheie = s.prenume.trim() + " " + s.nume.trim();
//            cautareDupaNume.put(cheie, s);
//        }
//
//        String tinta = prenume.trim() + " " + nume.trim();
//        if (cautareDupaNume.containsKey(tinta)) {
//            return cautareDupaNume.get(tinta).getNota();
//        }
//
//        return 0.0f;
    }
}
