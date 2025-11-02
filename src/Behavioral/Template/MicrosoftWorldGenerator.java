package Behavioral.Template;

public class MicrosoftWorldGenerator extends ReportGenerator {
    @Override
    protected void createReport() {
        System.out.println("Generating DOC Report");
        // DOC specific report generation logic
        // e.g., using a DOC library to create the report
    }
}
