package quek.undergarden.block;

import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.KelpPlantBlock;
import quek.undergarden.registry.UGBlocks;

public class GlowingKelpBlock extends KelpPlantBlock {

    public GlowingKelpBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) UGBlocks.glowing_kelp_top;
    }
}
