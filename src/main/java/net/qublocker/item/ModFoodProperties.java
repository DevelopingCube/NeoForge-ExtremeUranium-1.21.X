package net.qublocker.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties DECAYED_COD = new FoodProperties.Builder()
            .nutrition(-1)
            .saturationModifier(0f)
            .alwaysEdible()
            .fast()
            .effect(()-> new MobEffectInstance(MobEffects.HARM,1, 0),.5f)
            .effect(()-> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400), .5f)
            .build();
}
