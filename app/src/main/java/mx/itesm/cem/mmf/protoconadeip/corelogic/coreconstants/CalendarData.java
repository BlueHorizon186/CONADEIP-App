package mx.itesm.cem.mmf.protoconadeip.corelogic.coreconstants;

/**
 * Created on 05/11/16.
 */

public enum CalendarData {
    HOME_TEAM(0),
    VISIT_TEAM(1),
    DATE(2),
    HOME_SCORE(3),
    VISIT_SCORE(4),
    STATUS(5),
    TIME(7),
    WEEK(8);

    private final int value;
    private CalendarData(int value) {
        this.value = value;
    }

    public int num() {
        return value;
    }
}
