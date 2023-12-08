public interface Character {
    /** Recover character's hp and mana
     *  effects: increase character's hp and mana by 30% but can't heal dead character
     *  effects: print character healed if heal-able. if not print character can't be healed
     */
    void recovery();
    /** Revive dead character
     *  effects: Revive dead character back to live and fully heal their hp and mana
     *  effects: print character revived if can be revived, if not, print blessing waste
     */
    void godRevive();
    /** Update character stats
     *  effects: update character's stats to match up their level and equipment
     */
    void updateStat();
    /** Recover character's hp and mana
     *  required: levels you want to increase in positive int
     *  effects: increase character level
     *  effects: print "character leveled up!!" and character new level
     */
    void levelUp(int level);
    /** Equip sword to the character
     *  effects: equip the sword to the character and give character the sword's stats
     *  effects: print what sword character is going to equip if they can equip any, if not, print that they can't
     */
    void equip(Sword sword);
    /** Unequipped sword of the character
     *  effects: Unequipped the sword of the character and take away the character the sword's stats
     *  effects: print if they are unequipped or not
     */
    void unEquip(Sword sword);
    /** Equip shield to the character
     *  effects: equip the shield to the character and give character the shield's stats
     *  effects: print if character equipped shield or not
     */
    void equip(Shield shield);
    /** Unequipped shield of the character
     *  effects: Unequipped the shield of the character and take away the character the shield's stats
     *  effects: print if character is unequipped or not
     */
    void unEquip(Shield shield);

    /** Show character's stats
     *  effects: print all available stats of the character
     */
    void showStat();

    /** Upgrade character's sword
     * effects: increase sword's level and update its stats
     * effects: print character is upgrading the sword and its new level.
     * @param sword the sword you want to upgrade
     * @param level the level you want to increase
     */
    void upgrade(Sword sword, int level);

    /** Upgrade character's shield
     * effects: increase shield's level and update its stats
     * effects: print character is upgrading the shield and its new level.
     * @param shield the shield you want to upgrade
     * @param level the level you want to increase
     */
    void upgrade(Shield shield, int level);
}
