package ro.ulbs.proiectaresoftware.students;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70f),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10f),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90f),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10f),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10f),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33f),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20f),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12f),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22f)
        );

        Exporter exporter = new Exporter();

        IStudentiExport strategieConsola = new StudentiInConsola();
        exporter.startExport(strategieConsola, studenti);

        IStudentiExport strategieText = new StudentiInFisierText("studenti.txt");
        exporter.startExport(strategieText, studenti);

        IStudentiExport strategieXlsx = new StudentiInFisierXlsx("studenti.xlsx");
        exporter.startExport(strategieXlsx, studenti);

        Importer importer = new Importer();

        IStudentiImport citireText = new StudentiDinFisierText("studenti.txt");
        List<Student> studentiDinText = importer.startImport(citireText);

        System.out.println("Studenti din TXT:");
        exporter.startExport(strategieConsola, studentiDinText);

        IStudentiImport citireXlsx = new StudentiDinFisierXlsx("studenti.xlsx");
        List<Student> studentiDinXlsx = importer.startImport(citireXlsx);

        System.out.println("Studenti din XLSX:");
        exporter.startExport(strategieConsola, studentiDinXlsx);
    }
}
