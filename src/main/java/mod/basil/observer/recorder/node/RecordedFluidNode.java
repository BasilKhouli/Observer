//package mod.basil.observer.recorder.node;
//
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.material.Fluid;
//import net.minecraft.world.level.material.FluidState;
//import net.minecraft.world.level.material.FlowingFluid;
//
//import net.minecraft.world.level.Level;
//
//public abstract class RecordedFluidNode extends RecordedEntityNode {
//    protected final BlockPos position;
//    protected final Fluid fluid;
//    protected final FluidState fluidState;
//    protected final FlowingFluid flowingFluid;
//
//    public RecordedFluidNode(final Level level, final int entityID, final BlockPos position, final Fluid fluid, final FluidState fluidState, final FlowingFluid flowingFluid) {
//        super(level, entityID);
//        this.position = position;
//        this.fluid = fluid;
//        this.fluidState = fluidState;
//        this.flowingFluid = flowingFluid;
//    }
//}
