package icbf.item.custom;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class IronGloveMaterial implements ToolMaterial {
    public static final IronGloveMaterial INSTANCE = new IronGloveMaterial();

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
        return 9;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }

    //TODO: SoundEvents.ITEM_ARMOR_EQUIP_IRON when putting item into offhand
}
