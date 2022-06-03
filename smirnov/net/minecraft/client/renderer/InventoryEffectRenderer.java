// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import java.util.Collection;
import net.minecraft.potion.Potion;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.PotionEffect;
import com.google.common.collect.Ordering;
import net.minecraft.inventory.Container;
import net.minecraft.client.gui.inventory.GuiContainer;

public abstract class InventoryEffectRenderer extends GuiContainer
{
    protected /* synthetic */ boolean hasActivePotionEffects;
    
    public InventoryEffectRenderer(final Container llllllllllllIIllIlllllIllIllIlIl) {
        super(llllllllllllIIllIlllllIllIllIlIl);
    }
    
    protected void updateActivePotionEffects() {
        if (this.mc.player.getActivePotionEffects().isEmpty()) {
            this.guiLeft = (this.width - this.xSize) / 2;
            this.hasActivePotionEffects = false;
        }
        else {
            this.guiLeft = 160 + (this.width - this.xSize - 200) / 2;
            this.hasActivePotionEffects = true;
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllIIllIlllllIllIlIIlll, final int llllllllllllIIllIlllllIllIlIIIlI, final float llllllllllllIIllIlllllIllIlIIlIl) {
        super.drawScreen(llllllllllllIIllIlllllIllIlIIlll, llllllllllllIIllIlllllIllIlIIIlI, llllllllllllIIllIlllllIllIlIIlIl);
        if (this.hasActivePotionEffects) {
            this.drawActivePotionEffects();
        }
    }
    
    private void drawActivePotionEffects() {
        final int llllllllllllIIllIlllllIllIIlIlII = this.guiLeft - 124;
        int llllllllllllIIllIlllllIllIIlIIll = this.guiTop;
        final int llllllllllllIIllIlllllIllIIlIIlI = 166;
        final Collection<PotionEffect> llllllllllllIIllIlllllIllIIlIIIl = this.mc.player.getActivePotionEffects();
        if (!llllllllllllIIllIlllllIllIIlIIIl.isEmpty()) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableLighting();
            int llllllllllllIIllIlllllIllIIlIIII = 33;
            if (llllllllllllIIllIlllllIllIIlIIIl.size() > 5) {
                llllllllllllIIllIlllllIllIIlIIII = 132 / (llllllllllllIIllIlllllIllIIlIIIl.size() - 1);
            }
            for (final PotionEffect llllllllllllIIllIlllllIllIIIllll : Ordering.natural().sortedCopy((Iterable)llllllllllllIIllIlllllIllIIlIIIl)) {
                final Potion llllllllllllIIllIlllllIllIIIlllI = llllllllllllIIllIlllllIllIIIllll.getPotion();
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.mc.getTextureManager().bindTexture(InventoryEffectRenderer.INVENTORY_BACKGROUND);
                this.drawTexturedModalRect(llllllllllllIIllIlllllIllIIlIlII, llllllllllllIIllIlllllIllIIlIIll, 0, 166, 140, 32);
                if (llllllllllllIIllIlllllIllIIIlllI.hasStatusIcon()) {
                    final int llllllllllllIIllIlllllIllIIIllIl = llllllllllllIIllIlllllIllIIIlllI.getStatusIconIndex();
                    this.drawTexturedModalRect(llllllllllllIIllIlllllIllIIlIlII + 6, llllllllllllIIllIlllllIllIIlIIll + 7, 0 + llllllllllllIIllIlllllIllIIIllIl % 8 * 18, 198 + llllllllllllIIllIlllllIllIIIllIl / 8 * 18, 18, 18);
                }
                String llllllllllllIIllIlllllIllIIIllII = I18n.format(llllllllllllIIllIlllllIllIIIlllI.getName(), new Object[0]);
                if (llllllllllllIIllIlllllIllIIIllll.getAmplifier() == 1) {
                    llllllllllllIIllIlllllIllIIIllII = String.valueOf(llllllllllllIIllIlllllIllIIIllII) + " " + I18n.format("enchantment.level.2", new Object[0]);
                }
                else if (llllllllllllIIllIlllllIllIIIllll.getAmplifier() == 2) {
                    llllllllllllIIllIlllllIllIIIllII = String.valueOf(llllllllllllIIllIlllllIllIIIllII) + " " + I18n.format("enchantment.level.3", new Object[0]);
                }
                else if (llllllllllllIIllIlllllIllIIIllll.getAmplifier() == 3) {
                    llllllllllllIIllIlllllIllIIIllII = String.valueOf(llllllllllllIIllIlllllIllIIIllII) + " " + I18n.format("enchantment.level.4", new Object[0]);
                }
                this.fontRendererObj.drawStringWithShadow(llllllllllllIIllIlllllIllIIIllII, (float)(llllllllllllIIllIlllllIllIIlIlII + 10 + 18), (float)(llllllllllllIIllIlllllIllIIlIIll + 6), 16777215);
                final String llllllllllllIIllIlllllIllIIIlIll = Potion.getPotionDurationString(llllllllllllIIllIlllllIllIIIllll, 1.0f);
                this.fontRendererObj.drawStringWithShadow(llllllllllllIIllIlllllIllIIIlIll, (float)(llllllllllllIIllIlllllIllIIlIlII + 10 + 18), (float)(llllllllllllIIllIlllllIllIIlIIll + 6 + 10), 8355711);
                llllllllllllIIllIlllllIllIIlIIll += llllllllllllIIllIlllllIllIIlIIII;
            }
        }
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.updateActivePotionEffects();
    }
}
