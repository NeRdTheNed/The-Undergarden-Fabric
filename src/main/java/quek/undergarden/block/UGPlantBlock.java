package quek.undergarden.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import quek.undergarden.registry.UGBlocks;

public class UGPlantBlock extends PlantBlock {

    protected UGPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(UGBlocks.deepturf_block) || floor.isOf(UGBlocks.deepsoil) || floor.isOf(UGBlocks.coarse_deepsoil);
    }
}
