package UI;

import java.util.HashMap;

public class Location {
    private HashMap map;

    public Location(int x, int y) {
        map.put("x", x);
        map.put("y", y);
    }

    public int getX() {
        return map.get("x");
    }

    public int getY() {
        return map.get("y");
    }
}