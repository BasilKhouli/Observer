package mod.basil.observer;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static org.lwjgl.glfw.GLFW.*;

@OnlyIn(Dist.CLIENT)
public class ObserverKeyBinds {

    public static final KeyMapping KEY_RECORDING_START = new KeyMapping("key.record.start", GLFW_KEY_O, "key.category.observer");
    public static final KeyMapping KEY_RECORDING_STOP = new KeyMapping("key.record.stop", GLFW_KEY_P, "key.category.observer");
    public static final KeyMapping KEY_RECORDING_PLAY = new KeyMapping("key.record.play", GLFW_KEY_K, "key.category.observer");
    public static final KeyMapping KEY_RECORDING_PAUSE = new KeyMapping("key.record.pause", GLFW_KEY_L, "key.category.observer");
    public static final KeyMapping KEY_RECORDING_CLEAR = new KeyMapping("key.record.clear", GLFW_KEY_M, "key.category.observer");
}
