package UI.Game;

import java.util.HashMap;

/**
 * A {@code Location} represents a coordinate within a {@code Grid}
 * in the format (x, y).
 */
public class Location {
    private HashMap<String, Integer> map;

    /**
     * Creates a {@code Location} object with x-value {@code x}
     * and y-value {@code y}.
     * @param x
     * @param y
     */
    public Location(Integer r, Integer c) {
        map = new HashMap<String, Integer>();

        map.put("r", r);
        map.put("c", c);
    }

    /**
     * Retreives the {@code Map} that represents the coordinates.
     * @return  a clone of the {@code Map}
     */
    public HashMap<String, Integer> getMap() {
        return new HashMap<String, Integer>(map);
    }

    /**
     * Retreives the row-value of the {@code Location}.
     * @return the row-value
     */
    public Integer getR() {
        return map.get("r");
    }

    /**
     * Retreives the column-value of the {@code Location}.
     * @return the column-value
     */
    public Integer getC() {
        return map.get("c");
    }
}