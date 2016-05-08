package me.SP3NC3RXD.tag;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

/**
 * Created by Spencer on 5/1/2016.
 */
public class WorldListener implements Listener{
    public static Tag plugin;

    public WorldListener(Tag instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event){
        Player p = event.getPlayer();
        if (!p.getWorld().getName().equals("tag")) {
            if (event.getFrom().equals("tag")) {

                if (plugin.TAGGER.contains(p.getName())) {
                    plugin.TAGGER.remove(p.getName());
                } else if (plugin.RUNNER.contains(p.getName())) {
                    plugin.RUNNER.remove(p.getName());
                }
            }
        } else {
            p.sendMessage("Checking if there is already a tagger...");
            if (plugin.TAGGER.size() != 1) {
                plugin.TAGGER.add(p.getName());
                p.sendMessage("Changed World: No Tagger - You should have red armour");
            } else {
                plugin.RUNNER.add(p.getName());
                p.sendMessage("Changed World: Tagger Found - You should have blue armour");
            }
        }
    }
}