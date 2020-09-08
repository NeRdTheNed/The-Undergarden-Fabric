package quek.undergarden.blockentity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Tickable;
import quek.undergarden.registry.UGBlockEntities;

public class SmogVentBlockEntity extends BlockEntity implements Tickable {

    public SmogVentBlockEntity() {
        super(UGBlockEntities.smog_vent);
    }

    @Override
    public void tick() {
        double x = (double)pos.getX() + 0.5D;
        double y = (double)pos.getY() + 1D;
        double z = (double)pos.getZ() + 0.5D;
        if(world.isAir(pos.up())) {
            world.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0.0D, 0.05D, 0.0D);
        }
    }
}
