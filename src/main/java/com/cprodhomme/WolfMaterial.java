package com.cprodhomme;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

public class WolfMaterial implements ToolMaterial {
  public static final WolfMaterial INSTANCE = new WolfMaterial();

  @Override
  public int getDurability() {
    return ToolMaterials.STONE.getDurability();
  }

  @Override
  public float getMiningSpeedMultiplier() {
    return ToolMaterials.STONE.getMiningSpeedMultiplier();
  }

  @Override
  public float getAttackDamage() {
    return ToolMaterials.STONE.getAttackDamage();
  }

  @Override
  public TagKey<Block> getInverseTag() {
    return ToolMaterials.STONE.getInverseTag();
  }

  @Override
  public int getEnchantability() {
    return ToolMaterials.STONE.getEnchantability();
  }

  @Override
  public Ingredient getRepairIngredient() {
    return ToolMaterials.STONE.getRepairIngredient();
  }
}
