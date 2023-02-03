package graphicsEngineExtension.input.mouse;

import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * A simple mouse wheel listener.
 */
public class SimpleMouseWheelListener implements MouseWheelListener {
    private final @NotNull MouseActionInterface actionInterface;

    /**
     * Creates a new simple mouse wheel listener.
     *
     * @param actionInterface Reference acton interface.
     */
    public SimpleMouseWheelListener(@NotNull MouseActionInterface actionInterface) {
        this.actionInterface = actionInterface;
    }


    /**
     * Invoked when the mouse wheel is rotated.
     *
     * @param e the event to be processed
     */
    //TODO: add javadoc
    @Override
    public void mouseWheelMoved(@NotNull MouseWheelEvent e) {
        actionInterface.scroll(e.getWheelRotation());
    }
}