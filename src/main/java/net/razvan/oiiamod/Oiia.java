package net.razvan.oiiamod;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTabs;
import net.razvan.oiiamod.block.ModBlocks;
import net.razvan.oiiamod.component.ModDataComponents;
import net.razvan.oiiamod.effect.ModEffects;
import net.razvan.oiiamod.enchantment.ModEnchantmentEffects;
import net.razvan.oiiamod.entity.ModEntities;
import net.razvan.oiiamod.entity.client.OiiaCatRenderer;
import net.razvan.oiiamod.item.ModCreativeModeTabs;
import net.razvan.oiiamod.item.ModItems;
import net.razvan.oiiamod.potion.ModPotions;
import net.razvan.oiiamod.sound.ModSounds;
import net.razvan.oiiamod.util.ModItemProperties;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Oiia.MOD_ID)
public class Oiia {
    public static final String MOD_ID = "oiiamod";
    private static final Logger LOGGER = LogUtils.getLogger();
    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Oiia(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        // Register the item to a creative tab
        ModEffects.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        ModSounds.register(modEventBus);

        ModPotions.register(modEventBus);

        ModEnchantmentEffects.register(modEventBus);

        ModEntities.register(modEventBus);

        ModDataComponents.register(modEventBus);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.OIIAITE);
            event.accept(ModItems.RAW_OIIAITE);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.OIIAITE_BLOCK);
            event.accept(ModBlocks.OIIAITE_ORE);
            event.accept(ModBlocks.OIIAITE_DEEPSLATE_ORE);
            event.accept(ModBlocks.OIIA_LAMP);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();

            EntityRenderers.register(ModEntities.OIIA_CAT.get(), OiiaCatRenderer::new);
        }
    }
}
