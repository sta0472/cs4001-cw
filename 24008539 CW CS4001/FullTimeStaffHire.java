/**
 * FullTimeStaffHire: Adds salary and hours, and hire method
 *
 * @STA0472
 * @25.7.25 Resit
 */
public class FullTimeStaffHire extends StaffHire {
    private double salary;
    private int workingHours;
    private String staffName;
    private String joinDate;
    private String qualification;
    private String appointedBy;
    private boolean joined = false;
    
    public FullTimeStaffHire(int vacancyNumber, String designation,
                             double salary, int workingHours) {
        super(vacancyNumber, designation, "Full-Time");
        this.salary        = salary;
        this.workingHours  = workingHours;
    }

    public boolean isJoined() {
        return joined;
    }

    /**
       * Change salary if nobody’s hired yet*/
    public void setSalary(double newSalary) {
        if (!joined) {
            this.salary = newSalary;
        } else {
            System.out.println("Cannot change salary after joining.");
        }
    }

    /**
     * Hire if vacancy is open*/
    public void hireStaff(String name, String date,
                          String qualification, String appointedBy) {
        if (!joined) {
            this.staffName     = name;
            this.joinDate      = date;
            this.qualification = qualification;
            this.appointedBy   = appointedBy;
            this.joined        = true;
        } else {
            System.out.println("Staff already hired.");
        }
    }

    /**
     * Display common vacancy info*/
    @Override
    public void display() {
    // print the base‐class fields via getters
    System.out.println("Vacancy number: "  + getVacancyNumber());
    System.out.println("Designation: "     + getDesignation());
    System.out.println("Job type: "        + getJobType());
    // now the FT‐only fields
    System.out.println("Salary: "          + salary);
    System.out.println("Working Hours: "   + workingHours);
    System.out.println();  // blank line
}
}