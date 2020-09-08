package quek.undergarden.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class GooBlock extends Block {

    public static final IntProperty AGE = Properties.AGE_15;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

    public GooBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        //TODO: cloggrum boot and scintling immunity
        if(entity.isOnGround()) {
            entity.slowMovement(state, new Vec3d(0.45D, 0.45D, 0.45D));
        }

    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(!state.canPlaceAt(world, pos)) {
            world.removeBlock(pos, false);
        }
        if(random.nextFloat() < 100F + state.get(AGE) * 0.50F) {
            world.removeBlock(pos, false);
        }
    }



}
