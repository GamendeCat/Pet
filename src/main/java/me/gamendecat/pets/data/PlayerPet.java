package me.gamendecat.pets.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerPet {

    private UUID uuid;
    private List<Pet> pets = new ArrayList<>();
    private List<Pet> enabled = new ArrayList<>();

    public PlayerPet(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        if(pets.contains(pet)) return;
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        if(pets.contains(pet)) pets.remove(pet);
        if(enabled.contains(pet)) enabled.remove(pet);
    }

    public void addEnabled(Pet pet) {
        if(!pets.contains(pet)) return;
        pets.remove(pet);
        enabled.add(pet);
    }

    public void removeEnabled(Pet pet) {
        if(!enabled.contains(pet)) return;
        pets.add(pet);
        enabled.remove(pet);
    }

    public List<Pet> getEnabled() {
        return enabled;
    }

    public boolean isEnabled(Pet pet) {
        return enabled.contains(pet);
    }
}
