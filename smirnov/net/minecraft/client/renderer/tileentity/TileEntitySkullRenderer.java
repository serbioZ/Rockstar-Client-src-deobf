// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.tileentity.TileEntity;
import java.util.UUID;
import java.util.Map;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.renderer.GlStateManager;
import javax.annotation.Nullable;
import com.mojang.authlib.GameProfile;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.model.ModelHumanoidHead;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.model.ModelDragonHead;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntitySkull;

public class TileEntitySkullRenderer extends TileEntitySpecialRenderer<TileEntitySkull>
{
    public static /* synthetic */ TileEntitySkullRenderer instance;
    private static final /* synthetic */ ResourceLocation SKELETON_TEXTURES;
    private final /* synthetic */ ModelDragonHead dragonHead;
    private static final /* synthetic */ ResourceLocation DRAGON_TEXTURES;
    private final /* synthetic */ ModelSkeletonHead humanoidHead;
    private final /* synthetic */ ModelSkeletonHead skeletonHead;
    private static final /* synthetic */ ResourceLocation CREEPER_TEXTURES;
    private static final /* synthetic */ ResourceLocation WITHER_SKELETON_TEXTURES;
    private static final /* synthetic */ ResourceLocation ZOMBIE_TEXTURES;
    
    public TileEntitySkullRenderer() {
        this.dragonHead = new ModelDragonHead(0.0f);
        this.skeletonHead = new ModelSkeletonHead(0, 0, 64, 32);
        this.humanoidHead = new ModelHumanoidHead();
    }
    
    @Override
    public void setRendererDispatcher(final TileEntityRendererDispatcher lllllllllllIlllIlIIllIIlIlIIlIIl) {
        super.setRendererDispatcher(lllllllllllIlllIlIIllIIlIlIIlIIl);
        TileEntitySkullRenderer.instance = this;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = TileEntitySkullRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final Exception lllllllllllIlllIlIIllIIlIIIIIlll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlllIlIIllIIlIIIIIlll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlllIlIIllIIlIIIIIlll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlllIlIIllIIlIIIIIlll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlllIlIIllIIlIIIIIlll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlllIlIIllIIlIIIIIlll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlllIlIIllIIlIIIIIlll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return TileEntitySkullRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlllIlIIllIIlIIIIIlll;
    }
    
    @Override
    public void func_192841_a(final TileEntitySkull lllllllllllIlllIlIIllIIlIlIllllI, final double lllllllllllIlllIlIIllIIlIlIlllIl, final double lllllllllllIlllIlIIllIIlIlIlIIlI, final double lllllllllllIlllIlIIllIIlIlIlIIIl, final float lllllllllllIlllIlIIllIIlIlIlIIII, final int lllllllllllIlllIlIIllIIlIlIllIIl, final float lllllllllllIlllIlIIllIIlIlIllIII) {
        final EnumFacing lllllllllllIlllIlIIllIIlIlIlIlll = EnumFacing.getFront(lllllllllllIlllIlIIllIIlIlIllllI.getBlockMetadata() & 0x7);
        final float lllllllllllIlllIlIIllIIlIlIlIllI = lllllllllllIlllIlIIllIIlIlIllllI.getAnimationProgress(lllllllllllIlllIlIIllIIlIlIlIIII);
        this.renderSkull((float)lllllllllllIlllIlIIllIIlIlIlllIl, (float)lllllllllllIlllIlIIllIIlIlIlIIlI, (float)lllllllllllIlllIlIIllIIlIlIlIIIl, lllllllllllIlllIlIIllIIlIlIlIlll, lllllllllllIlllIlIIllIIlIlIllllI.getSkullRotation() * 360 / 16.0f, lllllllllllIlllIlIIllIIlIlIllllI.getSkullType(), lllllllllllIlllIlIIllIIlIlIllllI.getPlayerProfile(), lllllllllllIlllIlIIllIIlIlIllIIl, lllllllllllIlllIlIIllIIlIlIlIllI);
    }
    
