package quek.undergarden.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import quek.undergarden.registry.UGBlocks;

import java.util.Random;

public class UGSaplingBlock extends SaplingBlock {

    public UGSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(UGBlocks.deepturf_block) || floor.isOf(UGBlocks.deepsoil) || floor.isOf(UGBlocks.coarse_deepsoil);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(7) == 0) {
            this.generate(world, pos, state, random);
        }

    }
}
