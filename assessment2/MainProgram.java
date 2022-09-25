package assessment2;

import java.util.ArrayList;
import java.util.Scanner; 
import java.io.File;

/**
 * Write a description of class MainProgram here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainProgram
{
    // instance variables - replace the example below with your own
    private static ArrayList<Student> students;
    private final static String FOLDER_PATH = "C:\\Users\\RubySenpaii\\PROG5001_Assessment2\\assessment2\\";
    private final static String FILE_NAME = "prog5001_students_grade_2022.csv";

    /**
     * Constructor for objects of class MainProgram
     */
    public static void main(String[] args)
    {
        students = new ArrayList<>();
        System.out.println("Loading text file...");
        
        try {
            // Load text file
            Scanner sc = new Scanner(new File(FOLDER_PATH + FILE_NAME));
            String title = sc.nextLine(); // first row whichis the title
            String labels = sc.nextLine(); // csv labels or column names
            System.out.println(title);
            try {
                // Loop thru the remaining csv
                while (sc.hasNext()) {
                    String line = sc.nextLine();
                    Scanner scLine = new Scanner(line);
                    scLine.useDelimiter(",");
                    String lastName = scLine.next();
                    String firstName = scLine.next();
                    int studentId = Integer.parseInt(scLine.next());
                    double a1,a2, a3;
                    try {
                        a1 = Double.parseDouble(scLine.next());
                    } catch (Exception x) {
                        a1 = 0;
                    }
                    try {
                        a2 = Double.parseDouble(scLine.next());
                    } catch (Exception x) {
                        a2 = 0;
                    }
                    try {
                        a3 = Double.parseDouble(scLine.next());
                    } catch (Exception x) {
                        a3 = 0;
                    }
                    scLine.close();
                    Student student = new Student(lastName, firstName, studentId, a1, a2, a3);
                    students.add(student);
                }
            } catch (Exception x) {
                System.err.println("Invalid line");
                System.err.println(x);
            }
            sc.close();
            // System.out.println("Student Count: " + students.size());
        } catch (Exception x) {
            System.err.println(x);
        }
        
        mainMenu();
    }
    
    // display the main menu and its options
    public static void mainMenu() {
        System.out.println("Choose an option: ");
        System.out.println("[1] - Show list of students with marks");
        System.out.println("[2] - Print students with grades less than threshold");
        System.out.println("[3] - Show Top 10 Students");
        System.out.println("[4] - Show Bottom 10 Students");
        int input = 0;
        do {
            Scanner sc = new Scanner(System.in);
            // check if use inputs a valid number
            try {
                input = Integer.parseInt(sc.nextLine());
                switch (input) {
                    case 1: showStudentList(); break;
                    case 2: showStudentListWithThreshold(); break;
                    case 3: showTop10Students(); break;
                    case 4: showBottom10Students(); break;
                    default: System.out.println("Invalid Input!"); break;
                }
            } catch (Exception x) {
                System.err.println("Error Occurred: Invalid input!");
            }
            sc.close();
        } while (input < 1 && input > 4);
    }
    
    // lists all student with the format Last Name, First Name (Student ID) Assessment1 Assesment2 Assement3 Total Mark: TotalMark
    public static void showStudentList() {
        for (Student student: students) {
            System.out.format("%-40s (%s) %05.2f %05.2f %05.2f Total: %05.2f", student.getFullName(), 
                student.getStudentId(), student.getA1(), student.getA2(), student.getA3(), student.getTotalMark());
            System.out.println();
        }
    }
    
    // requires an input and only shows students who are below the mark
    public static void showStudentListWithThreshold() {
        System.out.println("Please input a threshold between 0-100");
        double input = 0;
        do {
            Scanner sc = new Scanner(System.in);
            try {
                input = Double.parseDouble(sc.nextLine());
                if (input > 100 && input <= 0) {
                    System.out.println("Invalid Input!");
                }
            } catch (Exception x) {
                System.err.println("Error Occurred: Invalid input!");
            }System.out.println(input);
            sc.close();
        } while (input > 100 && input <= 0);
        for (Student student: students) {
            if (student.getTotalMark() < input) {
                System.out.format("%-40s (%s) %05.2f %05.2f %05.2f Total: %05.2f", student.getFullName(), 
                    student.getStudentId(), student.getA1(), student.getA2(), student.getA3(), student.getTotalMark());
                System.out.println();
            }
        }
    }
    
    // shows first 10 in the student list sorted descending to display top 10 students
    public static void showTop10Students() {
        int i = 1;
        sortStudents("desc");
        for (Student student: students) {
            System.out.format("%-40s (%s) %05.2f %05.2f %05.2f Total: %05.2f", student.getFullName(), 
                student.getStudentId(), student.getA1(), student.getA2(), student.getA3(), student.getTotalMark());
            System.out.println();
            if (i >= 10) {
                break;
            }
            i++;
        }
    }
    
    // shows first 10 in the student list sorted ascending to display bottom 10 students
    public static void showBottom10Students() {
        int i = 1;
        sortStudents("asc");
        for (Student student: students) {
            System.out.format("%-40s (%s) %05.2f %05.2f %05.2f Total: %05.2f", student.getFullName(), 
                student.getStudentId(), student.getA1(), student.getA2(), student.getA3(), student.getTotalMark());
            System.out.println();
            if (i >= 10) {
                break;
            }
            i++;
        }
    }
    
    // sort students
    private static void sortStudents(String order) {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (order.equals("desc")) {
                    if (students.get(j).getTotalMark() < students.get(j + 1).getTotalMark()) {
                        Student temp = students.get(j);
                        students.set(j, students.get(j + 1));
                        students.set(j + 1, temp);
                    }
                } else {
                    if (students.get(j).getTotalMark() > students.get(j + 1).getTotalMark()) {
                        Student temp = students.get(j);
                        students.set(j, students.get(j + 1));
                        students.set(j + 1, temp);
                    }
                }
            }
        }
    }
}
