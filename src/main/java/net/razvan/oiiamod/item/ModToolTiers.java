package net.razvan.oiiamod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.razvan.oiiamod.util.ModTags;

public class ModToolTiers {
    public static final Tier OIIAITE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_OIIA_TOOL,
            4269,4f,4f, 30, () -> Ingredient.of(ModItems.OIIAITE));
}
