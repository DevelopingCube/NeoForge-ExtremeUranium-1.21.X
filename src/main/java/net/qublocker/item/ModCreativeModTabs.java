package net.qublocker.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qublocker.ExtremeUranium.ExtremeUranium;
import net.qublocker.ExtremeUranium.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExtremeUranium.MODID);

    public static final Supplier<CreativeModeTab> EXTREME_URANIUM_TAB = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("extremeuranium_tab",
            ()-> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.URANIUM.get()))
                    .title(Component.translatable("creativetab.extremeuranium"))
                    .displayItems((parameters, output) -> {
                      output.accept(ModItems.URANIUM);
                      output.accept(ModItems.URANIUM_BLOB);
                      output.accept(ModItems.RAW_URANIUM);
                      output.accept(ModBlocks.URANIUM_BLOCK);
                      output.accept(ModBlocks.COBBLED_RADROCK);
                      output.accept(ModItems.DECAYED_COD);
                      output.accept(ModBlocks.URANIUM_ORE);
                      output.accept(ModBlocks.URANIUM_CRYSTAL);
                      output.accept(ModBlocks.WITHERED_GRASS_BLOCK);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(eventBus);
    }
}
