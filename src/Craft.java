public final class Craft {
    private Item inputItem, outputItem;
    private int inputAmount, outputAmount;

    //               Wood   X 2  --->  Planks  X 7
    public Craft(Item in, int in2, Item out, int out2) {
        inputItem = in;
        inputAmount = in2;
        outputItem = out;
        outputAmount = out2;
    }

}
