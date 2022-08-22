package com.unlikepaladin.ncake;

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
    public static Block NCAKE = new NCakeBlock(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.NETHERITE_BLOCK).noOcclusion().strength(50.0f, 1200.0f));
    public static final Item NCAKE_ITEM = new BlockItem(NCAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD));
}
