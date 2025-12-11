package tirgul7_practice;
import java.time.LocalDateTime;

public class Battery {
    private int _capacity, precent;
    private String _model;
    private LocalDateTime productionTimestamp;
    private long serialNumber;

    private static long count = 0;

    public Battery(int capacity, String model) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity can't be negative. you tried to enter " + capacity);
        }
        _capacity = capacity;
        if (model == null) {
            throw new IllegalArgumentException("model can't be null");
        }
        this.precent = 100;
        _model = model;
        productionTimestamp = LocalDateTime.now();
        count += 1;
        this.serialNumber = count;
    }

    public Battery() {
        this(100, "default");
    }

    public Battery(Battery other) {
        this(other._capacity, other._model);
    }

    public int get_capacity() {
        return _capacity;
    }

    public String get_model() {
        return _model;
    }

    public LocalDateTime getProductionTimestamp() {
        return productionTimestamp;
    }

    public static long getCount() {
        return count;
    }

    public long getSerialNumber() {
        return this.serialNumber;
    }

    public int getPrecent() {
        return this.precent;
    }

    public void use(){
        this.precent -= 10;
    }
}
