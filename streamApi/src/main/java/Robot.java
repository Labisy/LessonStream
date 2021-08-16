public class Robot {

    private final String name;
    private final int Strength;
    private final int speed;
    private final Classification classification;

    public Robot(String name, int strength, int speed, Classification classification) {
        this.name = name;
        Strength = strength;
        this.speed = speed;
        this.classification = classification;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return Strength;
    }

    public int getSpeed() {
        return speed;
    }

    public Classification getClassification() {
        return classification;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", Strength=" + Strength +
                ", speed=" + speed +
                ", classification=" + classification +
                '}';
    }
}
