// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCustomPayload;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;
import java.io.IOException;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.TabCompleter;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ITabCompleter;
import net.minecraft.client.gui.GuiScreen;

public class GuiEditCommandBlockMinecart extends GuiScreen implements ITabCompleter
{
    private /* synthetic */ GuiButton cancelButton;
    private final /* synthetic */ CommandBlockBaseLogic commandBlockLogic;
    private /* synthetic */ boolean trackOutput;
    private /* synthetic */ GuiButton doneButton;
    private /* synthetic */ GuiButton outputButton;
    private /* synthetic */ TabCompleter tabCompleter;
    private /* synthetic */ GuiTextField commandField;
    private /* synthetic */ GuiTextField previousEdit;
    
    public GuiEditCommandBlockMinecart(final CommandBlockBaseLogic lllllllllllIlllIIllllIIllIIIllII) {
        this.commandBlockLogic = lllllllllllIlllIIllllIIllIIIllII;
    }
    
    @Override
    public void updateScreen() {
        this.commandField.updateCursorCounter();
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIlllIIllllIIlIlllIIlI, final int lllllllllllIlllIIllllIIlIlllIIIl) throws IOException {
        this.tabCompleter.resetRequested();
        if (lllllllllllIlllIIllllIIlIlllIIIl == 15) {
            this.tabCompleter.complete();
        }
        else {
            this.tabCompleter.resetDidComplete();
        }
        this.commandField.textboxKeyTyped(lllllllllllIlllIIllllIIlIlllIIlI, lllllllllllIlllIIllllIIlIlllIIIl);
        this.previousEdit.textboxKeyTyped(lllllllllllIlllIIllllIIlIlllIIlI, lllllllllllIlllIIllllIIlIlllIIIl);
        this.doneButton.enabled = !this.commandField.getText().trim().isEmpty();
        if (lllllllllllIlllIIllllIIlIlllIIIl != 28 && lllllllllllIlllIIllllIIlIlllIIIl != 156) {
            if (lllllllllllIlllIIllllIIlIlllIIIl == 1) {
                this.actionPerformed(this.cancelButton);
            }
        }
        else {
            this.actionPerformed(this.doneButton);
        }
    }
    
    @Override
    public void setCompletions(final String... lllllllllllIlllIIllllIIlIlIIlIlI) {
        this.tabCompleter.setCompletions(lllllllllllIlllIIllllIIlIlIIlIlI);
    }
    
