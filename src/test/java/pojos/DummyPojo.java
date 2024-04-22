package pojos;

public class DummyPojo {
    public String name ="John";
    public String lastname="Doe";
    public int age =25;


    public DummyPojo(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "DummyPojo{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
