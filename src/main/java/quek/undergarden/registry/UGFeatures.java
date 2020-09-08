package quek.undergarden.registry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
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
import net.minecraft.world.gen.placer.DoublePlantPlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import quek.undergarden.UndergardenMod;
import quek.undergarden.block.*;
import quek.undergarden.world.gen.feature.*;

public class UGFeatures {

    public static final Feature<TreeFeatureConfig> undergarden_tree = new UGTreeFeature(TreeFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> glowing_kelp = new GlowingKelpFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> droopvine = new DroopvineFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> smog_vent = new SmogVentFeature(DefaultFeatureConfig.CODEC);

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

    public static final RuleTest depthrock_filler = new BlockMatchRuleTest(UGBlocks.depthrock);

    public static void registerAll() {
        registerAllFeatures();
        registerAllConfiguredFeatures();
    }

    private static void registerAllFeatures() {
        registerFeature("undergarden_tree", undergarden_tree);
        registerFeature("glowing_kelp", glowing_kelp);
        registerFeature("droopvine", droopvine);
        registerFeature("smog_vent", smog_vent);
    }

    private static void registerAllConfiguredFeatures() {
        registerConfigFeature("spring", Feature.SPRING_FEATURE.configure(new SpringFeatureConfig(Fluids.WATER.getDefaultState(), false, 4, 1, ImmutableSet.of(UGBlocks.depthrock, UGBlocks.deepsoil))).decorate(ConfiguredFeatures.Decorators.NETHER_SPRING.spreadHorizontally()).repeat(8));
        registerConfigFeature("virulent_spring", Feature.SPRING_FEATURE.configure(new SpringFeatureConfig(UGFluids.virulent_mix.getDefaultState(), false, 4, 1, ImmutableSet.of(UGBlocks.depthrock, UGBlocks.deepsoil))).decorate(ConfiguredFeatures.Decorators.NETHER_SPRING.spreadHorizontally()).repeat(8));

        registerConfigFeature("deepturf_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.deepturf.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(UGBlocks.deepturf_block)).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(100));
        registerConfigFeature("ashen_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.ashen_deepturf.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(UGBlocks.ashen_deepturf)).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(100));
        registerConfigFeature("shimmerweed_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.shimmerweed.getDefaultState()), new SimpleBlockPlacer())).tries(32).whitelist(ImmutableSet.of(UGBlocks.deepturf_block)).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(75));
        registerConfigFeature("pebble_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.depthrock_pebbles.getDefaultState()), new SimpleBlockPlacer())).tries(32).whitelist(ImmutableSet.of(UGBlocks.deepturf_block, UGBlocks.ashen_deepturf, UGBlocks.depthrock, UGBlocks.shiverstone)).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(75));
        registerConfigFeature("ditchbulb_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.ditchbulb_plant.getDefaultState()), new SimpleBlockPlacer())).tries(16).whitelist(ImmutableSet.of(UGBlocks.depthrock)).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(50));
        registerConfigFeature("seagrass_patch", Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(UGBlocks.glowing_seagrass.getDefaultState(), ImmutableList.of(UGBlocks.depthrock.getDefaultState(), UGBlocks.deepsoil.getDefaultState()), ImmutableList.of(Blocks.WATER.getDefaultState()), ImmutableList.of(Blocks.WATER.getDefaultState()))).method_30377(32).spreadHorizontally().repeat(100));

        registerConfigFeature("double_deepturf_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.tall_deepturf.getDefaultState()), new DoublePlantPlacer())).tries(32).whitelist(ImmutableSet.of(UGBlocks.deepturf_block)).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(100));
        registerConfigFeature("double_shimmerweed_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.tall_shimmerweed.getDefaultState()), new DoublePlantPlacer())).tries(16).whitelist(ImmutableSet.of(UGBlocks.deepturf_block)).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(50));

        registerConfigFeature("indigo_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.indigo_mushroom.getDefaultState()), new SimpleBlockPlacer())).tries(64).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(1));
        registerConfigFeature("veil_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.veil_mushroom.getDefaultState()), new SimpleBlockPlacer())).tries(64).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(1));
        registerConfigFeature("ink_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.ink_mushroom.getDefaultState()), new SimpleBlockPlacer())).tries(64).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(1));
        registerConfigFeature("blood_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.blood_mushroom.getDefaultState()), new SimpleBlockPlacer())).tries(64).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(1));
        registerConfigFeature("gronglet_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.gronglet.getDefaultState()), new SimpleBlockPlacer())).tries(64).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(100));

        registerConfigFeature("underbean_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.underbean_bush.getDefaultState().with(UnderbeanBushBlock.AGE, 3)), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(UGBlocks.deepturf_block)).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(5));
        registerConfigFeature("blisterberry_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.blisterberry_bush.getDefaultState().with(UnderbeanBushBlock.AGE, 3)), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(UGBlocks.ashen_deepturf)).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(5));
        registerConfigFeature("gloomgourd_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(UGBlocks.gloomgourd.getDefaultState()), new SimpleBlockPlacer())).tries(16).whitelist(ImmutableSet.of(UGBlocks.deepturf_block)).cannotProject().build()).method_30377(256).spreadHorizontally().repeat(5));

        registerConfigFeature("coal_ore", Feature.ORE.configure(new OreFeatureConfig(depthrock_filler, UGBlocks.coal_ore.getDefaultState(), 17)).method_30377(256).spreadHorizontally().repeat(20));
        registerConfigFeature("iron_ore", Feature.ORE.configure(new OreFeatureConfig(depthrock_filler, UGBlocks.iron_ore.getDefaultState(), 9)).method_30377(64).spreadHorizontally().repeat(20));
        registerConfigFeature("gold_ore", Feature.ORE.configure(new OreFeatureConfig(depthrock_filler, UGBlocks.gold_ore.getDefaultState(), 9)).method_30377(32).spreadHorizontally().repeat(2));
        registerConfigFeature("diamond_ore", Feature.ORE.configure(new OreFeatureConfig(depthrock_filler, UGBlocks.diamond_ore.getDefaultState(), 8)).method_30377(16).spreadHorizontally().repeat(8));
        registerConfigFeature("cloggrum_ore", Feature.ORE.configure(new OreFeatureConfig(depthrock_filler, UGBlocks.cloggrum_ore.getDefaultState(), 5)).method_30377(128).spreadHorizontally().repeat(15));
        registerConfigFeature("froststeel_ore", Feature.ORE.configure(new OreFeatureConfig(depthrock_filler, UGBlocks.froststeel_ore.getDefaultState(), 4)).method_30377(64).spreadHorizontally().repeat(3));
        registerConfigFeature("utherium_ore", Feature.ORE.configure(new OreFeatureConfig(depthrock_filler, UGBlocks.utherium_ore.getDefaultState(), 8)).method_30377(32).spreadHorizontally().repeat(1));
        registerConfigFeature("regalium_ore", Feature.ORE.configure(new OreFeatureConfig(depthrock_filler, UGBlocks.regalium_ore.getDefaultState(), 4)).method_30377(11).spreadHorizontally().repeat(2));

        registerConfigFeature("shiverstone_patch", Feature.ORE.configure(new OreFeatureConfig(depthrock_filler, UGBlocks.shiverstone.getDefaultState(), 33)).method_30377(256).spreadHorizontally().repeat(10));
        registerConfigFeature("deepsoil_patch", Feature.ORE.configure(new OreFeatureConfig(depthrock_filler, UGBlocks.deepsoil.getDefaultState(), 33)).method_30377(256).spreadHorizontally().repeat(10));

        registerConfigFeature("smogstem_tree", smogstem_tree.decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8))));
        registerConfigFeature("wigglewood_tree", wigglewood_tree.decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8))));
        registerConfigFeature("grongle", grongle.decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8))));

        registerConfigFeature("glowing_kelp", glowing_kelp.configure(FeatureConfig.DEFAULT).method_30377(32).spreadHorizontally().repeat(100));
        registerConfigFeature("smog_vent", smog_vent.configure(FeatureConfig.DEFAULT).decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8))));
        //registerConfigFeature("enigmatic_statue", enigmatic_statue.configure(FeatureConfig.DEFAULT).method_30377(256).spreadHorizontally().repeat(100));
        registerConfigFeature("droopvine", droopvine.configure(FeatureConfig.DEFAULT).method_30377(256).spreadHorizontally().repeat(100));
    }

    private static void registerFeature(String regName, Feature<?> feature2Register) {
        Registry.register(Registry.FEATURE, new Identifier(UndergardenMod.MODID, regName), feature2Register);
    }

    private static <FC extends FeatureConfig> void registerConfigFeature(String regName, ConfiguredFeature<FC, ?> configuredFeature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(UndergardenMod.MODID, regName), configuredFeature);
    }
}
