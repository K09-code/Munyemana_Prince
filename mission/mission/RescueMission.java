import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RescueMission extends Mission {
    private List<Resource> allocatedResources;

    public RescueMission(String missionId, String missionName, Date start, Date end) {
        super(missionId, missionName, start, end);
        this.allocatedResources = new ArrayList<>();
    }

    @Override
    public void assignTask() {
        boolean hasMedic = false;
        for (Personnel p : assignedPersonnel) {
            if (p.getRole().equalsIgnoreCase("Medic")) {
                hasMedic = true;
                break;
            }
        }

        if (!hasMedic) {
            throw new IllegalStateException("At least one medic is required for Rescue Mission.");
        }

        System.out.println("Rescue tasks assigned: rescue, medical assistance, logistics.");
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        boolean hasAmbulance = false;
        boolean hasMedicalKits = false;

        for (Resource res : availableResources) {
            if (res.getResourceType().equalsIgnoreCase("Medical Supplies") &&
                res.getResourceName().equalsIgnoreCase("Medical Kit") &&
                res.getQuantity() > 0) {
                hasMedicalKits = true;
            }
            if (res.getResourceType().equalsIgnoreCase("Equipment") &&
                res.getResourceName().equalsIgnoreCase("Ambulance") &&
                res.getQuantity() > 0) {
                hasAmbulance = true;
            }
        }

        if (!hasMedicalKits || !hasAmbulance) {
            throw new IllegalStateException("Required resources for Rescue Mission are not available.");
        }

        System.out.println("Rescue resources allocated: Medical Kits and Ambulances.");
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking rescue mission progress...");
        this.status = "IN_PROGRESS";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("Rescue Mission Report:");
        System.out.println("Mission: " + missionName);
        System.out.println("Status: " + status);
        System.out.println("Personnel: " + assignedPersonnel.size());
        System.out.println("Resources allocated: Medical Kits and Ambulances.");
    }
}
