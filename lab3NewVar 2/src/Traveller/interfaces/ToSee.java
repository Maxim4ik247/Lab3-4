package Traveller.interfaces;

import road.environment.Color;

import java.util.HashSet;

public interface ToSee {
    void see(HashSet<Color> colors);
    boolean haveSeen(HashSet<Color> colors);
}
