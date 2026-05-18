package ro.ulbs.proiectaresoftware.students;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {
    private String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Studenti");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("NumarMatricol");
        header.createCell(1).setCellValue("Prenume");
        header.createCell(2).setCellValue("Nume");
        header.createCell(3).setCellValue("FormatieDeStudiu");
        header.createCell(4).setCellValue("Medie");

        int rowIndex = 1;

        for (Student student : studenti) {
            Row row = sheet.createRow(rowIndex);

            row.createCell(0).setCellValue(student.getNumarMatricol());
            row.createCell(1).setCellValue(student.getPrenume());
            row.createCell(2).setCellValue(student.getNume());
            row.createCell(3).setCellValue(student.getFormatieDeStudiu());
            row.createCell(4).setCellValue(student.getNota());

            rowIndex++;
        }

        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            System.out.println("Eroare XLSX.");
        }
    }
}