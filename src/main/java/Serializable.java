import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Serializable {
    public static void record(List<Animal> listAnimals, String fileName) {
        Path path = Paths.get(fileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(listAnimals);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static List<Animal> read(String fileName) {
        Path path = Paths.get(fileName);
        List<Animal> listAnimals = null;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            listAnimals = (List<Animal>) ois.readObject();
            return listAnimals;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listAnimals;
    }

    public static void serializer(List<Animal> listAnimals, String fileName){
        Path path = Paths.get(fileName);
        try(DataOutputStream outputStream =
                    new DataOutputStream(Files.newOutputStream(path))){
            outputStream.writeInt(listAnimals.size());
            for (Animal animal : listAnimals) {
                outputStream.writeUTF(animal.getName());
                outputStream.writeUTF(animal.getType().name());
                outputStream.writeInt(animal.getAge());
                outputStream.writeInt(animal.getFoodList().size());
                for (Food food : animal.getFoodList()) {
                    outputStream.writeUTF(food.getName());
                    outputStream.writeFloat(food.getMass());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static List<Animal> deserializer(String fileName)  {
        Path path = Paths.get(fileName);
        List<Animal> animalList = new ArrayList<>();

        String name;
        TypeAnimal type;
        int age;

        try (DataInputStream inputStream =
                     new DataInputStream(Files.newInputStream(path))) {
            int countAnimal = inputStream.readInt();
            for (int i = 0; i < countAnimal; i++) {
                name = inputStream.readUTF();
                type = TypeAnimal.valueOf(inputStream.readUTF());
                age = inputStream.readInt();
                int countFood = inputStream.readInt();
                List<Food> listFood = new ArrayList<>();
                for (int j = 0; j < countFood; j++) {
                    String nameFood = inputStream.readUTF();
                    float mass = inputStream.readFloat();
                    listFood.add(new Food(nameFood, mass));
                }
                animalList.add(new Animal( type, name, age, listFood));
            }
        }  catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return animalList;
    }
}