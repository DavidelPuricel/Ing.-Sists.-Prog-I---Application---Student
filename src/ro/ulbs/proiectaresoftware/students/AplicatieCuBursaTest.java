package ro.ulbs.proiectaresoftware.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class AplicatieCuBursaTest {
    AplicatieCuBursa appCuBursa = new AplicatieCuBursa();

    @Test
    void sortTest1() {
        List<StudentBursier> lista = appCuBursa.genereaza();
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);
        Assertions.assertEquals(lista.size(), sortata.size());
        for (int i = 0; i < sortata.size() - 1; i++) {
            StudentBursier s1 = sortata.get(i);
            StudentBursier s2 = sortata.get(i + 1);
            Assertions.assertTrue(s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu()) <= 0);
        }
    }
}