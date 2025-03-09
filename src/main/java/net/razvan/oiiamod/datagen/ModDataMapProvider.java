package net.razvan.oiiamod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.razvan.oiiamod.item.ModItems;
import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.HALF_DEAD_CAT.getId(), new FurnaceFuel(600), false)
                .add(ModItems.DEAD_CAT.getId(), new FurnaceFuel(1200), false);
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.PEN_SEEDS.getId(), new Compostable(0.25f), false)
                .add(ModItems.PEN.getId(), new Compostable(0.69f), false);
    }
}
