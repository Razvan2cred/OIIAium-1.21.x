package net.razvan.oiiamod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Oiia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.OIIAITE_BLOCK.get())
                .add(ModBlocks.OIIAITE_ORE.get())
                .add(ModBlocks.OIIAITE_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.OIIAITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.OIIAITE_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.OIIA_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.OIIA_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.OIIA_WALL.get());

    }
}
