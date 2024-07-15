package net.minecraftfr.wolfarmormod.mixin;

import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraftfr.wolfarmormod.ModItems;

@Mixin(PowderSnowBlock.class)
public class PowderSnowBlockMixin {
  @Inject(method = "canWalkOnPowderSnow", at = @At("HEAD"), cancellable = true)
  private static void canWalkOnPowderSnow(Entity entity, CallbackInfoReturnable<Boolean> cir) {
    if (entity instanceof LivingEntity) {
      ItemStack boots = ((LivingEntity)entity).getEquippedStack(EquipmentSlot.FEET);
      if (boots.isOf(Items.LEATHER_BOOTS) || boots.isOf(ModItems.WOLF_BOOTS)) {
        cir.setReturnValue(true);
      }
    }
  }
}
