package homework10;

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
    public String displayAllFamilies(){
        return Arrays.toString(fams.getAllFamilies().toArray());
    }

    public Collection<Family> getFamiliesBiggerThan(int n){
        return fams
                .getAllFamilies()
                .stream()
                .filter(f->f.countFamily()>n)
                .collect(Collectors.toList());
    }
    public Collection<homework10.Family> getFamiliesLessThan(int n){
        return fams
                .getAllFamilies()
                .stream()
                .filter(f->f.countFamily()<n)
                .collect(Collectors.toList());
    }
    public int countFamiliesWithMemberNumber(homework10.Family f){
        if(f.countFamily()==4) { // initial is 2 (mother and father). 4 means that the family has 2 children
            return f.countFamily();
        }
        return 0;
    }

    public void createNewFamily(Human father, Human mother, List<Human> children){
        fams.families.add(new Family(father,mother, children));
        System.out.println("new Family is created and added to database");
    }

    public void deleteFamilyByIndex(int index){
        fams.deleteFamily(index);
        System.out.println(index + "th family was removed from DAO");
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
