public class Amulet implements Accessory{
    protected String name;
    protected int magicResistance;
    Amulet(String name, int magicResistance){
        this.name = name;
        this.magicResistance = magicResistance;
    }
    /** Show stats of the Accessory.
     *  effects: print all stat of the amulet
     */
    public void showStat() {
        System.out.println("Amulet stat's ");
        System.out.println("Magic Resistance: " + this.magicResistance);
    }
}
