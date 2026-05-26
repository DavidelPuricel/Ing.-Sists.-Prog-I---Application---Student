package ro.ulbs.proiectaresoftware.students;
import java.util.List;

public class StudentiExportCuTimp extends StudentiExportDecorator {
    public StudentiExportCuTimp(IStudentiExport exportDecorat) {
        super(exportDecorat);
    }

    @Override
    public void doExport(List<Student> studenti) {
        long startTime = System.currentTimeMillis();

        exportDecorat.doExport(studenti);

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        System.out.println("Timp executie export: " + executionTime + " ms");
    }
}