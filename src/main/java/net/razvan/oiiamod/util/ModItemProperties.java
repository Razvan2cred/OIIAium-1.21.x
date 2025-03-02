package net.razvan.oiiamod.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.component.ModDataComponents;
import net.razvan.oiiamod.item.ModItems;

public class ModItemProperties {
    public static void addCustomItemProperties() {//ctrl + l click ItemProperties pt inspiratie!!!
        ItemProperties.register(ModItems.OIIATOR.get(), ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, "used"),
                (stack, level, entity, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f:0f);
    }
}
