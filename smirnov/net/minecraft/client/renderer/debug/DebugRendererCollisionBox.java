// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.debug;

import java.util.List;
import net.minecraft.world.World;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class DebugRendererCollisionBox implements DebugRenderer.IDebugRenderer
{
    private /* synthetic */ double field_191314_c;
    private /* synthetic */ EntityPlayer field_191313_b;
    private final /* synthetic */ Minecraft field_191312_a;
    private /* synthetic */ double field_191316_e;
    private /* synthetic */ double field_191315_d;
    
    public DebugRendererCollisionBox(final Minecraft llllllllllllIIlllIIlIIlIIIllIlll) {
        this.field_191312_a = llllllllllllIIlllIIlIIlIIIllIlll;
    }
    
    @Override
    public void render(final float llllllllllllIIlllIIlIIlIIIlIIlll, final long llllllllllllIIlllIIlIIlIIIlIllII) {
        this.field_191313_b = this.field_191312_a.player;
        this.field_191314_c = this.field_191313_b.lastTickPosX + (this.field_191313_b.posX - this.field_191313_b.lastTickPosX) * llllllllllllIIlllIIlIIlIIIlIIlll;
        this.field_191315_d = this.field_191313_b.lastTickPosY + (this.field_191313_b.posY - this.field_191313_b.lastTickPosY) * llllllllllllIIlllIIlIIlIIIlIIlll;
        this.field_191316_e = this.field_191313_b.lastTickPosZ + (this.field_191313_b.posZ - this.field_191313_b.lastTickPosZ) * llllllllllllIIlllIIlIIlIIIlIIlll;
        final World llllllllllllIIlllIIlIIlIIIlIlIll = this.field_191312_a.player.world;
        final List<AxisAlignedBB> llllllllllllIIlllIIlIIlIIIlIlIlI = llllllllllllIIlllIIlIIlIIIlIlIll.getCollisionBoxes(this.field_191313_b, this.field_191313_b.getEntityBoundingBox().expandXyz(6.0));
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth(2.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        for (final AxisAlignedBB llllllllllllIIlllIIlIIlIIIlIlIIl : llllllllllllIIlllIIlIIlIIIlIlIlI) {
            RenderGlobal.drawSelectionBoundingBox(llllllllllllIIlllIIlIIlIIIlIlIIl.expandXyz(0.002).offset(-this.field_191314_c, -this.field_191315_d, -this.field_191316_e), 1.0f, 1.0f, 1.0f, 1.0f);
        }
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
}
