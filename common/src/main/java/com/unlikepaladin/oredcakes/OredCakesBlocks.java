package com.unlikepaladin.oredcakes;

import com.unlikepaladin.oredcakes.blocks.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

public class OredCakesBlocks {
    public static NetheriteCakeBlock NETHERITE_CAKE = new NetheriteCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.COLOR_BLACK).sound(SoundType.NETHERITE_BLOCK).noOcclusion().strength(50.0f, 1200.0f));
    public static DiamondCakeBlock DIAMOND_CAKE = new DiamondCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.DIAMOND).sound(SoundType.METAL).noOcclusion().strength(5.0f, 6.0f));
    public static EmeraldCakeBlock EMERALD_CAKE = new EmeraldCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.EMERALD).sound(SoundType.METAL).noOcclusion().strength(5.0f, 6.0f));
    public static GoldCakeBlock GOLD_CAKE = new GoldCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.GOLD).sound(SoundType.METAL).noOcclusion().strength(3.0f, 6.0f));
    public static CoalCakeBlock COAL_CAKE = new CoalCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.COLOR_BLACK).noOcclusion().strength(5.0f, 6.0f));
    public static LapisCakeBlock LAPIS_CAKE = new LapisCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.LAPIS).sound(SoundType.METAL).noOcclusion().strength(3.0f, 3.0f));
    public static IronCakeBlock IRON_CAKE = new IronCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.METAL).sound(SoundType.METAL).noOcclusion().strength(5.0f, 6.0f));
    public static RedstoneCakeBlock REDSTONE_CAKE = new RedstoneCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.FIRE).sound(SoundType.METAL).noOcclusion().strength(5.0f, 6.0f).isRedstoneConductor((blockState, blockGetter, blockPos) -> false));

    public static final Item NETHERITE_CAKE_ITEM = new BlockItem(NETHERITE_CAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1));
    public static final Item DIAMOND_CAKE_ITEM = new BlockItem(DIAMOND_CAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1));
    public static final Item EMERALD_CAKE_ITEM = new BlockItem(EMERALD_CAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1));
    public static final Item GOLD_CAKE_ITEM = new BlockItem(GOLD_CAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1));
    public static final Item COAL_CAKE_ITEM = new BlockItem(COAL_CAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)) {

        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 1600;
        }
    };
    public static final Item LAPIS_CAKE_ITEM = new BlockItem(LAPIS_CAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1));
    public static final Item IRON_CAKE_ITEM = new BlockItem(IRON_CAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1));
    public static final Item REDSTONE_CAKE_ITEM = new BlockItem(REDSTONE_CAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1));

    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> (Boolean)state.getValue(BlockStateProperties.LIT) ? litLevel : 0;
    }
    public static Block[] candles = new Block[] {Blocks.CANDLE, Blocks.WHITE_CANDLE, Blocks.ORANGE_CANDLE, Blocks.MAGENTA_CANDLE, Blocks.LIGHT_BLUE_CANDLE, Blocks.YELLOW_CANDLE, Blocks.LIME_CANDLE, Blocks.PINK_CANDLE, Blocks.GRAY_CANDLE, Blocks.LIGHT_GRAY_CANDLE, Blocks.CYAN_CANDLE, Blocks.PURPLE_CANDLE, Blocks.BLUE_CANDLE, Blocks.BROWN_CANDLE, Blocks.GREEN_CANDLE, Blocks.RED_CANDLE, Blocks.BLACK_CANDLE};
    public static AbstractOreCakeBlock[] cakes = new AbstractOreCakeBlock[] {NETHERITE_CAKE, DIAMOND_CAKE, EMERALD_CAKE, GOLD_CAKE, COAL_CAKE, LAPIS_CAKE, IRON_CAKE, REDSTONE_CAKE};
}
