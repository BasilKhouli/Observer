package mod.basil.observer.recorder.node;

import net.minecraft.world.level.Level;

public abstract class RecordedWorldNode extends RecordedNode {

    final Level level;

    public RecordedWorldNode(final Level level) {
        this.level = level;
    }

}
