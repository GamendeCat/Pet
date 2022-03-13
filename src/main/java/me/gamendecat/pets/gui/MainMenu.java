package me.gamendecat.pets.gui;

import me.gamendecat.pets.Pets;
import me.gamendecat.pets.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class MainMenu implements GUI{

    private Inventory inv;
    private Pets plugin;

    public MainMenu(Pets plugin) {
        this.plugin = plugin;
        inv = Bukkit.createInventory(null, 27, getName());

        setupInventory();
    }

    public void setupInventory() {
        ItemStack itemStack = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, "§8").build();
        for(int i = 0; i < 27; i++) {
            if(i == 12) {
                ItemStack itemStack1 = new ItemBuilder(Material.IRON_BARS, 1, "§e§lCAGES").build();
                inv.setItem(12, itemStack1);
                continue;
            }else if(i == 14){
                ItemStack itemStack2 = new ItemBuilder(Material.GRAY_DYE, 1, "§e§lPETS").build();
                inv.setItem(14, itemStack2);
                continue;
            }
            inv.setItem(i, itemStack);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }

    @Override
    public String getName() {
        return "§8§lPETS";
    }

    @Override
    public GUI handleClick(Player player, ItemStack itemstack, InventoryView view) {
        if(itemstack == null) return null;

        switch(itemstack.getType()) {
            case IRON_BARS:
                CagesMenu cagesMenu = new CagesMenu(plugin, player);
                plugin.getGuiManager().setGUI(player, cagesMenu);
                break;
            case GRAY_DYE:
                PetsMenu petsMenu = new PetsMenu(plugin, player);
                plugin.getGuiManager().setGUI(player, petsMenu);
                break;
        }
        return null;
    }

    @Override
    public boolean isInventory(InventoryView view) {
        return view.getTitle().equals(getName());
    }
}
