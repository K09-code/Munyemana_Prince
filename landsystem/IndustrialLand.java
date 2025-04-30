import java.util.Date;

public class IndustrialLand extends Land {
    private boolean hasEnvironmentalClearance;

    public IndustrialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, boolean hasEnvironmentalClearance) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
        this.hasEnvironmentalClearance = hasEnvironmentalClearance;
    }

    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("industrial zone") && hasEnvironmentalClearance;
    }

    public double calculateTax() {
        return sizeInAcres * 12000 * 0.03;
    }

    public String generateLandReport() {
        return getCommonReportDetails()
            + "Ownership Valid: " + validateOwnership() + "\n"
            + "Zoning Compliance: " + checkZoningCompliance() + "\n"
            + "Tax Due: $" + String.format("%.2f", calculateTax()) + "\n";
    }
}
