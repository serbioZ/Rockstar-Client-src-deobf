// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.api.event.EventTarget;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.gui.GuiChat;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.Feature;

public class GuiMove extends Feature
{
    @Override
    public void onDisable() {
        GuiMove.mc.gameSettings.keyBindJump.pressed = false;
        GuiMove.mc.gameSettings.keyBindForward.pressed = false;
        GuiMove.mc.gameSettings.keyBindBack.pressed = false;
        GuiMove.mc.gameSettings.keyBindLeft.pressed = false;
        GuiMove.mc.gameSettings.keyBindRight.pressed = false;
        GuiMove.mc.gameSettings.keyBindSprint.pressed = false;
        super.onDisable();
    }
    
    public GuiMove() {
        super("GuiWalk", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0445\u043e\u0434\u0438\u0442\u044c \u0432 \u043e\u0442\u043a\u0440\u044b\u0442\u043e\u043c \u043a\u043e\u043d\u0442\u0435\u0439\u043d\u0435\u0440\u0435 (\u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c,\u0441\u0443\u043d\u0434\u0443\u043a \u0438 \u0442.\u0434)", 0, Category.PLAYER);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIIIlIIllIllllIIllllIl) {
        if (!(GuiMove.mc.currentScreen instanceof GuiChat)) {
            GuiMove.mc.gameSettings.keyBindJump.pressed = Keyboard.isKeyDown(GuiMove.mc.gameSettings.keyBindJump.getKeyCode());
            GuiMove.mc.gameSettings.keyBindForward.pressed = Keyboard.isKeyDown(GuiMove.mc.gameSettings.keyBindForward.getKeyCode());
            GuiMove.mc.gameSettings.keyBindBack.pressed = Keyboard.isKeyDown(GuiMove.mc.gameSettings.keyBindBack.getKeyCode());
            GuiMove.mc.gameSettings.keyBindLeft.pressed = Keyboard.isKeyDown(GuiMove.mc.gameSettings.keyBindLeft.getKeyCode());
            GuiMove.mc.gameSettings.keyBindRight.pressed = Keyboard.isKeyDown(GuiMove.mc.gameSettings.keyBindRight.getKeyCode());
            GuiMove.mc.gameSettings.keyBindSprint.pressed = Keyboard.isKeyDown(GuiMove.mc.gameSettings.keyBindSprint.getKeyCode());
        }
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
    }
}
