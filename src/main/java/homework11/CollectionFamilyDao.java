package homework11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao {
    List<Family> families;

    public CollectionFamilyDao(){
        families = new ArrayList<Family>();
//        Family f1 = new Family(new Human("Allahverdi","Hajiyev"),new Human("Allahverdi","Hajiyev"));
//        Family f2 = new Family(new Human("Hajiyev","Allahverdi"),new Human("Hajiyev","Allahverdi"));
//        Set<Pet> p = new HashSet<Pet>();
//        p.add(new Pet() {
//            @Override
//            public String eat() {
//                return null;
//            }
//
//            @Override
//            public String respond() {
//                return null;
//            }
//
//            @Override
//            public String foul() {
//                return null;
//            }
//        });
//        f1.setPet(p);
//        f2.setPet(p);
//        families.add(f1);
//        families.add(f2);
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

    @Override
    public List<Family> displayAllFamilies() {
        return families.stream().toList();
    }

    @Override
    public List<Family> getFamiliesBiggerThan(int n) {
        return families
                .stream()
                .filter(f->f.countFamily()>n)
                .collect(Collectors.toList());
    }
    @Override
    public List<Family> getFamiliesLessThan(int n) {
        return families
                .stream()
                .filter(f->f.countFamily()<n)
                .collect(Collectors.toList());
    }

    @Override
    public int countFamiliesWithMemberNumber() {
        List<Family> fam = families
                .stream()
                .filter(f->f.countFamily()==4)
                .collect(Collectors.toList());
        return fam.size();
    }

    @Override
    public void createNewFamily(Human father, Human mother, List<Human> children) {
        families.add(new Family(father,mother, children));
        System.out.println("new Family is created and added to database");
    }

    @Override
    public void deleteFamilyByIndex(int index) {
        deleteFamily(index);
        System.out.println(index + "th family was removed from DAO");
    }

    @Override
    public Family deleteAllChildrenOlderThen(Family f, int n) {
        List<Human> childrens = f.getChildren()
                .stream()
                .filter(a->a.getAge()<n)
                .collect(Collectors.toList());

        f.setChildren(childrens);
        return f;
    }

    @Override
    public void bornChild(Family family, String gender) {
        if(gender.equals("masculine")){
            families
                    .stream().filter(f->f.equals(family))
                    .findFirst()
                    .get()
                    .addChild(new Human("masculine name","masculine surname"));

        }else if (gender.equals("feminine")) {
            families
                    .stream().filter(f->f.equals(family))
                    .findFirst().get()
                    .addChild(new Human("feminine name","feminine surname"));
        }
    }

    @Override
    public Family adoptChild(Family f, Human child) {
        f.addChild(child);
        return f;
    }

    @Override
    public int count() {
        return getAllFamilies().size();
    }

    @Override
    public Family getFamilyById(int id) {
        return getAllFamilies().get(id);
    }

    @Override
    public List<Pet> getPets(int index) {
        return getFamilyById(index).getPet().stream().collect(Collectors.toList());
    }

    @Override
    public void addPet(int index, Pet p) {
        getFamilyById(index).getPet().add(p);
        System.out.println("a new pet is added to the specified family");
    }

    public void create(Family family) {
        getAllFamilies().add(family);
        System.out.println("new family is added to DAO");
    }

}

