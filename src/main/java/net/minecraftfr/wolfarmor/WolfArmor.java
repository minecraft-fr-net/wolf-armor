package net.minecraftfr.wolfarmor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WolfArmor implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
  public static final Logger LOGGER = LoggerFactory.getLogger("wolf-armor");
	public static final String MOD_ID = "wolf-armor";

	@Override
	public void onInitialize() {
		LOGGER.info("Initialize " + MOD_ID);

		ModArmorMaterials.initialize();
		ModItems.initialize();

		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			// Vérification si la table de loot correspond à celle du loup
			if (EntityType.WOLF.getLootTableId().equals(key)) {
				// Création d'une pool de loot pour les os
				LootPool leatherPool = LootPool.builder()
								.with(ItemEntry.builder(ModItems.WOLF_LEATHER)
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
												.apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f))))
								.build();

				LootPool toothPool = LootPool.builder()
								.with(ItemEntry.builder(ModItems.WOLF_TOOTH)
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)))
												.apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f))))
								.build();

				tableBuilder.pool(leatherPool);
				tableBuilder.pool(toothPool);
			}
		});
	}
}
