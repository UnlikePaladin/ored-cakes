package com.unlikepaladin.oredcakes.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class LapisCakeBlock extends AbstractOreCakeBlock{
    public LapisCakeBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void oreCakeInteraction(LevelAccessor world, Player player, BlockPos pos) {
        player.getFoodData().eat(2, 0.8f);
        if (world.isClientSide())
            return;

        Random rand = new Random();
        if(rand.nextInt() % 2 == 0) {
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 3000, 1));
            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 80, 1));
        }
        else {
            player.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 2000, 1));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 1));
        }
    }
}
