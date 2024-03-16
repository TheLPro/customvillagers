package studio.thelpro.customvillagers.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.MerchantRecipe;
import studio.thelpro.customvillagers.CustomVillagers;
import studio.thelpro.customvillagers.utils.MerchantMaker;

import java.util.List;

public class SpawnMerchantCommand implements CommandExecutor {

    CustomVillagers plugin = CustomVillagers.plugin;
    FileConfiguration config = plugin.getConfig();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length == 1) {
            if (config.contains(args[0])) {
                Player player = (Player) commandSender;

                MerchantMaker merchantMaker = new MerchantMaker(args[0], (List<MerchantRecipe>) config.getList(args[0]));
                Villager villager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
                villager.setCustomName(args[0]);
                villager.setCustomNameVisible(true);
                villager.setAI(false);
                villager.setAdult();

                player.sendMessage("Done! Summoned " + ChatColor.YELLOW + args[0]);
            } else {
                commandSender.sendMessage(ChatColor.RED + "Didn't find that villager in config.yml.");
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "Please only provide name of villager");
        }
        return true;
    }
}