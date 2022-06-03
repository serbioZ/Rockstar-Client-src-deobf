// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import org.lwjgl.util.vector.ReadableVector3f;
import shadersmod.client.Shaders;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.Vec3i;
import optifine.Reflector;
import net.minecraft.util.math.MathHelper;
import optifine.BlockModelUtils;
import net.minecraft.client.renderer.EnumFaceDirection;
import org.lwjgl.util.vector.Vector4f;
import org.lwjgl.util.vector.Matrix4f;
import optifine.Config;
import net.minecraftforge.common.model.ITransformation;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.lwjgl.util.vector.Vector3f;

public class FaceBakery
{
    private static final /* synthetic */ Rotation UV_ROTATION_0;
    private static final /* synthetic */ Rotation[] UV_ROTATIONS;
    private static final /* synthetic */ Rotation UV_ROTATION_90;
    private static final /* synthetic */ Rotation UV_ROTATION_270;
    private static final /* synthetic */ float SCALE_ROTATION_GENERAL;
    private static final /* synthetic */ Rotation UV_ROTATION_INVERSE;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private static final /* synthetic */ float SCALE_ROTATION_22_5;
    
    private void storeVertexData(final int[] lllllllllllIlIIlllIllIIIllIIllll, final int lllllllllllIlIIlllIllIIIllIIIlIl, final int lllllllllllIlIIlllIllIIIllIIllIl, final Vector3f lllllllllllIlIIlllIllIIIllIIllII, final int lllllllllllIlIIlllIllIIIllIIIIlI, final TextureAtlasSprite lllllllllllIlIIlllIllIIIllIIlIlI, final BlockFaceUV lllllllllllIlIIlllIllIIIllIIIIII) {
        final int lllllllllllIlIIlllIllIIIllIIlIII = lllllllllllIlIIlllIllIIIllIIllll.length / 4;
        final int lllllllllllIlIIlllIllIIIllIIIlll = lllllllllllIlIIlllIllIIIllIIIlIl * lllllllllllIlIIlllIllIIIllIIlIII;
        lllllllllllIlIIlllIllIIIllIIllll[lllllllllllIlIIlllIllIIIllIIIlll] = Float.floatToRawIntBits(lllllllllllIlIIlllIllIIIllIIllII.x);
        lllllllllllIlIIlllIllIIIllIIllll[lllllllllllIlIIlllIllIIIllIIIlll + 1] = Float.floatToRawIntBits(lllllllllllIlIIlllIllIIIllIIllII.y);
        lllllllllllIlIIlllIllIIIllIIllll[lllllllllllIlIIlllIllIIIllIIIlll + 2] = Float.floatToRawIntBits(lllllllllllIlIIlllIllIIIllIIllII.z);
        lllllllllllIlIIlllIllIIIllIIllll[lllllllllllIlIIlllIllIIIllIIIlll + 3] = lllllllllllIlIIlllIllIIIllIIIIlI;
        lllllllllllIlIIlllIllIIIllIIllll[lllllllllllIlIIlllIllIIIllIIIlll + 4] = Float.floatToRawIntBits(lllllllllllIlIIlllIllIIIllIIlIlI.getInterpolatedU(lllllllllllIlIIlllIllIIIllIIIIII.getVertexU(lllllllllllIlIIlllIllIIIllIIllIl) * 0.999 + lllllllllllIlIIlllIllIIIllIIIIII.getVertexU((lllllllllllIlIIlllIllIIIllIIllIl + 2) % 4) * 0.001));
        lllllllllllIlIIlllIllIIIllIIllll[lllllllllllIlIIlllIllIIIllIIIlll + 4 + 1] = Float.floatToRawIntBits(lllllllllllIlIIlllIllIIIllIIlIlI.getInterpolatedV(lllllllllllIlIIlllIllIIIllIIIIII.getVertexV(lllllllllllIlIIlllIllIIIllIIllIl) * 0.999 + lllllllllllIlIIlllIllIIIllIIIIII.getVertexV((lllllllllllIlIIlllIllIIIllIIllIl + 2) % 4) * 0.001));
    }
    
    public BakedQuad makeBakedQuad(final Vector3f lllllllllllIlIIlllIllIIlIllllllI, final Vector3f lllllllllllIlIIlllIllIIllIIIlIlI, final BlockPartFace lllllllllllIlIIlllIllIIlIlllllII, final TextureAtlasSprite lllllllllllIlIIlllIllIIlIllllIll, final EnumFacing lllllllllllIlIIlllIllIIlIllllIlI, final ModelRotation lllllllllllIlIIlllIllIIllIIIIllI, @Nullable final BlockPartRotation lllllllllllIlIIlllIllIIllIIIIlIl, final boolean lllllllllllIlIIlllIllIIlIlllIlll, final boolean lllllllllllIlIIlllIllIIllIIIIIll) {
        BlockFaceUV lllllllllllIlIIlllIllIIllIIIIIlI = lllllllllllIlIIlllIllIIlIlllllII.blockFaceUV;
        if (lllllllllllIlIIlllIllIIlIlllIlll) {
            lllllllllllIlIIlllIllIIllIIIIIlI = this.applyUVLock(lllllllllllIlIIlllIllIIlIlllllII.blockFaceUV, lllllllllllIlIIlllIllIIlIllllIlI, lllllllllllIlIIlllIllIIllIIIIllI);
        }
        final int[] lllllllllllIlIIlllIllIIllIIIIIIl = this.makeQuadVertexData(lllllllllllIlIIlllIllIIllIIIIIlI, lllllllllllIlIIlllIllIIlIllllIll, lllllllllllIlIIlllIllIIlIllllIlI, this.getPositionsDiv16(lllllllllllIlIIlllIllIIlIllllllI, lllllllllllIlIIlllIllIIllIIIlIlI), lllllllllllIlIIlllIllIIllIIIIllI, lllllllllllIlIIlllIllIIllIIIIlIl, lllllllllllIlIIlllIllIIllIIIIIll);
        final EnumFacing lllllllllllIlIIlllIllIIllIIIIIII = getFacingFromVertexData(lllllllllllIlIIlllIllIIllIIIIIIl);
        if (lllllllllllIlIIlllIllIIllIIIIlIl == null) {
            this.applyFacing(lllllllllllIlIIlllIllIIllIIIIIIl, lllllllllllIlIIlllIllIIllIIIIIII);
        }
        return new BakedQuad(lllllllllllIlIIlllIllIIllIIIIIIl, lllllllllllIlIIlllIllIIlIlllllII.tintIndex, lllllllllllIlIIlllIllIIllIIIIIII, lllllllllllIlIIlllIllIIlIllllIll);
    }
    
