package net.razvan.oiiamod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_OIIAITE_ORE_KEY = registerKey("oiiaite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_OIIAITE_ORE_KEY = registerKey("nether_oiiaite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_OIIAITE_ORE_KEY = registerKey("end_oiiaite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TECHWOOD_KEY = registerKey("techwood");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        //CF -> PF -> BM
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldOiiaiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.OIIAITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.OIIAITE_DEEPSLATE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_OIIAITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOiiaiteOres, 9));
        register(context, NETHER_OIIAITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.OIIAITE_NETHER_ORE.get().defaultBlockState(), 9));
        register(context, END_OIIAITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.OIIAITE_END_ORE.get().defaultBlockState(), 8));

        register(context, TECHWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.TECHWOOD_LOG.get()),
                new ForkingTrunkPlacer(2, 8, 2), //play around!!!!!

                BlockStateProvider.simple(ModBlocks.TECHWOOD_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
