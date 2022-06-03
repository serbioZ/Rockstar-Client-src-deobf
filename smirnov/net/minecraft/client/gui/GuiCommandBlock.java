// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.input.Keyboard;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCustomPayload;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.client.resources.I18n;
import java.io.IOException;
import net.minecraft.util.TabCompleter;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.ITabCompleter;

public class GuiCommandBlock extends GuiScreen implements ITabCompleter
{
    private /* synthetic */ boolean automatic;
    private final /* synthetic */ TileEntityCommandBlock commandBlock;
    private /* synthetic */ GuiButton conditionalBtn;
    private /* synthetic */ GuiButton autoExecBtn;
    private /* synthetic */ GuiButton cancelBtn;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
    private /* synthetic */ TileEntityCommandBlock.Mode commandBlockMode;
    private /* synthetic */ GuiTextField previousOutputTextField;
    private /* synthetic */ boolean conditional;
    private /* synthetic */ boolean trackOutput;
    private /* synthetic */ GuiTextField commandTextField;
    private /* synthetic */ GuiButton modeBtn;
    private /* synthetic */ TabCompleter tabCompleter;
    private /* synthetic */ GuiButton outputBtn;
    private /* synthetic */ GuiButton doneBtn;
    
    @Override
    protected void mouseClicked(final int lllllllllllIIIIllllIIlIIlIlIIlII, final int lllllllllllIIIIllllIIlIIlIlIIlll, final int lllllllllllIIIIllllIIlIIlIlIIllI) throws IOException {
        super.mouseClicked(lllllllllllIIIIllllIIlIIlIlIIlII, lllllllllllIIIIllllIIlIIlIlIIlll, lllllllllllIIIIllllIIlIIlIlIIllI);
        this.commandTextField.mouseClicked(lllllllllllIIIIllllIIlIIlIlIIlII, lllllllllllIIIIllllIIlIIlIlIIlll, lllllllllllIIIIllllIIlIIlIlIIllI);
        this.previousOutputTextField.mouseClicked(lllllllllllIIIIllllIIlIIlIlIIlII, lllllllllllIIIIllllIIlIIlIlIIlll, lllllllllllIIIIllllIIlIIlIlIIllI);
    }
    
