import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class HumanitarianMission extends Mission {
    private List<Resource> allocatedResources;

    public HumanitarianMission(String missionId, String missionName, Date start, Date end) {
        super(missionId, missionName, start, end);
        this.allocatedResources = new ArrayList<>();
    }

    @Override
    public void assignTask() {
        System.out.println("Humanitarian tasks assigned: logistics, distribution, medical aid.");
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        boolean hasFood = false;
        boolean hasMedicalKits = false;
        boolean hasTransport = false;

        for (Resource res : availableResources) {
            if (res.getResourceType().equalsIgnoreCase("Food Supplies") &&
                res.getResourceName().equalsIgnoreCase("Food") &&
                res.getQuantity() > 0) {
                hasFood = true;
            }
            if (res.getResourceType().equalsIgnoreCase("Medical Supplies") &&
                res.getResourceName().equalsIgnoreCase("Medical Kit") &&
                res.getQuantity() > 0) {
                hasMedicalKits = true;
            }
            if (res.getResourceType().equalsIgnoreCase("Equipment") &&
                res.getResourceName().equalsIgnoreCase("Transport Vehicle") &&
                res.getQuantity() > 0) {
                hasTransport = true;
            }
        }

        if (!hasFood || !hasMedicalKits || !hasTransport) {
            throw new IllegalStateException("Required resources for Humanitarian Mission are not available.");
        }

        System.out.println("Humanitarian resources allocated: Food, Medical Kits, and Transport.");
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking humanitarian mission progress...");
        this.status = "IN_PROGRESS";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("Humanitarian Mission Report:");
        System.out.println("Mission: " + missionName);
        System.out.println("Status: " + status);
        System.out.println("Personnel: " + assignedPersonnel.size());
        System.out.println("Resources allocated: Food, Medical Kits, and Transport.");
    }
}
