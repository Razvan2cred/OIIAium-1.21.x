package net.razvan.oiiamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.block.ModBlocks;
import net.razvan.oiiamod.block.custom.OiiaLampBlock;
import net.razvan.oiiamod.block.custom.PenCrop;
import net.razvan.oiiamod.block.custom.SigmaBushBlock;

import java.util.function.Function;

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

            makeCrop(((CropBlock) ModBlocks.PEN_CROP.get()), "pen_crop_stage", "pen_crop_stage");
            makeBush(((SweetBerryBushBlock) ModBlocks.SIGMA_BERRY_BUSH.get()), "sigma_berry_bush_stage", "sigma_berry_bush_stage");
    }
    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(SigmaBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, "block/" + textureName + state.getValue(SigmaBushBlock.AGE))).renderType("cutout"));

        return models;
    }
    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((PenCrop) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, "block/" + textureName + state.getValue(((PenCrop) block).getAgeProperty()))).renderType("cutout"));

        return models;
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
