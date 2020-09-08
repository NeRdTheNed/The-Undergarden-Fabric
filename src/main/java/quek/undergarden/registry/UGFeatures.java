package quek.undergarden.registry;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import quek.undergarden.UndergardenMod;
import quek.undergarden.world.gen.feature.UGTreeFeature;

public class UGFeatures {

    public static final Feature<TreeFeatureConfig> undergarden_tree = new UGTreeFeature(TreeFeatureConfig.CODEC);

    public static final TreeFeatureConfig smogstem_config = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(UGBlocks.smogstem_log.getDefaultState()),
            new SimpleBlockStateProvider(UGBlocks.smogstem_leaves.getDefaultState()),
            new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 2),
            new StraightTrunkPlacer(10, 2, 2),
            new TwoLayersFeatureSize(1, 0, 1)
    ).ignoreVines().build());

    public static final TreeFeatureConfig wigglewood_config = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(UGBlocks.wigglewood_log.getDefaultState()),
            new SimpleBlockStateProvider(UGBlocks.wigglewood_leaves.getDefaultState()),
            new BushFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 0),
            new ForkingTrunkPlacer(3, 0, 0),
            new TwoLayersFeatureSize(1, 0, 2)
    ).ignoreVines().build());

    public static final HugeFungusFeatureConfig grongle_config = new HugeFungusFeatureConfig(
            UGBlocks.deepturf_block.getDefaultState(),
            UGBlocks.grongle_log.getDefaultState(),
            UGBlocks.grongle_cap.getDefaultState(),
            Blocks.SHROOMLIGHT.getDefaultState(),
            true
    );

    public static final ConfiguredFeature<TreeFeatureConfig, ?> smogstem_tree = undergarden_tree.configure(smogstem_config);
    public static final ConfiguredFeature<TreeFeatureConfig, ?> wigglewood_tree = undergarden_tree.configure(wigglewood_config);
    public static final ConfiguredFeature<HugeFungusFeatureConfig, ?> grongle = Feature.HUGE_FUNGUS.configure(grongle_config);

    public static void registerAll() {
        registerAllFeatures();
        registerAllConfiguredFeatures();
    }

    private static void registerAllFeatures() {
        registerFeature("undergarden_tree", undergarden_tree);
    }

    private static void registerAllConfiguredFeatures() {
        registerConfigFeature("smogstem_tree", smogstem_tree.decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8))));
        registerConfigFeature("wigglewood_tree", wigglewood_tree.decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8))));
        registerConfigFeature("grongle", grongle.decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8))));
    }

    private static void registerFeature(String regName, Feature<?> feature2Register) {
        Registry.register(Registry.FEATURE, new Identifier(UndergardenMod.MODID, regName), feature2Register);
    }

    private static <FC extends FeatureConfig> void registerConfigFeature(String regName, ConfiguredFeature<FC, ?> configuredFeature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(UndergardenMod.MODID, regName), configuredFeature);
    }
}
