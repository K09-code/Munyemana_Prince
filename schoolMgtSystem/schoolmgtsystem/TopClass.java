public class TopClass extends NurseryClass {

    public TopClass(String classId) {
        super(classId, "Top Class", 25);
    }

    @Override
    public boolean enrollStudent(Student student) {
        if (student.age < 4 || student.age > 5 || isClassFull() || isDuplicateStudent(student)) {
            return false;
        }
        if (student.registeredClass != null) return false;
        students.add(student);
        student.registeredClass = this;
        return true;
    }

    @Override
    public void trackProgress() {
        progressNotes = "Preparing students for primary school with assessments, reading and writing.";
    }
}