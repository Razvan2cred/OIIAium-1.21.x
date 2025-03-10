package net.razvan.oiiamod.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.entity.custom.OiiaCatEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Oiia.MOD_ID);

    public static final Supplier<EntityType<OiiaCatEntity>> OIIA_CAT =
            ENTITY_TYPES.register("oiia_cat", () -> EntityType.Builder.of(OiiaCatEntity::new, MobCategory.CREATURE)
                    .sized(1f,0.80f).build("oiia_cat"));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
