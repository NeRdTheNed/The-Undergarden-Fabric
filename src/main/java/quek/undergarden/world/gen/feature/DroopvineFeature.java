package quek.undergarden.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import quek.undergarden.registry.UGBlocks;

import java.util.Random;

public class DroopvineFeature extends Feature<DefaultFeatureConfig> {

    public DroopvineFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(StructureWorldAccess structureWorldAccess, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, DefaultFeatureConfig defaultFeatureConfig) {
        if (!structureWorldAccess.isAir(blockPos)) {
            return false;
        } else {
            BlockState blockState = structureWorldAccess.getBlockState(blockPos.up());
            if (!blockState.isOf(UGBlocks.depthrock) && !blockState.isOf(UGBlocks.shiverstone)) {
                return false;
            } else {
                this.generateVinesInArea(structureWorldAccess, random, blockPos);
                return true;
            }
        }
    }

    private void generateVinesInArea(WorldAccess world, Random random, BlockPos pos) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int i = 0; i < 100; ++i) {
            mutable.set(pos, random.nextInt(8) - random.nextInt(8), random.nextInt(2) - random.nextInt(7), random.nextInt(8) - random.nextInt(8));
            if (world.isAir(mutable)) {
                BlockState blockState = world.getBlockState(mutable.up());
                if (blockState.isOf(UGBlocks.depthrock) || blockState.isOf(UGBlocks.shiverstone)) {
                    int j = MathHelper.nextInt(random, 1, 8);
                    if (random.nextInt(6) == 0) {
                        j *= 2;
                    }

                    if (random.nextInt(5) == 0) {
                        j = 1;
                    }

                    generateVineColumn(world, random, mutable, j, 17, 25);
                }
            }
        }

    }

    public static void generateVineColumn(WorldAccess world, Random random, BlockPos.Mutable pos, int length, int minAge, int maxAge) {
        for(int i = 0; i <= length; ++i) {
            if (world.isAir(pos)) {
                if (i == length || !world.isAir(pos.down())) {
                    world.setBlockState(pos, UGBlocks.droopvine_top.getDefaultState().with(AbstractPlantStemBlock.AGE, MathHelper.nextInt(random, minAge, maxAge)), 2);
                    break;
                }

                world.setBlockState(pos, UGBlocks.droopvine.getDefaultState(), 2);
            }

            pos.move(Direction.DOWN);
        }

    }
}
