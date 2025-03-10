package net.razvan.oiiamod.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.razvan.oiiamod.Oiia;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_OIIAITE_ORE = registerKey("add_oiiaite_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_OIIAITE_ORE = registerKey("add_nether_oiiaite_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_OIIAITE_ORE = registerKey("add_end_oiiaite_ore");
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        // CF -> PF -> BM
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_OIIAITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.OIIAITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
/* EXAMPLE INDIVIDUAL BIOMES
        context.register(ADD_OIIAITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BEACH), biomes.getOrThrow(Biomes.COLD_OCEAN)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.OIIAITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        */
        context.register(ADD_NETHER_OIIAITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_OIIAITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_OIIAITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_OIIAITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

    }
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, name));
    }
}
