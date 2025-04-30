import java.util.Date;

public class CommercialLand extends Land {
    public CommercialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
    }

    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("commercial zone");
    }

    public double calculateTax() {
        return sizeInAcres * 10000 * 0.025;
    }

    public String generateLandReport() {
        return getCommonReportDetails()
            + "Ownership Valid: " + validateOwnership() + "\n"
            + "Zoning Compliance: " + checkZoningCompliance() + "\n"
            + "Tax Due: $" + String.format("%.2f", calculateTax()) + "\n";
    }
}
