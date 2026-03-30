package net.minecraftfr.wolfarmor;

import java.util.function.Function;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
	public static final Item WOLF_HELMET = register("wolf_helmet", s -> new Item(s.armor(ModArmorMaterials.WOLF, EquipmentType.HELMET)));
	public static final Item WOLF_CHESTPLATE = register("wolf_chestplate", s -> new Item(s.armor(ModArmorMaterials.WOLF, EquipmentType.CHESTPLATE)));
	public static final Item WOLF_LEGGINGS = register("wolf_leggings", s -> new Item(s.armor(ModArmorMaterials.WOLF, EquipmentType.LEGGINGS)));
	public static final Item WOLF_BOOTS = register("wolf_boots", s -> new Item(s.armor(ModArmorMaterials.WOLF, EquipmentType.BOOTS)));

	public static final Item WOLF_LEATHER = register("wolf_leather", Item::new);
	public static final Item WOLF_TOOTH = register("wolf_tooth", Item::new);

	public static final Item WOLF_SWORD = register("wolf_sword", s -> new Item(s.sword(ToolMaterial.STONE, 3, -2.4F)));
	public static final Item WOLF_DAGGER = register("wolf_dagger", s -> new Item(s.sword(ToolMaterial.STONE, 2, -1.9F)));
	public static final Item WOLF_BOW = register("wolf_bow", s -> new BowItem(s.maxDamage(384)));

	public static void initialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(itemGroup -> {
			itemGroup.add(ModItems.WOLF_HELMET);
			itemGroup.add(ModItems.WOLF_CHESTPLATE);
			itemGroup.add(ModItems.WOLF_LEGGINGS);
			itemGroup.add(ModItems.WOLF_BOOTS);
			itemGroup.add(ModItems.WOLF_SWORD);
			itemGroup.add(ModItems.WOLF_DAGGER);
			itemGroup.add(ModItems.WOLF_BOW);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> {
			itemGroup.add(ModItems.WOLF_LEATHER);
			itemGroup.add(ModItems.WOLF_TOOTH);
		});
	}

	private static Item register(String id, Function<Item.Settings, Item> factory) {
		Identifier itemId = Identifier.of(WolfArmor.MOD_ID, id);
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
		Item item = factory.apply(new Item.Settings().registryKey(key));
		return Registry.register(Registries.ITEM, itemId, item);
	}
}
