package ro.ulbs.proiectaresoftware.students;

import java.util.List;

public interface IStudentiExport { //defineste o interfata (un set de metode obligatorii)
    void doExport(List<Student> studenti); //met abstracta primeste lista de studenti si face exportul
}