import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LandRegistry {
    private List<Land> lands = new ArrayList<>();

    public void registerLand(Land land) {
        if (land.validateOwnership()) {
            lands.add(land);
        } else {
            System.out.println("Registration failed: Invalid ownership.");
        }
    }

    public void printAllReports() {
        for (Land land : lands) {
            System.out.println("------ LAND REPORT ------");
            System.out.println(land.generateLandReport());
            System.out.println("-------------------------\n");
        }
    }
}
