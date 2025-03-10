package net.razvan.oiiamod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.block.ModBlocks;
import net.razvan.oiiamod.entity.ModEntities;
import net.razvan.oiiamod.item.custom.FuelItem;
import net.razvan.oiiamod.item.custom.HammerItem;
import net.razvan.oiiamod.item.custom.ModArmorItem;
import net.razvan.oiiamod.item.custom.OiiaItem;
import net.razvan.oiiamod.sound.ModSounds;

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
    public static final DeferredItem<ArmorItem> OIIAITE_HELMET = ITEMS.register("oiiaite_helmet",
        () -> new ModArmorItem(ModArmorMaterials.OIIAITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(35))));
    public static final DeferredItem<ArmorItem> OIIAITE_CHESTPLATE = ITEMS.register("oiiaite_chestplate",
        () -> new ArmorItem(ModArmorMaterials.OIIAITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(35))));
    public static final DeferredItem<ArmorItem> OIIAITE_LEGGINGS = ITEMS.register("oiiaite_leggings",
        () -> new ArmorItem(ModArmorMaterials.OIIAITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(35))));
    public static final DeferredItem<ArmorItem> OIIAITE_BOOTS = ITEMS.register("oiiaite_boots",
        () -> new ArmorItem(ModArmorMaterials.OIIAITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(35))));
    public static final DeferredItem<Item> OIIAITE_HORSE_ARMOR = ITEMS.register("oiiaite_horse_armor",
        () ->  new AnimalArmorItem(ModArmorMaterials.OIIAITE_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                false, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> COMPOUND_BOW = ITEMS.register("compound_bow",
            () -> new BowItem(new Item.Properties().durability(690)));
    public static final DeferredItem<Item> OIIA_TECH_MUSIC_DISC = ITEMS.register("oiia_tech_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.OIIA_TECH_KEY).stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> PEN_SEEDS = ITEMS.register("pen_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PEN_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> PEN = ITEMS.register("pen",
            () -> new ItemNameBlockItem(ModBlocks.PEN_CROP.get(), new Item.Properties().food(ModFoodProperties.PEN)));
    public static final DeferredItem<Item> SIGMA_BERRIES = ITEMS.register("sigma_berries",
            () -> new ItemNameBlockItem(ModBlocks.SIGMA_BERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.SIGMA_BERRIES)));
    public static final DeferredItem<Item> OIIA_CAT_SPAWN_EGG = ITEMS.register("oiia_cat_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.OIIA_CAT, 0x241408, 0x362214,
                    new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
