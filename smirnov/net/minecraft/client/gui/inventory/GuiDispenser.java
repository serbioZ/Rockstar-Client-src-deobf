// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiDispenser extends GuiContainer
{
    private final /* synthetic */ InventoryPlayer playerInventory;
    private static final /* synthetic */ ResourceLocation DISPENSER_GUI_TEXTURES;
    public /* synthetic */ IInventory dispenserInventory;
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllIIIlIIllIlIllIlIllI, final int lllllllllllllIIIlIIllIlIllIlIlIl, final int lllllllllllllIIIlIIllIlIllIlIlII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiDispenser.DISPENSER_GUI_TEXTURES);
        final int lllllllllllllIIIlIIllIlIllIlIIll = (this.width - this.xSize) / 2;
        final int lllllllllllllIIIlIIllIlIllIlIIlI = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllIIIlIIllIlIllIlIIll, lllllllllllllIIIlIIllIlIllIlIIlI, 0, 0, this.xSize, this.ySize);
    }
    
    static {
        DISPENSER_GUI_TEXTURES = new ResourceLocation("textures/gui/container/dispenser.png");
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllIIIlIIllIlIllIlllll, final int lllllllllllllIIIlIIllIlIllIllllI) {
        final String lllllllllllllIIIlIIllIlIllIlllIl = this.dispenserInventory.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(lllllllllllllIIIlIIllIlIllIlllIl, (float)(this.xSize / 2 - this.fontRendererObj.getStringWidth(lllllllllllllIIIlIIllIlIllIlllIl) / 2), 6.0f, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
    }
    
    public GuiDispenser(final InventoryPlayer lllllllllllllIIIlIIllIlIllllIIII, final IInventory lllllllllllllIIIlIIllIlIlllIllll) {
        super(new ContainerDispenser(lllllllllllllIIIlIIllIlIllllIIII, lllllllllllllIIIlIIllIlIlllIllll));
        this.playerInventory = lllllllllllllIIIlIIllIlIllllIIII;
        this.dispenserInventory = lllllllllllllIIIlIIllIlIlllIllll;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIlIIllIlIlllIlIIl, final int lllllllllllllIIIlIIllIlIlllIIlII, final float lllllllllllllIIIlIIllIlIlllIIlll) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllllIIIlIIllIlIlllIlIIl, lllllllllllllIIIlIIllIlIlllIIlII, lllllllllllllIIIlIIllIlIlllIIlll);
        this.func_191948_b(lllllllllllllIIIlIIllIlIlllIlIIl, lllllllllllllIIIlIIllIlIlllIIlII);
    }
}
