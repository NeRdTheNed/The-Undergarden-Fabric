package quek.undergarden.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import quek.undergarden.UndergardenMod;
import quek.undergarden.mixin.SkyPropertiesMixin;
import quek.undergarden.registry.UGBlocks;

import java.awt.*;

@Environment(EnvType.CLIENT)
public class UndergardenClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UGBlocks.renderLayers();
        registerBlockColors();
        registerItemColors();
        SkyPropertiesMixin.BY_IDENTIFIER().put(new Identifier(UndergardenMod.MODID, "undergarden"), new SkyProperties(Float.NaN, false, SkyProperties.SkyType.NONE, false, true) {
            @Override
            public Vec3d adjustSkyColor(Vec3d color, float sunHeight) {
                return color;
            }

            @Override
            public boolean useThickFog(int camX, int camY) {
                return false;
            }
        });
    }

    public static void registerBlockColors() {
        BlockColors colors = new BlockColors();

        colors.registerColorProvider((state, world, pos, tint) ->
                        world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : new Color(91, 117, 91).getRGB(),
                UGBlocks.deepturf_block,
                UGBlocks.deepturf,
                UGBlocks.shimmerweed,
                UGBlocks.tall_deepturf,
                UGBlocks.tall_shimmerweed//,
                //UGBlocks.gloomgourd_stem,
                ///UGBlocks.gloomgourd_stem_attached
        );
    }

    public static void registerItemColors() {
        BlockColors bColors = new BlockColors();
        ItemColors iColors = new ItemColors();

        iColors.register((stack, tint) -> bColors.getColor(((BlockItem) stack.getItem()).getBlock().getDefaultState(), null, null, 0),
                UGBlocks.deepturf_block,
                UGBlocks.deepturf,
                UGBlocks.shimmerweed,
                UGBlocks.tall_shimmerweed,
                UGBlocks.tall_deepturf
        );

        iColors.register((stack, tint) -> {
                    if(tint == 0) {
                        return new Color(91, 117, 91).getRGB();
                    }
                    return -1;
                },

                UGBlocks.shimmerweed,
                UGBlocks.tall_shimmerweed
        );

    }
}
