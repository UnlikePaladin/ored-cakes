package com.unlikepaladin.oredcakes.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class IronCakeBlock extends AbstractOreCakeBlock{
    public IronCakeBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void oreCakeInteraction(LevelAccessor world, Player player, BlockPos pos) {
        player.getFoodData().eat(1, 0.5f);
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3000, 1));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 1));
    }
}
