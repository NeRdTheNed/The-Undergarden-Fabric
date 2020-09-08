package quek.undergarden.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.SkyProperties;
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
        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) ->
                        world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : new Color(91, 117, 91).getRGB()),
                UGBlocks.deepturf_block,
                UGBlocks.deepturf,
                UGBlocks.shimmerweed,
                UGBlocks.tall_deepturf,
                UGBlocks.tall_shimmerweed,
                UGBlocks.gloomgourd_stem,
                UGBlocks.gloomgourd_stem_attached
        );
        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) ->
                        new Color(54, 45, 66).getRGB()),
                UGBlocks.gloomgourd_stem,
                UGBlocks.gloomgourd_stem_attached
        );
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
                    if (tintIndex == 0) {
                        return new Color(91, 117, 91).getRGB();
                    }
                    return -1;
                },
                UGBlocks.deepturf_block,
                UGBlocks.deepturf,
                UGBlocks.shimmerweed,
                UGBlocks.tall_shimmerweed,
                UGBlocks.tall_deepturf
        );
    }
}