    private int[] makeQuadVertexData(final BlockFaceUV lllllllllllIlIIlllIllIIlIIllIIlI, final TextureAtlasSprite lllllllllllIlIIlllIllIIlIIlIIllI, final EnumFacing lllllllllllIlIIlllIllIIlIIlIIlIl, final float[] lllllllllllIlIIlllIllIIlIIlIllll, final ITransformation lllllllllllIlIIlllIllIIlIIlIlllI, @Nullable final BlockPartRotation lllllllllllIlIIlllIllIIlIIlIIIlI, final boolean lllllllllllIlIIlllIllIIlIIlIllII) {
        int lllllllllllIlIIlllIllIIlIIlIlIll = 28;
        if (Config.isShaders()) {
            lllllllllllIlIIlllIllIIlIIlIlIll = 56;
        }
        final int[] lllllllllllIlIIlllIllIIlIIlIlIlI = new int[lllllllllllIlIIlllIllIIlIIlIlIll];
        for (int lllllllllllIlIIlllIllIIlIIlIlIIl = 0; lllllllllllIlIIlllIllIIlIIlIlIIl < 4; ++lllllllllllIlIIlllIllIIlIIlIlIIl) {
            this.fillVertexData(lllllllllllIlIIlllIllIIlIIlIlIlI, lllllllllllIlIIlllIllIIlIIlIlIIl, lllllllllllIlIIlllIllIIlIIlIIlIl, lllllllllllIlIIlllIllIIlIIllIIlI, lllllllllllIlIIlllIllIIlIIlIllll, lllllllllllIlIIlllIllIIlIIlIIllI, lllllllllllIlIIlllIllIIlIIlIlllI, lllllllllllIlIIlllIllIIlIIlIIIlI, lllllllllllIlIIlllIllIIlIIlIllII);
        }
        return lllllllllllIlIIlllIllIIlIIlIlIlI;
    }
    
    private void rotateScale(final Vector3f lllllllllllIlIIlllIllIIIlIIIlIlI, final Vector3f lllllllllllIlIIlllIllIIIlIIIIlII, final Matrix4f lllllllllllIlIIlllIllIIIlIIIlIII, final Vector3f lllllllllllIlIIlllIllIIIlIIIIlll) {
        final Vector4f lllllllllllIlIIlllIllIIIlIIIIllI = new Vector4f(lllllllllllIlIIlllIllIIIlIIIlIlI.x - lllllllllllIlIIlllIllIIIlIIIIlII.x, lllllllllllIlIIlllIllIIIlIIIlIlI.y - lllllllllllIlIIlllIllIIIlIIIIlII.y, lllllllllllIlIIlllIllIIIlIIIlIlI.z - lllllllllllIlIIlllIllIIIlIIIIlII.z, 1.0f);
        Matrix4f.transform(lllllllllllIlIIlllIllIIIlIIIlIII, lllllllllllIlIIlllIllIIIlIIIIllI, lllllllllllIlIIlllIllIIIlIIIIllI);
        final Vector4f vector4f = lllllllllllIlIIlllIllIIIlIIIIllI;
        vector4f.x *= lllllllllllIlIIlllIllIIIlIIIIlll.x;
        final Vector4f vector4f2 = lllllllllllIlIIlllIllIIIlIIIIllI;
        vector4f2.y *= lllllllllllIlIIlllIllIIIlIIIIlll.y;
        final Vector4f vector4f3 = lllllllllllIlIIlllIllIIIlIIIIllI;
        vector4f3.z *= lllllllllllIlIIlllIllIIIlIIIIlll.z;
        lllllllllllIlIIlllIllIIIlIIIlIlI.set(lllllllllllIlIIlllIllIIIlIIIIllI.x + lllllllllllIlIIlllIllIIIlIIIIlII.x, lllllllllllIlIIlllIllIIIlIIIIllI.y + lllllllllllIlIIlllIllIIIlIIIIlII.y, lllllllllllIlIIlllIllIIIlIIIIllI.z + lllllllllllIlIIlllIllIIIlIIIIlII.z);
    }
    
