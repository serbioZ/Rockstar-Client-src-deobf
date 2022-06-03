// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.client.resources.I18n;
import java.io.IOException;

public class GuiSleepMP extends GuiChat
{
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIllIlIIlIIllllIIIII) throws IOException {
        if (lllllllllllllIllIlIIlIIllllIIIII.id == 1) {
            this.wakeFromSleep();
        }
        else {
            super.actionPerformed(lllllllllllllIllIlIIlIIllllIIIII);
        }
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height - 40, I18n.format("multiplayer.stopSleeping", new Object[0])));
    }
    
    private void wakeFromSleep() {
        final NetHandlerPlayClient lllllllllllllIllIlIIlIIlllIllIlI = this.mc.player.connection;
        lllllllllllllIllIlIIlIIlllIllIlI.sendPacket(new CPacketEntityAction(this.mc.player, CPacketEntityAction.Action.STOP_SLEEPING));
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIllIlIIlIIllllIlIlI, final int lllllllllllllIllIlIIlIIllllIlIIl) throws IOException {
        if (lllllllllllllIllIlIIlIIllllIlIIl == 1) {
            this.wakeFromSleep();
        }
        else if (lllllllllllllIllIlIIlIIllllIlIIl != 28 && lllllllllllllIllIlIIlIIllllIlIIl != 156) {
            super.keyTyped(lllllllllllllIllIlIIlIIllllIlIlI, lllllllllllllIllIlIIlIIllllIlIIl);
        }
        else {
            final String lllllllllllllIllIlIIlIIllllIlIII = this.inputField.getText().trim();
            if (!lllllllllllllIllIlIIlIIllllIlIII.isEmpty()) {
                this.mc.player.sendChatMessage(lllllllllllllIllIlIIlIIllllIlIII);
            }
            this.inputField.setText("");
            this.mc.ingameGUI.getChatGUI().resetScroll();
        }
    }
}
