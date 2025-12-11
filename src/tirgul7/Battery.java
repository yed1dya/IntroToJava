package tirgul7;
import java.time.LocalDateTime;

public class Battery {
    // Fields
    private int capacity;
    private String model;
    private final LocalDateTime productionTimestamp;
    private final long serialNumber; // 'final' implies no setter is needed

    // Static counter
    private static int totalBatteriesCreated = 0;

    // Standard Constructor
    public Battery(int capacity, String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative.");
        }

        this.capacity = capacity;
        this.model = model;
        this.productionTimestamp = LocalDateTime.now();

        // Update static counter and assign ID
        this.serialNumber = ++totalBatteriesCreated;
    }

    // Default Constructor
    public Battery() {
        this(100, "Generic"); // Chaining to main constructor
    }

    // Copy Constructor
    public Battery(Battery other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot copy a null battery.");
        }
        this.capacity = other.capacity;
        this.model = other.model;
        this.productionTimestamp = other.productionTimestamp;

        // A copied battery is a NEW physical unit, so it gets a NEW serial number.
        this.serialNumber = ++totalBatteriesCreated;
    }

    // Getters and Setters
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative");
        this.capacity = capacity;
    }

    public String getModel() { return model; }
    public void setModel(String model) {
        if(model == null || model.isEmpty()) throw new IllegalArgumentException("Invalid model");
        this.model = model;
    }

    public LocalDateTime getProductionTimestamp() { return productionTimestamp; }
    // Production time is final and shouldn't have a setter.

    public long getSerialNumber() { return serialNumber; }
    // No setter for Serial Number (it acts as a unique ID).

    // Method: Life Span
    public double calculateLifeSpan(double usageRate) {
        if (usageRate < 0) {
            throw new IllegalArgumentException("Usage rate cannot be negative.");
        }
        if (usageRate == 0) return Double.POSITIVE_INFINITY; // Avoid division by zero
        return this.capacity / usageRate;
    }

    @Override
    public String toString() {
        return "Battery #" + serialNumber + " (" + model + ")";
    }
}
