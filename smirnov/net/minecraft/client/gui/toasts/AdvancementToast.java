// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.toasts;

import java.util.List;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.advancements.FrameType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.advancements.Advancement;

public class AdvancementToast implements IToast
{
    private /* synthetic */ boolean field_194168_d;
    private final /* synthetic */ Advancement field_193679_c;
    
    @Override
    public Visibility func_193653_a(final GuiToast lllllllllllllIIIlIIlIllIIIIlIllI, final long lllllllllllllIIIlIIlIllIIIIlIlIl) {
        lllllllllllllIIIlIIlIllIIIIlIllI.func_192989_b().getTextureManager().bindTexture(AdvancementToast.field_193654_a);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        final DisplayInfo lllllllllllllIIIlIIlIllIIIIlIlII = this.field_193679_c.func_192068_c();
        lllllllllllllIIIlIIlIllIIIIlIllI.drawTexturedModalRect(0, 0, 0, 0, 160, 32);
        if (lllllllllllllIIIlIIlIllIIIIlIlII != null) {
            lllllllllllllIIIlIIlIllIIIIlIllI.func_192989_b();
            final List<String> lllllllllllllIIIlIIlIllIIIIlIIll = Minecraft.fontRendererObj.listFormattedStringToWidth(lllllllllllllIIIlIIlIllIIIIlIlII.func_192297_a().getFormattedText(), 125);
            final int lllllllllllllIIIlIIlIllIIIIlIIlI = (lllllllllllllIIIlIIlIllIIIIlIlII.func_192291_d() == FrameType.CHALLENGE) ? 16746751 : 16776960;
            if (lllllllllllllIIIlIIlIllIIIIlIIll.size() == 1) {
                lllllllllllllIIIlIIlIllIIIIlIllI.func_192989_b();
                Minecraft.fontRendererObj.drawString(I18n.format("advancements.toast." + lllllllllllllIIIlIIlIllIIIIlIlII.func_192291_d().func_192307_a(), new Object[0]), 30.0f, 7.0f, lllllllllllllIIIlIIlIllIIIIlIIlI | 0xFF000000);
                lllllllllllllIIIlIIlIllIIIIlIllI.func_192989_b();
                Minecraft.fontRendererObj.drawString(lllllllllllllIIIlIIlIllIIIIlIlII.func_192297_a().getFormattedText(), 30.0f, 18.0f, -1);
            }
            else {
                final int lllllllllllllIIIlIIlIllIIIIlIIIl = 1500;
                final float lllllllllllllIIIlIIlIllIIIIlIIII = 300.0f;
                if (lllllllllllllIIIlIIlIllIIIIlIlIl < 1500L) {
                    final int lllllllllllllIIIlIIlIllIIIIIllll = MathHelper.floor(MathHelper.clamp((1500L - lllllllllllllIIIlIIlIllIIIIlIlIl) / 300.0f, 0.0f, 1.0f) * 255.0f) << 24 | 0x4000000;
                    lllllllllllllIIIlIIlIllIIIIlIllI.func_192989_b();
                    Minecraft.fontRendererObj.drawString(I18n.format("advancements.toast." + lllllllllllllIIIlIIlIllIIIIlIlII.func_192291_d().func_192307_a(), new Object[0]), 30.0f, 11.0f, lllllllllllllIIIlIIlIllIIIIlIIlI | lllllllllllllIIIlIIlIllIIIIIllll);
                }
                else {
                    final int lllllllllllllIIIlIIlIllIIIIIlllI = MathHelper.floor(MathHelper.clamp((lllllllllllllIIIlIIlIllIIIIlIlIl - 1500L) / 300.0f, 0.0f, 1.0f) * 252.0f) << 24 | 0x4000000;
                    final int n = 16;
                    final int size = lllllllllllllIIIlIIlIllIIIIlIIll.size();
                    lllllllllllllIIIlIIlIllIIIIlIllI.func_192989_b();
                    int lllllllllllllIIIlIIlIllIIIIIllIl = n - size * Minecraft.fontRendererObj.FONT_HEIGHT / 2;
                    for (final String lllllllllllllIIIlIIlIllIIIIIllII : lllllllllllllIIIlIIlIllIIIIlIIll) {
                        lllllllllllllIIIlIIlIllIIIIlIllI.func_192989_b();
                        Minecraft.fontRendererObj.drawString(lllllllllllllIIIlIIlIllIIIIIllII, 30.0f, (float)lllllllllllllIIIlIIlIllIIIIIllIl, 0xFFFFFF | lllllllllllllIIIlIIlIllIIIIIlllI);
                        final int n2 = lllllllllllllIIIlIIlIllIIIIIllIl;
                        lllllllllllllIIIlIIlIllIIIIlIllI.func_192989_b();
                        lllllllllllllIIIlIIlIllIIIIIllIl = n2 + Minecraft.fontRendererObj.FONT_HEIGHT;
                    }
                }
            }
            if (!this.field_194168_d && lllllllllllllIIIlIIlIllIIIIlIlIl > 0L) {
                this.field_194168_d = true;
                if (lllllllllllllIIIlIIlIllIIIIlIlII.func_192291_d() == FrameType.CHALLENGE) {
                    lllllllllllllIIIlIIlIllIIIIlIllI.func_192989_b().getSoundHandler().playSound(PositionedSoundRecord.func_194007_a(SoundEvents.field_194228_if, 1.0f, 1.0f));
                }
            }
            RenderHelper.enableGUIStandardItemLighting();
            lllllllllllllIIIlIIlIllIIIIlIllI.func_192989_b().getRenderItem().renderItemAndEffectIntoGUI(null, lllllllllllllIIIlIIlIllIIIIlIlII.func_192298_b(), 8, 8);
            return (lllllllllllllIIIlIIlIllIIIIlIlIl >= 5000L) ? Visibility.HIDE : Visibility.SHOW;
        }
        return Visibility.HIDE;
    }
    
    public AdvancementToast(final Advancement lllllllllllllIIIlIIlIllIIIlIIlII) {
        this.field_194168_d = false;
        this.field_193679_c = lllllllllllllIIIlIIlIllIIIlIIlII;
    }
}
