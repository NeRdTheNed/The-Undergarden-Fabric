package quek.undergarden.block;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;
import quek.undergarden.blockentity.ShardTorchBlockEntity;

public class ShardWallTorchBlock extends UGWallTorchBlock implements BlockEntityProvider {

    public ShardWallTorchBlock(Settings settings, ParticleEffect particleEffect) {
        super(settings, particleEffect);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new ShardTorchBlockEntity();
    }
}
