package studio.thelpro.customvillagers.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import java.util.List;

public class MerchantMaker {

    String name;
    List<MerchantRecipe> recipes;

    public String getName() {
        return name;
    }

    public List<MerchantRecipe> getRecipes() {
        return recipes;
    }

    public MerchantMaker(String name, List<MerchantRecipe> recipes) {
        this.name = name;
        this.recipes = recipes;
    }

    public Merchant merchant() {
        Merchant merchant = Bukkit.createMerchant(name);
        merchant.setRecipes(recipes);

        return merchant;
    }
}