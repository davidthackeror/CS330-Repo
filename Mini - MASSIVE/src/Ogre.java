class Ogre extends Orc{
    private static String name = "Ogre";


    Ogre(int minHealth, int maxHealth, int minSpeed, int maxSpeed, int minCourage, int maxCourage, int size, int minAttack, int maxAttack) {
        super(minHealth*2, maxHealth*2, minSpeed/2, maxSpeed/2, minCourage, maxCourage*2, size*2, minAttack*2, maxAttack*2);
    }

    public String getName() { return Ogre.name; }

}
