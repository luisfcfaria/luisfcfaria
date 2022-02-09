package academy.mindswap.Fruits;

import java.util.Objects;

public abstract class Fruits {
    private final int ACIDITY_LEVEL;
    String name;

    public Fruits(int acidityLevel) {
        this.ACIDITY_LEVEL = acidityLevel;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruits)) return false;
        Fruits fruits = (Fruits) o;
        return ACIDITY_LEVEL == fruits.ACIDITY_LEVEL && getName().equals(fruits.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACIDITY_LEVEL, getName());
    }

    @Override
    public String toString() {
        return "\n\nFruits{ " +
                "\nacidityLevel = " + ACIDITY_LEVEL +
                ", \nname= '" + name + '\'' +
                '}';
    }
}
