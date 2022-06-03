// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.block.Block;
import optifine.RenderEnv;
import net.minecraft.block.BlockSlab;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.EnumFacing;
import optifine.CustomColors;
import shadersmod.client.SVertexBuilder;
import optifine.Config;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class BlockFluidRenderer
{
    private final /* synthetic */ TextureAtlasSprite[] atlasSpritesLava;
    private /* synthetic */ TextureAtlasSprite atlasSpriteWaterOverlay;
    private final /* synthetic */ BlockColors blockColors;
    private final /* synthetic */ TextureAtlasSprite[] atlasSpritesWater;
    
    public BlockFluidRenderer(final BlockColors llllllllllllIlIIIllllIIIlllllIll) {
        this.atlasSpritesLava = new TextureAtlasSprite[2];
        this.atlasSpritesWater = new TextureAtlasSprite[2];
        this.blockColors = llllllllllllIlIIIllllIIIlllllIll;
        this.initAtlasSprites();
    }
    
    private float getFluidHeight(final IBlockAccess llllllllllllIlIIIlllIllllllllIII, final BlockPos llllllllllllIlIIIlllIllllllIllIl, final Material llllllllllllIlIIIlllIllllllIllII) {
        int llllllllllllIlIIIlllIlllllllIlIl = 0;
        float llllllllllllIlIIIlllIlllllllIlII = 0.0f;
        for (int llllllllllllIlIIIlllIlllllllIIll = 0; llllllllllllIlIIIlllIlllllllIIll < 4; ++llllllllllllIlIIIlllIlllllllIIll) {
            final BlockPos llllllllllllIlIIIlllIlllllllIIlI = llllllllllllIlIIIlllIllllllIllIl.add(-(llllllllllllIlIIIlllIlllllllIIll & 0x1), 0, -(llllllllllllIlIIIlllIlllllllIIll >> 1 & 0x1));
            if (llllllllllllIlIIIlllIllllllllIII.getBlockState(llllllllllllIlIIIlllIlllllllIIlI.up()).getMaterial() == llllllllllllIlIIIlllIllllllIllII) {
                return 1.0f;
            }
            final IBlockState llllllllllllIlIIIlllIlllllllIIIl = llllllllllllIlIIIlllIllllllllIII.getBlockState(llllllllllllIlIIIlllIlllllllIIlI);
            final Material llllllllllllIlIIIlllIlllllllIIII = llllllllllllIlIIIlllIlllllllIIIl.getMaterial();
            if (llllllllllllIlIIIlllIlllllllIIII != llllllllllllIlIIIlllIllllllIllII) {
                if (!llllllllllllIlIIIlllIlllllllIIII.isSolid()) {
                    ++llllllllllllIlIIIlllIlllllllIlII;
                    ++llllllllllllIlIIIlllIlllllllIlIl;
                }
            }
            else {
                final int llllllllllllIlIIIlllIllllllIllll = llllllllllllIlIIIlllIlllllllIIIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
                if (llllllllllllIlIIIlllIllllllIllll >= 8 || llllllllllllIlIIIlllIllllllIllll == 0) {
                    llllllllllllIlIIIlllIlllllllIlII += BlockLiquid.getLiquidHeightPercent(llllllllllllIlIIIlllIllllllIllll) * 10.0f;
                    llllllllllllIlIIIlllIlllllllIlIl += 10;
                }
                llllllllllllIlIIIlllIlllllllIlII += BlockLiquid.getLiquidHeightPercent(llllllllllllIlIIIlllIllllllIllll);
                ++llllllllllllIlIIIlllIlllllllIlIl;
            }
        }
        return 1.0f - llllllllllllIlIIIlllIlllllllIlII / llllllllllllIlIIIlllIlllllllIlIl;
    }
    
    protected void initAtlasSprites() {
        final TextureMap llllllllllllIlIIIllllIIIllllIlIl = Minecraft.getMinecraft().getTextureMapBlocks();
        this.atlasSpritesLava[0] = llllllllllllIlIIIllllIIIllllIlIl.getAtlasSprite("minecraft:blocks/lava_still");
        this.atlasSpritesLava[1] = llllllllllllIlIIIllllIIIllllIlIl.getAtlasSprite("minecraft:blocks/lava_flow");
        this.atlasSpritesWater[0] = llllllllllllIlIIIllllIIIllllIlIl.getAtlasSprite("minecraft:blocks/water_still");
        this.atlasSpritesWater[1] = llllllllllllIlIIIllllIIIllllIlIl.getAtlasSprite("minecraft:blocks/water_flow");
        this.atlasSpriteWaterOverlay = llllllllllllIlIIIllllIIIllllIlIl.getAtlasSprite("minecraft:blocks/water_overlay");
    }
    
    public boolean renderFluid(final IBlockAccess llllllllllllIlIIIllllIIIlIllIIll, final IBlockState llllllllllllIlIIIllllIIIIIllllll, final BlockPos llllllllllllIlIIIllllIIIlIllIIIl, final BufferBuilder llllllllllllIlIIIllllIIIlIllIIII) {
        try {
            if (Config.isShaders()) {
                SVertexBuilder.pushEntity(llllllllllllIlIIIllllIIIIIllllll, llllllllllllIlIIIllllIIIlIllIIIl, llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIII);
            }
            final BlockLiquid llllllllllllIlIIIllllIIIlIlIllII = (BlockLiquid)llllllllllllIlIIIllllIIIIIllllll.getBlock();
            final boolean llllllllllllIlIIIllllIIIlIlIlIll = llllllllllllIlIIIllllIIIIIllllll.getMaterial() == Material.LAVA;
            final TextureAtlasSprite[] llllllllllllIlIIIllllIIIlIlIlIlI = llllllllllllIlIIIllllIIIlIlIlIll ? this.atlasSpritesLava : this.atlasSpritesWater;
            final RenderEnv llllllllllllIlIIIllllIIIlIlIlIIl = llllllllllllIlIIIllllIIIlIllIIII.getRenderEnv(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIIIllllll, llllllllllllIlIIIllllIIIlIllIIIl);
            final int llllllllllllIlIIIllllIIIlIlIlIII = CustomColors.getFluidColor(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIIIllllll, llllllllllllIlIIIllllIIIlIllIIIl, llllllllllllIlIIIllllIIIlIlIlIIl);
            final float llllllllllllIlIIIllllIIIlIlIIlll = (llllllllllllIlIIIllllIIIlIlIlIII >> 16 & 0xFF) / 255.0f;
            final float llllllllllllIlIIIllllIIIlIlIIllI = (llllllllllllIlIIIllllIIIlIlIlIII >> 8 & 0xFF) / 255.0f;
            final float llllllllllllIlIIIllllIIIlIlIIlIl = (llllllllllllIlIIIllllIIIlIlIlIII & 0xFF) / 255.0f;
            final boolean llllllllllllIlIIIllllIIIlIlIIlII = llllllllllllIlIIIllllIIIIIllllll.shouldSideBeRendered(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl, EnumFacing.UP);
            final boolean llllllllllllIlIIIllllIIIlIlIIIll = llllllllllllIlIIIllllIIIIIllllll.shouldSideBeRendered(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl, EnumFacing.DOWN);
            final boolean[] llllllllllllIlIIIllllIIIlIlIIIlI = llllllllllllIlIIIllllIIIlIlIlIIl.getBorderFlags();
            llllllllllllIlIIIllllIIIlIlIIIlI[0] = llllllllllllIlIIIllllIIIIIllllll.shouldSideBeRendered(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl, EnumFacing.NORTH);
            llllllllllllIlIIIllllIIIlIlIIIlI[1] = llllllllllllIlIIIllllIIIIIllllll.shouldSideBeRendered(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl, EnumFacing.SOUTH);
            llllllllllllIlIIIllllIIIlIlIIIlI[2] = llllllllllllIlIIIllllIIIIIllllll.shouldSideBeRendered(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl, EnumFacing.WEST);
            llllllllllllIlIIIllllIIIlIlIIIlI[3] = llllllllllllIlIIIllllIIIIIllllll.shouldSideBeRendered(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl, EnumFacing.EAST);
            if (llllllllllllIlIIIllllIIIlIlIIlII || llllllllllllIlIIIllllIIIlIlIIIll || llllllllllllIlIIIllllIIIlIlIIIlI[0] || llllllllllllIlIIIllllIIIlIlIIIlI[1] || llllllllllllIlIIIllllIIIlIlIIIlI[2] || llllllllllllIlIIIllllIIIlIlIIIlI[3]) {
                boolean llllllllllllIlIIIllllIIIlIlIllll = false;
                final float llllllllllllIlIIIllllIIIlIlIIIIl = 0.5f;
                final float llllllllllllIlIIIllllIIIlIlIIIII = 1.0f;
                final float llllllllllllIlIIIllllIIIlIIlllll = 0.8f;
                final float llllllllllllIlIIIllllIIIlIIllllI = 0.6f;
                final Material llllllllllllIlIIIllllIIIlIIlllIl = llllllllllllIlIIIllllIIIIIllllll.getMaterial();
                float llllllllllllIlIIIllllIIIlIIlllII = this.getFluidHeight(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl, llllllllllllIlIIIllllIIIlIIlllIl);
                float llllllllllllIlIIIllllIIIlIIllIll = this.getFluidHeight(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl.south(), llllllllllllIlIIIllllIIIlIIlllIl);
                float llllllllllllIlIIIllllIIIlIIllIlI = this.getFluidHeight(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl.east().south(), llllllllllllIlIIIllllIIIlIIlllIl);
                float llllllllllllIlIIIllllIIIlIIllIIl = this.getFluidHeight(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl.east(), llllllllllllIlIIIllllIIIlIIlllIl);
                final double llllllllllllIlIIIllllIIIlIIllIII = llllllllllllIlIIIllllIIIlIllIIIl.getX();
                final double llllllllllllIlIIIllllIIIlIIlIlll = llllllllllllIlIIIllllIIIlIllIIIl.getY();
                final double llllllllllllIlIIIllllIIIlIIlIllI = llllllllllllIlIIIllllIIIlIllIIIl.getZ();
                final float llllllllllllIlIIIllllIIIlIIlIlIl = 0.001f;
                if (llllllllllllIlIIIllllIIIlIlIIlII) {
                    llllllllllllIlIIIllllIIIlIlIllll = true;
                    final float llllllllllllIlIIIllllIIIlIIlIlII = BlockLiquid.getSlopeAngle(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl, llllllllllllIlIIIllllIIIlIIlllIl, llllllllllllIlIIIllllIIIIIllllll);
                    final TextureAtlasSprite llllllllllllIlIIIllllIIIlIIlIIll = (llllllllllllIlIIIllllIIIlIIlIlII > -999.0f) ? llllllllllllIlIIIllllIIIlIlIlIlI[1] : llllllllllllIlIIIllllIIIlIlIlIlI[0];
                    llllllllllllIlIIIllllIIIlIllIIII.setSprite(llllllllllllIlIIIllllIIIlIIlIIll);
                    llllllllllllIlIIIllllIIIlIIlllII -= 0.001f;
                    llllllllllllIlIIIllllIIIlIIllIll -= 0.001f;
                    llllllllllllIlIIIllllIIIlIIllIlI -= 0.001f;
                    llllllllllllIlIIIllllIIIlIIllIIl -= 0.001f;
                    float llllllllllllIlIIIllllIIIlIIlIIIl = 0.0f;
                    float llllllllllllIlIIIllllIIIlIIIlIIl = 0.0f;
                    float llllllllllllIlIIIllllIIIlIIIllll = 0.0f;
                    float llllllllllllIlIIIllllIIIlIIIIlll = 0.0f;
                    float llllllllllllIlIIIllllIIIlIIIllIl = 0.0f;
                    float llllllllllllIlIIIllllIIIlIIIIlIl = 0.0f;
                    float llllllllllllIlIIIllllIIIlIIIlIll = 0.0f;
                    float llllllllllllIlIIIllllIIIlIIIIIll = 0.0f;
                    if (llllllllllllIlIIIllllIIIlIIlIlII < -999.0f) {
                        final float llllllllllllIlIIIllllIIIlIIlIIlI = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedU(0.0);
                        final float llllllllllllIlIIIllllIIIlIIIlIlI = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedV(0.0);
                        final float llllllllllllIlIIIllllIIIlIIlIIII = llllllllllllIlIIIllllIIIlIIlIIlI;
                        final float llllllllllllIlIIIllllIIIlIIIlIII = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedV(16.0);
                        final float llllllllllllIlIIIllllIIIlIIIlllI = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedU(16.0);
                        final float llllllllllllIlIIIllllIIIlIIIIllI = llllllllllllIlIIIllllIIIlIIIlIII;
                        final float llllllllllllIlIIIllllIIIlIIIllII = llllllllllllIlIIIllllIIIlIIIlllI;
                        final float llllllllllllIlIIIllllIIIlIIIIlII = llllllllllllIlIIIllllIIIlIIIlIlI;
                    }
                    else {
                        final float llllllllllllIlIIIllllIIIlIIIIIlI = MathHelper.sin(llllllllllllIlIIIllllIIIlIIlIlII) * 0.25f;
                        final float llllllllllllIlIIIllllIIIlIIIIIIl = MathHelper.cos(llllllllllllIlIIIllllIIIlIIlIlII) * 0.25f;
                        final float llllllllllllIlIIIllllIIIlIIIIIII = 8.0f;
                        llllllllllllIlIIIllllIIIlIIlIIIl = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedU(8.0f + (-llllllllllllIlIIIllllIIIlIIIIIIl - llllllllllllIlIIIllllIIIlIIIIIlI) * 16.0f);
                        llllllllllllIlIIIllllIIIlIIIlIIl = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedV(8.0f + (-llllllllllllIlIIIllllIIIlIIIIIIl + llllllllllllIlIIIllllIIIlIIIIIlI) * 16.0f);
                        llllllllllllIlIIIllllIIIlIIIllll = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedU(8.0f + (-llllllllllllIlIIIllllIIIlIIIIIIl + llllllllllllIlIIIllllIIIlIIIIIlI) * 16.0f);
                        llllllllllllIlIIIllllIIIlIIIIlll = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedV(8.0f + (llllllllllllIlIIIllllIIIlIIIIIIl + llllllllllllIlIIIllllIIIlIIIIIlI) * 16.0f);
                        llllllllllllIlIIIllllIIIlIIIllIl = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedU(8.0f + (llllllllllllIlIIIllllIIIlIIIIIIl + llllllllllllIlIIIllllIIIlIIIIIlI) * 16.0f);
                        llllllllllllIlIIIllllIIIlIIIIlIl = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedV(8.0f + (llllllllllllIlIIIllllIIIlIIIIIIl - llllllllllllIlIIIllllIIIlIIIIIlI) * 16.0f);
                        llllllllllllIlIIIllllIIIlIIIlIll = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedU(8.0f + (llllllllllllIlIIIllllIIIlIIIIIIl - llllllllllllIlIIIllllIIIlIIIIIlI) * 16.0f);
                        llllllllllllIlIIIllllIIIlIIIIIll = llllllllllllIlIIIllllIIIlIIlIIll.getInterpolatedV(8.0f + (-llllllllllllIlIIIllllIIIlIIIIIIl - llllllllllllIlIIIllllIIIlIIIIIlI) * 16.0f);
                    }
                    final int llllllllllllIlIIIllllIIIIlllllll = llllllllllllIlIIIllllIIIIIllllll.getPackedLightmapCoords(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl);
                    final int llllllllllllIlIIIllllIIIIllllllI = llllllllllllIlIIIllllIIIIlllllll >> 16 & 0xFFFF;
                    final int llllllllllllIlIIIllllIIIIlllllIl = llllllllllllIlIIIllllIIIIlllllll & 0xFFFF;
                    final float llllllllllllIlIIIllllIIIIlllllII = 1.0f * llllllllllllIlIIIllllIIIlIlIIlll;
                    final float llllllllllllIlIIIllllIIIIllllIll = 1.0f * llllllllllllIlIIIllllIIIlIlIIllI;
                    final float llllllllllllIlIIIllllIIIIllllIlI = 1.0f * llllllllllllIlIIIllllIIIlIlIIlIl;
                    llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII + 0.0, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIlIIlllII, llllllllllllIlIIIllllIIIlIIlIllI + 0.0).color(llllllllllllIlIIIllllIIIIlllllII, llllllllllllIlIIIllllIIIIllllIll, llllllllllllIlIIIllllIIIIllllIlI, 1.0f).tex(llllllllllllIlIIIllllIIIlIIlIIIl, llllllllllllIlIIIllllIIIlIIIlIIl).lightmap(llllllllllllIlIIIllllIIIIllllllI, llllllllllllIlIIIllllIIIIlllllIl).endVertex();
                    llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII + 0.0, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIlIIllIll, llllllllllllIlIIIllllIIIlIIlIllI + 1.0).color(llllllllllllIlIIIllllIIIIlllllII, llllllllllllIlIIIllllIIIIllllIll, llllllllllllIlIIIllllIIIIllllIlI, 1.0f).tex(llllllllllllIlIIIllllIIIlIIIllll, llllllllllllIlIIIllllIIIlIIIIlll).lightmap(llllllllllllIlIIIllllIIIIllllllI, llllllllllllIlIIIllllIIIIlllllIl).endVertex();
                    llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII + 1.0, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIlIIllIlI, llllllllllllIlIIIllllIIIlIIlIllI + 1.0).color(llllllllllllIlIIIllllIIIIlllllII, llllllllllllIlIIIllllIIIIllllIll, llllllllllllIlIIIllllIIIIllllIlI, 1.0f).tex(llllllllllllIlIIIllllIIIlIIIllIl, llllllllllllIlIIIllllIIIlIIIIlIl).lightmap(llllllllllllIlIIIllllIIIIllllllI, llllllllllllIlIIIllllIIIIlllllIl).endVertex();
                    llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII + 1.0, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIlIIllIIl, llllllllllllIlIIIllllIIIlIIlIllI + 0.0).color(llllllllllllIlIIIllllIIIIlllllII, llllllllllllIlIIIllllIIIIllllIll, llllllllllllIlIIIllllIIIIllllIlI, 1.0f).tex(llllllllllllIlIIIllllIIIlIIIlIll, llllllllllllIlIIIllllIIIlIIIIIll).lightmap(llllllllllllIlIIIllllIIIIllllllI, llllllllllllIlIIIllllIIIIlllllIl).endVertex();
                    if (llllllllllllIlIIIllllIIIlIlIllII.shouldRenderSides(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl.up())) {
                        llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII + 0.0, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIlIIlllII, llllllllllllIlIIIllllIIIlIIlIllI + 0.0).color(llllllllllllIlIIIllllIIIIlllllII, llllllllllllIlIIIllllIIIIllllIll, llllllllllllIlIIIllllIIIIllllIlI, 1.0f).tex(llllllllllllIlIIIllllIIIlIIlIIIl, llllllllllllIlIIIllllIIIlIIIlIIl).lightmap(llllllllllllIlIIIllllIIIIllllllI, llllllllllllIlIIIllllIIIIlllllIl).endVertex();
                        llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII + 1.0, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIlIIllIIl, llllllllllllIlIIIllllIIIlIIlIllI + 0.0).color(llllllllllllIlIIIllllIIIIlllllII, llllllllllllIlIIIllllIIIIllllIll, llllllllllllIlIIIllllIIIIllllIlI, 1.0f).tex(llllllllllllIlIIIllllIIIlIIIlIll, llllllllllllIlIIIllllIIIlIIIIIll).lightmap(llllllllllllIlIIIllllIIIIllllllI, llllllllllllIlIIIllllIIIIlllllIl).endVertex();
                        llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII + 1.0, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIlIIllIlI, llllllllllllIlIIIllllIIIlIIlIllI + 1.0).color(llllllllllllIlIIIllllIIIIlllllII, llllllllllllIlIIIllllIIIIllllIll, llllllllllllIlIIIllllIIIIllllIlI, 1.0f).tex(llllllllllllIlIIIllllIIIlIIIllIl, llllllllllllIlIIIllllIIIlIIIIlIl).lightmap(llllllllllllIlIIIllllIIIIllllllI, llllllllllllIlIIIllllIIIIlllllIl).endVertex();
                        llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII + 0.0, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIlIIllIll, llllllllllllIlIIIllllIIIlIIlIllI + 1.0).color(llllllllllllIlIIIllllIIIIlllllII, llllllllllllIlIIIllllIIIIllllIll, llllllllllllIlIIIllllIIIIllllIlI, 1.0f).tex(llllllllllllIlIIIllllIIIlIIIllll, llllllllllllIlIIIllllIIIlIIIIlll).lightmap(llllllllllllIlIIIllllIIIIllllllI, llllllllllllIlIIIllllIIIIlllllIl).endVertex();
                    }
                }
                if (llllllllllllIlIIIllllIIIlIlIIIll) {
                    final float llllllllllllIlIIIllllIIIIllllIIl = llllllllllllIlIIIllllIIIlIlIlIlI[0].getMinU();
                    final float llllllllllllIlIIIllllIIIIllllIII = llllllllllllIlIIIllllIIIlIlIlIlI[0].getMaxU();
                    final float llllllllllllIlIIIllllIIIIlllIlll = llllllllllllIlIIIllllIIIlIlIlIlI[0].getMinV();
                    final float llllllllllllIlIIIllllIIIIlllIllI = llllllllllllIlIIIllllIIIlIlIlIlI[0].getMaxV();
                    final int llllllllllllIlIIIllllIIIIlllIlIl = llllllllllllIlIIIllllIIIIIllllll.getPackedLightmapCoords(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIlIllIIIl.down());
                    final int llllllllllllIlIIIllllIIIIlllIlII = llllllllllllIlIIIllllIIIIlllIlIl >> 16 & 0xFFFF;
                    final int llllllllllllIlIIIllllIIIIlllIIll = llllllllllllIlIIIllllIIIIlllIlIl & 0xFFFF;
                    llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII, llllllllllllIlIIIllllIIIlIIlIlll, llllllllllllIlIIIllllIIIlIIlIllI + 1.0).color(llllllllllllIlIIIllllIIIlIlIIlll * 0.5f, llllllllllllIlIIIllllIIIlIlIIllI * 0.5f, llllllllllllIlIIIllllIIIlIlIIlIl * 0.5f, 1.0f).tex(llllllllllllIlIIIllllIIIIllllIIl, llllllllllllIlIIIllllIIIIlllIllI).lightmap(llllllllllllIlIIIllllIIIIlllIlII, llllllllllllIlIIIllllIIIIlllIIll).endVertex();
                    llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII, llllllllllllIlIIIllllIIIlIIlIlll, llllllllllllIlIIIllllIIIlIIlIllI).color(llllllllllllIlIIIllllIIIlIlIIlll * 0.5f, llllllllllllIlIIIllllIIIlIlIIllI * 0.5f, llllllllllllIlIIIllllIIIlIlIIlIl * 0.5f, 1.0f).tex(llllllllllllIlIIIllllIIIIllllIIl, llllllllllllIlIIIllllIIIIlllIlll).lightmap(llllllllllllIlIIIllllIIIIlllIlII, llllllllllllIlIIIllllIIIIlllIIll).endVertex();
                    llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII + 1.0, llllllllllllIlIIIllllIIIlIIlIlll, llllllllllllIlIIIllllIIIlIIlIllI).color(llllllllllllIlIIIllllIIIlIlIIlll * 0.5f, llllllllllllIlIIIllllIIIlIlIIllI * 0.5f, llllllllllllIlIIIllllIIIlIlIIlIl * 0.5f, 1.0f).tex(llllllllllllIlIIIllllIIIIllllIII, llllllllllllIlIIIllllIIIIlllIlll).lightmap(llllllllllllIlIIIllllIIIIlllIlII, llllllllllllIlIIIllllIIIIlllIIll).endVertex();
                    llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIlIIllIII + 1.0, llllllllllllIlIIIllllIIIlIIlIlll, llllllllllllIlIIIllllIIIlIIlIllI + 1.0).color(llllllllllllIlIIIllllIIIlIlIIlll * 0.5f, llllllllllllIlIIIllllIIIlIlIIllI * 0.5f, llllllllllllIlIIIllllIIIlIlIIlIl * 0.5f, 1.0f).tex(llllllllllllIlIIIllllIIIIllllIII, llllllllllllIlIIIllllIIIIlllIllI).lightmap(llllllllllllIlIIIllllIIIIlllIlII, llllllllllllIlIIIllllIIIIlllIIll).endVertex();
                    llllllllllllIlIIIllllIIIlIlIllll = true;
                }
                for (int llllllllllllIlIIIllllIIIIlllIIlI = 0; llllllllllllIlIIIllllIIIIlllIIlI < 4; ++llllllllllllIlIIIllllIIIIlllIIlI) {
                    int llllllllllllIlIIIllllIIIIlllIIIl = 0;
                    int llllllllllllIlIIIllllIIIIlllIIII = 0;
                    if (llllllllllllIlIIIllllIIIIlllIIlI == 0) {
                        --llllllllllllIlIIIllllIIIIlllIIII;
                    }
                    if (llllllllllllIlIIIllllIIIIlllIIlI == 1) {
                        ++llllllllllllIlIIIllllIIIIlllIIII;
                    }
                    if (llllllllllllIlIIIllllIIIIlllIIlI == 2) {
                        --llllllllllllIlIIIllllIIIIlllIIIl;
                    }
                    if (llllllllllllIlIIIllllIIIIlllIIlI == 3) {
                        ++llllllllllllIlIIIllllIIIIlllIIIl;
                    }
                    final BlockPos llllllllllllIlIIIllllIIIIllIllll = llllllllllllIlIIIllllIIIlIllIIIl.add(llllllllllllIlIIIllllIIIIlllIIIl, 0, llllllllllllIlIIIllllIIIIlllIIII);
                    TextureAtlasSprite llllllllllllIlIIIllllIIIIllIlllI = llllllllllllIlIIIllllIIIlIlIlIlI[1];
                    llllllllllllIlIIIllllIIIlIllIIII.setSprite(llllllllllllIlIIIllllIIIIllIlllI);
                    float llllllllllllIlIIIllllIIIIllIllIl = 0.0f;
                    float llllllllllllIlIIIllllIIIIllIllII = 0.0f;
                    if (!llllllllllllIlIIIllllIIIlIlIlIll) {
                        final IBlockState llllllllllllIlIIIllllIIIIllIlIll = llllllllllllIlIIIllllIIIlIllIIll.getBlockState(llllllllllllIlIIIllllIIIIllIllll);
                        final Block llllllllllllIlIIIllllIIIIllIlIlI = llllllllllllIlIIIllllIIIIllIlIll.getBlock();
                        if (llllllllllllIlIIIllllIIIIllIlIlI == Blocks.GLASS || llllllllllllIlIIIllllIIIIllIlIlI == Blocks.STAINED_GLASS || llllllllllllIlIIIllllIIIIllIlIlI == Blocks.BEACON || llllllllllllIlIIIllllIIIIllIlIlI == Blocks.SLIME_BLOCK) {
                            llllllllllllIlIIIllllIIIIllIlllI = this.atlasSpriteWaterOverlay;
                            llllllllllllIlIIIllllIIIlIllIIII.setSprite(llllllllllllIlIIIllllIIIIllIlllI);
                        }
                        if (llllllllllllIlIIIllllIIIIllIlIlI == Blocks.FARMLAND || llllllllllllIlIIIllllIIIIllIlIlI == Blocks.GRASS_PATH) {
                            llllllllllllIlIIIllllIIIIllIllIl = 0.9375f;
                            llllllllllllIlIIIllllIIIIllIllII = 0.9375f;
                        }
                        if (llllllllllllIlIIIllllIIIIllIlIlI instanceof BlockSlab) {
                            final BlockSlab llllllllllllIlIIIllllIIIIllIlIIl = (BlockSlab)llllllllllllIlIIIllllIIIIllIlIlI;
                            if (!llllllllllllIlIIIllllIIIIllIlIIl.isDouble() && llllllllllllIlIIIllllIIIIllIlIll.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) {
                                llllllllllllIlIIIllllIIIIllIllIl = 0.5f;
                                llllllllllllIlIIIllllIIIIllIllII = 0.5f;
                            }
                        }
                    }
                    if (llllllllllllIlIIIllllIIIlIlIIIlI[llllllllllllIlIIIllllIIIIlllIIlI]) {
                        float llllllllllllIlIIIllllIIIIllIIlIl = 0.0f;
                        float llllllllllllIlIIIllllIIIIllIIIIl = 0.0f;
                        double llllllllllllIlIIIllllIIIIlIlllIl = 0.0;
                        double llllllllllllIlIIIllllIIIIlIlIlIl = 0.0;
                        double llllllllllllIlIIIllllIIIIlIllIIl = 0.0;
                        double llllllllllllIlIIIllllIIIIlIlIIIl = 0.0;
                        if (llllllllllllIlIIIllllIIIIlllIIlI == 0) {
                            final float llllllllllllIlIIIllllIIIIllIlIII = llllllllllllIlIIIllllIIIlIIlllII;
                            final float llllllllllllIlIIIllllIIIIllIIlII = llllllllllllIlIIIllllIIIlIIllIIl;
                            final double llllllllllllIlIIIllllIIIIllIIIII = llllllllllllIlIIIllllIIIlIIllIII;
                            final double llllllllllllIlIIIllllIIIIlIllIII = llllllllllllIlIIIllllIIIlIIllIII + 1.0;
                            final double llllllllllllIlIIIllllIIIIlIlllII = llllllllllllIlIIIllllIIIlIIlIllI + 0.0010000000474974513;
                            final double llllllllllllIlIIIllllIIIIlIlIlII = llllllllllllIlIIIllllIIIlIIlIllI + 0.0010000000474974513;
                        }
                        else if (llllllllllllIlIIIllllIIIIlllIIlI == 1) {
                            final float llllllllllllIlIIIllllIIIIllIIlll = llllllllllllIlIIIllllIIIlIIllIlI;
                            final float llllllllllllIlIIIllllIIIIllIIIll = llllllllllllIlIIIllllIIIlIIllIll;
                            final double llllllllllllIlIIIllllIIIIlIlllll = llllllllllllIlIIIllllIIIlIIllIII + 1.0;
                            final double llllllllllllIlIIIllllIIIIlIlIlll = llllllllllllIlIIIllllIIIlIIllIII;
                            final double llllllllllllIlIIIllllIIIIlIllIll = llllllllllllIlIIIllllIIIlIIlIllI + 1.0 - 0.0010000000474974513;
                            final double llllllllllllIlIIIllllIIIIlIlIIll = llllllllllllIlIIIllllIIIlIIlIllI + 1.0 - 0.0010000000474974513;
                        }
                        else if (llllllllllllIlIIIllllIIIIlllIIlI == 2) {
                            final float llllllllllllIlIIIllllIIIIllIIllI = llllllllllllIlIIIllllIIIlIIllIll;
                            final float llllllllllllIlIIIllllIIIIllIIIlI = llllllllllllIlIIIllllIIIlIIlllII;
                            final double llllllllllllIlIIIllllIIIIlIllllI = llllllllllllIlIIIllllIIIlIIllIII + 0.0010000000474974513;
                            final double llllllllllllIlIIIllllIIIIlIlIllI = llllllllllllIlIIIllllIIIlIIllIII + 0.0010000000474974513;
                            final double llllllllllllIlIIIllllIIIIlIllIlI = llllllllllllIlIIIllllIIIlIIlIllI + 1.0;
                            final double llllllllllllIlIIIllllIIIIlIlIIlI = llllllllllllIlIIIllllIIIlIIlIllI;
                        }
                        else {
                            llllllllllllIlIIIllllIIIIllIIlIl = llllllllllllIlIIIllllIIIlIIllIIl;
                            llllllllllllIlIIIllllIIIIllIIIIl = llllllllllllIlIIIllllIIIlIIllIlI;
                            llllllllllllIlIIIllllIIIIlIlllIl = llllllllllllIlIIIllllIIIlIIllIII + 1.0 - 0.0010000000474974513;
                            llllllllllllIlIIIllllIIIIlIlIlIl = llllllllllllIlIIIllllIIIlIIllIII + 1.0 - 0.0010000000474974513;
                            llllllllllllIlIIIllllIIIIlIllIIl = llllllllllllIlIIIllllIIIlIIlIllI;
                            llllllllllllIlIIIllllIIIIlIlIIIl = llllllllllllIlIIIllllIIIlIIlIllI + 1.0;
                        }
                        if (llllllllllllIlIIIllllIIIIllIIlIl > llllllllllllIlIIIllllIIIIllIllIl || llllllllllllIlIIIllllIIIIllIIIIl > llllllllllllIlIIIllllIIIIllIllII) {
                            llllllllllllIlIIIllllIIIIllIllIl = Math.min(llllllllllllIlIIIllllIIIIllIllIl, llllllllllllIlIIIllllIIIIllIIlIl);
                            llllllllllllIlIIIllllIIIIllIllII = Math.min(llllllllllllIlIIIllllIIIIllIllII, llllllllllllIlIIIllllIIIIllIIIIl);
                            if (llllllllllllIlIIIllllIIIIllIllIl > llllllllllllIlIIIllllIIIlIIlIlIl) {
                                llllllllllllIlIIIllllIIIIllIllIl -= llllllllllllIlIIIllllIIIlIIlIlIl;
                            }
                            if (llllllllllllIlIIIllllIIIIllIllII > llllllllllllIlIIIllllIIIlIIlIlIl) {
                                llllllllllllIlIIIllllIIIIllIllII -= llllllllllllIlIIIllllIIIlIIlIlIl;
                            }
                            llllllllllllIlIIIllllIIIlIlIllll = true;
                            final float llllllllllllIlIIIllllIIIIlIlIIII = llllllllllllIlIIIllllIIIIllIlllI.getInterpolatedU(0.0);
                            final float llllllllllllIlIIIllllIIIIlIIllll = llllllllllllIlIIIllllIIIIllIlllI.getInterpolatedU(8.0);
                            final float llllllllllllIlIIIllllIIIIlIIlllI = llllllllllllIlIIIllllIIIIllIlllI.getInterpolatedV((1.0f - llllllllllllIlIIIllllIIIIllIIlIl) * 16.0f * 0.5f);
                            final float llllllllllllIlIIIllllIIIIlIIllIl = llllllllllllIlIIIllllIIIIllIlllI.getInterpolatedV((1.0f - llllllllllllIlIIIllllIIIIllIIIIl) * 16.0f * 0.5f);
                            final float llllllllllllIlIIIllllIIIIlIIllII = llllllllllllIlIIIllllIIIIllIlllI.getInterpolatedV(8.0);
                            final float llllllllllllIlIIIllllIIIIlIIlIll = llllllllllllIlIIIllllIIIIllIlllI.getInterpolatedV((1.0f - llllllllllllIlIIIllllIIIIllIllIl) * 16.0f * 0.5f);
                            final float llllllllllllIlIIIllllIIIIlIIlIlI = llllllllllllIlIIIllllIIIIllIlllI.getInterpolatedV((1.0f - llllllllllllIlIIIllllIIIIllIllII) * 16.0f * 0.5f);
                            final int llllllllllllIlIIIllllIIIIlIIlIIl = llllllllllllIlIIIllllIIIIIllllll.getPackedLightmapCoords(llllllllllllIlIIIllllIIIlIllIIll, llllllllllllIlIIIllllIIIIllIllll);
                            final int llllllllllllIlIIIllllIIIIlIIlIII = llllllllllllIlIIIllllIIIIlIIlIIl >> 16 & 0xFFFF;
                            final int llllllllllllIlIIIllllIIIIlIIIlll = llllllllllllIlIIIllllIIIIlIIlIIl & 0xFFFF;
                            final float llllllllllllIlIIIllllIIIIlIIIllI = (llllllllllllIlIIIllllIIIIlllIIlI < 2) ? 0.8f : 0.6f;
                            final float llllllllllllIlIIIllllIIIIlIIIlIl = 1.0f * llllllllllllIlIIIllllIIIIlIIIllI * llllllllllllIlIIIllllIIIlIlIIlll;
                            final float llllllllllllIlIIIllllIIIIlIIIlII = 1.0f * llllllllllllIlIIIllllIIIIlIIIllI * llllllllllllIlIIIllllIIIlIlIIllI;
                            final float llllllllllllIlIIIllllIIIIlIIIIll = 1.0f * llllllllllllIlIIIllllIIIIlIIIllI * llllllllllllIlIIIllllIIIlIlIIlIl;
                            llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIIlIlllIl, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIIllIIlIl, llllllllllllIlIIIllllIIIIlIllIIl).color(llllllllllllIlIIIllllIIIIlIIIlIl, llllllllllllIlIIIllllIIIIlIIIlII, llllllllllllIlIIIllllIIIIlIIIIll, 1.0f).tex(llllllllllllIlIIIllllIIIIlIlIIII, llllllllllllIlIIIllllIIIIlIIlllI).lightmap(llllllllllllIlIIIllllIIIIlIIlIII, llllllllllllIlIIIllllIIIIlIIIlll).endVertex();
                            llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIIlIlIlIl, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIIllIIIIl, llllllllllllIlIIIllllIIIIlIlIIIl).color(llllllllllllIlIIIllllIIIIlIIIlIl, llllllllllllIlIIIllllIIIIlIIIlII, llllllllllllIlIIIllllIIIIlIIIIll, 1.0f).tex(llllllllllllIlIIIllllIIIIlIIllll, llllllllllllIlIIIllllIIIIlIIllIl).lightmap(llllllllllllIlIIIllllIIIIlIIlIII, llllllllllllIlIIIllllIIIIlIIIlll).endVertex();
                            llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIIlIlIlIl, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIIllIllII, llllllllllllIlIIIllllIIIIlIlIIIl).color(llllllllllllIlIIIllllIIIIlIIIlIl, llllllllllllIlIIIllllIIIIlIIIlII, llllllllllllIlIIIllllIIIIlIIIIll, 1.0f).tex(llllllllllllIlIIIllllIIIIlIIllll, llllllllllllIlIIIllllIIIIlIIlIlI).lightmap(llllllllllllIlIIIllllIIIIlIIlIII, llllllllllllIlIIIllllIIIIlIIIlll).endVertex();
                            llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIIlIlllIl, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIIllIllIl, llllllllllllIlIIIllllIIIIlIllIIl).color(llllllllllllIlIIIllllIIIIlIIIlIl, llllllllllllIlIIIllllIIIIlIIIlII, llllllllllllIlIIIllllIIIIlIIIIll, 1.0f).tex(llllllllllllIlIIIllllIIIIlIlIIII, llllllllllllIlIIIllllIIIIlIIlIll).lightmap(llllllllllllIlIIIllllIIIIlIIlIII, llllllllllllIlIIIllllIIIIlIIIlll).endVertex();
                            if (llllllllllllIlIIIllllIIIIllIlllI != this.atlasSpriteWaterOverlay) {
                                llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIIlIlllIl, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIIllIllIl, llllllllllllIlIIIllllIIIIlIllIIl).color(llllllllllllIlIIIllllIIIIlIIIlIl, llllllllllllIlIIIllllIIIIlIIIlII, llllllllllllIlIIIllllIIIIlIIIIll, 1.0f).tex(llllllllllllIlIIIllllIIIIlIlIIII, llllllllllllIlIIIllllIIIIlIIlIll).lightmap(llllllllllllIlIIIllllIIIIlIIlIII, llllllllllllIlIIIllllIIIIlIIIlll).endVertex();
                                llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIIlIlIlIl, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIIllIllII, llllllllllllIlIIIllllIIIIlIlIIIl).color(llllllllllllIlIIIllllIIIIlIIIlIl, llllllllllllIlIIIllllIIIIlIIIlII, llllllllllllIlIIIllllIIIIlIIIIll, 1.0f).tex(llllllllllllIlIIIllllIIIIlIIllll, llllllllllllIlIIIllllIIIIlIIlIlI).lightmap(llllllllllllIlIIIllllIIIIlIIlIII, llllllllllllIlIIIllllIIIIlIIIlll).endVertex();
                                llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIIlIlIlIl, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIIllIIIIl, llllllllllllIlIIIllllIIIIlIlIIIl).color(llllllllllllIlIIIllllIIIIlIIIlIl, llllllllllllIlIIIllllIIIIlIIIlII, llllllllllllIlIIIllllIIIIlIIIIll, 1.0f).tex(llllllllllllIlIIIllllIIIIlIIllll, llllllllllllIlIIIllllIIIIlIIllIl).lightmap(llllllllllllIlIIIllllIIIIlIIlIII, llllllllllllIlIIIllllIIIIlIIIlll).endVertex();
                                llllllllllllIlIIIllllIIIlIllIIII.pos(llllllllllllIlIIIllllIIIIlIlllIl, llllllllllllIlIIIllllIIIlIIlIlll + llllllllllllIlIIIllllIIIIllIIlIl, llllllllllllIlIIIllllIIIIlIllIIl).color(llllllllllllIlIIIllllIIIIlIIIlIl, llllllllllllIlIIIllllIIIIlIIIlII, llllllllllllIlIIIllllIIIIlIIIIll, 1.0f).tex(llllllllllllIlIIIllllIIIIlIlIIII, llllllllllllIlIIIllllIIIIlIIlllI).lightmap(llllllllllllIlIIIllllIIIIlIIlIII, llllllllllllIlIIIllllIIIIlIIIlll).endVertex();
                            }
                        }
                    }
                }
                llllllllllllIlIIIllllIIIlIllIIII.setSprite(null);
                final boolean llllllllllllIlIIIllllIIIIIIIIlII;
                final boolean llllllllllllIlIIIllllIIIIlIIIIlI = llllllllllllIlIIIllllIIIIIIIIlII = llllllllllllIlIIIllllIIIlIlIllll;
                return llllllllllllIlIIIllllIIIIIIIIlII;
            }
            final boolean llllllllllllIlIIIllllIIIlIlIlllI = false;
        }
        finally {
            if (Config.isShaders()) {
                SVertexBuilder.popEntity(llllllllllllIlIIIllllIIIlIllIIII);
            }
        }
        if (Config.isShaders()) {
            SVertexBuilder.popEntity(llllllllllllIlIIIllllIIIlIllIIII);
        }
        final boolean llllllllllllIlIIIllllIIIlIlIllIl;
        return llllllllllllIlIIIllllIIIlIlIllIl;
    }
}
