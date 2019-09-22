
/**
 * Project: Mini - MASSIVE
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */
public class Main
{
    public static void main(String[] args){
        Army allies = new Army(10,0, 5 ,5,0,0,0);
        for (int i = 0; i < 10; i++) {
            System.out.println("Allegiance of " + i + " is " + allies.getAllianceNum());
            System.out.println("Health of " + i + " is " + allies.soldiers.get(i).getHealth());
            System.out.println("Courage of " + i + " is " + allies.soldiers.get(i).getCourage());
            System.out.println("Size of " + i + " is " + allies.soldiers.get(i).getSize());
            System.out.println("Attack of " + i + " is " + allies.soldiers.get(i).getAttack());
            System.out.println("Speed of " + i + " is " + allies.soldiers.get(i).getSpeed());
            System.out.println();
        }
        Army axis = new Army(16,1,0,0,1,10,5);
        for (int i = 0; i < 16; i++) {
            System.out.println("Allegiance of " + i + " is " + axis.getAllianceNum());
            System.out.println("Health of " + i + " is " + axis.soldiers.get(i).getHealth());
            System.out.println("Courage of " + i + " is " + axis.soldiers.get(i).getCourage());
            System.out.println("Size of " + i + " is " + axis.soldiers.get(i).getSize());
            System.out.println("Attack of " + i + " is " + axis.soldiers.get(i).getAttack());
            System.out.println("Speed of " + i + " is " + axis.soldiers.get(i).getSpeed());
            System.out.println();
        }



    }
}
