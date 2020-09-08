package quek.undergarden.block;

import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShapes;
import org.jetbrains.annotations.Nullable;
import quek.undergarden.registry.UGBlocks;

import java.util.Random;
import java.util.function.ToIntFunction;

public class DroopvineBlock extends AbstractPlantBlock {

    public static final BooleanProperty GLOWY = BooleanProperty.of("glowy");

    public DroopvineBlock(Settings settings) {
        super(settings, Direction.DOWN, VoxelShapes.fullCube(), false);
        this.setDefaultState(this.stateManager.getDefaultState().with(GLOWY, false));
    }

    public static ToIntFunction<BlockState> glowIfGlowy() {
        return (state) -> state.get(GLOWY) ? 10 : 0;
    }

    public static boolean randomTorF() {
        return new Random().nextInt(5) == 1;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(GLOWY, randomTorF());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GLOWY);
    }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) UGBlocks.droopvine_top;
    }
}
