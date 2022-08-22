package com.unlikepaladin.ncake.forge;

import com.unlikepaladin.ncake.NCakeMod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.unlikepaladin.ncake.NCakeBlocks.*;
import static com.unlikepaladin.ncake.NCakeMod.*;

@Mod(NCakeMod.MOD_ID)
public class NCakeModForge {
    public NCakeModForge() {
        NCakeMod.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            String name = "ncake";
            blockRegistryEvent.getRegistry().register(NCAKE.setRegistryName(MOD_ID, name));

            blockRegistryEvent.getRegistry().register(CANDLE_NCAKE.setRegistryName(MOD_ID, "candle_" + name));
            blockRegistryEvent.getRegistry().register(WHITE_CANDLE_NCAKE.setRegistryName(MOD_ID, "white_candle_" + name));
            blockRegistryEvent.getRegistry().register(ORANGE_CANDLE_NCAKE.setRegistryName(MOD_ID, "orange_candle_" + name));
            blockRegistryEvent.getRegistry().register(MAGENTA_CANDLE_NCAKE.setRegistryName(MOD_ID, "magenta_candle_" + name));
            blockRegistryEvent.getRegistry().register(LIGHT_BLUE_CANDLE_NCAKE.setRegistryName(MOD_ID, "light_blue_candle_" + name));
            blockRegistryEvent.getRegistry().register(LIME_CANDLE_NCAKE.setRegistryName(MOD_ID, "lime_candle_" + name));
            blockRegistryEvent.getRegistry().register(YELLOW_CANDLE_NCAKE.setRegistryName(MOD_ID, "yellow_candle_" + name));
            blockRegistryEvent.getRegistry().register(PINK_CANDLE_NCAKE.setRegistryName(MOD_ID, "pink_candle_" + name));
            blockRegistryEvent.getRegistry().register(GRAY_CANDLE_NCAKE.setRegistryName(MOD_ID, "gray_candle_" + name));
            blockRegistryEvent.getRegistry().register(LIGHT_GRAY_CANDLE_NCAKE.setRegistryName(MOD_ID, "light_gray_candle_" + name));
            blockRegistryEvent.getRegistry().register(CYAN_CANDLE_NCAKE.setRegistryName(MOD_ID, "cyan_candle_" + name));
            blockRegistryEvent.getRegistry().register(PURPLE_CANDLE_NCAKE.setRegistryName(MOD_ID, "purple_candle_" + name));
            blockRegistryEvent.getRegistry().register(BLUE_CANDLE_NCAKE.setRegistryName(MOD_ID, "blue_candle_" + name));
            blockRegistryEvent.getRegistry().register(BROWN_CANDLE_NCAKE.setRegistryName(MOD_ID, "brown_candle_" + name));
            blockRegistryEvent.getRegistry().register(GREEN_CANDLE_NCAKE.setRegistryName(MOD_ID, "green_candle_" + name));
            blockRegistryEvent.getRegistry().register(RED_CANDLE_NCAKE.setRegistryName(MOD_ID, "red_candle_" + name));
            blockRegistryEvent.getRegistry().register(BLACK_CANDLE_NCAKE.setRegistryName(MOD_ID, "black_candle_" + name));

        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            // register a new item here
            itemRegistryEvent.getRegistry().register(NCAKE_ITEM.setRegistryName(MOD_ID, "ncake"));
        }
    }
}