    @Override
    public void updateScreen() {
        this.commandTextField.updateCursorCounter();
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIIIllllIIlIIlIIllIlI, final int lllllllllllIIIIllllIIlIIlIIllIIl, final float lllllllllllIIIIllllIIlIIlIIllIII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("advMode.setCommand", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("advMode.command", new Object[0]), this.width / 2 - 150, 40, 10526880);
        this.commandTextField.drawTextBox();
        int lllllllllllIIIIllllIIlIIlIIlIlll = 75;
        int lllllllllllIIIIllllIIlIIlIIlIllI = 0;
        this.drawString(this.fontRendererObj, I18n.format("advMode.nearestPlayer", new Object[0]), this.width / 2 - 140, lllllllllllIIIIllllIIlIIlIIlIlll + lllllllllllIIIIllllIIlIIlIIlIllI++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.randomPlayer", new Object[0]), this.width / 2 - 140, lllllllllllIIIIllllIIlIIlIIlIlll + lllllllllllIIIIllllIIlIIlIIlIllI++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.allPlayers", new Object[0]), this.width / 2 - 140, lllllllllllIIIIllllIIlIIlIIlIlll + lllllllllllIIIIllllIIlIIlIIlIllI++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.allEntities", new Object[0]), this.width / 2 - 140, lllllllllllIIIIllllIIlIIlIIlIlll + lllllllllllIIIIllllIIlIIlIIlIllI++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.self", new Object[0]), this.width / 2 - 140, lllllllllllIIIIllllIIlIIlIIlIlll + lllllllllllIIIIllllIIlIIlIIlIllI++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        if (!this.previousOutputTextField.getText().isEmpty()) {
            lllllllllllIIIIllllIIlIIlIIlIlll = lllllllllllIIIIllllIIlIIlIIlIlll + lllllllllllIIIIllllIIlIIlIIlIllI * this.fontRendererObj.FONT_HEIGHT + 1;
            this.drawString(this.fontRendererObj, I18n.format("advMode.previousOutput", new Object[0]), this.width / 2 - 150, lllllllllllIIIIllllIIlIIlIIlIlll + 4, 10526880);
            this.previousOutputTextField.drawTextBox();
        }
        super.drawScreen(lllllllllllIIIIllllIIlIIlIIllIlI, lllllllllllIIIIllllIIlIIlIIllIIl, lllllllllllIIIIllllIIlIIlIIllIII);
    }
    
    public GuiCommandBlock(final TileEntityCommandBlock lllllllllllIIIIllllIIlIIllIlIlIl) {
        this.commandBlockMode = TileEntityCommandBlock.Mode.REDSTONE;
        this.commandBlock = lllllllllllIIIIllllIIlIIllIlIlIl;
    }
    
    private void nextMode() {
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode()[this.commandBlockMode.ordinal()]) {
            case 1: {
                this.commandBlockMode = TileEntityCommandBlock.Mode.AUTO;
                break;
            }
            case 2: {
                this.commandBlockMode = TileEntityCommandBlock.Mode.REDSTONE;
                break;
            }
            case 3: {
                this.commandBlockMode = TileEntityCommandBlock.Mode.SEQUENCE;
                break;
            }
        }
    }
    
    @Override
    public void setCompletions(final String... lllllllllllIIIIllllIIlIIIllllIII) {
        this.tabCompleter.setCompletions(lllllllllllIIIIllllIIlIIIllllIII);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIIIIllllIIlIIlIlIllll, final int lllllllllllIIIIllllIIlIIlIlIlllI) throws IOException {
        this.tabCompleter.resetRequested();
        if (lllllllllllIIIIllllIIlIIlIlIlllI == 15) {
            this.tabCompleter.complete();
        }
        else {
            this.tabCompleter.resetDidComplete();
        }
        this.commandTextField.textboxKeyTyped(lllllllllllIIIIllllIIlIIlIlIllll, lllllllllllIIIIllllIIlIIlIlIlllI);
        this.previousOutputTextField.textboxKeyTyped(lllllllllllIIIIllllIIlIIlIlIllll, lllllllllllIIIIllllIIlIIlIlIlllI);
        if (lllllllllllIIIIllllIIlIIlIlIlllI != 28 && lllllllllllIIIIllllIIlIIlIlIlllI != 156) {
            if (lllllllllllIIIIllllIIlIIlIlIlllI == 1) {
                this.actionPerformed(this.cancelBtn);
            }
        }
        else {
            this.actionPerformed(this.doneBtn);
        }
    }
    
    private void updateAutoExec() {
        if (this.automatic) {
            this.autoExecBtn.displayString = I18n.format("advMode.mode.autoexec.bat", new Object[0]);
        }
        else {
            this.autoExecBtn.displayString = I18n.format("advMode.mode.redstoneTriggered", new Object[0]);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode = GuiCommandBlock.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
        }
        final String lllllllllllIIIIllllIIlIIIlllIllI = (Object)new int[TileEntityCommandBlock.Mode.values().length];
        try {
            lllllllllllIIIIllllIIlIIIlllIllI[TileEntityCommandBlock.Mode.AUTO.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIIIllllIIlIIIlllIllI[TileEntityCommandBlock.Mode.REDSTONE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIIIllllIIlIIIlllIllI[TileEntityCommandBlock.Mode.SEQUENCE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return GuiCommandBlock.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode = (int[])(Object)lllllllllllIIIIllllIIlIIIlllIllI;
    }
    
    public void updateGui() {
        final CommandBlockBaseLogic lllllllllllIIIIllllIIlIIllIIIllI = this.commandBlock.getCommandBlockLogic();
        this.commandTextField.setText(lllllllllllIIIIllllIIlIIllIIIllI.getCommand());
        this.trackOutput = lllllllllllIIIIllllIIlIIllIIIllI.shouldTrackOutput();
        this.commandBlockMode = this.commandBlock.getMode();
        this.conditional = this.commandBlock.isConditional();
        this.automatic = this.commandBlock.isAuto();
        this.updateCmdOutput();
        this.updateMode();
        this.updateConditional();
        this.updateAutoExec();
        this.doneBtn.enabled = true;
        this.outputBtn.enabled = true;
        this.modeBtn.enabled = true;
        this.conditionalBtn.enabled = true;
        this.autoExecBtn.enabled = true;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIIIllllIIlIIlIllllIl) throws IOException {
        if (lllllllllllIIIIllllIIlIIlIllllIl.enabled) {
            final CommandBlockBaseLogic lllllllllllIIIIllllIIlIIlIllllII = this.commandBlock.getCommandBlockLogic();
            if (lllllllllllIIIIllllIIlIIlIllllIl.id == 1) {
                lllllllllllIIIIllllIIlIIlIllllII.setTrackOutput(this.trackOutput);
                this.mc.displayGuiScreen(null);
            }
            else if (lllllllllllIIIIllllIIlIIlIllllIl.id == 0) {
                final PacketBuffer lllllllllllIIIIllllIIlIIlIlllIll = new PacketBuffer(Unpooled.buffer());
                lllllllllllIIIIllllIIlIIlIllllII.fillInInfo(lllllllllllIIIIllllIIlIIlIlllIll);
                lllllllllllIIIIllllIIlIIlIlllIll.writeString(this.commandTextField.getText());
                lllllllllllIIIIllllIIlIIlIlllIll.writeBoolean(lllllllllllIIIIllllIIlIIlIllllII.shouldTrackOutput());
                lllllllllllIIIIllllIIlIIlIlllIll.writeString(this.commandBlockMode.name());
                lllllllllllIIIIllllIIlIIlIlllIll.writeBoolean(this.conditional);
                lllllllllllIIIIllllIIlIIlIlllIll.writeBoolean(this.automatic);
                this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|AutoCmd", lllllllllllIIIIllllIIlIIlIlllIll));
                if (!lllllllllllIIIIllllIIlIIlIllllII.shouldTrackOutput()) {
                    lllllllllllIIIIllllIIlIIlIllllII.setLastOutput(null);
                }
                this.mc.displayGuiScreen(null);
            }
            else if (lllllllllllIIIIllllIIlIIlIllllIl.id == 4) {
                lllllllllllIIIIllllIIlIIlIllllII.setTrackOutput(!lllllllllllIIIIllllIIlIIlIllllII.shouldTrackOutput());
                this.updateCmdOutput();
            }
            else if (lllllllllllIIIIllllIIlIIlIllllIl.id == 5) {
                this.nextMode();
                this.updateMode();
            }
            else if (lllllllllllIIIIllllIIlIIlIllllIl.id == 6) {
                this.conditional = !this.conditional;
                this.updateConditional();
            }
            else if (lllllllllllIIIIllllIIlIIlIllllIl.id == 7) {
                this.automatic = !this.automatic;
                this.updateAutoExec();
            }
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void initGui() {
        final CommandBlockBaseLogic lllllllllllIIIIllllIIlIIllIIllII = this.commandBlock.getCommandBlockLogic();
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.doneBtn = this.addButton(new GuiButton(0, this.width / 2 - 4 - 150, this.height / 4 + 120 + 12, 150, 20, I18n.format("gui.done", new Object[0])));
        this.cancelBtn = this.addButton(new GuiButton(1, this.width / 2 + 4, this.height / 4 + 120 + 12, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.outputBtn = this.addButton(new GuiButton(4, this.width / 2 + 150 - 20, 135, 20, 20, "O"));
        this.modeBtn = this.addButton(new GuiButton(5, this.width / 2 - 50 - 100 - 4, 165, 100, 20, I18n.format("advMode.mode.sequence", new Object[0])));
        this.conditionalBtn = this.addButton(new GuiButton(6, this.width / 2 - 50, 165, 100, 20, I18n.format("advMode.mode.unconditional", new Object[0])));
        this.autoExecBtn = this.addButton(new GuiButton(7, this.width / 2 + 50 + 4, 165, 100, 20, I18n.format("advMode.mode.redstoneTriggered", new Object[0])));
        this.commandTextField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 150, 50, 300, 20);
        this.commandTextField.setMaxStringLength(32500);
        this.commandTextField.setFocused(true);
        this.previousOutputTextField = new GuiTextField(3, this.fontRendererObj, this.width / 2 - 150, 135, 276, 20);
        this.previousOutputTextField.setMaxStringLength(32500);
        this.previousOutputTextField.setEnabled(false);
        this.previousOutputTextField.setText("-");
        this.doneBtn.enabled = false;
        this.outputBtn.enabled = false;
        this.modeBtn.enabled = false;
        this.conditionalBtn.enabled = false;
        this.autoExecBtn.enabled = false;
        this.tabCompleter = new TabCompleter(this.commandTextField, true) {
            @Nullable
            @Override
            public BlockPos getTargetBlockPos() {
                return lllllllllllIIIIllllIIlIIllIIllII.getPosition();
            }
        };
    }
    
    private void updateMode() {
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode()[this.commandBlockMode.ordinal()]) {
            case 1: {
                this.modeBtn.displayString = I18n.format("advMode.mode.sequence", new Object[0]);
                break;
            }
            case 2: {
                this.modeBtn.displayString = I18n.format("advMode.mode.auto", new Object[0]);
                break;
            }
            case 3: {
                this.modeBtn.displayString = I18n.format("advMode.mode.redstone", new Object[0]);
                break;
            }
        }
    }
    
    private void updateConditional() {
        if (this.conditional) {
            this.conditionalBtn.displayString = I18n.format("advMode.mode.conditional", new Object[0]);
        }
        else {
            this.conditionalBtn.displayString = I18n.format("advMode.mode.unconditional", new Object[0]);
        }
    }
    
    private void updateCmdOutput() {
        final CommandBlockBaseLogic lllllllllllIIIIllllIIlIIlIIIllII = this.commandBlock.getCommandBlockLogic();
        if (lllllllllllIIIIllllIIlIIlIIIllII.shouldTrackOutput()) {
            this.outputBtn.displayString = "O";
            if (lllllllllllIIIIllllIIlIIlIIIllII.getLastOutput() != null) {
                this.previousOutputTextField.setText(lllllllllllIIIIllllIIlIIlIIIllII.getLastOutput().getUnformattedText());
            }
        }
        else {
            this.outputBtn.displayString = "X";
            this.previousOutputTextField.setText("-");
        }
    }
}
