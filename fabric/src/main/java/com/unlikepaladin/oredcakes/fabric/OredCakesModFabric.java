package com.unlikepaladin.oredcakes.fabric;

import ca.weblite.objc.Runtime;
import com.unlikepaladin.oredcakes.OredCakesBlocks;
import com.unlikepaladin.oredcakes.OredCakesMod;
import com.unlikepaladin.oredcakes.blocks.AbstractOreCakeBlock;
import com.unlikepaladin.oredcakes.blocks.CandleOreCakeBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;

import static com.unlikepaladin.oredcakes.OredCakesBlocks.*;

public class OredCakesModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        OredCakesMod.init();
        Registry.register(Registry.BLOCK, new ResourceLocation(OredCakesMod.MOD_ID, "netherite_cake"), NETHERITE_CAKE);
        Registry.register(Registry.BLOCK, new ResourceLocation(OredCakesMod.MOD_ID, "diamond_cake"), DIAMOND_CAKE);
        Registry.register(Registry.BLOCK, new ResourceLocation(OredCakesMod.MOD_ID, "gold_cake"), GOLD_CAKE);
        Registry.register(Registry.BLOCK, new ResourceLocation(OredCakesMod.MOD_ID, "emerald_cake"), EMERALD_CAKE);
        Registry.register(Registry.BLOCK, new ResourceLocation(OredCakesMod.MOD_ID, "lapis_cake"), LAPIS_CAKE);
        Registry.register(Registry.BLOCK, new ResourceLocation(OredCakesMod.MOD_ID, "iron_cake"), IRON_CAKE);
        Registry.register(Registry.BLOCK, new ResourceLocation(OredCakesMod.MOD_ID, "redstone_cake"), REDSTONE_CAKE);
        Registry.register(Registry.BLOCK, new ResourceLocation(OredCakesMod.MOD_ID, "coal_cake"), COAL_CAKE);

        Registry.register(Registry.ITEM, new ResourceLocation(OredCakesMod.MOD_ID, "netherite_cake"), NETHERITE_CAKE_ITEM);
        Registry.register(Registry.ITEM, new ResourceLocation(OredCakesMod.MOD_ID, "diamond_cake"), DIAMOND_CAKE_ITEM);
        Registry.register(Registry.ITEM, new ResourceLocation(OredCakesMod.MOD_ID, "gold_cake"), GOLD_CAKE_ITEM);
        Registry.register(Registry.ITEM, new ResourceLocation(OredCakesMod.MOD_ID, "emerald_cake"), EMERALD_CAKE_ITEM);
        Registry.register(Registry.ITEM, new ResourceLocation(OredCakesMod.MOD_ID, "lapis_cake"), LAPIS_CAKE_ITEM);
        Registry.register(Registry.ITEM, new ResourceLocation(OredCakesMod.MOD_ID, "iron_cake"), IRON_CAKE_ITEM);
        Registry.register(Registry.ITEM, new ResourceLocation(OredCakesMod.MOD_ID, "redstone_cake"), REDSTONE_CAKE_ITEM);
        Registry.register(Registry.ITEM, new ResourceLocation(OredCakesMod.MOD_ID, "coal_cake"), COAL_CAKE_ITEM);
        FuelRegistry.INSTANCE.add(COAL_CAKE_ITEM, 1600);

        for (Block candle : candles) {
            for (AbstractOreCakeBlock oreCakeBlock : cakes) {
                CandleOreCakeBlock candleOreCakeBlock = new CandleOreCakeBlock(candle, oreCakeBlock, BlockBehaviour.Properties.copy(oreCakeBlock).lightLevel(createLightLevelFromLitBlockState(3)));
                Registry.register(Registry.BLOCK, new ResourceLocation(OredCakesMod.MOD_ID, Registry.BLOCK.getKey(candle).getPath()+"_"+Registry.BLOCK.getKey(oreCakeBlock).getPath()), candleOreCakeBlock);
            }
        }
    }
}

