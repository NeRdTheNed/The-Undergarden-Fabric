package quek.undergarden.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import quek.undergarden.registry.UGBlocks;
import quek.undergarden.registry.UGItems;

import java.util.Random;

public class UGStemBlock extends StemBlock implements Fertilizable {

    public UGStemBlock(GourdBlock gourdBlock, Settings settings) {
        super(gourdBlock, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(UGBlocks.deepsoil_farmland);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(UGItems.gloomgourd_seeds);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float f = getAvailableMoisture(this, world, pos);
        if (random.nextInt((int) (25.0F / f) + 1) == 0) {
            int i = state.get(AGE);
            if (i < 7) {
                state = state.with(AGE, i + 1);
                world.setBlockState(pos, state, 2);
            } else {
                Direction direction = Direction.Type.HORIZONTAL.random(random);
                BlockPos blockPos = pos.offset(direction);
                BlockState blockState = world.getBlockState(blockPos.down());
                if (world.getBlockState(blockPos).isAir() && (blockState.isOf(UGBlocks.deepsoil_farmland) || blockState.isOf(UGBlocks.deepturf_block) || blockState.isOf(UGBlocks.deepsoil) || blockState.isOf(UGBlocks.coarse_deepsoil))) {
                    world.setBlockState(blockPos, UGBlocks.gloomgourd.getDefaultState());
                    world.setBlockState(pos, UGBlocks.gloomgourd.getAttachedStem().getDefaultState().with(HorizontalFacingBlock.FACING, direction));
                }
            }
        }
    }

    protected static float getAvailableMoisture(Block block, BlockView world, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockPos = pos.down();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float g = 0.0F;
                BlockState blockState = world.getBlockState(blockPos.add(i, 0, j));
                if (blockState.isOf(UGBlocks.deepsoil_farmland)) {
                    g = 1.0F;
                    if (blockState.get(UGFarmlandBlock.MOISTURE) > 0) {
                        g = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    g /= 4.0F;
                }

                f += g;
            }
        }

        BlockPos blockPos2 = pos.north();
        BlockPos blockPos3 = pos.south();
        BlockPos blockPos4 = pos.west();
        BlockPos blockPos5 = pos.east();
        boolean bl = block == world.getBlockState(blockPos4).getBlock() || block == world.getBlockState(blockPos5).getBlock();
        boolean bl2 = block == world.getBlockState(blockPos2).getBlock() || block == world.getBlockState(blockPos3).getBlock();
        if (bl && bl2) {
            f /= 2.0F;
        } else {
            boolean bl3 = block == world.getBlockState(blockPos4.north()).getBlock() || block == world.getBlockState(blockPos5.north()).getBlock() || block == world.getBlockState(blockPos5.south()).getBlock() || block == world.getBlockState(blockPos4.south()).getBlock();
            if (bl3) {
                f /= 2.0F;
            }
        }

        return f;
    }
}
