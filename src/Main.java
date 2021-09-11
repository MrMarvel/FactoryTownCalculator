import java.util.*;

public class Main {


    private static final HashMap<Item, Float> itemsINeedToProduce = new HashMap<>() {{
        //put(Material.Piano, 210f);
        //put(Material.Bed, 1f/220+1f/60);
        //put(Material.Wood_Frame, 1f);
        //put(Material.Piano, 1f/350);
        put(Material.Table, 4f);
        put(Material.Bench, 3f);
    }};
    private static final Set<Item> itemsNotSeparate = newHashSet(Material.Nails);


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        //START
        printItems();
        reBase(1);
        //System.out.println("Замена\n");
        //replaceOres();
        reBase(1);
        //END
        long end = System.currentTimeMillis();
        System.out.printf("Выполнено за %dms%n", end-start);
    }

    private static void reBase(int tries) {
        if (tries >= 50) return;
        Optional<Map.Entry<Item, Float>> res = itemsINeedToProduce.entrySet().stream().filter(e -> e.getKey().getCraft() != null && !itemsNotSeparate.contains(e.getKey())).findFirst();
        Map.Entry<Item, Float> entry = null;
        if (res.isPresent()) entry = res.get();
        if (entry != null) {
            Item itemInBag = entry.getKey();
            float amountInBag = entry.getValue();
            Map<Item, Float> craft = itemInBag.getCraft();
            matrixAddMatrix(itemsINeedToProduce, matrixMultiply(craft, amountInBag));
            itemsINeedToProduce.remove(itemInBag);
        }

        printItems();
        if (itemsINeedToProduce.keySet().stream().anyMatch(item -> item.getCraft() != null && !itemsNotSeparate.contains(item))) reBase(tries+1);
    }

    private static void replaceOres() {
        HashMap<Item, Float> finalMap = new HashMap<>(itemsINeedToProduce);
        finalMap.entrySet().stream()
                .filter(e -> e.getKey() == Material.Iron || e.getKey() == Material.Copper || e.getKey() == Material.Stone)
                .forEach(entry->{
                    Item itemInBag = entry.getKey();
                    float amountInBag = entry.getValue();
                    Item convertTo = null;
                    if (Material.Iron.equals(itemInBag)) {
                        convertTo = Material.AutoMine_Iron;
                    } else if (Material.Stone.equals(itemInBag)) {
                        convertTo = Material.AutoMine_Stone;
                    }
                    if (convertTo != null) {
                        itemsINeedToProduce.put(convertTo, amountInBag);
                        printItems();
                    }
                });
    }

    private static void printItems() {
        itemsINeedToProduce.forEach((item, amount) -> {
            String msg = (item.getCraft() == null || itemsNotSeparate.contains(item) ? "\033[0;31;1m" : "\033[0;33;1m") + String.format(("%-" + (Item.getMaxNameLength() + 2) + "s"), item.getName()) + "\033[0;32;1m" + amount + "\033[0m";
            System.out.println(msg);
        });
        System.out.println();

    }


    @SafeVarargs
    public static <T> Set<T> newHashSet(T... objects) {
        Set<T> set = new HashSet<>();
        Collections.addAll(set, objects);
        return set;
    }

    public static <K> Map<K, Float> matrixAddMatrix (Map<K, Float> map1, Map<K, Float> map2) {
        map2.forEach((k, v) -> {
            if (map1.containsKey(k)) {
                map1.replace(k, map1.get(k)+v);
            } else {
                map1.put(k, v);
            }
        });
        return map1;
    }
    public static <K> Map<K, Float> matrixMultiply (Map<K,Float> map, float mp) {
        Map<K, Float> finalMap = new HashMap<>(map);
        finalMap.forEach((k, v) -> {
            finalMap.replace(k, v*mp);
        });
        return finalMap;
    }
}
