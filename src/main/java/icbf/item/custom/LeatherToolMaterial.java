package icbf.item.custom;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LeatherToolMaterial implements ToolMaterial {
    public static final LeatherToolMaterial INSTANCE = new LeatherToolMaterial();

    @Override
    public int getDurability() {
        return 34;
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
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.LEATHER);
    }

    //TODO: SoundEvents.ITEM_ARMOR_EQUIP_LEATHER when putting item into offhand
}
