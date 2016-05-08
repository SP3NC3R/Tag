package me.SP3NC3RXD.tag;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

/**
 * Created by Spencer on 5/1/2016.
 */
public class ArmourMoveListener implements Listener {
    public static Tag plugin;

    public ArmourMoveListener(Tag instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onInventoryClick(InventoryInteractEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (!p.getWorld().getName().equals("tag")) {
            return;
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        Player p = (Player) e.getPlayer();
        if (!p.getWorld().equals("tag")) {
            return;
        } else {
            e.setCancelled(true);
        }
    }
}
