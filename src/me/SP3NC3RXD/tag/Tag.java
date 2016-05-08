package me.SP3NC3RXD.tag;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.activation.CommandObject;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Spencer on 5/1/2016.
 */
public class Tag extends JavaPlugin implements CommandExecutor {
    public void onEnable() {

        getLogger().info(getDescription().getName() + " has been enabled!");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new WorldListener(this), this);
        pm.registerEvents(new HitListener(this), this);
        pm.registerEvents(new PlayerJoinListener(this), this);
        pm.registerEvents(new ArmourMoveListener(this), this);

    }

    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }

    //public boolean adminMode;

    public ArrayList<String> TAGGER = new ArrayList<String>();
    public ArrayList<String> RUNNER = new ArrayList<String>();

    public void RED_ARMOUR(Player target) {

        ArrayList<ItemStack> contents = new ArrayList<ItemStack>();
        for (String suffix : Arrays.asList("Helmet", "Chestplate", "Leggings", "Boots")) {
            ItemStack armorPiece = new ItemStack(Material.valueOf("LEATHER_" + suffix.toUpperCase()));
            LeatherArmorMeta meta = (LeatherArmorMeta) armorPiece.getItemMeta();
            meta.setColor(Color.RED);
            contents.add(armorPiece);
        }
        target.getInventory().setContents(contents.toArray(new ItemStack[4]));

    }
    public static void BLUE_ARMOUR(Player damager) {

        ArrayList<ItemStack> contents = new ArrayList<ItemStack>();
        for (String suffix : Arrays.asList("Helmet", "Chestplate", "Leggings", "Boots")) {
            ItemStack armorPiece = new ItemStack(Material.valueOf("LEATHER_" + suffix.toUpperCase()));
            LeatherArmorMeta meta = (LeatherArmorMeta) armorPiece.getItemMeta();
            meta.setColor(Color.BLUE);
            contents.add(armorPiece);
        }
        damager.getInventory().setContents(contents.toArray(new ItemStack[4]));


    }

    /*@Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("tag"))
        {
            if (args[0].equalsIgnoreCase("admin")) {
                if (adminMode == true) {
                    //adminMode == true;
                    sender.sendMessage("lol");
                }
                if (adminMode == false) {

                }
            }
            sender.sendMessage("");
        }
        return true;
    }*/

}
