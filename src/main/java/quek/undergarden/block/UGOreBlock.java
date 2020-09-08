package quek.undergarden.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import quek.undergarden.registry.UGBlocks;

import java.util.Random;

public class UGOreBlock extends OreBlock {

    public UGOreBlock(Settings settings) {
        super(settings);
    }

    protected int getExperienceWhenMined(Random random) {
        if (this == UGBlocks.coal_ore) {
            return MathHelper.nextInt(random, 0, 2);
        } else if (this == UGBlocks.diamond_ore || this == UGBlocks.utherium_ore) {
            return MathHelper.nextInt(random, 3, 7);
        } else {
            return this == UGBlocks.regalium_ore ? MathHelper.nextInt(random, 4, 8) : 0;
        }
    }

    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack);
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            int i = this.getExperienceWhenMined(world.random);
            if (i > 0) {
                this.dropExperience(world, pos, i);
            }
        }

    }
}
