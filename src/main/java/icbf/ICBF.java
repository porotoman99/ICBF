package icbf;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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

	public static final Item LOCKALLOY_INGOT = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "lockalloy_ingot"),
			new Item(new FabricItemSettings().group(ItemGroup.MATERIALS))
	);

	public static final Item BRASS_INGOT = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "brass_ingot"),
			new Item(new FabricItemSettings().group(ItemGroup.MATERIALS))
	);

	public static final Item GUNMETAL_INGOT = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "gunmetal_ingot"),
			new Item(new FabricItemSettings().group(ItemGroup.MATERIALS))
	);

	public static final Item MAGNOX_INGOT = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "magnox_ingot"),
			new Item(new FabricItemSettings().group(ItemGroup.MATERIALS))
	);

	public static final Item BELL_METAL_INGOT = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "bell_metal_ingot"),
			new Item(new FabricItemSettings().group(ItemGroup.MATERIALS))
	);

	public static final Item OBLITERITE_INGOT = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "obliterite_ingot"),
			new Item(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof())
	);

	public static final Block ROSE_GOLD_BLOCK = Registry.register(
			Registry.BLOCK,
			new Identifier("icbf", "rose_gold_block"),
			new Block(FabricBlockSettings.of(Material.METAL, MapColor.GOLD).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.METAL))
	);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading ICBF...");

		Registry.register(
				Registry.ITEM,
				new Identifier("icbf", "rose_gold_block"),
				new BlockItem(ROSE_GOLD_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS))
		);

		LOGGER.info("ICBF loaded!");
	}
}
