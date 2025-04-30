public class Resource {
    private String resourceId;
    private String resourceName;
    private int quantity;
    private String resourceType;

    public Resource(String id, String name, int qty, String type) {
        this.resourceId = id;
        this.resourceName = name;
        this.quantity = qty;
        this.resourceType = type;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            throw new IllegalStateException("Not enough quantity for resource: " + resourceName);
        }
    }
}
