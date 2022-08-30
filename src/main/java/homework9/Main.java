package homework9;

import java.util.*;

public class Main {

    public static <CollectionFamilyDAO> void main(String[] args) {
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

        FamilyDao fams = new FamilyDao() {
            @Override
            public List<Family> getAllFamilies() {
                return null;
            }

            @Override
            public Family getFamilyByIndex(int index) {
                return null;
            }

            @Override
            public Boolean deleteFamily(int index) {
                return null;
            }

            @Override
            public Boolean deleteFamily(Family f) {
                return null;
            }

            @Override
            public List<Family> saveFamily(Family f) {
                return null;
            }
        };
        FamilyService fs = new FamilyService(new CollectionFamilyDao());
        FamilyController fc = new FamilyController(fs);

        fs.createNewFamily(new Human("Allahverdi","Hajiyev"),new Human("Allahverdi","Hajiyev"));
        System.out.println(fs.getAllFamilies());
        System.out.println(fs.count());
        System.out.println(fs.displayAllFamilies());
        System.out.println(fs.getPets(0));
        System.out.println(fs.getFamiliesLessThan(2));
        System.out.println(fs.getFamiliesBiggerThan(1));
        fs.createNewFamily(new Human("Allahverdi2","Hajiyev"),new Human("Allahverdi2","Hajiyev"));
        System.out.println(fs.getAllFamilies());
    }
}
