class Student {
    String name;
    double attendance;

    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class M5_StudentCollege {
    public static void main(String[] args) {

        Student s1 = new Student("Saranya", 90);
        Student s2 = new Student("Priya", 85);

        System.out.println("2 Student objects created");

        Student.printCollegeInfo();
    }
}