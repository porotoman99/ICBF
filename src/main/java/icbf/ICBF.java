package icbf;

import icbf.item.custom.DyeableGloveItem;
import icbf.item.custom.LeatherToolMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ICBF implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("ICBF");

	public static final Item ROSE_GOLD_INGOT = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "rose_gold_ingot"),
			new Item(new FabricItemSettings().group(ItemGroup.MATERIALS))
	);

	public static final Item BELL_METAL_INGOT = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "bellmetal_ingot"),
			new Item(new FabricItemSettings().group(ItemGroup.MATERIALS))
	);

	public static final Block ROSE_GOLD_BLOCK = Registry.register(
			Registry.BLOCK,
			new Identifier("icbf", "rose_gold_block"),
			new Block(FabricBlockSettings.of(Material.METAL, MapColor.GOLD).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.METAL))
	);

	public static final Item LEATHER_GLOVE = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "leather_glove"),
			(new DyeableGloveItem(LeatherToolMaterial.INSTANCE, 1, new FabricItemSettings().group(ItemGroup.COMBAT)))
	);

	@Override
	public void onInitialize() {

		Registry.register(
				Registry.ITEM,
				new Identifier("icbf", "rose_gold_block"),
				new BlockItem(ROSE_GOLD_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS))
		);

		CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(LEATHER_GLOVE, CauldronBehavior.CLEAN_DYEABLE_ITEM);
		ColorProviderRegistry.ITEM.register(new ItemColorProvider() {
			@Override
			public int getColor(ItemStack stack, int tintIndex) {
				if(tintIndex == 0){
					NbtCompound nbtCompound = stack.getSubNbt("display");
					return nbtCompound != null && nbtCompound.contains("color", 99) ? nbtCompound.getInt("color") : 10511680;
				}
				else{
					return 0xFFFFFF;
				}
			}
		}, Registry.ITEM.get(new Identifier("icbf", "leather_glove")));

		LOGGER.info("ICBF loaded!");
	}
}
