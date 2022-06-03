// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.api.event.event.RespawnEvent;
import com.ibm.icu.math.BigDecimal;
import net.minecraft.util.math.Vec3d;
import java.awt.Color;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.api.event.EventTarget;
import java.util.Iterator;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.Setting;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import ru.rockstar.client.features.Category;
import java.util.Map;
import java.util.List;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class DamageParticles extends Feature
{
    public /* synthetic */ NumberSetting deleteAfter;
    private final /* synthetic */ List<Particle> particles;
    private final /* synthetic */ Map<Integer, Float> hpData;
    
    public DamageParticles() {
        super("DamageParticles", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043f\u0430\u0440\u0442\u0438\u043a\u043b\u044b \u0434\u0430\u043c\u0430\u0433\u0430", 0, Category.VISUALS);
        this.deleteAfter = new NumberSetting("Delete After", 7.0f, 1.0f, 20.0f, 1.0f, () -> true);
        this.hpData = (Map<Integer, Float>)Maps.newHashMap();
        this.particles = (List<Particle>)Lists.newArrayList();
        this.addSettings(this.deleteAfter);
    }
    
    @EventTarget
    public void onRender3d(final Event3D llllllllllllIIIIIIIIlIllIlIllIlI) {
        if (DamageParticles.timerHelper.hasReached(this.deleteAfter.getNumberValue() * 300.0f)) {
            this.particles.clear();
            DamageParticles.timerHelper.reset();
        }
        if (!this.particles.isEmpty()) {
            for (final Particle llllllllllllIIIIIIIIlIllIlIllIII : this.particles) {
                if (llllllllllllIIIIIIIIlIllIlIllIII != null) {
                    GlStateManager.pushMatrix();
                    GlStateManager.enablePolygonOffset();
                    GlStateManager.doPolygonOffset(1.0f, -1500000.0f);
                    final double posX = llllllllllllIIIIIIIIlIllIlIllIII.posX;
                    DamageParticles.mc.getRenderManager();
                    final double lllllllllllIlIIIIIlllIIllIIlIllI = posX - RenderManager.renderPosX;
                    final double posY = llllllllllllIIIIIIIIlIllIlIllIII.posY;
                    DamageParticles.mc.getRenderManager();
                    final double lllllllllllIlIIIIIlllIIllIIlIlIl = posY - RenderManager.renderPosY;
                    final double posZ = llllllllllllIIIIIIIIlIllIlIllIII.posZ;
                    DamageParticles.mc.getRenderManager();
                    GlStateManager.translate(lllllllllllIlIIIIIlllIIllIIlIllI, lllllllllllIlIIIIIlllIIllIIlIlIl, posZ - RenderManager.renderPosZ);
                    DamageParticles.mc.getRenderManager();
                    GlStateManager.rotate(-RenderManager.playerViewY, 0.0f, 1.0f, 0.0f);
                    final float llllllllllllIIIIIIIIlIllIlIlIlll = (DamageParticles.mc.gameSettings.thirdPersonView == 2) ? -1.0f : 1.0f;
                    DamageParticles.mc.getRenderManager();
                    GlStateManager.rotate(RenderManager.playerViewX, llllllllllllIIIIIIIIlIllIlIlIlll, 0.0f, 0.0f);
                    GlStateManager.scale(-0.03, -0.03, 0.03);
                    GL11.glDepthMask(false);
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
    public void onUpdate(final EventUpdate llllllllllllIIIIIIIIlIllIlllIIII) {
        for (final Entity llllllllllllIIIIIIIIlIllIllIlllI : DamageParticles.mc.world.loadedEntityList) {
            if (llllllllllllIIIIIIIIlIllIllIlllI instanceof EntityLivingBase) {
                final EntityLivingBase llllllllllllIIIIIIIIlIllIllIllIl = (EntityLivingBase)llllllllllllIIIIIIIIlIllIllIlllI;
                final double llllllllllllIIIIIIIIlIllIllIllII = this.hpData.getOrDefault(llllllllllllIIIIIIIIlIllIllIllIl.getEntityId(), llllllllllllIIIIIIIIlIllIllIllIl.getMaxHealth());
                this.hpData.remove(llllllllllllIIIIIIIIlIllIllIlllI.getEntityId());
                this.hpData.put(llllllllllllIIIIIIIIlIllIllIlllI.getEntityId(), llllllllllllIIIIIIIIlIllIllIllIl.getHealth());
                if (llllllllllllIIIIIIIIlIllIllIllII == llllllllllllIIIIIIIIlIllIllIllIl.getHealth()) {
                    continue;
                }
                Color llllllllllllIIIIIIIIlIllIllIlIlI = null;
                if (llllllllllllIIIIIIIIlIllIllIllII > llllllllllllIIIIIIIIlIllIllIllIl.getHealth()) {
                    final Color llllllllllllIIIIIIIIlIllIllIlIll = Color.red;
                }
                else {
                    llllllllllllIIIIIIIIlIllIllIlIlI = Color.GREEN;
                }
                final Vec3d llllllllllllIIIIIIIIlIllIllIlIIl = new Vec3d(llllllllllllIIIIIIIIlIllIllIlllI.posX + Math.random() * 0.5 * ((Math.random() > 0.5) ? -1 : 1), llllllllllllIIIIIIIIlIllIllIlllI.getEntityBoundingBox().minY + (llllllllllllIIIIIIIIlIllIllIlllI.getEntityBoundingBox().maxY - llllllllllllIIIIIIIIlIllIllIlllI.getEntityBoundingBox().minY) * 0.5, llllllllllllIIIIIIIIlIllIllIlllI.posZ + Math.random() * 0.5 * ((Math.random() > 0.5) ? -1 : 1));
                final double llllllllllllIIIIIIIIlIllIllIlIII = new BigDecimal(Math.abs(llllllllllllIIIIIIIIlIllIllIllII - llllllllllllIIIIIIIIlIllIllIllIl.getHealth())).setScale(1, 4).doubleValue();
                this.particles.add(new Particle(new StringBuilder().append(llllllllllllIIIIIIIIlIllIllIlIII).toString(), llllllllllllIIIIIIIIlIllIllIlIIl.xCoord, llllllllllllIIIIIIIIlIllIllIlIIl.yCoord, llllllllllllIIIIIIIIlIllIllIlIIl.zCoord, llllllllllllIIIIIIIIlIllIllIlIlI));
            }
        }
    }
    
    @EventTarget
    public void onRespawn(final RespawnEvent llllllllllllIIIIIIIIlIllIllllIll) {
        this.particles.clear();
    }
    
    class Particle
    {
        public /* synthetic */ double posX;
        public /* synthetic */ String str;
        public /* synthetic */ int ticks;
        public /* synthetic */ double posZ;
        public /* synthetic */ double posY;
        public /* synthetic */ Color color;
        
        public Particle(final String llllllllllllIIIIIIIIIIlIIIIIlIll, final double llllllllllllIIIIIIIIIIlIIIIIlIlI, final double llllllllllllIIIIIIIIIIlIIIIIIIlI, final double llllllllllllIIIIIIIIIIlIIIIIlIII, final Color llllllllllllIIIIIIIIIIlIIIIIIIII) {
            this.str = llllllllllllIIIIIIIIIIlIIIIIlIll;
            this.posX = llllllllllllIIIIIIIIIIlIIIIIlIlI;
            this.posY = llllllllllllIIIIIIIIIIlIIIIIIIlI;
            this.posZ = llllllllllllIIIIIIIIIIlIIIIIlIII;
            this.color = llllllllllllIIIIIIIIIIlIIIIIIIII;
            this.ticks = 0;
        }
    }
}
