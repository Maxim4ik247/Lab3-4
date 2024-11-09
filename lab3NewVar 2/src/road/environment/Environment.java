package road.environment;

public class Environment {
    private String name;
    private String description;
    private Color color;

    public Environment(String name, String description, Color color) {
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public void printInfo(){
        System.out.println(this.getName() + " " + this.getDescription());
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Color getColor() {
        return color;
    }
}
