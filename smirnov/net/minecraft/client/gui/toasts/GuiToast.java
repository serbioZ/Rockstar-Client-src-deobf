// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.toasts;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import java.util.Arrays;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.gui.ScaledResolution;
import javax.annotation.Nullable;
import com.google.common.collect.Queues;
import java.util.Deque;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class GuiToast extends Gui
{
    private final /* synthetic */ Minecraft field_191790_f;
    private final /* synthetic */ ToastInstance<?>[] field_191791_g;
    private final /* synthetic */ Deque<IToast> field_191792_h;
    
    public GuiToast(final Minecraft llllllllllllllIlIIIIIlIIIIIIIllI) {
        this.field_191791_g = (ToastInstance<?>[])new ToastInstance[5];
        this.field_191792_h = (Deque<IToast>)Queues.newArrayDeque();
        this.field_191790_f = llllllllllllllIlIIIIIlIIIIIIIllI;
    }
    
    public void func_192988_a(final IToast llllllllllllllIlIIIIIIlllllIIIII) {
        this.field_191792_h.add(llllllllllllllIlIIIIIIlllllIIIII);
    }
    
    @Nullable
    public <T extends IToast> T func_192990_a(final Class<? extends T> llllllllllllllIlIIIIIIlllllIllII, final Object llllllllllllllIlIIIIIIllllllIIII) {
        final char llllllllllllllIlIIIIIIlllllIIlll;
        final float llllllllllllllIlIIIIIIlllllIlIII = ((ToastInstance<?>[])(Object)(llllllllllllllIlIIIIIIlllllIIlll = (char)(Object)this.field_191791_g)).length;
        for (boolean llllllllllllllIlIIIIIIlllllIlIIl = false; (llllllllllllllIlIIIIIIlllllIlIIl ? 1 : 0) < llllllllllllllIlIIIIIIlllllIlIII; ++llllllllllllllIlIIIIIIlllllIlIIl) {
            final ToastInstance<?> llllllllllllllIlIIIIIIlllllIllll = llllllllllllllIlIIIIIIlllllIIlll[llllllllllllllIlIIIIIIlllllIlIIl];
            if (llllllllllllllIlIIIIIIlllllIllll != null && llllllllllllllIlIIIIIIlllllIllII.isAssignableFrom(llllllllllllllIlIIIIIIlllllIllll.func_193685_a().getClass()) && ((IToast)llllllllllllllIlIIIIIIlllllIllll.func_193685_a()).func_193652_b().equals(llllllllllllllIlIIIIIIllllllIIII)) {
                return (T)llllllllllllllIlIIIIIIlllllIllll.func_193685_a();
            }
        }
        for (final IToast llllllllllllllIlIIIIIIlllllIlllI : this.field_191792_h) {
            if (llllllllllllllIlIIIIIIlllllIllII.isAssignableFrom(llllllllllllllIlIIIIIIlllllIlllI.getClass()) && llllllllllllllIlIIIIIIlllllIlllI.func_193652_b().equals(llllllllllllllIlIIIIIIllllllIIII)) {
                return (T)llllllllllllllIlIIIIIIlllllIlllI;
            }
        }
        return null;
    }
    
    public void func_191783_a(final ScaledResolution llllllllllllllIlIIIIIIllllllllII) {
        if (!this.field_191790_f.gameSettings.hideGUI) {
            RenderHelper.disableStandardItemLighting();
            for (int llllllllllllllIlIIIIIIllllllllll = 0; llllllllllllllIlIIIIIIllllllllll < this.field_191791_g.length; ++llllllllllllllIlIIIIIIllllllllll) {
                final ToastInstance<?> llllllllllllllIlIIIIIIlllllllllI = this.field_191791_g[llllllllllllllIlIIIIIIllllllllll];
                if (llllllllllllllIlIIIIIIlllllllllI != null && llllllllllllllIlIIIIIIlllllllllI.func_193684_a(llllllllllllllIlIIIIIIllllllllII.getScaledWidth(), llllllllllllllIlIIIIIIllllllllll)) {
                    this.field_191791_g[llllllllllllllIlIIIIIIllllllllll] = null;
                }
                if (this.field_191791_g[llllllllllllllIlIIIIIIllllllllll] == null && !this.field_191792_h.isEmpty()) {
                    this.field_191791_g[llllllllllllllIlIIIIIIllllllllll] = new ToastInstance<Object>((IToast)this.field_191792_h.removeFirst(), (ToastInstance<?>)null);
                }
            }
        }
    }
    
    public void func_191788_b() {
        Arrays.fill(this.field_191791_g, null);
        this.field_191792_h.clear();
    }
    
    public Minecraft func_192989_b() {
        return this.field_191790_f;
    }
    
    class ToastInstance<T extends IToast>
    {
        private /* synthetic */ IToast.Visibility field_193691_e;
        private /* synthetic */ long field_193690_d;
        private /* synthetic */ long field_193689_c;
        private final /* synthetic */ T field_193688_b;
        
        public T func_193685_a() {
            return this.field_193688_b;
        }
        
        private ToastInstance(final T lllllllllllIIIIIIIIlllllIllIllll) {
            this.field_193689_c = -1L;
            this.field_193690_d = -1L;
            this.field_193691_e = IToast.Visibility.SHOW;
            this.field_193688_b = lllllllllllIIIIIIIIlllllIllIllll;
        }
        
        public boolean func_193684_a(final int lllllllllllIIIIIIIIlllllIlIllIIl, final int lllllllllllIIIIIIIIlllllIlIlIIll) {
            final long lllllllllllIIIIIIIIlllllIlIlIlll = Minecraft.getSystemTime();
            if (this.field_193689_c == -1L) {
                this.field_193689_c = lllllllllllIIIIIIIIlllllIlIlIlll;
                this.field_193691_e.func_194169_a(GuiToast.this.field_191790_f.getSoundHandler());
            }
            if (this.field_193691_e == IToast.Visibility.SHOW && lllllllllllIIIIIIIIlllllIlIlIlll - this.field_193689_c <= 600L) {
                this.field_193690_d = lllllllllllIIIIIIIIlllllIlIlIlll;
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(lllllllllllIIIIIIIIlllllIlIllIIl - 160.0f * this.func_193686_a(lllllllllllIIIIIIIIlllllIlIlIlll), (float)(lllllllllllIIIIIIIIlllllIlIlIIll * 32), (float)(500 + lllllllllllIIIIIIIIlllllIlIlIIll));
            final IToast.Visibility lllllllllllIIIIIIIIlllllIlIlIllI = this.field_193688_b.func_193653_a(GuiToast.this, lllllllllllIIIIIIIIlllllIlIlIlll - this.field_193690_d);
            GlStateManager.popMatrix();
            if (lllllllllllIIIIIIIIlllllIlIlIllI != this.field_193691_e) {
                this.field_193689_c = lllllllllllIIIIIIIIlllllIlIlIlll - (int)((1.0f - this.func_193686_a(lllllllllllIIIIIIIIlllllIlIlIlll)) * 600.0f);
                this.field_193691_e = lllllllllllIIIIIIIIlllllIlIlIllI;
                this.field_193691_e.func_194169_a(GuiToast.this.field_191790_f.getSoundHandler());
            }
            return this.field_193691_e == IToast.Visibility.HIDE && lllllllllllIIIIIIIIlllllIlIlIlll - this.field_193689_c > 600L;
        }
        
        private float func_193686_a(final long lllllllllllIIIIIIIIlllllIllIIlII) {
            float lllllllllllIIIIIIIIlllllIllIIIll = MathHelper.clamp((lllllllllllIIIIIIIIlllllIllIIlII - this.field_193689_c) / 600.0f, 0.0f, 1.0f);
            lllllllllllIIIIIIIIlllllIllIIIll *= lllllllllllIIIIIIIIlllllIllIIIll;
            return (this.field_193691_e == IToast.Visibility.HIDE) ? (1.0f - lllllllllllIIIIIIIIlllllIllIIIll) : lllllllllllIIIIIIIIlllllIllIIIll;
        }
    }
}
