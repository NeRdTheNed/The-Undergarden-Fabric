package quek.undergarden.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import quek.undergarden.UndergardenMod;
import quek.undergarden.block.*;
import quek.undergarden.world.gen.tree.*;

public class UGBlocks {

    public static final Block depthrock = new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.BASALT));
    public static final Block depthrock_bricks = new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.BASALT));
    public static final Block depthrock_bricks_cracked = new Block(FabricBlockSettings.copyOf(Blocks.CRACKED_STONE_BRICKS).sounds(BlockSoundGroup.BASALT));
    public static final Block depthrock_slab = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).sounds(BlockSoundGroup.BASALT));
    public static final Block depthrock_brick_slab = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_SLAB).sounds(BlockSoundGroup.BASALT));
    public static final Block depthrock_stairs = new UGStairsBlock(depthrock.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).sounds(BlockSoundGroup.BASALT));
    public static final Block depthrock_brick_stairs = new UGStairsBlock(depthrock_bricks.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_BRICK_STAIRS).sounds(BlockSoundGroup.BASALT));
    public static final Block depthrock_wall = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.BASALT));
    public static final Block depthrock_brick_wall = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.BASALT));
    public static final Block depthrock_button = new UGStoneButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON).sounds(BlockSoundGroup.BASALT));
    public static final Block depthrock_pressure_plate = new UGPressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE).sounds(BlockSoundGroup.BASALT));

    public static final Block shiverstone = new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block shiverstone_bricks = new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block shiverstone_bricks_cracked = new Block(FabricBlockSettings.copyOf(Blocks.CRACKED_STONE_BRICKS).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block shiverstone_slab = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block shiverstone_brick_slab = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_SLAB).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block shiverstone_stairs = new UGStairsBlock(shiverstone.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block shiverstone_brick_stairs = new UGStairsBlock(shiverstone_bricks.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_BRICK_STAIRS).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block shiverstone_wall = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block shiverstone_brick_wall = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block shiverstone_button = new UGStoneButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block shiverstone_pressure_plate = new UGPressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE).sounds(BlockSoundGroup.NETHER_BRICKS));

    public static final Block deepsoil = new Block(FabricBlockSettings.copyOf(Blocks.DIRT));
    public static final Block coarse_deepsoil = new Block(FabricBlockSettings.copyOf(Blocks.COARSE_DIRT));
    public static final Block deepsoil_farmland = new UGFarmlandBlock(FabricBlockSettings.copyOf(Blocks.FARMLAND));
    public static final Block deepturf_block = new UGSpreadableBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK));
    public static final Block ashen_deepturf_block = new Block(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK));
    public static final Block deepturf = new UGFernBlock(FabricBlockSettings.copyOf(Blocks.GRASS));
    public static final Block shimmerweed = new UGFernBlock(FabricBlockSettings.copyOf(Blocks.GRASS).lightLevel(12));
    public static final Block ashen_deepturf = new AshenDeepturfBlock(FabricBlockSettings.copyOf(Blocks.GRASS));
    public static final Block tall_deepturf = new UGTallPlantBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS));
    public static final Block tall_shimmerweed = new UGTallPlantBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).lightLevel(14));

    public static final Block smogstem_log = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG));
    public static final Block smogstem_wood = new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD));
    public static final Block smogstem_log_stripped = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG));
    public static final Block smogstem_wood_stripped = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD));
    public static final Block smogstem_planks = new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS));
    public static final Block smogstem_slab = new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB));
    public static final Block smogstem_stairs = new UGStairsBlock(smogstem_planks.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final Block smogstem_fence = new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE));
    public static final Block smogstem_fence_gate = new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE));
    public static final Block smogstem_button = new UGWoodenButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON));
    public static final Block smogstem_pressure_plate = new UGPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE));
    public static final Block smogstem_door = new UGDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR));
    public static final Block smogstem_trapdoor = new UGTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR));

    public static final Block wigglewood_log = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG));
    public static final Block wigglewood_wood = new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD));
    public static final Block wigglewood_log_stripped = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG));
    public static final Block wigglewood_wood_stripped = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD));
    public static final Block wigglewood_planks = new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS));
    public static final Block wigglewood_slab = new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB));
    public static final Block wigglewood_stairs = new UGStairsBlock(wigglewood_planks.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final Block wigglewood_fence = new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE));
    public static final Block wigglewood_fence_gate = new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE));
    public static final Block wigglewood_button = new UGWoodenButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON));
    public static final Block wigglewood_pressure_plate = new UGPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE));
    public static final Block wigglewood_door = new UGDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR));
    public static final Block wigglewood_trapdoor = new UGTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR));

    public static final Block grongle_log = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.SHROOMLIGHT));
    public static final Block grongle_wood = new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).sounds(BlockSoundGroup.SHROOMLIGHT));
    public static final Block grongle_log_stripped = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.SHROOMLIGHT));
    public static final Block grongle_wood_stripped = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD));
    public static final Block grongle_planks = new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS));
    public static final Block grongle_slab = new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB));
    public static final Block grongle_stairs = new UGStairsBlock(grongle_planks.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final Block grongle_fence = new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE));
    public static final Block grongle_fence_gate = new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE));
    public static final Block grongle_button = new UGWoodenButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON));
    public static final Block grongle_pressure_plate = new UGPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE));
    public static final Block grongle_door = new UGDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR));
    public static final Block grongle_trapdoor = new UGTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR));

    public static final Block smogstem_leaves = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES));
    public static final Block wigglewood_leaves = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES));
    public static final Block grongle_cap = new Block(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).sounds(BlockSoundGroup.SHROOMLIGHT));

    public static final Block smogstem_sapling = new UGSaplingBlock(new SmogstemSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
    public static final Block wigglewood_sapling = new UGSaplingBlock(new WigglewoodSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
    public static final Block gronglet = new GrongletBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_FUNGUS).sounds(BlockSoundGroup.SHROOMLIGHT), () -> UGFeatures.grongle);

    public static final Block coal_ore = new UGOreBlock(FabricBlockSettings.copyOf(Blocks.COAL_ORE).sounds(BlockSoundGroup.BASALT));
    public static final Block iron_ore = new UGOreBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).sounds(BlockSoundGroup.BASALT));
    public static final Block gold_ore = new UGOreBlock(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).sounds(BlockSoundGroup.BASALT));
    public static final Block diamond_ore = new UGOreBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.BASALT));
    public static final Block cloggrum_ore = new UGOreBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).sounds(BlockSoundGroup.BASALT));
    public static final Block froststeel_ore = new UGOreBlock(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).sounds(BlockSoundGroup.BASALT));
    public static final Block utherium_ore = new UGOreBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.BASALT));
    public static final Block regalium_ore = new UGOreBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.BASALT));

    public static final Block cloggrum_block = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block froststeel_block = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block utherium_block = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block regalium_block = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block cloggrum_bars = new UGPaneBlock(FabricBlockSettings.copyOf(Blocks.IRON_BARS));

    public static final GourdBlock gloomgourd = new GloomgourdBlock(FabricBlockSettings.copyOf(Blocks.PUMPKIN));
    public static final Block carved_gloomgourd = new CarvedGloomgourdBlock(FabricBlockSettings.copyOf(Blocks.CARVED_PUMPKIN));
    public static final Block gloom_o_lantern = new CarvedGloomgourdBlock(FabricBlockSettings.copyOf(Blocks.JACK_O_LANTERN).lightLevel(15));
    public static final StemBlock gloomgourd_stem = new UGStemBlock(gloomgourd, FabricBlockSettings.copyOf(Blocks.MELON_STEM));
    public static final AttachedStemBlock gloomgourd_stem_attached = new UGStemAttachedBlock(gloomgourd, FabricBlockSettings.copyOf(Blocks.ATTACHED_MELON_STEM));
    public static final Block depthrock_pebbles = new PebblesBlock(FabricBlockSettings.of(Material.SUPPORTED).sounds(BlockSoundGroup.BASALT).strength(0F).nonOpaque().noCollision());
    public static final Block underbean_bush = new UnderbeanBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH));
    public static final Block blisterberry_bush = new UnderbeanBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH));
    public static final Block indigo_mushroom = new UGPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).lightLevel(2));
    public static final Block veil_mushroom = new UGPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM));
    public static final Block ink_mushroom = new UGPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM));
    public static final Block blood_mushroom = new UGPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM));
    public static final Block ditchbulb_plant = new DitchbulbBlock(FabricBlockSettings.copyOf(Blocks.GRASS));
    public static final Block glowing_kelp = new GlowingKelpBlock(FabricBlockSettings.copyOf(Blocks.KELP_PLANT).lightLevel(10));
    public static final Block glowing_kelp_top = new GlowingKelpTopBlock(FabricBlockSettings.copyOf(Blocks.KELP).lightLevel(5));
    public static final Block glowing_seagrass = new GlowingSeagrassBlock(FabricBlockSettings.copyOf(Blocks.SEAGRASS).lightLevel(7));
    public static final Block droopvine = new DroopvineBlock(FabricBlockSettings.copyOf(Blocks.WEEPING_VINES).sounds(BlockSoundGroup.WET_GRASS).lightLevel(DroopvineBlock.glowIfGlowy()));
    public static final Block droopvine_top = new DroopvineTopBlock(FabricBlockSettings.copyOf(Blocks.WEEPING_VINES_PLANT).sounds(BlockSoundGroup.WET_GRASS).lightLevel(10));
    public static final Block goo = new GooBlock(FabricBlockSettings.of(Material.SNOW_LAYER).strength(1F, 0F).noCollision().ticksRandomly().sounds(BlockSoundGroup.SLIME).requiresTool());
    public static final Block smog_vent = new SmogVentBlock(FabricBlockSettings.copyOf(depthrock).lightLevel(15));

    public static final Block smogstem_torch = new UGTorchBlock(FabricBlockSettings.copyOf(Blocks.TORCH), ParticleTypes.FLAME);
    public static final Block smogstem_wall_torch = new UGWallTorchBlock(FabricBlockSettings.copyOf(Blocks.WALL_TORCH), ParticleTypes.FLAME);
    public static final Block shard_torch = new ShardTorchBlock(FabricBlockSettings.copyOf(Blocks.TORCH).lightLevel(6), ParticleTypes.FLAME);
    public static final Block shard_wall_torch = new ShardWallTorchBlock(FabricBlockSettings.copyOf(Blocks.TORCH).lightLevel(6), ParticleTypes.FLAME);

    public static final Block virulent_mix = new UGFluidBlock(UGFluids.virulent_mix, FabricBlockSettings.copyOf(Blocks.WATER));

    public static void registerAll() {
        registerBlock("depthrock", depthrock);
        registerBlock("depthrock_bricks", depthrock_bricks);
        registerBlock("cracked_depthrock_bricks", depthrock_bricks_cracked);
        registerBlock("depthrock_slab", depthrock_slab);
        registerBlock("depthrock_brick_slab", depthrock_brick_slab);
        registerBlock("depthrock_brick_stairs", depthrock_brick_stairs);
        registerBlock("depthrock_wall", depthrock_wall);
        registerBlock("depthrock_brick_wall", depthrock_brick_wall);
        registerBlock("depthrock_button", depthrock_button);
        registerBlock("depthrock_pressure_plate", depthrock_pressure_plate);

        registerBlock("shiverstone", shiverstone);
        registerBlock("shiverstone_bricks", shiverstone_bricks);
        registerBlock("cracked_shiverstone_bricks", shiverstone_bricks_cracked);
        registerBlock("shiverstone_slab", shiverstone_slab);
        registerBlock("shiverstone_brick_slab", shiverstone_brick_slab);
        registerBlock("shiverstone_brick_stairs", shiverstone_brick_stairs);
        registerBlock("shiverstone_wall", shiverstone_wall);
        registerBlock("shiverstone_brick_wall", shiverstone_brick_wall);
        registerBlock("shiverstone_button", shiverstone_button);
        registerBlock("shiverstone_pressure_plate", shiverstone_pressure_plate);

        registerBlock("deepsoil", deepsoil);
        registerBlock("coarse_deepsoil", coarse_deepsoil);
        registerBlock("deepsoil_farmland", deepsoil_farmland);
        registerBlock("deepturf_block", deepturf_block);
        registerBlock("ashen_deepturf_block", ashen_deepturf_block);
        registerBlock("deepturf", deepturf);
        registerBlock("shimmerweed", shimmerweed);
        registerBlock("ashen_deepturf", ashen_deepturf);
        registerBlock("tall_deepturf", tall_deepturf);
        registerBlock("tall_shimmerweed", tall_shimmerweed);

        registerBlock("smogstem_log", smogstem_log);
        registerBlock("smogstem_wood", smogstem_wood);
        registerBlock("stripped_smogstem_log", smogstem_log_stripped);
        registerBlock("stripped_smogstem_wood", smogstem_wood_stripped);
        registerBlock("smogstem_planks", smogstem_planks);
        registerBlock("smogstem_slab", smogstem_slab);
        registerBlock("smogstem_fence", smogstem_fence);
        registerBlock("smogstem_fence_gate", smogstem_fence_gate);
        registerBlock("smogstem_button", smogstem_button);
        registerBlock("smogstem_pressure_plate", smogstem_pressure_plate);
        registerBlock("smogstem_door", smogstem_door);
        registerBlock("smogstem_trapdoor", smogstem_trapdoor);

        registerBlock("wigglewood_log", wigglewood_log);
        registerBlock("wigglewood_wood", wigglewood_wood);
        registerBlock("stripped_wigglewood_log", wigglewood_log_stripped);
        registerBlock("stripped_wigglewood_wood", wigglewood_wood_stripped);
        registerBlock("wigglewood_planks", wigglewood_planks);
        registerBlock("wigglewood_slab", wigglewood_slab);
        registerBlock("wigglewood_fence", wigglewood_fence);
        registerBlock("wigglewood_fence_gate", wigglewood_fence_gate);
        registerBlock("wigglewood_button", wigglewood_button);
        registerBlock("wigglewood_pressure_plate", wigglewood_pressure_plate);
        registerBlock("wigglewood_door", wigglewood_door);
        registerBlock("wigglewood_trapdoor", wigglewood_trapdoor);

        registerBlock("grongle_stem", grongle_log);
        registerBlock("grongle_hyphae", grongle_wood);
        registerBlock("stripped_grongle_stem", grongle_log_stripped);
        registerBlock("stripped_grongle_hyphae", grongle_wood_stripped);
        registerBlock("grongle_planks", grongle_planks);
        registerBlock("grongle_slab", grongle_slab);
        registerBlock("grongle_fence", grongle_fence);
        registerBlock("grongle_fence_gate", grongle_fence_gate);
        registerBlock("grongle_button", grongle_button);
        registerBlock("grongle_pressure_plate", grongle_pressure_plate);
        registerBlock("grongle_door", grongle_door);
        registerBlock("grongle_trapdoor", grongle_trapdoor);

        registerBlock("smogstem_leaves", smogstem_leaves);
        registerBlock("wigglewood_leaves", wigglewood_leaves);
        registerBlock("grongle_cap", grongle_cap);

        registerBlock("smogstem_sapling", smogstem_sapling);
        registerBlock("wigglewood_sapling", wigglewood_sapling);
        registerBlock("gronglet", gronglet);

        registerBlock("coal_ore", coal_ore);
        registerBlock("iron_ore", iron_ore);
        registerBlock("gold_ore", gold_ore);
        registerBlock("diamond_ore", diamond_ore);
        registerBlock("cloggrum_ore", cloggrum_ore);
        registerBlock("froststeel_ore", froststeel_ore);
        registerBlock("utherium_ore", utherium_ore);
        registerBlock("regalium_ore", regalium_ore);

        registerBlock("cloggrum_block", cloggrum_block);
        registerBlock("froststeel_block", froststeel_block);
        registerBlock("utherium_block", utherium_block);
        registerBlock("regalium_block", regalium_block);
        registerBlock("cloggrum_bars", cloggrum_bars);

        registerBlock("gloomgourd", gloomgourd);
        registerBlock("carved_gloomgourd", carved_gloomgourd);
        registerBlock("gloom_o_lantern", gloom_o_lantern);
        registerBlockNoItem("gloomgourd_stem", gloomgourd_stem);
        registerBlockNoItem("gloomgourd_stem_attached", gloomgourd_stem_attached);
        registerBlock("depthrock_pebbles", depthrock_pebbles);
        registerBlockNoItem("underbean_bush", underbean_bush);
        registerBlockNoItem("blisterberry_bush", blisterberry_bush);
        registerBlock("indigo_mushroom", indigo_mushroom);
        registerBlock("veil_mushroom", veil_mushroom);
        registerBlock("ink_mushroom", ink_mushroom);
        registerBlock("blood_mushroom", blood_mushroom);
        registerBlock("ditchbulb_plant", ditchbulb_plant);
        registerBlockNoItem("glowing_kelp_top", glowing_kelp_top);
        registerBlockNoItem("glowing_kelp", glowing_kelp);
        registerBlock("glowing_sea_grass", glowing_seagrass);
        registerBlockNoItem("droopvine_top", droopvine_top);
        registerBlockNoItem("droopvine", droopvine);
        registerBlock("goo", goo);
        registerBlock("smog_vent", smog_vent);

        registerBlockNoItem("smogstem_torch", smogstem_torch);
        registerBlockNoItem("smogstem_wall_torch", smogstem_wall_torch);
        registerBlockNoItem("shard_torch", shard_torch);
        registerBlockNoItem("shard_wall_torch", shard_wall_torch);

        registerBlockNoItem("virulent_mix", virulent_mix);
    }

    @Environment(EnvType.CLIENT)
    public static void renderLayers() {
        RenderLayer cutout = RenderLayer.getCutout();
        RenderLayer mipped = RenderLayer.getCutoutMipped();
        RenderLayer translucent = RenderLayer.getTranslucent();

        registerRenderLayer(deepturf_block, mipped);
        registerRenderLayer(deepturf, cutout);
        registerRenderLayer(ashen_deepturf, cutout);
        registerRenderLayer(shimmerweed, cutout);
        registerRenderLayer(ashen_deepturf, cutout);
        registerRenderLayer(tall_deepturf, cutout);
        registerRenderLayer(tall_shimmerweed, cutout);
        registerRenderLayer(smogstem_sapling, cutout);
        registerRenderLayer(wigglewood_sapling, cutout);
        registerRenderLayer(gronglet, cutout);
        registerRenderLayer(smogstem_door, cutout);
        registerRenderLayer(smogstem_trapdoor, cutout);
        registerRenderLayer(wigglewood_door, cutout);
        registerRenderLayer(wigglewood_trapdoor, cutout);
        registerRenderLayer(grongle_door, cutout);
        registerRenderLayer(grongle_trapdoor, cutout);
        registerRenderLayer(gloomgourd_stem, cutout);
        registerRenderLayer(gloomgourd_stem_attached, cutout);
        registerRenderLayer(underbean_bush, cutout);
        registerRenderLayer(blisterberry_bush, cutout);
        registerRenderLayer(indigo_mushroom, cutout);
        registerRenderLayer(veil_mushroom, cutout);
        registerRenderLayer(ink_mushroom, cutout);
        registerRenderLayer(blood_mushroom, cutout);
        registerRenderLayer(ditchbulb_plant, cutout);
        registerRenderLayer(glowing_kelp, cutout);
        registerRenderLayer(glowing_kelp_top, cutout);
        registerRenderLayer(glowing_seagrass, cutout);
        registerRenderLayer(droopvine, cutout);
        registerRenderLayer(droopvine_top, cutout);
        registerRenderLayer(goo, translucent);
        registerRenderLayer(smogstem_torch, cutout);
        registerRenderLayer(smogstem_wall_torch, cutout);
        registerRenderLayer(shard_torch, cutout);
        registerRenderLayer(shard_wall_torch, cutout);
        registerRenderLayer(virulent_mix, translucent);
    }

    private static void registerBlock(String regName, Block block2Register) {
        Registry.register(Registry.BLOCK, new Identifier(UndergardenMod.MODID, regName), block2Register);
        Registry.register(Registry.ITEM, new Identifier(UndergardenMod.MODID, regName), new BlockItem(block2Register, new FabricItemSettings().group(UndergardenMod.group)));
    }

    private static void registerBlockNoItem(String regName, Block block2Register) {
        Registry.register(Registry.BLOCK, new Identifier(UndergardenMod.MODID, regName), block2Register);
    }

    private static void registerRenderLayer(Block block, RenderLayer renderLayer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, renderLayer);
    }

}