    public void renderSkull(final float lllllllllllIlllIlIIllIIlIIllIllI, final float lllllllllllIlllIlIIllIIlIIllIlIl, final float lllllllllllIlllIlIIllIIlIIllIlII, final EnumFacing lllllllllllIlllIlIIllIIlIIlIIIll, float lllllllllllIlllIlIIllIIlIIlIIIlI, final int lllllllllllIlllIlIIllIIlIIlIIIIl, @Nullable final GameProfile lllllllllllIlllIlIIllIIlIIlIIIII, final int lllllllllllIlllIlIIllIIlIIIlllll, final float lllllllllllIlllIlIIllIIlIIIllllI) {
        ModelBase lllllllllllIlllIlIIllIIlIIlIllIl = this.skeletonHead;
        if (lllllllllllIlllIlIIllIIlIIIlllll >= 0) {
            this.bindTexture(TileEntitySkullRenderer.DESTROY_STAGES[lllllllllllIlllIlIIllIIlIIIlllll]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 2.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            switch (lllllllllllIlllIlIIllIIlIIlIIIIl) {
                default: {
                    this.bindTexture(TileEntitySkullRenderer.SKELETON_TEXTURES);
                    break;
                }
                case 1: {
                    this.bindTexture(TileEntitySkullRenderer.WITHER_SKELETON_TEXTURES);
                    break;
                }
                case 2: {
                    this.bindTexture(TileEntitySkullRenderer.ZOMBIE_TEXTURES);
                    lllllllllllIlllIlIIllIIlIIlIllIl = this.humanoidHead;
                    break;
                }
                case 3: {
                    lllllllllllIlllIlIIllIIlIIlIllIl = this.humanoidHead;
                    ResourceLocation lllllllllllIlllIlIIllIIlIIlIllII = DefaultPlayerSkin.getDefaultSkinLegacy();
                    if (lllllllllllIlllIlIIllIIlIIlIIIII != null) {
                        final Minecraft lllllllllllIlllIlIIllIIlIIlIlIll = Minecraft.getMinecraft();
                        final Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> lllllllllllIlllIlIIllIIlIIlIlIlI = lllllllllllIlllIlIIllIIlIIlIlIll.getSkinManager().loadSkinFromCache(lllllllllllIlllIlIIllIIlIIlIIIII);
                        if (lllllllllllIlllIlIIllIIlIIlIlIlI.containsKey(MinecraftProfileTexture.Type.SKIN)) {
                            lllllllllllIlllIlIIllIIlIIlIllII = lllllllllllIlllIlIIllIIlIIlIlIll.getSkinManager().loadSkin(lllllllllllIlllIlIIllIIlIIlIlIlI.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN);
                        }
                        else {
                            final UUID lllllllllllIlllIlIIllIIlIIlIlIIl = EntityPlayer.getUUID(lllllllllllIlllIlIIllIIlIIlIIIII);
                            lllllllllllIlllIlIIllIIlIIlIllII = DefaultPlayerSkin.getDefaultSkin(lllllllllllIlllIlIIllIIlIIlIlIIl);
                        }
                    }
                    this.bindTexture(lllllllllllIlllIlIIllIIlIIlIllII);
                    break;
                }
                case 4: {
                    this.bindTexture(TileEntitySkullRenderer.CREEPER_TEXTURES);
                    break;
                }
                case 5: {
                    this.bindTexture(TileEntitySkullRenderer.DRAGON_TEXTURES);
                    lllllllllllIlllIlIIllIIlIIlIllIl = this.dragonHead;
                    break;
                }
            }
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        if (lllllllllllIlllIlIIllIIlIIlIIIll == EnumFacing.UP) {
            GlStateManager.translate(lllllllllllIlllIlIIllIIlIIllIllI + 0.5f, lllllllllllIlllIlIIllIIlIIllIlIl, lllllllllllIlllIlIIllIIlIIllIlII + 0.5f);
        }
        else {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlllIlIIllIIlIIlIIIll.ordinal()]) {
                case 3: {
                    GlStateManager.translate(lllllllllllIlllIlIIllIIlIIllIllI + 0.5f, lllllllllllIlllIlIIllIIlIIllIlIl + 0.25f, lllllllllllIlllIlIIllIIlIIllIlII + 0.74f);
                    break;
                }
                case 4: {
                    GlStateManager.translate(lllllllllllIlllIlIIllIIlIIllIllI + 0.5f, lllllllllllIlllIlIIllIIlIIllIlIl + 0.25f, lllllllllllIlllIlIIllIIlIIllIlII + 0.26f);
                    lllllllllllIlllIlIIllIIlIIlIIIlI = 180.0f;
                    break;
                }
                case 5: {
                    GlStateManager.translate(lllllllllllIlllIlIIllIIlIIllIllI + 0.74f, lllllllllllIlllIlIIllIIlIIllIlIl + 0.25f, lllllllllllIlllIlIIllIIlIIllIlII + 0.5f);
                    lllllllllllIlllIlIIllIIlIIlIIIlI = 270.0f;
                    break;
                }
                default: {
                    GlStateManager.translate(lllllllllllIlllIlIIllIIlIIllIllI + 0.26f, lllllllllllIlllIlIIllIIlIIllIlIl + 0.25f, lllllllllllIlllIlIIllIIlIIllIlII + 0.5f);
                    lllllllllllIlllIlIIllIIlIIlIIIlI = 90.0f;
                    break;
                }
            }
        }
        final float lllllllllllIlllIlIIllIIlIIlIlIII = 0.0625f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        GlStateManager.enableAlpha();
        if (lllllllllllIlllIlIIllIIlIIlIIIIl == 3) {
            GlStateManager.enableBlendProfile(GlStateManager.Profile.PLAYER_SKIN);
        }
        lllllllllllIlllIlIIllIIlIIlIllIl.render(null, lllllllllllIlllIlIIllIIlIIIllllI, 0.0f, 0.0f, lllllllllllIlllIlIIllIIlIIlIIIlI, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
        if (lllllllllllIlllIlIIllIIlIIIlllll >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    static {
        SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/skeleton.png");
        WITHER_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
        ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/zombie.png");
        CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");
        DRAGON_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    }
}
