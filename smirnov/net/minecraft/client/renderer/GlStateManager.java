// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import org.lwjgl.opengl.GLContext;
import org.lwjgl.BufferUtils;
import javax.annotation.Nullable;
import org.lwjgl.util.vector.Quaternion;
import optifine.GlBlendState;
import org.lwjgl.opengl.GL14;
import java.nio.ByteBuffer;
import optifine.Config;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;
import java.nio.FloatBuffer;

public class GlStateManager
{
    private static /* synthetic */ int activeTextureUnit;
    private static final /* synthetic */ ColorMaterialState colorMaterialState;
    private static final /* synthetic */ BooleanState[] lightState;
    private static /* synthetic */ int activeShadeModel;
    private static final /* synthetic */ BlendState blendState;
    private static final /* synthetic */ BooleanState rescaleNormalState;
    private static final /* synthetic */ Color colorState;
    private static final /* synthetic */ ColorMask colorMaskState;
    private static final /* synthetic */ FloatBuffer BUF_FLOAT_4;
    private static final /* synthetic */ BooleanState lightingState;
    private static final /* synthetic */ PolygonOffsetState polygonOffsetState;
    private static final /* synthetic */ CullState cullState;
    private static final /* synthetic */ AlphaState alphaState;
    private static final /* synthetic */ TextureState[] textureState;
    private static final /* synthetic */ ClearState clearState;
    private static final /* synthetic */ FogState fogState;
    public static /* synthetic */ boolean clearEnabled;
    private static final /* synthetic */ BooleanState normalizeState;
    private static final /* synthetic */ FloatBuffer BUF_FLOAT_16;
    private static final /* synthetic */ TexGenState texGenState;
    private static final /* synthetic */ ColorLogicState colorLogicState;
    private static final /* synthetic */ DepthState depthState;
    
    public static void glCopyTexSubImage2D(final int lllllllllllIlIIIIIlllIlIIIIlllll, final int lllllllllllIlIIIIIlllIlIIIlIIllI, final int lllllllllllIlIIIIIlllIlIIIIlllIl, final int lllllllllllIlIIIIIlllIlIIIlIIlII, final int lllllllllllIlIIIIIlllIlIIIlIIIll, final int lllllllllllIlIIIIIlllIlIIIIllIlI, final int lllllllllllIlIIIIIlllIlIIIIllIIl, final int lllllllllllIlIIIIIlllIlIIIIllIII) {
        GL11.glCopyTexSubImage2D(lllllllllllIlIIIIIlllIlIIIIlllll, lllllllllllIlIIIIIlllIlIIIlIIllI, lllllllllllIlIIIIIlllIlIIIIlllIl, lllllllllllIlIIIIIlllIlIIIlIIlII, lllllllllllIlIIIIIlllIlIIIlIIIll, lllllllllllIlIIIIIlllIlIIIIllIlI, lllllllllllIlIIIIIlllIlIIIIllIIl, lllllllllllIlIIIIIlllIlIIIIllIII);
    }
    
    public static void glDrawArrays(final int lllllllllllIlIIIIIlllIIIlllIIlIl, final int lllllllllllIlIIIIIlllIIIlllIIlll, final int lllllllllllIlIIIIIlllIIIlllIIllI) {
        GL11.glDrawArrays(lllllllllllIlIIIIIlllIIIlllIIlIl, lllllllllllIlIIIIIlllIIIlllIIlll, lllllllllllIlIIIIIlllIIIlllIIllI);
    }
    
    public static void enable(final int lllllllllllIlIIIIIlllIllIlIlllIl) {
        GL11.glEnable(lllllllllllIlIIIIIlllIllIlIlllIl);
    }
    
    public static void glNormal3f(final float lllllllllllIlIIIIIlllIllIIllIIIl, final float lllllllllllIlIIIIIlllIllIIlIllIl, final float lllllllllllIlIIIIIlllIllIIlIllll) {
        GL11.glNormal3f(lllllllllllIlIIIIIlllIllIIllIIIl, lllllllllllIlIIIIIlllIllIIlIllIl, lllllllllllIlIIIIIlllIllIIlIllll);
    }
    
