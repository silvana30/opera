package model.model.exporter;

public class FactoryExp {
    public FactoryExp() {
    }

    public Exporter getExporter(String exp) {
        if (exp == null) {
            return null;
        }
        if (exp.equalsIgnoreCase("CSV")) {
            return new CsvExporter();
        } else if (exp.equalsIgnoreCase("JSON")) {
            return new JsonExporter();
        } else
            return null;
    }
}
