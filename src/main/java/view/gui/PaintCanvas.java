package view.gui;

import javax.swing.JComponent;
import java.awt.*;
import model.Picture.Picture;
import model.Picture.SelectList;
import model.interfaces.IShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PaintCanvas is responsible for responding to the graphics system when it
 * is time to update the display.  This is a boundary class so very little code
 * should be added here.
 */
public class PaintCanvas extends JComponent {
    Picture picture;
    SelectList selectList;
    public PaintCanvas(Picture picture, SelectList selectList) {
        this.picture=picture;
        this.selectList = selectList;
    }

    private static final Logger log = LoggerFactory.getLogger(PaintCanvas.class);

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    @Override
    /**
     * This is an event handler.  If this function gets called, its time to
     * draw the entire picture.
     * It you want to force a paint event, call aPaintCanvas.repaint()
     */
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        for(IShape shape : picture.getPicture()){
            shape.draw(graphics2d);
        }
        for(IShape shape : selectList.getSelect()) {
            shape.drawOutline(graphics2d);
        }


    }
}
