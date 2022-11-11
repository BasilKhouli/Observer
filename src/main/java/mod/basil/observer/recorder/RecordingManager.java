package mod.basil.observer.recorder;

import com.google.common.collect.Lists;
import mod.basil.observer.ObserverKeyBinds;
import mod.basil.observer.recorder.node.RecordedNode;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckForNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RecordingManager {

    private final Map<Integer, List<RecordedNode>> recordedNodes = new TreeMap<>();

    private RecordingStatus status = RecordingStatus.IDLE;
    private boolean paused = false;

    private int maxTick = 0;
    private Integer tick = 0;

    public void onUpdate(final Minecraft minecraft) {

        switch (status) {
            case IDLE:
                onUpdateIdle(minecraft);
                break;
            case RECORDING:
                onUpdateRecording(minecraft);
                break;
            case PLAYING:
                onUpdatePlaying(minecraft);
                break;
        }

        onUpdateKeys(minecraft);
    }

    private void onUpdateKeys(final Minecraft minecraft) {
        if (ObserverKeyBinds.KEY_RECORDING_START.consumeClick()) {
            minecraft.gui.getChat().addMessage(Component.literal("Started recording!"));
            startRecording(minecraft);
            return;
        }
        if (ObserverKeyBinds.KEY_RECORDING_STOP.consumeClick()) {
            minecraft.gui.getChat().addMessage(Component.literal("Stopped recording!"));
            stopRecording(minecraft);
            return;
        }
        if (ObserverKeyBinds.KEY_RECORDING_PLAY.consumeClick()) {
            minecraft.gui.getChat().addMessage(Component.literal("Playing recording!"));
            playRecording(minecraft);
            return;
        }
        if (ObserverKeyBinds.KEY_RECORDING_PAUSE.consumeClick()) {
            setPaused(!paused);
            minecraft.gui.getChat().addMessage(Component.literal(paused ? "Pausing recording!" : "Playing recording!"));
            return;
        }
        if (ObserverKeyBinds.KEY_RECORDING_CLEAR.consumeClick()) {
            if (getStatus() != RecordingManager.RecordingStatus.IDLE) {
                minecraft.gui.getChat().addMessage(Component.literal("Cannot reset while recording or playing!"));
                return;
            }

            minecraft.gui.getChat().addMessage(Component.literal("Resetting & clearing recording!"));
            resetRecording(minecraft);
            return;
        }
    }

    public void addNode(@NotNull final RecordedNode node) {
        if (status != RecordingStatus.RECORDING) return;
        if (paused) return;
        System.out.println("Adding node " + node.getName());
        recordedNodes.computeIfAbsent(tick, (i) -> new ArrayList<>()).add(node);
    }

    @CheckForNull
    public List<RecordedNode> getNodesAtTick(final int tick) {
        return recordedNodes.getOrDefault(tick, null);
    }

    public void stopRecording(final Minecraft minecraft) {
        setStatus(RecordingStatus.IDLE);
        rewindRecording(minecraft);
        tick = 0;
    }

    public void startRecording(final Minecraft minecraft) {
        minecraft.gui.getChat().addMessage(Component.literal("Started recording!"));
        setStatus(RecordingStatus.RECORDING);
        rewindRecording(minecraft);
        tick = 0;
    }

    public void playRecording(final Minecraft minecraft) {
        minecraft.gui.getChat().addMessage(Component.literal("Started playing recording!"));
        setStatus(RecordingStatus.PLAYING);
        tick = 0;
    }

    public void resetRecording(final Minecraft minecraft) {
        setStatus(RecordingStatus.IDLE);
        recordedNodes.clear();
        tick = 0;
    }

    private void onUpdateIdle(final Minecraft minecraft) {

    }

    private void onUpdateRecording(final Minecraft minecraft) {
        tick++;
        if (tick > maxTick) maxTick = tick;
    }

    private void onUpdatePlaying(final Minecraft minecraft) {
        if (paused) return;

        tick++;
        if (tick > maxTick) {
            minecraft.gui.getChat().addMessage(Component.literal("Playing of recording finished!"));
            stopRecording(minecraft);
        }

        final List<RecordedNode> nodesForTick = getNodesAtTick(tick);
        if (nodesForTick == null) return;

        nodesForTick.forEach(node -> {
            System.out.println("Triggering Node " + node.getName());
            node.trigger(minecraft);
        });
    }

    private void rewindRecording(final Minecraft minecraft) {
        for (int i = tick; i > 0; i--) {
            System.out.println("Undoing Index: " + i);
            final List<RecordedNode> nodesForTick = getNodesAtTick(i);
            if (nodesForTick == null) continue;

            for (final var node : Lists.reverse(nodesForTick))
            {
                System.out.println("Undoing Node " + node.getName());
                node.undo(minecraft);
            }
        }

        tick = 0;
    }

    public void setPaused(final boolean paused) {
        this.paused = paused;
    }

    public void setStatus(final RecordingStatus status) {
        this.status = status;
    }

    public RecordingStatus getStatus() {
        return status;
    }

    public MutableComponent getStatusComponent() {
        switch (status) {
            case IDLE:
                return Component.literal("");
            case PLAYING:
                var playingComponent = Component.literal("PLAYING (" + tick + " / " + maxTick +")").withStyle(ChatFormatting.GREEN);

                if (paused) {
                    playingComponent.append(Component.literal(" PAUSED").withStyle(ChatFormatting.RED));
                }

                return playingComponent;
            case RECORDING:
                return Component.literal("RECORDING (" + tick + ")").withStyle(ChatFormatting.RED);
        }

        return Component.literal("");
    }

    public static enum RecordingStatus {
        IDLE,
        RECORDING,
        PLAYING
    }
}
