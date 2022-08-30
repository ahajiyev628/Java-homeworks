package homework9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionFamilyDao implements FamilyDao {
    List<Family> families;

    public CollectionFamilyDao(){
        families = new ArrayList<Family>();
        Family f1 = new Family(new Human("Allahverdi","Hajiyev"),new Human("Allahverdi","Hajiyev"));
        Family f2 = new Family(new Human("Hajiyev","Allahverdi"),new Human("Hajiyev","Allahverdi"));
        Set<Pet> p = new HashSet<Pet>();
        p.add(new Pet() {
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
        });
        f1.setPet(p);
        f2.setPet(p);
        families.add(f1);
        families.add(f2);
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return families.get(index);
    }

    @Override
    public Boolean deleteFamily(int index) {
        if (index < families.size()){
            families.remove(families.get(index));
            return true;
        } else return false;
    }

    @Override
    public Boolean deleteFamily(Family f) {
        return families.remove(f);
    }

    @Override
    public List<Family> saveFamily(Family f) {
        families.add(f);
        return families;
    }

    public void create(Family family) {
        getAllFamilies().add(family);
        System.out.println("new family is added to DAO");
    }
}

