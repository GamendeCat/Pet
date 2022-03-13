package me.gamendecat.pets.data;

import me.gamendecat.pets.Pets;
import me.gamendecat.pets.util.ConfigurationFile;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerData {

    private ConfigurationFile configFile;
    private FileConfiguration config;
    private List<PlayerPet> pets;
    private Pets plugin;

    public PlayerData(Pets plugin) {
        this.plugin = plugin;
        configFile = new ConfigurationFile(plugin, "player.yml");
        config = configFile.getCustomConfig();
    }

    public void loadPlayer() {
        for(String uuid : config.getKeys(false)) {
            PlayerPet playerPet = new PlayerPet(UUID.fromString(uuid));
            for(int id : config.getIntegerList(uuid + "." + "pet_ids")) {
                for(Pet pet : plugin.getPetData().getPets()) {
                    if(pet.getId() == id) {
                        playerPet.addPet(pet);
                    }
                }
            }
        }
    }

    public void savePlayers() {
        for(PlayerPet pet : pets) {
            savePlayer(pet);
        }
    }

    public void savePlayer(PlayerPet player) {
        ConfigurationSection section = config.getConfigurationSection(String.valueOf(player.getUuid()));
        List<Integer> petIds = new ArrayList<>();
        for(Pet pet : player.getPets()) {
            petIds.add(pet.getId());
        }
        section.set("pet_ids", petIds);
    }

    public PlayerPet getPlayer(Player player) {
        for(PlayerPet pet : pets) {
            if(pet.getUuid() == player.getUniqueId()) {
                return pet;
            }
        }
        return null;
    }

    public List<PlayerPet> getPlayerPets() {
        return pets;
    }
}
