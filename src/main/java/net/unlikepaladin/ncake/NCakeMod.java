package net.unlikepaladin.ncake;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;

import net.unlikepaladin.ncake.blocks.CandleNCakeBlock;
import net.unlikepaladin.ncake.blocks.NCakeBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("ncake")
public class NCakeMod {
    public static String MODID = "ncake";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public NCakeMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().;
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("ncake", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    private static String name = "_candle_ncake";
    public static Block NCAKE = new NCakeBlock(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.NETHERITE_BLOCK).noOcclusion().strength(50.0f, 1200.0f)).setRegistryName(MODID, "ncake");
    public static Block CANDLE_NCAKE = new CandleNCakeBlock(Blocks.CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "candle_ncake");
    public static Block WHITE_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.WHITE_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "white" + name);
    public static Block ORANGE_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.ORANGE_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "orange" + name);
    public static Block MAGENTA_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.MAGENTA_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "magenta" + name);
    public static Block LIGHT_BLUE_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.LIGHT_BLUE_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "light_blue" + name);
    public static Block YELLOW_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.YELLOW_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "yellow" + name);
    public static Block LIME_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.LIME_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "lime" + name);
    public static Block PINK_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.PINK_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "pink" + name);
    public static Block GRAY_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.GRAY_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "gray" + name);
    public static Block LIGHT_GRAY_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.LIGHT_GRAY_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "light_gray" + name);
    public static Block CYAN_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.CYAN_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "cyan" + name);
    public static Block PURPLE_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.PURPLE_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "purple" + name);
    public static Block BLUE_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.BLUE_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "blue" + name);
    public static Block BROWN_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.BROWN_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "brown" + name);
    public static Block GREEN_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.GREEN_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "green" + name);
    public static Block RED_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.RED_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "red" + name);
    public static Block BLACK_CANDLE_NCAKE = new CandleNCakeBlock(Blocks.BLACK_CANDLE, (NCakeBlock) NCAKE, BlockBehaviour.Properties.copy(NCAKE).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)).setRegistryName(MODID, "black" + name);

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            blockRegistryEvent.getRegistry().register(NCAKE);

            blockRegistryEvent.getRegistry().register(CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(WHITE_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(ORANGE_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(MAGENTA_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(LIGHT_BLUE_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(LIME_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(YELLOW_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(PINK_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(GRAY_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(LIGHT_GRAY_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(CYAN_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(PURPLE_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(BLUE_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(BROWN_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(GREEN_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(RED_CANDLE_NCAKE);
            blockRegistryEvent.getRegistry().register(BLACK_CANDLE_NCAKE);

        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            // register a new item here
            itemRegistryEvent.getRegistry().register(new BlockItem(NCAKE, new Item.Properties().tab(CreativeModeTab.TAB_FOOD)).setRegistryName(MODID, "ncake"));
        }
    }
}
