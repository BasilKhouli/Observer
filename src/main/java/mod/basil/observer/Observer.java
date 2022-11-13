package mod.basil.observer;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.basil.observer.command.IClientCommand;
import mod.basil.observer.command.RecordingCommand;
import mod.basil.observer.event.BlockEvents;
import mod.basil.observer.recorder.RecordingManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

import java.util.ArrayList;
import java.util.List;

@Mod(Observer.MOD_ID)
public class Observer {

    /**
     * The mod id for this {@link Observer} mod container
     */
    public static final String MOD_ID = "observer";

    /**
     * The static instance of {@link Observer}
     */
    private static Observer MOD_INSTANCE;

    public RecordingManager recordingManager;

    /**
     * Default Constructor for the Observer mod
     */
    public Observer() {
        MOD_INSTANCE = this;

        // If the mod is not client-side, return early
        if (!isClientSide()) return;

        // Fetch the mod event bus and register client events
        final var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::onClientSetupEvent);
        modEventBus.addListener(this::onClientKeyMappingsRegistry);
    }

    @OnlyIn(Dist.CLIENT)
    private void onClientSetupEvent(final FMLClientSetupEvent event) {
        recordingManager = new RecordingManager();
        MinecraftForge.EVENT_BUS.addListener(this::onClientTickEvent);
        MinecraftForge.EVENT_BUS.addListener(this::onRenderEvent);

        MinecraftForge.EVENT_BUS.addListener(BlockEvents::onBlockBreak);
        MinecraftForge.EVENT_BUS.addListener(BlockEvents::onBlockPlace);
    }

    @OnlyIn(Dist.CLIENT)
    public void onClientKeyMappingsRegistry(final RegisterKeyMappingsEvent event) {
        event.register(ObserverKeyBinds.KEY_RECORDING_START);
        event.register(ObserverKeyBinds.KEY_RECORDING_STOP);
        event.register(ObserverKeyBinds.KEY_RECORDING_PLAY);
        event.register(ObserverKeyBinds.KEY_RECORDING_PAUSE);
        event.register(ObserverKeyBinds.KEY_RECORDING_CLEAR);
    }

    @OnlyIn(Dist.CLIENT)
    public void onClientTickEvent(final TickEvent.LevelTickEvent event) {
        if(event.phase != TickEvent.Phase.END || event.level.isClientSide) return;

        recordingManager.onUpdate(Minecraft.getInstance());
    }

    @OnlyIn(Dist.CLIENT)
    public void onRenderEvent(final TickEvent.RenderTickEvent event) {
        if(event.phase != TickEvent.Phase.END) return;

        final var mc = Minecraft.getInstance();
        mc.font.draw(new PoseStack(), recordingManager.getStatusComponent(), 5, 5, 0xFFFFFF);
    }

    /**
     * Determines whether the Minecraft instance is client or server side
     *
     * @return - Returns True/False - Yes, client-side/No, not client-side
     */
    public static boolean isClientSide() {
        return FMLEnvironment.dist == Dist.CLIENT;
    }

    /**
     * Useful method for fetching the {@link Observer} mod instance
     *
     * @return - Returns the static mod instance
     */
    public static Observer getInstance() {
        return MOD_INSTANCE;
    }
}
