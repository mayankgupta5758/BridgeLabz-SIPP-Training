import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PetAdoptionPortal<T extends Pet> {
    private List<T> petList;

    public PetAdoptionPortal() {
        petList = new ArrayList<>();
    }

    public void addPet(T pet) {
        petList.add(pet);
    }

    public List<T> getByType(List<T> petList) {
        Collections.sort(petList, (a, b) -> a.getType().compareTo(b.getType()));
        return new ArrayList<>(petList);
    }

    public List<T> getByAge(List<T> petList) {
        Collections.sort(petList, (a, b) -> Integer.compare(a.getAge(), b.getAge()));
        return new ArrayList<>(petList);
    }

    public List<T> getAllPets() {
        return new ArrayList<>(petList);
    }
}
