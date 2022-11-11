package mod.basil.observer.recorder.node;

import net.minecraft.world.level.Level;

public abstract class RecordedEntityNode extends RecordedWorldNode {

    private final int entityID;

    public RecordedEntityNode(final Level level, final int entityID) {
        super(level);
        this.entityID = entityID;
    }

    public int getEntityId() {
        return entityID;
    }
}
