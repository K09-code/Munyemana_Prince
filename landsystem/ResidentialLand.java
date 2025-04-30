import java.util.Date;

public class ResidentialLand extends Land {
    private int residentialUnits;

    public ResidentialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, int residentialUnits) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
        this.residentialUnits = residentialUnits;
    }

    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    public boolean checkZoningCompliance() {
        return (residentialUnits <= 2 * sizeInAcres);
    }

    public double calculateTax() {
        return sizeInAcres * 8000 * 0.015;
    }

    public String generateLandReport() {
        return getCommonReportDetails()
            + "Ownership Valid: " + validateOwnership() + "\n"
            + "Zoning Compliance: " + checkZoningCompliance() + "\n"
            + "Tax Due: $" + String.format("%.2f", calculateTax()) + "\n";
    }
}
