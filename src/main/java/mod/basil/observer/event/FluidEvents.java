//package mod.basil.observer.event;
//
//import mod.basil.observer.Observer;
//import mod.basil.observer.recorder.node.RecordedBlockPlaceNode;
//import mod.basil.observer.recorder.node.RecordedFluidPlaceNode;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.event.level.BlockEvent;
//import net.minecraft.world.level.Level;
//@OnlyIn(Dist.CLIENT)
//public class FluidEvents {
//
//    public static void onFluidPlace(final BlockEvent.FluidPlaceBlockEvent) {
//        System.out.println("Fluid place was heard!");
//        Observer.getInstance().recordingManager.addNode(new RecordedFluidPlaceNode(Level));
//    }
//}
