package assessment2;

  

/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    // instance variables - replace the example below with your own
    private String LastName;
    private String FirstName;
    private int StudentId;
    private double A1;
    private double A2;
    private double A3;

    /**
     * Constructor for objects of class Student
     */
    public Student(String lastName, String firstName, int studentId, double a1)
    {
        // initialise instance variables
        this.LastName = lastName;
        this.FirstName = firstName;
        this.StudentId = studentId;
        this.A1 = a1;
        this.A2 = 0;
        this.A3 = 0;
    }
    
    public Student(String lastName, String firstName, int studentId, double a1, double a2)
    {
        // initialise instance variables
        this.LastName = lastName;
        this.FirstName = firstName;
        this.StudentId = studentId;
        this.A1 = a1;
        this.A2 = a2;
        this.A3 = 0;
    }
    
    public Student(String lastName, String firstName, int studentId, double a1, double a2, double a3)
    {
        // initialise instance variables
        this.LastName = lastName;
        this.FirstName = firstName;
        this.StudentId = studentId;
        this.A1 = a1;
        this.A2 = a2;
        this.A3 = a3;
    }
    
    // getters
    public String getLastName() {
        return this.LastName;
    }
    
    public String getFirstName() {
        return this.FirstName;
    }
    
    public String getFullName() {
        return this.LastName + ", " + this.FirstName;
    }
    
    public int getStudentId() {
        return this.StudentId;
    }
    
    public double getA1() {
        return this.A1;
    }
    
    public double getA2() {
        return this.A2;
    }
    
    public double getA3() {
        return this.A3;
    }
    
    public double getTotalMark() {
        return this.A1 + this.A2 + this.A3;
    }
}
