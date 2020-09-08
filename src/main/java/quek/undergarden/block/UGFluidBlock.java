package quek.undergarden.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import quek.undergarden.registry.UGFluids;

public class UGFluidBlock extends FluidBlock {

    public UGFluidBlock(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(this.fluid == UGFluids.virulent_mix || this.fluid == UGFluids.flowing_virulent_mix) {
            if(entity.isAlive() && entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 0));
            }
        }
    }
}
