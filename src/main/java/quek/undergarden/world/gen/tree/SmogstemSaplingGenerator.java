package quek.undergarden.world.gen.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;
import quek.undergarden.registry.UGFeatures;

import java.util.Random;

public class SmogstemSaplingGenerator extends SaplingGenerator {

    @Override
    protected @Nullable ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return UGFeatures.undergarden_tree.configure(UGFeatures.smogstem_config);
    }
}
