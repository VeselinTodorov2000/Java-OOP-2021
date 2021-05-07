package trafficLight;

public enum TrafficLight {
    RED(3_000),
    GREEN(3_000),
    YELLOW(3_000);

    private int duration;

    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
