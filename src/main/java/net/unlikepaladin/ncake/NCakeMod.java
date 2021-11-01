package net.unlikepaladin.ncake;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.unlikepaladin.ncake.blocks.NCakeBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.ToIntFunction;

public class NCakeMod implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("ncake");
    public static final String MOD_ID = "ncake";
    public static final Block NCAKE = new NCakeBlock(FabricBlockSettings.of(Material.CAKE).resistance(1200.0f).hardness(50.0f).nonOpaque().sounds(BlockSoundGroup.NETHERITE));

    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> {
            return (Boolean)state.get(Properties.LIT) ? litLevel : 0;
        };
    }

    private static void registerBlock(String name, Block block) {
        Identifier id = new Identifier(MOD_ID, name);
        Registry.register(Registry.BLOCK, id, block);
    }
    @Override
    public void onInitialize() {
        String name = "ncake";
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "ncake"), NCAKE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ncake"), new BlockItem(NCAKE, new FabricItemSettings().group(ItemGroup.FOOD)));

    }


}
