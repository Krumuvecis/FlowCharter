package graphicsEngineExtension.windows;

import graphicsEngine.presets.SimpleOverlay;
import graphicsEngine.windows.WindowConfig;
import graphicsEngine.windows.WindowManager;
import graphicsEngine.windows.windowTypes.MultiPageWindow;
import graphicsEngineExtension.input.keyboard.KeyboardListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.event.ActionListener;
import java.util.List;

//TODO: incorporate these features into AbstractWindow
public abstract class KeyboardListenableWindow extends MultiPageWindow {
    private final @NotNull KeyboardListener keyboardListener;

    public KeyboardListenableWindow(@NotNull WindowManager windowManager,
                                    @NotNull WindowConfig config,
                                    @Nullable List<@Nullable ActionListener> actionListenerList,
                                    @Nullable SimpleOverlay overlay) {
        super(
                windowManager,
                config,
                actionListenerList,
                overlay);
        keyboardListener = new KeyboardListener();
        addKeyListener(keyboardListener);
    }

    public final @NotNull List<Integer> getPressedKeys() {
        return keyboardListener.getKeys();
    }
}