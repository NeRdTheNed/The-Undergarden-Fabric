package quek.undergarden.registry;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import quek.undergarden.UndergardenMod;
import quek.undergarden.fluid.VirulentFluid;

public class UGFluids {

    public static final FlowableFluid flowing_virulent_mix = new VirulentFluid.Flowing();
    public static final FlowableFluid virulent_mix = new VirulentFluid.Still();

    public static void registerAll() {
        registerFluid("flowing_virulent_mix", flowing_virulent_mix);
        registerFluid("virulent_mix", virulent_mix);
    }

    private static void registerFluid(String regName, FlowableFluid fluid2register) {
        Registry.register(Registry.FLUID, new Identifier(UndergardenMod.MODID, regName), fluid2register);
    }
}
