public class Cleric {
    protected String name;
    protected int level = 1;
    protected double maxHP = 100+10*(level-1);
    protected double hp = maxHP;
    protected Boolean dead = false;
    protected double maxMana = 50+2*(level-1);
    protected double mana = maxMana;
    protected double maxAttackSpeed = 30*(0.1+0.03*(level-1));
    protected double attackSpeedPenalty = 0;
    protected double attackSpeed = maxAttackSpeed*((100-attackSpeedPenalty)/100);
    protected double healBonus = 0.3 + (double) level /200;
    protected double attack;
    protected double defense;
    protected double magicResistance = 15;
    protected Sword sword;
    protected Boolean swordEquipped = false;
    protected Shield shield;
    protected Boolean shieldEquipped = false;
    protected Ring ring;
    protected Amulet amulet;
    protected Gloves gloves;
    Cleric(String name,int level){
        this.name = name;
        this.level = level;
        updateStat();
        hp = maxHP;
        mana = maxMana;
    }
    Cleric(String name,int level,Sword sword){
        this.name = name;
        this.level = level;
        attack = sword.damage;
        swordEquipped = true;
        this.sword = sword;
        attackSpeedPenalty += 5;
        updateStat();
        hp = maxHP;
        mana = maxMana;
    }
    Cleric(String name,int level,Shield shield){
        this.name = name;
        this.level = level;
        defense = shield.defense;
        shieldEquipped = true;
        this.shield = shield;
        attackSpeedPenalty += 10;
        updateStat();
        hp = maxHP;
        mana = maxMana;
    }
    Cleric(String name,int level,Sword sword,Shield shield){
        this.name = name;
        this.level = level;
        attack = sword.damage;
        swordEquipped = true;
        this.sword = sword;
        attackSpeedPenalty += 5;
        defense = shield.defense;
        shieldEquipped = true;
        this.shield = shield;
        attackSpeedPenalty += 10;
        updateStat();
        hp = maxHP;
        mana = maxMana;
    }
    /** Recover character's hp and mana
     *  effects: increase character's hp and mana by 30% but can't heal dead character
     *  effects: print character healed if heal-able. if not print character can't be healed
     */
    public void recovery(){
        if(!dead){
            System.out.println("-------------------------------------");
            System.out.println(name + " is healed");
            System.out.println("-------------------------------------");
            hp = maxHP*0.3;
            mana = maxMana*0.3;
        }else{
            System.out.println("-------------------------------------");
            System.out.println("We already lost " + name);
            System.out.println("Nothing can heal " + name);
            System.out.println("-------------------------------------");
        }

    }
    /** Revive dead character
     *  effects: Revive dead character back to live and fully heal their hp and mana
     *  effects: print character revived if can be revived, if not, print blessing waste
     */
    public void godRevive(){
        if(dead){
            System.out.println("-------------------------------------");
            System.out.println(name + " received god's blessing!");
            System.out.println(name + " has come back to life!!!");
            System.out.println("-------------------------------------");
            dead = false;
            hp = maxHP;
            mana = maxMana;
        }else{
            System.out.println("-------------------------------------");
            System.out.println(name + " has wasted god's blessing!");
            System.out.println("-------------------------------------");
        }
    }
    /** Update character stats
     *  effects: update character's stats to match up their level and equipment
     */
    public void updateStat(){
        maxHP = 100+10*(level-1);
        maxMana = 50+2*(level-1);
        maxAttackSpeed = 30*(0.1+0.03*(level-1));
        attackSpeed = maxAttackSpeed*((100-attackSpeedPenalty)/100);
        healBonus = 0.3 + (double) level /200;
        if(healBonus > 0.85) healBonus = 0.85;
        if(swordEquipped) attack = sword.damage;
        if(shieldEquipped) defense = shield.defense;
    }
    /** Recover character's hp and mana
     *  required: levels you want to increase in positive int
     *  effects: increase character level
     *  effects: print "character leveled up!!" and character new level
     */
    public void levelUp(int level){
        this.level += level;
        updateStat();
        System.out.println("-------------------------------------");
        System.out.println(name + " level up!!!");
        System.out.println(name + " is now level " + level);
        System.out.println("-------------------------------------");
        if(!dead) recovery();
    }
    /** Equip sword to the character
     *  effects: equip the sword to the character and give character the sword's stats
     *  effects: print what sword character is going to equip if they can equip any, if not, print that they can't
     */
    public void equip(Sword sword){
        if(!swordEquipped){
            System.out.println("-------------------------------------");
            System.out.println(name + " is equipping " + sword.name);
            System.out.println("-------------------------------------");
            attack = sword.damage;
            swordEquipped = true;
            this.sword = sword;
            attackSpeedPenalty += 5;
        }else{
            System.out.println("-------------------------------------");
            System.out.println(name + " already equipping " + sword.name);
            System.out.println(name + " can't equip any more sword!");
            System.out.println("-------------------------------------");
        }
    }
    /** Unequipped sword of the character
     *  effects: Unequipped the sword of the character and take away the character the sword's stats
     *  effects: print if they are unequipped or not
     */
    public void unEquip(Sword sword){
        if(swordEquipped){
            System.out.println("-------------------------------------");
            System.out.println(name + " is unequipping " + sword.name);
            System.out.println("-------------------------------------");
            attack = 0.0;
            swordEquipped = false;
            this.sword = null;
            attackSpeedPenalty -= 5;
        }else{
            System.out.println("-------------------------------------");
            System.out.println(name + " isn't equipping any sword!");
            System.out.println("-------------------------------------");
        }
    }
    /** Equip shield to the character
     *  effects: equip the shield to the character and give character the shield's stats
     *  effects: print if character equipped shield or not
     */
    public void equip(Shield shield){
        if(!shieldEquipped){
            System.out.println("-------------------------------------");
            System.out.println(name + " is equipping " + shield.name);
            System.out.println("-------------------------------------");
            defense = shield.defense;
            shieldEquipped = true;
            this.shield = shield;
            attackSpeedPenalty += 10;
        }else{
            System.out.println("-------------------------------------");
            System.out.println(name + " already equipping " + shield.name);
            System.out.println(name + " can't equip any more shield!");
            System.out.println("-------------------------------------");
        }
    }
    /** Unequipped shield of the character
     *  effects: Unequipped the shield of the character and take away the character the shield's stats
     *  effects: print if character is unequipped or not
     */
    public void unEquip(Shield shield){
        if(shieldEquipped){
            System.out.println("-------------------------------------");
            System.out.println(name + " is unequipped " + shield.name);
            System.out.println("-------------------------------------");
            defense = 0.0;
            shieldEquipped = false;
            this.shield = null;
            attackSpeedPenalty -= 10;
        }else{
            System.out.println("-------------------------------------");
            System.out.println(name + " isn't equipping any shield!");
            System.out.println("-------------------------------------");
        }
    }
    /** Equip ring to the character
     * effects: increase character's stats by the ring stats
     * @param ring the ring you want to equip to the character
     */
    public void equip(Ring ring){
        this.ring = ring;
        this.maxHP += ring.hpAddition;
        updateStat();
    }
    /** Equip amulet to the character
     * effects: increase character's stats by the amulet stats
     * @param amulet the amulet you want to equip to the character
     */
    public void equip(Amulet amulet){
        this.amulet = amulet;
        this.magicResistance += this.magicResistance*amulet.magicResistance;
        updateStat();
    }
    /** Equip gloves to the character
     * effects: increase character's stats by the gloves stats
     * @param gloves the gloves you want to equip to the character
     */
    public void equip(Gloves gloves){
        this.gloves = gloves;
        this.magicResistance += gloves.magicResistance;
        this.maxAttackSpeed += gloves.attackSpeed;
        updateStat();
    }
    /** Show character's stats
     *  effects: print all available stats of the character
     */
    public void showStat(){
        System.out.println("-------------------------------------");
        System.out.println(name + "'s Stat ");
        System.out.println("Level: " + level);
        if(dead){
            System.out.println("HP: " + this.hp + "/" +maxHP + " [DEAD]");
        }else{
            System.out.println("HP: " + this.hp + "/" +maxHP);
        }
        System.out.println("MP: " + this.mana + "/" +maxMana);
        System.out.println("Attack Speed: " + this.attackSpeed + "/" +maxAttackSpeed);
        System.out.println("Damage: " + this.attack);
        System.out.println("Defense: " + this.defense);
        System.out.println("Healing Bonus: " + this.healBonus*100 + "%");
        if(sword != null) System.out.println("Sword: " + sword.name);
        if(shield != null) System.out.println("Shield: " + shield.name);
        if(gloves != null) System.out.println("Gloves: " + gloves.name);
        if(amulet != null) System.out.println("Amulet: " + amulet.name);
        if(ring != null) System.out.println("Ring: " + ring.name);
        System.out.println("-------------------------------------");
    }
    /** attack opponent (4 method() for each class of characters)
     * effects: decrease opponent hp by the damage cause after calculated with opponent defense
     * effects: if attacker is dead, attacker can't attack.
     * effects: if opponent is dead, opponent can't be attacked.
     * effects: if attack successful print damage given and opponent remaining hp
     * @param opponent the opponent you want to attack
     */
    public void attack(Warrior opponent){
        if(!dead){
            if(!opponent.dead){
                System.out.println("-------------------------------------");
                System.out.println(this.name + " Attack " + opponent.name + "!");
                double damage = this.attack-opponent.defense;
                System.out.println(this.name + " dealt " + damage +" damage!");
                if(damage >= opponent.hp) damage = opponent.hp;
                if(damage < 0) damage = 0;
                opponent.hp -= damage;
                System.out.println(opponent.name + "'s remaining HP is " + opponent.hp);
                System.out.println("-------------------------------------");
                if(opponent.hp <= 0) {
                    opponent.dead = true;
                    System.out.println(opponent.name + " Dead");
                    System.out.println("-------------------------------------");
                }
            }else{
                System.out.println("-------------------------------------");
                System.out.println(this.name + " can't attack " + opponent.name + "!");
                System.out.println(opponent.name + " is already dead!!!");
                System.out.println("-------------------------------------");
            }
        }else{
            System.out.println(name + " is dead. " + name + " can't attack.");
        }
    }
    public void attack(Archer opponent){
        if(!dead){
            if(!opponent.dead){
                System.out.println("-------------------------------------");
                System.out.println(this.name + " Attack " + opponent.name + "!");
                double damage = this.attack-opponent.defense;
                System.out.println(this.name + " dealt " + damage +" damage!");
                if(damage >= opponent.hp) damage = opponent.hp;
                if(damage < 0) damage = 0;
                opponent.hp -= damage;
                System.out.println(opponent.name + "'s remaining HP is " + opponent.hp);
                System.out.println("-------------------------------------");
                if(opponent.hp <= 0) {
                    opponent.dead = true;
                    System.out.println(opponent.name + " Dead");
                    System.out.println("-------------------------------------");
                }
            }else{
                System.out.println("-------------------------------------");
                System.out.println(this.name + " can't attack " + opponent.name + "!");
                System.out.println(opponent.name + " is already dead!!!");
                System.out.println("-------------------------------------");
            }
        }else{
            System.out.println(name + " is dead. " + name + " can't attack.");
        }
    }
    public void attack(Cleric opponent){
        if(!dead){
            if(!opponent.dead){
                System.out.println("-------------------------------------");
                System.out.println(this.name + " Attack " + opponent.name + "!");
                double damage = this.attack-opponent.defense;
                System.out.println(this.name + " dealt " + damage +" damage!");
                if(damage >= opponent.hp) damage = opponent.hp;
                if(damage < 0) damage = 0;
                opponent.hp -= damage;
                System.out.println(opponent.name + "'s remaining HP is " + opponent.hp);
                System.out.println("-------------------------------------");
                if(opponent.hp <= 0) {
                    opponent.dead = true;
                    System.out.println(opponent.name + " Dead");
                    System.out.println("-------------------------------------");
                }
            }else{
                System.out.println("-------------------------------------");
                System.out.println(this.name + " can't attack " + opponent.name + "!");
                System.out.println(opponent.name + " is already dead!!!");
                System.out.println("-------------------------------------");
            }
        }else{
            System.out.println(name + " is dead. " + name + " can't attack.");
        }
    }
    public void attack(Sorceress opponent){
        if(!dead){
            if(!opponent.dead){
                System.out.println("-------------------------------------");
                System.out.println(this.name + " Attack " + opponent.name + "!");
                double damage = this.attack-opponent.defense;
                System.out.println(this.name + " dealt " + damage +" damage!");
                if(damage >= opponent.hp) damage = opponent.hp;
                if(damage < 0) damage = 0;
                opponent.hp -= damage;
                System.out.println(opponent.name + "'s remaining HP is " + opponent.hp);
                System.out.println("-------------------------------------");
                if(opponent.hp <= 0) {
                    opponent.dead = true;
                    System.out.println(opponent.name + " Dead");
                    System.out.println("-------------------------------------");
                }
            }else{
                System.out.println("-------------------------------------");
                System.out.println(this.name + " can't attack " + opponent.name + "!");
                System.out.println(opponent.name + " is already dead!!!");
                System.out.println("-------------------------------------");
            }
        }else{
            System.out.println(name + " is dead. " + name + " can't attack.");
        }
    }
    /** Upgrade character's sword
     * effects: increase sword's level and update its stats
     * effects: print character is upgrading the sword and its new level.
     * @param sword the sword you want to upgrade
     * @param level the level you want to increase
     */
    public void upgrade(Sword sword, int level){
        sword.level += level;
        sword.damage = 15*(1+0.1*(sword.level-1));
        updateStat();
        System.out.println("-------------------------------------");
        System.out.println(name + " is upgrading " + sword.name + "!");
        System.out.println(sword.name + "'s level is now " + sword.level + "!!!");
        System.out.println("-------------------------------------");
    }
    /** Upgrade character's shield
     * effects: increase shield's level and update its stats
     * effects: print character is upgrading the shield and its new level.
     * @param shield the shield you want to upgrade
     * @param level the level you want to increase
     */
    public void upgrade(Shield shield, int level){
        shield.level += level;
        shield.defense  = 10*(1+0.05*(shield.level-1));
        updateStat();
        System.out.println("-------------------------------------");
        System.out.println(name + " is upgrading " + shield.name + "!");
        System.out.println(shield.name + "'s level is now " + shield.level + "!!!");
        System.out.println("-------------------------------------");
    }
    /** duel the two character (4 method() each for character classes)
     * effects: print that two character are dueling
     * effects: the character who is greater in attack speed will be the one who can attack
     * @param opponent the character you want to duel
     */
    public void duel(Warrior opponent){
        System.out.println("-------------------------------------");
        System.out.println(this.name + " and " + opponent.name + " are dueling!!!");
        System.out.println("-------------------------------------");
        if(this.attackSpeed > opponent.attackSpeed) {
            this.attack(opponent);
        }
        else if (opponent.attackSpeed > this.attackSpeed) {
            opponent.attack(this);
        }else {
            this.attack(opponent);
            opponent.attack(this);
        }
    }
    public void duel(Archer opponent){
        System.out.println("-------------------------------------");
        System.out.println(this.name + " and " + opponent.name + " are dueling!!!");
        System.out.println("-------------------------------------");
        if(this.attackSpeed > opponent.attackSpeed) {
            this.attack(opponent);
        }
        else if (opponent.attackSpeed > this.attackSpeed) {
            opponent.attack(this);
        }else {
            this.attack(opponent);
            opponent.attack(this);
        }
    }
    public void duel(Cleric opponent){
        System.out.println("-------------------------------------");
        System.out.println(this.name + " and " + opponent.name + " are dueling!!!");
        System.out.println("-------------------------------------");
        if(this.attackSpeed > opponent.attackSpeed) {
            this.attack(opponent);
        }
        else if (opponent.attackSpeed > this.attackSpeed) {
            opponent.attack(this);
        }else {
            this.attack(opponent);
            opponent.attack(this);
        }
    }
    public void duel(Sorceress opponent){
        System.out.println("-------------------------------------");
        System.out.println(this.name + " and " + opponent.name + " are dueling!!!");
        System.out.println("-------------------------------------");
        if(this.attackSpeed > opponent.attackSpeed) {
            this.attack(opponent);
        }
        else if (opponent.attackSpeed > this.attackSpeed) {
            opponent.magicAttack(this);
        }else {
            this.attack(opponent);
            opponent.magicAttack(this);
        }
    }

