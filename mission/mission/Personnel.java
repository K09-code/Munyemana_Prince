public class Personnel {
    private String personnelId;
    private String personnelName;
    private String personnelRole;
    private Mission assignedMission;

    public Personnel(String id, String name, String role) {
        this.personnelId = id;
        this.personnelName = name;
        this.personnelRole = role;
    }

    public String getRole() {
        return personnelRole;
    }

    public void setAssignedMission(Mission mission) {
        this.assignedMission = mission;
    }

    public Mission getAssignedMission() {
        return assignedMission;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Personnel)) return false;
        Personnel p = (Personnel) obj;
        return this.personnelId.equals(p.personnelId);
    }

    @Override
    public int hashCode() {
        return personnelId.hashCode();
    }
}
