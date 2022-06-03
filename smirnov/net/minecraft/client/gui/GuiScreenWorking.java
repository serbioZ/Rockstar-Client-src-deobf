// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.util.IProgressUpdate;

public class GuiScreenWorking extends GuiScreen implements IProgressUpdate
{
    private /* synthetic */ String title;
    private /* synthetic */ int progress;
    private /* synthetic */ boolean doneWorking;
    private /* synthetic */ String stage;
    
    @Override
    public void displayLoadingString(final String lllllllllllIIllIlllIllIlIlllIlII) {
        this.stage = lllllllllllIIllIlllIllIlIlllIlII;
        this.setLoadingProgress(0);
    }
    
    @Override
    public void setDoneWorking() {
        this.doneWorking = true;
    }
    
    @Override
    public void displaySavingString(final String lllllllllllIIllIlllIllIllIIIIIlI) {
        this.resetProgressAndMessage(lllllllllllIIllIlllIllIllIIIIIlI);
    }
    
    @Override
    public void setLoadingProgress(final int lllllllllllIIllIlllIllIlIllIlllI) {
        this.progress = lllllllllllIIllIlllIllIlIllIlllI;
    }
    
    @Override
    public void resetProgressAndMessage(final String lllllllllllIIllIlllIllIlIlllllII) {
        this.title = lllllllllllIIllIlllIllIlIlllllII;
        this.displayLoadingString("Working...");
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIllIlllIllIlIllIIIIl, final int lllllllllllIIllIlllIllIlIllIIIII, final float lllllllllllIIllIlllIllIlIlIlllll) {
        if (this.doneWorking) {
            if (!this.mc.isConnectedToRealms()) {
                this.mc.displayGuiScreen(null);
            }
        }
        else {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 70, 16777215);
            this.drawCenteredString(this.fontRendererObj, String.valueOf(this.stage) + " " + this.progress + "%", this.width / 2, 90, 16777215);
            super.drawScreen(lllllllllllIIllIlllIllIlIllIIIIl, lllllllllllIIllIlllIllIlIllIIIII, lllllllllllIIllIlllIllIlIlIlllll);
        }
    }
    
    public GuiScreenWorking() {
        this.title = "";
        this.stage = "";
    }
}
