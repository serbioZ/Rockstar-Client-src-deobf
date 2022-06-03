// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.button;

import ru.rockstar.api.utils.render.DrawHelper;
import net.minecraft.client.renderer.GlStateManager;
import java.awt.Color;
import ru.rockstar.client.ui.MouseHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import ru.rockstar.client.ui.GuiCapeSelector;
import ru.rockstar.client.ui.draggable.GuiHudEditor;
import ru.rockstar.client.ui.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;

public class ImageButton
{
    protected /* synthetic */ int target;
    protected /* synthetic */ String description;
    protected /* synthetic */ Minecraft mc;
    protected /* synthetic */ int width;
    protected /* synthetic */ int x;
    protected /* synthetic */ ResourceLocation image;
    protected /* synthetic */ int y;
    protected /* synthetic */ int height;
    protected /* synthetic */ int ani;
    
    protected void hoverAnimation(final int llllllllllllIIIIIllIIlIllIlIlIlI, final int llllllllllllIIIIIllIIlIllIlIlIIl) {
        if (this.isHovered(llllllllllllIIIIIllIIlIllIlIlIlI, llllllllllllIIIIIllIIlIllIlIlIIl)) {
            if (this.ani < 3) {
                ++this.ani;
            }
        }
        else if (this.ani > 0) {
            --this.ani;
        }
    }
    
    public ImageButton(final ResourceLocation llllllllllllIIIIIllIIlIllIllIlIl, final int llllllllllllIIIIIllIIlIllIllllII, final int llllllllllllIIIIIllIIlIllIllIIll, final int llllllllllllIIIIIllIIlIllIllIIlI, final int llllllllllllIIIIIllIIlIllIllIIIl, final String llllllllllllIIIIIllIIlIllIllIIII, final int llllllllllllIIIIIllIIlIllIllIlll) {
        this.ani = 0;
        this.image = llllllllllllIIIIIllIIlIllIllIlIl;
        this.x = llllllllllllIIIIIllIIlIllIllllII;
        this.y = llllllllllllIIIIIllIIlIllIllIIll;
        this.width = llllllllllllIIIIIllIIlIllIllIIlI;
        this.height = llllllllllllIIIIIllIIlIllIllIIIl;
        this.description = llllllllllllIIIIIllIIlIllIllIIII;
        this.target = llllllllllllIIIIIllIIlIllIllIlll;
        this.mc = Minecraft.getMinecraft();
    }
    
