package homework11;

import java.text.ParseException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ParseException {
        FamilyController fc = new FamilyController();

        Human child1 = new Human("child1","child1",10, 1322018752992l, 10);
        Human child2 = new Human("child2","child2",11,1322018752992l, 20);
        Human child3 = new Human("child3","child3", 12,1322018752992l, 30);
        fc.createNewFamily(new Human("father","father"),new Human("mother","mother"), Arrays.asList(child1, child2));
        fc.createNewFamily(new Human("father","father"),new Human("mother","mother"), Arrays.asList(child3));

        System.out.println(fc.count());

        System.out.println(fc.getAllFamilies().toString());
        System.out.println("");

        Human h2 = new Human("Allahverdi2","Hajiyev2",23, "24/11/1998", 100);
        fc.adoptChild(fc.getFamilyById(0), h2);
        System.out.println("after a child is adopted: ");
        System.out.println(fc.getAllFamilies().toString());
        System.out.println("");

        System.out.println("------------------------------------------------------------------------------");
        System.out.println(fc.displayAllFamilies());

        System.out.println("families with the number of people equal to the number of transfered people:");
        System.out.println(fc.countFamiliesWithMemberNumber());

        System.out.println("family with number of people more than 3");
        System.out.println(fc.getFamiliesBiggerThan(3));

        System.out.println("family with number of people less than 3");
        System.out.println(fc.getFamiliesLessThan(3));


        System.out.println(fc.getFamilyById(0).toString());

        fc.getFamilyById(0).getChildren().add(new Human("aaaa", "bbbbb", 12, "24/11/1998", 50));

        System.out.println(fc.getFamilyById(0).toString());

        System.out.println(fc.getFamilyById(0).getChildren().get(0).getAge());
        System.out.println(fc.getFamilyById(0).getChildren().get(1).getAge());

        System.out.println("delete all children older than 20");
        System.out.println(fc.deleteAllChildrenOlderThen(fc.getFamilyById(0),20));

//        System.out.println("Another child:");
//        Human h1 = new Human("Allahverdi1","Hajiyev1", 1322018752992l, 10);
//        System.out.println(h1.toString());
    }
}
