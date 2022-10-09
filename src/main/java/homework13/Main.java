package homework13;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static String gender_boy = "masculine";
    public static String gender_girl = "feminine";

    public static void main(String[] args) throws ParseException, IOException {
        String[] tasks = {"do homework", "go to courses", "watch a film", "play a game", "meet with friends", "go for shopping", "go to sport"};
        FamilyService fs = new FamilyService(new CollectionFamilyDao());

        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Type '1' if you want to add a new family to the database");
        System.out.println("Type '2' if you want to read and display all the families in the console");
        System.out.println();

        boolean forAllMethods = true;
        while (forAllMethods) {
            System.out.println();
            System.out.println("Now, enter 1 or 2, or type 'exit' to exit: ");
            String item = sc.next();

            if (item.equals("1")) {
                // fs.loadData(fs.getAllFamilies());
                Human father2 = new Human();
                System.out.print("father name: ");
                father2.setName(sc.nextLine());
                System.out.print("father surname: ");
                father2.setSurname(sc.nextLine());
                System.out.print("father IQ: ");
                father2.setIq(sc.nextInt());
                father2.setBirthDate(sc.nextLine());
                father2.setSchedule(new HashMap<>());
                System.out.print("father task: ");
                father2.getSchedule().put(DayOfWeek.Thursday, sc.nextLine());

                Human mother2 = new Human();
                System.out.print("mother name: ");
                mother2.setName(sc.nextLine());
                System.out.print("mother surname: ");
                mother2.setSurname(sc.nextLine());
                System.out.print("mother IQ: ");
                mother2.setIq(sc.nextInt());
                mother2.setBirthDate(sc.nextLine());
                mother2.setSchedule(new HashMap<>());
                System.out.print("mother task: ");
                mother2.getSchedule().put(DayOfWeek.Wednesday, sc.nextLine());

                fs.createNewFamily(father2, mother2);


                //System.out.println("mother: " + mother2.toString());
                //System.out.println("father: " + father2.toString());

                Set<Pet> p = new HashSet<Pet>();

                Set<String> petHabits = new HashSet<String>();
                Set<String> catHabits = new HashSet<String>();

                Pet dog = new Pet(AnimalSpecies.DOG, "wimel", 6, 9, (HashSet<String>) petHabits) {
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

                family.setPet(p);
                family.setMother(mother2);
                family.setFather(father2);

                fs.getFamilyById(0).setChildren(new ArrayList<Human>());

                Human child1 = new Human();
                child1.setName("Michael");
                child1.setSurname("Karleone");
                child1.setIq(50);
                child1.setSchedule(new HashMap<>());
                child1.getSchedule().put(DayOfWeek.Tuesday, tasks[2]);
                fs.bornChild(family, child1, gender_boy);

                Human child2 = new Human();
                child2.setName("Jane");
                child2.setSurname("Karleone");
                child2.setIq(80);
                child2.setSchedule(new HashMap<>());
                child2.getSchedule().put(DayOfWeek.Thursday, tasks[4]);
                fs.bornChild(family, child2, gender_girl);

                fs.loadData(fs.getAllFamilies());
            } else if (item.equals("2")) {
                fs.readData();
            } else if (item.toLowerCase().equals("exit")) {
                forAllMethods = false;
            } else {
                forAllMethods = true;
            }
        }
    }
}
