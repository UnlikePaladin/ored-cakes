package com.unlikepaladin.oredcakes.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DiamondCakeBlock extends AbstractOreCakeBlock{
    public DiamondCakeBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void oreCakeInteraction(LevelAccessor world, Player player, BlockPos pos) {
        player.getFoodData().eat(3, 0.2F);
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 2));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 5));
    }
}
