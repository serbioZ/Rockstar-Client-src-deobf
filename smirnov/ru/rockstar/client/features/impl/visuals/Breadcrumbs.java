// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import net.minecraft.util.text.TextFormatting;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import org.lwjgl.opengl.GL11;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.Setting;
import java.awt.Color;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import java.util.ArrayList;
import ru.rockstar.client.features.Feature;

public class Breadcrumbs extends Feature
{
    /* synthetic */ ArrayList<Point> points;
    /* synthetic */ ColorSetting twocolor;
    /* synthetic */ ColorSetting onecolor;
    /* synthetic */ NumberSetting removeticks;
    /* synthetic */ BooleanSetting smoothending;
    /* synthetic */ NumberSetting alpha;
    /* synthetic */ ListSetting colorMode;
    
    @Override
    public void onDisable() {
        this.points.clear();
        super.onDisable();
    }
    
    public Breadcrumbs() {
        super("Trails", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043b\u0438\u043d\u0438\u044e \u0432\u0437\u0430\u0434\u0438 \u0432\u0430\u0441", 0, Category.VISUALS);
        this.points = new ArrayList<Point>();
        this.colorMode = new ListSetting("Trails Color", "Astolfo", () -> true, new String[] { "Astolfo", "Pulse", "Custom", "Client", "Static" });
        this.onecolor = new ColorSetting("One Color", new Color(255, 255, 255).getRGB(), () -> this.colorMode.currentMode.equalsIgnoreCase("Static") || this.colorMode.currentMode.equalsIgnoreCase("Custom"));
        this.twocolor = new ColorSetting("Two Color", new Color(255, 255, 255).getRGB(), () -> this.colorMode.currentMode.equalsIgnoreCase("Custom"));
        this.removeticks = new NumberSetting("Remove Ticks", "\u0417\u0430\u0434\u0435\u0440\u0436\u043a\u0430 \u043f\u043e\u0441\u043b\u0435 \u043a\u043e\u0442\u043e\u0440\u043e\u0439 \u0431\u0443\u0434\u0443\u0442 \u043f\u0440\u043e\u043f\u0430\u0434\u0430\u0442\u044c \u0442\u0440\u0435\u0439\u043b\u044b", 100.0f, 100.0f, 500.0f, 1.0f, () -> true);
        this.alpha = new NumberSetting("Alpha Trails", "\u041f\u0440\u043e\u0437\u0440\u0430\u0447\u043d\u043e\u0441\u0442\u044c", 255.0f, 1.0f, 255.0f, 1.0f, () -> true);
        this.smoothending = new BooleanSetting("Smooth Ending", true, () -> true);
        this.addSettings(this.colorMode, this.onecolor, this.twocolor, this.removeticks, this.alpha, this.smoothending);
    }
    
    public static Color getGradientOffset(final Color llllllllllllIllIIIIlllIIllllllII, final Color llllllllllllIllIIIIlllIIlllllIll, double llllllllllllIllIIIIlllIIlllllIlI, final int llllllllllllIllIIIIlllIlIIIIIIll) {
        if (llllllllllllIllIIIIlllIIlllllIlI > 1.0) {
            final double llllllllllllIllIIIIlllIlIIIIIIlI = llllllllllllIllIIIIlllIIlllllIlI % 1.0;
            final int llllllllllllIllIIIIlllIlIIIIIIIl = (int)llllllllllllIllIIIIlllIIlllllIlI;
            llllllllllllIllIIIIlllIIlllllIlI = ((llllllllllllIllIIIIlllIlIIIIIIIl % 2 == 0) ? llllllllllllIllIIIIlllIlIIIIIIlI : (1.0 - llllllllllllIllIIIIlllIlIIIIIIlI));
        }
        final double llllllllllllIllIIIIlllIlIIIIIIII = 1.0 - llllllllllllIllIIIIlllIIlllllIlI;
        final int llllllllllllIllIIIIlllIIllllllll = (int)(llllllllllllIllIIIIlllIIllllllII.getRed() * llllllllllllIllIIIIlllIlIIIIIIII + llllllllllllIllIIIIlllIIlllllIll.getRed() * llllllllllllIllIIIIlllIIlllllIlI);
        final int llllllllllllIllIIIIlllIIlllllllI = (int)(llllllllllllIllIIIIlllIIllllllII.getGreen() * llllllllllllIllIIIIlllIlIIIIIIII + llllllllllllIllIIIIlllIIlllllIll.getGreen() * llllllllllllIllIIIIlllIIlllllIlI);
        final int llllllllllllIllIIIIlllIIllllllIl = (int)(llllllllllllIllIIIIlllIIllllllII.getBlue() * llllllllllllIllIIIIlllIlIIIIIIII + llllllllllllIllIIIIlllIIlllllIll.getBlue() * llllllllllllIllIIIIlllIIlllllIlI);
        return new Color(llllllllllllIllIIIIlllIIllllllll, llllllllllllIllIIIIlllIIlllllllI, llllllllllllIllIIIIlllIIllllllIl, llllllllllllIllIIIIlllIlIIIIIIll);
    }
    
    @EventTarget
    public void onRender(final Event3D llllllllllllIllIIIIlllIlIIlIIIll) {
        this.points.removeIf(llllllllllllIllIIIIlllIIlllIlIIl -> llllllllllllIllIIIIlllIIlllIlIIl.age >= this.removeticks.getNumberValue());
        final float llllllllllllIllIIIIlllIlIIllIIll = (float)(Breadcrumbs.mc.player.lastTickPosX + (Breadcrumbs.mc.player.posX - Breadcrumbs.mc.player.lastTickPosX) * llllllllllllIllIIIIlllIlIIlIIIll.getPartialTicks());
        final float llllllllllllIllIIIIlllIlIIllIIlI = (float)(Breadcrumbs.mc.player.lastTickPosY + (Breadcrumbs.mc.player.posY - Breadcrumbs.mc.player.lastTickPosY) * llllllllllllIllIIIIlllIlIIlIIIll.getPartialTicks());
        final float llllllllllllIllIIIIlllIlIIllIIIl = (float)(Breadcrumbs.mc.player.lastTickPosZ + (Breadcrumbs.mc.player.posZ - Breadcrumbs.mc.player.lastTickPosZ) * llllllllllllIllIIIIlllIlIIlIIIll.getPartialTicks());
        this.points.add(new Point(llllllllllllIllIIIIlllIlIIllIIll, llllllllllllIllIIIIlllIlIIllIIlI, llllllllllllIllIIIIlllIlIIllIIIl));
        GL11.glPushMatrix();
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glEnable(2848);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glDisable(2884);
        for (final Point llllllllllllIllIIIIlllIlIIllIIII : this.points) {
            if (this.points.indexOf(llllllllllllIllIIIIlllIlIIllIIII) >= this.points.size() - 1) {
                continue;
            }
            final Point llllllllllllIllIIIIlllIlIIlIllll = this.points.get(this.points.indexOf(llllllllllllIllIIIIlllIlIIllIIII) + 1);
            float llllllllllllIllIIIIlllIlIIlIlllI = this.alpha.getNumberValue();
            if (this.smoothending.getBoolValue()) {
                llllllllllllIllIIIIlllIlIIlIlllI = this.alpha.getNumberValue() * (this.points.indexOf(llllllllllllIllIIIIlllIlIIllIIII) / (float)this.points.size());
            }
            Color llllllllllllIllIIIIlllIlIIlIllIl = Color.WHITE;
            final Color llllllllllllIllIIIIlllIlIIlIllII = new Color(this.onecolor.getColorValue());
            final double llllllllllllIllIIIIlllIlIIIllIIl;
            switch (((String)(llllllllllllIllIIIIlllIlIIIllIIl = (double)this.colorMode.currentMode)).hashCode()) {
                case -1808614770: {
                    if (!((String)llllllllllllIllIIIIlllIlIIIllIIl).equals("Static")) {
                        break;
                    }
                    llllllllllllIllIIIIlllIlIIlIllIl = llllllllllllIllIIIIlllIlIIlIllII;
                    break;
                }
                case 77474681: {
                    if (!((String)llllllllllllIllIIIIlllIlIIIllIIl).equals("Pulse")) {
                        break;
                    }
                    llllllllllllIllIIIIlllIlIIlIllIl = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 6.0f * (llllllllllllIllIIIIlllIlIIllIIII.age / 16.0f) / 60.0f);
                    break;
                }
                case 961091784: {
                    if (!((String)llllllllllllIllIIIIlllIlIIIllIIl).equals("Astolfo")) {
                        break;
                    }
                    llllllllllllIllIIIIlllIlIIlIllIl = DrawHelper.astolfoColors45(llllllllllllIllIIIIlllIlIIllIIII.age - llllllllllllIllIIIIlllIlIIllIIII.age + 1.0f, llllllllllllIllIIIIlllIlIIllIIII.age, 0.5f, 10.0f);
                    break;
                }
                case 2021122027: {
                    if (!((String)llllllllllllIllIIIIlllIlIIIllIIl).equals("Client")) {
                        break;
                    }
                    llllllllllllIllIIIIlllIlIIlIllIl = ClientHelper.getClientColor(llllllllllllIllIIIIlllIlIIllIIII.age / 16.0f, 5.0f, llllllllllllIllIIIIlllIlIIllIIII.age, 5);
                    break;
                }
                case 2029746065: {
                    if (!((String)llllllllllllIllIIIIlllIlIIIllIIl).equals("Custom")) {
                        break;
                    }
                    llllllllllllIllIIIIlllIlIIlIllIl = DrawHelper.TwoColoreffect(new Color(this.onecolor.getColorValue()), new Color(this.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 3.0f * (llllllllllllIllIIIIlllIlIIllIIII.age / 16.0f) / 60.0f);
                    break;
                }
            }
            final Color llllllllllllIllIIIIlllIlIIlIlIll = DrawHelper.setAlpha(llllllllllllIllIIIIlllIlIIlIllIl, (int)llllllllllllIllIIIIlllIlIIlIlllI);
            GL11.glBegin(8);
            final double llllllllllllIllIIIIlllIlIIlIlIlI = llllllllllllIllIIIIlllIlIIllIIII.x - RenderManager.renderPosX;
            final double llllllllllllIllIIIIlllIlIIlIlIIl = llllllllllllIllIIIIlllIlIIllIIII.y - RenderManager.renderPosY;
            final double llllllllllllIllIIIIlllIlIIlIlIII = llllllllllllIllIIIIlllIlIIllIIII.z - RenderManager.renderPosZ;
            final double llllllllllllIllIIIIlllIlIIlIIlll = llllllllllllIllIIIIlllIlIIlIllll.x - RenderManager.renderPosX;
            final double llllllllllllIllIIIIlllIlIIlIIllI = llllllllllllIllIIIIlllIlIIlIllll.y - RenderManager.renderPosY;
            final double llllllllllllIllIIIIlllIlIIlIIlIl = llllllllllllIllIIIIlllIlIIlIllll.z - RenderManager.renderPosZ;
            DrawHelper.glColor(new Color(llllllllllllIllIIIIlllIlIIlIlIll.getRed(), llllllllllllIllIIIIlllIlIIlIlIll.getGreen(), llllllllllllIllIIIIlllIlIIlIlIll.getBlue(), 0).getRGB());
            GL11.glVertex3d(llllllllllllIllIIIIlllIlIIlIlIlI, llllllllllllIllIIIIlllIlIIlIlIIl + Breadcrumbs.mc.player.height - 0.1, llllllllllllIllIIIIlllIlIIlIlIII);
            DrawHelper.glColor(llllllllllllIllIIIIlllIlIIlIlIll.getRGB());
            GL11.glVertex3d(llllllllllllIllIIIIlllIlIIlIlIlI, llllllllllllIllIIIIlllIlIIlIlIIl + 0.2, llllllllllllIllIIIIlllIlIIlIlIII);
            GL11.glVertex3d(llllllllllllIllIIIIlllIlIIlIIlll, llllllllllllIllIIIIlllIlIIlIIllI + Breadcrumbs.mc.player.height - 0.1, llllllllllllIllIIIIlllIlIIlIIlIl);
            GL11.glVertex3d(llllllllllllIllIIIIlllIlIIlIIlll, llllllllllllIllIIIIlllIlIIlIIllI + 0.2, llllllllllllIllIIIIlllIlIIlIIlIl);
            GL11.glEnd();
            final Point point = llllllllllllIllIIIIlllIlIIllIIII;
            ++point.age;
        }
        GlStateManager.resetColor();
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIllIIIIlllIlIlIIlIlI) {
        this.setModuleName("Trails " + TextFormatting.GRAY + this.colorMode.currentMode);
    }
    
    class Point
    {
        public final /* synthetic */ float x;
        public final /* synthetic */ float z;
        public final /* synthetic */ float y;
        public /* synthetic */ float age;
        
        public Point(final float lllllllllllIIIlIIIllIlIlIIlllIII, final float lllllllllllIIIlIIIllIlIlIIllllII, final float lllllllllllIIIlIIIllIlIlIIlllIll) {
            this.age = 0.0f;
            this.x = lllllllllllIIIlIIIllIlIlIIlllIII;
            this.y = lllllllllllIIIlIIIllIlIlIIllllII;
            this.z = lllllllllllIIIlIIIllIlIlIIlllIll;
        }
    }
}
