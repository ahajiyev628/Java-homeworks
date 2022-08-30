package homework9;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TestUnit {
    FamilyDao fams = new FamilyDao() {
        @Override
        public List<homework9.Family> getAllFamilies() {
            return null;
        }

        @Override
        public homework9.Family getFamilyByIndex(int index) {
            return null;
        }

        @Override
        public Boolean deleteFamily(int index) {
            return null;
        }

        @Override
        public Boolean deleteFamily(homework9.Family f) {
            return null;
        }

        @Override
        public List<homework9.Family> saveFamily(Family f) {
            return null;
        }
    };
    FamilyService fs = new FamilyService(new CollectionFamilyDao());
    FamilyController fc = new FamilyController(fs);

    @Test
    public void firstTest() {
        fs.createNewFamily(new Human("Allahverdi","Hajiyev"),new Human("Allahverdi","Hajiyev"));
        System.out.println(fs.getAllFamilies());
        System.out.println(fs.displayAllFamilies());
        System.out.println(fs.getPets(0));
        System.out.println(fs.getFamiliesLessThan(2));
        System.out.println(fs.getFamiliesBiggerThan(1));
        fs.createNewFamily(new Human("Allahverdi2","Hajiyev"),new Human("Allahverdi2","Hajiyev"));
        System.out.println(fs.getAllFamilies());

        //Assert.assertEquals(4, fs.count());

        //Assert.assertNull(fs.getFamiliesLessThan(2));

        Assert.assertNotSame(fs.getFamilyById(0), fs.getFamilyById(1));
    }
}
