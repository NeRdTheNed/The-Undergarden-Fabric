package quek.undergarden.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FungusBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;
import quek.undergarden.registry.UGBlocks;

import java.util.function.Supplier;

public class GrongletBlock extends FungusBlock {

    public GrongletBlock(Settings settings, Supplier<ConfiguredFeature<HugeFungusFeatureConfig, ?>> supplier) {
        super(settings, supplier);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(UGBlocks.deepturf_block) || floor.isOf(UGBlocks.deepsoil) || floor.isOf(UGBlocks.coarse_deepsoil);
    }
}
