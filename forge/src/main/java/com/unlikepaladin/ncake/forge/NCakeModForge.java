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

        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            // register a new item here
            itemRegistryEvent.getRegistry().register(NCAKE_ITEM.setRegistryName(MOD_ID, "ncake"));
        }
    }
}
