// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.util.ResourceLocation;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiFurnace extends GuiContainer
{
    private final /* synthetic */ InventoryPlayer playerInventory;
    private final /* synthetic */ IInventory tileFurnace;
    private static final /* synthetic */ ResourceLocation FURNACE_GUI_TEXTURES;
    
    private int getCookProgressScaled(final int llllllllllllIIIIIIIllIllIIIlllIl) {
        final int llllllllllllIIIIIIIllIllIIIlllII = this.tileFurnace.getField(2);
        final int llllllllllllIIIIIIIllIllIIIllIll = this.tileFurnace.getField(3);
        return (llllllllllllIIIIIIIllIllIIIllIll != 0 && llllllllllllIIIIIIIllIllIIIlllII != 0) ? (llllllllllllIIIIIIIllIllIIIlllII * llllllllllllIIIIIIIllIllIIIlllIl / llllllllllllIIIIIIIllIllIIIllIll) : 0;
    }
    
    public GuiFurnace(final InventoryPlayer llllllllllllIIIIIIIllIllIlIIlIll, final IInventory llllllllllllIIIIIIIllIllIlIIIlll) {
        super(new ContainerFurnace(llllllllllllIIIIIIIllIllIlIIlIll, llllllllllllIIIIIIIllIllIlIIIlll));
        this.playerInventory = llllllllllllIIIIIIIllIllIlIIlIll;
        this.tileFurnace = llllllllllllIIIIIIIllIllIlIIIlll;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllllIIIIIIIllIllIIllIlll, final int llllllllllllIIIIIIIllIllIIllIllI) {
        final String llllllllllllIIIIIIIllIllIIllIlIl = this.tileFurnace.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(llllllllllllIIIIIIIllIllIIllIlIl, (float)(this.xSize / 2 - this.fontRendererObj.getStringWidth(llllllllllllIIIIIIIllIllIIllIlIl) / 2), 6.0f, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
    }
    
    private int getBurnLeftScaled(final int llllllllllllIIIIIIIllIllIIIIllll) {
        int llllllllllllIIIIIIIllIllIIIlIIIl = this.tileFurnace.getField(1);
        if (llllllllllllIIIIIIIllIllIIIlIIIl == 0) {
            llllllllllllIIIIIIIllIllIIIlIIIl = 200;
        }
        return this.tileFurnace.getField(0) * llllllllllllIIIIIIIllIllIIIIllll / llllllllllllIIIIIIIllIllIIIlIIIl;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllllIIIIIIIllIllIIlIllIl, final int llllllllllllIIIIIIIllIllIIlIllII, final int llllllllllllIIIIIIIllIllIIlIlIll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiFurnace.FURNACE_GUI_TEXTURES);
        final int llllllllllllIIIIIIIllIllIIlIlIlI = (this.width - this.xSize) / 2;
        final int llllllllllllIIIIIIIllIllIIlIlIIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(llllllllllllIIIIIIIllIllIIlIlIlI, llllllllllllIIIIIIIllIllIIlIlIIl, 0, 0, this.xSize, this.ySize);
        if (TileEntityFurnace.isBurning(this.tileFurnace)) {
            final int llllllllllllIIIIIIIllIllIIlIlIII = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(llllllllllllIIIIIIIllIllIIlIlIlI + 56, llllllllllllIIIIIIIllIllIIlIlIIl + 36 + 12 - llllllllllllIIIIIIIllIllIIlIlIII, 176, 12 - llllllllllllIIIIIIIllIllIIlIlIII, 14, llllllllllllIIIIIIIllIllIIlIlIII + 1);
        }
        final int llllllllllllIIIIIIIllIllIIlIIlll = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(llllllllllllIIIIIIIllIllIIlIlIlI + 79, llllllllllllIIIIIIIllIllIIlIlIIl + 34, 176, 14, llllllllllllIIIIIIIllIllIIlIIlll + 1, 16);
    }
    
    static {
        FURNACE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/furnace.png");
    }
    
    @Override
    public void drawScreen(final int llllllllllllIIIIIIIllIllIIllllIl, final int llllllllllllIIIIIIIllIllIIllllII, final float llllllllllllIIIIIIIllIllIIlllIll) {
        this.drawDefaultBackground();
        super.drawScreen(llllllllllllIIIIIIIllIllIIllllIl, llllllllllllIIIIIIIllIllIIllllII, llllllllllllIIIIIIIllIllIIlllIll);
        this.func_191948_b(llllllllllllIIIIIIIllIllIIllllIl, llllllllllllIIIIIIIllIllIIllllII);
    }
}
