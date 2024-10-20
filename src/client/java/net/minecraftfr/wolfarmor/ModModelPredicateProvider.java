package net.minecraftfr.wolfarmor;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
  public static void registerModModels() {
    registerBow(ModItems.WOLF_BOW);
  }

  private static void registerBow(Item bow) {
    ModelPredicateProviderRegistry.register(bow, Identifier.ofVanilla("pull"), (stack, world, entity, seed) -> {
			if (entity == null) {
				return 0.0F;
			} else {
				return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
			}
		});

    ModelPredicateProviderRegistry.register(
			bow,
			Identifier.ofVanilla("pulling"),
			(stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
		);
  }
}
