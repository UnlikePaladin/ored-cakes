package com.unlikepaladin.oredcakes.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class RedstoneCakeBlock extends AbstractOreCakeBlock{
    public RedstoneCakeBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void oreCakeInteraction(LevelAccessor world, Player player, BlockPos pos) {
        player.getFoodData().eat(1, 0.5f);
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 2));
        player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 3000, 1));
    }

    @Override
    public boolean isSignalSource(BlockState blockState) {
        return true;
    }

    @Override
    public int getSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return 15;
    }
}
