package me.SP3NC3RXD.tag;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Spencer on 5/1/2016.
 */
public class PlayerJoinListener implements Listener {
    public static Tag plugin;

    public PlayerJoinListener(Tag instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        ItemStack[] armour = p.getInventory().getArmorContents();
        if (!p.getWorld().getName().equals("tag")) {
            return;
        } else {
            if (plugin.TAGGER.contains(p.getName())) {
                plugin.TAGGER.remove(p.getName());
            }
            if (plugin.RUNNER.contains(p.getName())) {
                plugin.RUNNER.remove(p.getName());
            }
            if (armour == null) {
                return;
            }
            p.getInventory().setHelmet(new ItemStack(null, 1));
            p.getInventory().setChestplate(new ItemStack(null, 1));
            p.getInventory().setLeggings(new ItemStack(null, 1));
            p.getInventory().setBoots(new ItemStack(null, 1));
        }
    }
}
