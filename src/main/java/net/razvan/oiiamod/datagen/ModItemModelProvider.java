package net.razvan.oiiamod.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.razvan.oiiamod.Oiia;
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
    }


}
