package net.razvan.oiiamod.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;
import net.razvan.oiiamod.block.ModBlocks;
import net.razvan.oiiamod.block.custom.PenCrop;
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
        add(ModBlocks.OIIAITE_END_ORE.get(),
            block -> createMultipleOreDrops(ModBlocks.OIIAITE_END_ORE.get(), ModItems.RAW_OIIAITE.get(),3,6));
        add(ModBlocks.OIIAITE_NETHER_ORE.get(),
            block -> createMultipleOreDrops(ModBlocks.OIIAITE_NETHER_ORE.get(), ModItems.RAW_OIIAITE.get(),4,8));

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

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.PEN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PenCrop.AGE, 3));

        this.add(ModBlocks.PEN_CROP.get(), this.createCropDrops(ModBlocks.PEN_CROP.get(),
                ModItems.PEN.get(), ModItems.PEN_SEEDS.get(), lootItemConditionBuilder));

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.SIGMA_BERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SIGMA_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.SIGMA_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 5.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SIGMA_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.SIGMA_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));

        this.dropSelf(ModBlocks.TECHWOOD_LOG.get());
        this.dropSelf(ModBlocks.TECHWOOD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_TECHWOOD_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_TECHWOOD_WOOD.get());
        this.dropSelf(ModBlocks.TECHWOOD_PLANKS.get());
        this.dropSelf(ModBlocks.TECHWOOD_SAPLING.get());

        this.add(ModBlocks.TECHWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.TECHWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

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