    /** Heal the target (4 method() for each of character classes)
     * effects: increase target's hp by healing stat(max at 85% of hp)
     * effects: print if target is healed or not
     * @param target the target you want to heal
     */
    public void heal(Warrior target){
        if(!target.dead){
            target.hp += target.maxHP*healBonus;
            if(target.hp > target.maxHP) target.hp = target.maxHP;
            target.mana += target.maxMana*healBonus;
            if(target.mana > target.maxMana) target.mana = target.maxMana;
            System.out.println("-------------------------------------");
            System.out.println(name + " healed " + target.name + "!");
            System.out.println(target.name + "'s remaining HP is now " + target.hp);
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("We already lost " + name);
            System.out.println("Nothing can heal " + name);
            System.out.println("-------------------------------------");
        }
    }
    public void heal(Archer target){
        if(!target.dead){
            target.hp += target.maxHP*healBonus;
            if(target.hp > target.maxHP) target.hp = target.maxHP;
            target.mana += target.maxMana*healBonus;
            if(target.mana > target.maxMana) target.mana = target.maxMana;
            System.out.println("-------------------------------------");
            System.out.println(name + " healed " + target.name + "!");
            System.out.println(target.name + "'s remaining HP is now " + target.hp);
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("We already lost " + name);
            System.out.println("Nothing can heal " + name);
            System.out.println("-------------------------------------");
        }
    }
    public void heal(Cleric target){
        if(!target.dead){
            target.hp += target.maxHP*healBonus;
            if(target.hp > target.maxHP) target.hp = target.maxHP;
            target.mana += target.maxMana*healBonus;
            if(target.mana > target.maxMana) target.mana = target.maxMana;
            System.out.println("-------------------------------------");
            System.out.println(name + " healed " + target.name + "!");
            System.out.println(target.name + "'s remaining HP is now " + target.hp);
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("We already lost " + name);
            System.out.println("Nothing can heal " + name);
            System.out.println("-------------------------------------");
        }
    }
    public void heal(Sorceress target){
        if(!target.dead){
            target.hp += target.maxHP*healBonus;
            if(target.hp > target.maxHP) target.hp = target.maxHP;
            target.mana += target.maxMana*healBonus;
            if(target.mana > target.maxMana) target.mana = target.maxMana;
            System.out.println("-------------------------------------");
            System.out.println(name + " healed " + target.name + "!");
            System.out.println(target.name + "'s remaining HP is now " + target.hp);
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("We already lost " + name);
            System.out.println("Nothing can heal " + name);
            System.out.println("-------------------------------------");
        }
    }
}
