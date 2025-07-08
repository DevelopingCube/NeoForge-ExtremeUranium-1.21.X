package net.qublocker.ExtremeUranium;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.qublocker.ExtremeUranium.block.ModBlocks;

public class ClientModEvents {
    public static void onCientSetup(FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.URANIUM_CRYSTAL.get(), RenderType.cutout());
    }
}
