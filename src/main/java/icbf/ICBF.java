package icbf;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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

	public static final Item BRONZE_INGOT = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "bronze_ingot"),
			new Item(new FabricItemSettings().group(ItemGroup.MATERIALS))
	);

	public static final Item OBLITERITE_INGOT = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "obliterite_ingot"),
			new Item(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof())
	);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading ICBF...");
		LOGGER.info("ICBF loaded!");
	}
}
