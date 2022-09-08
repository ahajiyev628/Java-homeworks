package homework13;

import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    Boolean deleteFamily(int index);
    Boolean deleteFamily(Family f);
    List<Family> saveFamily(Family f);
}
