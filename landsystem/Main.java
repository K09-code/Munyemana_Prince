import java.util.*;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LandRegistry registry = new LandRegistry();

        System.out.print("Enter number of lands to register: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter land type (agricultural, residential, commercial, industrial): ");
            String type = scanner.nextLine().toLowerCase();

            System.out.print("Enter Land ID: ");
            String landId = scanner.nextLine();

            System.out.print("Enter Owner Name: ");
            String ownerName = scanner.nextLine();

            System.out.print("Enter Location (include zone info): ");
            String location = scanner.nextLine();

            System.out.print("Enter Size in Acres: ");
            double size = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Land Use Status (Vacant, In Use, etc.): ");
            String status = scanner.nextLine();

            Date regDate = new Date();

            switch (type) {
                case "agricultural":
                    registry.registerLand(new AgriculturalLand(landId, ownerName, location, size, regDate, status));
                    break;

                case "residential":
                    System.out.print("Enter number of residential units: ");
                    int units = Integer.parseInt(scanner.nextLine());
                    registry.registerLand(new ResidentialLand(landId, ownerName, location, size, regDate, status, units));
                    break;

                case "commercial":
                    registry.registerLand(new CommercialLand(landId, ownerName, location, size, regDate, status));
                    break;

                case "industrial":
                    System.out.print("Has environmental clearance? (true/false): ");
                    boolean clearance = Boolean.parseBoolean(scanner.nextLine());
                    registry.registerLand(new IndustrialLand(landId, ownerName, location, size, regDate, status, clearance));
                    break;

                default:
                    System.out.println("Unknown land type. Skipping entry.");
                    break;
            }
        }

        System.out.println("\n\n--- LAND REPORTS ---");
        registry.printAllReports();
        scanner.close();
    }
}
