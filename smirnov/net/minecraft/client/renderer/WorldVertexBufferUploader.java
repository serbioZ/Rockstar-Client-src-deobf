// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import java.util.List;
import java.nio.ByteBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import shadersmod.client.SVertexBuilder;
import optifine.Config;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import optifine.Reflector;

public class WorldVertexBufferUploader
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
    
    public void draw(final BufferBuilder llllllllllllllIllIlIlIlIllIllIlI) {
        if (llllllllllllllIllIlIlIlIllIllIlI.getVertexCount() > 0) {
            final VertexFormat llllllllllllllIllIlIlIlIllIllIIl = llllllllllllllIllIlIlIlIllIllIlI.getVertexFormat();
            final int llllllllllllllIllIlIlIlIllIllIII = llllllllllllllIllIlIlIlIllIllIIl.getNextOffset();
            final ByteBuffer llllllllllllllIllIlIlIlIllIlIlll = llllllllllllllIllIlIlIlIllIllIlI.getByteBuffer();
            final List<VertexFormatElement> llllllllllllllIllIlIlIlIllIlIllI = llllllllllllllIllIlIlIlIllIllIIl.getElements();
            final boolean llllllllllllllIllIlIlIlIllIlIlIl = Reflector.ForgeVertexFormatElementEnumUseage_preDraw.exists();
            final boolean llllllllllllllIllIlIlIlIllIlIlII = Reflector.ForgeVertexFormatElementEnumUseage_postDraw.exists();
            for (int llllllllllllllIllIlIlIlIllIlIIll = 0; llllllllllllllIllIlIlIlIllIlIIll < llllllllllllllIllIlIlIlIllIlIllI.size(); ++llllllllllllllIllIlIlIlIllIlIIll) {
                final VertexFormatElement llllllllllllllIllIlIlIlIllIlIIlI = llllllllllllllIllIlIlIlIllIlIllI.get(llllllllllllllIllIlIlIlIllIlIIll);
                final VertexFormatElement.EnumUsage llllllllllllllIllIlIlIlIllIlIIIl = llllllllllllllIllIlIlIlIllIlIIlI.getUsage();
                if (llllllllllllllIllIlIlIlIllIlIlIl) {
                    Reflector.callVoid((Object)llllllllllllllIllIlIlIlIllIlIIIl, Reflector.ForgeVertexFormatElementEnumUseage_preDraw, new Object[] { llllllllllllllIllIlIlIlIllIllIIl, llllllllllllllIllIlIlIlIllIlIIll, llllllllllllllIllIlIlIlIllIllIII, llllllllllllllIllIlIlIlIllIlIlll });
                }
                else {
                    final int llllllllllllllIllIlIlIlIllIlIIII = llllllllllllllIllIlIlIlIllIlIIlI.getType().getGlConstant();
                    final int llllllllllllllIllIlIlIlIllIIllll = llllllllllllllIllIlIlIlIllIlIIlI.getIndex();
                    llllllllllllllIllIlIlIlIllIlIlll.position(llllllllllllllIllIlIlIlIllIllIIl.getOffset(llllllllllllllIllIlIlIlIllIlIIll));
                    switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[llllllllllllllIllIlIlIlIllIlIIIl.ordinal()]) {
                        case 1: {
                            GlStateManager.glVertexPointer(llllllllllllllIllIlIlIlIllIlIIlI.getElementCount(), llllllllllllllIllIlIlIlIllIlIIII, llllllllllllllIllIlIlIlIllIllIII, llllllllllllllIllIlIlIlIllIlIlll);
                            GlStateManager.glEnableClientState(32884);
                            break;
                        }
                        case 4: {
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllllllIllIlIlIlIllIIllll);
                            GlStateManager.glTexCoordPointer(llllllllllllllIllIlIlIlIllIlIIlI.getElementCount(), llllllllllllllIllIlIlIlIllIlIIII, llllllllllllllIllIlIlIlIllIllIII, llllllllllllllIllIlIlIlIllIlIlll);
                            GlStateManager.glEnableClientState(32888);
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                            break;
                        }
                        case 3: {
                            GlStateManager.glColorPointer(llllllllllllllIllIlIlIlIllIlIIlI.getElementCount(), llllllllllllllIllIlIlIlIllIlIIII, llllllllllllllIllIlIlIlIllIllIII, llllllllllllllIllIlIlIlIllIlIlll);
                            GlStateManager.glEnableClientState(32886);
                            break;
                        }
                        case 2: {
                            GlStateManager.glNormalPointer(llllllllllllllIllIlIlIlIllIlIIII, llllllllllllllIllIlIlIlIllIllIII, llllllllllllllIllIlIlIlIllIlIlll);
                            GlStateManager.glEnableClientState(32885);
                            break;
                        }
                    }
                }
            }
            if (llllllllllllllIllIlIlIlIllIllIlI.isMultiTexture()) {
                llllllllllllllIllIlIlIlIllIllIlI.drawMultiTexture();
            }
            else if (Config.isShaders()) {
                SVertexBuilder.drawArrays(llllllllllllllIllIlIlIlIllIllIlI.getDrawMode(), 0, llllllllllllllIllIlIlIlIllIllIlI.getVertexCount(), llllllllllllllIllIlIlIlIllIllIlI);
            }
            else {
                GlStateManager.glDrawArrays(llllllllllllllIllIlIlIlIllIllIlI.getDrawMode(), 0, llllllllllllllIllIlIlIlIllIllIlI.getVertexCount());
            }
            for (int llllllllllllllIllIlIlIlIllIIlllI = 0, llllllllllllllIllIlIlIlIllIIllIl = llllllllllllllIllIlIlIlIllIlIllI.size(); llllllllllllllIllIlIlIlIllIIlllI < llllllllllllllIllIlIlIlIllIIllIl; ++llllllllllllllIllIlIlIlIllIIlllI) {
                final VertexFormatElement llllllllllllllIllIlIlIlIllIIllII = llllllllllllllIllIlIlIlIllIlIllI.get(llllllllllllllIllIlIlIlIllIIlllI);
                final VertexFormatElement.EnumUsage llllllllllllllIllIlIlIlIllIIlIll = llllllllllllllIllIlIlIlIllIIllII.getUsage();
                if (llllllllllllllIllIlIlIlIllIlIlII) {
                    Reflector.callVoid((Object)llllllllllllllIllIlIlIlIllIIlIll, Reflector.ForgeVertexFormatElementEnumUseage_postDraw, new Object[] { llllllllllllllIllIlIlIlIllIllIIl, llllllllllllllIllIlIlIlIllIIlllI, llllllllllllllIllIlIlIlIllIllIII, llllllllllllllIllIlIlIlIllIlIlll });
                }
                else {
                    final int llllllllllllllIllIlIlIlIllIIlIlI = llllllllllllllIllIlIlIlIllIIllII.getIndex();
                    switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[llllllllllllllIllIlIlIlIllIIlIll.ordinal()]) {
                        case 1: {
                            GlStateManager.glDisableClientState(32884);
                            break;
                        }
                        case 4: {
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllllllIllIlIlIlIllIIlIlI);
                            GlStateManager.glDisableClientState(32888);
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                            break;
                        }
                        case 3: {
                            GlStateManager.glDisableClientState(32886);
                            GlStateManager.resetColor();
                            break;
                        }
                        case 2: {
                            GlStateManager.glDisableClientState(32885);
                            break;
                        }
                    }
                }
            }
        }
        llllllllllllllIllIlIlIlIllIllIlI.reset();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = WorldVertexBufferUploader.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        if ($switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage != null) {
            return $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        }
        final Exception llllllllllllllIllIlIlIlIlIllllII = (Object)new int[VertexFormatElement.EnumUsage.values().length];
        try {
            llllllllllllllIllIlIlIlIlIllllII[VertexFormatElement.EnumUsage.BLEND_WEIGHT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIllIlIlIlIlIllllII[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIllIlIlIlIlIllllII[VertexFormatElement.EnumUsage.MATRIX.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIllIlIlIlIlIllllII[VertexFormatElement.EnumUsage.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIllIlIlIlIlIllllII[VertexFormatElement.EnumUsage.PADDING.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIllIlIlIlIlIllllII[VertexFormatElement.EnumUsage.POSITION.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIllIlIlIlIlIllllII[VertexFormatElement.EnumUsage.UV.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return WorldVertexBufferUploader.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = (int[])(Object)llllllllllllllIllIlIlIlIlIllllII;
    }
}