    private void fillVertexData(final int[] lllllllllllIlIIlllIllIIIlllIIlll, final int lllllllllllIlIIlllIllIIIlllIIllI, final EnumFacing lllllllllllIlIIlllIllIIIllllIlII, final BlockFaceUV lllllllllllIlIIlllIllIIIlllIIlII, final float[] lllllllllllIlIIlllIllIIIllllIIlI, final TextureAtlasSprite lllllllllllIlIIlllIllIIIlllIIIlI, final ITransformation lllllllllllIlIIlllIllIIIlllIIIIl, @Nullable final BlockPartRotation lllllllllllIlIIlllIllIIIlllIllll, final boolean lllllllllllIlIIlllIllIIIllIlllll) {
        final EnumFacing lllllllllllIlIIlllIllIIIlllIllIl = lllllllllllIlIIlllIllIIIlllIIIIl.rotate(lllllllllllIlIIlllIllIIIllllIlII);
        final int lllllllllllIlIIlllIllIIIlllIllII = lllllllllllIlIIlllIllIIIllIlllll ? this.getFaceShadeColor(lllllllllllIlIIlllIllIIIlllIllIl) : -1;
        final EnumFaceDirection.VertexInformation lllllllllllIlIIlllIllIIIlllIlIll = EnumFaceDirection.getFacing(lllllllllllIlIIlllIllIIIllllIlII).getVertexInformation(lllllllllllIlIIlllIllIIIlllIIllI);
        final Vector3f lllllllllllIlIIlllIllIIIlllIlIlI = new Vector3f(lllllllllllIlIIlllIllIIIllllIIlI[lllllllllllIlIIlllIllIIIlllIlIll.xIndex], lllllllllllIlIIlllIllIIIllllIIlI[lllllllllllIlIIlllIllIIIlllIlIll.yIndex], lllllllllllIlIIlllIllIIIllllIIlI[lllllllllllIlIIlllIllIIIlllIlIll.zIndex]);
        this.rotatePart(lllllllllllIlIIlllIllIIIlllIlIlI, lllllllllllIlIIlllIllIIIlllIllll);
        final int lllllllllllIlIIlllIllIIIlllIlIIl = this.rotateVertex(lllllllllllIlIIlllIllIIIlllIlIlI, lllllllllllIlIIlllIllIIIllllIlII, lllllllllllIlIIlllIllIIIlllIIllI, lllllllllllIlIIlllIllIIIlllIIIIl);
        BlockModelUtils.snapVertexPosition(lllllllllllIlIIlllIllIIIlllIlIlI);
        this.storeVertexData(lllllllllllIlIIlllIllIIIlllIIlll, lllllllllllIlIIlllIllIIIlllIlIIl, lllllllllllIlIIlllIllIIIlllIIllI, lllllllllllIlIIlllIllIIIlllIlIlI, lllllllllllIlIIlllIllIIIlllIllII, lllllllllllIlIIlllIllIIIlllIIIlI, lllllllllllIlIIlllIllIIIlllIIlII);
    }
    
