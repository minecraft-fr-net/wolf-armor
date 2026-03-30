package net.minecraftfr.wolfarmor.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftfr.wolfarmor.ModItems;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin {
	@Redirect(
		method = "getFovMultiplier",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
		)
	)
	private boolean wolfArmor$bowOrWolfBow(ItemStack stack, Item item) {
		if (item == Items.BOW) {
			return stack.isOf(Items.BOW) || stack.isOf(ModItems.WOLF_BOW);
		}
		return stack.isOf(item);
	}
}
