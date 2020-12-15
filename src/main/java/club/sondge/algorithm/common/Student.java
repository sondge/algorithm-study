package club.sondge.algorithm.common;


public class Student implements Comparable<Student> {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;

        return this.name.toLowerCase().equals(student.getName().toLowerCase());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public int compareTo(Student student) {
        if (student == null) {
            return 1;
        }
        return name.compareTo(student.getName());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
