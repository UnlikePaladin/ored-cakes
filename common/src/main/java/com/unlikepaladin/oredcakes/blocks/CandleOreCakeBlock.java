package com.unlikepaladin.oredcakes.blocks;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import net.minecraft.tags.BlockTags;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class CandleOreCakeBlock extends AbstractCandleBlock {
    private static final Iterable<Vec3> PARTICLE_OFFSETS = ImmutableList.of(new Vec3(0.5D, 1.0D, 0.5D));
    private final AbstractOreCakeBlock cake;
    public static Map<AbstractOreCakeBlock, Map<Block, CandleOreCakeBlock>> CAKE_TO_CANDLE_CAKE = new HashMap<>();

    public static final BooleanProperty LIT = AbstractCandleBlock.LIT;
    protected static final VoxelShape CAKE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
    protected static final VoxelShape CANDLE_SHAPE = Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    protected static final VoxelShape SHAPE = Shapes.or(CAKE_SHAPE, CANDLE_SHAPE);

    public CandleOreCakeBlock(Block candle, AbstractOreCakeBlock cake, BlockBehaviour.Properties settings) {
        super(settings);
        this.cake = cake;
        if (!CAKE_TO_CANDLE_CAKE.containsKey(cake)) {
            CAKE_TO_CANDLE_CAKE.put(cake, new HashMap<>());
        }
        CAKE_TO_CANDLE_CAKE.get(cake).put(candle, this);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false));
    }

    public static BlockState byCandle(AbstractOreCakeBlock candleOreCakeBlock, Block candle) {
        return CAKE_TO_CANDLE_CAKE.get(candleOreCakeBlock).get(candle).defaultBlockState();
    }

    public void extinguish(@Nullable Player player, BlockState state, Level world, BlockPos pos) {
        if (!state.getValue(LIT)) {
            dropResources(state, world, pos);
            world.setBlockAndUpdate(pos, cake.defaultBlockState());
        } else {
            AbstractCandleBlock.extinguish(player, state, world, pos);
        }
    }

    protected Iterable<Vec3> getParticleOffsets(BlockState p_152868_) {
        return PARTICLE_OFFSETS;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (!itemStack.is(Items.FLINT_AND_STEEL) && !itemStack.is(Items.FIRE_CHARGE)) {
            if (candleHit(hit) && player.getItemInHand(hand).isEmpty()) {
                extinguish(player, state, world, pos);
                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                dropResources(state, world, pos);
                return cake.eat(world, pos, cake.defaultBlockState(), player);
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }


    private static boolean candleHit(BlockHitResult hitResult) {
        return hitResult.getLocation().y - (double) hitResult.getBlockPos().getY() > 0.5D;
    }


    public ItemStack getCloneItemStack(BlockGetter p_152862_, BlockPos p_152863_, BlockState p_152864_) {
        return new ItemStack(cake);
    }

    public BlockState updateShape(BlockState p_152898_, Direction p_152899_, BlockState p_152900_, LevelAccessor p_152901_, BlockPos p_152902_, BlockPos p_152903_) {
        return p_152899_ == Direction.DOWN && !p_152898_.canSurvive(p_152901_, p_152902_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_152898_, p_152899_, p_152900_, p_152901_, p_152902_, p_152903_);
    }

    public boolean canSurvive(BlockState p_152891_, LevelReader p_152892_, BlockPos p_152893_) {
        return p_152892_.getBlockState(p_152893_.below()).getMaterial().isSolid();
    }

    public int getAnalogOutputSignal(BlockState p_152880_, Level p_152881_, BlockPos p_152882_) {
        return CakeBlock.FULL_CAKE_SIGNAL;
    }

    public boolean hasAnalogOutputSignal(BlockState p_152909_) {
        return true;
    }

    public boolean isPathfindable(BlockState p_152870_, BlockGetter p_152871_, BlockPos p_152872_, PathComputationType p_152873_) {
        return false;
    }

    @Override
    public boolean isSignalSource(BlockState blockState) {
        return cake.isSignalSource(blockState);
    }

    @Override
    public int getSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return cake.getSignal(blockState, blockGetter, blockPos, direction);
    }

    public static boolean canLight(BlockState state) {
        return state.is(BlockTags.CANDLE_CAKES, (p_152896_) -> {
            return state.hasProperty(LIT) && !state.getValue(LIT);
        });
    }
}