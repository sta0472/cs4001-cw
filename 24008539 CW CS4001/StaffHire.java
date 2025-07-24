/**
 * StaffHire Class: Base class with 3 common fields
 *
 * @STA0472
 * @Resit 25.7.25
 */
public abstract class StaffHire {
    private final int vacancyNumber;
    private final String designation;
    private final String jobType;

    public StaffHire(int vacancyNumber, String designation, String jobType) {
        this.vacancyNumber = vacancyNumber;
        this.designation   = designation;
        this.jobType       = jobType;
    }

    public int    getVacancyNumber() { return vacancyNumber; }
    public String getDesignation()   { return designation;   }
    public String getJobType()       { return jobType;       }

    public abstract void display();
}