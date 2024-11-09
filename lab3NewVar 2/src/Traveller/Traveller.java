package Traveller;

import Transport.Transport;
import Traveller.interfaces.ToSeat;
import Traveller.interfaces.ToSee;
import road.environment.Color;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public record Traveller(String name, int age, ArrayList<Set<Color>> views) implements ToSee, ToSeat {
    public Traveller(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void see(HashSet<Color> colors) {
        views.add(colors);
    }

    @Override
    public boolean haveSeen(HashSet<Color> colors) {
        return views.contains(colors);
    }

    @Override
    public void toSeat(Transport transport) {
        System.out.println(name + " садится в " + transport.getName());
        transport.seat(this);
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Traveller traveller)) return false;
        return age == traveller.age && Objects.equals(name, traveller.name) && Objects.equals(views, traveller.views);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, views);
    }
}
