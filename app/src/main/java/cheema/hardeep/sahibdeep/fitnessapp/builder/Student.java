package cheema.hardeep.sahibdeep.fitnessapp.builder;

//Build Pattern Rules/Guidelines
//1. Builder access is always static
//2. Builder creates a class which cannot be created by normal creation (private)
//3. Builder always maintain the modification to the class

public class Student {
    private String name;
    private int age;
    private String rollNumber;
    private String university;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.rollNumber = builder.rollNumber;
        this.university = "DAV";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getUniversity() {
        return university;
    }

    public static class Builder {
        private String name;
        private int age;
        private String rollNumber;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setRollNumber(String rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}




