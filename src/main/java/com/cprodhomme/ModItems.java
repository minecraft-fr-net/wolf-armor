package com.cprodhomme;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
  public static final Item WOLF_HELMET = register(new ArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.HELMET, new Item.Settings()), "wolf_helmet");
  public static final Item WOLF_CHESTPLATE = register(new ArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.CHESTPLATE, new Item.Settings()), "wolf_chestplate");
  public static final Item WOLF_LEGGINGS = register(new ArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.LEGGINGS, new Item.Settings()), "wolf_leggings");
  public static final Item WOLF_BOOTS = register(new ArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.BOOTS, new Item.Settings()), "wolf_boots");

  public static final Item WOLF_LEATHER = register(new Item(new Item.Settings()), "wolf_leather");
  public static final Item WOLF_TOOTH = register(new Item(new Item.Settings()), "wolf_tooth");

  public static void initialize() {
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
		  .register((itemGroup) -> itemGroup.add(ModItems.WOLF_HELMET));
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
      .register((itemGroup) -> itemGroup.add(ModItems.WOLF_CHESTPLATE));
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
		  .register((itemGroup) -> itemGroup.add(ModItems.WOLF_LEGGINGS));
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
      .register((itemGroup) -> itemGroup.add(ModItems.WOLF_BOOTS));

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
      .register((itemGroup) -> itemGroup.add(ModItems.WOLF_LEATHER));
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
      .register((itemGroup) -> itemGroup.add(ModItems.WOLF_TOOTH));
  }

	public static Item register(Item item, String id) {
		// Create the identifier for the item.
		Identifier itemID = Identifier.of(WolfArmorMod.MOD_ID, id);

		// Register the item.
		Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

		// Return the registered item!
		return registeredItem;
	}
}
