// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerShulkerBox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;

public class GuiShulkerBox extends GuiContainer
{
    private final /* synthetic */ IInventory field_190779_v;
    private final /* synthetic */ InventoryPlayer field_190780_w;
    private static final /* synthetic */ ResourceLocation field_190778_u;
    
    @Override
    public void drawScreen(final int lllllllllllIllIlIllllIIlIIlIIlIl, final int lllllllllllIllIlIllllIIlIIlIIlII, final float lllllllllllIllIlIllllIIlIIlIIlll) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllIllIlIllllIIlIIlIIlIl, lllllllllllIllIlIllllIIlIIlIIlII, lllllllllllIllIlIllllIIlIIlIIlll);
        this.func_191948_b(lllllllllllIllIlIllllIIlIIlIIlIl, lllllllllllIllIlIllllIIlIIlIIlII);
    }
    
    static {
        field_190778_u = new ResourceLocation("textures/gui/container/shulker_box.png");
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllIllIlIllllIIlIIIllIIl, final int lllllllllllIllIlIllllIIlIIIllIII, final int lllllllllllIllIlIllllIIlIIIlIlll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiShulkerBox.field_190778_u);
        final int lllllllllllIllIlIllllIIlIIIlIllI = (this.width - this.xSize) / 2;
        final int lllllllllllIllIlIllllIIlIIIlIlIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllIllIlIllllIIlIIIlIllI, lllllllllllIllIlIllllIIlIIIlIlIl, 0, 0, this.xSize, this.ySize);
    }
    
    public GuiShulkerBox(final InventoryPlayer lllllllllllIllIlIllllIIlIIllIIll, final IInventory lllllllllllIllIlIllllIIlIIlIllll) {
        super(new ContainerShulkerBox(lllllllllllIllIlIllllIIlIIllIIll, lllllllllllIllIlIllllIIlIIlIllll, Minecraft.getMinecraft().player));
        this.field_190780_w = lllllllllllIllIlIllllIIlIIllIIll;
        this.field_190779_v = lllllllllllIllIlIllllIIlIIlIllll;
        ++this.ySize;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIllIlIllllIIlIIlIIIII, final int lllllllllllIllIlIllllIIlIIIlllll) {
        this.fontRendererObj.drawString(this.field_190779_v.getDisplayName().getUnformattedText(), 8.0f, 6.0f, 4210752);
        this.fontRendererObj.drawString(this.field_190780_w.getDisplayName().getUnformattedText(), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
    }
}
