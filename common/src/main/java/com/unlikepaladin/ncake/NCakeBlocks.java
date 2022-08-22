package com.unlikepaladin.ncake;

import com.unlikepaladin.ncake.blocks.CandleNCakeBlock;
import com.unlikepaladin.ncake.blocks.NCakeBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;

import java.util.function.ToIntFunction;

public class NCakeBlocks {
    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> (Boolean)state.getValue(BlockStateProperties.LIT) ? litLevel : 0;
    }

    public static Block NCAKE = new NCakeBlock(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.NETHERITE_BLOCK).noOcclusion().strength(50.0f, 1200.0f));
    public static Block CANDLE_NCAKE = new CandleNCakeBlock(Blocks.CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(createLightLevelFromLitBlockState(3)));
    public static Block WHITE_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.WHITE_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block ORANGE_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.ORANGE_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block MAGENTA_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.MAGENTA_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block LIGHT_BLUE_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.LIGHT_BLUE_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block YELLOW_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.YELLOW_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block LIME_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.LIME_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block PINK_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.PINK_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block GRAY_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.GRAY_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block LIGHT_GRAY_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.LIGHT_GRAY_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block CYAN_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.CYAN_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block PURPLE_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.PURPLE_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block BLUE_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.BLUE_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block BROWN_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.BROWN_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block GREEN_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.GREEN_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block RED_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.RED_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));
    public static Block BLACK_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.BLACK_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(CANDLE_NCAKE));

    public static final Item NCAKE_ITEM = new BlockItem(NCAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD));
}
