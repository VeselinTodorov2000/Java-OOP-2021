package alarm;

public class AlarmEvent {
    private int nRings;

    public AlarmEvent(int nRings) {
        this.setnRings(nRings);
    }

    public int getnRings() {
        return nRings;
    }

    public void setnRings(int nRings) {
        this.nRings = nRings > 0 ? nRings : 0;
    }
}
