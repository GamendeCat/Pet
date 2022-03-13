package me.gamendecat.pets;

import me.gamendecat.pets.data.PetData;
import me.gamendecat.pets.data.PlayerData;
import me.gamendecat.pets.gui.GUIManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pets extends JavaPlugin {

    private PetData petData;
    private GUIManager guiManager;
    private PlayerData playerData;

    @Override
    public void onEnable() {
        petData = new PetData(this);
        petData.loadPets();
        guiManager = new GUIManager();
        playerData = new PlayerData(this);
        playerData.loadPlayer();

    }

    @Override
    public void onDisable() {
        playerData.savePlayers();
    }

    public PetData getPetData() {
        return petData;
    }

    public GUIManager getGuiManager() {
        return guiManager;
    }

    public PlayerData getPlayerData() {
        return playerData;
    }
}
