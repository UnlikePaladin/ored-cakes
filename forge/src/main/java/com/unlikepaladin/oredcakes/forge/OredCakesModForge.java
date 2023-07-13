package com.unlikepaladin.oredcakes.forge;

import com.unlikepaladin.oredcakes.OredCakesMod;

import com.unlikepaladin.oredcakes.blocks.AbstractOreCakeBlock;
import com.unlikepaladin.oredcakes.blocks.CandleOreCakeBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;

import static com.unlikepaladin.oredcakes.OredCakesBlocks.*;
import static com.unlikepaladin.oredcakes.OredCakesMod.*;

@Mod(OredCakesMod.MOD_ID)
public class OredCakesModForge {
    public OredCakesModForge() {
        OredCakesMod.init();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(NCakeCompatibility.class);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            blockRegistryEvent.getRegistry().register(NETHERITE_CAKE.setRegistryName(MOD_ID, "netherite_cake"));
            blockRegistryEvent.getRegistry().register(DIAMOND_CAKE.setRegistryName(MOD_ID, "diamond_cake"));
            blockRegistryEvent.getRegistry().register(GOLD_CAKE.setRegistryName(MOD_ID, "gold_cake"));
            blockRegistryEvent.getRegistry().register(EMERALD_CAKE.setRegistryName(MOD_ID, "emerald_cake"));
            blockRegistryEvent.getRegistry().register(LAPIS_CAKE.setRegistryName(MOD_ID, "lapis_cake"));
            blockRegistryEvent.getRegistry().register(IRON_CAKE.setRegistryName(MOD_ID, "iron_cake"));
            blockRegistryEvent.getRegistry().register(REDSTONE_CAKE.setRegistryName(MOD_ID, "redstone_cake"));
            blockRegistryEvent.getRegistry().register(COAL_CAKE.setRegistryName(MOD_ID, "coal_cake"));
            for (Block candle : candles) {
                for (AbstractOreCakeBlock oreCakeBlock : cakes) {
                    CandleOreCakeBlock candleOreCakeBlock = new CandleOreCakeBlock(candle, oreCakeBlock, BlockBehaviour.Properties.copy(oreCakeBlock).lightLevel(createLightLevelFromLitBlockState(3)));
                    blockRegistryEvent.getRegistry().register(candleOreCakeBlock.setRegistryName(ForgeRegistries.BLOCKS.getKey(candle).getPath()+"_"+ForgeRegistries.BLOCKS.getKey(oreCakeBlock).getPath()));
                }
            }
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            itemRegistryEvent.getRegistry().register(NETHERITE_CAKE_ITEM.setRegistryName(MOD_ID, "netherite_cake"));
            itemRegistryEvent.getRegistry().register(DIAMOND_CAKE_ITEM.setRegistryName(MOD_ID, "diamond_cake"));
            itemRegistryEvent.getRegistry().register(GOLD_CAKE_ITEM.setRegistryName(MOD_ID, "gold_cake"));
            itemRegistryEvent.getRegistry().register(EMERALD_CAKE_ITEM.setRegistryName(MOD_ID, "emerald_cake"));
            itemRegistryEvent.getRegistry().register(LAPIS_CAKE_ITEM.setRegistryName(MOD_ID, "lapis_cake"));
            itemRegistryEvent.getRegistry().register(IRON_CAKE_ITEM.setRegistryName(MOD_ID, "iron_cake"));
            itemRegistryEvent.getRegistry().register(REDSTONE_CAKE_ITEM.setRegistryName(MOD_ID, "redstone_cake"));
            itemRegistryEvent.getRegistry().register(COAL_CAKE_ITEM.setRegistryName(MOD_ID, "coal_cake"));
        }
    }

    @Mod.EventBusSubscriber(modid ="oredcakes")
    public static class NCakeCompatibility {
        @SubscribeEvent
        public static void onMissingBlock(final RegistryEvent.MissingMappings<Block> missingMappings) {
            missingMappings.getMappings("ncake").forEach(blockMapping -> {
                switch (blockMapping.key.getPath()) {
                    case "ncake": {
                        blockMapping.remap(NETHERITE_CAKE);
                        break;
                    }
                    default:
                        blockMapping.warn();
                        break;
                }
            });
        }

        @SubscribeEvent
        public static void onMissingItem(final RegistryEvent.MissingMappings<Item> missingMappings) {
            missingMappings.getMappings("ncake").forEach(itemMapping -> {
                switch (itemMapping.key.getPath()) {
                    case "ncake": {
                        itemMapping.remap(NETHERITE_CAKE_ITEM);
                        break;
                    }
                    default:
                        itemMapping.warn();
                        break;
                }
            });
        }
    }

}
