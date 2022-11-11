//package mod.basil.observer.client;
//
//import com.mojang.blaze3d.systems.RenderSystem;
//import mod.basil.observer.Observer;
//import mod.basil.observer.ObserverKeyBinds;
//import net.minecraft.client.gui.GuiComponent;
//import net.minecraft.client.renderer.GameRenderer;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.client.gui.overlay.IGuiOverlay;
//
//public class RecordingHudOverlay {
//    public static final ResourceLocation RECORDING_START = new ResourceLocation(Observer.MOD_ID, "textures/gui/recording_start");
//    public static final ResourceLocation RECORDING_STOP = new ResourceLocation(Observer.MOD_ID, "textures/gui/recording_stop");
//    public static final ResourceLocation RECORDING_PLAY = new ResourceLocation(Observer.MOD_ID, "textures/gui/recording_play");
//    public static final ResourceLocation RECORDING_PAUSE = new ResourceLocation(Observer.MOD_ID, "textures/gui/recording_pause");
//
//    public static final IGuiOverlay HUD_Recording = ((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
//        int x = screenWidth / 2;
//        int y = screenHeight;
//
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//
//        if (ObserverKeyBinds.KEY_RECORDING_START.consumeClick()) {
//            RenderSystem.setShaderTexture(0, RECORDING_START);
//            GuiComponent.blit(poseStack, x - 94, y - 54, 0, 0, 12, 12, 12, 12);
//        }
//    });
//}
