package com.unlikepaladin.oredcakes.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Objects;
import java.util.Random;

public class NetheriteCakeBlock extends AbstractOreCakeBlock {

    public NetheriteCakeBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Override
    public void oreCakeInteraction(LevelAccessor world, Player player, BlockPos pos) {
        player.getFoodData().eat(4, 0.3F);
        Random rand = new Random();
        if(!world.isClientSide()) {
            player.addEffect(new MobEffectInstance(Objects.requireNonNull(MobEffect.byId(rand.nextInt(31) + 1)), 200, 0));
        }
    }

}
