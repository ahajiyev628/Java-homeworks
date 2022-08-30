package homework9;

import java.util.*;

public class Main {

    public static <CollectionFamilyDAO> void main(String[] args) {
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

        System.out.println(fs.count());
    }
}
