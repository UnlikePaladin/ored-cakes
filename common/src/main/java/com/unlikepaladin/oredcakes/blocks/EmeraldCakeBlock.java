package com.unlikepaladin.oredcakes.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class EmeraldCakeBlock extends AbstractOreCakeBlock{
    public EmeraldCakeBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void oreCakeInteraction(LevelAccessor world, Player player, BlockPos pos) {
        player.getFoodData().eat(2, 0.15F);
        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 3000, 1));
        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2000, 1));

    }
}
