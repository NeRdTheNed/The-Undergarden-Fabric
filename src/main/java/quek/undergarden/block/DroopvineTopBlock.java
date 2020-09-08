package quek.undergarden.block;

import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineLogic;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShapes;
import quek.undergarden.registry.UGBlocks;

import java.util.Random;

public class DroopvineTopBlock extends AbstractPlantStemBlock {

    public DroopvineTopBlock(Settings settings) {
        super(settings, Direction.DOWN, VoxelShapes.fullCube(), false, 0.1D);
    }

    @Override
    protected int method_26376(Random random) {
        return VineLogic.method_26381(random);
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return VineLogic.isValidForWeepingStem(state);
    }

    @Override
    protected Block getPlant() {
        return UGBlocks.droopvine;
    }
}
