// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.block.properties.IProperty;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.WorldType;
import java.util.Collection;
import optifine.Reflector;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.Display;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.Entity;
import net.minecraft.world.EnumSkyBlock;
import com.google.common.collect.Lists;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import java.util.List;
import com.google.common.base.Strings;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;

public class GuiOverlayDebug extends Gui
{
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ FontRenderer fontRenderer;
    
    private int getFrameColor(final int lllllllllllIlllIIIIlIIlIIIllIIIl, final int lllllllllllIlllIIIIlIIlIIIllIIII, final int lllllllllllIlllIIIIlIIlIIIlIlIll, final int lllllllllllIlllIIIIlIIlIIIlIlIlI) {
        return (lllllllllllIlllIIIIlIIlIIIllIIIl < lllllllllllIlllIIIIlIIlIIIlIlIll) ? this.blendColors(-16711936, -256, lllllllllllIlllIIIIlIIlIIIllIIIl / (float)lllllllllllIlllIIIIlIIlIIIlIlIll) : this.blendColors(-256, -65536, (lllllllllllIlllIIIIlIIlIIIllIIIl - lllllllllllIlllIIIIlIIlIIIlIlIll) / (float)(lllllllllllIlllIIIIlIIlIIIlIlIlI - lllllllllllIlllIIIIlIIlIIIlIlIll));
    }
    
    private static long bytesToMb(final long lllllllllllIlllIIIIlIIIllllllIIl) {
        return lllllllllllIlllIIIIlIIIllllllIIl / 1024L / 1024L;
    }
    
    private int blendColors(final int lllllllllllIlllIIIIlIIlIIIIllIIl, final int lllllllllllIlllIIIIlIIlIIIIllIII, final float lllllllllllIlllIIIIlIIlIIIIIlIII) {
        final int lllllllllllIlllIIIIlIIlIIIIlIllI = lllllllllllIlllIIIIlIIlIIIIllIIl >> 24 & 0xFF;
        final int lllllllllllIlllIIIIlIIlIIIIlIlIl = lllllllllllIlllIIIIlIIlIIIIllIIl >> 16 & 0xFF;
        final int lllllllllllIlllIIIIlIIlIIIIlIlII = lllllllllllIlllIIIIlIIlIIIIllIIl >> 8 & 0xFF;
        final int lllllllllllIlllIIIIlIIlIIIIlIIll = lllllllllllIlllIIIIlIIlIIIIllIIl & 0xFF;
        final int lllllllllllIlllIIIIlIIlIIIIlIIlI = lllllllllllIlllIIIIlIIlIIIIllIII >> 24 & 0xFF;
        final int lllllllllllIlllIIIIlIIlIIIIlIIIl = lllllllllllIlllIIIIlIIlIIIIllIII >> 16 & 0xFF;
        final int lllllllllllIlllIIIIlIIlIIIIlIIII = lllllllllllIlllIIIIlIIlIIIIllIII >> 8 & 0xFF;
        final int lllllllllllIlllIIIIlIIlIIIIIllll = lllllllllllIlllIIIIlIIlIIIIllIII & 0xFF;
        final int lllllllllllIlllIIIIlIIlIIIIIlllI = MathHelper.clamp((int)(lllllllllllIlllIIIIlIIlIIIIlIllI + (lllllllllllIlllIIIIlIIlIIIIlIIlI - lllllllllllIlllIIIIlIIlIIIIlIllI) * lllllllllllIlllIIIIlIIlIIIIIlIII), 0, 255);
        final int lllllllllllIlllIIIIlIIlIIIIIllIl = MathHelper.clamp((int)(lllllllllllIlllIIIIlIIlIIIIlIlIl + (lllllllllllIlllIIIIlIIlIIIIlIIIl - lllllllllllIlllIIIIlIIlIIIIlIlIl) * lllllllllllIlllIIIIlIIlIIIIIlIII), 0, 255);
        final int lllllllllllIlllIIIIlIIlIIIIIllII = MathHelper.clamp((int)(lllllllllllIlllIIIIlIIlIIIIlIlII + (lllllllllllIlllIIIIlIIlIIIIlIIII - lllllllllllIlllIIIIlIIlIIIIlIlII) * lllllllllllIlllIIIIlIIlIIIIIlIII), 0, 255);
        final int lllllllllllIlllIIIIlIIlIIIIIlIll = MathHelper.clamp((int)(lllllllllllIlllIIIIlIIlIIIIlIIll + (lllllllllllIlllIIIIlIIlIIIIIllll - lllllllllllIlllIIIIlIIlIIIIlIIll) * lllllllllllIlllIIIIlIIlIIIIIlIII), 0, 255);
        return lllllllllllIlllIIIIlIIlIIIIIlllI << 24 | lllllllllllIlllIIIIlIIlIIIIIllIl << 16 | lllllllllllIlllIIIIlIIlIIIIIllII << 8 | lllllllllllIlllIIIIlIIlIIIIIlIll;
    }
    
