package me.gamendecat.pets.data;

import org.bukkit.inventory.ItemStack;

public class Pet {

    private ItemStack itemStack;
    private String name;
    private int id;
    private PetType petType;

    public Pet(ItemStack itemStack, String name, int id, PetType petType) {
        this.itemStack = itemStack;
        this.name = name;
        this.id = id;
        this.petType = petType;
    }

    public PetType getPetType() {
        return petType;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
