package com.unlikepaladin.oredcakes.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Objects;
import java.util.Random;

public abstract class AbstractOreCakeBlock extends CakeBlock {
        public AbstractOreCakeBlock(BlockBehaviour.Properties settings) {
            super(settings);
            this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
        }

        public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult hitResult) {
            ItemStack itemStack = player.getItemInHand(interactionHand);
            Item item = itemStack.getItem();
            if (itemStack.is(ItemTags.CANDLES) && state.getValue(BITES) == 0) {
                Block block = Block.byItem(item);
                if (block instanceof CandleBlock) {
                    if (!player.isCreative()) {
                        itemStack.shrink(1);
                    }

                    level.playSound(null, blockPos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(blockPos, CandleOreCakeBlock.byCandle(this, block));
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    return InteractionResult.SUCCESS;
                }
            }

            if (level.isClientSide) {
                if (eat(level, blockPos, state, player).consumesAction()) {
                    return InteractionResult.SUCCESS;
                }

                if (itemStack.isEmpty()) {
                    return InteractionResult.CONSUME;
                }
            }
            return eat(level, blockPos, state, player);
        }

        public static InteractionResult eat(LevelAccessor worldAccessor, BlockPos blockPos, BlockState state, Player player) {
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
