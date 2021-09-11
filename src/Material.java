import java.util.*;

public class Material {
    //RAW
    public static final Item Wood = new Item(null, "Дерево");
    public static final Item Stone = new Item(null, "Камень");
    public static final Item Iron = new Item(null, "Железо");
    public static final Item Copper = new Item(null, "Медь");
    //T1
    public static final Item Fire_Log = new Item(new HashMap<>(){{put(Wood, 1f/6);}}, "Дрова");
    public static final Item Pillar = new Item(new HashMap<>(){{put(Wood, 1f);}}, "Балка(Дерево)");
    //T2
    public static final Item Plank = new Item(new HashMap<>(){{put(Pillar, 2f/7);}},"Планка");
    //T3
    public static final Item Iron_Ingot = new Item(new HashMap<>(){{put(Fire_Log, 3f);put(Iron, 2f);}}, "Железный Слиток");
    public static final Item Copper_Ingot = new Item(new HashMap<>(){{put(Fire_Log, 2f);put(Copper, 1f);}}, "Медный Слиток");
    //T4
    public static final Item Nails = new Item(new HashMap<>(){{put(Iron_Ingot, 1f/10);}}, "Гвозди");
    public static final Item Coil = new Item(new HashMap<>(){{put(Copper_Ingot, 1f);}}, "Катушка");
    public static final Item Iron_Frame = new Item(new HashMap<>(){{put(Iron_Ingot, 1f);}}, "Рама(Железо)");
    public static final Item Iron_Beam = new Item(new HashMap<>(){{put(Iron_Ingot, 3f);}}, "Балка(Железо)");
    //T5
    public static final Item Wood_Frame = new Item(new HashMap<>(){{put(Plank, 4f);put(Nails, 4f);}}, "Рама(Дерево)");
    public static final Item Drill = new Item(new HashMap<>(){{put(Stone, 5f/100);put(Iron_Beam, 1f/100);}}, "Бур");
    //T6
    public static final Item Bed = new Item(new HashMap<>(){{put(Pillar, 2f);put(Wood_Frame, 2f);put(Nails, 2f);put(Plank, 4f);}}, "Кровать");
    public static final Item Table = new Item(new HashMap<>(){{put(Wood_Frame, 1f);put(Pillar, 1f);}}, "Стол");
    public static final Item Bench = new Item(new HashMap<>(){{put(Wood_Frame, 1f);put(Pillar, 1f);}}, "Лавка");
    public static final Item AutoMine_Iron = new Item(new HashMap<>(){{put(Fire_Log, 3f);put(Drill, 2f);}}, "Железо(с Шахтёра)");
    public static final Item AutoMine_Stone = new Item(new HashMap<>(){{put(Fire_Log, 2f);put(Drill, 1f);}}, "Камень(с Шахтёра)");
    //T6
    public static final Item Piano = new Item(new HashMap<>(){{put(Iron_Frame, 1f);put(Bench, 1f);put(Coil, 4f);put(Table, 1f);}}, "Пианино");



    protected static void setCraft(Item item, HashMap<Item, Float> craft) {
        item.setCraft(craft);
    }
}
