//package mod.basil.observer.recorder.node;
//
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.material.Fluid;
//import net.minecraft.world.level.material.FluidState;
//import net.minecraft.world.level.material.FlowingFluid;
//import net.minecraftforge.event.level.BlockEvent.FluidPlaceBlockEvent;
//
//import net.minecraft.world.level.Level;
//
//public abstract class RecordedFluidNode {
//    protected final BlockPos position;
//    protected final Fluid fluid;
//    protected final BlockState blockState;
//    protected final BlockPos liquidPos;
//
//    public RecordedFluidNode(final Level level, final int entityID, final BlockPos position, final BlockPos liquidPos, final Fluid fluid, final BlockState blockState) {
//        super(level, entityID);
//        this.liquidPos = liquidPos;
//        this.position = position;
//        this.fluid = fluid;
//        this.blockState = blockState;
//
//
//
//    }
//}
