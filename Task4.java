import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task4 {
    private static final Collection<Student> students = Arrays.asList(
            new Student("Дмитрий", 17, Gender.MAN),
            new Student("Максим", 17, Gender.MAN),
            new Student("Екатерина", 19, Gender.WOMAN),
            new Student("Михаил", 28, Gender.MAN)
    );

    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    "}";
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        public int hashCode() {
            return Objects.hash(name, age, gender.ordinal());
        }
    }

    public static void main(String[] args) {
        // 4.1
        int averageAgeOfMen = (int) students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Средний возраст студентов мужского пола: " + averageAgeOfMen);

        // 4.2
        List<String> potentialDraftees = students.stream()
                .filter(student -> student.getGender() == Gender.MAN && student.getAge() >= 18 && student.getAge() <= 27)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Потенциальные призывники: " + potentialDraftees);
    }
}