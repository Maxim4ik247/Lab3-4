import Transport.*;
import Traveller.*;
import road.*;
import road.environment.*;


public class Main {
    public static void main(String[] args) {
        Environment justRoad = new Environment("Подьем", "Дорога", Color.NONE);
        SectionOfRoad sectionOfRoad1 = new SectionOfRoad(justRoad, SectionOfRoad.Gradient.UP);

        Environment ground = new Environment("Земля", "Большие круги", Color.MULTICOLORED);
        SectionOfRoad sectionOfRoad2 = new SectionOfRoad(ground, SectionOfRoad.Gradient.STREIGHT);

        Environment stripes = new Environment("Полоски", "В горошинку", Color.NONE);
        SectionOfRoad sectionOfRoad3 = new SectionOfRoad(stripes, SectionOfRoad.Gradient.STREIGHT);

        Environment hills = new Environment("Холмы", "Покрыты полосками ситца в мелкую крапинку", Color.MULTICOLORED);
        SectionOfRoad sectionOfRoad4 = new SectionOfRoad(hills, SectionOfRoad.Gradient.STREIGHT);

        Environment forest = new Environment("Лесная просека", "Ровная", Color.NONE);
        SectionOfRoad sectionOfRoad5 = new SectionOfRoad(forest, SectionOfRoad.Gradient.DOWN);

        Environment maks = new Environment("Заросли мака", "Длинные зеленые стебли, а вверху так и сверкали на солнышке красные цветы мака.", Color.RED);
        SectionOfRoad sectionOfRoad6 = new SectionOfRoad(maks, SectionOfRoad.Gradient.DOWN);

        Road road = new Road();
        road.getSectionOfRoads().add(sectionOfRoad1);
        road.getSectionOfRoads().add(sectionOfRoad2);
        road.getSectionOfRoads().add(sectionOfRoad3);
        road.getSectionOfRoads().add(sectionOfRoad4);
        road.getSectionOfRoads().add(sectionOfRoad5);
        road.getSectionOfRoads().add(sectionOfRoad6);

        Car car = new Car("Porshe", 3);

        Traveller traveller = TravellerGenerator.generateTraveller();
        traveller.toSeat(car);

        Animal animal = new Animal("Белка", "Собака");
        Animal animal2 = new Animal("Стрелка", "Собака");

        animal.toSeat(car);
        animal2.toSeat(car);

        car.go(road);
//        car.go(road);

    }
}