    public static void translate(final float lllllllllllIlIIIIIlllIIllIIlllII, final float lllllllllllIlIIIIIlllIIllIIllllI, final float lllllllllllIlIIIIIlllIIllIIlllIl) {
        GL11.glTranslatef(lllllllllllIlIIIIIlllIIllIIlllII, lllllllllllIlIIIIIlllIIllIIllllI, lllllllllllIlIIIIIlllIIllIIlllIl);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen = GlStateManager.$SWITCH_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen;
        if ($switch_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen != null) {
            return $switch_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen;
        }
        final char lllllllllllIlIIIIIlllIIIlIIIIlII = (Object)new int[TexGen.values().length];
        try {
            lllllllllllIlIIIIIlllIIIlIIIIlII[TexGen.Q.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIIIIlllIIIlIIIIlII[TexGen.R.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIIIIlllIIIlIIIIlII[TexGen.S.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIIIIIlllIIIlIIIIlII[TexGen.T.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return GlStateManager.$SWITCH_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen = (int[])(Object)lllllllllllIlIIIIIlllIIIlIIIIlII;
    }
    
    public static void enableFog() {
        GlStateManager.fogState.fog.setEnabled();
    }
    
    public static void popMatrix() {
        GL11.glPopMatrix();
    }
    
    public static void glTexSubImage2D(final int lllllllllllIlIIIIIlllIlIIlIIIIIl, final int lllllllllllIlIIIIIlllIlIIlIIIIII, final int lllllllllllIlIIIIIlllIlIIIllllll, final int lllllllllllIlIIIIIlllIlIIIlllllI, final int lllllllllllIlIIIIIlllIlIIIllllIl, final int lllllllllllIlIIIIIlllIlIIIllllII, final int lllllllllllIlIIIIIlllIlIIIlllIll, final int lllllllllllIlIIIIIlllIlIIIllIIIl, final IntBuffer lllllllllllIlIIIIIlllIlIIIlllIIl) {
        GL11.glTexSubImage2D(lllllllllllIlIIIIIlllIlIIlIIIIIl, lllllllllllIlIIIIIlllIlIIlIIIIII, lllllllllllIlIIIIIlllIlIIIllllll, lllllllllllIlIIIIIlllIlIIIlllllI, lllllllllllIlIIIIIlllIlIIIllllIl, lllllllllllIlIIIIIlllIlIIIllllII, lllllllllllIlIIIIIlllIlIIIlllIll, lllllllllllIlIIIIIlllIlIIIllIIIl, lllllllllllIlIIIIIlllIlIIIlllIIl);
    }
    
    public static void disableDepth() {
        GlStateManager.depthState.depthTest.setDisabled();
    }
    
    public static void glTexEnv(final int lllllllllllIlIIIIIlllIlIlIlIIlll, final int lllllllllllIlIIIIIlllIlIlIlIIllI, final FloatBuffer lllllllllllIlIIIIIlllIlIlIlIIIlI) {
        GL11.glTexEnv(lllllllllllIlIIIIIlllIlIlIlIIlll, lllllllllllIlIIIIIlllIlIlIlIIllI, lllllllllllIlIIIIIlllIlIlIlIIIlI);
    }
    
    private static void cullFace(final int lllllllllllIlIIIIIlllIlIllIllIll) {
        if (lllllllllllIlIIIIIlllIlIllIllIll != GlStateManager.cullState.mode) {
            GlStateManager.cullState.mode = lllllllllllIlIIIIIlllIlIllIllIll;
            GL11.glCullFace(lllllllllllIlIIIIIlllIlIllIllIll);
        }
    }
    
    public static void glGetTexImage(final int lllllllllllIlIIIIIlllIlIIIIlIIlI, final int lllllllllllIlIIIIIlllIlIIIIIllII, final int lllllllllllIlIIIIIlllIlIIIIIlIll, final int lllllllllllIlIIIIIlllIlIIIIIlIlI, final IntBuffer lllllllllllIlIIIIIlllIlIIIIIlllI) {
        GL11.glGetTexImage(lllllllllllIlIIIIIlllIlIIIIlIIlI, lllllllllllIlIIIIIlllIlIIIIIllII, lllllllllllIlIIIIIlllIlIIIIIlIll, lllllllllllIlIIIIIlllIlIIIIIlIlI, lllllllllllIlIIIIIlllIlIIIIIlllI);
    }
    
    public static void glEndList() {
        GL11.glEndList();
    }
    
    public static void texGen(final TexGen lllllllllllIlIIIIIlllIlIlIllllll, final int lllllllllllIlIIIIIlllIlIlIlllIll) {
        final TexGenCoord lllllllllllIlIIIIIlllIlIlIllllIl = texGenCoord(lllllllllllIlIIIIIlllIlIlIllllll);
        if (lllllllllllIlIIIIIlllIlIlIlllIll != lllllllllllIlIIIIIlllIlIlIllllIl.param) {
            lllllllllllIlIIIIIlllIlIlIllllIl.param = lllllllllllIlIIIIIlllIlIlIlllIll;
            GL11.glTexGeni(lllllllllllIlIIIIIlllIlIlIllllIl.coord, 9472, lllllllllllIlIIIIIlllIlIlIlllIll);
        }
    }
    
    public static void glFogi(final int lllllllllllIlIIIIIlllIlIlllIIlII, final int lllllllllllIlIIIIIlllIlIlllIIIIl) {
        GL11.glFogi(lllllllllllIlIIIIIlllIlIlllIIlII, lllllllllllIlIIIIIlllIlIlllIIIIl);
    }
    
    public static void cullFace(final CullFace lllllllllllIlIIIIIlllIlIllIllllI) {
        cullFace(lllllllllllIlIIIIIlllIlIllIllllI.mode);
    }
    
    public static void checkBoundTexture() {
        if (Config.isMinecraftThread()) {
            final int lllllllllllIlIIIIIlllIIIlIIlllII = GL11.glGetInteger(34016);
            final int lllllllllllIlIIIIIlllIIIlIIllIll = GL11.glGetInteger(32873);
            final int lllllllllllIlIIIIIlllIIIlIIllIlI = getActiveTextureUnit();
            final int lllllllllllIlIIIIIlllIIIlIIllIIl = getBoundTexture();
            if (lllllllllllIlIIIIIlllIIIlIIllIIl > 0 && (lllllllllllIlIIIIIlllIIIlIIlllII != lllllllllllIlIIIIIlllIIIlIIllIlI || lllllllllllIlIIIIIlllIIIlIIllIll != lllllllllllIlIIIIIlllIIIlIIllIIl)) {
                Config.dbg("checkTexture: act: " + lllllllllllIlIIIIIlllIIIlIIllIlI + ", glAct: " + lllllllllllIlIIIIIlllIIIlIIlllII + ", tex: " + lllllllllllIlIIIIIlllIIIlIIllIIl + ", glTex: " + lllllllllllIlIIIIIlllIIIlIIllIll);
            }
        }
    }
    
    public static int glGenLists(final int lllllllllllIlIIIIIlllIIIllIIlllI) {
        return GL11.glGenLists(lllllllllllIlIIIIIlllIIIllIIlllI);
    }
    
    public static void translate(final double lllllllllllIlIIIIIlllIIllIIlIllI, final double lllllllllllIlIIIIIlllIIllIIlIlIl, final double lllllllllllIlIIIIIlllIIllIIlIIIl) {
        GL11.glTranslated(lllllllllllIlIIIIIlllIIllIIlIllI, lllllllllllIlIIIIIlllIIllIIlIlIl, lllllllllllIlIIIIIlllIIllIIlIIIl);
    }
    
    public static void glPixelStorei(final int lllllllllllIlIIIIIlllIIIllIIlIIl, final int lllllllllllIlIIIIIlllIIIllIIlIII) {
        GL11.glPixelStorei(lllllllllllIlIIIIIlllIIIllIIlIIl, lllllllllllIlIIIIIlllIIIllIIlIII);
    }
    
    private static TexGenCoord texGenCoord(final TexGen lllllllllllIlIIIIIlllIlIlIlIllll) {
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen()[lllllllllllIlIIIIIlllIlIlIlIllll.ordinal()]) {
            case 1: {
                return GlStateManager.texGenState.s;
            }
            case 2: {
                return GlStateManager.texGenState.t;
            }
            case 3: {
                return GlStateManager.texGenState.r;
            }
            case 4: {
                return GlStateManager.texGenState.q;
            }
            default: {
                return GlStateManager.texGenState.s;
            }
        }
    }
    
    public static void clearColor(final float lllllllllllIlIIIIIlllIIllllIIllI, final float lllllllllllIlIIIIIlllIIllllIIIIl, final float lllllllllllIlIIIIIlllIIllllIIlII, final float lllllllllllIlIIIIIlllIIllllIIIll) {
        if (lllllllllllIlIIIIIlllIIllllIIllI != GlStateManager.clearState.color.red || lllllllllllIlIIIIIlllIIllllIIIIl != GlStateManager.clearState.color.green || lllllllllllIlIIIIIlllIIllllIIlII != GlStateManager.clearState.color.blue || lllllllllllIlIIIIIlllIIllllIIIll != GlStateManager.clearState.color.alpha) {
            GlStateManager.clearState.color.red = lllllllllllIlIIIIIlllIIllllIIllI;
            GlStateManager.clearState.color.green = lllllllllllIlIIIIIlllIIllllIIIIl;
            GlStateManager.clearState.color.blue = lllllllllllIlIIIIIlllIIllllIIlII;
            GlStateManager.clearState.color.alpha = lllllllllllIlIIIIIlllIIllllIIIll;
            GL11.glClearColor(lllllllllllIlIIIIIlllIIllllIIllI, lllllllllllIlIIIIIlllIIllllIIIIl, lllllllllllIlIIIIIlllIIllllIIlII, lllllllllllIlIIIIIlllIIllllIIIll);
        }
    }
    
    public static void matrixMode(final int lllllllllllIlIIIIIlllIIlllIllIIl) {
        GL11.glMatrixMode(lllllllllllIlIIIIIlllIIlllIllIIl);
    }
    
    public static void viewport(final int lllllllllllIlIIIIIlllIIlllllllIl, final int lllllllllllIlIIIIIlllIIlllllllII, final int lllllllllllIlIIIIIlllIIllllllIll, final int lllllllllllIlIIIIIlllIIllllllllI) {
        GL11.glViewport(lllllllllllIlIIIIIlllIIlllllllIl, lllllllllllIlIIIIIlllIIlllllllII, lllllllllllIlIIIIIlllIIllllllIll, lllllllllllIlIIIIIlllIIllllllllI);
    }
    
    public static void enableBlend() {
        GlStateManager.blendState.blend.setEnabled();
    }
    
    public static void enableLight(final int lllllllllllIlIIIIIlllIllIlIIlllI) {
        GlStateManager.lightState[lllllllllllIlIIIIIlllIllIlIIlllI].setEnabled();
    }
    
    public static void glEnd() {
        GL11.glEnd();
    }
    
    public static int getActiveTextureUnit() {
        return OpenGlHelper.defaultTexUnit + GlStateManager.activeTextureUnit;
    }
    
    public static void resetColor() {
        GlStateManager.colorState.red = -1.0f;
        GlStateManager.colorState.green = -1.0f;
        GlStateManager.colorState.blue = -1.0f;
        GlStateManager.colorState.alpha = -1.0f;
    }
    
    public static void glColorPointer(final int lllllllllllIlIIIIIlllIIIlllllIII, final int lllllllllllIlIIIIIlllIIIlllllIll, final int lllllllllllIlIIIIIlllIIIlllllIlI, final ByteBuffer lllllllllllIlIIIIIlllIIIlllllIIl) {
        GL11.glColorPointer(lllllllllllIlIIIIIlllIIIlllllIII, lllllllllllIlIIIIIlllIIIlllllIll, lllllllllllIlIIIIIlllIIIlllllIlI, lllllllllllIlIIIIIlllIIIlllllIIl);
    }
    
    public static void setActiveTexture(final int lllllllllllIlIIIIIlllIlIlIlIllII) {
        if (GlStateManager.activeTextureUnit != lllllllllllIlIIIIIlllIlIlIlIllII - OpenGlHelper.defaultTexUnit) {
            GlStateManager.activeTextureUnit = lllllllllllIlIIIIIlllIlIlIlIllII - OpenGlHelper.defaultTexUnit;
            OpenGlHelper.setActiveTexture(lllllllllllIlIIIIIlllIlIlIlIllII);
        }
    }
    
    public static boolean isFogEnabled() {
        return GlStateManager.fogState.fog.currentState;
    }
    
    public static void glBlendEquation(final int lllllllllllIlIIIIIlllIllIIIIIIII) {
        GL14.glBlendEquation(lllllllllllIlIIIIIlllIllIIIIIIII);
    }
    
    public static void glLineWidth(final float lllllllllllIlIIIIIlllIIIlllIIIII) {
        GL11.glLineWidth(lllllllllllIlIIIIIlllIIIlllIIIII);
    }
    
    public static void pushAttrib() {
        GL11.glPushAttrib(8256);
    }
    
    public static void callList(final int lllllllllllIlIIIIIlllIIIllIlllIl) {
        GL11.glCallList(lllllllllllIlIIIIIlllIIIllIlllIl);
    }
    
    public static void disableAlpha() {
        GlStateManager.alphaState.alphaTest.setDisabled();
    }
    
    public static void depthFunc(final int lllllllllllIlIIIIIlllIllIIlIlIIl) {
        if (lllllllllllIlIIIIIlllIllIIlIlIIl != GlStateManager.depthState.depthFunc) {
            GlStateManager.depthState.depthFunc = lllllllllllIlIIIIIlllIllIIlIlIIl;
            GL11.glDepthFunc(lllllllllllIlIIIIIlllIllIIlIlIIl);
        }
    }
    
    public static void setFogEnd(final float lllllllllllIlIIIIIlllIlIlllIllIl) {
        if (lllllllllllIlIIIIIlllIlIlllIllIl != GlStateManager.fogState.end) {
            GlStateManager.fogState.end = lllllllllllIlIIIIIlllIlIlllIllIl;
            GL11.glFogf(2916, lllllllllllIlIIIIIlllIlIlllIllIl);
        }
    }
    
    public static void doPolygonOffset(final float lllllllllllIlIIIIIlllIlIllIlIIlI, final float lllllllllllIlIIIIIlllIlIllIIllll) {
        if (lllllllllllIlIIIIIlllIlIllIlIIlI != GlStateManager.polygonOffsetState.factor || lllllllllllIlIIIIIlllIlIllIIllll != GlStateManager.polygonOffsetState.units) {
            GlStateManager.polygonOffsetState.factor = lllllllllllIlIIIIIlllIlIllIlIIlI;
            GlStateManager.polygonOffsetState.units = lllllllllllIlIIIIIlllIlIllIIllll;
            GL11.glPolygonOffset(lllllllllllIlIIIIIlllIlIllIlIIlI, lllllllllllIlIIIIIlllIlIllIIllll);
        }
    }
    
    public static void glTexCoord2f(final float lllllllllllIlIIIIIlllIIlIlIlIIII, final float lllllllllllIlIIIIIlllIIlIlIlIIIl) {
        GL11.glTexCoord2f(lllllllllllIlIIIIIlllIIlIlIlIIII, lllllllllllIlIIIIIlllIIlIlIlIIIl);
    }
    
    public static void disableTexGenCoord(final TexGen lllllllllllIlIIIIIlllIlIllIIIlII) {
        texGenCoord(lllllllllllIlIIIIIlllIlIllIIIlII).textureGen.setDisabled();
    }
    
    public static void bindTexture(final int lllllllllllIlIIIIIlllIlIIllIIllI) {
        final TextureState textureState = GlStateManager.textureState[GlStateManager.activeTextureUnit];
        if (lllllllllllIlIIIIIlllIlIIllIIllI != TextureState.textureName) {
            final TextureState textureState2 = GlStateManager.textureState[GlStateManager.activeTextureUnit];
            GL11.glBindTexture(3553, TextureState.textureName = lllllllllllIlIIIIIlllIlIIllIIllI);
        }
    }
    
    public static int glGetTexLevelParameteri(final int lllllllllllIlIIIIIlllIlIIllllIlI, final int lllllllllllIlIIIIIlllIlIIlllIllI, final int lllllllllllIlIIIIIlllIlIIlllIlIl) {
        return GL11.glGetTexLevelParameteri(lllllllllllIlIIIIIlllIlIIllllIlI, lllllllllllIlIIIIIlllIlIIlllIllI, lllllllllllIlIIIIIlllIlIIlllIlIl);
    }
    
    public static void glGetInteger(final int lllllllllllIlIIIIIlllIIIlIlIllIl, final IntBuffer lllllllllllIlIIIIIlllIIIlIlIllII) {
        GL11.glGetInteger(lllllllllllIlIIIIIlllIIIlIlIllIl, lllllllllllIlIIIIIlllIIIlIlIllII);
    }
    
    public static void setFogEnabled(final boolean lllllllllllIlIIIIIlllIIIlIIIllII) {
        GlStateManager.fogState.fog.setState(lllllllllllIlIIIIIlllIIIlIIIllII);
    }
    
    public static void disableRescaleNormal() {
        GlStateManager.rescaleNormalState.setDisabled();
    }
    
    public static void loadIdentity() {
        GL11.glLoadIdentity();
    }
    
    public static void enableBlendProfile(final Profile lllllllllllIlIIIIIlllIIIlIlIIlII) {
        lllllllllllIlIIIIIlllIIIlIlIIlII.apply();
    }
    
    public static void glDisableClientState(final int lllllllllllIlIIIIIlllIIIllllIIlI) {
        GL11.glDisableClientState(lllllllllllIlIIIIIlllIIIllllIIlI);
    }
    
    public static void enableAlpha() {
        GlStateManager.alphaState.alphaTest.setEnabled();
    }
    
    public static void disableColorMaterial() {
        GlStateManager.colorMaterialState.colorMaterial.setDisabled();
    }
    
    public static void enableOutlineMode(final int lllllllllllIlIIIIIlllIlIllllllII) {
        GlStateManager.BUF_FLOAT_4.put(0, (lllllllllllIlIIIIIlllIlIllllllII >> 16 & 0xFF) / 255.0f);
        GlStateManager.BUF_FLOAT_4.put(1, (lllllllllllIlIIIIIlllIlIllllllII >> 8 & 0xFF) / 255.0f);
        GlStateManager.BUF_FLOAT_4.put(2, (lllllllllllIlIIIIIlllIlIllllllII >> 0 & 0xFF) / 255.0f);
        GlStateManager.BUF_FLOAT_4.put(3, (lllllllllllIlIIIIIlllIlIllllllII >> 24 & 0xFF) / 255.0f);
        glTexEnv(8960, 8705, GlStateManager.BUF_FLOAT_4);
        glTexEnvi(8960, 8704, 34160);
        glTexEnvi(8960, 34161, 7681);
        glTexEnvi(8960, 34176, 34166);
        glTexEnvi(8960, 34192, 768);
        glTexEnvi(8960, 34162, 7681);
        glTexEnvi(8960, 34184, 5890);
        glTexEnvi(8960, 34200, 770);
    }
    
    public static void setFog(final FogMode lllllllllllIlIIIIIlllIlIlllllIlI) {
        setFog(lllllllllllIlIIIIIlllIlIlllllIlI.capabilityId);
    }
    
    public static void deleteTexture(final int lllllllllllIlIIIIIlllIlIIllIllll) {
        if (lllllllllllIlIIIIIlllIlIIllIllll != 0) {
            GL11.glDeleteTextures(lllllllllllIlIIIIIlllIlIIllIllll);
            final float lllllllllllIlIIIIIlllIlIIllIlIIl;
            final byte lllllllllllIlIIIIIlllIlIIllIlIlI = (byte)((TextureState[])(Object)(lllllllllllIlIIIIIlllIlIIllIlIIl = (float)(Object)GlStateManager.textureState)).length;
            for (float lllllllllllIlIIIIIlllIlIIllIlIll = 0; lllllllllllIlIIIIIlllIlIIllIlIll < lllllllllllIlIIIIIlllIlIIllIlIlI; ++lllllllllllIlIIIIIlllIlIIllIlIll) {
                final TextureState lllllllllllIlIIIIIlllIlIIllIlllI = lllllllllllIlIIIIIlllIlIIllIlIIl[lllllllllllIlIIIIIlllIlIIllIlIll];
                if (TextureState.textureName == lllllllllllIlIIIIIlllIlIIllIllll) {
                    TextureState.textureName = 0;
                }
            }
        }
    }
    
    public static void glTexEnvi(final int lllllllllllIlIIIIIlllIlIlIIllllI, final int lllllllllllIlIIIIIlllIlIlIIlllIl, final int lllllllllllIlIIIIIlllIlIlIIllIIl) {
        GL11.glTexEnvi(lllllllllllIlIIIIIlllIlIlIIllllI, lllllllllllIlIIIIIlllIlIlIIlllIl, lllllllllllIlIIIIIlllIlIlIIllIIl);
    }
    
    public static void multMatrix(final FloatBuffer lllllllllllIlIIIIIlllIIllIIIlllI) {
        GL11.glMultMatrix(lllllllllllIlIIIIIlllIIllIIIlllI);
    }
    
    public static void disableTexture2D() {
        GlStateManager.textureState[GlStateManager.activeTextureUnit].texture2DState.setDisabled();
    }
    
    private static void setFog(final int lllllllllllIlIIIIIlllIlIllllIlll) {
        if (lllllllllllIlIIIIIlllIlIllllIlll != GlStateManager.fogState.mode) {
            GlStateManager.fogState.mode = lllllllllllIlIIIIIlllIlIllllIlll;
            GL11.glFogi(2917, lllllllllllIlIIIIIlllIlIllllIlll);
        }
    }
    
    public static void setFogDensity(final float lllllllllllIlIIIIIlllIlIllllIlII) {
        if (lllllllllllIlIIIIIlllIlIllllIlII != GlStateManager.fogState.density) {
            GlStateManager.fogState.density = lllllllllllIlIIIIIlllIlIllllIlII;
            GL11.glFogf(2914, lllllllllllIlIIIIIlllIlIllllIlII);
        }
    }
    
    public static int getBoundTexture() {
        final TextureState textureState = GlStateManager.textureState[GlStateManager.activeTextureUnit];
        return TextureState.textureName;
    }
    
    public static void glTexCoordPointer(final int lllllllllllIlIIIIIlllIIlIIllIlII, final int lllllllllllIlIIIIIlllIIlIIllIlll, final int lllllllllllIlIIIIIlllIIlIIllIllI, final int lllllllllllIlIIIIIlllIIlIIllIlIl) {
        GL11.glTexCoordPointer(lllllllllllIlIIIIIlllIIlIIllIlII, lllllllllllIlIIIIIlllIIlIIllIlll, lllllllllllIlIIIIIlllIIlIIllIllI, (long)lllllllllllIlIIIIIlllIIlIIllIlIl);
    }
    
    public static void enablePolygonOffset() {
        GlStateManager.polygonOffsetState.polygonOffsetFill.setEnabled();
    }
    
    public static void enableColorMaterial() {
        GlStateManager.colorMaterialState.colorMaterial.setEnabled();
    }
    
    public static void enableDepth() {
        GlStateManager.depthState.depthTest.setEnabled();
    }
    
    public static void enableLighting() {
        GlStateManager.lightingState.setEnabled();
    }
    
    public static void pushMatrix() {
        GL11.glPushMatrix();
    }
    
    public static void enableTexGenCoord(final TexGen lllllllllllIlIIIIIlllIlIllIIIllI) {
        texGenCoord(lllllllllllIlIIIIIlllIlIllIIIllI).textureGen.setEnabled();
    }
    
    public static void glReadPixels(final int lllllllllllIlIIIIIlllIIIllIIIIII, final int lllllllllllIlIIIIIlllIIIlIlllIII, final int lllllllllllIlIIIIIlllIIIlIlllllI, final int lllllllllllIlIIIIIlllIIIlIllIllI, final int lllllllllllIlIIIIIlllIIIlIllIlIl, final int lllllllllllIlIIIIIlllIIIlIlllIll, final IntBuffer lllllllllllIlIIIIIlllIIIlIllIIll) {
        GL11.glReadPixels(lllllllllllIlIIIIIlllIIIllIIIIII, lllllllllllIlIIIIIlllIIIlIlllIII, lllllllllllIlIIIIIlllIIIlIlllllI, lllllllllllIlIIIIIlllIIIlIllIllI, lllllllllllIlIIIIIlllIIIlIllIlIl, lllllllllllIlIIIIIlllIIIlIlllIll, lllllllllllIlIIIIIlllIIIlIllIIll);
    }
    
    public static void glFog(final int lllllllllllIlIIIIIlllIlIlllIlIII, final FloatBuffer lllllllllllIlIIIIIlllIlIlllIlIIl) {
        GL11.glFog(lllllllllllIlIIIIIlllIlIlllIlIII, lllllllllllIlIIIIIlllIlIlllIlIIl);
    }
    
    public static void clear(final int lllllllllllIlIIIIIlllIIlllIlllII) {
        if (GlStateManager.clearEnabled) {
            GL11.glClear(lllllllllllIlIIIIIlllIIlllIlllII);
        }
    }
    
    public static void rotate(final float lllllllllllIlIIIIIlllIIllIllllII, final float lllllllllllIlIIIIIlllIIllIllIlll, final float lllllllllllIlIIIIIlllIIllIlllIlI, final float lllllllllllIlIIIIIlllIIllIllIlIl) {
        GL11.glRotatef(lllllllllllIlIIIIIlllIIllIllllII, lllllllllllIlIIIIIlllIIllIllIlll, lllllllllllIlIIIIIlllIIllIlllIlI, lllllllllllIlIIIIIlllIIllIllIlIl);
    }
    
    public static void color(final float lllllllllllIlIIIIIlllIIlIlIllIlI, final float lllllllllllIlIIIIIlllIIlIlIllIIl, final float lllllllllllIlIIIIIlllIIlIlIllIII) {
        color(lllllllllllIlIIIIIlllIIlIlIllIlI, lllllllllllIlIIIIIlllIIlIlIllIIl, lllllllllllIlIIIIIlllIIlIlIllIII, 1.0f);
    }
    
    public static void disableNormalize() {
        GlStateManager.normalizeState.setDisabled();
    }
    
    public static void enableTexture2D() {
        GlStateManager.textureState[GlStateManager.activeTextureUnit].texture2DState.setEnabled();
    }
    
    public static void blendFunc(final SourceFactor lllllllllllIlIIIIIlllIllIIlIIIIl, final DestFactor lllllllllllIlIIIIIlllIllIIlIIIII) {
        blendFunc(lllllllllllIlIIIIIlllIllIIlIIIIl.factor, lllllllllllIlIIIIIlllIllIIlIIIII.factor);
    }
    
    public static void enableNormalize() {
        GlStateManager.normalizeState.setEnabled();
    }
    
    public static void glVertexPointer(final int lllllllllllIlIIIIIlllIIlIIIlIlII, final int lllllllllllIlIIIIIlllIIlIIIlIIll, final int lllllllllllIlIIIIIlllIIlIIIIlllI, final ByteBuffer lllllllllllIlIIIIIlllIIlIIIIllIl) {
        GL11.glVertexPointer(lllllllllllIlIIIIIlllIIlIIIlIlII, lllllllllllIlIIIIIlllIIlIIIlIIll, lllllllllllIlIIIIIlllIIlIIIIlllI, lllllllllllIlIIIIIlllIIlIIIIllIl);
    }
    
    public static int glGetError() {
        return GL11.glGetError();
    }
    
    public static void scale(final double lllllllllllIlIIIIIlllIIllIlIIlIl, final double lllllllllllIlIIIIIlllIIllIlIIlII, final double lllllllllllIlIIIIIlllIIllIlIIllI) {
        GL11.glScaled(lllllllllllIlIIIIIlllIIllIlIIlIl, lllllllllllIlIIIIIlllIIllIlIIlII, lllllllllllIlIIIIIlllIIllIlIIllI);
    }
    
    public static void glLightModel(final int lllllllllllIlIIIIIlllIllIIllIllI, final FloatBuffer lllllllllllIlIIIIIlllIllIIllIlll) {
        GL11.glLightModel(lllllllllllIlIIIIIlllIllIIllIllI, lllllllllllIlIIIIIlllIllIIllIlll);
    }
    
    public static void glEnableClientState(final int lllllllllllIlIIIIIlllIIIllllIIII) {
        GL11.glEnableClientState(lllllllllllIlIIIIIlllIIIllllIIII);
    }
    
    public static void disableBlendProfile(final Profile lllllllllllIlIIIIIlllIIIlIlIIIlI) {
        lllllllllllIlIIIIIlllIIIlIlIIIlI.clean();
    }
    
    public static void glDeleteLists(final int lllllllllllIlIIIIIlllIIIllIllIlI, final int lllllllllllIlIIIIIlllIIIllIllIIl) {
        GL11.glDeleteLists(lllllllllllIlIIIIIlllIIIllIllIlI, lllllllllllIlIIIIIlllIIIllIllIIl);
    }
    
    public static void disableCull() {
        GlStateManager.cullState.cullFace.setDisabled();
    }
    
    public static void popAttrib() {
        GL11.glPopAttrib();
    }
    
    public static void disablePolygonOffset() {
        GlStateManager.polygonOffsetState.polygonOffsetFill.setDisabled();
    }
    
    public static void colorMask(final boolean lllllllllllIlIIIIIlllIIlllllIIIl, final boolean lllllllllllIlIIIIIlllIIlllllIlII, final boolean lllllllllllIlIIIIIlllIIllllIllll, final boolean lllllllllllIlIIIIIlllIIllllIlllI) {
        if (lllllllllllIlIIIIIlllIIlllllIIIl != GlStateManager.colorMaskState.red || lllllllllllIlIIIIIlllIIlllllIlII != GlStateManager.colorMaskState.green || lllllllllllIlIIIIIlllIIllllIllll != GlStateManager.colorMaskState.blue || lllllllllllIlIIIIIlllIIllllIlllI != GlStateManager.colorMaskState.alpha) {
            GlStateManager.colorMaskState.red = lllllllllllIlIIIIIlllIIlllllIIIl;
            GlStateManager.colorMaskState.green = lllllllllllIlIIIIIlllIIlllllIlII;
            GlStateManager.colorMaskState.blue = lllllllllllIlIIIIIlllIIllllIllll;
            GlStateManager.colorMaskState.alpha = lllllllllllIlIIIIIlllIIllllIlllI;
            GL11.glColorMask(lllllllllllIlIIIIIlllIIlllllIIIl, lllllllllllIlIIIIIlllIIlllllIlII, lllllllllllIlIIIIIlllIIllllIllll, lllllllllllIlIIIIIlllIIllllIlllI);
        }
    }
    
    public static void scale(final float lllllllllllIlIIIIIlllIIllIlIlllI, final float lllllllllllIlIIIIIlllIIllIlIllIl, final float lllllllllllIlIIIIIlllIIllIlIllll) {
        GL11.glScalef(lllllllllllIlIIIIIlllIIllIlIlllI, lllllllllllIlIIIIIlllIIllIlIllIl, lllllllllllIlIIIIIlllIIllIlIllll);
    }
    
    public static void glNewList(final int lllllllllllIlIIIIIlllIIIllIlIlII, final int lllllllllllIlIIIIIlllIIIllIlIIll) {
        GL11.glNewList(lllllllllllIlIIIIIlllIIIllIlIlII, lllllllllllIlIIIIIlllIIIllIlIIll);
    }
    
    public static void disableColorLogic() {
        GlStateManager.colorLogicState.colorLogicOp.setDisabled();
    }
    
    public static void deleteTextures(final IntBuffer lllllllllllIlIIIIIlllIIIlIIlIIlI) {
        lllllllllllIlIIIIIlllIIIlIIlIIlI.rewind();
        while (lllllllllllIlIIIIIlllIIIlIIlIIlI.position() < lllllllllllIlIIIIIlllIIIlIIlIIlI.limit()) {
            final int lllllllllllIlIIIIIlllIIIlIIlIIIl = lllllllllllIlIIIIIlllIIIlIIlIIlI.get();
            deleteTexture(lllllllllllIlIIIIIlllIIIlIIlIIIl);
        }
        lllllllllllIlIIIIIlllIIIlIIlIIlI.rewind();
    }
    
    public static void getBlendState(final GlBlendState lllllllllllIlIIIIIlllIIIlIIIlIlI) {
        lllllllllllIlIIIIIlllIIIlIIIlIlI.enabled = GlStateManager.blendState.blend.currentState;
        lllllllllllIlIIIIIlllIIIlIIIlIlI.srcFactor = GlStateManager.blendState.srcFactor;
        lllllllllllIlIIIIIlllIIIlIIIlIlI.dstFactor = GlStateManager.blendState.dstFactor;
    }
    
    public static void getFloat(final int lllllllllllIlIIIIIlllIIlllIlIllI, final FloatBuffer lllllllllllIlIIIIIlllIIlllIlIIll) {
        GL11.glGetFloat(lllllllllllIlIIIIIlllIIlllIlIllI, lllllllllllIlIIIIIlllIIlllIlIIll);
    }
    
    public static void texGen(final TexGen lllllllllllIlIIIIIlllIlIlIllIllI, final int lllllllllllIlIIIIIlllIlIlIllIIlI, final FloatBuffer lllllllllllIlIIIIIlllIlIlIllIIIl) {
        GL11.glTexGen(texGenCoord(lllllllllllIlIIIIIlllIlIlIllIllI).coord, lllllllllllIlIIIIIlllIlIlIllIIlI, lllllllllllIlIIIIIlllIlIlIllIIIl);
    }
    
    public static void disableBlend() {
        GlStateManager.blendState.blend.setDisabled();
    }
    
    public static FloatBuffer quatToGlMatrix(final FloatBuffer lllllllllllIlIIIIIlllIIlIlllIlII, final Quaternion lllllllllllIlIIIIIlllIIlIllllllI) {
        lllllllllllIlIIIIIlllIIlIlllIlII.clear();
        final float lllllllllllIlIIIIIlllIIlIlllllIl = lllllllllllIlIIIIIlllIIlIllllllI.x * lllllllllllIlIIIIIlllIIlIllllllI.x;
        final float lllllllllllIlIIIIIlllIIlIlllllII = lllllllllllIlIIIIIlllIIlIllllllI.x * lllllllllllIlIIIIIlllIIlIllllllI.y;
        final float lllllllllllIlIIIIIlllIIlIllllIll = lllllllllllIlIIIIIlllIIlIllllllI.x * lllllllllllIlIIIIIlllIIlIllllllI.z;
        final float lllllllllllIlIIIIIlllIIlIllllIlI = lllllllllllIlIIIIIlllIIlIllllllI.x * lllllllllllIlIIIIIlllIIlIllllllI.w;
        final float lllllllllllIlIIIIIlllIIlIllllIIl = lllllllllllIlIIIIIlllIIlIllllllI.y * lllllllllllIlIIIIIlllIIlIllllllI.y;
        final float lllllllllllIlIIIIIlllIIlIllllIII = lllllllllllIlIIIIIlllIIlIllllllI.y * lllllllllllIlIIIIIlllIIlIllllllI.z;
        final float lllllllllllIlIIIIIlllIIlIlllIlll = lllllllllllIlIIIIIlllIIlIllllllI.y * lllllllllllIlIIIIIlllIIlIllllllI.w;
        final float lllllllllllIlIIIIIlllIIlIlllIllI = lllllllllllIlIIIIIlllIIlIllllllI.z * lllllllllllIlIIIIIlllIIlIllllllI.z;
        final float lllllllllllIlIIIIIlllIIlIlllIlIl = lllllllllllIlIIIIIlllIIlIllllllI.z * lllllllllllIlIIIIIlllIIlIllllllI.w;
        lllllllllllIlIIIIIlllIIlIlllIlII.put(1.0f - 2.0f * (lllllllllllIlIIIIIlllIIlIllllIIl + lllllllllllIlIIIIIlllIIlIlllIllI));
        lllllllllllIlIIIIIlllIIlIlllIlII.put(2.0f * (lllllllllllIlIIIIIlllIIlIlllllII + lllllllllllIlIIIIIlllIIlIlllIlIl));
        lllllllllllIlIIIIIlllIIlIlllIlII.put(2.0f * (lllllllllllIlIIIIIlllIIlIllllIll - lllllllllllIlIIIIIlllIIlIlllIlll));
        lllllllllllIlIIIIIlllIIlIlllIlII.put(0.0f);
        lllllllllllIlIIIIIlllIIlIlllIlII.put(2.0f * (lllllllllllIlIIIIIlllIIlIlllllII - lllllllllllIlIIIIIlllIIlIlllIlIl));
        lllllllllllIlIIIIIlllIIlIlllIlII.put(1.0f - 2.0f * (lllllllllllIlIIIIIlllIIlIlllllIl + lllllllllllIlIIIIIlllIIlIlllIllI));
        lllllllllllIlIIIIIlllIIlIlllIlII.put(2.0f * (lllllllllllIlIIIIIlllIIlIllllIII + lllllllllllIlIIIIIlllIIlIllllIlI));
        lllllllllllIlIIIIIlllIIlIlllIlII.put(0.0f);
        lllllllllllIlIIIIIlllIIlIlllIlII.put(2.0f * (lllllllllllIlIIIIIlllIIlIllllIll + lllllllllllIlIIIIIlllIIlIlllIlll));
        lllllllllllIlIIIIIlllIIlIlllIlII.put(2.0f * (lllllllllllIlIIIIIlllIIlIllllIII - lllllllllllIlIIIIIlllIIlIllllIlI));
        lllllllllllIlIIIIIlllIIlIlllIlII.put(1.0f - 2.0f * (lllllllllllIlIIIIIlllIIlIlllllIl + lllllllllllIlIIIIIlllIIlIllllIIl));
        lllllllllllIlIIIIIlllIIlIlllIlII.put(0.0f);
        lllllllllllIlIIIIIlllIIlIlllIlII.put(0.0f);
        lllllllllllIlIIIIIlllIIlIlllIlII.put(0.0f);
        lllllllllllIlIIIIIlllIIlIlllIlII.put(0.0f);
        lllllllllllIlIIIIIlllIIlIlllIlII.put(1.0f);
        lllllllllllIlIIIIIlllIIlIlllIlII.rewind();
        return lllllllllllIlIIIIIlllIIlIlllIlII;
    }
    
    public static void alphaFunc(final int lllllllllllIlIIIIIlllIllIllIIIII, final float lllllllllllIlIIIIIlllIllIlIlllll) {
        if (lllllllllllIlIIIIIlllIllIllIIIII != GlStateManager.alphaState.func || lllllllllllIlIIIIIlllIllIlIlllll != GlStateManager.alphaState.ref) {
            GlStateManager.alphaState.func = lllllllllllIlIIIIIlllIllIllIIIII;
            GlStateManager.alphaState.ref = lllllllllllIlIIIIIlllIllIlIlllll;
            GL11.glAlphaFunc(lllllllllllIlIIIIIlllIllIllIIIII, lllllllllllIlIIIIIlllIllIlIlllll);
        }
    }
    
    public static void glLight(final int lllllllllllIlIIIIIlllIllIlIIIIII, final int lllllllllllIlIIIIIlllIllIIllllII, final FloatBuffer lllllllllllIlIIIIIlllIllIIlllllI) {
        GL11.glLight(lllllllllllIlIIIIIlllIllIlIIIIII, lllllllllllIlIIIIIlllIllIIllllII, lllllllllllIlIIIIIlllIllIIlllllI);
    }
    
    public static void glVertex3f(final float lllllllllllIlIIIIIlllIIlIlIIlIII, final float lllllllllllIlIIIIIlllIIlIlIIIlll, final float lllllllllllIlIIIIIlllIIlIlIIIllI) {
        GL11.glVertex3f(lllllllllllIlIIIIIlllIIlIlIIlIII, lllllllllllIlIIIIIlllIIlIlIIIlll, lllllllllllIlIIIIIlllIIlIlIIIllI);
    }
    
    public static void ortho(final double lllllllllllIlIIIIIlllIIlllIIIllI, final double lllllllllllIlIIIIIlllIIlllIIlIll, final double lllllllllllIlIIIIIlllIIlllIIIlII, final double lllllllllllIlIIIIIlllIIlllIIIIll, final double lllllllllllIlIIIIIlllIIlllIIIIlI, final double lllllllllllIlIIIIIlllIIlllIIIlll) {
        GL11.glOrtho(lllllllllllIlIIIIIlllIIlllIIIllI, lllllllllllIlIIIIIlllIIlllIIlIll, lllllllllllIlIIIIIlllIIlllIIIlII, lllllllllllIlIIIIIlllIIlllIIIIll, lllllllllllIlIIIIIlllIIlllIIIIlI, lllllllllllIlIIIIIlllIIlllIIIlll);
    }
    
    public static void enableColorLogic() {
        GlStateManager.colorLogicState.colorLogicOp.setEnabled();
    }
    
    public static void glTexCoordPointer(final int lllllllllllIlIIIIIlllIIlIIlIlIII, final int lllllllllllIlIIIIIlllIIlIIlIIlll, final int lllllllllllIlIIIIIlllIIlIIlIlIlI, final ByteBuffer lllllllllllIlIIIIIlllIIlIIlIIlIl) {
        GL11.glTexCoordPointer(lllllllllllIlIIIIIlllIIlIIlIlIII, lllllllllllIlIIIIIlllIIlIIlIIlll, lllllllllllIlIIIIIlllIIlIIlIlIlI, lllllllllllIlIIIIIlllIIlIIlIIlIl);
    }
    
    public static void glVertexPointer(final int lllllllllllIlIIIIIlllIIlIIIlllII, final int lllllllllllIlIIIIIlllIIlIIIlllll, final int lllllllllllIlIIIIIlllIIlIIIllllI, final int lllllllllllIlIIIIIlllIIlIIIlllIl) {
        GL11.glVertexPointer(lllllllllllIlIIIIIlllIIlIIIlllII, lllllllllllIlIIIIIlllIIlIIIlllll, lllllllllllIlIIIIIlllIIlIIIllllI, (long)lllllllllllIlIIIIIlllIIlIIIlllIl);
    }
    
    public static void color(final float lllllllllllIlIIIIIlllIIlIllIIIIl, final float lllllllllllIlIIIIIlllIIlIllIIIII, final float lllllllllllIlIIIIIlllIIlIlIlllll, final float lllllllllllIlIIIIIlllIIlIlIllllI) {
        if (lllllllllllIlIIIIIlllIIlIllIIIIl != GlStateManager.colorState.red || lllllllllllIlIIIIIlllIIlIllIIIII != GlStateManager.colorState.green || lllllllllllIlIIIIIlllIIlIlIlllll != GlStateManager.colorState.blue || lllllllllllIlIIIIIlllIIlIlIllllI != GlStateManager.colorState.alpha) {
            GlStateManager.colorState.red = lllllllllllIlIIIIIlllIIlIllIIIIl;
            GlStateManager.colorState.green = lllllllllllIlIIIIIlllIIlIllIIIII;
            GlStateManager.colorState.blue = lllllllllllIlIIIIIlllIIlIlIlllll;
            GlStateManager.colorState.alpha = lllllllllllIlIIIIIlllIIlIlIllllI;
            GL11.glColor4f(lllllllllllIlIIIIIlllIIlIllIIIIl, lllllllllllIlIIIIIlllIIlIllIIIII, lllllllllllIlIIIIIlllIIlIlIlllll, lllllllllllIlIIIIIlllIIlIlIllllI);
        }
    }
    
    public static void enableRescaleNormal() {
        GlStateManager.rescaleNormalState.setEnabled();
    }
    
    public static void clearDepth(final double lllllllllllIlIIIIIlllIIllllIllII) {
        if (lllllllllllIlIIIIIlllIIllllIllII != GlStateManager.clearState.depth) {
            GlStateManager.clearState.depth = lllllllllllIlIIIIIlllIIllllIllII;
            GL11.glClearDepth(lllllllllllIlIIIIIlllIIllllIllII);
        }
    }
    
    public static void colorLogicOp(final int lllllllllllIlIIIIIlllIlIllIIlIIl) {
        if (lllllllllllIlIIIIIlllIlIllIIlIIl != GlStateManager.colorLogicState.opcode) {
            GlStateManager.colorLogicState.opcode = lllllllllllIlIIIIIlllIlIllIIlIIl;
            GL11.glLogicOp(lllllllllllIlIIIIIlllIlIllIIlIIl);
        }
    }
    
    public static void colorMaterial(final int lllllllllllIlIIIIIlllIllIlIIIlll, final int lllllllllllIlIIIIIlllIllIlIIIlII) {
        if (lllllllllllIlIIIIIlllIllIlIIIlll != GlStateManager.colorMaterialState.face || lllllllllllIlIIIIIlllIllIlIIIlII != GlStateManager.colorMaterialState.mode) {
            GlStateManager.colorMaterialState.face = lllllllllllIlIIIIIlllIllIlIIIlll;
            GlStateManager.colorMaterialState.mode = lllllllllllIlIIIIIlllIllIlIIIlII;
            GL11.glColorMaterial(lllllllllllIlIIIIIlllIllIlIIIlll, lllllllllllIlIIIIIlllIllIlIIIlII);
        }
    }
    
    public static void disableOutlineMode() {
        glTexEnvi(8960, 8704, 8448);
        glTexEnvi(8960, 34161, 8448);
        glTexEnvi(8960, 34162, 8448);
        glTexEnvi(8960, 34176, 5890);
        glTexEnvi(8960, 34184, 5890);
        glTexEnvi(8960, 34192, 768);
        glTexEnvi(8960, 34200, 770);
    }
    
    public static void rotate(final Quaternion lllllllllllIlIIIIIlllIIllIIIlIll) {
        multMatrix(quatToGlMatrix(GlStateManager.BUF_FLOAT_16, lllllllllllIlIIIIIlllIIllIIIlIll));
    }
    
    public static void disableFog() {
        GlStateManager.fogState.fog.setDisabled();
    }
    
    public static void glColorPointer(final int lllllllllllIlIIIIIlllIIlIIIIIlII, final int lllllllllllIlIIIIIlllIIlIIIIIlll, final int lllllllllllIlIIIIIlllIIlIIIIIllI, final int lllllllllllIlIIIIIlllIIlIIIIIIIl) {
        GL11.glColorPointer(lllllllllllIlIIIIIlllIIlIIIIIlII, lllllllllllIlIIIIIlllIIlIIIIIlll, lllllllllllIlIIIIIlllIIlIIIIIllI, (long)lllllllllllIlIIIIIlllIIlIIIIIIIl);
    }
    
    public static void glTexImage2D(final int lllllllllllIlIIIIIlllIlIIlIlllII, final int lllllllllllIlIIIIIlllIlIIlIllIll, final int lllllllllllIlIIIIIlllIlIIlIllIlI, final int lllllllllllIlIIIIIlllIlIIlIlIIII, final int lllllllllllIlIIIIIlllIlIIlIIllll, final int lllllllllllIlIIIIIlllIlIIlIIlllI, final int lllllllllllIlIIIIIlllIlIIlIIllIl, final int lllllllllllIlIIIIIlllIlIIlIlIlIl, @Nullable final IntBuffer lllllllllllIlIIIIIlllIlIIlIIlIll) {
        GL11.glTexImage2D(lllllllllllIlIIIIIlllIlIIlIlllII, lllllllllllIlIIIIIlllIlIIlIllIll, lllllllllllIlIIIIIlllIlIIlIllIlI, lllllllllllIlIIIIIlllIlIIlIlIIII, lllllllllllIlIIIIIlllIlIIlIIllll, lllllllllllIlIIIIIlllIlIIlIIlllI, lllllllllllIlIIIIIlllIlIIlIIllIl, lllllllllllIlIIIIIlllIlIIlIlIlIl, lllllllllllIlIIIIIlllIlIIlIIlIll);
    }
    
    public static void bindCurrentTexture() {
        final int n = 3553;
        final TextureState textureState = GlStateManager.textureState[GlStateManager.activeTextureUnit];
        GL11.glBindTexture(n, TextureState.textureName);
    }
    
    public static void tryBlendFuncSeparate(final int lllllllllllIlIIIIIlllIllIIIIIlIl, final int lllllllllllIlIIIIIlllIllIIIIlIII, final int lllllllllllIlIIIIIlllIllIIIIIIll, final int lllllllllllIlIIIIIlllIllIIIIIIlI) {
        if (lllllllllllIlIIIIIlllIllIIIIIlIl != GlStateManager.blendState.srcFactor || lllllllllllIlIIIIIlllIllIIIIlIII != GlStateManager.blendState.dstFactor || lllllllllllIlIIIIIlllIllIIIIIIll != GlStateManager.blendState.srcFactorAlpha || lllllllllllIlIIIIIlllIllIIIIIIlI != GlStateManager.blendState.dstFactorAlpha) {
            GlStateManager.blendState.srcFactor = lllllllllllIlIIIIIlllIllIIIIIlIl;
            GlStateManager.blendState.dstFactor = lllllllllllIlIIIIIlllIllIIIIlIII;
            GlStateManager.blendState.srcFactorAlpha = lllllllllllIlIIIIIlllIllIIIIIIll;
            GlStateManager.blendState.dstFactorAlpha = lllllllllllIlIIIIIlllIllIIIIIIlI;
            OpenGlHelper.glBlendFunc(lllllllllllIlIIIIIlllIllIIIIIlIl, lllllllllllIlIIIIIlllIllIIIIlIII, lllllllllllIlIIIIIlllIllIIIIIIll, lllllllllllIlIIIIIlllIllIIIIIIlI);
        }
    }
    
    public static void setBlendState(final GlBlendState lllllllllllIlIIIIIlllIIIlIIIIlll) {
        GlStateManager.blendState.blend.setState(lllllllllllIlIIIIIlllIIIlIIIIlll.enabled);
        blendFunc(lllllllllllIlIIIIIlllIIIlIIIIlll.srcFactor, lllllllllllIlIIIIIlllIIIlIIIIlll.dstFactor);
    }
    
    public static int glGetInteger(final int lllllllllllIlIIIIIlllIIIlIlIIlll) {
        return GL11.glGetInteger(lllllllllllIlIIIIIlllIIIlIlIIlll);
    }
    
    public static void glPolygonMode(final int lllllllllllIlIIIIIlllIlIllIlIllI, final int lllllllllllIlIIIIIlllIlIllIlIlll) {
        GL11.glPolygonMode(lllllllllllIlIIIIIlllIlIllIlIllI, lllllllllllIlIIIIIlllIlIllIlIlll);
    }
    
    public static int generateTexture() {
        return GL11.glGenTextures();
    }
    
    public static void shadeModel(final int lllllllllllIlIIIIIlllIlIIIIIIllI) {
        if (lllllllllllIlIIIIIlllIlIIIIIIllI != GlStateManager.activeShadeModel) {
            GL11.glShadeModel(GlStateManager.activeShadeModel = lllllllllllIlIIIIIlllIlIIIIIIllI);
        }
    }
    
    public static void glBegin(final int lllllllllllIlIIIIIlllIIIlllIllII) {
        GL11.glBegin(lllllllllllIlIIIIIlllIIIlllIllII);
    }
    
    public static void blendFunc(final int lllllllllllIlIIIIIlllIllIIIlllIl, final int lllllllllllIlIIIIIlllIllIIIlllII) {
        if (lllllllllllIlIIIIIlllIllIIIlllIl != GlStateManager.blendState.srcFactor || lllllllllllIlIIIIIlllIllIIIlllII != GlStateManager.blendState.dstFactor) {
            GlStateManager.blendState.srcFactor = lllllllllllIlIIIIIlllIllIIIlllIl;
            GlStateManager.blendState.dstFactor = lllllllllllIlIIIIIlllIllIIIlllII;
            GL11.glBlendFunc(lllllllllllIlIIIIIlllIllIIIlllIl, lllllllllllIlIIIIIlllIllIIIlllII);
        }
    }
    
    public static void disableLight(final int lllllllllllIlIIIIIlllIllIlIIlIll) {
        GlStateManager.lightState[lllllllllllIlIIIIIlllIllIlIIlIll].setDisabled();
    }
    
    public static void glTexParameteri(final int lllllllllllIlIIIIIlllIlIlIIIIIll, final int lllllllllllIlIIIIIlllIlIlIIIIIlI, final int lllllllllllIlIIIIIlllIlIIllllllI) {
        GL11.glTexParameteri(lllllllllllIlIIIIIlllIlIlIIIIIll, lllllllllllIlIIIIIlllIlIlIIIIIlI, lllllllllllIlIIIIIlllIlIIllllllI);
    }
    
    public static void disableLighting() {
        GlStateManager.lightingState.setDisabled();
    }
    
    public static void tryBlendFuncSeparate(final SourceFactor lllllllllllIlIIIIIlllIllIIIlIlIl, final DestFactor lllllllllllIlIIIIIlllIllIIIlIlII, final SourceFactor lllllllllllIlIIIIIlllIllIIIlIIll, final DestFactor lllllllllllIlIIIIIlllIllIIIlIIlI) {
        tryBlendFuncSeparate(lllllllllllIlIIIIIlllIllIIIlIlIl.factor, lllllllllllIlIIIIIlllIllIIIlIlII.factor, lllllllllllIlIIIIIlllIllIIIlIIll.factor, lllllllllllIlIIIIIlllIllIIIlIIlI.factor);
    }
    
    public static void colorLogicOp(final LogicOp lllllllllllIlIIIIIlllIlIllIIllII) {
        colorLogicOp(lllllllllllIlIIIIIlllIlIllIIllII.opcode);
    }
    
    public static void depthMask(final boolean lllllllllllIlIIIIIlllIllIIlIIllI) {
        if (lllllllllllIlIIIIIlllIllIIlIIllI != GlStateManager.depthState.maskEnabled) {
            GlStateManager.depthState.maskEnabled = lllllllllllIlIIIIIlllIllIIlIIllI;
            GL11.glDepthMask(lllllllllllIlIIIIIlllIllIIlIIllI);
        }
    }
    
    public static void setFogStart(final float lllllllllllIlIIIIIlllIlIllllIIIl) {
        if (lllllllllllIlIIIIIlllIlIllllIIIl != GlStateManager.fogState.start) {
            GlStateManager.fogState.start = lllllllllllIlIIIIIlllIlIllllIIIl;
            GL11.glFogf(2915, lllllllllllIlIIIIIlllIlIllllIIIl);
        }
    }
    
    public static void glTexParameterf(final int lllllllllllIlIIIIIlllIlIlIIIllII, final int lllllllllllIlIIIIIlllIlIlIIIlIll, final float lllllllllllIlIIIIIlllIlIlIIIlIlI) {
        GL11.glTexParameterf(lllllllllllIlIIIIIlllIlIlIIIllII, lllllllllllIlIIIIIlllIlIlIIIlIll, lllllllllllIlIIIIIlllIlIlIIIlIlI);
    }
    
    public static void disable(final int lllllllllllIlIIIIIlllIllIlIlIIII) {
        GL11.glDisable(lllllllllllIlIIIIIlllIllIlIlIIII);
    }
    
    public static void enableCull() {
        GlStateManager.cullState.cullFace.setEnabled();
    }
    
    public static String glGetString(final int lllllllllllIlIIIIIlllIIIlIllIIII) {
        return GL11.glGetString(lllllllllllIlIIIIIlllIIIlIllIIII);
    }
    
    public static void glNormalPointer(final int lllllllllllIlIIIIIlllIIlIlIIIIlI, final int lllllllllllIlIIIIIlllIIlIlIIIIIl, final ByteBuffer lllllllllllIlIIIIIlllIIlIIllllIl) {
        GL11.glNormalPointer(lllllllllllIlIIIIIlllIIlIlIIIIlI, lllllllllllIlIIIIIlllIIlIlIIIIIl, lllllllllllIlIIIIIlllIIlIIllllIl);
    }
    
    public static void glVertex3d(final double lllllllllllIlIIIIIlllIllIlIllIII, final double lllllllllllIlIIIIIlllIllIlIlIlll, final double lllllllllllIlIIIIIlllIllIlIlIIll) {
        GL11.glVertex3d(lllllllllllIlIIIIIlllIllIlIllIII, lllllllllllIlIIIIIlllIllIlIlIlll, lllllllllllIlIIIIIlllIllIlIlIIll);
    }
    
    static {
        BUF_FLOAT_16 = BufferUtils.createFloatBuffer(16);
        BUF_FLOAT_4 = BufferUtils.createFloatBuffer(4);
        alphaState = new AlphaState(null);
        lightingState = new BooleanState(2896);
        lightState = new BooleanState[8];
        GlStateManager.clearEnabled = true;
        for (int lllllllllllIlIIIIIlllIllIllIlIlI = 0; lllllllllllIlIIIIIlllIllIllIlIlI < 8; ++lllllllllllIlIIIIIlllIllIllIlIlI) {
            GlStateManager.lightState[lllllllllllIlIIIIIlllIllIllIlIlI] = new BooleanState(16384 + lllllllllllIlIIIIIlllIllIllIlIlI);
        }
        colorMaterialState = new ColorMaterialState(null);
        blendState = new BlendState(null);
        depthState = new DepthState(null);
        fogState = new FogState(null);
        cullState = new CullState(null);
        polygonOffsetState = new PolygonOffsetState(null);
        colorLogicState = new ColorLogicState(null);
        texGenState = new TexGenState(null);
        clearState = new ClearState(null);
        stencilState = new StencilState(null);
        normalizeState = new BooleanState(2977);
        textureState = new TextureState[32];
        for (int lllllllllllIlIIIIIlllIllIllIlIIl = 0; lllllllllllIlIIIIIlllIllIllIlIIl < GlStateManager.textureState.length; ++lllllllllllIlIIIIIlllIllIllIlIIl) {
            GlStateManager.textureState[lllllllllllIlIIIIIlllIllIllIlIIl] = new TextureState(null);
        }
        GlStateManager.activeShadeModel = 7425;
        rescaleNormalState = new BooleanState(32826);
        colorMaskState = new ColorMask(null);
        colorState = new Color();
    }
    
    public static void glTexEnvf(final int lllllllllllIlIIIIIlllIlIlIIlIIlI, final int lllllllllllIlIIIIIlllIlIlIIlIlII, final float lllllllllllIlIIIIIlllIlIlIIlIIll) {
        GL11.glTexEnvf(lllllllllllIlIIIIIlllIlIlIIlIIlI, lllllllllllIlIIIIIlllIlIlIIlIlII, lllllllllllIlIIIIIlllIlIlIIlIIll);
    }
    
    static class FogState
    {
        public /* synthetic */ float density;
        public /* synthetic */ int mode;
        public /* synthetic */ float start;
        public /* synthetic */ BooleanState fog;
        public /* synthetic */ float end;
        
        private FogState() {
            this.fog = new BooleanState(2912);
            this.mode = 2048;
            this.density = 1.0f;
            this.end = 1.0f;
        }
    }
    
    static class BooleanState
    {
        private /* synthetic */ boolean currentState;
        private final /* synthetic */ int capability;
        
        public void setDisabled() {
            this.setState(false);
        }
        
        public void setEnabled() {
            this.setState(true);
        }
        
        public BooleanState(final int lllllllllllIlIIlllllIlIlIlIlllIl) {
            this.capability = lllllllllllIlIIlllllIlIlIlIlllIl;
        }
        
        public void setState(final boolean lllllllllllIlIIlllllIlIlIlIlIIIl) {
            if (lllllllllllIlIIlllllIlIlIlIlIIIl != this.currentState) {
                this.currentState = lllllllllllIlIIlllllIlIlIlIlIIIl;
                if (lllllllllllIlIIlllllIlIlIlIlIIIl) {
                    GL11.glEnable(this.capability);
                }
                else {
                    GL11.glDisable(this.capability);
                }
            }
        }
    }
    
    public enum LogicOp
    {
        XOR("XOR", 15, 5382);
        
        public final /* synthetic */ int opcode;
        
        OR_REVERSE("OR_REVERSE", 13, 5387), 
        OR("OR", 11, 5383), 
        AND_INVERTED("AND_INVERTED", 1, 5380), 
        CLEAR("CLEAR", 3, 5376), 
        COPY("COPY", 4, 5379), 
        NAND("NAND", 8, 5390), 
        OR_INVERTED("OR_INVERTED", 12, 5389), 
        SET("SET", 14, 5391), 
        NOR("NOR", 10, 5384), 
        NOOP("NOOP", 9, 5381), 
        COPY_INVERTED("COPY_INVERTED", 5, 5388), 
        AND("AND", 0, 5377), 
        AND_REVERSE("AND_REVERSE", 2, 5378), 
        INVERT("INVERT", 7, 5386), 
        EQUIV("EQUIV", 6, 5385);
        
        private LogicOp(final String lllllllllllIIllllllIIIllIlIIIIlI, final int lllllllllllIIllllllIIIllIlIIIIIl, final int lllllllllllIIllllllIIIllIlIIIIII) {
            this.opcode = lllllllllllIIllllllIIIllIlIIIIII;
        }
    }
    
    public enum TexGen
    {
        Q("Q", 3), 
        S("S", 0), 
        T("T", 1), 
        R("R", 2);
        
        private TexGen(final String lllllllllllIIlIIlIlIllIlIlllllII, final int lllllllllllIIlIIlIlIllIlIllllIll) {
        }
    }
    
    public enum Profile
    {
        DEFAULT(0) {
            @Override
            public void clean() {
            }
            
            @Override
            public void apply() {
                GlStateManager.disableAlpha();
                GlStateManager.alphaFunc(519, 0.0f);
                GlStateManager.disableLighting();
                GL11.glLightModel(2899, RenderHelper.setColorBuffer(0.2f, 0.2f, 0.2f, 1.0f));
                for (int lllllllllllIllIIllIllIIllIIIlIIl = 0; lllllllllllIllIIllIllIIllIIIlIIl < 8; ++lllllllllllIllIIllIllIIllIIIlIIl) {
                    GlStateManager.disableLight(lllllllllllIllIIllIllIIllIIIlIIl);
                    GL11.glLight(16384 + lllllllllllIllIIllIllIIllIIIlIIl, 4608, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                    GL11.glLight(16384 + lllllllllllIllIIllIllIIllIIIlIIl, 4611, RenderHelper.setColorBuffer(0.0f, 0.0f, 1.0f, 0.0f));
                    if (lllllllllllIllIIllIllIIllIIIlIIl == 0) {
                        GL11.glLight(16384 + lllllllllllIllIIllIllIIllIIIlIIl, 4609, RenderHelper.setColorBuffer(1.0f, 1.0f, 1.0f, 1.0f));
                        GL11.glLight(16384 + lllllllllllIllIIllIllIIllIIIlIIl, 4610, RenderHelper.setColorBuffer(1.0f, 1.0f, 1.0f, 1.0f));
                    }
                    else {
                        GL11.glLight(16384 + lllllllllllIllIIllIllIIllIIIlIIl, 4609, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                        GL11.glLight(16384 + lllllllllllIllIIllIllIIllIIIlIIl, 4610, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                    }
                }
                GlStateManager.disableColorMaterial();
                GlStateManager.colorMaterial(1032, 5634);
                GlStateManager.disableDepth();
                GlStateManager.depthFunc(513);
                GlStateManager.depthMask(true);
                GlStateManager.disableBlend();
                GlStateManager.blendFunc(SourceFactor.ONE, DestFactor.ZERO);
                GlStateManager.tryBlendFuncSeparate(SourceFactor.ONE, DestFactor.ZERO, SourceFactor.ONE, DestFactor.ZERO);
                GL14.glBlendEquation(32774);
                GlStateManager.disableFog();
                GL11.glFogi(2917, 2048);
                GlStateManager.setFogDensity(1.0f);
                GlStateManager.setFogStart(0.0f);
                GlStateManager.setFogEnd(1.0f);
                GL11.glFog(2918, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                if (GLContext.getCapabilities().GL_NV_fog_distance) {
                    GL11.glFogi(2917, 34140);
                }
                GlStateManager.doPolygonOffset(0.0f, 0.0f);
                GlStateManager.disableColorLogic();
                GlStateManager.colorLogicOp(5379);
                GlStateManager.disableTexGenCoord(TexGen.S);
                GlStateManager.texGen(TexGen.S, 9216);
                GlStateManager.texGen(TexGen.S, 9474, RenderHelper.setColorBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.texGen(TexGen.S, 9217, RenderHelper.setColorBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.disableTexGenCoord(TexGen.T);
                GlStateManager.texGen(TexGen.T, 9216);
                GlStateManager.texGen(TexGen.T, 9474, RenderHelper.setColorBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GlStateManager.texGen(TexGen.T, 9217, RenderHelper.setColorBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GlStateManager.disableTexGenCoord(TexGen.R);
                GlStateManager.texGen(TexGen.R, 9216);
                GlStateManager.texGen(TexGen.R, 9474, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.texGen(TexGen.R, 9217, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.disableTexGenCoord(TexGen.Q);
                GlStateManager.texGen(TexGen.Q, 9216);
                GlStateManager.texGen(TexGen.Q, 9474, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.texGen(TexGen.Q, 9217, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.setActiveTexture(0);
                GL11.glTexParameteri(3553, 10240, 9729);
                GL11.glTexParameteri(3553, 10241, 9986);
                GL11.glTexParameteri(3553, 10242, 10497);
                GL11.glTexParameteri(3553, 10243, 10497);
                GL11.glTexParameteri(3553, 33085, 1000);
                GL11.glTexParameteri(3553, 33083, 1000);
                GL11.glTexParameteri(3553, 33082, -1000);
                GL11.glTexParameterf(3553, 34049, 0.0f);
                GL11.glTexEnvi(8960, 8704, 8448);
                GL11.glTexEnv(8960, 8705, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                GL11.glTexEnvi(8960, 34161, 8448);
                GL11.glTexEnvi(8960, 34162, 8448);
                GL11.glTexEnvi(8960, 34176, 5890);
                GL11.glTexEnvi(8960, 34177, 34168);
                GL11.glTexEnvi(8960, 34178, 34166);
                GL11.glTexEnvi(8960, 34184, 5890);
                GL11.glTexEnvi(8960, 34185, 34168);
                GL11.glTexEnvi(8960, 34186, 34166);
                GL11.glTexEnvi(8960, 34192, 768);
                GL11.glTexEnvi(8960, 34193, 768);
                GL11.glTexEnvi(8960, 34194, 770);
                GL11.glTexEnvi(8960, 34200, 770);
                GL11.glTexEnvi(8960, 34201, 770);
                GL11.glTexEnvi(8960, 34202, 770);
                GL11.glTexEnvf(8960, 34163, 1.0f);
                GL11.glTexEnvf(8960, 3356, 1.0f);
                GlStateManager.disableNormalize();
                GlStateManager.shadeModel(7425);
                GlStateManager.disableRescaleNormal();
                GlStateManager.colorMask(true, true, true, true);
                GlStateManager.clearDepth(1.0);
                GL11.glLineWidth(1.0f);
                GL11.glNormal3f(0.0f, 0.0f, 1.0f);
                GL11.glPolygonMode(1028, 6914);
                GL11.glPolygonMode(1029, 6914);
            }
        }, 
        PLAYER_SKIN(1) {
            @Override
            public void clean() {
                GlStateManager.disableBlend();
            }
            
            @Override
            public void apply() {
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            }
        }, 
        TRANSPARENT_MODEL(2) {
            @Override
            public void apply() {
                GlStateManager.color(1.0f, 1.0f, 1.0f, 0.15f);
                GlStateManager.depthMask(false);
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
                GlStateManager.alphaFunc(516, 0.003921569f);
            }
            
            @Override
            public void clean() {
                GlStateManager.disableBlend();
                GlStateManager.alphaFunc(516, 0.1f);
                GlStateManager.depthMask(true);
            }
        };
        
        private Profile(final String lllllllllllIlIllllIlllIIlIlllllI, final int lllllllllllIlIllllIlllIIlIllllIl) {
        }
        
        public abstract void apply();
        
        public abstract void clean();
    }
    
    public enum DestFactor
    {
        ONE_MINUS_DST_COLOR("ONE_MINUS_DST_COLOR", 8, 775), 
        ZERO("ZERO", 13, 0), 
        SRC_COLOR("SRC_COLOR", 12, 768), 
        ONE_MINUS_SRC_ALPHA("ONE_MINUS_SRC_ALPHA", 9, 771), 
        SRC_ALPHA("SRC_ALPHA", 11, 770), 
        ONE_MINUS_SRC_COLOR("ONE_MINUS_SRC_COLOR", 10, 769), 
        ONE_MINUS_CONSTANT_COLOR("ONE_MINUS_CONSTANT_COLOR", 6, 32770), 
        ONE_MINUS_CONSTANT_ALPHA("ONE_MINUS_CONSTANT_ALPHA", 5, 32772), 
        DST_COLOR("DST_COLOR", 3, 774), 
        ONE_MINUS_DST_ALPHA("ONE_MINUS_DST_ALPHA", 7, 773), 
        CONSTANT_COLOR("CONSTANT_COLOR", 1, 32769), 
        ONE("ONE", 4, 1), 
        CONSTANT_ALPHA("CONSTANT_ALPHA", 0, 32771);
        
        public final /* synthetic */ int factor;
        
        DST_ALPHA("DST_ALPHA", 2, 772);
        
        private DestFactor(final String lllllllllllIIlIlIIIIlIIlIlIlIIll, final int lllllllllllIIlIlIIIIlIIlIlIlIIlI, final int lllllllllllIIlIlIIIIlIIlIlIlIlIl) {
            this.factor = lllllllllllIIlIlIIIIlIIlIlIlIlIl;
        }
    }
    
    public enum SourceFactor
    {
        SRC_ALPHA_SATURATE("SRC_ALPHA_SATURATE", 12, 776), 
        CONSTANT_COLOR("CONSTANT_COLOR", 1, 32769), 
        DST_ALPHA("DST_ALPHA", 2, 772), 
        ONE_MINUS_DST_ALPHA("ONE_MINUS_DST_ALPHA", 7, 773), 
        ONE_MINUS_CONSTANT_ALPHA("ONE_MINUS_CONSTANT_ALPHA", 5, 32772), 
        DST_COLOR("DST_COLOR", 3, 774), 
        ONE_MINUS_SRC_ALPHA("ONE_MINUS_SRC_ALPHA", 9, 771), 
        ZERO("ZERO", 14, 0), 
        ONE_MINUS_SRC_COLOR("ONE_MINUS_SRC_COLOR", 10, 769), 
        ONE("ONE", 4, 1);
        
        public final /* synthetic */ int factor;
        
        CONSTANT_ALPHA("CONSTANT_ALPHA", 0, 32771), 
        SRC_ALPHA("SRC_ALPHA", 11, 770), 
        SRC_COLOR("SRC_COLOR", 13, 768), 
        ONE_MINUS_CONSTANT_COLOR("ONE_MINUS_CONSTANT_COLOR", 6, 32770), 
        ONE_MINUS_DST_COLOR("ONE_MINUS_DST_COLOR", 8, 775);
        
        private SourceFactor(final String lllllllllllIIIllIlIlIllIIIlIllll, final int lllllllllllIIIllIlIlIllIIIlIlllI, final int lllllllllllIIIllIlIlIllIIIlIllIl) {
            this.factor = lllllllllllIIIllIlIlIllIIIlIllIl;
        }
    }
    
    static class ColorMask
    {
        public /* synthetic */ boolean blue;
        public /* synthetic */ boolean alpha;
        public /* synthetic */ boolean red;
        public /* synthetic */ boolean green;
        
        private ColorMask() {
            this.red = true;
            this.green = true;
            this.blue = true;
            this.alpha = true;
        }
    }
    
    static class CullState
    {
        public /* synthetic */ int mode;
        public /* synthetic */ BooleanState cullFace;
        
        private CullState() {
            this.cullFace = new BooleanState(2884);
            this.mode = 1029;
        }
    }
    
    public enum FogMode
    {
        LINEAR("LINEAR", 0, 9729), 
        EXP("EXP", 1, 2048);
        
        public final /* synthetic */ int capabilityId;
        
        EXP2("EXP2", 2, 2049);
        
        private FogMode(final String lllllllllllIlIIllIlIIllIIIlIIIII, final int lllllllllllIlIIllIlIIllIIIIlllll, final int lllllllllllIlIIllIlIIllIIIlIIIlI) {
            this.capabilityId = lllllllllllIlIIllIlIIllIIIlIIIlI;
        }
    }
    
    static class AlphaState
    {
        public /* synthetic */ BooleanState alphaTest;
        public /* synthetic */ float ref;
        public /* synthetic */ int func;
        
        private AlphaState() {
            this.alphaTest = new BooleanState(3008);
            this.func = 519;
            this.ref = -1.0f;
        }
    }
    
    static class PolygonOffsetState
    {
        public /* synthetic */ BooleanState polygonOffsetLine;
        public /* synthetic */ BooleanState polygonOffsetFill;
        public /* synthetic */ float units;
        public /* synthetic */ float factor;
        
        private PolygonOffsetState() {
            this.polygonOffsetFill = new BooleanState(32823);
            this.polygonOffsetLine = new BooleanState(10754);
        }
    }
    
    static class ColorMaterialState
    {
        public /* synthetic */ int face;
        public /* synthetic */ int mode;
        public /* synthetic */ BooleanState colorMaterial;
        
        private ColorMaterialState() {
            this.colorMaterial = new BooleanState(2903);
            this.face = 1032;
            this.mode = 5634;
        }
    }
    
    static class Color
    {
        public /* synthetic */ float alpha;
        public /* synthetic */ float green;
        public /* synthetic */ float red;
        public /* synthetic */ float blue;
        
        public Color(final float lllllllllllIlIlllIIIlIIlIllIlIIl, final float lllllllllllIlIlllIIIlIIlIllIlIII, final float lllllllllllIlIlllIIIlIIlIllIllII, final float lllllllllllIlIlllIIIlIIlIllIIllI) {
            this.red = 1.0f;
            this.green = 1.0f;
            this.blue = 1.0f;
            this.alpha = 1.0f;
            this.red = lllllllllllIlIlllIIIlIIlIllIlIIl;
            this.green = lllllllllllIlIlllIIIlIIlIllIlIII;
            this.blue = lllllllllllIlIlllIIIlIIlIllIllII;
            this.alpha = lllllllllllIlIlllIIIlIIlIllIIllI;
        }
        
        public Color() {
            this(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    static class ClearState
    {
        public /* synthetic */ Color color;
        public /* synthetic */ double depth;
        
        private ClearState() {
            this.depth = 1.0;
            this.color = new Color(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
    
    static class DepthState
    {
        public /* synthetic */ int depthFunc;
        public /* synthetic */ BooleanState depthTest;
        public /* synthetic */ boolean maskEnabled;
        
        private DepthState() {
            this.depthTest = new BooleanState(2929);
            this.maskEnabled = true;
            this.depthFunc = 513;
        }
    }
    
    static class TexGenState
    {
        public /* synthetic */ TexGenCoord q;
        public /* synthetic */ TexGenCoord r;
        public /* synthetic */ TexGenCoord s;
        public /* synthetic */ TexGenCoord t;
        
        private TexGenState() {
            this.s = new TexGenCoord(8192, 3168);
            this.t = new TexGenCoord(8193, 3169);
            this.r = new TexGenCoord(8194, 3170);
            this.q = new TexGenCoord(8195, 3171);
        }
    }
    
    static class TexGenCoord
    {
        public /* synthetic */ BooleanState textureGen;
        public /* synthetic */ int coord;
        public /* synthetic */ int param;
        
        public TexGenCoord(final int lllllllllllIIllIllllIIlIIIIllIll, final int lllllllllllIIllIllllIIlIIIIlllIl) {
            this.param = -1;
            this.coord = lllllllllllIIllIllllIIlIIIIllIll;
            this.textureGen = new BooleanState(lllllllllllIIllIllllIIlIIIIlllIl);
        }
    }
    
    public enum CullFace
    {
        BACK("BACK", 1, 1029), 
        FRONT_AND_BACK("FRONT_AND_BACK", 2, 1032);
        
        public final /* synthetic */ int mode;
        
        FRONT("FRONT", 0, 1028);
        
        private CullFace(final String lllllllllllllIIlllIllIlllIlIIIIl, final int lllllllllllllIIlllIllIlllIlIIIII, final int lllllllllllllIIlllIllIlllIIlllll) {
            this.mode = lllllllllllllIIlllIllIlllIIlllll;
        }
    }
    
    static class ColorLogicState
    {
        public /* synthetic */ BooleanState colorLogicOp;
        public /* synthetic */ int opcode;
        
        private ColorLogicState() {
            this.colorLogicOp = new BooleanState(3058);
            this.opcode = 5379;
        }
    }
    
    static class StencilFunc
    {
        public /* synthetic */ int func;
        public /* synthetic */ int mask;
        
        private StencilFunc() {
            this.func = 519;
            this.mask = -1;
        }
    }
    
    static class BlendState
    {
        public /* synthetic */ int srcFactorAlpha;
        public /* synthetic */ int dstFactor;
        public /* synthetic */ int srcFactor;
        public /* synthetic */ BooleanState blend;
        public /* synthetic */ int dstFactorAlpha;
        
        private BlendState() {
            this.blend = new BooleanState(3042);
            this.srcFactor = 1;
            this.dstFactor = 0;
            this.srcFactorAlpha = 1;
            this.dstFactorAlpha = 0;
        }
    }
    
    public static class TextureState
    {
        public static /* synthetic */ int textureName;
        public /* synthetic */ BooleanState texture2DState;
        
        private TextureState() {
            this.texture2DState = new BooleanState(3553);
        }
    }
    
    static class StencilState
    {
        public /* synthetic */ StencilFunc func;
        public /* synthetic */ int zpass;
        public /* synthetic */ int fail;
        public /* synthetic */ int zfail;
        public /* synthetic */ int mask;
        
        private StencilState() {
            this.func = new StencilFunc(null);
            this.mask = -1;
            this.fail = 7680;
            this.zfail = 7680;
            this.zpass = 7680;
        }
    }
}
