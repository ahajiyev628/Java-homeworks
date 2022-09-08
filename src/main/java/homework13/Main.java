package homework13;

import java.io.*;
import java.util.List;
import java.text.ParseException;
import java.util.*;

public class Main {
    private static DayOfWeek dw;
    public static String gender_boy = "masculine";
    public static String gender_girl = "feminine";
    public static String path = "/home/ufaz/Downloads/test.txt";
    public static void main(String[] args) throws ParseException, IOException {
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


        //System.out.println(fs.getFamilyById(0).prettyFormat());

        ///////////////////////////////////////////////////

        //Path path = Paths.get("../home/ufaz/Downloads/ideaIU-2022.2.1/idea-IU-222.3739.54/test.txt");

        //String path = "/home/ufaz/Downloads/test.txt";

        loadData(fs.getAllFamilies());


    }
    public static void loadData(List<Family> families) throws IOException {
        Iterator<Family> iter = families.iterator();

        FileWriter fw = new FileWriter(path, false);
        PrintWriter out = new PrintWriter(fw);
        out.println(iter.next().prettyFormat());
        out.close();

        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
