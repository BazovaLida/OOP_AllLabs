package Lab7;

import Lab6V2.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySet mySet = new MySet();
        ElectricAppliances refr = new Refrigerator("холодильник", 113, (float) 22.6, "white", "Japan", 40);
        ElectricAppliances iron = new Iron("праска", 2400, (float) 1.7, "purple", "France", 20);
        ElectricAppliances lap1 = new Laptop("Сірий ноутбук", 130, (float) 2.2, "grey", "China", 50, (float) 15.6);
        ElectricAppliances lap2 = new Laptop("Чорний ноутбук", 90, (float) 1.8, "black", "USA", 35, (float) 14.0);

        mySet.add(iron);
        mySet.add(lap1);
        mySet.add(lap2);
        mySet.add(refr);

        Iterator<ElectricAppliances> iterator = mySet.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(mySet.contains(new Laptop("Чорний ноутбук", 90, (float) 1.8, "black", "USA", 35, (float) 14.0)));
        System.out.println("Done!");

    }
}
