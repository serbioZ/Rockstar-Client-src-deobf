// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUpdateSign;
import org.lwjgl.input.Keyboard;
import java.io.IOException;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.client.gui.GuiScreen;

public class GuiEditSign extends GuiScreen
{
    private final /* synthetic */ TileEntitySign tileSign;
    private /* synthetic */ int updateCounter;
    private /* synthetic */ GuiButton doneBtn;
    private /* synthetic */ int editLine;
    
    @Override
    public void drawScreen(final int llllllllllllllIIlIIIIlIIlllIIIIl, final int llllllllllllllIIlIIIIlIIlllIIIII, final float llllllllllllllIIlIIIIlIIllIlllll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("sign.edit", new Object[0]), this.width / 2, 40, 16777215);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(this.width / 2), 0.0f, 50.0f);
        final float llllllllllllllIIlIIIIlIIllIllllI = 93.75f;
        GlStateManager.scale(-93.75f, -93.75f, -93.75f);
        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
        final Block llllllllllllllIIlIIIIlIIllIlllIl = this.tileSign.getBlockType();
        if (llllllllllllllIIlIIIIlIIllIlllIl == Blocks.STANDING_SIGN) {
            final float llllllllllllllIIlIIIIlIIllIlllII = this.tileSign.getBlockMetadata() * 360 / 16.0f;
            GlStateManager.rotate(llllllllllllllIIlIIIIlIIllIlllII, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -1.0625f, 0.0f);
        }
        else {
            final int llllllllllllllIIlIIIIlIIllIllIll = this.tileSign.getBlockMetadata();
            float llllllllllllllIIlIIIIlIIllIllIlI = 0.0f;
            if (llllllllllllllIIlIIIIlIIllIllIll == 2) {
                llllllllllllllIIlIIIIlIIllIllIlI = 180.0f;
            }
            if (llllllllllllllIIlIIIIlIIllIllIll == 4) {
                llllllllllllllIIlIIIIlIIllIllIlI = 90.0f;
            }
            if (llllllllllllllIIlIIIIlIIllIllIll == 5) {
                llllllllllllllIIlIIIIlIIllIllIlI = -90.0f;
            }
            GlStateManager.rotate(llllllllllllllIIlIIIIlIIllIllIlI, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -1.0625f, 0.0f);
        }
        if (this.updateCounter / 6 % 2 == 0) {
            this.tileSign.lineBeingEdited = this.editLine;
        }
        TileEntityRendererDispatcher.instance.renderTileEntityAt(this.tileSign, -0.5, -0.75, -0.5, 0.0f);
        this.tileSign.lineBeingEdited = -1;
        GlStateManager.popMatrix();
        super.drawScreen(llllllllllllllIIlIIIIlIIlllIIIIl, llllllllllllllIIlIIIIlIIlllIIIII, llllllllllllllIIlIIIIlIIllIlllll);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIIlIIIIlIIlllIllIl, final int llllllllllllllIIlIIIIlIIlllIllII) throws IOException {
        if (llllllllllllllIIlIIIIlIIlllIllII == 200) {
            this.editLine = (this.editLine - 1 & 0x3);
        }
        if (llllllllllllllIIlIIIIlIIlllIllII == 208 || llllllllllllllIIlIIIIlIIlllIllII == 28 || llllllllllllllIIlIIIIlIIlllIllII == 156) {
            this.editLine = (this.editLine + 1 & 0x3);
        }
        String llllllllllllllIIlIIIIlIIlllIllll = this.tileSign.signText[this.editLine].getUnformattedText();
        if (llllllllllllllIIlIIIIlIIlllIllII == 14 && !llllllllllllllIIlIIIIlIIlllIllll.isEmpty()) {
            llllllllllllllIIlIIIIlIIlllIllll = llllllllllllllIIlIIIIlIIlllIllll.substring(0, llllllllllllllIIlIIIIlIIlllIllll.length() - 1);
        }
        if (ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIIlIIIIlIIlllIllIl) && this.fontRendererObj.getStringWidth(String.valueOf(llllllllllllllIIlIIIIlIIlllIllll) + llllllllllllllIIlIIIIlIIlllIllIl) <= 90) {
            llllllllllllllIIlIIIIlIIlllIllll = String.valueOf(llllllllllllllIIlIIIIlIIlllIllll) + llllllllllllllIIlIIIIlIIlllIllIl;
        }
        this.tileSign.signText[this.editLine] = new TextComponentString(llllllllllllllIIlIIIIlIIlllIllll);
        if (llllllllllllllIIlIIIIlIIlllIllII == 1) {
            this.actionPerformed(this.doneBtn);
        }
    }
    
    @Override
    public void updateScreen() {
        ++this.updateCounter;
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        final NetHandlerPlayClient llllllllllllllIIlIIIIlIlIIIIIIlI = this.mc.getConnection();
        if (llllllllllllllIIlIIIIlIlIIIIIIlI != null) {
            llllllllllllllIIlIIIIlIlIIIIIIlI.sendPacket(new CPacketUpdateSign(this.tileSign.getPos(), this.tileSign.signText));
        }
        this.tileSign.setEditable(true);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIlIIIIlIIllllIlll) throws IOException {
        if (llllllllllllllIIlIIIIlIIllllIlll.enabled && llllllllllllllIIlIIIIlIIllllIlll.id == 0) {
            this.tileSign.markDirty();
            this.mc.displayGuiScreen(null);
        }
    }
    
    public GuiEditSign(final TileEntitySign llllllllllllllIIlIIIIlIlIIIIlIIl) {
        this.tileSign = llllllllllllllIIlIIIIlIlIIIIlIIl;
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.doneBtn = this.addButton(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, I18n.format("gui.done", new Object[0])));
        this.tileSign.setEditable(false);
    }
}
