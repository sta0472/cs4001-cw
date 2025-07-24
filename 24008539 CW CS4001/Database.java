
/**
 * Database: Holds all vacancies in list
 *
 * @STA0472
 * @25.7.25 Resit
 */
import java.util.ArrayList;

public class Database {
    private ArrayList<StaffHire> staffList = new ArrayList<>();

    public void add(StaffHire staff) {
        staffList.add(staff);
    }

    public StaffHire getVacancy(int index) {
        if (index >= 0 && index < staffList.size())
            return staffList.get(index);
        else
            return null;
    }

    public void listAll() {
        for (StaffHire s : staffList) {
            s.display();
        }
    }
/**
 * Returns full list*/
public ArrayList<StaffHire> getStaffList() {
    return staffList;
}
}

