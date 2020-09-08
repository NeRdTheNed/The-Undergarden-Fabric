package quek.undergarden.block;

import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import quek.undergarden.registry.UGBlocks;
import quek.undergarden.registry.UGItems;

public class GloomgourdBlock extends GourdBlock {

    public GloomgourdBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == Items.SHEARS) {
            if (!world.isClient) {
                Direction direction = hit.getSide();
                Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
                world.playSound(null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.setBlockState(pos, UGBlocks.carved_gloomgourd.getDefaultState().with(CarvedGloomgourdBlock.FACING, direction2), 11);
                ItemEntity itemEntity = new ItemEntity(world, (double)pos.getX() + 0.5D + (double)direction2.getOffsetX() * 0.65D, (double)pos.getY() + 0.1D, (double)pos.getZ() + 0.5D + (double)direction2.getOffsetZ() * 0.65D, new ItemStack(UGItems.gloomgourd_seeds, 4));
                itemEntity.setVelocity(0.05D * (double)direction2.getOffsetX() + world.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double)direction2.getOffsetZ() + world.random.nextDouble() * 0.02D);
                world.spawnEntity(itemEntity);
                itemStack.damage(1, (LivingEntity)player, ((playerEntity) -> playerEntity.sendToolBreakStatus(hand)));
            }

            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }

    @Override
    public StemBlock getStem() {
        return UGBlocks.gloomgourd_stem;
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return UGBlocks.gloomgourd_stem_attached;
    }
}
