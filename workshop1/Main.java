import java.util.List;

public class Main {
    public static void main(String[] args) {
        PetAdoptionPortal<Pet> portal = new PetAdoptionPortal<>();

        portal.addPet(new Pet("Dog", 2, false));
        portal.addPet(new Pet("Cat", 3, false));
        portal.addPet(new Pet("Bird", 1, true));
        portal.addPet(new Pet("Dog", 5, false));
        portal.addPet(new Pet("Reptile", 4, false));

        System.out.println("All Pets:");

        // List<Pet> list = portal.getByType(portal.getAllPets());
        List<Pet> list = portal.getByAge(portal.getAllPets());

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Pet{" +
                    "type='" + list.get(i).getType() + '\'' +
                    ", age=" + list.get(i).getAge() +
                    ", isAdopted=" + list.get(i).isAdopted() + '}');
        }

    }
}
