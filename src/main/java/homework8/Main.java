package homework8;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Human mother = new Human();
        Human father = new Human();
        Human child = new Human();

        Set<Pet> p = new HashSet<Pet>();

        Set<String> petHabits = new HashSet<String>();

        Set<String> catHabits = new HashSet<String>();

        Pet dog = new Dog(AnimalSpecies.DOG,"wimel", 6, 9, (HashSet<String>) petHabits) {
            @Override
            public String eat() {
                return null;
            }

            @Override
            public String respond() {
                return null;
            }

            @Override
            public String foul() {
                return null;
            }
        };
        dog.getHabits().add("run");
        dog.getHabits().add("eat");
        p.add(dog);

        RoboCat cat = new RoboCat(AnimalSpecies.CAT, "asdfghjk", 10, 51, (HashSet<String>) catHabits) {
            @Override
            public String eat() {
                return null;
            }

            @Override
            public String respond() {
                return null;
            }

            @Override
            public String foul() {
                return null;
            }
        };
        cat.getHabits().add("drink");
        cat.getHabits().add("move");
        p.add(cat);


        Family family = new Family();
        //ArrayList<Human> family = new ArrayList<>();

        mother.setName("Tito");
        mother.setSurname("Karleone");
        /*mother.setYear(1960);
        mother.setIq(60);
        mother.setFather(new Human("Allahverdi", "Hajiyev"));
        mother.setMother(new Human("Allahverdi", "Hajiyev"));
        mother.setSchedule(new String[]{String.valueOf(DayOfWeek.Sunday), Human.tasks[0]});*/


        father.setName("Vito");
        father.setSurname("Karleone");
        /*father.setYear(1970);
        father.setIq(70);
        father.setFather(new Human("Allahverdi", "Hajiyev"));
        father.setMother(new Human("Allahverdi", "Hajiyev"));
        father.setSchedule(new String[]{String.valueOf(DayOfWeek.Thursday), Human.tasks[4]});*/

        child.setName("Michael");
        child.setSurname("Karleone");
        child.setYear(1990);
        child.setIq(50);
        child.setFather(new Human(father.getName(), father.getSurname()));
        child.setMother(new Human(mother.getName(), mother.getSurname()));
        child.setSchedule(Map.of(DayOfWeek.Saturday, Human.tasks[6]));
        child.setFamily(family);

        family.setMother(mother);
        family.setFather(father);
        family.setPet(p);
        //family.addChild(child);
        List<Human> childs = family.addChild(child);
        family.setChildren(childs);

        System.out.println(family.toString());

        for(Human ch : childs) System.out.println(ch.toString());
        // family.deleteChild(0);

        System.out.print("Count of members in the family: " + family.countFamily());

    }
}
