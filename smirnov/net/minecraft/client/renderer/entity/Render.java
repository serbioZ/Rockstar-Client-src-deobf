// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLiving;
import shadersmod.client.Shaders;
import optifine.Config;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ResourceLocation;
import net.optifine.entity.model.IEntityRenderer;
import net.minecraft.entity.Entity;

public abstract class Render<T extends Entity> implements IEntityRenderer
{
    protected /* synthetic */ boolean renderOutlines;
    private /* synthetic */ ResourceLocation locationTextureCustom;
    private static final /* synthetic */ ResourceLocation SHADOW_TEXTURES;
    protected final /* synthetic */ RenderManager renderManager;
    protected /* synthetic */ float shadowOpaque;
    public /* synthetic */ float shadowSize;
    private /* synthetic */ Class entityClass;
    
    public void bindTexture(final ResourceLocation lllllllllllIIIIllIlIlllIIIIllllI) {
        this.renderManager.renderEngine.bindTexture(lllllllllllIIIIllIlIlllIIIIllllI);
    }
    
    @Override
    public Class getEntityClass() {
        return this.entityClass;
    }
    
    protected int getTeamColor(final T lllllllllllIIIIllIlIlllIIlIlIlII) {
        int lllllllllllIIIIllIlIlllIIlIllIII = 16777215;
        final ScorePlayerTeam lllllllllllIIIIllIlIlllIIlIlIlll = (ScorePlayerTeam)lllllllllllIIIIllIlIlllIIlIlIlII.getTeam();
        if (lllllllllllIIIIllIlIlllIIlIlIlll != null) {
            final String lllllllllllIIIIllIlIlllIIlIlIllI = FontRenderer.getFormatFromString(lllllllllllIIIIllIlIlllIIlIlIlll.getColorPrefix());
            if (lllllllllllIIIIllIlIlllIIlIlIllI.length() >= 2) {
                lllllllllllIIIIllIlIlllIIlIllIII = this.getFontRendererFromRenderManager().getColorCode(lllllllllllIIIIllIlIlllIIlIlIllI.charAt(1));
            }
        }
        return lllllllllllIIIIllIlIlllIIlIllIII;
    }
    
    public void doRenderShadowAndFire(final Entity lllllllllllIIIIllIlIllIlIIlIIIIl, final double lllllllllllIIIIllIlIllIlIIlIIIII, final double lllllllllllIIIIllIlIllIlIIIlIllI, final double lllllllllllIIIIllIlIllIlIIIllllI, final float lllllllllllIIIIllIlIllIlIIIlllIl, final float lllllllllllIIIIllIlIllIlIIIlIlII) {
        if (this.renderManager.options != null) {
            if (this.renderManager.options.entityShadows && this.shadowSize > 0.0f && !lllllllllllIIIIllIlIllIlIIlIIIIl.isInvisible() && this.renderManager.isRenderShadow()) {
                final double lllllllllllIIIIllIlIllIlIIIllIll = this.renderManager.getDistanceToCamera(lllllllllllIIIIllIlIllIlIIlIIIIl.posX, lllllllllllIIIIllIlIllIlIIlIIIIl.posY, lllllllllllIIIIllIlIllIlIIlIIIIl.posZ);
                final float lllllllllllIIIIllIlIllIlIIIllIlI = (float)((1.0 - lllllllllllIIIIllIlIllIlIIIllIll / 256.0) * this.shadowOpaque);
                if (lllllllllllIIIIllIlIllIlIIIllIlI > 0.0f) {
                    this.renderShadow(lllllllllllIIIIllIlIllIlIIlIIIIl, lllllllllllIIIIllIlIllIlIIlIIIII, lllllllllllIIIIllIlIllIlIIIlIllI, lllllllllllIIIIllIlIllIlIIIllllI, lllllllllllIIIIllIlIllIlIIIllIlI, lllllllllllIIIIllIlIllIlIIIlIlII);
                }
            }
            if (lllllllllllIIIIllIlIllIlIIlIIIIl.canRenderOnFire() && (!(lllllllllllIIIIllIlIllIlIIlIIIIl instanceof EntityPlayer) || !((EntityPlayer)lllllllllllIIIIllIlIllIlIIlIIIIl).isSpectator())) {
                this.renderEntityOnFire(lllllllllllIIIIllIlIllIlIIlIIIIl, lllllllllllIIIIllIlIllIlIIlIIIII, lllllllllllIIIIllIlIllIlIIIlIllI, lllllllllllIIIIllIlIllIlIIIllllI, lllllllllllIIIIllIlIllIlIIIlIlII);
            }
        }
    }
    
