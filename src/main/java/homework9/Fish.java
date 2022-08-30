package homework9;

import java.util.Set;

public class Fish extends Pet {
    public Fish(AnimalSpecies species, String nickname, int age, int tricklevel, Set<String> habits) {
        super(species, nickname, age, tricklevel, habits);
        setSpecies(AnimalSpecies.FISH);
    }

    @Override
    public String eat() {
        return "Fish eats";
    }

    @Override
    public String respond() {
        return "Fish responds";
    }

    @Override
    public String foul() {
        return "Fish fouls";
    }
}