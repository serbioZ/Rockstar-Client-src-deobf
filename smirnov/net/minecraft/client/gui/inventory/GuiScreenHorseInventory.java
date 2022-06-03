// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.AbstractChestHorse;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerHorseInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.inventory.IInventory;

public class GuiScreenHorseInventory extends GuiContainer
{
    private final /* synthetic */ IInventory horseInventory;
    private /* synthetic */ float mousePosx;
    private /* synthetic */ float mousePosY;
    private final /* synthetic */ IInventory playerInventory;
    private final /* synthetic */ AbstractHorse horseEntity;
    private static final /* synthetic */ ResourceLocation HORSE_GUI_TEXTURES;
    
    static {
        HORSE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/horse.png");
    }
    
    public GuiScreenHorseInventory(final IInventory lllllllllllIllIlllIIllIIlIIIIIlI, final IInventory lllllllllllIllIlllIIllIIlIIIIIIl, final AbstractHorse lllllllllllIllIlllIIllIIlIIIIlII) {
        super(new ContainerHorseInventory(lllllllllllIllIlllIIllIIlIIIIIlI, lllllllllllIllIlllIIllIIlIIIIIIl, lllllllllllIllIlllIIllIIlIIIIlII, Minecraft.getMinecraft().player));
        this.playerInventory = lllllllllllIllIlllIIllIIlIIIIIlI;
        this.horseInventory = lllllllllllIllIlllIIllIIlIIIIIIl;
        this.horseEntity = lllllllllllIllIlllIIllIIlIIIIlII;
        this.allowUserInput = false;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllIllIlllIIllIIIlllIlIl, final int lllllllllllIllIlllIIllIIIlllIlII, final int lllllllllllIllIlllIIllIIIlllIIll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiScreenHorseInventory.HORSE_GUI_TEXTURES);
        final int lllllllllllIllIlllIIllIIIlllIIlI = (this.width - this.xSize) / 2;
        final int lllllllllllIllIlllIIllIIIlllIIIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllIllIlllIIllIIIlllIIlI, lllllllllllIllIlllIIllIIIlllIIIl, 0, 0, this.xSize, this.ySize);
        if (this.horseEntity instanceof AbstractChestHorse) {
            final AbstractChestHorse lllllllllllIllIlllIIllIIIlllIIII = (AbstractChestHorse)this.horseEntity;
            if (lllllllllllIllIlllIIllIIIlllIIII.func_190695_dh()) {
                this.drawTexturedModalRect(lllllllllllIllIlllIIllIIIlllIIlI + 79, lllllllllllIllIlllIIllIIIlllIIIl + 17, 0, this.ySize, lllllllllllIllIlllIIllIIIlllIIII.func_190696_dl() * 18, 54);
            }
        }
        if (this.horseEntity.func_190685_dA()) {
            this.drawTexturedModalRect(lllllllllllIllIlllIIllIIIlllIIlI + 7, lllllllllllIllIlllIIllIIIlllIIIl + 35 - 18, 18, this.ySize + 54, 18, 18);
        }
        if (this.horseEntity.func_190677_dK()) {
            if (this.horseEntity instanceof EntityLlama) {
                this.drawTexturedModalRect(lllllllllllIllIlllIIllIIIlllIIlI + 7, lllllllllllIllIlllIIllIIIlllIIIl + 35, 36, this.ySize + 54, 18, 18);
            }
            else {
                this.drawTexturedModalRect(lllllllllllIllIlllIIllIIIlllIIlI + 7, lllllllllllIllIlllIIllIIIlllIIIl + 35, 0, this.ySize + 54, 18, 18);
            }
        }
        GuiInventory.drawEntityOnScreen(lllllllllllIllIlllIIllIIIlllIIlI + 51, lllllllllllIllIlllIIllIIIlllIIIl + 60, 17, lllllllllllIllIlllIIllIIIlllIIlI + 51 - this.mousePosx, lllllllllllIllIlllIIllIIIlllIIIl + 75 - 50 - this.mousePosY, this.horseEntity);
    }
    
    @Override
    public void drawScreen(final int lllllllllllIllIlllIIllIIIllIIllI, final int lllllllllllIllIlllIIllIIIllIIIIl, final float lllllllllllIllIlllIIllIIIllIIlII) {
        this.drawDefaultBackground();
        this.mousePosx = (float)lllllllllllIllIlllIIllIIIllIIllI;
        this.mousePosY = (float)lllllllllllIllIlllIIllIIIllIIIIl;
        super.drawScreen(lllllllllllIllIlllIIllIIIllIIllI, lllllllllllIllIlllIIllIIIllIIIIl, lllllllllllIllIlllIIllIIIllIIlII);
        this.func_191948_b(lllllllllllIllIlllIIllIIIllIIllI, lllllllllllIllIlllIIllIIIllIIIIl);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIllIlllIIllIIIlllllIl, final int lllllllllllIllIlllIIllIIIlllllII) {
        this.fontRendererObj.drawString(this.horseInventory.getDisplayName().getUnformattedText(), 8.0f, 6.0f, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
    }
}
