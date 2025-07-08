package net.qublocker.ExtremeUranium.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.qublocker.ExtremeUranium.ExtremeUranium;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> creativeTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ExtremeUranium.MODID, name));
        }
    }


    private boolean isValidItem(ItemStack item) {
        return item.is(Items.TRANSFORMABLE_ITEMS);
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ExtremeUranium.MODID, name));
        }
    }
}
