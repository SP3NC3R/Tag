package me.SP3NC3RXD.tag;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by Spencer on 5/1/2016.
 */
public class HitListener implements Listener {
    public static Tag plugin;

    public HitListener(Tag instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player target = (Player) e.getEntity();
            Player damager = (Player) e.getDamager();
            if(!target.getWorld().getName().equals("tag")) {
                return;
            } else {
                if (!plugin.TAGGER.contains(damager)) {
                    e.setCancelled(true);
                } else {
                    plugin.TAGGER.remove(damager.getName());
                    plugin.RUNNER.add(damager.getName());
                    plugin.BLUE_ARMOUR(damager);
                    damager.setCustomName(ChatColor.BLUE + damager.getName());

                    plugin.RUNNER.remove(target.getName());
                    plugin.TAGGER.add(target.getName());
                    plugin.RED_ARMOUR(target);
                    target.setCustomName(ChatColor.RED + target.getName());


                }
            }
        }
    }

}