    private void applyFacing(final int[] lllllllllllIlIIlllIllIIIIIIllllI, final EnumFacing lllllllllllIlIIlllIllIIIIIllIIll) {
        final int[] lllllllllllIlIIlllIllIIIIIllIIlI = new int[lllllllllllIlIIlllIllIIIIIIllllI.length];
        System.arraycopy(lllllllllllIlIIlllIllIIIIIIllllI, 0, lllllllllllIlIIlllIllIIIIIllIIlI, 0, lllllllllllIlIIlllIllIIIIIIllllI.length);
        final float[] lllllllllllIlIIlllIllIIIIIllIIIl = new float[EnumFacing.values().length];
        lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.WEST_INDEX] = 999.0f;
        lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.DOWN_INDEX] = 999.0f;
        lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.NORTH_INDEX] = 999.0f;
        lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.EAST_INDEX] = -999.0f;
        lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.UP_INDEX] = -999.0f;
        lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.SOUTH_INDEX] = -999.0f;
        final int lllllllllllIlIIlllIllIIIIIllIIII = lllllllllllIlIIlllIllIIIIIIllllI.length / 4;
        for (int lllllllllllIlIIlllIllIIIIIlIllll = 0; lllllllllllIlIIlllIllIIIIIlIllll < 4; ++lllllllllllIlIIlllIllIIIIIlIllll) {
            final int lllllllllllIlIIlllIllIIIIIlIlllI = lllllllllllIlIIlllIllIIIIIllIIII * lllllllllllIlIIlllIllIIIIIlIllll;
            final float lllllllllllIlIIlllIllIIIIIlIllIl = Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIIllIIlI[lllllllllllIlIIlllIllIIIIIlIlllI]);
            final float lllllllllllIlIIlllIllIIIIIlIllII = Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIIllIIlI[lllllllllllIlIIlllIllIIIIIlIlllI + 1]);
            final float lllllllllllIlIIlllIllIIIIIlIlIll = Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIIllIIlI[lllllllllllIlIIlllIllIIIIIlIlllI + 2]);
            if (lllllllllllIlIIlllIllIIIIIlIllIl < lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.WEST_INDEX]) {
                lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.WEST_INDEX] = lllllllllllIlIIlllIllIIIIIlIllIl;
            }
            if (lllllllllllIlIIlllIllIIIIIlIllII < lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.DOWN_INDEX]) {
                lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.DOWN_INDEX] = lllllllllllIlIIlllIllIIIIIlIllII;
            }
            if (lllllllllllIlIIlllIllIIIIIlIlIll < lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.NORTH_INDEX]) {
                lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.NORTH_INDEX] = lllllllllllIlIIlllIllIIIIIlIlIll;
            }
            if (lllllllllllIlIIlllIllIIIIIlIllIl > lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.EAST_INDEX]) {
                lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.EAST_INDEX] = lllllllllllIlIIlllIllIIIIIlIllIl;
            }
            if (lllllllllllIlIIlllIllIIIIIlIllII > lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.UP_INDEX]) {
                lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.UP_INDEX] = lllllllllllIlIIlllIllIIIIIlIllII;
            }
            if (lllllllllllIlIIlllIllIIIIIlIlIll > lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.SOUTH_INDEX]) {
                lllllllllllIlIIlllIllIIIIIllIIIl[EnumFaceDirection.Constants.SOUTH_INDEX] = lllllllllllIlIIlllIllIIIIIlIlIll;
            }
        }
        final EnumFaceDirection lllllllllllIlIIlllIllIIIIIlIlIlI = EnumFaceDirection.getFacing(lllllllllllIlIIlllIllIIIIIllIIll);
        for (int lllllllllllIlIIlllIllIIIIIlIlIIl = 0; lllllllllllIlIIlllIllIIIIIlIlIIl < 4; ++lllllllllllIlIIlllIllIIIIIlIlIIl) {
            final int lllllllllllIlIIlllIllIIIIIlIlIII = lllllllllllIlIIlllIllIIIIIllIIII * lllllllllllIlIIlllIllIIIIIlIlIIl;
            final EnumFaceDirection.VertexInformation lllllllllllIlIIlllIllIIIIIlIIlll = lllllllllllIlIIlllIllIIIIIlIlIlI.getVertexInformation(lllllllllllIlIIlllIllIIIIIlIlIIl);
            final float lllllllllllIlIIlllIllIIIIIlIIllI = lllllllllllIlIIlllIllIIIIIllIIIl[lllllllllllIlIIlllIllIIIIIlIIlll.xIndex];
            final float lllllllllllIlIIlllIllIIIIIlIIlIl = lllllllllllIlIIlllIllIIIIIllIIIl[lllllllllllIlIIlllIllIIIIIlIIlll.yIndex];
            final float lllllllllllIlIIlllIllIIIIIlIIlII = lllllllllllIlIIlllIllIIIIIllIIIl[lllllllllllIlIIlllIllIIIIIlIIlll.zIndex];
            lllllllllllIlIIlllIllIIIIIIllllI[lllllllllllIlIIlllIllIIIIIlIlIII] = Float.floatToRawIntBits(lllllllllllIlIIlllIllIIIIIlIIllI);
            lllllllllllIlIIlllIllIIIIIIllllI[lllllllllllIlIIlllIllIIIIIlIlIII + 1] = Float.floatToRawIntBits(lllllllllllIlIIlllIllIIIIIlIIlIl);
            lllllllllllIlIIlllIllIIIIIIllllI[lllllllllllIlIIlllIllIIIIIlIlIII + 2] = Float.floatToRawIntBits(lllllllllllIlIIlllIllIIIIIlIIlII);
            for (int lllllllllllIlIIlllIllIIIIIlIIIll = 0; lllllllllllIlIIlllIllIIIIIlIIIll < 4; ++lllllllllllIlIIlllIllIIIIIlIIIll) {
                final int lllllllllllIlIIlllIllIIIIIlIIIlI = lllllllllllIlIIlllIllIIIIIllIIII * lllllllllllIlIIlllIllIIIIIlIIIll;
                final float lllllllllllIlIIlllIllIIIIIlIIIIl = Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIIllIIlI[lllllllllllIlIIlllIllIIIIIlIIIlI]);
                final float lllllllllllIlIIlllIllIIIIIlIIIII = Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIIllIIlI[lllllllllllIlIIlllIllIIIIIlIIIlI + 1]);
                final float lllllllllllIlIIlllIllIIIIIIlllll = Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIIllIIlI[lllllllllllIlIIlllIllIIIIIlIIIlI + 2]);
                if (MathHelper.epsilonEquals(lllllllllllIlIIlllIllIIIIIlIIllI, lllllllllllIlIIlllIllIIIIIlIIIIl) && MathHelper.epsilonEquals(lllllllllllIlIIlllIllIIIIIlIIlIl, lllllllllllIlIIlllIllIIIIIlIIIII) && MathHelper.epsilonEquals(lllllllllllIlIIlllIllIIIIIlIIlII, lllllllllllIlIIlllIllIIIIIIlllll)) {
                    lllllllllllIlIIlllIllIIIIIIllllI[lllllllllllIlIIlllIllIIIIIlIlIII + 4] = lllllllllllIlIIlllIllIIIIIllIIlI[lllllllllllIlIIlllIllIIIIIlIIIlI + 4];
                    lllllllllllIlIIlllIllIIIIIIllllI[lllllllllllIlIIlllIllIIIIIlIlIII + 4 + 1] = lllllllllllIlIIlllIllIIIIIllIIlI[lllllllllllIlIIlllIllIIIIIlIIIlI + 4 + 1];
                }
            }
        }
    }
    
    private static int getIndex(final ModelRotation lllllllllllIlIIlllIllIIIIIIIIIlI, final EnumFacing lllllllllllIlIIlllIlIlllllllllll) {
        return ModelRotation.values().length * lllllllllllIlIIlllIlIlllllllllll.ordinal() + lllllllllllIlIIlllIllIIIIIIIIIlI.ordinal();
    }
    
    static {
        SCALE_ROTATION_22_5 = 1.0f / (float)Math.cos(0.39269909262657166) - 1.0f;
        SCALE_ROTATION_GENERAL = 1.0f / (float)Math.cos(0.7853981633974483) - 1.0f;
        UV_ROTATIONS = new Rotation[ModelRotation.values().length * EnumFacing.values().length];
        UV_ROTATION_0 = new Rotation() {
            @Override
            BlockFaceUV makeRotatedUV(final float lllllllllllIllIIIllllllIIllIllIl, final float lllllllllllIllIIIllllllIIlllIIII, final float lllllllllllIllIIIllllllIIllIlIll, final float lllllllllllIllIIIllllllIIllIlllI) {
                return new BlockFaceUV(new float[] { lllllllllllIllIIIllllllIIllIllIl, lllllllllllIllIIIllllllIIlllIIII, lllllllllllIllIIIllllllIIllIlIll, lllllllllllIllIIIllllllIIllIlllI }, 0);
            }
        };
        UV_ROTATION_270 = new Rotation() {
            @Override
            BlockFaceUV makeRotatedUV(final float lllllllllllIlllIIIIIlIlIlIlIlIIl, final float lllllllllllIlllIIIIIlIlIlIlIlIII, final float lllllllllllIlllIIIIIlIlIlIlIIIll, final float lllllllllllIlllIIIIIlIlIlIlIIllI) {
                return new BlockFaceUV(new float[] { lllllllllllIlllIIIIIlIlIlIlIIllI, 16.0f - lllllllllllIlllIIIIIlIlIlIlIlIIl, lllllllllllIlllIIIIIlIlIlIlIlIII, 16.0f - lllllllllllIlllIIIIIlIlIlIlIIIll }, 270);
            }
        };
        UV_ROTATION_INVERSE = new Rotation() {
            @Override
            BlockFaceUV makeRotatedUV(final float lllllllllllIllIlIIIlIlIIIIIIIIIl, final float lllllllllllIllIlIIIlIlIIIIIIIlII, final float lllllllllllIllIlIIIlIlIIIIIIIIll, final float lllllllllllIllIlIIIlIlIIIIIIIIlI) {
                return new BlockFaceUV(new float[] { 16.0f - lllllllllllIllIlIIIlIlIIIIIIIIIl, 16.0f - lllllllllllIllIlIIIlIlIIIIIIIlII, 16.0f - lllllllllllIllIlIIIlIlIIIIIIIIll, 16.0f - lllllllllllIllIlIIIlIlIIIIIIIIlI }, 0);
            }
        };
        UV_ROTATION_90 = new Rotation() {
            @Override
            BlockFaceUV makeRotatedUV(final float lllllllllllIIllIllIIllllllIIlIII, final float lllllllllllIIllIllIIllllllIIlIll, final float lllllllllllIIllIllIIllllllIIIllI, final float lllllllllllIIllIllIIllllllIIIlIl) {
                return new BlockFaceUV(new float[] { 16.0f - lllllllllllIIllIllIIllllllIIlIll, lllllllllllIIllIllIIllllllIIIllI, 16.0f - lllllllllllIIllIllIIllllllIIIlIl, lllllllllllIIllIllIIllllllIIlIII }, 90);
            }
        };
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.EAST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.WEST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.EAST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.WEST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.EAST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.WEST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.EAST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.WEST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.UP, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.DOWN, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.WEST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.WEST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.WEST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.NORTH, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.WEST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.UP, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.DOWN, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.EAST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.EAST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.NORTH, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.EAST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.EAST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.EAST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.WEST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.EAST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.WEST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.EAST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.WEST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.EAST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.WEST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.UP, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.DOWN, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.EAST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.EAST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.NORTH, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.EAST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.EAST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.WEST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.DOWN, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.UP, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.WEST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.WEST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.NORTH, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.WEST, FaceBakery.UV_ROTATION_90);
    }
    
    private float[] getPositionsDiv16(final Vector3f lllllllllllIlIIlllIllIIlIIIIlIIl, final Vector3f lllllllllllIlIIlllIllIIlIIIIlIll) {
        final float[] lllllllllllIlIIlllIllIIlIIIIlIlI = new float[EnumFacing.values().length];
        lllllllllllIlIIlllIllIIlIIIIlIlI[EnumFaceDirection.Constants.WEST_INDEX] = lllllllllllIlIIlllIllIIlIIIIlIIl.x / 16.0f;
        lllllllllllIlIIlllIllIIlIIIIlIlI[EnumFaceDirection.Constants.DOWN_INDEX] = lllllllllllIlIIlllIllIIlIIIIlIIl.y / 16.0f;
        lllllllllllIlIIlllIllIIlIIIIlIlI[EnumFaceDirection.Constants.NORTH_INDEX] = lllllllllllIlIIlllIllIIlIIIIlIIl.z / 16.0f;
        lllllllllllIlIIlllIllIIlIIIIlIlI[EnumFaceDirection.Constants.EAST_INDEX] = lllllllllllIlIIlllIllIIlIIIIlIll.x / 16.0f;
        lllllllllllIlIIlllIllIIlIIIIlIlI[EnumFaceDirection.Constants.UP_INDEX] = lllllllllllIlIIlllIllIIlIIIIlIll.y / 16.0f;
        lllllllllllIlIIlllIllIIlIIIIlIlI[EnumFaceDirection.Constants.SOUTH_INDEX] = lllllllllllIlIIlllIllIIlIIIIlIll.z / 16.0f;
        return lllllllllllIlIIlllIllIIlIIIIlIlI;
    }
    
    public int rotateVertex(final Vector3f lllllllllllIlIIlllIllIIIlIIllIIl, final EnumFacing lllllllllllIlIIlllIllIIIlIIlIIll, final int lllllllllllIlIIlllIllIIIlIIlIIlI, final ITransformation lllllllllllIlIIlllIllIIIlIIlIIIl) {
        if (lllllllllllIlIIlllIllIIIlIIlIIIl == ModelRotation.X0_Y0) {
            return lllllllllllIlIIlllIllIIIlIIlIIlI;
        }
        if (Reflector.ForgeHooksClient_transform.exists()) {
            Reflector.call(Reflector.ForgeHooksClient_transform, new Object[] { lllllllllllIlIIlllIllIIIlIIllIIl, lllllllllllIlIIlllIllIIIlIIlIIIl.getMatrix() });
        }
        else {
            this.rotateScale(lllllllllllIlIIlllIllIIIlIIllIIl, new Vector3f(0.5f, 0.5f, 0.5f), ((ModelRotation)lllllllllllIlIIlllIllIIIlIIlIIIl).getMatrix4d(), new Vector3f(1.0f, 1.0f, 1.0f));
        }
        return lllllllllllIlIIlllIllIIIlIIlIIIl.rotate(lllllllllllIlIIlllIllIIIlIIlIIll, lllllllllllIlIIlllIllIIIlIIlIIlI);
    }
    
    public static EnumFacing getFacingFromVertexData(final int[] lllllllllllIlIIlllIllIIIIllIlIIl) {
        final int lllllllllllIlIIlllIllIIIIllIlIII = lllllllllllIlIIlllIllIIIIllIlIIl.length / 4;
        final int lllllllllllIlIIlllIllIIIIllIIlll = lllllllllllIlIIlllIllIIIIllIlIII * 2;
        final Vector3f lllllllllllIlIIlllIllIIIIllIIllI = new Vector3f(Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIllIlIIl[0]), Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIllIlIIl[1]), Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIllIlIIl[2]));
        final Vector3f lllllllllllIlIIlllIllIIIIllIIlIl = new Vector3f(Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIllIlIIl[lllllllllllIlIIlllIllIIIIllIlIII]), Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIllIlIIl[lllllllllllIlIIlllIllIIIIllIlIII + 1]), Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIllIlIIl[lllllllllllIlIIlllIllIIIIllIlIII + 2]));
        final Vector3f lllllllllllIlIIlllIllIIIIllIIlII = new Vector3f(Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIllIlIIl[lllllllllllIlIIlllIllIIIIllIIlll]), Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIllIlIIl[lllllllllllIlIIlllIllIIIIllIIlll + 1]), Float.intBitsToFloat(lllllllllllIlIIlllIllIIIIllIlIIl[lllllllllllIlIIlllIllIIIIllIIlll + 2]));
        final Vector3f lllllllllllIlIIlllIllIIIIllIIIll = new Vector3f();
        final Vector3f lllllllllllIlIIlllIllIIIIllIIIlI = new Vector3f();
        final Vector3f lllllllllllIlIIlllIllIIIIllIIIIl = new Vector3f();
        Vector3f.sub(lllllllllllIlIIlllIllIIIIllIIllI, lllllllllllIlIIlllIllIIIIllIIlIl, lllllllllllIlIIlllIllIIIIllIIIll);
        Vector3f.sub(lllllllllllIlIIlllIllIIIIllIIlII, lllllllllllIlIIlllIllIIIIllIIlIl, lllllllllllIlIIlllIllIIIIllIIIlI);
        Vector3f.cross(lllllllllllIlIIlllIllIIIIllIIIlI, lllllllllllIlIIlllIllIIIIllIIIll, lllllllllllIlIIlllIllIIIIllIIIIl);
        final float lllllllllllIlIIlllIllIIIIllIIIII = (float)Math.sqrt(lllllllllllIlIIlllIllIIIIllIIIIl.x * lllllllllllIlIIlllIllIIIIllIIIIl.x + lllllllllllIlIIlllIllIIIIllIIIIl.y * lllllllllllIlIIlllIllIIIIllIIIIl.y + lllllllllllIlIIlllIllIIIIllIIIIl.z * lllllllllllIlIIlllIllIIIIllIIIIl.z);
        final Vector3f vector3f = lllllllllllIlIIlllIllIIIIllIIIIl;
        vector3f.x /= lllllllllllIlIIlllIllIIIIllIIIII;
        final Vector3f vector3f2 = lllllllllllIlIIlllIllIIIIllIIIIl;
        vector3f2.y /= lllllllllllIlIIlllIllIIIIllIIIII;
        final Vector3f vector3f3 = lllllllllllIlIIlllIllIIIIllIIIIl;
        vector3f3.z /= lllllllllllIlIIlllIllIIIIllIIIII;
        EnumFacing lllllllllllIlIIlllIllIIIIlIlllll = null;
        float lllllllllllIlIIlllIllIIIIlIllllI = 0.0f;
        final long lllllllllllIlIIlllIllIIIIlIIlIlI;
        final String lllllllllllIlIIlllIllIIIIlIIlIll = (String)((EnumFacing[])(Object)(lllllllllllIlIIlllIllIIIIlIIlIlI = (long)(Object)EnumFacing.values())).length;
        for (long lllllllllllIlIIlllIllIIIIlIIllII = 0; lllllllllllIlIIlllIllIIIIlIIllII < lllllllllllIlIIlllIllIIIIlIIlIll; ++lllllllllllIlIIlllIllIIIIlIIllII) {
            final EnumFacing lllllllllllIlIIlllIllIIIIlIlllIl = lllllllllllIlIIlllIllIIIIlIIlIlI[lllllllllllIlIIlllIllIIIIlIIllII];
            final Vec3i lllllllllllIlIIlllIllIIIIlIlllII = lllllllllllIlIIlllIllIIIIlIlllIl.getDirectionVec();
            final Vector3f lllllllllllIlIIlllIllIIIIlIllIll = new Vector3f((float)lllllllllllIlIIlllIllIIIIlIlllII.getX(), (float)lllllllllllIlIIlllIllIIIIlIlllII.getY(), (float)lllllllllllIlIIlllIllIIIIlIlllII.getZ());
            final float lllllllllllIlIIlllIllIIIIlIllIlI = Vector3f.dot(lllllllllllIlIIlllIllIIIIllIIIIl, lllllllllllIlIIlllIllIIIIlIllIll);
            if (lllllllllllIlIIlllIllIIIIlIllIlI >= 0.0f && lllllllllllIlIIlllIllIIIIlIllIlI > lllllllllllIlIIlllIllIIIIlIllllI) {
                lllllllllllIlIIlllIllIIIIlIllllI = lllllllllllIlIIlllIllIIIIlIllIlI;
                lllllllllllIlIIlllIllIIIIlIlllll = lllllllllllIlIIlllIllIIIIlIlllIl;
            }
        }
        if (lllllllllllIlIIlllIllIIIIlIlllll == null) {
            return EnumFacing.UP;
        }
        return lllllllllllIlIIlllIllIIIIlIlllll;
    }
    
    private static void addUvRotation(final ModelRotation lllllllllllIlIIlllIllIIIIIIIlIlI, final EnumFacing lllllllllllIlIIlllIllIIIIIIIIllI, final Rotation lllllllllllIlIIlllIllIIIIIIIlIII) {
        FaceBakery.UV_ROTATIONS[getIndex(lllllllllllIlIIlllIllIIIIIIIlIlI, lllllllllllIlIIlllIllIIIIIIIIllI)] = lllllllllllIlIIlllIllIIIIIIIlIII;
    }
    
    private Matrix4f getMatrixIdentity() {
        final Matrix4f lllllllllllIlIIlllIllIIIIllllllI = new Matrix4f();
        lllllllllllIlIIlllIllIIIIllllllI.setIdentity();
        return lllllllllllIlIIlllIllIIIIllllllI;
    }
    
    public BakedQuad makeBakedQuad(final Vector3f lllllllllllIlIIlllIllIIlIlIlIlIl, final Vector3f lllllllllllIlIIlllIllIIlIlIlIlII, final BlockPartFace lllllllllllIlIIlllIllIIlIlIlIIll, final TextureAtlasSprite lllllllllllIlIIlllIllIIlIlIlIIlI, final EnumFacing lllllllllllIlIIlllIllIIlIlIlllll, final ITransformation lllllllllllIlIIlllIllIIlIlIllllI, final BlockPartRotation lllllllllllIlIIlllIllIIlIlIIllll, final boolean lllllllllllIlIIlllIllIIlIlIIlllI, final boolean lllllllllllIlIIlllIllIIlIlIllIll) {
        BlockFaceUV lllllllllllIlIIlllIllIIlIlIllIlI = lllllllllllIlIIlllIllIIlIlIlIIll.blockFaceUV;
        if (lllllllllllIlIIlllIllIIlIlIIlllI) {
            if (Reflector.ForgeHooksClient_applyUVLock.exists()) {
                lllllllllllIlIIlllIllIIlIlIllIlI = (BlockFaceUV)Reflector.call(Reflector.ForgeHooksClient_applyUVLock, new Object[] { lllllllllllIlIIlllIllIIlIlIlIIll.blockFaceUV, lllllllllllIlIIlllIllIIlIlIlllll, lllllllllllIlIIlllIllIIlIlIllllI });
            }
            else {
                lllllllllllIlIIlllIllIIlIlIllIlI = this.applyUVLock(lllllllllllIlIIlllIllIIlIlIlIIll.blockFaceUV, lllllllllllIlIIlllIllIIlIlIlllll, (ModelRotation)lllllllllllIlIIlllIllIIlIlIllllI);
            }
        }
        final boolean lllllllllllIlIIlllIllIIlIlIllIIl = lllllllllllIlIIlllIllIIlIlIllIll && !Reflector.ForgeHooksClient_fillNormal.exists();
        final int[] lllllllllllIlIIlllIllIIlIlIllIII = this.makeQuadVertexData(lllllllllllIlIIlllIllIIlIlIllIlI, lllllllllllIlIIlllIllIIlIlIlIIlI, lllllllllllIlIIlllIllIIlIlIlllll, this.getPositionsDiv16(lllllllllllIlIIlllIllIIlIlIlIlIl, lllllllllllIlIIlllIllIIlIlIlIlII), lllllllllllIlIIlllIllIIlIlIllllI, lllllllllllIlIIlllIllIIlIlIIllll, lllllllllllIlIIlllIllIIlIlIllIIl);
        final EnumFacing lllllllllllIlIIlllIllIIlIlIlIlll = getFacingFromVertexData(lllllllllllIlIIlllIllIIlIlIllIII);
        if (lllllllllllIlIIlllIllIIlIlIIllll == null) {
            this.applyFacing(lllllllllllIlIIlllIllIIlIlIllIII, lllllllllllIlIIlllIllIIlIlIlIlll);
        }
        if (Reflector.ForgeHooksClient_fillNormal.exists()) {
            Reflector.call(Reflector.ForgeHooksClient_fillNormal, new Object[] { lllllllllllIlIIlllIllIIlIlIllIII, lllllllllllIlIIlllIllIIlIlIlIlll });
            return new BakedQuad(lllllllllllIlIIlllIllIIlIlIllIII, lllllllllllIlIIlllIllIIlIlIlIIll.tintIndex, lllllllllllIlIIlllIllIIlIlIlIlll, lllllllllllIlIIlllIllIIlIlIlIIlI, lllllllllllIlIIlllIllIIlIlIllIll, DefaultVertexFormats.ITEM);
        }
        return new BakedQuad(lllllllllllIlIIlllIllIIlIlIllIII, lllllllllllIlIIlllIllIIlIlIlIIll.tintIndex, lllllllllllIlIIlllIllIIlIlIlIlll, lllllllllllIlIIlllIllIIlIlIlIIlI);
    }
    
    public int rotateVertex(final Vector3f lllllllllllIlIIlllIllIIIlIlIlIII, final EnumFacing lllllllllllIlIIlllIllIIIlIlIIIlI, final int lllllllllllIlIIlllIllIIIlIlIIllI, final ModelRotation lllllllllllIlIIlllIllIIIlIlIIIII) {
        return this.rotateVertex(lllllllllllIlIIlllIllIIIlIlIlIII, lllllllllllIlIIlllIllIIIlIlIIIlI, lllllllllllIlIIlllIllIIIlIlIIllI, lllllllllllIlIIlllIllIIIlIlIIIII);
    }
    
    public static float getFaceBrightness(final EnumFacing lllllllllllIlIIlllIllIIlIIIlIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlIIlllIllIIlIIIlIIlI.ordinal()]) {
            case 1: {
                if (Config.isShaders()) {
                    return Shaders.blockLightLevel05;
                }
                return 0.5f;
            }
            case 2: {
                return 1.0f;
            }
            case 3:
            case 4: {
                if (Config.isShaders()) {
                    return Shaders.blockLightLevel08;
                }
                return 0.8f;
            }
            case 5:
            case 6: {
                if (Config.isShaders()) {
                    return Shaders.blockLightLevel06;
                }
                return 0.6f;
            }
            default: {
                return 1.0f;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = FaceBakery.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final char lllllllllllIlIIlllIlIllllllllIll = (Object)new int[EnumFacing.Axis.values().length];
        try {
            lllllllllllIlIIlllIlIllllllllIll[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIlllIlIllllllllIll[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIlllIlIllllllllIll[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return FaceBakery.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllIlIIlllIlIllllllllIll;
    }
    
    private int getFaceShadeColor(final EnumFacing lllllllllllIlIIlllIllIIlIIIllIIl) {
        final float lllllllllllIlIIlllIllIIlIIIllIII = getFaceBrightness(lllllllllllIlIIlllIllIIlIIIllIIl);
        final int lllllllllllIlIIlllIllIIlIIIlIlll = MathHelper.clamp((int)(lllllllllllIlIIlllIllIIlIIIllIII * 255.0f), 0, 255);
        return 0xFF000000 | lllllllllllIlIIlllIllIIlIIIlIlll << 16 | lllllllllllIlIIlllIllIIlIIIlIlll << 8 | lllllllllllIlIIlllIllIIlIIIlIlll;
    }
    
    private BlockFaceUV applyUVLock(final BlockFaceUV lllllllllllIlIIlllIllIIlIlIIIIIl, final EnumFacing lllllllllllIlIIlllIllIIlIlIIIIll, final ModelRotation lllllllllllIlIIlllIllIIlIlIIIIlI) {
        return FaceBakery.UV_ROTATIONS[getIndex(lllllllllllIlIIlllIllIIlIlIIIIlI, lllllllllllIlIIlllIllIIlIlIIIIll)].rotateUV(lllllllllllIlIIlllIllIIlIlIIIIIl);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = FaceBakery.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final String lllllllllllIlIIlllIlIlllllllllIl = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlIIlllIlIlllllllllIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIlllIlIlllllllllIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIlllIlIlllllllllIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIIlllIlIlllllllllIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlIIlllIlIlllllllllIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlIIlllIlIlllllllllIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return FaceBakery.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlIIlllIlIlllllllllIl;
    }
    
    private void rotatePart(final Vector3f lllllllllllIlIIlllIllIIIlIllIlll, @Nullable final BlockPartRotation lllllllllllIlIIlllIllIIIlIllIIIl) {
        if (lllllllllllIlIIlllIllIIIlIllIIIl != null) {
            final Matrix4f lllllllllllIlIIlllIllIIIlIllIlIl = this.getMatrixIdentity();
            final Vector3f lllllllllllIlIIlllIllIIIlIllIlII = new Vector3f(0.0f, 0.0f, 0.0f);
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllIlIIlllIllIIIlIllIIIl.axis.ordinal()]) {
                case 1: {
                    Matrix4f.rotate(lllllllllllIlIIlllIllIIIlIllIIIl.angle * 0.017453292f, new Vector3f(1.0f, 0.0f, 0.0f), lllllllllllIlIIlllIllIIIlIllIlIl, lllllllllllIlIIlllIllIIIlIllIlIl);
                    lllllllllllIlIIlllIllIIIlIllIlII.set(0.0f, 1.0f, 1.0f);
                    break;
                }
                case 2: {
                    Matrix4f.rotate(lllllllllllIlIIlllIllIIIlIllIIIl.angle * 0.017453292f, new Vector3f(0.0f, 1.0f, 0.0f), lllllllllllIlIIlllIllIIIlIllIlIl, lllllllllllIlIIlllIllIIIlIllIlIl);
                    lllllllllllIlIIlllIllIIIlIllIlII.set(1.0f, 0.0f, 1.0f);
                    break;
                }
                case 3: {
                    Matrix4f.rotate(lllllllllllIlIIlllIllIIIlIllIIIl.angle * 0.017453292f, new Vector3f(0.0f, 0.0f, 1.0f), lllllllllllIlIIlllIllIIIlIllIlIl, lllllllllllIlIIlllIllIIIlIllIlIl);
                    lllllllllllIlIIlllIllIIIlIllIlII.set(1.0f, 1.0f, 0.0f);
                    break;
                }
            }
            if (lllllllllllIlIIlllIllIIIlIllIIIl.rescale) {
                if (Math.abs(lllllllllllIlIIlllIllIIIlIllIIIl.angle) == 22.5f) {
                    lllllllllllIlIIlllIllIIIlIllIlII.scale(FaceBakery.SCALE_ROTATION_22_5);
                }
                else {
                    lllllllllllIlIIlllIllIIIlIllIlII.scale(FaceBakery.SCALE_ROTATION_GENERAL);
                }
                Vector3f.add(lllllllllllIlIIlllIllIIIlIllIlII, new Vector3f(1.0f, 1.0f, 1.0f), lllllllllllIlIIlllIllIIIlIllIlII);
            }
            else {
                lllllllllllIlIIlllIllIIIlIllIlII.set(1.0f, 1.0f, 1.0f);
            }
            this.rotateScale(lllllllllllIlIIlllIllIIIlIllIlll, new Vector3f((ReadableVector3f)lllllllllllIlIIlllIllIIIlIllIIIl.origin), lllllllllllIlIIlllIllIIIlIllIlIl, lllllllllllIlIIlllIllIIIlIllIlII);
        }
    }
    
    abstract static class Rotation
    {
        abstract BlockFaceUV makeRotatedUV(final float p0, final float p1, final float p2, final float p3);
        
        public BlockFaceUV rotateUV(final BlockFaceUV lllllllllllIIlIIIIIllIlIIlIIlIlI) {
            final float lllllllllllIIlIIIIIllIlIIlIIlIIl = lllllllllllIIlIIIIIllIlIIlIIlIlI.getVertexU(lllllllllllIIlIIIIIllIlIIlIIlIlI.getVertexRotatedRev(0));
            final float lllllllllllIIlIIIIIllIlIIlIIlIII = lllllllllllIIlIIIIIllIlIIlIIlIlI.getVertexV(lllllllllllIIlIIIIIllIlIIlIIlIlI.getVertexRotatedRev(0));
            final float lllllllllllIIlIIIIIllIlIIlIIIlll = lllllllllllIIlIIIIIllIlIIlIIlIlI.getVertexU(lllllllllllIIlIIIIIllIlIIlIIlIlI.getVertexRotatedRev(2));
            final float lllllllllllIIlIIIIIllIlIIlIIIllI = lllllllllllIIlIIIIIllIlIIlIIlIlI.getVertexV(lllllllllllIIlIIIIIllIlIIlIIlIlI.getVertexRotatedRev(2));
            return this.makeRotatedUV(lllllllllllIIlIIIIIllIlIIlIIlIIl, lllllllllllIIlIIIIIllIlIIlIIlIII, lllllllllllIIlIIIIIllIlIIlIIIlll, lllllllllllIIlIIIIIllIlIIlIIIllI);
        }
        
        private Rotation() {
        }
    }
}
