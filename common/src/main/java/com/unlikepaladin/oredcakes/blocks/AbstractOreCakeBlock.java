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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Objects;
import java.util.Random;

public abstract class AbstractOreCakeBlock extends CakeBlock {
        public AbstractOreCakeBlock(BlockBehaviour.Properties settings) {
            super(settings);
            this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
        }

        public InteractionResult use(BlockState state, Level world, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult hitResult) {
            ItemStack itemStack = player.getItemInHand(interactionHand);
            if (world.isClientSide) {
                if (eat(world, blockPos, state, player).consumesAction()) {
                    return InteractionResult.SUCCESS;
                }

                if (itemStack.isEmpty()) {
                    return InteractionResult.CONSUME;
                }
            }
            return eat(world, blockPos, state, player);
        }

        protected static InteractionResult eat(LevelAccessor worldAccessor, BlockPos blockPos, BlockState state, Player player) {
            if (!player.canEat(false)) {
                return InteractionResult.PASS;
            } else {
                player.awardStat(Stats.EAT_CAKE_SLICE);
                int biteNum = state.getValue(BITES);

                Block cakeBlock = state.getBlock();
                if (cakeBlock instanceof AbstractOreCakeBlock) {
                    ((AbstractOreCakeBlock)cakeBlock).oreCakeInteraction(worldAccessor, player, blockPos);
                }
                if (biteNum < 6) {
                    worldAccessor.setBlock(blockPos, state.setValue(BITES, biteNum + 1), 3);
                } else {
                    worldAccessor.removeBlock(blockPos, false);
                }

                return InteractionResult.SUCCESS;
            }
        }

        public abstract void oreCakeInteraction(LevelAccessor world, Player player, BlockPos pos);
}
