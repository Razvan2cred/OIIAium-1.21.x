package net.razvan.oiia.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.razvan.oiia.Oiia;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Oiia.MOD_ID);

    public static final DeferredItem<Item> OIIAITE = ITEMS.register("oiiaite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_OIIAITE = ITEMS.register("raw_oiiaite",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
