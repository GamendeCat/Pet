package me.gamendecat.pets.gui;

import me.gamendecat.pets.Pets;
import me.gamendecat.pets.data.Pet;
import me.gamendecat.pets.data.PlayerData;
import me.gamendecat.pets.data.PlayerPet;
import me.gamendecat.pets.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class PetsMenu implements GUI{

    private Pets plugin;
    private Inventory inv;

    public PetsMenu(Pets plugin, Player player) {
        this.plugin = plugin;
        this.inv = Bukkit.createInventory(null, 54, getName());

        setupInventory(player);
    }

    public void setupInventory(Player player) {
        ItemStack itemStack = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§8").build();
        for(int i = 0; i < 9; i++) {
            inv.setItem(i, itemStack);
        }

        for(int i = 45; i < 54; i++) {
            inv.setItem(i, itemStack);
        }

        PlayerPet playerData = plugin.getPlayerData().getPlayer(player);
        for(Pet pet : playerData.getPets()) {
            inv.addItem(pet.getItemStack());
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }

    @Override
    public String getName() {
        return "§e§lPETS";
    }

    @Override
    public GUI handleClick(Player player, ItemStack itemstack, InventoryView view) {
        PlayerPet playerPet = plugin.getPlayerData().getPlayer(player);
        for(Pet pet : playerPet.getPets()) {
            if(pet.getItemStack() == itemstack) {
                //todo enable pet
            }
        }
        return null;
    }

    @Override
    public boolean isInventory(InventoryView view) {
        return view.getTitle().equals(getName());
    }
}
