import java.util.ArrayList;
import java.util.List;

public abstract class NurseryClass {
    String classId;
    String className;
    int maxCapacity;
    Teacher assignedTeacher;
    List<Student> students = new ArrayList<>();
    List<String> activities = new ArrayList<>();
    String progressNotes = "";

    public NurseryClass(String classId, String className, int maxCapacity) {
        this.classId = classId;
        this.className = className;
        this.maxCapacity = maxCapacity;
    }

    public abstract boolean enrollStudent(Student student);

    public abstract void trackProgress();

    public void conductActivity(String activityName) {
        activities.add(activityName);
        System.out.println(className + " conducted: " + activityName);
    }

    public void assignTeacher(Teacher teacher) {
        this.assignedTeacher = teacher;
        teacher.assignedClass = this;
    }

    public String generateClassReport() {
        return "Class Name: " + className +
               "\nTeacher: " + (assignedTeacher != null ? assignedTeacher.teacherName : "None") +
               "\nStudents Enrolled: " + students.size() +
               "\nActivities: " + activities +
               "\nProgress Notes: " + progressNotes + "\n";
    }

    protected boolean isDuplicateStudent(Student student) {
        return students.stream().anyMatch(s -> s.studentId.equals(student.studentId));
    }

    protected boolean isClassFull() {
        return students.size() >= maxCapacity;
    }
}
