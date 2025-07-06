package net.qublocker.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qublocker.ExtremeUranium.ExtremeUranium;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ExtremeUranium.MODID);

    public static final DeferredItem<Item> URANIUM = ITEMS.register("uranium",
            () -> new Item(new Item.Properties()));

    public  static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
