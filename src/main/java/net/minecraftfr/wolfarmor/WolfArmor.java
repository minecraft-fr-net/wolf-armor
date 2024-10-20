package net.minecraftfr.wolfarmor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WolfArmor implements ModInitializer {
	public static final String MOD_ID = "wolf-armor";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initialize " + MOD_ID);

		ModArmorMaterials.initialize();
		ModItems.initialize();

		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			// Vérification si la table de loot correspond à celle du loup
			if (EntityType.WOLF.getLootTableId().equals(key)) {
				LootPool leatherPool = LootPool.builder()
								.with(ItemEntry.builder(ModItems.WOLF_LEATHER)
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f))))
								.build();

				LootPool toothPool = LootPool.builder()
								.with(ItemEntry.builder(ModItems.WOLF_TOOTH)
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f))))
								.build();

				tableBuilder.pool(leatherPool);
				tableBuilder.pool(toothPool);
			}
		});
	}
}
