import java.io.Serializable;
import java.util.Objects;

public class Food implements Serializable {
    private final String name;
    private final float mass;
    public Food(String name,float mass){
        this.name=name;
        this.mass=mass;
    }

    public String getName() {
        return name;
    }

    public float getMass() {
        return mass;
    }

    @Override
    public String toString(){
        return "Food{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return mass == food.mass &&
                Objects.equals(name, food.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,mass);
    }

}
