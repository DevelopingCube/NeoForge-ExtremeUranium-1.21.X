package net.qublocker.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SyringeItem extends Item {

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.extremeuranium.syringe.shiftdown"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.extremeuranium.syringe"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    private static final Map<Block, Block> URANIUM_MAP =
            Map.of(

            );

    public SyringeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        return super.useOn(pContext);
    }

    @Override

    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (!pPlayer.level().isClientSide) {
            Set<EntityType<?>> injectableTypes = Set.of(
                    EntityType.PIG,
                    EntityType.PLAYER,
                    EntityType.HORSE,
                    EntityType.COW,
                    EntityType.CHICKEN,
                    EntityType.VILLAGER,
                    EntityType.BEE,
                    EntityType.SALMON,
                    EntityType.COD,
                    EntityType.PUFFERFISH,
                    EntityType.TURTLE,
                    EntityType.DOLPHIN,
                    EntityType.TROPICAL_FISH,
                    EntityType.MULE
            );

            

        };

        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }
}
