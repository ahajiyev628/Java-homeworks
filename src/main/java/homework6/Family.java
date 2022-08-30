package homework6;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human[] children = new Human[0];
    private Pet pet;
    private Human mother;
    private Human father;

    public Family(Pet pet, Human mother, Human father, Human[] children) {
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Family() {
    }

    public Human[] deleteChild(Human child) {
        int i = 0;
        if (children.length > 1) {
            Human[] newChildren = new Human[children.length - 1];
            for (Human ch : children) {
                if (!ch.equals(child)) {
                    newChildren[i] = ch;
                    i++;
                }
            }
            this.children = newChildren;
        }
        return children;
    }

    public Human[] addChild(Human child) {
        Human[] newChildren = new Human[children.length + 1];
        newChildren[children.length] = child;
        for (int i = 0; i < children.length; i++) {
            newChildren[i] = children[i];
        }
        this.children = newChildren;
        return children;
    }

    public Human[] deleteChild(int position) {
        int j = 0;
        if (position > 0 && position < children.length) {
            Human[] newChildren = new Human[children.length - 1];
            for (int i = 0; i < children.length; i++) {
                if (position != i) {
                    newChildren[j] = children[i];
                    j++;
                }
            }
            this.children = newChildren;
        } else {
            throw new IndexOutOfBoundsException("Please enter the correct index");
        }
        return children;
    }

    public int countFamily() {
        return children.length + 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(pet, family.pet) && Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Arrays.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pet, mother, father);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    public String toString() {
        return "Family{" +
                "pet=" + pet +
                ", mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("redefined finalize() method");
    }

}