    protected void renderDebugInfoRight(final ScaledResolution lllllllllllIlllIIIIlIIlIlIIIllII) {
        final List<String> lllllllllllIlllIIIIlIIlIlIIIlIll = this.getDebugInfoRight();
        for (int lllllllllllIlllIIIIlIIlIlIIIlIlI = 0; lllllllllllIlllIIIIlIIlIlIIIlIlI < lllllllllllIlllIIIIlIIlIlIIIlIll.size(); ++lllllllllllIlllIIIIlIIlIlIIIlIlI) {
            final String lllllllllllIlllIIIIlIIlIlIIIlIIl = lllllllllllIlllIIIIlIIlIlIIIlIll.get(lllllllllllIlllIIIIlIIlIlIIIlIlI);
            if (!Strings.isNullOrEmpty(lllllllllllIlllIIIIlIIlIlIIIlIIl)) {
                final int lllllllllllIlllIIIIlIIlIlIIIlIII = this.fontRenderer.FONT_HEIGHT;
                final int lllllllllllIlllIIIIlIIlIlIIIIlll = this.fontRenderer.getStringWidth(lllllllllllIlllIIIIlIIlIlIIIlIIl);
                final int lllllllllllIlllIIIIlIIlIlIIIIllI = lllllllllllIlllIIIIlIIlIlIIIllII.getScaledWidth() - 2 - lllllllllllIlllIIIIlIIlIlIIIIlll;
                final int lllllllllllIlllIIIIlIIlIlIIIIlIl = 2 + lllllllllllIlllIIIIlIIlIlIIIlIII * lllllllllllIlllIIIIlIIlIlIIIlIlI;
                Gui.drawRect(lllllllllllIlllIIIIlIIlIlIIIIllI - 1, lllllllllllIlllIIIIlIIlIlIIIIlIl - 1, lllllllllllIlllIIIIlIIlIlIIIIllI + lllllllllllIlllIIIIlIIlIlIIIIlll + 1, lllllllllllIlllIIIIlIIlIlIIIIlIl + lllllllllllIlllIIIIlIIlIlIIIlIII - 1, -1873784752);
                this.fontRenderer.drawString(lllllllllllIlllIIIIlIIlIlIIIlIIl, (float)lllllllllllIlllIIIIlIIlIlIIIIllI, (float)lllllllllllIlllIIIIlIIlIlIIIIlIl, 14737632);
            }
        }
    }
    
    public GuiOverlayDebug(final Minecraft lllllllllllIlllIIIIlIIlIlIllIlIl) {
        this.mc = lllllllllllIlllIIIIlIIlIlIllIlIl;
        this.fontRenderer = Minecraft.fontRendererObj;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = GuiOverlayDebug.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final char lllllllllllIlllIIIIlIIIlllllIlll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlllIIIIlIIIlllllIlll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlllIIIIlIIIlllllIlll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlllIIIIlIIIlllllIlll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlllIIIIlIIIlllllIlll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlllIIIIlIIIlllllIlll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlllIIIIlIIIlllllIlll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return GuiOverlayDebug.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlllIIIIlIIIlllllIlll;
    }
    
