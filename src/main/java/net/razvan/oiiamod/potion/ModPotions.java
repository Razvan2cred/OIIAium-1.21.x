package net.razvan.oiiamod.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, Oiia.MOD_ID);

    public static final Holder<Potion> GAY_POTION = POTIONS.register("gay_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.GAY_EFFECT, 69420, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
