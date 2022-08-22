package com.unlikepaladin.ncake.forge;

import com.google.common.base.Suppliers;
import com.unlikepaladin.ncake.NCakeBlocks;
import com.unlikepaladin.ncake.NCakeMod;

import com.unlikepaladin.ncake.blocks.CandleNCakeBlock;
import com.unlikepaladin.ncake.blocks.NCakeBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.unlikepaladin.ncake.NCakeBlocks.*;
import static com.unlikepaladin.ncake.NCakeMod.*;

@Mod(NCakeMod.MOD_ID)
public class NCakeModForge {
    public NCakeModForge() {
        NCakeMod.init();
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryObject<Block> NCAKE = BLOCKS.register("ncake", () ->
           NCakeBlocks.NCAKE);
    public static final RegistryObject<Block> CANDLE_NCAKE = BLOCKS.register("candle_ncake", () ->
           NCakeBlocks.CANDLE_NCAKE);
    public static final RegistryObject<Block> WHITE_CANDLE_NCAKE = BLOCKS.register("white_candle_ncake", () ->
            NCakeBlocks.WHITE_CANDLE_NCAKE);
    public static final RegistryObject<Block> ORANGE_CANDLE_NCAKE = BLOCKS.register("orange_candle_ncake", () ->
            NCakeBlocks.ORANGE_CANDLE_NCAKE);
    public static final RegistryObject<Block> MAGENTA_CANDLE_NCAKE = BLOCKS.register("magenta_candle_ncake", () ->
            NCakeBlocks.MAGENTA_CANDLE_NCAKE);
    public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_NCAKE = BLOCKS.register("light_blue_candle_ncake", () ->
            NCakeBlocks.LIGHT_BLUE_CANDLE_NCAKE);
    public static final RegistryObject<Block> YELLOW_CANDLE_NCAKE = BLOCKS.register("yellow_candle_ncake", () ->
            NCakeBlocks.YELLOW_CANDLE_NCAKE);
    public static final RegistryObject<Block> LIME_CANDLE_NCAKE = BLOCKS.register("lime_candle_ncake", () ->
            NCakeBlocks.LIME_CANDLE_NCAKE);
    public static final RegistryObject<Block> PINK_CANDLE_NCAKE = BLOCKS.register("pink_candle_ncake", () ->
            NCakeBlocks.PINK_CANDLE_NCAKE);
    public static final RegistryObject<Block> GRAY_CANDLE_NCAKE = BLOCKS.register("gray_candle_ncake", () ->
            NCakeBlocks.GRAY_CANDLE_NCAKE);
    public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_NCAKE = BLOCKS.register("light_gray_candle_ncake", () ->
            NCakeBlocks.LIGHT_GRAY_CANDLE_NCAKE);
    public static final RegistryObject<Block> CYAN_CANDLE_NCAKE = BLOCKS.register("cyan_candle_ncake", () ->
            NCakeBlocks.CYAN_CANDLE_NCAKE);
    public static final RegistryObject<Block> PURPLE_CANDLE_NCAKE = BLOCKS.register("purple_candle_ncake", () ->
            NCakeBlocks.PURPLE_CANDLE_NCAKE);
    public static final RegistryObject<Block> BLUE_CANDLE_NCAKE = BLOCKS.register("blue_candle_ncake", () ->
            NCakeBlocks.BLUE_CANDLE_NCAKE);
    public static final RegistryObject<Block> BROWN_CANDLE_NCAKE = BLOCKS.register("brown_candle_ncake", () ->
            NCakeBlocks.BROWN_CANDLE_NCAKE);
    public static final RegistryObject<Block> GREEN_CANDLE_NCAKE = BLOCKS.register("green_candle_ncake", () ->
            NCakeBlocks.GREEN_CANDLE_NCAKE);
    public static final RegistryObject<Block> RED_CANDLE_NCAKE = BLOCKS.register("red_candle_ncake", () ->
            NCakeBlocks.RED_CANDLE_NCAKE);
    public static final RegistryObject<Block> BLACK_CANDLE_NCAKE = BLOCKS.register("black_candle_ncake", () ->
            NCakeBlocks.BLACK_CANDLE_NCAKE);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final RegistryObject<Item> NCAKE_ITEM = ITEMS.register("ncake", () ->
            NCakeBlocks.NCAKE_ITEM);

}