    private void renderLagometer() {
    }
    
    protected List<String> call() {
        final BlockPos lllllllllllIlllIIIIlIIlIIlllIIIl = new BlockPos(this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ);
        if (this.mc.isReducedDebug()) {
            return (List<String>)Lists.newArrayList((Object[])new String[] { "Minecraft 1.12.2 (" + this.mc.getVersion() + "/" + ClientBrandRetriever.getClientModName() + ")", this.mc.debug, this.mc.renderGlobal.getDebugInfoRenders(), this.mc.renderGlobal.getDebugInfoEntities(), "P: " + this.mc.effectRenderer.getStatistics() + ". T: " + this.mc.world.getDebugLoadedEntities(), this.mc.world.getProviderName(), "", String.format("Chunk-relative: %d %d %d", lllllllllllIlllIIIIlIIlIIlllIIIl.getX() & 0xF, lllllllllllIlllIIIIlIIlIIlllIIIl.getY() & 0xF, lllllllllllIlllIIIIlIIlIIlllIIIl.getZ() & 0xF) });
        }
        final Entity lllllllllllIlllIIIIlIIlIIlllIIII = this.mc.getRenderViewEntity();
        final EnumFacing lllllllllllIlllIIIIlIIlIIllIllll = lllllllllllIlllIIIIlIIlIIlllIIII.getHorizontalFacing();
        String lllllllllllIlllIIIIlIIlIIllIlllI = "Invalid";
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlllIIIIlIIlIIllIllll.ordinal()]) {
            case 3: {
                lllllllllllIlllIIIIlIIlIIllIlllI = "Towards negative Z";
                break;
            }
            case 4: {
                lllllllllllIlllIIIIlIIlIIllIlllI = "Towards positive Z";
                break;
            }
            case 5: {
                lllllllllllIlllIIIIlIIlIIllIlllI = "Towards negative X";
                break;
            }
            case 6: {
                lllllllllllIlllIIIIlIIlIIllIlllI = "Towards positive X";
                break;
            }
        }
        final List<String> lllllllllllIlllIIIIlIIlIIllIllIl = (List<String>)Lists.newArrayList((Object[])new String[] { "Minecraft 1.12.2 (" + this.mc.getVersion() + "/" + ClientBrandRetriever.getClientModName() + ("release".equalsIgnoreCase(this.mc.getVersionType()) ? "" : ("/" + this.mc.getVersionType())) + ")", this.mc.debug, this.mc.renderGlobal.getDebugInfoRenders(), this.mc.renderGlobal.getDebugInfoEntities(), "P: " + this.mc.effectRenderer.getStatistics() + ". T: " + this.mc.world.getDebugLoadedEntities(), this.mc.world.getProviderName(), "", String.format("XYZ: %.3f / %.5f / %.3f", this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ), String.format("Block: %d %d %d", lllllllllllIlllIIIIlIIlIIlllIIIl.getX(), lllllllllllIlllIIIIlIIlIIlllIIIl.getY(), lllllllllllIlllIIIIlIIlIIlllIIIl.getZ()), String.format("Chunk: %d %d %d in %d %d %d", lllllllllllIlllIIIIlIIlIIlllIIIl.getX() & 0xF, lllllllllllIlllIIIIlIIlIIlllIIIl.getY() & 0xF, lllllllllllIlllIIIIlIIlIIlllIIIl.getZ() & 0xF, lllllllllllIlllIIIIlIIlIIlllIIIl.getX() >> 4, lllllllllllIlllIIIIlIIlIIlllIIIl.getY() >> 4, lllllllllllIlllIIIIlIIlIIlllIIIl.getZ() >> 4), String.format("Facing: %s (%s) (%.1f / %.1f)", lllllllllllIlllIIIIlIIlIIllIllll, lllllllllllIlllIIIIlIIlIIllIlllI, MathHelper.wrapDegrees(lllllllllllIlllIIIIlIIlIIlllIIII.rotationYaw), MathHelper.wrapDegrees(lllllllllllIlllIIIIlIIlIIlllIIII.rotationPitch)) });
        if (this.mc.world != null) {
            final Chunk lllllllllllIlllIIIIlIIlIIllIllII = this.mc.world.getChunkFromBlockCoords(lllllllllllIlllIIIIlIIlIIlllIIIl);
            if (this.mc.world.isBlockLoaded(lllllllllllIlllIIIIlIIlIIlllIIIl) && lllllllllllIlllIIIIlIIlIIlllIIIl.getY() >= 0 && lllllllllllIlllIIIIlIIlIIlllIIIl.getY() < 256) {
                if (!lllllllllllIlllIIIIlIIlIIllIllII.isEmpty()) {
                    lllllllllllIlllIIIIlIIlIIllIllIl.add("Biome: " + lllllllllllIlllIIIIlIIlIIllIllII.getBiome(lllllllllllIlllIIIIlIIlIIlllIIIl, this.mc.world.getBiomeProvider()).getBiomeName());
                    lllllllllllIlllIIIIlIIlIIllIllIl.add("Light: " + lllllllllllIlllIIIIlIIlIIllIllII.getLightSubtracted(lllllllllllIlllIIIIlIIlIIlllIIIl, 0) + " (" + lllllllllllIlllIIIIlIIlIIllIllII.getLightFor(EnumSkyBlock.SKY, lllllllllllIlllIIIIlIIlIIlllIIIl) + " sky, " + lllllllllllIlllIIIIlIIlIIllIllII.getLightFor(EnumSkyBlock.BLOCK, lllllllllllIlllIIIIlIIlIIlllIIIl) + " block)");
                    DifficultyInstance lllllllllllIlllIIIIlIIlIIllIlIll = this.mc.world.getDifficultyForLocation(lllllllllllIlllIIIIlIIlIIlllIIIl);
                    if (this.mc.isIntegratedServerRunning() && this.mc.getIntegratedServer() != null) {
                        final EntityPlayerMP lllllllllllIlllIIIIlIIlIIllIlIlI = this.mc.getIntegratedServer().getPlayerList().getPlayerByUUID(this.mc.player.getUniqueID());
                        if (lllllllllllIlllIIIIlIIlIIllIlIlI != null) {
                            lllllllllllIlllIIIIlIIlIIllIlIll = lllllllllllIlllIIIIlIIlIIllIlIlI.world.getDifficultyForLocation(new BlockPos(lllllllllllIlllIIIIlIIlIIllIlIlI));
                        }
                    }
                    lllllllllllIlllIIIIlIIlIIllIllIl.add(String.format("Local Difficulty: %.2f // %.2f (Day %d)", lllllllllllIlllIIIIlIIlIIllIlIll.getAdditionalDifficulty(), lllllllllllIlllIIIIlIIlIIllIlIll.getClampedAdditionalDifficulty(), this.mc.world.getWorldTime() / 24000L));
                }
                else {
                    lllllllllllIlllIIIIlIIlIIllIllIl.add("Waiting for chunk...");
                }
            }
            else {
                lllllllllllIlllIIIIlIIlIIllIllIl.add("Outside of world...");
            }
        }
        if (this.mc.entityRenderer != null && this.mc.entityRenderer.isShaderActive()) {
            lllllllllllIlllIIIIlIIlIIllIllIl.add("Shader: " + this.mc.entityRenderer.getShaderGroup().getShaderGroupName());
        }
        if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK && this.mc.objectMouseOver.getBlockPos() != null) {
            final BlockPos lllllllllllIlllIIIIlIIlIIllIlIIl = this.mc.objectMouseOver.getBlockPos();
            lllllllllllIlllIIIIlIIlIIllIllIl.add(String.format("Looking at: %d %d %d", lllllllllllIlllIIIIlIIlIIllIlIIl.getX(), lllllllllllIlllIIIIlIIlIIllIlIIl.getY(), lllllllllllIlllIIIIlIIlIIllIlIIl.getZ()));
        }
        return lllllllllllIlllIIIIlIIlIIllIllIl;
    }
    
    protected void renderDebugInfoLeft() {
        final List<String> lllllllllllIlllIIIIlIIlIlIlIIlIl = this.call();
        lllllllllllIlllIIIIlIIlIlIlIIlIl.add("");
        lllllllllllIlllIIIIlIIlIlIlIIlIl.add("Debug: Pie [shift]: " + (this.mc.gameSettings.showDebugProfilerChart ? "visible" : "hidden") + " FPS [alt]: " + (this.mc.gameSettings.showLagometer ? "visible" : "hidden"));
        lllllllllllIlllIIIIlIIlIlIlIIlIl.add("For help: press F3 + Q");
        for (int lllllllllllIlllIIIIlIIlIlIlIIlII = 0; lllllllllllIlllIIIIlIIlIlIlIIlII < lllllllllllIlllIIIIlIIlIlIlIIlIl.size(); ++lllllllllllIlllIIIIlIIlIlIlIIlII) {
            final String lllllllllllIlllIIIIlIIlIlIlIIIll = lllllllllllIlllIIIIlIIlIlIlIIlIl.get(lllllllllllIlllIIIIlIIlIlIlIIlII);
            if (!Strings.isNullOrEmpty(lllllllllllIlllIIIIlIIlIlIlIIIll)) {
                final int lllllllllllIlllIIIIlIIlIlIlIIIlI = this.fontRenderer.FONT_HEIGHT;
                final int lllllllllllIlllIIIIlIIlIlIlIIIIl = this.fontRenderer.getStringWidth(lllllllllllIlllIIIIlIIlIlIlIIIll);
                final int lllllllllllIlllIIIIlIIlIlIlIIIII = 2;
                final int lllllllllllIlllIIIIlIIlIlIIlllll = 2 + lllllllllllIlllIIIIlIIlIlIlIIIlI * lllllllllllIlllIIIIlIIlIlIlIIlII;
                Gui.drawRect(1.0, lllllllllllIlllIIIIlIIlIlIIlllll - 1, 2 + lllllllllllIlllIIIIlIIlIlIlIIIIl + 1, lllllllllllIlllIIIIlIIlIlIIlllll + lllllllllllIlllIIIIlIIlIlIlIIIlI - 1, -1873784752);
                this.fontRenderer.drawString(lllllllllllIlllIIIIlIIlIlIlIIIll, 2.0f, (float)lllllllllllIlllIIIIlIIlIlIIlllll, 14737632);
            }
        }
    }
    
    protected <T extends Comparable<T>> List<String> getDebugInfoRight() {
        final long lllllllllllIlllIIIIlIIlIIlIlIIIl = Runtime.getRuntime().maxMemory();
        final long lllllllllllIlllIIIIlIIlIIlIlIIII = Runtime.getRuntime().totalMemory();
        final long lllllllllllIlllIIIIlIIlIIlIIllll = Runtime.getRuntime().freeMemory();
        final long lllllllllllIlllIIIIlIIlIIlIIlllI = lllllllllllIlllIIIIlIIlIIlIlIIII - lllllllllllIlllIIIIlIIlIIlIIllll;
        final List<String> lllllllllllIlllIIIIlIIlIIlIIllIl = (List<String>)Lists.newArrayList((Object[])new String[] { String.format("Java: %s %dbit", System.getProperty("java.version"), this.mc.isJava64bit() ? 64 : 32), String.format("Mem: % 2d%% %03d/%03dMB", lllllllllllIlllIIIIlIIlIIlIIlllI * 100L / lllllllllllIlllIIIIlIIlIIlIlIIIl, bytesToMb(lllllllllllIlllIIIIlIIlIIlIIlllI), bytesToMb(lllllllllllIlllIIIIlIIlIIlIlIIIl)), String.format("Allocated: % 2d%% %03dMB", lllllllllllIlllIIIIlIIlIIlIlIIII * 100L / lllllllllllIlllIIIIlIIlIIlIlIIIl, bytesToMb(lllllllllllIlllIIIIlIIlIIlIlIIII)), "", String.format("CPU: %s", OpenGlHelper.getCpu()), "", String.format("Display: %dx%d (%s)", Display.getWidth(), Display.getHeight(), GlStateManager.glGetString(7936)), GlStateManager.glGetString(7937), GlStateManager.glGetString(7938) });
        if (Reflector.FMLCommonHandler_getBrandings.exists()) {
            final Object lllllllllllIlllIIIIlIIlIIlIIllII = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            lllllllllllIlllIIIIlIIlIIlIIllIl.add("");
            lllllllllllIlllIIIIlIIlIIlIIllIl.addAll((Collection<? extends String>)Reflector.call(lllllllllllIlllIIIIlIIlIIlIIllII, Reflector.FMLCommonHandler_getBrandings, new Object[] { false }));
        }
        if (this.mc.isReducedDebug()) {
            return lllllllllllIlllIIIIlIIlIIlIIllIl;
        }
        if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK && this.mc.objectMouseOver.getBlockPos() != null) {
            final BlockPos lllllllllllIlllIIIIlIIlIIlIIlIll = this.mc.objectMouseOver.getBlockPos();
            IBlockState lllllllllllIlllIIIIlIIlIIlIIlIlI = this.mc.world.getBlockState(lllllllllllIlllIIIIlIIlIIlIIlIll);
            if (this.mc.world.getWorldType() != WorldType.DEBUG_WORLD) {
                lllllllllllIlllIIIIlIIlIIlIIlIlI = lllllllllllIlllIIIIlIIlIIlIIlIlI.getActualState(this.mc.world, lllllllllllIlllIIIIlIIlIIlIIlIll);
            }
            lllllllllllIlllIIIIlIIlIIlIIllIl.add("");
            lllllllllllIlllIIIIlIIlIIlIIllIl.add(String.valueOf(Block.REGISTRY.getNameForObject(lllllllllllIlllIIIIlIIlIIlIIlIlI.getBlock())));
            for (final Map.Entry<IProperty<?>, Comparable<?>> lllllllllllIlllIIIIlIIlIIlIIIllI : lllllllllllIlllIIIIlIIlIIlIIlIlI.getProperties().entrySet()) {
                final IProperty<T> lllllllllllIlllIIIIlIIlIIlIIlIIl = (IProperty<T>)lllllllllllIlllIIIIlIIlIIlIIIllI.getKey();
                final T lllllllllllIlllIIIIlIIlIIlIIIlIl = (T)lllllllllllIlllIIIIlIIlIIlIIIllI.getValue();
                String lllllllllllIlllIIIIlIIlIIlIIlIII = lllllllllllIlllIIIIlIIlIIlIIlIIl.getName(lllllllllllIlllIIIIlIIlIIlIIIlIl);
                if (Boolean.TRUE.equals(lllllllllllIlllIIIIlIIlIIlIIIlIl)) {
                    lllllllllllIlllIIIIlIIlIIlIIlIII = TextFormatting.GREEN + lllllllllllIlllIIIIlIIlIIlIIlIII;
                }
                else if (Boolean.FALSE.equals(lllllllllllIlllIIIIlIIlIIlIIIlIl)) {
                    lllllllllllIlllIIIIlIIlIIlIIlIII = TextFormatting.RED + lllllllllllIlllIIIIlIIlIIlIIlIII;
                }
                lllllllllllIlllIIIIlIIlIIlIIllIl.add(String.valueOf(lllllllllllIlllIIIIlIIlIIlIIlIIl.getName()) + ": " + lllllllllllIlllIIIIlIIlIIlIIlIII);
            }
        }
        return lllllllllllIlllIIIIlIIlIIlIIllIl;
    }
    
    public void renderDebugInfo(final ScaledResolution lllllllllllIlllIIIIlIIlIlIlIllll) {
        this.mc.mcProfiler.startSection("debug");
        GlStateManager.pushMatrix();
        this.renderDebugInfoLeft();
        this.renderDebugInfoRight(lllllllllllIlllIIIIlIIlIlIlIllll);
        GlStateManager.popMatrix();
        if (this.mc.gameSettings.showLagometer) {
            this.renderLagometer();
        }
        this.mc.mcProfiler.endSection();
    }
}
