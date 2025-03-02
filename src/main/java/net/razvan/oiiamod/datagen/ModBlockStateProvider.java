package net.razvan.oiiamod.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

            stairsBlock(ModBlocks.OIIA_STAIRS.get(), blockTexture(ModBlocks.OIIAITE_BLOCK.get()));
            slabBlock(ModBlocks.OIIA_SLAB.get(), blockTexture(ModBlocks.OIIAITE_BLOCK.get()), blockTexture(ModBlocks.OIIAITE_BLOCK.get()));

            buttonBlock(ModBlocks.OIIA_BUTTON.get(), blockTexture(ModBlocks.OIIAITE_BLOCK.get()));
            pressurePlateBlock(ModBlocks.OIIA_PRESSURE_PLATE.get(), blockTexture(ModBlocks.OIIAITE_BLOCK.get()));

            fenceBlock(ModBlocks.OIIA_FENCE.get(), blockTexture(ModBlocks.OIIAITE_BLOCK.get()));
            fenceGateBlock(ModBlocks.OIIA_FENCE_GATE.get(), blockTexture(ModBlocks.OIIAITE_BLOCK.get()));
            wallBlock(ModBlocks.OIIA_WALL.get(), blockTexture(ModBlocks.OIIAITE_BLOCK.get()));

            doorBlockWithRenderType(ModBlocks.OIIA_DOOR.get(), modLoc("block/oiia_door_bottom"), modLoc("block/oiia_door_top"), "cutout");
            trapdoorBlockWithRenderType(ModBlocks.OIIA_TRAPDOOR.get(), modLoc("block/oiia_trapdoor"), true, "cutout");

            blockItem(ModBlocks.OIIA_STAIRS);
            blockItem(ModBlocks.OIIA_SLAB);
            blockItem(ModBlocks.OIIA_PRESSURE_PLATE);
            blockItem(ModBlocks.OIIA_TRAPDOOR, "_bottom");
            blockItem(ModBlocks.OIIA_FENCE_GATE);


    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("oiiamod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("oiiamod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
