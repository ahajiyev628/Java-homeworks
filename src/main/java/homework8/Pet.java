package homework8;

import java.util.HashSet;
import java.util.Set;

public abstract class Pet {
    private AnimalSpecies species;
    private String nickname;
    private int age;
    private int tricklevel;
    private Set<String> habits;

    public Pet(AnimalSpecies species, String nickname, int age, int tricklevel, Set<String> habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.tricklevel = tricklevel;
        this.habits = habits;
    }

    public Pet(AnimalSpecies species, String nickname)
    {
        this.species=species;
        this.nickname=nickname;
    }

    public Pet(String nickname, int age, int tricklevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.tricklevel = tricklevel;
        this.habits = habits;
    }

    public Pet(AnimalSpecies dog, int age, int tricklevel, HashSet<String> habits) {
    }

    public AnimalSpecies getSpecies() {
        return species;
    }

    public void setSpecies(AnimalSpecies species) {
        this.species = species;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTricklevel() {
        return tricklevel;
    }

    public void setTricklevel(int tricklevel) {
        this.tricklevel = tricklevel;
    }


    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public abstract String eat();
    public abstract String respond();
    public abstract String foul();

    public String greetPet() {
        return "Hello, " + nickname;
    }

    public static String tLevel(int a) {
        if (a > 50) {
            return "very sly";
        } else {
            return "almost not sly";
        }
    }

    @Override
    public String toString() {
        return "Pet{" +
                "species=" + species +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", tricklevel=" + tricklevel +
                ", habits=" + habits +
                '}';
    }

    public String describePet() {
        return "I have a " + species + ", he is " + age + " years old, he is " + tLevel(this.getTricklevel());
    }
}
