// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerHopper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.inventory.IInventory;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiHopper extends GuiContainer
{
    private final /* synthetic */ IInventory playerInventory;
    private final /* synthetic */ IInventory hopperInventory;
    private static final /* synthetic */ ResourceLocation HOPPER_GUI_TEXTURE;
    
    @Override
    public void drawScreen(final int lllllllllllIlIIlIIlIllllllIlIIII, final int lllllllllllIlIIlIIlIllllllIlIIll, final float lllllllllllIlIIlIIlIllllllIlIIlI) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllIlIIlIIlIllllllIlIIII, lllllllllllIlIIlIIlIllllllIlIIll, lllllllllllIlIIlIIlIllllllIlIIlI);
        this.func_191948_b(lllllllllllIlIIlIIlIllllllIlIIII, lllllllllllIlIIlIIlIllllllIlIIll);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIlIIlIIlIllllllIIlIll, final int lllllllllllIlIIlIIlIllllllIIlIlI) {
        this.fontRendererObj.drawString(this.hopperInventory.getDisplayName().getUnformattedText(), 8.0f, 6.0f, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
    }
    
    static {
        HOPPER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/hopper.png");
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllIlIIlIIlIllllllIIIlII, final int lllllllllllIlIIlIIlIllllllIIIIll, final int lllllllllllIlIIlIIlIllllllIIIIlI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiHopper.HOPPER_GUI_TEXTURE);
        final int lllllllllllIlIIlIIlIllllllIIIIIl = (this.width - this.xSize) / 2;
        final int lllllllllllIlIIlIIlIllllllIIIIII = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllIlIIlIIlIllllllIIIIIl, lllllllllllIlIIlIIlIllllllIIIIII, 0, 0, this.xSize, this.ySize);
    }
    
    public GuiHopper(final InventoryPlayer lllllllllllIlIIlIIlIllllllIllllI, final IInventory lllllllllllIlIIlIIlIllllllIllIlI) {
        super(new ContainerHopper(lllllllllllIlIIlIIlIllllllIllllI, lllllllllllIlIIlIIlIllllllIllIlI, Minecraft.getMinecraft().player));
        this.playerInventory = lllllllllllIlIIlIIlIllllllIllllI;
        this.hopperInventory = lllllllllllIlIIlIIlIllllllIllIlI;
        this.allowUserInput = false;
        this.ySize = 133;
    }
}
