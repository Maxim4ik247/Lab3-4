package road;

import road.environment.Environment;
import road.environment.Gradient;

public class SectionOfRoad {
    private Environment environment;
    private Gradient gradient;

    public enum Gradient {
        UP, STREIGHT, DOWN;
    }

    public SectionOfRoad(Environment environment, Gradient gradient) {
        this.environment = environment;
        this.gradient = gradient;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public Gradient getGradient() {
        return gradient;
    }

    @Override
    public String toString() {
        return "SectionOfRoad{" +
                "environment=" + environment +
                '}';
    }
}
