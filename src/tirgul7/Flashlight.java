package tirgul7;

public class Flashlight {
    private Battery battery;

    // Constructor with Deep Copy logic
    public Flashlight(Battery battery) {
        if (battery == null) {
            throw new IllegalArgumentException("Flashlight requires a battery.");
        }
        // Deep copy: We create a NEW battery based on the input.
        // The serial number will be different (new object = new ID).
        this.battery = new Battery(battery);
    }

    // Change Battery [cite: 26]
    public void changeBattery(Battery newBattery) {
        // Here we might verify that the new battery is compatible or not null
        if (newBattery == null) throw new IllegalArgumentException("Invalid battery");

        // To ensure the flashlight owns its battery uniquely:
        this.battery = new Battery(newBattery);
    }
}
