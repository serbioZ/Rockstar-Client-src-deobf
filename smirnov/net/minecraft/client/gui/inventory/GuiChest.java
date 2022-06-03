// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiChest extends GuiContainer
{
    private static final /* synthetic */ ResourceLocation CHEST_GUI_TEXTURE;
    private final /* synthetic */ IInventory lowerChestInventory;
    private final /* synthetic */ int inventoryRows;
    private final /* synthetic */ IInventory upperChestInventory;
    
    public int getInventoryRows() {
        return this.inventoryRows;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllIIlIIIlIIIlllllIIIIIl, final int lllllllllllIIlIIIlIIIlllllIIIIII, final int lllllllllllIIlIIIlIIIllllIllllll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiChest.CHEST_GUI_TEXTURE);
        final int lllllllllllIIlIIIlIIIllllIlllllI = (this.width - this.xSize) / 2;
        final int lllllllllllIIlIIIlIIIllllIllllIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllIIlIIIlIIIllllIlllllI, lllllllllllIIlIIIlIIIllllIllllIl, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.drawTexturedModalRect(lllllllllllIIlIIIlIIIllllIlllllI, lllllllllllIIlIIIlIIIllllIllllIl + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
    
    static {
        CHEST_GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIIlIIIlIIIlllllIIlIII, final int lllllllllllIIlIIIlIIIlllllIIIlll) {
        this.fontRendererObj.drawString(this.lowerChestInventory.getDisplayName().getUnformattedText(), 8.0f, 6.0f, 4210752);
        this.fontRendererObj.drawString(this.upperChestInventory.getDisplayName().getUnformattedText(), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIlIIIlIIIlllllIlIIII, final int lllllllllllIIlIIIlIIIlllllIIllll, final float lllllllllllIIlIIIlIIIlllllIlIIlI) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllIIlIIIlIIIlllllIlIIII, lllllllllllIIlIIIlIIIlllllIIllll, lllllllllllIIlIIIlIIIlllllIlIIlI);
        this.func_191948_b(lllllllllllIIlIIIlIIIlllllIlIIII, lllllllllllIIlIIIlIIIlllllIIllll);
    }
    
    public GuiChest(final IInventory lllllllllllIIlIIIlIIIlllllIlllIl, final IInventory lllllllllllIIlIIIlIIIllllllIIIIl) {
        super(new ContainerChest(lllllllllllIIlIIIlIIIlllllIlllIl, lllllllllllIIlIIIlIIIllllllIIIIl, Minecraft.getMinecraft().player));
        this.upperChestInventory = lllllllllllIIlIIIlIIIlllllIlllIl;
        this.lowerChestInventory = lllllllllllIIlIIIlIIIllllllIIIIl;
        this.allowUserInput = false;
        final int lllllllllllIIlIIIlIIIllllllIIIII = 222;
        final int lllllllllllIIlIIIlIIIlllllIlllll = 114;
        this.inventoryRows = lllllllllllIIlIIIlIIIllllllIIIIl.getSizeInventory() / 9;
        this.ySize = 114 + this.inventoryRows * 18;
    }
}
