package net.razvan.oiiamod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.item.custom.FuelItem;
import net.razvan.oiiamod.item.custom.OiiaItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Oiia.MOD_ID);

    public static final DeferredItem<Item> OIIAITE = ITEMS.register("oiiaite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_OIIAITE = ITEMS.register("raw_oiiaite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> OIIATOR = ITEMS.register("oiiator",
            () -> new OiiaItem(new Item.Properties().durability(32)));
    public static final DeferredItem<Item> CAT_POOP = ITEMS.register("cat_poop",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CAT_POO)));
    public static final DeferredItem<Item> DEAD_CAT = ITEMS.register("dead_cat",
            () -> new FuelItem(new Item.Properties(), 1000));
    public static final DeferredItem<Item> HALF_DEAD_CAT = ITEMS.register("half_dead_cat",
            () -> new Item(new Item.Properties())); //metoda 2, in neoforge/data_maps/item/furnace_fuels.json!!!

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
