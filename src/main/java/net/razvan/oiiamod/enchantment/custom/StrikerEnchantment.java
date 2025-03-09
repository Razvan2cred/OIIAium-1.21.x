package net.razvan.oiiamod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

import java.util.Map;

public record StrikerEnchantment() implements EnchantmentEntityEffect {//ctrl+h insp!
    public static final MapCodec<StrikerEnchantment> CODEC = MapCodec.unit(StrikerEnchantment::new);
    @Override
    public void apply(ServerLevel serverLevel, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        if(enchantmentLevel == 1) {
            EntityType.IRON_GOLEM.spawn(serverLevel, entity.getOnPos(), MobSpawnType.TRIGGERED);
        }
        if(enchantmentLevel == 2) {
            EntityType.IRON_GOLEM.spawn(serverLevel, entity.getOnPos(), MobSpawnType.TRIGGERED);
            EntityType.SNOW_GOLEM.spawn(serverLevel, entity.getOnPos(), MobSpawnType.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
