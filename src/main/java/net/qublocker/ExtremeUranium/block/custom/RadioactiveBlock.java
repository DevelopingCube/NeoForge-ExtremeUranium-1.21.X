package net.qublocker.ExtremeUranium.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.qublocker.item.ModItems;

import java.util.Set;

public class RadioactiveBlock extends Block {
    public RadioactiveBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1f, 1f);

        return super.useWithoutItem(state, level, pos, player, hitResult);
    }


    @Override

    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        Set<EntityType<?>> harmableTypes = Set.of(
                EntityType.PIG,
                EntityType.PLAYER,
                EntityType.HORSE,
                EntityType.COW,
                EntityType.SHEEP,
                EntityType.CHICKEN,
                EntityType.VILLAGER,
                EntityType.BEE

        );

        // To fix later. Should only damage every second like magma cubes, and do no damage to the player if they have hazmat boots on.

        if(!level.isClientSide && harmableTypes.contains(entity.getType()) && entity instanceof LivingEntity){
            System.out.println("Affecting " + entity.getType());
            ((LivingEntity) entity).addEffect(new MobEffectInstance(
                    MobEffects.WITHER,
                    1,
                    1,
                    true,
                    true,
                    true));

            ((LivingEntity) entity).addEffect(new MobEffectInstance(
                    MobEffects.HARM,
                    1,
                    1,
                    false,
                    false,
                    false));
        }




        super.stepOn(level, pos, state, entity);
    }
}
