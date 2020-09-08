package quek.undergarden.blockentity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;
import quek.undergarden.registry.UGBlockEntities;

public class ShardTorchBlockEntity extends BlockEntity implements Tickable {

    public ShardTorchBlockEntity() {
        super(UGBlockEntities.shard_torch);
    }

    @Override
    public void tick() {
        //TODO: functionality
    }
}
