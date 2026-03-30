package net.minecraftfr.wolfarmor;

import java.util.EnumMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModArmorMaterials {
	public static final TagKey<Item> REPAIRS_WOLF_ARMOR = TagKey.of(RegistryKeys.ITEM, Identifier.of(WolfArmor.MOD_ID, "repairs_wolf_armor"));
	public static final RegistryKey<net.minecraft.item.equipment.EquipmentAsset> WOLF_ASSET_KEY =
		RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(WolfArmor.MOD_ID, "wolf"));

	public static final ArmorMaterial WOLF = new ArmorMaterial(
		5,
		wolfDefense(),
		15,
		SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
		0.0F,
		0.0F,
		REPAIRS_WOLF_ARMOR,
		WOLF_ASSET_KEY
	);

	private static Map<EquipmentType, Integer> wolfDefense() {
		Map<EquipmentType, Integer> map = new EnumMap<>(EquipmentType.class);
		map.put(EquipmentType.BOOTS, 1);
		map.put(EquipmentType.LEGGINGS, 2);
		map.put(EquipmentType.CHESTPLATE, 3);
		map.put(EquipmentType.HELMET, 1);
		map.put(EquipmentType.BODY, 3);
		return map;
	}

	public static void initialize() {}
}
