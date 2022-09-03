package homework11;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        FamilyService fs = new FamilyService(new CollectionFamilyDao());

        fs.createNewFamily(new Human("father","father"),new Human("mother","mother"), null);

        Human child1 = new Human("child1","child1",10, 1322018752992l, 10);
        Human child2 = new Human("child2","child2",11,1322018752992l, 20);
        Human child3 = new Human("child3","child3", 12,1322018752992l, 30);
        fs.createNewFamily(new Human("father","father"),new Human("mother","mother"), Arrays.asList(child1, child2));
        fs.createNewFamily(new Human("father","father"),new Human("mother","mother"), Arrays.asList(child3));

        System.out.println(fs.count());

        System.out.println(fs.getAllFamilies().toString());
        System.out.println("");

        Human h2 = new Human("Allahverdi2","Hajiyev2",23, "24/11/1998", 100);
        fs.adoptChild(fs.getFamilyById(0), h2);
        System.out.println("after a child is adopted: ");
        System.out.println(fs.getAllFamilies().toString());
        System.out.println("");

        System.out.println("------------------------------------------------------------------------------");
        System.out.println(fs.displayAllFamilies());

        System.out.println("families with the number of people equal to the number of transfered people:");
        System.out.println(fs.countFamiliesWithMemberNumber());

        System.out.println("family with number of people more than 3");
        System.out.println(fs.getFamiliesBiggerThan(3));

        System.out.println("family with number of people less than 3");
        System.out.println(fs.getFamiliesLessThan(3));

        System.out.println("delete all children older than 20");
        System.out.println(fs.deleteAllChildrenOlderThen(fs.getFamilyById(0),20));

//        System.out.println("Another child:");
//        Human h1 = new Human("Allahverdi1","Hajiyev1", 1322018752992l, 10);
//        System.out.println(h1.toString());
    }
}
