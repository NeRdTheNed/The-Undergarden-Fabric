package quek.undergarden;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import quek.undergarden.registry.*;

public class UndergardenMod implements ModInitializer {

    public static final String MODID = "undergarden";

    @Override
    public void onInitialize() {
        UGItems.registerAll();
        UGBlocks.registerAll();
        UGFeatures.registerAll();
        UGBlockEntities.registerAll();
        UGFluids.registerAll();
    }

    public static final ItemGroup group = FabricItemGroupBuilder.build(new Identifier(MODID, "undergarden_group"), () -> new ItemStack(UGBlocks.deepturf));
}