    public void onClick(final int llllllllllllIIIIIllIIlIllIIlllll, final int llllllllllllIIIIIllIIlIllIIllllI) {
        if (this.isHovered(llllllllllllIIIIIllIIlIllIIlllll, llllllllllllIIIIIllIIlIllIIllllI)) {
            if (this.target == 19) {
                Minecraft.getMinecraft().displayGuiScreen(null);
            }
            if (this.target == 22) {
                Minecraft.getMinecraft().displayGuiScreen(new GuiConfig());
            }
            if (this.target == 24) {
                Minecraft.getMinecraft().displayGuiScreen(new GuiHudEditor());
            }
            if (this.target == 23) {
                Minecraft.getMinecraft().displayGuiScreen(new GuiCapeSelector());
            }
            if (this.target == 30) {
                final GuiChest llllllllllllIIIIIllIIlIllIIlllIl = (GuiChest)this.mc.currentScreen;
                if (llllllllllllIIIIIllIIlIllIIlllIl != null) {
                    int llllllllllllIIIIIllIIlIlIllllIll;
                    final GuiChest guiChest;
                    ContainerChest llllllllllllIIIIIllIIlIlIllllIlI;
                    new Thread(() -> {
                        try {
                            for (llllllllllllIIIIIllIIlIlIllllIll = 0; llllllllllllIIIIIllIIlIlIllllIll < guiChest.getInventoryRows() * 9; ++llllllllllllIIIIIllIIlIlIllllIll) {
                                llllllllllllIIIIIllIIlIlIllllIlI = (ContainerChest)this.mc.player.openContainer;
                                if (llllllllllllIIIIIllIIlIlIllllIlI != null) {
                                    Thread.sleep(50L);
                                    this.mc.playerController.windowClick(llllllllllllIIIIIllIIlIlIllllIlI.windowId, llllllllllllIIIIIllIIlIlIllllIll, 0, ClickType.QUICK_MOVE, this.mc.player);
                                }
                            }
                        }
                        catch (Exception ex) {}
                        return;
                    }).start();
                }
            }
            if (this.target == 31) {
                final GuiChest llllllllllllIIIIIllIIlIllIIlllII = (GuiChest)this.mc.currentScreen;
                if (llllllllllllIIIIIllIIlIllIIlllII != null) {
                    final GuiChest guiChest2;
                    int llllllllllllIIIIIllIIlIlIlllIIlI;
                    Slot llllllllllllIIIIIllIIlIlIlllIIIl;
                    new Thread(() -> {
                        try {
                            for (llllllllllllIIIIIllIIlIlIlllIIlI = guiChest2.getInventoryRows() * 9; llllllllllllIIIIIllIIlIlIlllIIlI < guiChest2.getInventoryRows() * 9 + 44; ++llllllllllllIIIIIllIIlIlIlllIIlI) {
                                llllllllllllIIIIIllIIlIlIlllIIIl = guiChest2.inventorySlots.inventorySlots.get(llllllllllllIIIIIllIIlIlIlllIIlI);
                                if (llllllllllllIIIIIllIIlIlIlllIIIl.getStack() != null) {
                                    Thread.sleep(50L);
                                    guiChest2.handleMouseClick(llllllllllllIIIIIllIIlIlIlllIIIl, llllllllllllIIIIIllIIlIlIlllIIIl.slotNumber, 0, ClickType.QUICK_MOVE);
                                }
                            }
                        }
                        catch (Exception ex2) {}
                        return;
                    }).start();
                }
            }
            if (this.target == 32) {
                for (int llllllllllllIIIIIllIIlIllIIllIll = 0; llllllllllllIIIIIllIIlIllIIllIll < 46; ++llllllllllllIIIIIllIIlIllIIllIll) {
                    if (this.mc.player.inventoryContainer.getSlot(llllllllllllIIIIIllIIlIllIIllIll).getHasStack()) {
                        this.mc.playerController.windowClick(this.mc.player.inventoryContainer.windowId, llllllllllllIIIIIllIIlIllIIllIll, 1, ClickType.THROW, this.mc.player);
                    }
                }
            }
            if (this.target == 55) {
                final long llllllllllllIIIIIllIIlIllIIlIlll;
                switch (((String)(llllllllllllIIIIIllIIlIllIIlIlll = (long)GuiCapeSelector.Selector.getCapeName())).hashCode()) {
                    case 3046099: {
                        if (!((String)llllllllllllIIIIIllIIlIllIIlIlll).equals("cape")) {
                            break;
                        }
                        GuiCapeSelector.Selector.capeName = "cape";
                        break;
                    }
                    case 3441014: {
                        if (!((String)llllllllllllIIIIIllIIlIllIIlIlll).equals("pink")) {
                            break;
                        }
                        GuiCapeSelector.Selector.capeName = "pink";
                        break;
                    }
                }
            }
            if (this.target == 56) {
                final short llllllllllllIIIIIllIIlIllIIlIllI;
                switch (((String)(llllllllllllIIIIIllIIlIllIIlIllI = (short)GuiCapeSelector.Selector.getCapeName())).hashCode()) {
                    case 3046099: {
                        if (!((String)llllllllllllIIIIIllIIlIllIIlIllI).equals("cape")) {
                            break;
                        }
                        GuiCapeSelector.Selector.capeName = "cape";
                        break;
                    }
                    case 3441014: {
                        if (!((String)llllllllllllIIIIIllIIlIllIIlIllI).equals("pink")) {
                            break;
                        }
                        GuiCapeSelector.Selector.capeName = "pink";
                        break;
                    }
                }
            }
        }
    }
    
    protected boolean isHovered(final int llllllllllllIIIIIllIIlIllIIIIIlI, final int llllllllllllIIIIIllIIlIllIIIIlII) {
        return MouseHelper.isHovered(this.x, this.y, this.x + this.width, this.y + this.height, llllllllllllIIIIIllIIlIllIIIIIlI, llllllllllllIIIIIllIIlIllIIIIlII);
    }
    
    public void draw(final int llllllllllllIIIIIllIIlIllIIIllII, final int llllllllllllIIIIIllIIlIllIIIllll, final Color llllllllllllIIIIIllIIlIllIIIlIlI) {
        GlStateManager.pushMatrix();
        GlStateManager.disableBlend();
        this.hoverAnimation(llllllllllllIIIIIllIIlIllIIIllII, llllllllllllIIIIIllIIlIllIIIllll);
        if (this.ani > 0) {
            DrawHelper.drawImage(this.image, (float)(this.x - this.ani), (float)(this.y - this.ani), (float)(this.width + this.ani * 2), (float)(this.height + this.ani * 2), new Color(156, 156, 156, 255));
        }
        else {
            DrawHelper.drawImage(this.image, (float)this.x, (float)this.y, (float)this.width, (float)this.height, llllllllllllIIIIIllIIlIllIIIlIlI);
        }
        GlStateManager.popMatrix();
    }
}
