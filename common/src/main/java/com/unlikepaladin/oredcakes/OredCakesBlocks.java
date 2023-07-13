package com.unlikepaladin.oredcakes;

import com.unlikepaladin.oredcakes.blocks.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;

public class OredCakesBlocks {
    public static Block NETHERITE_CAKE = new NetheriteCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.COLOR_BLACK).sound(SoundType.NETHERITE_BLOCK).noOcclusion().strength(50.0f, 1200.0f));
    public static Block DIAMOND_CAKE = new DiamondCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.DIAMOND).sound(SoundType.METAL).noOcclusion().strength(5.0f, 6.0f));
    public static Block EMERALD_CAKE = new EmeraldCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.EMERALD).sound(SoundType.METAL).noOcclusion().strength(5.0f, 6.0f));
    public static Block GOLD_CAKE = new GoldCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.GOLD).sound(SoundType.METAL).noOcclusion().strength(3.0f, 6.0f));
    public static Block COAL_CAKE = new CoalCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.COLOR_BLACK).noOcclusion().strength(5.0f, 6.0f));
    public static Block LAPIS_CAKE = new LapisCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.LAPIS).sound(SoundType.METAL).noOcclusion().strength(3.0f, 3.0f));
    public static Block IRON_CAKE = new IronCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.METAL).sound(SoundType.METAL).noOcclusion().strength(5.0f, 6.0f));
    public static Block REDSTONE_CAKE = new RedstoneCakeBlock(BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.FIRE).sound(SoundType.METAL).noOcclusion().strength(5.0f, 6.0f).isRedstoneConductor((blockState, blockGetter, blockPos) -> false));


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

}
