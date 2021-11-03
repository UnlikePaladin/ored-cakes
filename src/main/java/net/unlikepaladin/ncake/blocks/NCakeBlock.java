package net.unlikepaladin.ncake.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;


import java.util.Random;

public class NCakeBlock extends CakeBlock {
    public static final IntegerProperty BITES = BlockStateProperties.BITES;
    protected static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)};

    public NCakeBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, Integer.valueOf(0)));
    }



    public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand p_225533_5_, BlockRayTraceResult rayTraceResult) {
        if (world.isClientSide) {
            ItemStack itemstack = player.getItemInHand(p_225533_5_);
            if (this.eat(world, blockPos, state, player).consumesAction()) {
                return ActionResultType.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }

        return this.eat(world, blockPos, state, player);
    }


    protected static ActionResultType eat(IWorld world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(2, 0.1F);
            int i = (Integer)state.getValue(BITES);
            Random rand = new Random();
            if(!world.isClientSide()) {
                player.addEffect(new EffectInstance(Effect.byId(rand.nextInt(31) + 1), 200, 0));
            }
            if (i < 6) {
                world.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                world.removeBlock(pos, false);
            }

            return ActionResultType.SUCCESS;
        }
    }
}
