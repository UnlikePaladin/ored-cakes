package com.unlikepaladin.oredcakes.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CoalCakeBlock extends AbstractOreCakeBlock{
    public CoalCakeBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void oreCakeInteraction(LevelAccessor world, Player player, BlockPos pos) {
        player.getFoodData().eat(4, 1.2f);
        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1));
        player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0));
    }
}
