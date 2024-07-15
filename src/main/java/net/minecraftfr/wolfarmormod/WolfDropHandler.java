package net.minecraftfr.wolfarmormod;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;

public class WolfDropHandler {
  public static void register() {
    ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
      if (killedEntity instanceof WolfEntity) {
        int lootingLevel = 0;

        if (entity instanceof PlayerEntity) {
          PlayerEntity player = (PlayerEntity) entity;
          lootingLevel = EnchantmentHelper.getEquipmentLevel(Enchantments.LOOTING, player);
        }

        Random random = world.getRandom();
        int leatherCount = random.nextBetween(1, 1 + lootingLevel);
        int toothCount = random.nextBetween(0, 1 + lootingLevel);

        for (int i = 0; i < leatherCount; i++) {
          killedEntity.dropItem(ModItems.WOLF_LEATHER);
        }

        for (int i = 0; i < toothCount; i++) {
          killedEntity.dropItem(ModItems.WOLF_TOOTH);
        }
      }
    });
  }
}
