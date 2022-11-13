package mod.basil.observer.recorder.node;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.Level;

public abstract class RecordedBlockNode extends RecordedEntityNode {

    protected final BlockPos position;

    protected final Block block;
    protected final BlockState blockState;

    public RecordedBlockNode(final Level level, final int entityID, final BlockPos position, final Block block, final BlockState blockState) {
        super(level, entityID);
        this.position = position;
        this.block = block;
        this.blockState = blockState;
    }
}
