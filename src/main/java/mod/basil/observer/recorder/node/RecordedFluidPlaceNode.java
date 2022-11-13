//package mod.basil.observer.recorder.node;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.material.FlowingFluid;
//import net.minecraft.world.level.material.Fluid;
//
//public class RecordedFluidPlaceNode extends RecordedFluidNode {
//    public RecordedFluidPlaceNode(final Level level, final BlockPos position, final BlockPos liquidPos, final Fluid fluid, final BlockState blockState) {
//        super(level, liquidPos, position, fluid, blockState);
//    }
//    @Override
//    public void trigger(final Minecraft minecraft) {
//        level.setBlockAndUpdate(position, blockState);
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
