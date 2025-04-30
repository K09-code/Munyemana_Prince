import java.util.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MissionManager {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Mission Management System");
            System.out.println("==========================");
            System.out.println("Choose mission type: ");
            System.out.println("1. Recon Mission");
            System.out.println("2. Rescue Mission");
            System.out.println("3. Combat Mission");
            System.out.println("4. Humanitarian Mission");
            System.out.print("Enter choice (1-4): ");
            int missionChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Mission ID: ");
            String missionId = scanner.nextLine();
            System.out.print("Enter Mission Name: ");
            String missionName = scanner.nextLine();
            System.out.print("Enter Mission Start Date (yyyy-MM-dd): ");
            String startDateStr = scanner.nextLine();
            System.out.print("Enter Mission End Date (yyyy-MM-dd): ");
            String endDateStr = scanner.nextLine();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date missionStartDate = dateFormat.parse(startDateStr);
            Date missionEndDate = dateFormat.parse(endDateStr);

            Mission mission = createMission(missionChoice, missionId, missionName, missionStartDate, missionEndDate);

            System.out.print("Enter number of personnel to assign: ");
            int numPersonnel = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numPersonnel; i++) {
                System.out.print("Enter Personnel ID: ");
                String personnelId = scanner.nextLine();
                System.out.print("Enter Personnel Name: ");
                String personnelName = scanner.nextLine();
                System.out.print("Enter Personnel Role (e.g., Medic, Soldier, Scout): ");
                String personnelRole = scanner.nextLine();
                Personnel personnel = new Personnel(personnelId, personnelName, personnelRole);
                mission.assignPersonnel(personnel);
            }

            System.out.print("Enter number of resources to allocate: ");
            int numResources = scanner.nextInt();
            scanner.nextLine();
            List<Resource> resources = new ArrayList<>();
            for (int i = 0; i < numResources; i++) {
                System.out.print("Enter Resource ID: ");
                String resourceId = scanner.nextLine();
                System.out.print("Enter Resource Name: ");
                String resourceName = scanner.nextLine();
                System.out.print("Enter Resource Quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Resource Type (e.g., Equipment, Medical Supplies, Weaponry): ");
                String resourceType = scanner.nextLine();
                resources.add(new Resource(resourceId, resourceName, quantity, resourceType));
            }

            mission.assignTask();
            mission.allocateResources(resources);
            mission.trackMissionProgress();
            mission.generateMissionReport();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static Mission createMission(int missionChoice, String missionId, String missionName, Date startDate, Date endDate) {
        switch (missionChoice) {
            case 1:
                return new ReconMission(missionId, missionName, startDate, endDate);
            case 2:
                return new RescueMission(missionId, missionName, startDate, endDate);
            case 3:
                return new CombatMission(missionId, missionName, startDate, endDate);
            case 4:
                return new HumanitarianMission(missionId, missionName, startDate, endDate);
            default:
                throw new IllegalArgumentException("Invalid mission type");
        }
    }
}