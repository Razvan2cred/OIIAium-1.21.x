package net.razvan.oiiamod.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.item.ModItems;
import net.razvan.oiiamod.potion.ModPotions;

@EventBusSubscriber(modid = Oiia.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
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
    public static final Holder<MobEffect> SIGMA_EFFECT = MOB_EFFECTS.register("sigma",
            () -> new SigmaEffect(MobEffectCategory.NEUTRAL, 0xcc0000)
                    .addAttributeModifier(Attributes.ATTACK_KNOCKBACK,
                            ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, "sigma"), 2.0f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.BLOCK_BREAK_SPEED,
                            ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, "sigma"), 3.0f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event){
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.WATER, ModItems.CAT_POOP.get(), ModPotions.GAY_POTION);
    }
}
