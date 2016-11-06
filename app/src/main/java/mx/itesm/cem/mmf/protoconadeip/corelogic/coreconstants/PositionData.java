package mx.itesm.cem.mmf.protoconadeip.corelogic.coreconstants;

/**
 * Created on 05/11/16.
 */

public enum PositionData {
    TEAM_NAME(0),
    PLAYED_GAMES(2),
    WON_GAMES(3),
    POINTS(7),
    PERCENTAGE(8);

    private final int value;
    private PositionData(int value) {
        this.value = value;
    }

    public int num() {
        return value;
    }
}