    private void updateCommandOutput() {
        if (this.commandBlockLogic.shouldTrackOutput()) {
            this.outputButton.displayString = "O";
            if (this.commandBlockLogic.getLastOutput() != null) {
                this.previousEdit.setText(this.commandBlockLogic.getLastOutput().getUnformattedText());
            }
        }
        else {
            this.outputButton.displayString = "X";
            this.previousEdit.setText("-");
        }
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.doneButton = this.addButton(new GuiButton(0, this.width / 2 - 4 - 150, this.height / 4 + 120 + 12, 150, 20, I18n.format("gui.done", new Object[0])));
        this.cancelButton = this.addButton(new GuiButton(1, this.width / 2 + 4, this.height / 4 + 120 + 12, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.outputButton = this.addButton(new GuiButton(4, this.width / 2 + 150 - 20, 150, 20, 20, "O"));
        this.commandField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 150, 50, 300, 20);
        this.commandField.setMaxStringLength(32500);
        this.commandField.setFocused(true);
        this.commandField.setText(this.commandBlockLogic.getCommand());
        this.previousEdit = new GuiTextField(3, this.fontRendererObj, this.width / 2 - 150, 150, 276, 20);
        this.previousEdit.setMaxStringLength(32500);
        this.previousEdit.setEnabled(false);
        this.previousEdit.setText("-");
        this.trackOutput = this.commandBlockLogic.shouldTrackOutput();
        this.updateCommandOutput();
        this.doneButton.enabled = !this.commandField.getText().trim().isEmpty();
        this.tabCompleter = new TabCompleter(this.commandField, true) {
            @Nullable
            @Override
            public BlockPos getTargetBlockPos() {
                return GuiEditCommandBlockMinecart.this.commandBlockLogic.getPosition();
            }
        };
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIlllIIllllIIlIllIlIll, final int lllllllllllIlllIIllllIIlIllIIllI, final int lllllllllllIlllIIllllIIlIllIIlIl) throws IOException {
        super.mouseClicked(lllllllllllIlllIIllllIIlIllIlIll, lllllllllllIlllIIllllIIlIllIIllI, lllllllllllIlllIIllllIIlIllIIlIl);
        this.commandField.mouseClicked(lllllllllllIlllIIllllIIlIllIlIll, lllllllllllIlllIIllllIIlIllIIllI, lllllllllllIlllIIllllIIlIllIIlIl);
        this.previousEdit.mouseClicked(lllllllllllIlllIIllllIIlIllIlIll, lllllllllllIlllIIllllIIlIllIIllI, lllllllllllIlllIIllllIIlIllIIlIl);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlllIIllllIIlIllllllI) throws IOException {
        if (lllllllllllIlllIIllllIIlIllllllI.enabled) {
            if (lllllllllllIlllIIllllIIlIllllllI.id == 1) {
                this.commandBlockLogic.setTrackOutput(this.trackOutput);
                this.mc.displayGuiScreen(null);
            }
            else if (lllllllllllIlllIIllllIIlIllllllI.id == 0) {
                final PacketBuffer lllllllllllIlllIIllllIIlIlllllIl = new PacketBuffer(Unpooled.buffer());
                lllllllllllIlllIIllllIIlIlllllIl.writeByte(this.commandBlockLogic.getCommandBlockType());
                this.commandBlockLogic.fillInInfo(lllllllllllIlllIIllllIIlIlllllIl);
                lllllllllllIlllIIllllIIlIlllllIl.writeString(this.commandField.getText());
                lllllllllllIlllIIllllIIlIlllllIl.writeBoolean(this.commandBlockLogic.shouldTrackOutput());
                this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|AdvCmd", lllllllllllIlllIIllllIIlIlllllIl));
                if (!this.commandBlockLogic.shouldTrackOutput()) {
                    this.commandBlockLogic.setLastOutput(null);
                }
                this.mc.displayGuiScreen(null);
            }
            else if (lllllllllllIlllIIllllIIlIllllllI.id == 4) {
                this.commandBlockLogic.setTrackOutput(!this.commandBlockLogic.shouldTrackOutput());
                this.updateCommandOutput();
            }
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlllIIllllIIlIlIlllIl, final int lllllllllllIlllIIllllIIlIlIlIllI, final float lllllllllllIlllIIllllIIlIlIllIll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("advMode.setCommand", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("advMode.command", new Object[0]), this.width / 2 - 150, 40, 10526880);
        this.commandField.drawTextBox();
        int lllllllllllIlllIIllllIIlIlIllIlI = 75;
        int lllllllllllIlllIIllllIIlIlIllIIl = 0;
        this.drawString(this.fontRendererObj, I18n.format("advMode.nearestPlayer", new Object[0]), this.width / 2 - 140, lllllllllllIlllIIllllIIlIlIllIlI + lllllllllllIlllIIllllIIlIlIllIIl++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.randomPlayer", new Object[0]), this.width / 2 - 140, lllllllllllIlllIIllllIIlIlIllIlI + lllllllllllIlllIIllllIIlIlIllIIl++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.allPlayers", new Object[0]), this.width / 2 - 140, lllllllllllIlllIIllllIIlIlIllIlI + lllllllllllIlllIIllllIIlIlIllIIl++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.allEntities", new Object[0]), this.width / 2 - 140, lllllllllllIlllIIllllIIlIlIllIlI + lllllllllllIlllIIllllIIlIlIllIIl++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.self", new Object[0]), this.width / 2 - 140, lllllllllllIlllIIllllIIlIlIllIlI + lllllllllllIlllIIllllIIlIlIllIIl++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        if (!this.previousEdit.getText().isEmpty()) {
            lllllllllllIlllIIllllIIlIlIllIlI = lllllllllllIlllIIllllIIlIlIllIlI + lllllllllllIlllIIllllIIlIlIllIIl * this.fontRendererObj.FONT_HEIGHT + 20;
            this.drawString(this.fontRendererObj, I18n.format("advMode.previousOutput", new Object[0]), this.width / 2 - 150, lllllllllllIlllIIllllIIlIlIllIlI, 10526880);
            this.previousEdit.drawTextBox();
        }
        super.drawScreen(lllllllllllIlllIIllllIIlIlIlllIl, lllllllllllIlllIIllllIIlIlIlIllI, lllllllllllIlllIIllllIIlIlIllIll);
    }
}
