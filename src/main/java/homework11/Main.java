package homework11;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        FamilyService fs = new FamilyService(new CollectionFamilyDao());

        fs.createNewFamily(new Human("father","father"),new Human("mother","mother"), null);

        System.out.println(fs.count());

        System.out.println(fs.getAllFamilies().toString());
        System.out.println("");

        Human h2 = new Human("Allahverdi2","Hajiyev2", "24/11/1998", 100);
        fs.adoptChild(fs.getFamilyById(0), h2);
        System.out.println("after a child is adopted: ");
        System.out.println(fs.getAllFamilies().toString());
        System.out.println("");

        System.out.println("Another child:");
        Human h1 = new Human("Allahverdi1","Hajiyev1", 1322018752992l, 10);
        System.out.println(h1.toString());
    }
}
