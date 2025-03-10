package net.razvan.oiiamod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower TECHWOOD = new TreeGrower(Oiia.MOD_ID + ":techwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.TECHWOOD_KEY), Optional.empty());
}
