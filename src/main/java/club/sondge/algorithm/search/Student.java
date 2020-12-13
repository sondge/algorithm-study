package club.sondge.algorithm.search;


public class Student {

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
}
