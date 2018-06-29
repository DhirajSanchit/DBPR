package DB;

import java.awt.List;
import java.util.ArrayList;

public class Result {

    private String type;
    private ArrayList<Signaal> signals;

    public Result(String type, ArrayList<Signaal> signals) {
        this.type = type;
        this.signals = signals;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Signaal> getSignals() {
        return signals;
    }

}
