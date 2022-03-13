package me.gamendecat.pets.data;

import me.gamendecat.pets.Pets;
import me.gamendecat.pets.util.ConfigurationFile;
import me.gamendecat.pets.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PetData {

    private ConfigurationFile configFile;
    private FileConfiguration config;
    private List<Pet> pets = new ArrayList<>();

    public PetData(Pets plugin) {
        configFile = new ConfigurationFile(plugin, "pets.yml");
        config = configFile.getCustomConfig();
    }

    public void loadPets() {
        for(String key: config.getKeys(false)) {
            ConfigurationSection section = config.getConfigurationSection(key);
            ItemStack itemStack = new ItemBuilder(Material.getMaterial(section.getString("material"))
                    , 1
                    , section.getString("display-name"))
                    .lore(section.getStringList("lore"))
                    .build();
            int id = section.getInt("id");
            PetType petType = PetType.valueOf(config.getString("pet-type"));
            pets.add(new Pet(itemStack, key, id, petType));
        }
    }

    public List<Pet> getPets() {
        return pets;
    }
}
