import java.util.Date;

public class AgriculturalLand extends Land {
    public AgriculturalLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
    }

    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("farming zone") && sizeInAcres >= 1;
    }

    public double calculateTax() {
        return sizeInAcres * 5000 * 0.01;
    }

    public String generateLandReport() {
        return getCommonReportDetails()
            + "Ownership Valid: " + validateOwnership() + "\n"
            + "Zoning Compliance: " + checkZoningCompliance() + "\n"
            + "Tax Due: $" + String.format("%.2f", calculateTax()) + "\n";
    }
}
