import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Student> studentRegistry = new HashMap<>();

        BabyClass baby = new BabyClass("B001");
        MiddleClass middle = new MiddleClass("M001");
        TopClass top = new TopClass("T001");

        System.out.println("--- Assign Teachers to Classes ---");
        assignTeacherToClass(sc, baby, "Baby Class");
        assignTeacherToClass(sc, middle, "Middle Class");
        assignTeacherToClass(sc, top, "Top Class");

        System.out.print("\nEnter number of students to enroll: ");
        int num = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < num; i++) {
            System.out.println("\n--- Enroll Student " + (i + 1) + " ---");

            System.out.print("Student ID: ");
            String id = sc.nextLine();
            if (studentRegistry.containsKey(id)) {
                System.out.println("Error: Duplicate student ID!");
                i--;
                continue;
            }

            System.out.print("Student Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Guardian Name: ");
            String guardian = sc.nextLine();

            Student student = new Student(id, name, age, guardian);
            studentRegistry.put(id, student);

            System.out.print("Enroll in (baby/middle/top): ");
            String classChoice = sc.nextLine().toLowerCase();

            boolean enrolled = switch (classChoice) {
                case "baby" -> baby.enrollStudent(student);
                case "middle" -> middle.enrollStudent(student);
                case "top" -> top.enrollStudent(student);
                default -> false;
            };

            if (enrolled) {
                System.out.println("Student enrolled successfully.");
            } else {
                System.out.println("Enrollment failed: Invalid age or class full.");
            }
        }

        System.out.println("\n--- Conduct Activities ---");
        runActivity(sc, baby);
        runActivity(sc, middle);
        runActivity(sc, top);

        baby.trackProgress();
        middle.trackProgress();
        top.trackProgress();

        System.out.println("\n----- CLASS REPORTS -----\n");
        System.out.println(baby.generateClassReport());
        System.out.println(middle.generateClassReport());
        System.out.println(top.generateClassReport());

        sc.close();
    }

    private static void assignTeacherToClass(Scanner sc, NurseryClass cls, String name) {
        while (true) {
            try {
                System.out.println("\nEnter teacher for " + name + ":");
                System.out.print("Teacher ID: ");
                String tId = sc.nextLine();
                System.out.print("Teacher Name: ");
                String tName = sc.nextLine();
                System.out.print("Teacher Role: ");
                String tRole = sc.nextLine();
                Teacher t = new Teacher(tId, tName, tRole);
                cls.assignTeacher(t);
                System.out.println("Teacher assigned to " + name);
                break;
            } catch (Exception e) {
                System.out.println("Error assigning teacher: " + e.getMessage());
            }
        }
    }

    private static void runActivity(Scanner sc, NurseryClass cls) {
        System.out.print("Enter activity for " + cls.className + ": ");
        String act = sc.nextLine();
        cls.conductActivity(act);
    }
}