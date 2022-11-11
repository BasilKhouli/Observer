package mod.basil.observer.event;

import mod.basil.observer.Observer;
import mod.basil.observer.recorder.node.RecordedBlockBreakNode;
import mod.basil.observer.recorder.node.RecordedBlockPlaceNode;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.level.BlockEvent;

@OnlyIn(Dist.CLIENT)
public class BlockEvents {

    public static void onBlockPlace(final BlockEvent.EntityPlaceEvent event) {
        System.out.println("Block place was heard!");
        Observer.getInstance().recordingManager.addNode(new RecordedBlockPlaceNode((Level) event.getLevel(), event.getEntity() != null ? event.getEntity().getId() : -1, event.getPos(), event.getState().getBlock(), event.getState()));
    }

    public static void onBlockBreak(final BlockEvent.BreakEvent event) {
        System.out.println("Block break was heard!");
        Observer.getInstance().recordingManager.addNode(new RecordedBlockBreakNode((Level) event.getLevel(), event.getPlayer().getId(), event.getPos(), event.getState().getBlock(), event.getState()));
    }
}
