package com.unlikepaladin.ncake.fabric;

import com.unlikepaladin.ncake.NCakeMod;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import static com.unlikepaladin.ncake.NCakeBlocks.*;

public class NCakeModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        NCakeMod.init();
        Registry.register(Registry.BLOCK, new ResourceLocation(NCakeMod.MOD_ID, "ncake"), NCAKE);
        Registry.register(Registry.ITEM, new ResourceLocation(NCakeMod.MOD_ID, "ncake"), NCAKE_ITEM);
    }

    private static void registerBlock(String name, Block block) {
        ResourceLocation id = new ResourceLocation(NCakeMod.MOD_ID, name);
        Registry.register(Registry.BLOCK, id, block);
    }
}

