package seninar_1

import org.junit.Test
import seninar_1.Animal
import seninar_1.Food
import seninar_1.TypeAnimal

import static org.junit.Assert.assertEquals;

public class SerializeTest {
    List<Animal> listAnimals = Arrays.asList(
            new Animal(TypeAnimal.BIRD,"Doroti",2,Arrays.asList(new Food("cereals", (float) 123.51))),
            new Animal(TypeAnimal.FISH,"Nemo",1,Arrays.asList(new Food("worms",(float)1.5))));

    @Test
    public void record()  {
        java.io.Serializable.record(listAnimals, "animalFile");
        assertEquals(listAnimals, java.io.Serializable.read("animalFile"));
    }
    @Test
    public void serializer()  {
        java.io.Serializable.serializer(listAnimals, "hardanimalFile");
        assertEquals(listAnimals, java.io.Serializable.deserializer("hardanimalFile"));
    }
    @Test
    public void searializableEmpty() {

        java.io.Serializable.record(Collections.emptyList(), "test");
        assertEquals(Collections.emptyList(), java.io.Serializable.read("test"));
    }
    @Test
    public void hardSerializerEmpty(){
        java.io.Serializable.serializer(Collections.emptyList(), "test");
        assertEquals(Collections.emptyList(), java.io.Serializable.deserializer("test"));
    }
}
