package quek.undergarden.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.GourdBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import quek.undergarden.registry.UGBlocks;
import quek.undergarden.registry.UGItems;

public class UGStemAttachedBlock extends AttachedStemBlock {

    public UGStemAttachedBlock(GourdBlock gourdBlock, Settings settings) {
        super(gourdBlock, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(UGBlocks.deepsoil_farmland);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(UGItems.gloomgourd_seeds);
    }
}
