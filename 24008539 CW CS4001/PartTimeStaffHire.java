
/**
 * PartTimeStaffHire: manages wages, hours, shifts and terminate method
 * @STA0472
 * @25.7.25 Resit
 */
public class PartTimeStaffHire extends StaffHire {
    private double wagesPerHour;
    private int workingHours;
    private String shifts;
    private String staffName;
    private String joinDate;
    private String qualification;
    private String appointedBy;
    private boolean joined    = false;
    private boolean terminated = false;

    public PartTimeStaffHire(int vacancyNumber, String designation,
                             double wagesPerHour, int workingHours,
                             String shifts) {
        super(vacancyNumber, designation, "Part-Time");
        this.wagesPerHour = wagesPerHour;
        this.workingHours = workingHours;
        this.shifts       = shifts;
    }

    public void hireStaff(String name, String date,
                          String qualification, String appointedBy) {
        if (!joined) {
            this.staffName     = name;
            this.joinDate      = date;
            this.qualification = qualification;
            this.appointedBy   = appointedBy;
            this.joined        = true;
            this.terminated    = false;
        } else {
            System.out.println("Staff already hired.");
        }
    }
/**
 * Terminates part time staff if already hired
 */
    public void terminateStaff() {
        if (joined && !terminated) {
            this.joined     = false;
            this.terminated = true;
        } else if (terminated) {
            System.out.println("Contract already terminated.");
        } else {
            System.out.println("No staff to terminate.");
        }
    }

    @Override
    public void display() {
        System.out.println("--- Part-Time Staff ---");
        System.out.println("Vacancy #: " + getVacancyNumber());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Job Type: " + getJobType());
        if (joined) {
            System.out.println("Name: " + staffName);
            System.out.println("Joined: " + joinDate);
            System.out.println("Qualification: " + qualification);
            System.out.println("Appointed By: " + appointedBy);
            System.out.println("Wages/Hour: " + wagesPerHour);
            System.out.println("Working Hours: " + workingHours);
            System.out.println("Shifts: " + shifts);
        } else if (terminated) {
            System.out.println("This position has been terminated.");
        } else {
            System.out.println("Position not yet filled.");
        }
        System.out.println();
    }
}

