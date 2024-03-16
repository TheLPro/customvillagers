package studio.thelpro.customvillagers.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import studio.thelpro.customvillagers.CustomVillagers;
import studio.thelpro.customvillagers.utils.MerchantMaker;
import studio.thelpro.customvillagers.utils.TradeMaker;

import java.util.ArrayList;
import java.util.List;

public class TestVillagerCommand implements CommandExecutor {

    CustomVillagers plugin = CustomVillagers.plugin;
    FileConfiguration config = plugin.getConfig();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        MerchantRecipe recipe = new TradeMaker(new ItemStack(Material.ARROW), new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.FIREWORK_ROCKET), 1).trade();

        List<MerchantRecipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        config.set("test", recipeList);
        plugin.saveConfig();

        return true;
    }
}