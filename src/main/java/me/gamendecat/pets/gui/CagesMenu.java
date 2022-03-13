package me.gamendecat.pets.gui;

import me.gamendecat.pets.Pets;
import me.gamendecat.pets.data.Pet;
import me.gamendecat.pets.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class CagesMenu implements GUI{

    private Pets plugin;
    private Inventory inv;

    public CagesMenu(Pets plugin, Player player) {
        this.plugin = plugin;
        this.inv = Bukkit.createInventory(null, 27, getName());
        setupInventory(player);
    }

    public void setupInventory(Player player) {
        ItemStack itemStack = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§8").build();
        for(int i = 0; i < 9; i++) {
            inv.setItem(i, itemStack);
        }

        for(int i = 18; i < 27; i++) {
            inv.setItem(i, itemStack);
        }

        for(Pet pet : plugin.getPlayerData().getPlayer(player).getEnabled()) {
            inv.addItem(pet.getItemStack());
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }

    @Override
    public String getName() {
        return "§e§lCAGES";
    }

    @Override
    public GUI handleClick(Player player, ItemStack itemstack, InventoryView view) {
        if(itemstack == null) return null;

        for(Pet pet : plugin.getPlayerData().getPlayer(player).getEnabled()) {
            if(itemstack == pet.getItemStack()) {
                plugin.getPlayerData().getPlayer(player).removeEnabled(pet);

                //todo send message
            }
        }

        return null;
    }

    @Override
    public boolean isInventory(InventoryView view) {
        return view.getTitle().equals(getName());
    }
}
