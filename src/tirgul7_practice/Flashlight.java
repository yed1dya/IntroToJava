package tirgul7_practice;

public class Flashlight {
    private Battery battery;

    public Flashlight(Battery battery) {
        this.battery = new Battery(battery);
    }

    public Battery getBattery() {
        return this.battery;
    }

    public void turnOn(){
        System.out.println("flashlight is on");
        this.battery.use();
    }
}
