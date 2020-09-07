package quek.undergarden.mixin;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SkyProperties.class)
public interface SkyPropertiesMixin {

    @Accessor("BY_IDENTIFIER")
    static Object2ObjectMap<Identifier, SkyProperties> BY_IDENTIFIER() {
        return null;
    }
}
