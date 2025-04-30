import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ReconMission extends Mission {
    private List<Resource> allocatedResources;

    public ReconMission(String missionId, String missionName, Date start, Date end) {
        super(missionId, missionName, start, end);
        this.allocatedResources = new ArrayList<>();
    }

    @Override
    public void assignTask() {
        if (assignedPersonnel.size() < 2) {
            throw new IllegalStateException("At least two personnel are required for Recon Mission.");
        }
        System.out.println("Recon tasks assigned: surveillance, intelligence gathering.");
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        boolean hasDrone = false;
        for (Resource res : availableResources) {
            if (res.getResourceType().equalsIgnoreCase("Equipment") &&
                res.getResourceName().toLowerCase().contains("drone") &&
                res.getQuantity() > 0) {
                allocatedResources.add(res);
                res.decreaseQuantity(1);
                hasDrone = true;
                break;
            }
        }
        if (!hasDrone) {
            throw new IllegalStateException("No drones available for Recon Mission.");
        }
        System.out.println("Recon resources allocated: Drones and Communication tools.");
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking reconnaissance progress...");
        this.status = "IN_PROGRESS";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("Recon Mission Report:");
        System.out.println("Mission: " + missionName);
        System.out.println("Status: " + status);
        System.out.println("Personnel: " + assignedPersonnel.size());
        System.out.println("Resources: " + allocatedResources.size());
    }
}
