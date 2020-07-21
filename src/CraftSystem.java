import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class CraftSystem {
    private static Set<Craft> crafts = new HashSet<>();

    public static Set<Craft> getCrafts() {
        return new HashSet<>(crafts);
    }

    public CraftSystem() {

    }
}
