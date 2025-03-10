package net.razvan.oiiamod.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.entity.ModEntities;
import net.razvan.oiiamod.entity.client.OiiaCatModel;
import net.razvan.oiiamod.entity.client.OiiaCatRenderer;
import net.razvan.oiiamod.entity.custom.OiiaCatEntity;

@EventBusSubscriber(modid = Oiia.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(OiiaCatModel.LAYER_LOCATION, OiiaCatModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.OIIA_CAT.get(), OiiaCatEntity.createAttributes().build());
    }
}
