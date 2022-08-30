package homework8;

import java.util.Set;

public class Dog extends Pet {
    public Dog(AnimalSpecies species, String nickname, int age, int tricklevel, Set<String> habits) {
        super(species, nickname, age, tricklevel, habits);
        setSpecies(AnimalSpecies.DOG);
    }

    @Override
    public String eat() {
        return "Dog eats";
    }

    @Override
    public String respond() {
        return "Dog responds";
    }

    @Override
    public String foul() {
        return "Dog fouls";
    }
}