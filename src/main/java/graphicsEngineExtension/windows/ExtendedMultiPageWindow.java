package graphicsEngineExtension.windows;

import graphicsEngine.presets.SimpleOverlay;
import graphicsEngine.windows.WindowConfig;
import graphicsEngine.windows.WindowManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.event.ActionListener;
import java.util.List;

/**
 * TODO:
 *      move keyboardListener to higher level of abstraction
 *      extend this from MultiPageWindow
 *      add javadocs where needed
 */
public abstract class ExtendedMultiPageWindow extends ExtendedLayeredWindow  {
    private final @Nullable String mainPageKey;

    //TODO: add javadoc
    public ExtendedMultiPageWindow(@NotNull WindowManager windowManager,
                                   @NotNull WindowConfig config,
                                   @Nullable List<@Nullable ActionListener> actionListenerList,
                                   @Nullable SimpleOverlay overlay,
                                   @Nullable String mainPageKey) {
        super(
                windowManager,
                config,
                actionListenerList,
                overlay);
        // icon paths don't work after graphicsEngine compilation! TODO: fix
        //setIcon(graphicsEngine.Utilities.getSampleIcon());
        this.mainPageKey = mainPageKey;
        switchToMainPage();
    }

    //TODO: add javadoc
    @Override
    public final void setActivePage(@Nullable String key) {
        super.setActivePage(key);
        hideOverlay();
    }

    //TODO: add javadoc
    public final void switchToMainPage() {
        setActivePage(mainPageKey);
    }
}