package net.unlikepaladin.ncake.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Random;

public class NCakeBlock extends CakeBlock {

    public NCakeBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(BITES, 0));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (this.tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return this.tryEat(world, pos, state, player);
    }

    private ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(2, 0.1F);
            if(!world.isClient()) {
                Random rand = new Random();
                player.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(rand.nextInt(31) + 1), 100, 0));
            }
            int i = (Integer) state.get(BITES);
            if (i < 6) {
                world.setBlockState(pos, (BlockState) state.with(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }

            return ActionResult.SUCCESS;
        }
    }
}
