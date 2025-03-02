package net.razvan.oiiamod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Oiia.MOD_ID);

    public static final Supplier<CreativeModeTab> OIIA_ITEMS_TAB = CREATIVE_MODE_TAB.register("oiia_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OIIAITE.get()))
                    .title(Component.translatable("creativetab.oiiamod.oiia_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.OIIAITE);
                        output.accept(ModItems.RAW_OIIAITE);

                        output.accept(ModItems.OIIATOR);
                        output.accept(ModItems.CAT_POOP);
                        output.accept(ModItems.DEAD_CAT);
                        output.accept(ModItems.HALF_DEAD_CAT);

                        output.accept(ModItems.OIIAITE_HELMET);
                        output.accept(ModItems.OIIAITE_CHESTPLATE);
                        output.accept(ModItems.OIIAITE_LEGGINGS);
                        output.accept(ModItems.OIIAITE_BOOTS);

                        output.accept(ModItems.OIIA_SWORD);
                        output.accept(ModItems.OIIA_PICKAXE);
                        output.accept(ModItems.OIIA_AXE);
                        output.accept(ModItems.OIIA_SHOVEL);
                        output.accept(ModItems.OIIA_HOE);

                        output.accept(ModItems.OIIA_HAMMER);

                        output.accept(ModItems.OIIAITE_HORSE_ARMOR);
                    }).build());
    public static final Supplier<CreativeModeTab> OIIA_BLOCKS_TAB = CREATIVE_MODE_TAB.register("oiia_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.OIIAITE_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, "oiia_items_tab"))
                    .title(Component.translatable("creativetab.oiiamod.oiia_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.OIIAITE_BLOCK);
                        output.accept(ModBlocks.OIIAITE_ORE);
                        output.accept(ModBlocks.OIIAITE_DEEPSLATE_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModBlocks.OIIA_STAIRS);
                        output.accept(ModBlocks.OIIA_SLAB);

                        output.accept(ModBlocks.OIIA_PRESSURE_PLATE);
                        output.accept(ModBlocks.OIIA_BUTTON);

                        output.accept(ModBlocks.OIIA_DOOR);
                        output.accept(ModBlocks.OIIA_TRAPDOOR);

                        output.accept(ModBlocks.OIIA_FENCE);
                        output.accept(ModBlocks.OIIA_FENCE_GATE);

                        output.accept(ModBlocks.OIIA_WALL);

                        output.accept(ModBlocks.OIIA_LAMP);
                    }).build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
