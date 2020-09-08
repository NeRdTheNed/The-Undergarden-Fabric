package quek.undergarden.block;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;
import quek.undergarden.blockentity.ShardTorchBlockEntity;

public class ShardTorchBlock extends UGTorchBlock implements BlockEntityProvider {

    public ShardTorchBlock(Settings settings, ParticleEffect particle) {
        super(settings, particle);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new ShardTorchBlockEntity();
    }
}
