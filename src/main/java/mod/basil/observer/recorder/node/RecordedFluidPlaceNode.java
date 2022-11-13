//package mod.basil.observer.recorder.node;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.material.FlowingFluid;
//import net.minecraft.world.level.material.Fluid;
//import net.minecraft.world.level.material.FluidState;
//
//public class RecordedFluidPlaceNode extends RecordedFluidNode {
//    public RecordedFluidPlaceNode(final Level level, final int entityID, final BlockPos position, final Fluid fluid, final FluidState fluidState, final FlowingFluid flowingFluid) {
//        super(level, entityID, position, fluid, fluidState, flowingFluid);
//    }
//    @Override
//    public void trigger(final Minecraft minecraft) {
//        level.setBlockAndUpdate(position, fluidState.createLegacyBlock());
//    }
//
//    @Override
//    public void undo(final Minecraft minecraft) {
//        level.setBlockAndUpdate(position, Blocks.AIR.defaultBlockState());
//    }
//
//    @Override
//    public String getName() {
//        return "FluidPlace";
//    }
//}
//
