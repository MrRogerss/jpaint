package controller;

import controller.command.CommandController;
import controller.command.CommandHistory;
import controller.command.CopyCommand;
import controller.command.PasteCommand;
import model.Picture.Picture;
import model.Picture.SelectList;
import model.interfaces.UserChoices;
import view.EventName;
import view.interfaces.UiModule;

/**
 * @see controller.EventConnector
 */
public class EventConnectorImpl implements EventConnector {
    private final UiModule uiModule;
    private final UserChoices userChoices;
    private final CommandController commandController;
    private final SelectList selectList;
    private final Picture picture;

    public EventConnectorImpl(UiModule uiModule, UserChoices userChoices,CommandController commandController, SelectList selectList, Picture picture) {
        this.uiModule = uiModule;
        this.userChoices = userChoices;
        this.commandController = commandController;
        this.selectList = selectList;
        this.picture = picture;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> userChoices.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> userChoices.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> userChoices.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> userChoices.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> userChoices.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, commandController::onUndo);
        uiModule.addEvent(EventName.REDO, commandController::onRedo);
        uiModule.addEvent(EventName.COPY, commandController::onCopy);
        uiModule.addEvent(EventName.PASTE, commandController::onPaste);
    }
}
