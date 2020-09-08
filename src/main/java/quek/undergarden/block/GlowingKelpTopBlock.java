package quek.undergarden.block;

import net.minecraft.block.Block;
import net.minecraft.block.KelpBlock;
import quek.undergarden.registry.UGBlocks;

public class GlowingKelpTopBlock extends KelpBlock {

    public GlowingKelpTopBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected Block getPlant() {
        return UGBlocks.glowing_kelp;
    }
}
