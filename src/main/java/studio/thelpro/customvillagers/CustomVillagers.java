package studio.thelpro.customvillagers;

import org.bukkit.plugin.java.JavaPlugin;
import studio.thelpro.customvillagers.commands.SpawnMerchantCommand;
import studio.thelpro.customvillagers.commands.TestVillagerCommand;
import studio.thelpro.customvillagers.events.VillagerGUIEvent;

public final class CustomVillagers extends JavaPlugin {

    public static CustomVillagers plugin;

    @Override
    public void onEnable() {

        reloadConfig();
        saveConfig();

        plugin = this;

        getCommand("spawnvillager").setExecutor(new SpawnMerchantCommand());
        getCommand("testnew").setExecutor(new TestVillagerCommand());

        getServer().getPluginManager().registerEvents(new VillagerGUIEvent(), this);

    }
}