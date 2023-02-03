package graphicsEngineExtension.windows;

import graphicsEngine.presets.SimpleOverlay;
import graphicsEngine.windows.WindowConfig;
import graphicsEngine.windows.WindowManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.event.ActionListener;
import java.util.List;

//TODO: incorporate these features into AbstractLayeredWindow
public abstract class ExtendedLayeredWindow extends KeyboardListenableWindow {
    /**
     * For determining the "enabled" state of non-overlay listeners
     */
    public boolean pageListenersEnabled;

    public ExtendedLayeredWindow(@NotNull WindowManager windowManager,
                                 @NotNull WindowConfig config,
                                 @Nullable List<@Nullable ActionListener> actionListenerList,
                                 @Nullable SimpleOverlay overlay) {
        super(
                windowManager,
                config,
                actionListenerList,
                overlay);
        setPageListenersEnabled(true);
    }

    private void setPageListenersEnabled(boolean state) {
        pageListenersEnabled = state;
    }

    private void togglePageListenersEnabled() {
        setPageListenersEnabled(!pageListenersEnabled);
    }

    //TODO: add javadoc
    @Override
    public final void showOverlay() {
        setPageListenersEnabled(false);
        super.showOverlay();
    }

    //TODO: add javadoc
    @Override
    public final void hideOverlay() {
        super.hideOverlay();
        setPageListenersEnabled(true);
    }

    //TODO: add javadoc
    @Override
    public final void toggleOverlay() {
        togglePageListenersEnabled();
        super.toggleOverlay();
    }
}