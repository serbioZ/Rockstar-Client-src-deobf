// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.api.event.event.EventRespawn;
import ru.rockstar.api.utils.render.DrawHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.Setting;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import java.util.Iterator;
import com.ibm.icu.math.BigDecimal;
import net.minecraft.util.math.Vec3d;
import java.awt.Color;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import ru.rockstar.api.event.event.EventUpdate;
import java.util.Map;
import java.util.List;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.features.Feature;

public class DamageMarkers extends Feature
{
    private static final /* synthetic */ Minecraft mc;
    public static /* synthetic */ NumberSetting deleteAfter;
    private final /* synthetic */ TimerHelper timerHelper;
    private final /* synthetic */ List<Particle> particles;
    private final /* synthetic */ Map<Integer, Float> hpData;
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIlIlIllIIlIIIllIIlIl) {
        for (final Entity llllllllllllIlIlIllIIlIIIllIIIll : DamageMarkers.mc.world.loadedEntityList) {
            if (llllllllllllIlIlIllIIlIIIllIIIll instanceof EntityLivingBase) {
                final EntityLivingBase llllllllllllIlIlIllIIlIIIllIIIlI = (EntityLivingBase)llllllllllllIlIlIllIIlIIIllIIIll;
                final double llllllllllllIlIlIllIIlIIIllIIIIl = this.hpData.getOrDefault(llllllllllllIlIlIllIIlIIIllIIIlI.getEntityId(), llllllllllllIlIlIllIIlIIIllIIIlI.getMaxHealth());
                this.hpData.remove(llllllllllllIlIlIllIIlIIIllIIIll.getEntityId());
                this.hpData.put(llllllllllllIlIlIllIIlIIIllIIIll.getEntityId(), llllllllllllIlIlIllIIlIIIllIIIlI.getHealth());
                if (llllllllllllIlIlIllIIlIIIllIIIIl == llllllllllllIlIlIllIIlIIIllIIIlI.getHealth()) {
                    continue;
                }
                Color llllllllllllIlIlIllIIlIIIlIlllll = null;
                if (llllllllllllIlIlIllIIlIIIllIIIIl > llllllllllllIlIlIllIIlIIIllIIIlI.getHealth()) {
                    final Color llllllllllllIlIlIllIIlIIIllIIIII = Color.red;
                }
                else {
                    llllllllllllIlIlIllIIlIIIlIlllll = Color.GREEN;
                }
                final Vec3d llllllllllllIlIlIllIIlIIIlIllllI = new Vec3d(llllllllllllIlIlIllIIlIIIllIIIll.posX + Math.random() * 0.5 * ((Math.random() > 0.5) ? -1 : 1), llllllllllllIlIlIllIIlIIIllIIIll.getEntityBoundingBox().minY + (llllllllllllIlIlIllIIlIIIllIIIll.getEntityBoundingBox().maxY - llllllllllllIlIlIllIIlIIIllIIIll.getEntityBoundingBox().minY) * 0.5, llllllllllllIlIlIllIIlIIIllIIIll.posZ + Math.random() * 0.5 * ((Math.random() > 0.5) ? -1 : 1));
                final double llllllllllllIlIlIllIIlIIIlIlllIl = new BigDecimal(Math.abs(llllllllllllIlIlIllIIlIIIllIIIIl - llllllllllllIlIlIllIIlIIIllIIIlI.getHealth())).setScale(1, 4).doubleValue();
                this.particles.add(new Particle(new StringBuilder().append(llllllllllllIlIlIllIIlIIIlIlllIl).toString(), llllllllllllIlIlIllIIlIIIlIllllI.xCoord, llllllllllllIlIlIllIIlIIIlIllllI.yCoord, llllllllllllIlIlIllIIlIIIlIllllI.zCoord, llllllllllllIlIlIllIIlIIIlIlllll));
            }
        }
    }
    
    public DamageMarkers() {
        super("DamageMarkers", "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0435\u0442 \u0440\u0435\u0433\u0435\u043d\u0438\u0440\u0430\u0446\u0438\u044e/\u0434\u0430\u043c\u0430\u0433 \u0432\u0441\u0435\u0445 \u044d\u043d\u0442\u0438\u0442\u0438 \u0432\u043e\u043a\u0440\u0443\u0433", 0, Category.VISUALS);
        this.hpData = (Map<Integer, Float>)Maps.newHashMap();
        this.particles = (List<Particle>)Lists.newArrayList();
        this.timerHelper = new TimerHelper();
        DamageMarkers.deleteAfter = new NumberSetting("Delete After", 7.0f, 1.0f, 20.0f, 1.0f, () -> true);
        this.addSettings(DamageMarkers.deleteAfter);
    }
    
    @EventTarget
    public void onRender3d(final Event3D llllllllllllIlIlIllIIlIIIlIIllll) {
        if (this.timerHelper.hasReached(DamageMarkers.deleteAfter.getNumberValue() * 300.0f)) {
            this.particles.clear();
            this.timerHelper.reset();
        }
        if (!this.particles.isEmpty()) {
            for (final Particle llllllllllllIlIlIllIIlIIIlIIllIl : this.particles) {
                if (llllllllllllIlIlIllIIlIIIlIIllIl != null) {
                    GlStateManager.pushMatrix();
                    GlStateManager.enablePolygonOffset();
                    GlStateManager.doPolygonOffset(1.0f, -1500000.0f);
                    final double posX = llllllllllllIlIlIllIIlIIIlIIllIl.posX;
                    DamageMarkers.mc.getRenderManager();
                    final double lllllllllllIlIIIIIlllIIllIIlIllI = posX - RenderManager.renderPosX;
                    final double posY = llllllllllllIlIlIllIIlIIIlIIllIl.posY;
                    DamageMarkers.mc.getRenderManager();
                    final double lllllllllllIlIIIIIlllIIllIIlIlIl = posY - RenderManager.renderPosY;
                    final double posZ = llllllllllllIlIlIllIIlIIIlIIllIl.posZ;
                    DamageMarkers.mc.getRenderManager();
                    GlStateManager.translate(lllllllllllIlIIIIIlllIIllIIlIllI, lllllllllllIlIIIIIlllIIllIIlIlIl, posZ - RenderManager.renderPosZ);
                    DamageMarkers.mc.getRenderManager();
                    GlStateManager.rotate(-RenderManager.playerViewY, 0.0f, 1.0f, 0.0f);
                    final float llllllllllllIlIlIllIIlIIIlIIllII = (DamageMarkers.mc.gameSettings.thirdPersonView == 2) ? -1.0f : 1.0f;
                    DamageMarkers.mc.getRenderManager();
                    GlStateManager.rotate(RenderManager.playerViewX, llllllllllllIlIlIllIIlIIIlIIllII, 0.0f, 0.0f);
                    GlStateManager.scale(-0.03, -0.03, 0.03);
                    GL11.glDepthMask(false);
                    DrawHelper.drawGlow(-DamageMarkers.mc.mntsb_17.getStringWidth(llllllllllllIlIlIllIIlIIIlIIllIl.str) * 0.5, -Minecraft.fontRendererObj.FONT_HEIGHT + 1 - 5, -DamageMarkers.mc.mntsb_17.getStringWidth(llllllllllllIlIlIllIIlIIIlIIllIl.str) * 0.5 + 10.0, -Minecraft.fontRendererObj.FONT_HEIGHT + 1 + 10, llllllllllllIlIlIllIIlIIIlIIllIl.color.getRGB() - new Color(0, 0, 0, 100).getRGB());
                    DamageMarkers.mc.mntsb_17.drawStringWithShadow(llllllllllllIlIlIllIIlIIIlIIllIl.str, (float)(-DamageMarkers.mc.mntsb_17.getStringWidth(llllllllllllIlIlIllIIlIIIlIIllIl.str) * 0.5), -Minecraft.fontRendererObj.FONT_HEIGHT + 1, llllllllllllIlIlIllIIlIIIlIIllIl.color.getRGB());
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    GL11.glDepthMask(true);
                    GlStateManager.doPolygonOffset(1.0f, 1500000.0f);
                    GlStateManager.disablePolygonOffset();
                    GlStateManager.resetColor();
                    GlStateManager.popMatrix();
                }
            }
        }
    }
    
    @EventTarget
    public void onRespawn(final EventRespawn llllllllllllIlIlIllIIlIIIlllIIII) {
        this.particles.clear();
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
    
    class Particle
    {
        public /* synthetic */ String str;
        public /* synthetic */ Color color;
        public /* synthetic */ double posY;
        public /* synthetic */ double posZ;
        public /* synthetic */ int ticks;
        public /* synthetic */ double posX;
        
        public Particle(final String llllllllllllIIIIIIIIlIllIIIlIlII, final double llllllllllllIIIIIIIIlIllIIIIllII, final double llllllllllllIIIIIIIIlIllIIIlIIlI, final double llllllllllllIIIIIIIIlIllIIIlIIIl, final Color llllllllllllIIIIIIIIlIllIIIIlIIl) {
            this.str = llllllllllllIIIIIIIIlIllIIIlIlII;
            this.posX = llllllllllllIIIIIIIIlIllIIIIllII;
            this.posY = llllllllllllIIIIIIIIlIllIIIlIIlI;
            this.posZ = llllllllllllIIIIIIIIlIllIIIlIIIl;
            this.color = llllllllllllIIIIIIIIlIllIIIIlIIl;
            this.ticks = 0;
        }
    }
}
