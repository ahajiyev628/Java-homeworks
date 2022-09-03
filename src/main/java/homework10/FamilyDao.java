package homework10;

import java.util.List;

public interface FamilyDao {
    List<homework10.Family> getAllFamilies();
    homework10.Family getFamilyByIndex(int index);
    Boolean deleteFamily(int index);
    Boolean deleteFamily(homework10.Family f);
    List<homework10.Family> saveFamily(Family f);
}
