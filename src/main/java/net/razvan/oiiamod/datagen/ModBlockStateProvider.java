package net.razvan.oiiamod.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Oiia.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
            blockWithItem(ModBlocks.MAGIC_BLOCK);

            blockWithItem(ModBlocks.OIIAITE_BLOCK);

            blockWithItem(ModBlocks.OIIAITE_DEEPSLATE_ORE);
            blockWithItem(ModBlocks.OIIAITE_ORE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
