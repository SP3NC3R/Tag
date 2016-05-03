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
        if (!p.getWorld().equals("tag")) {
            p.sendMessage("This is not the tag world.");
            return;
        } else {
            p.sendMessage("Checking if there is already a tagger...");
            if (plugin.TAGGER.size() != 1) {
                plugin.TAGGER.add(p.getName());
                p.sendMessage("Changed World - You should have red armour");
            } else {
                plugin.RUNNER.add(p.getName());
                p.sendMessage("Changed World - You should have blue armour");
            }
        }
    }
}