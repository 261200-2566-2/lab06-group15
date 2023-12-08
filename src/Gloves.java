public class Gloves implements Accessory{
    protected String name;
    protected int attackSpeed;
    protected int magicResistance;
    Gloves(String name, int magicResistance, int attackSpeed){
        this.name = name;
        this.magicResistance = magicResistance;
        this.attackSpeed = attackSpeed;
    }
    /** Show stats of the Accessory.
     *  effects: print all stat of the gloves
     */
    public void showStat() {
        System.out.println("Gloves stat's ");
        System.out.println("Magic Resistance: " + this.magicResistance);
        System.out.println("Attack Speed: " + this.attackSpeed);
    }
}
