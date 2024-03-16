package studio.thelpro.customvillagers.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class TradeMaker {
    ItemStack ingredient;
    ItemStack ingredient2;
    ItemStack result;
    int uses;

    public TradeMaker(ItemStack ingredient, ItemStack ingredient2, ItemStack result, int uses) {
        this.ingredient = ingredient;
        this.ingredient2 = ingredient2;
        this.result = result;
        this.uses = uses;
    }

    public MerchantRecipe trade() {
        MerchantRecipe recipe = new MerchantRecipe(result, uses);
        recipe.addIngredient(ingredient);
        recipe.addIngredient(ingredient2);

        return recipe;
    }
}