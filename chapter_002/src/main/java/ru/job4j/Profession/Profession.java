package ru.job4j.Profession;

public class Profession {
    String name;
    String profession;
    public String getName() {
        return name;
    }

    public class Doctor extends Profession {
        public void tread(Patient patient) {
        }
    }

    public class Ingeener extends Profession {
        public void build(Home home) {
        }
    }

    public class Teecher extends Profession {
        public void teach(Student student) {
        }
    }

    public class Patient {
    }

    public class Home {
    }

    public class Student {
    }
}
