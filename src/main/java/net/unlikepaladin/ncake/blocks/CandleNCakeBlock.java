package net.unlikepaladin.ncake.blocks;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.unlikepaladin.ncake.NCakeMod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class CandleNCakeBlock extends AbstractCandleBlock {
    private static final Map<CandleBlock, CandleNCakeBlock> CANDLES_TO_CANDLE_CAKES;
    private static final Iterable<Vec3d> PARTICLE_OFFSETS = ImmutableList.of(new Vec3d(0.5D, 1.0D, 0.5D));
    private final NCakeBlock cake;
    public static final BooleanProperty LIT = AbstractCandleBlock.LIT;
    protected static final VoxelShape CAKE_SHAPE;
    protected static final VoxelShape CANDLE_SHAPE;
    protected static final VoxelShape SHAPE;

    public CandleNCakeBlock(Block candle, NCakeBlock cake, Settings settings) {
        super(settings);
        this.cake = cake;
        CANDLES_TO_CANDLE_CAKES.put((CandleBlock) candle, this);
        this.setDefaultState((this.stateManager.getDefaultState()).with(LIT, false));

    }

    public static BlockState getCandleCakeFromCandle(Block candle) {
        return ((CandleNCakeBlock)CANDLES_TO_CANDLE_CAKES.get(candle)).getDefaultState();
    }
    public static void extinguish(@Nullable PlayerEntity player, @NotNull BlockState state, World world, BlockPos pos) {
        if (!state.get(LIT)) {
            dropStacks(state, world, pos);
            world.setBlockState(pos, NCakeMod.NCAKE.getDefaultState());
        } else {
            AbstractCandleBlock.extinguish(player, state, world, pos);
        }
    }
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.isOf(Items.FLINT_AND_STEEL) && !itemStack.isOf(Items.FIRE_CHARGE)) {
            if (isHittingCandle(hit) && player.getStackInHand(hand).isEmpty()) {
                extinguish(player, state, world, pos);
                return ActionResult.success(world.isClient);
            } else {
                dropStacks(state, world, pos);
                return NCakeBlock.tryEat(world, pos, NCakeMod.NCAKE.getDefaultState(), player);
            }
        } else {
            return ActionResult.PASS;
        }
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }


    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).getMaterial().isSolid();
    }
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return CakeBlock.DEFAULT_COMPARATOR_OUTPUT;
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(NCakeMod.NCAKE);
    }

    protected static boolean isHittingCandle(BlockHitResult hitResult) {
        return hitResult.getPos().y - (double)hitResult.getBlockPos().getY() > 0.5D;
    }

static {
    CAKE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
    CANDLE_SHAPE = Block.createCuboidShape(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    SHAPE = VoxelShapes.union(CAKE_SHAPE, CANDLE_SHAPE);
    CANDLES_TO_CANDLE_CAKES = Maps.newHashMap();
    }
}
