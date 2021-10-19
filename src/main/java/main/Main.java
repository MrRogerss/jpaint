package main;

import controller.EventConnector;
import controller.EventConnectorImpl;
import controller.KeyboardInterface;
import controller.MouseHandler;
import controller.command.CommandController;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import model.Picture.Picture;
import model.Picture.SelectList;
import model.interfaces.IShape;
import model.interfaces.UserChoices;
import model.persistence.UserChoicesImpl;
import view.gui.Gui;
import view.gui.GuiWindowImpl;
import view.gui.PaintCanvas;
import view.interfaces.GuiWindow;
import view.interfaces.UiModule;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Picture picture = new Picture();
        SelectList selectList = new SelectList();
        PaintCanvas paintCanvas = new PaintCanvas(picture);
        GuiWindow guiWindow = new GuiWindowImpl(paintCanvas);
        UiModule uiModule = new Gui(guiWindow);
        UserChoices appState = new UserChoicesImpl(uiModule);
        CommandController commandController = new CommandController(appState,picture,selectList,paintCanvas);
        EventConnector controller = new EventConnectorImpl(uiModule, appState,commandController);

        KeyboardInterface keys = new KeyboardInterface(paintCanvas, appState);
        keys.setup();

        MouseHandler mouse = new MouseHandler(commandController);
        paintCanvas.addMouseListener(mouse);
        controller.setup();

        Thread.sleep(500);

        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        paintCanvas.paintComponent(graphics2d);
        paintCanvas.repaint();


    }
}
