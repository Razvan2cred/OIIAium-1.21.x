package net.razvan.oiiamod.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.razvan.oiiamod.Oiia;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Oiia.MOD_ID);

    public static final Holder<MobEffect> GAY_EFFECT = MOB_EFFECTS.register("gay",
            () -> new GayEffect(MobEffectCategory.NEUTRAL, 0xab36ab)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, "gay"), -0.5f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.MAX_HEALTH,
                            ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, "gay"), -0.5f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }

}
