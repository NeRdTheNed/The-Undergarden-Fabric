package quek.undergarden.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import quek.undergarden.registry.UGBlocks;

import java.util.Random;

public class SmogVentFeature extends Feature<DefaultFeatureConfig> {

    public SmogVentFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, DefaultFeatureConfig featureConfig) {
        while (world.isAir(blockPos) && blockPos.getY() > 2) {
            blockPos = blockPos.down();
        }

        if (world.isAir(blockPos.up()) && world.getBlockState(blockPos).getBlock() == UGBlocks.ashen_deepturf) {
            blockPos = blockPos.up(random.nextInt(4));
            int ventHeight = 7;
            int j = ventHeight / 4 + random.nextInt(2);

            for (int k = 0; k < ventHeight; ++k) {
                float f = (1.0F - (float) k / (float) ventHeight) * (float) j;
                int l = MathHelper.ceil(f);

                for (int i1 = -l; i1 <= l; ++i1) {
                    float f1 = (float) MathHelper.abs(i1) - 0.25F;

                    for (int j1 = -l; j1 <= l; ++j1) {
                        float f2 = (float) MathHelper.abs(j1) - 0.25F;
                        if ((i1 == 0 && j1 == 0 || !(f1 * f1 + f2 * f2 > f * f)) && (i1 != -l && i1 != l && j1 != -l && j1 != l || !(random.nextFloat() > 0.75F))) {
                            BlockState blockstate = world.getBlockState(blockPos.add(i1, k, j1));
                            Block block = blockstate.getBlock();
                            BlockPos ventPos = new BlockPos(blockPos.getX(), blockPos.getY() + 7, blockPos.getZ()); //
                            if (blockstate.isAir() || block == UGBlocks.ashen_deepturf) {
                                this.setBlockState(world, blockPos.add(i1, k, j1), UGBlocks.depthrock.getDefaultState());
                            }
                            this.setBlockState(world, ventPos, UGBlocks.smog_vent.getDefaultState());

                            if (k != 0 && l > 1) {
                                blockstate = world.getBlockState(blockPos.add(i1, -k, j1));
                                block = blockstate.getBlock();
                                if (blockstate.isAir() || block == UGBlocks.ashen_deepturf) {
                                    this.setBlockState(world, blockPos.add(i1, -k, j1), UGBlocks.depthrock.getDefaultState());
                                }
                            }
                        }
                    }
                }
            }

            int k1 = j - 1;

            for(int l1 = -k1; l1 <= k1; ++l1) {
                for(int i2 = -k1; i2 <= k1; ++i2) {
                    BlockPos blockpos = blockPos.add(l1, -1, i2);
                    BlockState blockstate1 = world.getBlockState(blockpos);
                    Block block1 = blockstate1.getBlock();
                    if (!blockstate1.isAir() && block1 != UGBlocks.ashen_deepturf && block1 != UGBlocks.deepsoil && block1 != UGBlocks.depthrock) {
                        break;
                    }

                    world.setBlockState(blockpos, UGBlocks.depthrock.getDefaultState(), 1);
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}
