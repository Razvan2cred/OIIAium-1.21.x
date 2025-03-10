package net.razvan.oiiamod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.razvan.oiiamod.Oiia;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OIIAITE_ORE_PLACED_KEY = registerKey("oiiaite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_OIIAITE_ORE_PLACED_KEY = registerKey("nether_oiiaite_ore_placed");
    public static final ResourceKey<PlacedFeature> END_OIIAITE_ORE_PLACED_KEY = registerKey("end_oiiaite_ore_placed");
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, OIIAITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_OIIAITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_OIIAITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_OIIAITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_OIIAITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_OIIAITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
