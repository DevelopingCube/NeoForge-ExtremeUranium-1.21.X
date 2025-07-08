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

   public static final DeferredItem<Item> URANIUM_BLOB = ITEMS.register("uranium_blob",
           ()-> new Item(new Item.Properties()));

   public static final DeferredItem<Item> RAW_URANIUM = ITEMS.register("raw_uranium",
           ()-> new Item(new Item.Properties()));

   public  static final DeferredItem<Item> DECAYED_COD = ITEMS.register("decayed_cod",
           ()-> new Item(new Item.Properties().food(ModFoodProperties.DECAYED_COD)));

    public  static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
