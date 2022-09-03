package homework11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    private final CollectionFamilyDao fams;

    public FamilyService(CollectionFamilyDao fams) {
        this.fams = fams;
    }

    public List<Family> getAllFamilies(){
        return fams.getAllFamilies();
    }

//    public String displayAllFamilies(){
//        return Arrays.toString(fams.getAllFamilies().toArray());
//    }

    public List<Family> displayAllFamilies(){
        return fams.getAllFamilies().stream().toList();
    }


    public Collection<Family> getFamiliesBiggerThan(int n){
        return fams
                .getAllFamilies()
                .stream()
                .filter(f->f.countFamily()>n)
                .collect(Collectors.toList());
    }
    public Collection<Family> getFamiliesLessThan(int n){
        return fams
                .getAllFamilies()
                .stream()
                .filter(f->f.countFamily()<n)
                .collect(Collectors.toList());
    }
    public int countFamiliesWithMemberNumber(){
        List<Family> all_families = fams.getAllFamilies();
        List<Family> fam = all_families
                .stream()
                .filter(f->f.countFamily()==4)
                .collect(Collectors.toList());
        return fam.size();
    }

    public void createNewFamily(Human father, Human mother, List<Human> children){
        fams.families.add(new Family(father,mother, children));
        System.out.println("new Family is created and added to database");
    }

    public void deleteFamilyByIndex(int index){
        fams.deleteFamily(index);
        System.out.println(index + "th family was removed from DAO");
    }

    public static List<Human> deleteChild(Family f, Human child) {
        List<Human> children = new ArrayList<>(f.getChildren());
        int i = 0;
        List<Human> newChildren = new ArrayList<>();
        for (Human ch : children) {
            if (!ch.equals(child)) {
                newChildren.set(i, ch);
                i++;
            }
        }
        System.out.println("Child was deleted");
        children = newChildren;
        return children;
    }

    public Family deleteAllChildrenOlderThen(Family f, int n){
        List<Human> childrens = f.getChildren()
                        .stream()
                        .filter(a->a.getAge()>n)
                .collect(Collectors.toList());

        childrens.forEach((c)->FamilyService.deleteChild(f, c));
        return f;
    }



    public void bornChild(Family family, String gender){
        if(gender.equals("masculine")){
            fams.getAllFamilies()
                    .stream().filter(f->f.equals(family))
                    .findFirst()
                    .get()
                    .addChild(new Human("masculine name","masculine surname"));

        }else if (gender.equals("feminine")) {
            fams.getAllFamilies()
                    .stream().filter(f->f.equals(family))
                    .findFirst().get()
                    .addChild(new Human("feminine name","feminine surname"));
        }
    }

    public Family adoptChild(Family f, Human child) {
        f.addChild(child);
        return f;
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int id) {
        return getAllFamilies().get(id);
    }

    public List<Pet> getPets(int index) {
        return getFamilyById(index).getPet().stream().collect(Collectors.toList());
    }

    public void addPet(int index, Pet p) {
        getFamilyById(index).getPet().add(p);
        System.out.println("a new pet is added to the specified family");
    }
}
