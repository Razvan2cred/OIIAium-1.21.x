package net.razvan.oiiamod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.item.ModItems;
import net.razvan.oiiamod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Oiia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.RAW_OIIAITE.get())
                .add(Items.EGG)
                .add(ModItems.DEAD_CAT.get())
                .add(Items.NETHERITE_INGOT);

        tag(ItemTags.SWORDS)
                .add(ModItems.OIIA_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.OIIA_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.OIIA_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.OIIA_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.OIIA_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.OIIAITE_HELMET.get())
                .add(ModItems.OIIAITE_CHESTPLATE.get())
                .add(ModItems.OIIAITE_LEGGINGS.get())
                .add(ModItems.OIIAITE_BOOTS.get());
    }
}
