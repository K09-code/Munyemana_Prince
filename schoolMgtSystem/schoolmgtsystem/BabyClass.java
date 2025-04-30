public class BabyClass extends NurseryClass {

    public BabyClass(String classId) {
        super(classId, "Baby Class", 15);
    }

    @Override
    public boolean enrollStudent(Student student) {
        if (student.age < 2 || student.age > 3 || isClassFull() || isDuplicateStudent(student)) {
            return false;
        }
        if (student.registeredClass != null) return false;
        students.add(student);
        student.registeredClass = this;
        return true;
    }

    @Override
    public void assignTeacher(Teacher teacher) {
        if (!teacher.teacherRole.equals("Early Childhood Educator")) {
            throw new IllegalArgumentException("Only Early Childhood Educators can teach Baby Class");
        }
        super.assignTeacher(teacher);
    }

    @Override
    public void trackProgress() {
        progressNotes = "Developing motor skills and engaging in play-based learning.";
    }
}