package homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Family {
    private Human father = new Human();
    private Human mother = new Human();
    List<Human> children = new ArrayList<>();

    private Set<Pet> pet;

    public Family(Human father, Human mother, List<Human> children, Set<Pet> pet) {
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.pet = pet;
    }

    public Family(Human father, Human mother, ArrayList<Human> children) {
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Family() {

    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }

    public List<Human> addChild(Human child) {
        List<Human> newChildren = new ArrayList<>();
        int i = 0;
        newChildren.add(i, child);
        i++;
        System.out.println("Child was added");
        this.children = newChildren;
        return children;
    }

    /*public Human addChild(Human child) {
        ArrayList<Human> newChildren = new ArrayList<>();
        newChildren.add(children.size(), child);
        this.children = newChildren;
        return newChildren.get(newChildren.size()-1);
    }
    */
    public List<Human> deleteChild(Human child) {
        int i = 0;
        ArrayList<Human> newChildren = new ArrayList<>();
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

    public List<Human> deleteChild(int position) {
        int j = 0;
        if (position >= 0) {
            ArrayList<Human> newChildren = new ArrayList<>();
            for (int i = 0; i < children.size(); i++) {
                if (position != i) {
                    newChildren.set(j, children.get(i));
                    j++;
                }
            }
            System.out.println("Child was deleted");
            children = newChildren;
        } else {
            throw new IndexOutOfBoundsException("there is no child");
        }
        return children;
    }

    public int countFamily() {
        return children.size() + 2;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(father, family.father) && Objects.equals(mother, family.mother) && Objects.equals(children, family.children);
    }
    @Override
    public int hashCode() {
        return Objects.hash(father, mother, children);
    }


    @Override
    public String toString() {
        return "Family{" +
                "father=" + father +
                ", mother=" + mother +
                ", children=" + children +
                ", pet=" + pet +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() method in Family class was called");
    }
}
