package mod.basil.observer.command;

import mod.basil.observer.Observer;
import mod.basil.observer.recorder.RecordingManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class RecordingCommand extends IClientCommand {

    public boolean execute(Player player, String[] args) {

        // Fetch the Minecraft client instance
        final var mc = Minecraft.getInstance();
        final var recordingManager = Observer.getInstance().recordingManager;

        if (args.length >= 1) {

            String arg = args[0];

            switch (arg) {
                case "start" -> {
                    mc.gui.getChat().addMessage(Component.literal("Started recording!"));
                    recordingManager.startRecording(mc);
                    return true;
                }
                case "stop" -> {
                    mc.gui.getChat().addMessage(Component.literal("Stopped recording!"));
                    recordingManager.stopRecording(mc);
                    return true;
                }
                case "play" -> {
                    mc.gui.getChat().addMessage(Component.literal("Playing recording!"));
                    recordingManager.playRecording(mc);
                    return true;
                }
                case "reset" -> {
                    if (recordingManager.getStatus() != RecordingManager.RecordingStatus.IDLE) {
                        mc.gui.getChat().addMessage(Component.literal("Cannot reset while recording or playing!"));
                        return true;
                    }

                    mc.gui.getChat().addMessage(Component.literal("Resetting & clearing recording!"));
                    recordingManager.resetRecording(mc);
                    return true;
                }
            }
        }

        return false;
    }

    public String getPrefix() {
        return "cam";
    }

    public String getUsage() {
        return "<start/stop/reset/add/clear>";
    }
}
