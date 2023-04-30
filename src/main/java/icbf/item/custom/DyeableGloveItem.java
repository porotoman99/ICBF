package icbf.item.custom;

import net.minecraft.item.DyeableItem;
import net.minecraft.item.ToolMaterial;

public class DyeableGloveItem extends GloveItem implements DyeableItem {
    public DyeableGloveItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
}
