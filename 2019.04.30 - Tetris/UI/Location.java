package UI;

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
    public Location(Integer x, Integer y) {
        map = new HashMap<String, Integer>();

        map.put("x", x);
        map.put("y", y);
    }

    /**
     * Retreives the {@code Map} that represents the coordinates.
     * @return  a clone of the {@code Map}
     */
    public HashMap<String, Integer> getMap() {
        return new HashMap<String, Integer>(map);
    }

    /**
     * Retreives the x-value of the {@code Location}.
     * @return the x-value
     */
    public Integer getX() {
        return map.get("x");
    }

    /**
     * Retreives the y-value of the {@code Location}.
     * @return the y-value
     */
    public Integer getY() {
        return map.get("y");
    }
}