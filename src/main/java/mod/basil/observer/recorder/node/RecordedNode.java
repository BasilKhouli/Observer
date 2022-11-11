package mod.basil.observer.recorder.node;

import net.minecraft.client.Minecraft;

public abstract class RecordedNode {

    public abstract String getName();

    public abstract void trigger(final Minecraft minecraft);

    public abstract void undo(final Minecraft minecraft);
}
