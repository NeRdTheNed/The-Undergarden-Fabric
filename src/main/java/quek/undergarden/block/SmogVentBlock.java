package quek.undergarden.block;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import quek.undergarden.blockentity.SmogVentBlockEntity;

public class SmogVentBlock extends BlockWithEntity {

    public SmogVentBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        if (!entity.isFireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
            entity.setOnFireFor(3);
        }

        super.onSteppedOn(world, pos, entity);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new SmogVentBlockEntity();
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
