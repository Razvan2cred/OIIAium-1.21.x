package net.razvan.oiiamod.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;
import net.razvan.oiiamod.block.ModBlocks;
import net.razvan.oiiamod.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.OIIAITE_BLOCK.get());
        //dropSelf(ModBlocks.MAGIC_BLOCK.get());

        add(ModBlocks.OIIAITE_ORE.get(),
                block -> createOreDrop(ModBlocks.OIIAITE_ORE.get(), ModItems.RAW_OIIAITE.get()));
        add(ModBlocks.OIIAITE_DEEPSLATE_ORE.get(),
            block -> createMultipleOreDrops(ModBlocks.OIIAITE_DEEPSLATE_ORE.get(), ModItems.RAW_OIIAITE.get(),2,3));

        dropSelf(ModBlocks.OIIA_STAIRS.get());
        add(ModBlocks.OIIA_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OIIA_SLAB.get()));

        dropSelf(ModBlocks.OIIA_BUTTON.get());
        dropSelf(ModBlocks.OIIA_PRESSURE_PLATE.get());

        dropSelf(ModBlocks.OIIA_FENCE.get());
        dropSelf(ModBlocks.OIIA_FENCE_GATE.get());
        dropSelf(ModBlocks.OIIA_WALL.get());
        dropSelf(ModBlocks.OIIA_TRAPDOOR.get());

        add(ModBlocks.OIIA_DOOR.get(),
                block -> createDoorTable(ModBlocks.OIIA_DOOR.get()));

        dropSelf(ModBlocks.OIIA_LAMP.get());

    }



    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops,maxDrops)))
                    .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
