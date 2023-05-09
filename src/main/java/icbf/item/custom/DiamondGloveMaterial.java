package icbf.item.custom;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DiamondGloveMaterial implements ToolMaterial {
    public static final DiamondGloveMaterial INSTANCE = new DiamondGloveMaterial();

    @Override
    public int getDurability() {
        return 227;
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
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.DIAMOND);
    }

    //TODO: SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND when putting item into offhand
}
