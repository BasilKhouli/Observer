package mod.basil.observer.command;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public abstract class IClientCommand {

    public void onCommand(final Player player, final String[] args) {

        if (!execute(player, args)) {
            player.sendSystemMessage(Component.literal("Invalid usage!"));
        }
    }

    public abstract boolean execute(final Player player, final String[] args);

    public abstract String getPrefix();

    public abstract String getUsage();
}
