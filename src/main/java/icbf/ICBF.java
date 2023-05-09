package icbf;

import icbf.item.custom.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.item.v1.ModifyItemAttributeModifiersCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

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
			new DyeableGloveItem(LeatherGloveMaterial.INSTANCE, new FabricItemSettings().group(ItemGroup.COMBAT))
	);

	public static final Item CHAINMAIL_GLOVE = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "chainmail_glove"),
			new GloveItem(ChainmailGloveMaterial.INSTANCE, new FabricItemSettings().group(ItemGroup.COMBAT))
	);

	public static final Item IRON_GLOVE = Registry.register(
			Registry.ITEM,
			new Identifier("icbf", "iron_glove"),
			new GloveItem(IronGloveMaterial.INSTANCE, new FabricItemSettings().group(ItemGroup.COMBAT))
	);

	@Override
	public void onInitialize() {

		Registry.register(
				Registry.ITEM,
				new Identifier("icbf", "rose_gold_block"),
				new BlockItem(ROSE_GOLD_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS))
		);

		//Allows Leather Gloves to be washed off in cauldrons
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

		//Gives gloves armor values when in the offhand
		ModifyItemAttributeModifiersCallback.EVENT.register(((stack, slot, attributeModifiers) -> {
			if(stack.isOf(LEATHER_GLOVE) && slot.getEntitySlotId() == EquipmentSlot.OFFHAND.getEntitySlotId()){
				attributeModifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("5e48ea94-f441-4d7d-a8c9-fb801450226b"), "Armor modifier", 1, EntityAttributeModifier.Operation.ADDITION));
			}
		}));
		ModifyItemAttributeModifiersCallback.EVENT.register(((stack, slot, attributeModifiers) -> {
			if(stack.isOf(CHAINMAIL_GLOVE) && slot.getEntitySlotId() == EquipmentSlot.OFFHAND.getEntitySlotId()){
				attributeModifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("7de4836d-93e0-4223-ba39-c74a4dc8d986"), "Armor modifier", 2, EntityAttributeModifier.Operation.ADDITION));
			}
		}));
		ModifyItemAttributeModifiersCallback.EVENT.register(((stack, slot, attributeModifiers) -> {
			if(stack.isOf(IRON_GLOVE) && slot.getEntitySlotId() == EquipmentSlot.OFFHAND.getEntitySlotId()){
				attributeModifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("75d10d51-115e-4fbf-b57e-294296136e55"), "Armor modifier", 3, EntityAttributeModifier.Operation.ADDITION));
			}
		}));

		LOGGER.info("ICBF loaded!");
	}
}
