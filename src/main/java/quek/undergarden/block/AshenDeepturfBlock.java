package quek.undergarden.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import quek.undergarden.registry.UGBlocks;

public class AshenDeepturfBlock extends UGPlantBlock {

    public AshenDeepturfBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(UGBlocks.ashen_deepturf_block);
    }
}
