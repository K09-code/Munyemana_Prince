public class MiddleClass extends NurseryClass {

    public MiddleClass(String classId) {
        super(classId, "Middle Class", 20);
    }

    @Override
    public boolean enrollStudent(Student student) {
        if (student.age < 3 || student.age > 4 || isClassFull() || isDuplicateStudent(student)) {
            return false;
        }
        if (student.registeredClass != null) return false;
        students.add(student);
        student.registeredClass = this;
        return true;
    }

    @Override
    public void trackProgress() {
        progressNotes = "Focus on language development and basic counting.";
    }
}
