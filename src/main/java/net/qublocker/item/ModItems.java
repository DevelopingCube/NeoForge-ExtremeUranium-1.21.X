package net.qublocker.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qublocker.ExtremeUranium.ExtremeUranium;

import java.util.List;

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
           ()-> new Item(new Item.Properties().food(ModFoodProperties.DECAYED_FISH)){
               @Override
               public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                   tooltipComponents.add(Component.translatable("toolip.extremeuranium.decayed_cod"));

                   super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
               }
           });

    public  static final DeferredItem<Item> DECAYED_SALMON = ITEMS.register("decayed_salmon",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.DECAYED_FISH)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("toolip.extremeuranium.decayed_salmon"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public  static final DeferredItem<Item> DECAYED_PUFFERFISH = ITEMS.register("decayed_pufferfish",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.DECAYED_FISH)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("toolip.extremeuranium.decayed_pufferfish"));

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public  static final DeferredItem<Item> DECAYED_TROPICAL_FISH = ITEMS.register("decayed_tropical_fish",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.DECAYED_FISH)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("toolip.extremeuranium.decayed_tropical_fish"));

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public  static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
