package homework12;

import java.text.ParseException;
import java.util.*;

public class Main {
    private static DayOfWeek dw;
    public static void main(String[] args) throws ParseException {
        String[] tasks = {"do homework", "go to courses", "watch a film", "play a game", "meet with friends", "go for shopping", "go to sport"};

        Human mother2 = new Human("mother name", "mother surname", "24/11/1998", 100, new HashMap<>());
        mother2.getSchedule().put(DayOfWeek.Saturday, tasks[6]);

        Human father2 = new Human("father name", "father surname", "24/11/1998", 100, new HashMap<>());
        father2.getSchedule().put(DayOfWeek.Monday, tasks[1]);
        father2.getSchedule().put(DayOfWeek.Tuesday, tasks[2]);

        FamilyService fs = new FamilyService(new CollectionFamilyDao());

        fs.createNewFamily(father2,mother2);



        //System.out.println("mother: " + mother2.toString());
        //System.out.println("father: " + father2.toString());

        Human child = new Human();

        Set<Pet> p = new HashSet<Pet>();

        Set<String> petHabits = new HashSet<String>();

        Set<String> catHabits = new HashSet<String>();

        Pet dog = new Pet(AnimalSpecies.DOG,"wimel", 6, 9, (HashSet<String>) petHabits) {
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

        Pet cat = new Pet(AnimalSpecies.CAT, "asdfghjk", 10, 51, (HashSet<String>) catHabits) {
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

        Family family = fs.getAllFamilies().get(0);

        child.setName("Michael");
        child.setSurname("Karleone");
        child.setIq(50);
        child.setSchedule(new HashMap<>());
        child.getSchedule().put(DayOfWeek.Tuesday, tasks[2]);

        family.setPet(p);
        family.setMother(mother2);
        family.setFather(father2);
        List<Human> childs = family.addChild(child);
        family.setChildren(childs);

        System.out.println(fs.getFamilyById(0).prettyFormat());
    }
}
