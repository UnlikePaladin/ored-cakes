package com.unlikepaladin.ncake.quilt;

import com.unlikepaladin.ncake.NCakeMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import static com.unlikepaladin.ncake.NCakeBlocks.*;

public class NCakeModQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        NCakeMod.init();
        Registry.register(Registry.BLOCK, new ResourceLocation(NCakeMod.MOD_ID, "ncake"), NCAKE);
        Registry.register(Registry.ITEM, new ResourceLocation(NCakeMod.MOD_ID, "ncake"), NCAKE_ITEM);
        String name = "ncake";

        registerBlock("candle_" + name, CANDLE_NCAKE);
        registerBlock("white_candle_" + name, WHITE_CANDLE_NCAKE);
        registerBlock("orange_candle_" + name, ORANGE_CANDLE_NCAKE);
        registerBlock("magenta_candle_" + name, MAGENTA_CANDLE_NCAKE);
        registerBlock("light_blue_candle_" + name, LIGHT_BLUE_CANDLE_NCAKE);
        registerBlock("yellow_candle_" + name, YELLOW_CANDLE_NCAKE);
        registerBlock("lime_candle_" + name, LIME_CANDLE_NCAKE);
        registerBlock("pink_candle_" + name, PINK_CANDLE_NCAKE);
        registerBlock("gray_candle_" + name, GRAY_CANDLE_NCAKE);
        registerBlock("light_gray_candle_" + name, LIGHT_GRAY_CANDLE_NCAKE);
        registerBlock("cyan_candle_" + name, CYAN_CANDLE_NCAKE);
        registerBlock("purple_candle_" + name, PURPLE_CANDLE_NCAKE);
        registerBlock("blue_candle_" + name, BLUE_CANDLE_NCAKE);
        registerBlock("brown_candle_" + name, BROWN_CANDLE_NCAKE);
        registerBlock("green_candle_" + name, GREEN_CANDLE_NCAKE);
        registerBlock("red_candle_" + name, RED_CANDLE_NCAKE);
        registerBlock("black_candle_" + name, BLACK_CANDLE_NCAKE);
    }

    private static void registerBlock(String name, Block block) {
        ResourceLocation id = new ResourceLocation(NCakeMod.MOD_ID, name);
        Registry.register(Registry.BLOCK, id, block);
    }
}

