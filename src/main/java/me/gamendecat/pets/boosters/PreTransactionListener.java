package me.gamendecat.pets.boosters;

import me.gamendecat.pets.Pets;
import me.gamendecat.pets.data.Pet;
import me.gypopo.economyshopgui.api.events.PreTransactionEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

public class PreTransactionListener implements Listener {

    private Pets plugin;

    public PreTransactionListener(Pets plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void transactionListener(PreTransactionEvent e) {
        if(e.getTransactionMode() != "SELL" || e.getTransactionMode() != "SELL_ALL") return;

        List<Pet> enabled = plugin.getPlayerData().getPlayer(e.getPlayer()).getEnabled();

        int multi = 0;

        for(Pet pet : enabled) {
            multi += pet.getPetType().getMulti();
        }

        e.setPrice(e.getPrice() * multi);
    }


}
