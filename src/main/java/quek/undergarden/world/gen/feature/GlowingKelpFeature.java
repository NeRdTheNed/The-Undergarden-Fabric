package quek.undergarden.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import quek.undergarden.block.GlowingKelpTopBlock;
import quek.undergarden.registry.UGBlocks;

import java.util.Random;

public class GlowingKelpFeature extends Feature<DefaultFeatureConfig> {

    public GlowingKelpFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, DefaultFeatureConfig featureConfig) {
        int i = 0;
        int ocean_y = 32;
        BlockPos blockpos = new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        if(blockPos.getY() < ocean_y) {
            if (world.getBlockState(blockpos).getBlock() == Blocks.WATER) {
                BlockState kelp = UGBlocks.glowing_kelp.getDefaultState();
                BlockState kelp_top = UGBlocks.glowing_kelp_top.getDefaultState();
                int k = 1 + random.nextInt(10);

                for(int l = 0; l <= k; ++l) {
                    if (world.getBlockState(blockpos).getBlock() == Blocks.WATER && world.getBlockState(blockpos.up()).getBlock() == Blocks.WATER && kelp_top.canPlaceAt(world, blockpos)) {
                        if (l == k) {
                            world.setBlockState(blockpos, kelp_top.with(GlowingKelpTopBlock.AGE, random.nextInt(4) + 20), 2);
                            ++i;
                        } else {
                            world.setBlockState(blockpos, kelp_top, 2);
                        }
                    } else if (l > 0) {
                        BlockPos blockpos1 = blockpos.down();
                        if (kelp.canPlaceAt(world, blockpos1) && world.getBlockState(blockpos1.down()).getBlock() != UGBlocks.glowing_kelp) {
                            world.setBlockState(blockpos1, kelp_top.with(GlowingKelpTopBlock.AGE, random.nextInt(4) + 20), 2);
                            ++i;
                        }
                        break;
                    }

                    blockpos = blockpos.up();
                }
            }
        }
        return i > 0;
    }
}
