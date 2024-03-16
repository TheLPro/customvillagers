package studio.thelpro.customvillagers.events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import studio.thelpro.customvillagers.CustomVillagers;
import studio.thelpro.customvillagers.utils.MerchantMaker;
import studio.thelpro.customvillagers.utils.TradeMaker;

import java.util.List;

public class VillagerGUIEvent implements Listener {

    CustomVillagers plugin = CustomVillagers.plugin;
    FileConfiguration config = plugin.getConfig();

    @EventHandler
    public void onVillagerRequest(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked().getType().equals(EntityType.VILLAGER)) {
            Entity entity = e.getRightClicked();
            if (entity.getCustomName() != null) {
                if (config.contains(entity.getCustomName())) {
                    e.setCancelled(true);
                    List<MerchantRecipe> items = (List<MerchantRecipe>) config.getList(entity.getCustomName());
                    Merchant merchant = new MerchantMaker(entity.getCustomName(), items).merchant();
                    merchant.setRecipes(items);
                    e.getPlayer().openMerchant(merchant, true);
                }
            }
        }
    }
}