package net.minecraftfr.wolfarmor;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
  public static final Item WOLF_HELMET = register(new ArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(5))), "wolf_helmet");
  public static final Item WOLF_CHESTPLATE = register(new ArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(5))), "wolf_chestplate");
  public static final Item WOLF_LEGGINGS = register(new ArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(5))), "wolf_leggings");
  public static final Item WOLF_BOOTS = register(new ArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(5))), "wolf_boots");

  public static final Item WOLF_LEATHER = register(new Item(new Item.Settings()), "wolf_leather");
  public static final Item WOLF_TOOTH = register(new Item(new Item.Settings()), "wolf_tooth");

  public static final Item WOLF_SWORD = register(new SwordItem(ToolMaterials.STONE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 3, -2.4F))), "wolf_sword");
  public static final Item WOLF_BOW = register(new BowItem(new Item.Settings().maxDamage(384)), "wolf_bow");

  public static void initialize() {
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(itemGroup -> {
      // Armor
      itemGroup.add(ModItems.WOLF_HELMET);
      itemGroup.add(ModItems.WOLF_CHESTPLATE);
      itemGroup.add(ModItems.WOLF_LEGGINGS);
      itemGroup.add(ModItems.WOLF_BOOTS);

      // Weapon
      itemGroup.add(ModItems.WOLF_SWORD);
      itemGroup.add(ModItems.WOLF_BOW);
    });

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> {
      itemGroup.add(ModItems.WOLF_LEATHER);
      itemGroup.add(ModItems.WOLF_TOOTH);
    });
  }

	public static Item register(Item item, String id) {
		// Create the identifier for the item.
		Identifier itemID = Identifier.of(WolfArmor.MOD_ID, id);

		// Register the item.
		Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

		// Return the registered item!
		return registeredItem;
	}
}
