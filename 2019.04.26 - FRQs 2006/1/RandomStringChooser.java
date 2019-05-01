public class RandomStringChooser {
    private String[] strings;
    private int stringsChosen;
    
    public RandomStringChooser(String[] arr) {
        strings = arr;
        stringsChosen = 0;
    }

    private int getIndex() {
        return (int) (Math.random() * (strings.length));
    }

    public String getNext() {
        String str = "";
        int index = -1;

        if (stringsChosen >= strings.length) return "NONE";

        do {
            index = getIndex();
            str = strings[index];
            if (str != null) break;
        } while(str != null);

        stringsChosen++;
        strings[index] = null;
        return str;
    }
}