public class AttendanceSheet {

    private String[] students;
    private int presentCount;

    // Constructor
    public AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        presentCount = 0;
    }

    // Mark student as present
    public void markPresent(String name) {

        // Check duplicate
        if (isPresent(name)) {
            return;
        }

        // Add student
        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        }
    }

    // Return number of present students
    public int getPresentCount() {
        return presentCount;
    }

    // Check whether student is present
    public boolean isPresent(String name) {

        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    // Main method
    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " + sheet.getPresentCount());
        System.out.println("Ben Present: " + sheet.isPresent("Ben"));
        System.out.println("Chen Present: " + sheet.isPresent("Chen"));
    }
}