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

public class UGBlocks {

    public static final Block depthrock = new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.BASALT));
    public static final Block shiverstone = new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block deepsoil = new Block(FabricBlockSettings.copyOf(Blocks.DIRT));
    public static final Block coarse_deepsoil = new Block(FabricBlockSettings.copyOf(Blocks.COARSE_DIRT));
    public static final Block deepsoil_farmland = new Block(FabricBlockSettings.copyOf(Blocks.FARMLAND));
    public static final Block deepturf_block = new UGSpreadableBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK));
    public static final Block ashen_deepturf_block = new Block(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK));
    public static final Block deepturf = new UGFernBlock(FabricBlockSettings.copyOf(Blocks.GRASS));
    public static final Block shimmerweed = new UGFernBlock(FabricBlockSettings.copyOf(Blocks.GRASS).lightLevel(12));
    public static final Block ashen_deepturf = new AshenDeepturfBlock(FabricBlockSettings.copyOf(Blocks.GRASS));
    public static final Block tall_deepturf = new UGTallPlantBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS));
    public static final Block tall_shimmerweed = new UGTallPlantBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).lightLevel(14));
    public static final Block underbean_bush = new UnderbeanBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH));
    public static final Block glowing_kelp = new GlowingKelpBlock(FabricBlockSettings.copyOf(Blocks.SEAGRASS));

    public static final Block smogstem_torch = new UGTorchBlock(FabricBlockSettings.copyOf(Blocks.TORCH), ParticleTypes.FLAME);
    public static final Block smogstem_wall_torch = new UGWallTorchBlock(FabricBlockSettings.copyOf(Blocks.WALL_TORCH), ParticleTypes.FLAME);

    public static void registerAll() {
        registerBlock("depthrock", depthrock);
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
        registerBlockNoItem("underbean_bush", underbean_bush);
        registerBlock("glowing_kelp", glowing_kelp);
    }

    @Environment(EnvType.CLIENT)
    public static void renderLayers() {
        RenderLayer cutout = RenderLayer.getCutout();
        RenderLayer mipped = RenderLayer.getCutoutMipped();
        RenderLayer translucent = RenderLayer.getTranslucent();

        registerRenderLayer(deepturf_block, mipped);
        registerRenderLayer(deepturf, cutout);
        registerRenderLayer(shimmerweed, cutout);
        registerRenderLayer(ashen_deepturf, cutout);
        registerRenderLayer(tall_deepturf, cutout);
        registerRenderLayer(tall_shimmerweed, cutout);
        registerRenderLayer(smogstem_torch, cutout);
        registerRenderLayer(smogstem_wall_torch, cutout);
        registerRenderLayer(glowing_kelp, cutout);
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
