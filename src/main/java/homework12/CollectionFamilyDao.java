package homework12;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    List<Family> families;

    public CollectionFamilyDao(){
        families = new ArrayList<Family>();
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

