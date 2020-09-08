package quek.undergarden.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class DitchbulbBlock extends UGPlantBlock {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public DitchbulbBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double x = (double)pos.getX() + 0.5D;
        double y = (double)pos.getY() + 0.8D;
        double z = (double)pos.getZ() + 0.5D;
        world.addParticle(ParticleTypes.FLAME, x, y, z, 0.0D, 0.0D, 0.0D);
    }

}
