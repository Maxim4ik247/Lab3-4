package Traveller;

import Transport.Transport;
import Traveller.interfaces.ToSeat;

public record Animal(String name, String type) implements ToSeat {

    @Override
    public void toSeat(Transport transport) {
        System.out.println(type + " " + name + " запрыгивает в " + transport.getName());
        transport.seat(this);
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
