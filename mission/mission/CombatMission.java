import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CombatMission extends Mission {
    private List<Resource> allocatedResources;

    public CombatMission(String missionId, String missionName, Date start, Date end) {
        super(missionId, missionName, start, end);
        this.allocatedResources = new ArrayList<>();
    }

    @Override
    public void assignTask() {
        if (assignedPersonnel.size() < 3) {
            throw new IllegalStateException("At least three personnel are required for Combat Mission.");
        }
        System.out.println("Combat tasks assigned: defense, attack, strategy.");
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        boolean hasAmmunition = false;
        boolean hasVehicles = false;

        for (Resource res : availableResources) {
            if (res.getResourceType().equalsIgnoreCase("Weaponry") &&
                res.getResourceName().equalsIgnoreCase("Ammunition") &&
                res.getQuantity() > 0) {
                hasAmmunition = true;
            }
            if (res.getResourceType().equalsIgnoreCase("Equipment") &&
                res.getResourceName().equalsIgnoreCase("Military Vehicle") &&
                res.getQuantity() > 0) {
                hasVehicles = true;
            }
        }

        if (!hasAmmunition || !hasVehicles) {
            throw new IllegalStateException("Required resources for Combat Mission are not available.");
        }

        System.out.println("Combat resources allocated: Ammunition and Military Vehicles.");
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking combat mission progress...");
        this.status = "IN_PROGRESS";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("Combat Mission Report:");
        System.out.println("Mission: " + missionName);
        System.out.println("Status: " + status);
        System.out.println("Personnel: " + assignedPersonnel.size());
        System.out.println("Resources allocated: Ammunition and Military Vehicles.");
    }
}
