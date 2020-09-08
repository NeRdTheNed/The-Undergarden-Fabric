package quek.undergarden.registry;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import quek.undergarden.UndergardenMod;
import quek.undergarden.blockentity.*;

public class UGBlockEntities {

    public static final BlockEntityType<SmogVentBlockEntity> smog_vent = BlockEntityType.Builder.create(SmogVentBlockEntity::new, UGBlocks.smog_vent).build(null);
    public static final BlockEntityType<ShardTorchBlockEntity> shard_torch = BlockEntityType.Builder.create(ShardTorchBlockEntity::new, UGBlocks.shard_torch, UGBlocks.shard_wall_torch).build(null);

    public static void registerAll() {
        registerBE("smog_vent", smog_vent);
        registerBE("shard_torch", shard_torch);
    }

    private static void registerBE(String regName, BlockEntityType<?> blockEntity2register) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(UndergardenMod.MODID, regName), blockEntity2register);
    }
}
