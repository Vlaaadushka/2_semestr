import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Animal implements Serializable {

    private final List<Food> listFood ;
    private final TypeAnimal type;
    private final String name;
    private final int age;

    public Animal(TypeAnimal type, String name, int age, List<Food> listFood){
        this.type=type;
        this.name=name;
        this.age=age;
        this.listFood=listFood;
    }

    public Animal(List<Food> listFood, TypeAnimal type, String name, int age) {
        this.listFood = listFood;
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public List<Food> getFoodList() {
        return listFood;
    }

    public String getName() {
        return name;
    }

    public TypeAnimal getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name = '" + name + '\'' +
                ", type = " + type +
                ", age = " + age +
                ", listfood=" +listFood +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, age, listFood);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(name, animal.name) &&
                type == animal.type &&
                Objects.equals(listFood, animal.listFood);
    }
}
