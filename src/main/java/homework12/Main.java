package homework12;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static DayOfWeek dw;
    public static String gender_boy = "boy";
    public static String gender_girl = "girl";

    public static void main(String[] args) throws ParseException {
        String[] tasks = {"do homework", "go to courses", "watch a film", "play a game", "meet with friends", "go for shopping", "go to sport"};

        Human mother2 = new Human("mother name", "mother surname", "24/11/1998", 100, new HashMap<>());
        mother2.getSchedule().put(DayOfWeek.Saturday, tasks[6]);

        Human father2 = new Human("father name", "father surname", "24/11/1998", 100, new HashMap<>());
        father2.getSchedule().put(DayOfWeek.Monday, tasks[1]);
        father2.getSchedule().put(DayOfWeek.Tuesday, tasks[2]);

        FamilyService fs = new FamilyService(new CollectionFamilyDao());

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

//        fs.getFamilyById(0).getChildren()
//                .stream()
//                .forEach(s->s.setSchedule(new HashMap<>()));

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

        Human child3 = new Human();
        child3.setName("Jack");
        child3.setSurname("Karleone");
        child3.setIq(60);
        child3.setSchedule(new HashMap<>());
        child3.getSchedule().put(DayOfWeek.Sunday, tasks[0]);
        fs.bornChild(family, child3, gender_boy);

        System.out.println(family.getChildren().size());

        System.out.println(family.prettyFormat());

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        fs.createNewFamily(new Human(), new Human());
        Family family2 = fs.getAllFamilies().get(1);
        family2.setMother(new Human());
        family2.setFather(new Human());
        family2.setChildren(new ArrayList<>());
        family2.setPet(new HashSet<>());

        fs.bornChild(family2, new Human(), gender_boy);
        fs.bornChild(family2, new Human(), gender_girl);
        fs.bornChild(family2, new Human(), gender_boy);

        family2.getChildren().get(0).setSchedule(new HashMap<>());
        family2.getChildren().get(1).setSchedule(new HashMap<>());
        family2.getChildren().get(2).setSchedule(new HashMap<>());
        family2.getMother().setSchedule(new HashMap<>());
        family2.getFather().setSchedule(new HashMap<>());

        System.out.println(family2.prettyFormat());

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Iterator<Family> it = fs.getAllFamilies().iterator();
        for (int i = 1; it.hasNext(); i++) {
            System.out.println(i + " Family:    " + it.next());
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println();
        Scanner sc = new Scanner(System.in);


        System.out.println();
        System.out.println("Type '1' if you are looking for families with the most family members");
        System.out.println("Type '2' if you are looking for families with the least family members");
        System.out.println("Type '3' if you are looking for families with the specified family members");
        System.out.println("Type '4' if you want to create a new family");
        System.out.println("Type '5' if you want to delete a family");
        System.out.println("Type '6' if you want to edit a family member");
        System.out.println("Type '7' if you want to adopt a new child for the family");
        System.out.println();

        boolean forAllMethods = true;
        while (forAllMethods) {
            System.out.println("Now, enter one of the 6 number or type 'exit' to exit: ");
            String navBar = sc.next();
            if (navBar.equals("1")) {
                try {
                    System.out.print("Enter a number to get families having number of members bigger than that number: ");
                    Collection<Family> f1 = fs.getFamiliesBiggerThan(sc.nextInt());
                    Iterator<Family> iter1 = f1.iterator();
                    for (int i = 1; iter1.hasNext(); i++) {
                        System.out.println(i + " Family:    " + iter1.next());
                    }
                } catch (Exception ex) {
                    System.err.println("No familes found");
                }
            } else if (navBar.equals("2")) {
                try {
                    System.out.print("Enter a number to get families having number of members less than that number: ");
                    Collection<Family> f2 = fs.getFamiliesLessThan(sc.nextInt());
                    Iterator<Family> iter2 = f2.iterator();
                    for (int i = 1; iter2.hasNext(); i++) {
                        System.out.println(i + " Family:    " + iter2.next());
                    }
                } catch (Exception ex) {
                    System.err.println("No familes found");
                }
            } else if (navBar.equals("3")) {
                System.out.print("Enter a number to get families having number of members equals that number: ");
                int member_cnt = sc.nextInt();
                List<Family> fmm = fs.getAllFamilies().stream()
                        .filter(s -> s.getChildren().size() + 2 == member_cnt)
                        .collect(Collectors.toList());
                Iterator<Family> iter3 = fmm.iterator();
                for (int i = 1; iter3.hasNext(); i++) {
                    System.out.println(i + " Family:    " + iter3.next());
                }
            } else if (navBar.equals("4")) {
                Human father3 = new Human();
                System.out.print("father name: ");
                father3.setName(sc.nextLine());
                System.out.print("father surname: ");
                father3.setSurname(sc.nextLine());
                System.out.print("father IQ: ");
                father3.setIq(sc.nextInt());
                father3.setBirthDate(sc.nextLine());
                father3.setSchedule(new HashMap<>());
                System.out.print("father task: ");
                father3.getSchedule().put(DayOfWeek.Thursday, sc.nextLine());

                Human mother3 = new Human();
                System.out.print("mother name: ");
                mother3.setName(sc.nextLine());
                System.out.print("mother surname: ");
                mother3.setSurname(sc.nextLine());
                System.out.print("mother IQ: ");
                mother3.setIq(sc.nextInt());
                mother3.setBirthDate(sc.nextLine());
                mother3.setSchedule(new HashMap<>());
                System.out.print("mother task: ");
                mother3.getSchedule().put(DayOfWeek.Wednesday, sc.nextLine());

                fs.createNewFamily(father3, mother3);
                Family family3 = fs.getAllFamilies().get(2);
                family3.setFather(father3);
                family3.setMother(mother3);
                family3.setChildren(new ArrayList<>());
                family3.setPet(new HashSet<>());

                System.out.println(family3.prettyFormat());
            } else if (navBar.equals("5")) {

                System.out.println("delete family by its position: ");
                int deleted = sc.nextInt();
                System.out.print("Delete family in position: ");
                fs.deleteFamilyByIndex(deleted);

                //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            } else if (navBar.equals("6")) {
                int position = sc.nextInt();
                Family fam = fs.getFamilyById(position);
                Iterator<Human> childs = fam.getChildren().iterator();
                Human h = childs.next();
                if (childs.hasNext()) {
                    h.setBirthDate("24/11/1998");
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////

            else if (navBar.equals("7")) {
                Human adopted = new Human();
                adopted.setName("adopted");
                adopted.setSurname("adopted");
                adopted.setIq(60);
                adopted.setSchedule(new HashMap<>());
                adopted.getSchedule().put(DayOfWeek.Sunday, tasks[0]);
                fs.bornChild(family, adopted, gender_boy);
                int limit = sc.nextInt();
                fs.adoptChild(family, adopted);
                int cnt2 = family.getChildren().size() + 2;
                if (cnt2 > limit) throw new FamilyOverflowException("Error");
            } else if (navBar.toLowerCase().equals("exit")) {
                forAllMethods = false;
            } else {
                forAllMethods = true;
            }
        }
    }
}
