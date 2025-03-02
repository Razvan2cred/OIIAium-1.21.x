package net.razvan.oiiamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.block.ModBlocks;
import net.razvan.oiiamod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Oiia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.OIIAITE.get());
        basicItem(ModItems.RAW_OIIAITE.get());

        basicItem(ModItems.CAT_POOP.get());

        basicItem(ModItems.DEAD_CAT.get());
        basicItem(ModItems.HALF_DEAD_CAT.get());

        basicItem(ModItems.OIIATOR.get());

        buttonItem(ModBlocks.OIIA_BUTTON, ModBlocks.OIIAITE_BLOCK);
        fenceItem(ModBlocks.OIIA_FENCE, ModBlocks.OIIAITE_BLOCK);
        wallItem(ModBlocks.OIIA_WALL, ModBlocks.OIIAITE_BLOCK);

        basicItem(ModBlocks.OIIA_DOOR.asItem());

        handheldItem(ModItems.OIIA_SWORD);
        handheldItem(ModItems.OIIA_PICKAXE);
        handheldItem(ModItems.OIIA_AXE);
        handheldItem(ModItems.OIIA_SHOVEL);
        handheldItem(ModItems.OIIA_HOE);
    }
    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID,"item/" + item.getId().getPath()));
    }
}