    public static void renderOffsetAABB(final AxisAlignedBB lllllllllllIIIIllIlIllIlIIllIllI, final double lllllllllllIIIIllIlIllIlIIlIllll, final double lllllllllllIIIIllIlIllIlIIlIlllI, final double lllllllllllIIIIllIlIllIlIIllIIll) {
        GlStateManager.disableTexture2D();
        final Tessellator lllllllllllIIIIllIlIllIlIIllIIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIIllIlIllIlIIllIIIl = lllllllllllIIIIllIlIllIlIIllIIlI.getBuffer();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        lllllllllllIIIIllIlIllIlIIllIIIl.setTranslation(lllllllllllIIIIllIlIllIlIIlIllll, lllllllllllIIIIllIlIllIlIIlIlllI, lllllllllllIIIIllIlIllIlIIllIIll);
        lllllllllllIIIIllIlIllIlIIllIIIl.begin(7, DefaultVertexFormats.POSITION_NORMAL);
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.minX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.minZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.maxY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIIl.pos(lllllllllllIIIIllIlIllIlIIllIllI.maxX, lllllllllllIIIIllIlIllIlIIllIllI.minY, lllllllllllIIIIllIlIllIlIIllIllI.maxZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        lllllllllllIIIIllIlIllIlIIllIIlI.draw();
        lllllllllllIIIIllIlIllIlIIllIIIl.setTranslation(0.0, 0.0, 0.0);
        GlStateManager.enableTexture2D();
    }
    
    static {
        SHADOW_TEXTURES = new ResourceLocation("textures/misc/shadow.png");
    }
    
    private void renderShadow(final Entity lllllllllllIIIIllIlIllIllIlllIlI, final double lllllllllllIIIIllIlIllIllIIlllll, final double lllllllllllIIIIllIlIllIllIlllIII, final double lllllllllllIIIIllIlIllIllIIlllIl, final float lllllllllllIIIIllIlIllIllIllIllI, final float lllllllllllIIIIllIlIllIllIIllIll) {
        if (!Config.isShaders() || !Shaders.shouldSkipDefaultShadow) {
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.renderManager.renderEngine.bindTexture(Render.SHADOW_TEXTURES);
            final World lllllllllllIIIIllIlIllIllIllIlII = this.getWorldFromRenderManager();
            GlStateManager.depthMask(false);
            float lllllllllllIIIIllIlIllIllIllIIll = this.shadowSize;
            if (lllllllllllIIIIllIlIllIllIlllIlI instanceof EntityLiving) {
                final EntityLiving lllllllllllIIIIllIlIllIllIllIIlI = (EntityLiving)lllllllllllIIIIllIlIllIllIlllIlI;
                lllllllllllIIIIllIlIllIllIllIIll *= lllllllllllIIIIllIlIllIllIllIIlI.getRenderSizeModifier();
                if (lllllllllllIIIIllIlIllIllIllIIlI.isChild()) {
                    lllllllllllIIIIllIlIllIllIllIIll *= 0.5f;
                }
            }
            final double lllllllllllIIIIllIlIllIllIllIIIl = lllllllllllIIIIllIlIllIllIlllIlI.lastTickPosX + (lllllllllllIIIIllIlIllIllIlllIlI.posX - lllllllllllIIIIllIlIllIllIlllIlI.lastTickPosX) * lllllllllllIIIIllIlIllIllIIllIll;
            final double lllllllllllIIIIllIlIllIllIllIIII = lllllllllllIIIIllIlIllIllIlllIlI.lastTickPosY + (lllllllllllIIIIllIlIllIllIlllIlI.posY - lllllllllllIIIIllIlIllIllIlllIlI.lastTickPosY) * lllllllllllIIIIllIlIllIllIIllIll;
            final double lllllllllllIIIIllIlIllIllIlIllll = lllllllllllIIIIllIlIllIllIlllIlI.lastTickPosZ + (lllllllllllIIIIllIlIllIllIlllIlI.posZ - lllllllllllIIIIllIlIllIllIlllIlI.lastTickPosZ) * lllllllllllIIIIllIlIllIllIIllIll;
            final int lllllllllllIIIIllIlIllIllIlIlllI = MathHelper.floor(lllllllllllIIIIllIlIllIllIllIIIl - lllllllllllIIIIllIlIllIllIllIIll);
            final int lllllllllllIIIIllIlIllIllIlIllIl = MathHelper.floor(lllllllllllIIIIllIlIllIllIllIIIl + lllllllllllIIIIllIlIllIllIllIIll);
            final int lllllllllllIIIIllIlIllIllIlIllII = MathHelper.floor(lllllllllllIIIIllIlIllIllIllIIII - lllllllllllIIIIllIlIllIllIllIIll);
            final int lllllllllllIIIIllIlIllIllIlIlIll = MathHelper.floor(lllllllllllIIIIllIlIllIllIllIIII);
            final int lllllllllllIIIIllIlIllIllIlIlIlI = MathHelper.floor(lllllllllllIIIIllIlIllIllIlIllll - lllllllllllIIIIllIlIllIllIllIIll);
            final int lllllllllllIIIIllIlIllIllIlIlIIl = MathHelper.floor(lllllllllllIIIIllIlIllIllIlIllll + lllllllllllIIIIllIlIllIllIllIIll);
            final double lllllllllllIIIIllIlIllIllIlIlIII = lllllllllllIIIIllIlIllIllIIlllll - lllllllllllIIIIllIlIllIllIllIIIl;
            final double lllllllllllIIIIllIlIllIllIlIIlll = lllllllllllIIIIllIlIllIllIlllIII - lllllllllllIIIIllIlIllIllIllIIII;
            final double lllllllllllIIIIllIlIllIllIlIIllI = lllllllllllIIIIllIlIllIllIIlllIl - lllllllllllIIIIllIlIllIllIlIllll;
            final Tessellator lllllllllllIIIIllIlIllIllIlIIlIl = Tessellator.getInstance();
            final BufferBuilder lllllllllllIIIIllIlIllIllIlIIlII = lllllllllllIIIIllIlIllIllIlIIlIl.getBuffer();
            lllllllllllIIIIllIlIllIllIlIIlII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            for (final BlockPos lllllllllllIIIIllIlIllIllIlIIIll : BlockPos.getAllInBoxMutable(new BlockPos(lllllllllllIIIIllIlIllIllIlIlllI, lllllllllllIIIIllIlIllIllIlIllII, lllllllllllIIIIllIlIllIllIlIlIlI), new BlockPos(lllllllllllIIIIllIlIllIllIlIllIl, lllllllllllIIIIllIlIllIllIlIlIll, lllllllllllIIIIllIlIllIllIlIlIIl))) {
                final IBlockState lllllllllllIIIIllIlIllIllIlIIIlI = lllllllllllIIIIllIlIllIllIllIlII.getBlockState(lllllllllllIIIIllIlIllIllIlIIIll.down());
                if (lllllllllllIIIIllIlIllIllIlIIIlI.getRenderType() != EnumBlockRenderType.INVISIBLE && lllllllllllIIIIllIlIllIllIllIlII.getLightFromNeighbors(lllllllllllIIIIllIlIllIllIlIIIll) > 3) {
                    this.renderShadowSingle(lllllllllllIIIIllIlIllIllIlIIIlI, lllllllllllIIIIllIlIllIllIIlllll, lllllllllllIIIIllIlIllIllIlllIII, lllllllllllIIIIllIlIllIllIIlllIl, lllllllllllIIIIllIlIllIllIlIIIll, lllllllllllIIIIllIlIllIllIllIllI, lllllllllllIIIIllIlIllIllIllIIll, lllllllllllIIIIllIlIllIllIlIlIII, lllllllllllIIIIllIlIllIllIlIIlll, lllllllllllIIIIllIlIllIllIlIIllI);
                }
            }
            lllllllllllIIIIllIlIllIllIlIIlIl.draw();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
        }
    }
    
    public boolean shouldRender(final T lllllllllllIIIIllIlIlllIIlllIllI, final ICamera lllllllllllIIIIllIlIlllIIllllIll, final double lllllllllllIIIIllIlIlllIIllllIlI, final double lllllllllllIIIIllIlIlllIIlllIIll, final double lllllllllllIIIIllIlIlllIIllllIII) {
        AxisAlignedBB lllllllllllIIIIllIlIlllIIlllIlll = lllllllllllIIIIllIlIlllIIlllIllI.getRenderBoundingBox().expandXyz(0.5);
        if (lllllllllllIIIIllIlIlllIIlllIlll.hasNaN() || lllllllllllIIIIllIlIlllIIlllIlll.getAverageEdgeLength() == 0.0) {
            lllllllllllIIIIllIlIlllIIlllIlll = new AxisAlignedBB(lllllllllllIIIIllIlIlllIIlllIllI.posX - 2.0, lllllllllllIIIIllIlIlllIIlllIllI.posY - 2.0, lllllllllllIIIIllIlIlllIIlllIllI.posZ - 2.0, lllllllllllIIIIllIlIlllIIlllIllI.posX + 2.0, lllllllllllIIIIllIlIlllIIlllIllI.posY + 2.0, lllllllllllIIIIllIlIlllIIlllIllI.posZ + 2.0);
        }
        return lllllllllllIIIIllIlIlllIIlllIllI.isInRangeToRender3d(lllllllllllIIIIllIlIlllIIllllIlI, lllllllllllIIIIllIlIlllIIlllIIll, lllllllllllIIIIllIlIlllIIllllIII) && (lllllllllllIIIIllIlIlllIIlllIllI.ignoreFrustumCheck || lllllllllllIIIIllIlIlllIIllllIll.isBoundingBoxInFrustum(lllllllllllIIIIllIlIlllIIlllIlll));
    }
    
    @Nullable
    protected abstract ResourceLocation getEntityTexture(final T p0);
    
    private void renderEntityOnFire(final Entity lllllllllllIIIIllIlIlllIIIIIIIll, final double lllllllllllIIIIllIlIlllIIIIIIIlI, final double lllllllllllIIIIllIlIlllIIIIIIIIl, final double lllllllllllIIIIllIlIllIllllIlIII, final float lllllllllllIIIIllIlIllIlllllllll) {
        GlStateManager.disableLighting();
        final TextureMap lllllllllllIIIIllIlIllIllllllllI = Minecraft.getMinecraft().getTextureMapBlocks();
        final TextureAtlasSprite lllllllllllIIIIllIlIllIlllllllIl = lllllllllllIIIIllIlIllIllllllllI.getAtlasSprite("minecraft:blocks/fire_layer_0");
        final TextureAtlasSprite lllllllllllIIIIllIlIllIlllllllII = lllllllllllIIIIllIlIllIllllllllI.getAtlasSprite("minecraft:blocks/fire_layer_1");
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllIIIIllIlIlllIIIIIIIlI, (float)lllllllllllIIIIllIlIlllIIIIIIIIl, (float)lllllllllllIIIIllIlIllIllllIlIII);
        final float lllllllllllIIIIllIlIllIllllllIll = lllllllllllIIIIllIlIlllIIIIIIIll.width * 1.4f;
        GlStateManager.scale(lllllllllllIIIIllIlIllIllllllIll, lllllllllllIIIIllIlIllIllllllIll, lllllllllllIIIIllIlIllIllllllIll);
        final Tessellator lllllllllllIIIIllIlIllIllllllIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIIllIlIllIllllllIIl = lllllllllllIIIIllIlIllIllllllIlI.getBuffer();
        float lllllllllllIIIIllIlIllIllllllIII = 0.5f;
        final float lllllllllllIIIIllIlIllIlllllIlll = 0.0f;
        float lllllllllllIIIIllIlIllIlllllIllI = lllllllllllIIIIllIlIlllIIIIIIIll.height / lllllllllllIIIIllIlIllIllllllIll;
        float lllllllllllIIIIllIlIllIlllllIlIl = (float)(lllllllllllIIIIllIlIlllIIIIIIIll.posY - lllllllllllIIIIllIlIlllIIIIIIIll.getEntityBoundingBox().minY);
        GlStateManager.rotate(-RenderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.0f, -0.3f + (int)lllllllllllIIIIllIlIllIlllllIllI * 0.02f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        float lllllllllllIIIIllIlIllIlllllIlII = 0.0f;
        int lllllllllllIIIIllIlIllIlllllIIll = 0;
        lllllllllllIIIIllIlIllIllllllIIl.begin(7, DefaultVertexFormats.POSITION_TEX);
        while (lllllllllllIIIIllIlIllIlllllIllI > 0.0f) {
            final TextureAtlasSprite lllllllllllIIIIllIlIllIlllllIIlI = (lllllllllllIIIIllIlIllIlllllIIll % 2 == 0) ? lllllllllllIIIIllIlIllIlllllllIl : lllllllllllIIIIllIlIllIlllllllII;
            this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float lllllllllllIIIIllIlIllIlllllIIIl = lllllllllllIIIIllIlIllIlllllIIlI.getMinU();
            final float lllllllllllIIIIllIlIllIlllllIIII = lllllllllllIIIIllIlIllIlllllIIlI.getMinV();
            float lllllllllllIIIIllIlIllIllllIllll = lllllllllllIIIIllIlIllIlllllIIlI.getMaxU();
            final float lllllllllllIIIIllIlIllIllllIlllI = lllllllllllIIIIllIlIllIlllllIIlI.getMaxV();
            if (lllllllllllIIIIllIlIllIlllllIIll / 2 % 2 == 0) {
                final float lllllllllllIIIIllIlIllIllllIllIl = lllllllllllIIIIllIlIllIllllIllll;
                lllllllllllIIIIllIlIllIllllIllll = lllllllllllIIIIllIlIllIlllllIIIl;
                lllllllllllIIIIllIlIllIlllllIIIl = lllllllllllIIIIllIlIllIllllIllIl;
            }
            lllllllllllIIIIllIlIllIllllllIIl.pos(lllllllllllIIIIllIlIllIllllllIII - 0.0f, 0.0f - lllllllllllIIIIllIlIllIlllllIlIl, lllllllllllIIIIllIlIllIlllllIlII).tex(lllllllllllIIIIllIlIllIllllIllll, lllllllllllIIIIllIlIllIllllIlllI).endVertex();
            lllllllllllIIIIllIlIllIllllllIIl.pos(-lllllllllllIIIIllIlIllIllllllIII - 0.0f, 0.0f - lllllllllllIIIIllIlIllIlllllIlIl, lllllllllllIIIIllIlIllIlllllIlII).tex(lllllllllllIIIIllIlIllIlllllIIIl, lllllllllllIIIIllIlIllIllllIlllI).endVertex();
            lllllllllllIIIIllIlIllIllllllIIl.pos(-lllllllllllIIIIllIlIllIllllllIII - 0.0f, 1.4f - lllllllllllIIIIllIlIllIlllllIlIl, lllllllllllIIIIllIlIllIlllllIlII).tex(lllllllllllIIIIllIlIllIlllllIIIl, lllllllllllIIIIllIlIllIlllllIIII).endVertex();
            lllllllllllIIIIllIlIllIllllllIIl.pos(lllllllllllIIIIllIlIllIllllllIII - 0.0f, 1.4f - lllllllllllIIIIllIlIllIlllllIlIl, lllllllllllIIIIllIlIllIlllllIlII).tex(lllllllllllIIIIllIlIllIllllIllll, lllllllllllIIIIllIlIllIlllllIIII).endVertex();
            lllllllllllIIIIllIlIllIlllllIllI -= 0.45f;
            lllllllllllIIIIllIlIllIlllllIlIl -= 0.45f;
            lllllllllllIIIIllIlIllIllllllIII *= 0.9f;
            lllllllllllIIIIllIlIllIlllllIlII += 0.03f;
            ++lllllllllllIIIIllIlIllIlllllIIll;
        }
        lllllllllllIIIIllIlIllIllllllIlI.draw();
        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
    }
    
    protected boolean canRenderName(final T lllllllllllIIIIllIlIlllIIIlllllI) {
        return lllllllllllIIIIllIlIlllIIIlllllI.getAlwaysRenderNameTagForRender() && lllllllllllIIIIllIlIlllIIIlllllI.hasCustomName();
    }
    
    protected void renderEntityName(final T lllllllllllIIIIllIlIlllIIIllIllI, final double lllllllllllIIIIllIlIlllIIIlIlllI, final double lllllllllllIIIIllIlIlllIIIlIllIl, final double lllllllllllIIIIllIlIlllIIIllIIll, final String lllllllllllIIIIllIlIlllIIIllIIlI, final double lllllllllllIIIIllIlIlllIIIllIIIl) {
        this.renderLivingLabel(lllllllllllIIIIllIlIlllIIIllIllI, lllllllllllIIIIllIlIlllIIIllIIlI, lllllllllllIIIIllIlIlllIIIlIlllI, lllllllllllIIIIllIlIlllIIIlIllIl, lllllllllllIIIIllIlIlllIIIllIIll, 64);
    }
    
    protected boolean bindEntityTexture(final T lllllllllllIIIIllIlIlllIIIlIIllI) {
        ResourceLocation lllllllllllIIIIllIlIlllIIIlIIlIl = this.getEntityTexture(lllllllllllIIIIllIlIlllIIIlIIllI);
        if (this.locationTextureCustom != null) {
            lllllllllllIIIIllIlIlllIIIlIIlIl = this.locationTextureCustom;
        }
        if (lllllllllllIIIIllIlIlllIIIlIIlIl == null) {
            return false;
        }
        this.bindTexture(lllllllllllIIIIllIlIlllIIIlIIlIl);
        return true;
    }
    
    public void doRender(final T lllllllllllIIIIllIlIlllIIllIlIlI, final double lllllllllllIIIIllIlIlllIIllIlIIl, final double lllllllllllIIIIllIlIlllIIllIlIII, final double lllllllllllIIIIllIlIlllIIllIIIII, final float lllllllllllIIIIllIlIlllIIllIIllI, final float lllllllllllIIIIllIlIlllIIllIIlIl) {
        if (!this.renderOutlines) {
            this.renderName(lllllllllllIIIIllIlIlllIIllIlIlI, lllllllllllIIIIllIlIlllIIllIlIIl, lllllllllllIIIIllIlIlllIIllIlIII, lllllllllllIIIIllIlIlllIIllIIIII);
        }
    }
    
    @Override
    public ResourceLocation getLocationTextureCustom() {
        return this.locationTextureCustom;
    }
    
    protected Render(final RenderManager lllllllllllIIIIllIlIlllIlIIIllII) {
        this.shadowOpaque = 1.0f;
        this.entityClass = null;
        this.locationTextureCustom = null;
        this.renderManager = lllllllllllIIIIllIlIlllIlIIIllII;
    }
    
    public RenderManager getRenderManager() {
        return this.renderManager;
    }
    
    public boolean isMultipass() {
        return false;
    }
    
    protected void renderName(final T lllllllllllIIIIllIlIlllIIlIIIlIl, final double lllllllllllIIIIllIlIlllIIlIIlIIl, final double lllllllllllIIIIllIlIlllIIlIIlIII, final double lllllllllllIIIIllIlIlllIIlIIIIlI) {
        if (this.canRenderName(lllllllllllIIIIllIlIlllIIlIIIlIl)) {
            this.renderLivingLabel(lllllllllllIIIIllIlIlllIIlIIIlIl, lllllllllllIIIIllIlIlllIIlIIIlIl.getDisplayName().getFormattedText(), lllllllllllIIIIllIlIlllIIlIIlIIl, lllllllllllIIIIllIlIlllIIlIIlIII, lllllllllllIIIIllIlIlllIIlIIIIlI, 64);
        }
    }
    
    private void renderShadowSingle(final IBlockState lllllllllllIIIIllIlIllIlIlIlIIlI, final double lllllllllllIIIIllIlIllIlIlIlIIII, final double lllllllllllIIIIllIlIllIlIlIIllIl, final double lllllllllllIIIIllIlIllIlIlIIllII, final BlockPos lllllllllllIIIIllIlIllIlIlIIlIll, final float lllllllllllIIIIllIlIllIlIllIIllI, final float lllllllllllIIIIllIlIllIlIllIIlIl, final double lllllllllllIIIIllIlIllIlIllIIlII, final double lllllllllllIIIIllIlIllIlIlIIIlll, final double lllllllllllIIIIllIlIllIlIllIIIlI) {
        if (lllllllllllIIIIllIlIllIlIlIlIIlI.isFullCube()) {
            final Tessellator lllllllllllIIIIllIlIllIlIllIIIIl = Tessellator.getInstance();
            final BufferBuilder lllllllllllIIIIllIlIllIlIllIIIII = lllllllllllIIIIllIlIllIlIllIIIIl.getBuffer();
            double lllllllllllIIIIllIlIllIlIlIlllll = (lllllllllllIIIIllIlIllIlIllIIllI - (lllllllllllIIIIllIlIllIlIlIIllIl - (lllllllllllIIIIllIlIllIlIlIIlIll.getY() + lllllllllllIIIIllIlIllIlIlIIIlll)) / 2.0) * 0.5 * this.getWorldFromRenderManager().getLightBrightness(lllllllllllIIIIllIlIllIlIlIIlIll);
            if (lllllllllllIIIIllIlIllIlIlIlllll >= 0.0) {
                if (lllllllllllIIIIllIlIllIlIlIlllll > 1.0) {
                    lllllllllllIIIIllIlIllIlIlIlllll = 1.0;
                }
                final AxisAlignedBB lllllllllllIIIIllIlIllIlIlIllllI = lllllllllllIIIIllIlIllIlIlIlIIlI.getBoundingBox(this.getWorldFromRenderManager(), lllllllllllIIIIllIlIllIlIlIIlIll);
                final double lllllllllllIIIIllIlIllIlIlIlllIl = lllllllllllIIIIllIlIllIlIlIIlIll.getX() + lllllllllllIIIIllIlIllIlIlIllllI.minX + lllllllllllIIIIllIlIllIlIllIIlII;
                final double lllllllllllIIIIllIlIllIlIlIlllII = lllllllllllIIIIllIlIllIlIlIIlIll.getX() + lllllllllllIIIIllIlIllIlIlIllllI.maxX + lllllllllllIIIIllIlIllIlIllIIlII;
                final double lllllllllllIIIIllIlIllIlIlIllIll = lllllllllllIIIIllIlIllIlIlIIlIll.getY() + lllllllllllIIIIllIlIllIlIlIllllI.minY + lllllllllllIIIIllIlIllIlIlIIIlll + 0.015625;
                final double lllllllllllIIIIllIlIllIlIlIllIlI = lllllllllllIIIIllIlIllIlIlIIlIll.getZ() + lllllllllllIIIIllIlIllIlIlIllllI.minZ + lllllllllllIIIIllIlIllIlIllIIIlI;
                final double lllllllllllIIIIllIlIllIlIlIllIIl = lllllllllllIIIIllIlIllIlIlIIlIll.getZ() + lllllllllllIIIIllIlIllIlIlIllllI.maxZ + lllllllllllIIIIllIlIllIlIllIIIlI;
                final float lllllllllllIIIIllIlIllIlIlIllIII = (float)((lllllllllllIIIIllIlIllIlIlIlIIII - lllllllllllIIIIllIlIllIlIlIlllIl) / 2.0 / lllllllllllIIIIllIlIllIlIllIIlIl + 0.5);
                final float lllllllllllIIIIllIlIllIlIlIlIlll = (float)((lllllllllllIIIIllIlIllIlIlIlIIII - lllllllllllIIIIllIlIllIlIlIlllII) / 2.0 / lllllllllllIIIIllIlIllIlIllIIlIl + 0.5);
                final float lllllllllllIIIIllIlIllIlIlIlIllI = (float)((lllllllllllIIIIllIlIllIlIlIIllII - lllllllllllIIIIllIlIllIlIlIllIlI) / 2.0 / lllllllllllIIIIllIlIllIlIllIIlIl + 0.5);
                final float lllllllllllIIIIllIlIllIlIlIlIlIl = (float)((lllllllllllIIIIllIlIllIlIlIIllII - lllllllllllIIIIllIlIllIlIlIllIIl) / 2.0 / lllllllllllIIIIllIlIllIlIllIIlIl + 0.5);
                lllllllllllIIIIllIlIllIlIllIIIII.pos(lllllllllllIIIIllIlIllIlIlIlllIl, lllllllllllIIIIllIlIllIlIlIllIll, lllllllllllIIIIllIlIllIlIlIllIlI).tex(lllllllllllIIIIllIlIllIlIlIllIII, lllllllllllIIIIllIlIllIlIlIlIllI).color(1.0f, 1.0f, 1.0f, (float)lllllllllllIIIIllIlIllIlIlIlllll).endVertex();
                lllllllllllIIIIllIlIllIlIllIIIII.pos(lllllllllllIIIIllIlIllIlIlIlllIl, lllllllllllIIIIllIlIllIlIlIllIll, lllllllllllIIIIllIlIllIlIlIllIIl).tex(lllllllllllIIIIllIlIllIlIlIllIII, lllllllllllIIIIllIlIllIlIlIlIlIl).color(1.0f, 1.0f, 1.0f, (float)lllllllllllIIIIllIlIllIlIlIlllll).endVertex();
                lllllllllllIIIIllIlIllIlIllIIIII.pos(lllllllllllIIIIllIlIllIlIlIlllII, lllllllllllIIIIllIlIllIlIlIllIll, lllllllllllIIIIllIlIllIlIlIllIIl).tex(lllllllllllIIIIllIlIllIlIlIlIlll, lllllllllllIIIIllIlIllIlIlIlIlIl).color(1.0f, 1.0f, 1.0f, (float)lllllllllllIIIIllIlIllIlIlIlllll).endVertex();
                lllllllllllIIIIllIlIllIlIllIIIII.pos(lllllllllllIIIIllIlIllIlIlIlllII, lllllllllllIIIIllIlIllIlIlIllIll, lllllllllllIIIIllIlIllIlIlIllIlI).tex(lllllllllllIIIIllIlIllIlIlIlIlll, lllllllllllIIIIllIlIllIlIlIlIllI).color(1.0f, 1.0f, 1.0f, (float)lllllllllllIIIIllIlIllIlIlIlllll).endVertex();
            }
        }
    }
    
    public FontRenderer getFontRendererFromRenderManager() {
        return this.renderManager.getFontRenderer();
    }
    
    @Override
    public void setLocationTextureCustom(final ResourceLocation lllllllllllIIIIllIlIllIIllIIlIII) {
        this.locationTextureCustom = lllllllllllIIIIllIlIllIIllIIlIII;
    }
    
    @Override
    public void setEntityClass(final Class lllllllllllIIIIllIlIllIIllIlIIIl) {
        this.entityClass = lllllllllllIIIIllIlIllIIllIlIIIl;
    }
    
    public void setRenderOutlines(final boolean lllllllllllIIIIllIlIlllIlIIIIlII) {
        this.renderOutlines = lllllllllllIIIIllIlIlllIlIIIIlII;
    }
    
    private World getWorldFromRenderManager() {
        return this.renderManager.worldObj;
    }
    
    protected void renderLivingLabel(final T lllllllllllIIIIllIlIllIIllllIIIl, final String lllllllllllIIIIllIlIllIIllllIIII, final double lllllllllllIIIIllIlIllIIlllIllll, final double lllllllllllIIIIllIlIllIIllllllII, final double lllllllllllIIIIllIlIllIIlllIllIl, final int lllllllllllIIIIllIlIllIIlllllIlI) {
        final double lllllllllllIIIIllIlIllIIlllllIIl = lllllllllllIIIIllIlIllIIllllIIIl.getDistanceSqToEntity(this.renderManager.renderViewEntity);
        if (lllllllllllIIIIllIlIllIIlllllIIl <= lllllllllllIIIIllIlIllIIlllllIlI * lllllllllllIIIIllIlIllIIlllllIlI) {
            final boolean lllllllllllIIIIllIlIllIIlllllIII = lllllllllllIIIIllIlIllIIllllIIIl.isSneaking();
            final float lllllllllllIIIIllIlIllIIllllIlll = RenderManager.playerViewY;
            final float lllllllllllIIIIllIlIllIIllllIllI = RenderManager.playerViewX;
            final boolean lllllllllllIIIIllIlIllIIllllIlIl = this.renderManager.options.thirdPersonView == 2;
            final float lllllllllllIIIIllIlIllIIllllIlII = lllllllllllIIIIllIlIllIIllllIIIl.height + 0.5f - (lllllllllllIIIIllIlIllIIlllllIII ? 0.25f : 0.0f);
            final int lllllllllllIIIIllIlIllIIllllIIll = "deadmau5".equals(lllllllllllIIIIllIlIllIIllllIIII) ? -10 : 0;
            EntityRenderer.drawNameplate(this.getFontRendererFromRenderManager(), lllllllllllIIIIllIlIllIIllllIIII, (float)lllllllllllIIIIllIlIllIIlllIllll, (float)lllllllllllIIIIllIlIllIIllllllII + lllllllllllIIIIllIlIllIIllllIlII, (float)lllllllllllIIIIllIlIllIIlllIllIl, lllllllllllIIIIllIlIllIIllllIIll, lllllllllllIIIIllIlIllIIllllIlll, lllllllllllIIIIllIlIllIIllllIllI, lllllllllllIIIIllIlIllIIllllIlIl, lllllllllllIIIIllIlIllIIlllllIII);
        }
    }
    
    public void renderMultipass(final T lllllllllllIIIIllIlIllIIllIlllll, final double lllllllllllIIIIllIlIllIIllIllllI, final double lllllllllllIIIIllIlIllIIllIlllIl, final double lllllllllllIIIIllIlIllIIllIlllII, final float lllllllllllIIIIllIlIllIIllIllIll, final float lllllllllllIIIIllIlIllIIllIllIlI) {
    }
}
