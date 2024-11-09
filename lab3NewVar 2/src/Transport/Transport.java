package Transport;

import Exceptions.CarOverload;
import Traveller.Traveller;
import Traveller.interfaces.ToSeat;
import Traveller.interfaces.ToSee;
import road.Road;
import road.environment.Color;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Transport {
    private String name;
    private int capacity;
    private ArrayList<ToSeat> passengers = new ArrayList<>();
    private ArrayList<Traveller> humans = new ArrayList<>();


    public Transport(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void go(Road road){
        int number = road.getSectionOfRoads().size();
        boolean upIsOver = false;
        for (int i = 0; i<number; i++){
            System.out.println("-------------------");
            switch (road.getSectionOfRoads().get(i).getGradient()){
                case UP:
                    System.out.println("Дорога идет вверх вверх");
                    System.out.println("Путешественники еду среди:");
                    road.getSectionOfRoads().get(i).getEnvironment().printInfo();
                    upIsOver = true;
                    break;
                case DOWN:
                    System.out.println("Дорога пошла вниз");
                    road.getSectionOfRoads().get(i).getEnvironment().printInfo();
                    break;
                case STREIGHT:
                    System.out.println("Машина едет вперед, путешественников окружает:");
                    road.getSectionOfRoads().get(i).getEnvironment().printInfo();

                    if(upIsOver){
                        System.out.println("Подъем закончился, перед путешественниками открылась картина:");

                        HashSet<Color> colors = road.getView(i);

                        boolean nobodySaw = true;
                        for (Traveller traveller: humans){
                            if (traveller.haveSeen(colors)){
                                System.out.println("==" + traveller.getName() + " уже видел подобный пейзаж==");
                                nobodySaw = false;
                            }
                        }
                        if (nobodySaw){
                            System.out.println("==Никто из пассажиров никогда не видел такой картины==");
                        }
                        humans.forEach(traveller -> traveller.see(colors));

                        upIsOver = false;
                    }
                    break;
            }
            System.out.println("-------------------");
        }
    }

    public void seat(ToSeat passenger){
        if (capacity>0) {
            passengers.add(passenger);

            if (passenger instanceof ToSee){
                humans.add((Traveller) passenger);
            }

            capacity-=1;
        }
        else {
            throw new CarOverload("транспорт перегружен");
            }
    }


    public String getName() {
        return name;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
