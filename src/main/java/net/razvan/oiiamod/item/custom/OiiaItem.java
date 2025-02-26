package net.razvan.oiiamod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.razvan.oiiamod.block.ModBlocks;

import java.util.Map;

public class OiiaItem extends Item {
    private static final Map<Block, Block> OIIATOR_MAP=
            Map.of(
                    Blocks.NETHERITE_BLOCK, Blocks.DIAMOND_BLOCK,
                    Blocks.DIAMOND_BLOCK, Blocks.GOLD_BLOCK,
                    Blocks.GOLD_BLOCK, Blocks.IRON_BLOCK,
                    Blocks.IRON_BLOCK, ModBlocks.OIIAITE_BLOCK.get(),
                    ModBlocks.OIIAITE_BLOCK.get(), Blocks.AIR

            );
    public OiiaItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock =level.getBlockState(context.getClickedPos()).getBlock();

        if(OIIATOR_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), OIIATOR_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.CAT_PURREOW, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
