package net.razvan.oiiamod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.razvan.oiiamod.effect.ModEffects;

public class ModFoodProperties {
    public static final FoodProperties CAT_POO = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 800),1f).build();
    public static final FoodProperties PEN = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(ModEffects.GAY_EFFECT, 800),1f).build();
    //shift shift foods.class non project!!!
}
