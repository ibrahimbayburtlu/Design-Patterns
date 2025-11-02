package Behavioral.Template;

abstract class ReportGenerator {

    public final void generateReport() {
        fetchData();
        processData();
        createReport();
        saveReport();
    }

    protected void fetchData() {
        System.out.println("Data fetched from source.");
    }

    protected void processData() {
        System.out.println("Data processed.");
    }

    protected abstract void createReport();

    protected void saveReport() {
        System.out.println("Report saved to file.");
    }
}
