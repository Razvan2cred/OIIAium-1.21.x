package net.razvan.oiiamod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.block.custom.*;
import net.razvan.oiiamod.item.ModItems;
import net.razvan.oiiamod.sound.ModSounds;
import net.razvan.oiiamod.worldgen.tree.ModTreeGrowers;

import javax.swing.*;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Oiia.MOD_ID);

    public static final DeferredBlock<Block> OIIAITE_BLOCK = registerBlock("oiiaite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST))); // !!double shift Blocks non-project!!
    public static final DeferredBlock<Block> OIIAITE_ORE = registerBlock("oiiaite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> OIIAITE_DEEPSLATE_ORE = registerBlock("oiiaite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> OIIAITE_END_ORE = registerBlock("oiiaite_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,9),
                    BlockBehaviour.Properties.of().strength(7f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> OIIAITE_NETHER_ORE = registerBlock("oiiaite_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(1,5),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).noLootTable().sound(ModSounds.MAGIC_BLOCK_SOUNDS)));
                                    //MERGE SI CU SoundTypes
    public static final DeferredBlock<StairBlock> OIIA_STAIRS = registerBlock("oiia_stairs",
            () -> new StairBlock(ModBlocks.OIIAITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> OIIA_SLAB = registerBlock("oiia_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> OIIA_PRESSURE_PLATE = registerBlock("oiia_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> OIIA_BUTTON = registerBlock("oiia_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> OIIA_FENCE = registerBlock("oiia_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> OIIA_FENCE_GATE = registerBlock("oiia_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> OIIA_WALL = registerBlock("oiia_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));


    public static final DeferredBlock<DoorBlock> OIIA_DOOR = registerBlock("oiia_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> OIIA_TRAPDOOR = registerBlock("oiia_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<Block> OIIA_LAMP = registerBlock("oiia_lamp",
            () -> new OiiaLampBlock(BlockBehaviour.Properties.of().strength(2f)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(OiiaLampBlock.CLICKED) ? 15:0)));

    public static final DeferredBlock<Block> PEN_CROP = BLOCKS.register("pen_crop",
            () -> new PenCrop(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));
    public static final DeferredBlock<Block> SIGMA_BERRY_BUSH = BLOCKS.register("sigma_berry_bush",
            () -> new SigmaBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    public static final DeferredBlock<Block> TECHWOOD_LOG = registerBlock("techwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> TECHWOOD_WOOD = registerBlock("techwood_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_TECHWOOD_LOG = registerBlock("stripped_techwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_TECHWOOD_WOOD = registerBlock("stripped_techwood_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> TECHWOOD_PLANKS = registerBlock("techwood_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<Block> TECHWOOD_LEAVES = registerBlock("techwood_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> TECHWOOD_SAPLING = registerBlock("techwood_sapling",
            () -> new SaplingBlock(ModTreeGrowers.TECHWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
