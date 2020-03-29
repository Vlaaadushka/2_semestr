package seminar_1

import org.junit.Test
import seninar_1.Animal
import seninar_1.Food

import static org.junit.Assert.assertEquals;

public class SerializeTest {
    List<Animal> listAnimals = Arrays.asList(
            new Animal(TypeAnimal.BIRD,"Doroti",2,Arrays.asList(new Food("cereals", (float) 123.51))),
            new Animal(TypeAnimal.FISH,"Nemo",1,Arrays.asList(new Food("worms",(float)1.5))));

    @Test
    public void record()  {
        Serializable.record(listAnimals, "animalFile");
        assertEquals(listAnimals, Serializable.read("animalFile"));
    }
    @Test
    public void serializer()  {
        Serializable.serializer(listAnimals, "hardanimalFile");
        assertEquals(listAnimals, Serializable.deserializer("hardanimalFile"));
    }
    @Test
    public void searializableEmpty() {

        Serializable.record(Collections.emptyList(), "test");
        assertEquals(Collections.emptyList(), Serializable.read("test"));
    }
    @Test
    public void hardSerializerEmpty(){
        Serializable.serializer(Collections.emptyList(), "test");
        assertEquals(Collections.emptyList(), Serializable.deserializer("test"));
    }
}
