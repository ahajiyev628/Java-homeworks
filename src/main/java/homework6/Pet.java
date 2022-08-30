package homework6;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    String[] habits;

    private Family family;

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public Pet() {

    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits, Family family) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
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

    public void setTrickLevel(int trickLevel) {
        if (trickLevel > 100 || trickLevel < 0) {
            //System.out.println("Trick level should be between 0 and 100");
            this.trickLevel = Integer.parseInt("");
            return;
        }
        this.trickLevel=trickLevel;
    }

    public int getTrickLevel() {
        return this.trickLevel;
    }

    // Constructor with all the fields
    public Pet(String species, String nickname, int age, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet (String nickname) {
        this.nickname = nickname;
    }

    public void eat() {
        System.out.println("I am eating");
    }

    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!", this.nickname);
        System.out.println("");
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    public static String tLevel(int a) {
        if (a > 50) {
            return "very sly";
        } else {
            return "almost not sly";
        }
    }

    public void describePet() {
        System.out.println("I have a " + getSpecies() + ", he is " + getAge() + " years old, he is " + tLevel(getTrickLevel()));
    }

    public void greetPet() {
        System.out.println("Hello, " + getNickname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname) && Arrays.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "species='" + species + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() method was redefined in Pet class");
    }

}
