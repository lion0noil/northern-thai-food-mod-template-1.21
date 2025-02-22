package net.lion.northernthaifoodmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f).build();
    public static final FoodComponent FOOD1 = new FoodComponent.Builder().nutrition(8).saturationModifier(0.4f).build();
    public static final FoodComponent FOOD2 = new FoodComponent.Builder().nutrition(9).saturationModifier(0.4f).build();
    public static final FoodComponent FOOD3 = new FoodComponent.Builder().nutrition(6).saturationModifier(0.3f).build();
    public static final FoodComponent FOOD4 = new FoodComponent.Builder().nutrition(7).saturationModifier(0.4f).build();
    public static final FoodComponent FOOD5 = new FoodComponent.Builder().nutrition(11).saturationModifier(0.4f).build();
}
