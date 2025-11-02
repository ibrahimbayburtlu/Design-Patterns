package Behavioral.Template;

public class Main {
    public  static void main(String[] args) {
        ReportGenerator pdfReport = new PDFGenerator();
        pdfReport.generateReport();
    }
}
