package icbf.item.custom;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ChainmailGloveMaterial implements ToolMaterial {
    public static final ChainmailGloveMaterial INSTANCE = new ChainmailGloveMaterial();

    @Override
    public int getDurability() {
        return 103;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }

    //TODO: SoundEvents.ITEM_ARMOR_EQUIP_CHAIN when putting item into offhand
}
