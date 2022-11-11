package mod.basil.observer.recorder.node;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.Level;

public class RecordedBlockBreakNode extends RecordedBlockNode {

    public RecordedBlockBreakNode(final Level level, final int entityID, final BlockPos position, final Block block, final BlockState blockState) {
        super(level, entityID, position, block, blockState);
    }

    @Override
    public void trigger(final Minecraft minecraft) {
        level.setBlockAndUpdate(position, Blocks.AIR.defaultBlockState());
    }

    @Override
    public void undo(final Minecraft minecraft) {
        level.setBlockAndUpdate(position, blockState);
    }

    @Override
    public String getName() {
        return "BlockBreak";
    }
}
