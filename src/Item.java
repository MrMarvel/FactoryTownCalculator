import java.util.HashMap;
import java.util.Map;

public class Item {
    private static int maxNameLength = 1;

    private Map<Item, Float> craftedFrom;
    private String name;

    public Item(Map<Item, Float> craftedFrom, String name) {
        this.craftedFrom = craftedFrom;
        this.name = name;
        if (maxNameLength < name.length()) maxNameLength = name.length();
    }

    public Map<Item, Float> getCraft() {
        return craftedFrom;
    }

    public String getName() {
        return name;
    }
    public static int getMaxNameLength() {
        return maxNameLength;
    }


    protected  void setCraft(HashMap<Item, Float> craft) {
        craftedFrom = craft;
    }
}
