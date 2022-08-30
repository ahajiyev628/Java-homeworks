package homework9;

import java.util.Set;

public class DomesticCat extends Pet {

    public DomesticCat(AnimalSpecies species, String nickname, int age, int tricklevel, Set<String> habits) {
        super(species, nickname, age, tricklevel, habits);
        setSpecies(AnimalSpecies.DomesticCat);
    }
    @Override
    public String eat() {
        return "Domestic cat eats";
    }

    @Override
    public String respond() {
        return "Domestic cat responds";
    }

    @Override
    public String foul() {
        return "Domestic cat fouls";
    }
}