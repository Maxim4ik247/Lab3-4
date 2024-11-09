package Traveller;

import java.util.Random;

public class TravellerGenerator {
    private static String[] names = {"Наташа", "Дмитрий", "Антон", "Марина", "Аня", "Сергей"};
    public static Traveller generateTraveller(){
        Random random = new Random();
        Traveller traveller = new Traveller(names[random.nextInt(names.length)], random.nextInt(100));
        return traveller;
    }
}
