package net.razvan.oiiamod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.item.custom.FuelItem;
import net.razvan.oiiamod.item.custom.HammerItem;
import net.razvan.oiiamod.item.custom.OiiaItem;

import java.util.List;
import java.util.Properties;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Oiia.MOD_ID);

    public static final DeferredItem<Item> OIIAITE = ITEMS.register("oiiaite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_OIIAITE = ITEMS.register("raw_oiiaite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> OIIATOR = ITEMS.register("oiiator",
            () -> new OiiaItem(new Item.Properties().durability(32)));
    public static final DeferredItem<Item> CAT_POOP = ITEMS.register("cat_poop", //todo golden cat poo!
            () -> new Item(new Item.Properties().food(ModFoodProperties.CAT_POO)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.oiiamod.cat_poo.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> DEAD_CAT = ITEMS.register("dead_cat",
            () -> new FuelItem(new Item.Properties(), 1000));
    public static final DeferredItem<Item> HALF_DEAD_CAT = ITEMS.register("half_dead_cat",
            () -> new Item(new Item.Properties())); //metoda 2, in neoforge/data_maps/item/furnace_fuels.json!!!

    public static final DeferredItem<SwordItem> OIIA_SWORD = ITEMS.register("oiia_sword",
            () -> new SwordItem(ModToolTiers.OIIAITE, new Item.Properties().fireResistant()
                    .attributes(SwordItem.createAttributes(ModToolTiers.OIIAITE, 8, -1.4f))));
    public static final DeferredItem<PickaxeItem> OIIA_PICKAXE = ITEMS.register("oiia_pickaxe",
            () -> new PickaxeItem(ModToolTiers.OIIAITE, new Item.Properties().fireResistant()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.OIIAITE, 4.0f, -3f))));
    public static final DeferredItem<AxeItem> OIIA_AXE = ITEMS.register("oiia_axe",
            () -> new AxeItem(ModToolTiers.OIIAITE, new Item.Properties().fireResistant()
                    .attributes(AxeItem.createAttributes(ModToolTiers.OIIAITE, 9, -3.4f))));
    public static final DeferredItem<ShovelItem> OIIA_SHOVEL = ITEMS.register("oiia_shovel",
            () -> new ShovelItem(ModToolTiers.OIIAITE, new Item.Properties().fireResistant()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.OIIAITE, 5, -3f))));
    public static final DeferredItem<HoeItem> OIIA_HOE = ITEMS.register("oiia_hoe",
            () -> new HoeItem(ModToolTiers.OIIAITE, new Item.Properties().fireResistant()
                    .attributes(HoeItem.createAttributes(ModToolTiers.OIIAITE, 20, -3.9f))));
    public static final DeferredItem<HammerItem> OIIA_HAMMER = ITEMS.register("oiia_hammer",
            () -> new HammerItem(ModToolTiers.OIIAITE, new Item.Properties().fireResistant()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.OIIAITE, 7f, -3.5f))));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
