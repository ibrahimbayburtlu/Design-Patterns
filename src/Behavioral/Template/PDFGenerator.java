package Behavioral.Template;

public class PDFGenerator extends ReportGenerator {
    @Override
    protected void createReport() {
        System.out.println("Generating PDF Report");
        // PDF specific report generation logic
        // e.g., using a PDF library to create the report
    }
}
