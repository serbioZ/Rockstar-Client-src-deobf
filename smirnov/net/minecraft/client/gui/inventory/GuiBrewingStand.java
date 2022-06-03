// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBrewingStand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiBrewingStand extends GuiContainer
{
    private static final /* synthetic */ int[] BUBBLELENGTHS;
    private static final /* synthetic */ ResourceLocation BREWING_STAND_GUI_TEXTURES;
    private final /* synthetic */ IInventory tileBrewingStand;
    private final /* synthetic */ InventoryPlayer playerInventory;
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllIllllIIllIIIlIllIIllll, final int llllllllllIllllIIllIIIlIllIIlllI) {
        final String llllllllllIllllIIllIIIlIllIIllIl = this.tileBrewingStand.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(llllllllllIllllIIllIIIlIllIIllIl, (float)(this.xSize / 2 - this.fontRendererObj.getStringWidth(llllllllllIllllIIllIIIlIllIIllIl) / 2), 6.0f, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllIllllIIllIIIlIllIIIIlI, final int llllllllllIllllIIllIIIlIllIIIIIl, final int llllllllllIllllIIllIIIlIllIIIIII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiBrewingStand.BREWING_STAND_GUI_TEXTURES);
        final int llllllllllIllllIIllIIIlIlIllllll = (this.width - this.xSize) / 2;
        final int llllllllllIllllIIllIIIlIlIlllllI = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(llllllllllIllllIIllIIIlIlIllllll, llllllllllIllllIIllIIIlIlIlllllI, 0, 0, this.xSize, this.ySize);
        final int llllllllllIllllIIllIIIlIlIllllIl = this.tileBrewingStand.getField(1);
        final int llllllllllIllllIIllIIIlIlIllllII = MathHelper.clamp((18 * llllllllllIllllIIllIIIlIlIllllIl + 20 - 1) / 20, 0, 18);
        if (llllllllllIllllIIllIIIlIlIllllII > 0) {
            this.drawTexturedModalRect(llllllllllIllllIIllIIIlIlIllllll + 60, llllllllllIllllIIllIIIlIlIlllllI + 44, 176, 29, llllllllllIllllIIllIIIlIlIllllII, 4);
        }
        final int llllllllllIllllIIllIIIlIlIlllIll = this.tileBrewingStand.getField(0);
        if (llllllllllIllllIIllIIIlIlIlllIll > 0) {
            int llllllllllIllllIIllIIIlIlIlllIlI = (int)(28.0f * (1.0f - llllllllllIllllIIllIIIlIlIlllIll / 400.0f));
            if (llllllllllIllllIIllIIIlIlIlllIlI > 0) {
                this.drawTexturedModalRect(llllllllllIllllIIllIIIlIlIllllll + 97, llllllllllIllllIIllIIIlIlIlllllI + 16, 176, 0, 9, llllllllllIllllIIllIIIlIlIlllIlI);
            }
            llllllllllIllllIIllIIIlIlIlllIlI = GuiBrewingStand.BUBBLELENGTHS[llllllllllIllllIIllIIIlIlIlllIll / 2 % 7];
            if (llllllllllIllllIIllIIIlIlIlllIlI > 0) {
                this.drawTexturedModalRect(llllllllllIllllIIllIIIlIlIllllll + 63, llllllllllIllllIIllIIIlIlIlllllI + 14 + 29 - llllllllllIllllIIllIIIlIlIlllIlI, 185, 29 - llllllllllIllllIIllIIIlIlIlllIlI, 12, llllllllllIllllIIllIIIlIlIlllIlI);
            }
        }
    }
    
    static {
        BREWING_STAND_GUI_TEXTURES = new ResourceLocation("textures/gui/container/brewing_stand.png");
        BUBBLELENGTHS = new int[] { 29, 24, 20, 16, 11, 6, 0 };
    }
    
    @Override
    public void drawScreen(final int llllllllllIllllIIllIIIlIllIlIlIl, final int llllllllllIllllIIllIIIlIllIlIlII, final float llllllllllIllllIIllIIIlIllIlIlll) {
        this.drawDefaultBackground();
        super.drawScreen(llllllllllIllllIIllIIIlIllIlIlIl, llllllllllIllllIIllIIIlIllIlIlII, llllllllllIllllIIllIIIlIllIlIlll);
        this.func_191948_b(llllllllllIllllIIllIIIlIllIlIlIl, llllllllllIllllIIllIIIlIllIlIlII);
    }
    
    public GuiBrewingStand(final InventoryPlayer llllllllllIllllIIllIIIlIlllIIIII, final IInventory llllllllllIllllIIllIIIlIlllIIIlI) {
        super(new ContainerBrewingStand(llllllllllIllllIIllIIIlIlllIIIII, llllllllllIllllIIllIIIlIlllIIIlI));
        this.playerInventory = llllllllllIllllIIllIIIlIlllIIIII;
        this.tileBrewingStand = llllllllllIllllIIllIIIlIlllIIIlI;
    }
}
