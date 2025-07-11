package net.qublocker.ExtremeUranium;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.qublocker.ExtremeUranium.block.ModBlocks;
import net.qublocker.item.ModCreativeModTabs;
import net.qublocker.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ExtremeUranium.MODID)
public class ExtremeUranium {
    public static final String MODID = "extremeuranium";
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public ExtremeUranium(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
       if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
           event.accept(ModItems.URANIUM);
           event.accept(ModItems.RAW_URANIUM);
           event.accept(ModItems.URANIUM_BLOB);

       }

       if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
           event.accept(ModItems.DECAYED_SALMON);
           event.accept(ModItems.DECAYED_PUFFERFISH);
           event.accept(ModItems.DECAYED_TROPICAL_FISH);
           event.accept(ModItems.DECAYED_COD);
       }

       if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
           event.accept(ModBlocks.URANIUM_BLOCK);
           event.accept(ModBlocks.URANIUM_CRYSTAL);
           event.accept(ModBlocks.URANIUM_ORE);
           event.accept(ModBlocks.WITHERED_GRASS_BLOCK);
           event.accept(ModBlocks.COBBLED_RADROCK);
       }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = ExtremeUranium.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    static class ClientModEvents {
        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
