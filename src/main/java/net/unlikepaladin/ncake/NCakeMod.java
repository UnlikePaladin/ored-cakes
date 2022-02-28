package net.unlikepaladin.ncake;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.unlikepaladin.ncake.blocks.CandleNCakeBlock;
import net.unlikepaladin.ncake.blocks.NCakeBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.ToIntFunction;

public class NCakeMod implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("ncake");
    public static final String MOD_ID = "ncake";
    public static Block NCAKE;
    public static Block CANDLE_NCAKE;
    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> (Boolean)state.get(Properties.LIT) ? litLevel : 0;
    }

    private static void registerBlock(String name, Block block) {
        Identifier id = new Identifier(MOD_ID, name);
        Registry.register(Registry.BLOCK, id, block);
    }
    @Override
    public void onInitialize() {
        String name = "ncake";
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "ncake"), NCAKE = new NCakeBlock(AbstractBlock.Settings.of(Material.CAKE).resistance(1200.0f).hardness(50.0f).mapColor(MapColor.GRAY).nonOpaque().sounds(BlockSoundGroup.NETHERITE)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ncake"), new BlockItem(NCAKE, new FabricItemSettings().group(ItemGroup.FOOD).fireproof()));

        registerBlock("candle_" + name, CANDLE_NCAKE = new CandleNCakeBlock(Blocks.CANDLE, (NCakeBlock) NCAKE, AbstractBlock.Settings.copy(NCAKE).luminance(createLightLevelFromLitBlockState(3))));
        registerBlock("white_candle_" + name, new CandleNCakeBlock(Blocks.WHITE_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("orange_candle_" + name, new CandleNCakeBlock(Blocks.ORANGE_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("magenta_candle_" + name, new CandleNCakeBlock(Blocks.MAGENTA_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("light_blue_candle_" + name, new CandleNCakeBlock(Blocks.LIGHT_BLUE_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("yellow_candle_" + name, new CandleNCakeBlock(Blocks.YELLOW_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("lime_candle_" + name, new CandleNCakeBlock(Blocks.LIME_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("pink_candle_" + name, new CandleNCakeBlock(Blocks.PINK_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("gray_candle_" + name, new CandleNCakeBlock(Blocks.GRAY_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("light_gray_candle_" + name, new CandleNCakeBlock(Blocks.LIGHT_GRAY_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("cyan_candle_" + name, new CandleNCakeBlock(Blocks.CYAN_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("purple_candle_" + name, new CandleNCakeBlock(Blocks.PURPLE_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("blue_candle_" + name, new CandleNCakeBlock(Blocks.BLUE_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("brown_candle_" + name, new CandleNCakeBlock(Blocks.BROWN_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("green_candle_" + name, new CandleNCakeBlock(Blocks.GREEN_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("red_candle_" + name, new CandleNCakeBlock(Blocks.RED_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));
        registerBlock("black_candle_" + name, new CandleNCakeBlock(Blocks.BLACK_CANDLE, (NCakeBlock) NCAKE, FabricBlockSettings.copy(CANDLE_NCAKE)));

    }


}
