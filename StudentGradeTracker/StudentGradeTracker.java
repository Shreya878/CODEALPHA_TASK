import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        if (grades.isEmpty())
            return 0;
        int sum = 0;
        for (int grade : grades)
            sum += grade;
        return (double) sum / grades.size();
    }

    int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > max)
                max = grade;
        }
        return max;
    }

    int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int grade : grades) {
            if (grade < min)
                min = grade;
        }
        return min;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < studentCount; i++) {
            System.out.print("\nEnter student name: ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int gradeCount = scanner.nextInt();

            for (int j = 0; j < gradeCount; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.addGrade(grade);
            }
            scanner.nextLine();
            students.add(student);
        }

        System.out.println("\n--- Summary Report ---");
        for (Student student : students) {
            System.out.println("Name: " + student.name);
            System.out.println("Grades: " + student.grades);
            System.out.printf("Average: %.2f\n", student.getAverage());
            System.out.println("Highest: " + student.getHighest());
            System.out.println("Lowest: " + student.getLowest());
            System.out.println("-----------------------");
        }

        scanner.close();
    }
}