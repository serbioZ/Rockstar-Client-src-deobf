// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import optifine.TextureUtils;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import java.util.BitSet;
import java.util.Arrays;
import com.google.common.primitives.Floats;
import java.util.Comparator;
import java.nio.ByteOrder;
import net.minecraft.util.math.MathHelper;
import optifine.Config;
import org.apache.logging.log4j.LogManager;
import java.nio.FloatBuffer;
import optifine.RenderEnv;
import org.apache.logging.log4j.Logger;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import shadersmod.client.SVertexBuilder;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.util.BlockRenderLayer;
import java.nio.ByteBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;

public class BufferBuilder
{
    public /* synthetic */ int drawMode;
    private /* synthetic */ VertexFormat vertexFormat;
    public /* synthetic */ int vertexCount;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType;
    private /* synthetic */ TextureAtlasSprite[] quadSprites;
    private /* synthetic */ ByteBuffer byteBuffer;
    private /* synthetic */ TextureAtlasSprite[] quadSpritesPrev;
    private /* synthetic */ BlockRenderLayer blockLayer;
    private /* synthetic */ VertexFormatElement vertexFormatElement;
    private /* synthetic */ double xOffset;
    private /* synthetic */ TextureAtlasSprite quadSprite;
    private /* synthetic */ int vertexFormatIndex;
    private /* synthetic */ ShortBuffer rawShortBuffer;
    public /* synthetic */ IntBuffer rawIntBuffer;
    private static final /* synthetic */ Logger LOGGER;
    public /* synthetic */ RenderEnv renderEnv;
    public /* synthetic */ FloatBuffer rawFloatBuffer;
    private /* synthetic */ boolean[] drawnIcons;
    private /* synthetic */ boolean isDrawing;
    private /* synthetic */ boolean noColor;
    private /* synthetic */ double zOffset;
    private /* synthetic */ double yOffset;
    
    public void setVertexState(final State lllllllllllllIlllIlIllIllIlllIlI) {
        this.rawIntBuffer.clear();
        this.growBuffer(lllllllllllllIlllIlIllIllIlllIlI.getRawBuffer().length * 4);
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIllIlllIlI.getRawBuffer());
        this.vertexCount = lllllllllllllIlllIlIllIllIlllIlI.getVertexCount();
        this.vertexFormat = new VertexFormat(lllllllllllllIlllIlIllIllIlllIlI.getVertexFormat());
        if (lllllllllllllIlllIlIllIllIlllIlI.stateQuadSprites != null) {
            if (this.quadSprites == null) {
                this.quadSprites = this.quadSpritesPrev;
            }
            if (this.quadSprites == null || this.quadSprites.length < this.getBufferQuadSize()) {
                this.quadSprites = new TextureAtlasSprite[this.getBufferQuadSize()];
            }
            final TextureAtlasSprite[] lllllllllllllIlllIlIllIllIlllIIl = lllllllllllllIlllIlIllIllIlllIlI.stateQuadSprites;
            System.arraycopy(lllllllllllllIlllIlIllIllIlllIIl, 0, this.quadSprites, 0, lllllllllllllIlllIlIllIllIlllIIl.length);
        }
        else {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
        }
    }
    
    public void putColorRGB_F4(final float lllllllllllllIlllIlIllIIIlIlIlll, final float lllllllllllllIlllIlIllIIIlIlIllI, final float lllllllllllllIlllIlIllIIIlIllIlI) {
        for (int lllllllllllllIlllIlIllIIIlIllIIl = 0; lllllllllllllIlllIlIllIIIlIllIIl < 4; ++lllllllllllllIlllIlIllIIIlIllIIl) {
            this.putColorRGB_F(lllllllllllllIlllIlIllIIIlIlIlll, lllllllllllllIlllIlIllIIIlIlIllI, lllllllllllllIlllIlIllIIIlIllIlI, lllllllllllllIlllIlIllIIIlIllIIl + 1);
        }
    }
    
    public void putNormal(final float lllllllllllllIlllIlIllIIlIlIIIIl, final float lllllllllllllIlllIlIllIIlIlIlIlI, final float lllllllllllllIlllIlIllIIlIIlllll) {
        final int lllllllllllllIlllIlIllIIlIlIlIII = (byte)(lllllllllllllIlllIlIllIIlIlIIIIl * 127.0f) & 0xFF;
        final int lllllllllllllIlllIlIllIIlIlIIlll = (byte)(lllllllllllllIlllIlIllIIlIlIlIlI * 127.0f) & 0xFF;
        final int lllllllllllllIlllIlIllIIlIlIIllI = (byte)(lllllllllllllIlllIlIllIIlIIlllll * 127.0f) & 0xFF;
        final int lllllllllllllIlllIlIllIIlIlIIlIl = lllllllllllllIlllIlIllIIlIlIlIII | lllllllllllllIlllIlIllIIlIlIIlll << 8 | lllllllllllllIlllIlIllIIlIlIIllI << 16;
        final int lllllllllllllIlllIlIllIIlIlIIlII = this.vertexFormat.getNextOffset() >> 2;
        final int lllllllllllllIlllIlIllIIlIlIIIll = (this.vertexCount - 4) * lllllllllllllIlllIlIllIIlIlIIlII + this.vertexFormat.getNormalOffset() / 4;
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIIlIlIIIll, lllllllllllllIlllIlIllIIlIlIIlIl);
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIIlIlIIIll + lllllllllllllIlllIlIllIIlIlIIlII, lllllllllllllIlllIlIllIIlIlIIlIl);
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIIlIlIIIll + lllllllllllllIlllIlIllIIlIlIIlII * 2, lllllllllllllIlllIlIllIIlIlIIlIl);
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIIlIlIIIll + lllllllllllllIlllIlIllIIlIlIIlII * 3, lllllllllllllIlllIlIllIIlIlIIlIl);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    private void growBuffer(int lllllllllllllIlllIlIlllIIlIlIIIl) {
        if (Config.isShaders()) {
            lllllllllllllIlllIlIlllIIlIlIIIl *= 2;
        }
        if (MathHelper.roundUp(lllllllllllllIlllIlIlllIIlIlIIIl, 4) / 4 > this.rawIntBuffer.remaining() || this.vertexCount * this.vertexFormat.getNextOffset() + lllllllllllllIlllIlIlllIIlIlIIIl > this.byteBuffer.capacity()) {
            final int lllllllllllllIlllIlIlllIIlIlIIII = this.byteBuffer.capacity();
            final int lllllllllllllIlllIlIlllIIlIIllll = lllllllllllllIlllIlIlllIIlIlIIII + MathHelper.roundUp(lllllllllllllIlllIlIlllIIlIlIIIl, 2097152);
            BufferBuilder.LOGGER.debug("Needed to grow BufferBuilder buffer: Old size {} bytes, new size {} bytes.", (Object)lllllllllllllIlllIlIlllIIlIlIIII, (Object)lllllllllllllIlllIlIlllIIlIIllll);
            final int lllllllllllllIlllIlIlllIIlIIlllI = this.rawIntBuffer.position();
            final ByteBuffer lllllllllllllIlllIlIlllIIlIIllIl = GLAllocation.createDirectByteBuffer(lllllllllllllIlllIlIlllIIlIIllll);
            this.byteBuffer.position(0);
            lllllllllllllIlllIlIlllIIlIIllIl.put(this.byteBuffer);
            lllllllllllllIlllIlIlllIIlIIllIl.rewind();
            this.byteBuffer = lllllllllllllIlllIlIlllIIlIIllIl;
            this.rawFloatBuffer = this.byteBuffer.asFloatBuffer();
            this.rawIntBuffer = this.byteBuffer.asIntBuffer();
            this.rawIntBuffer.position(lllllllllllllIlllIlIlllIIlIIlllI);
            this.rawShortBuffer = this.byteBuffer.asShortBuffer();
            this.rawShortBuffer.position(lllllllllllllIlllIlIlllIIlIIlllI << 1);
            if (this.quadSprites != null) {
                final TextureAtlasSprite[] lllllllllllllIlllIlIlllIIlIIllII = this.quadSprites;
                final int lllllllllllllIlllIlIlllIIlIIlIll = this.getBufferQuadSize();
                this.quadSprites = new TextureAtlasSprite[lllllllllllllIlllIlIlllIIlIIlIll];
                System.arraycopy(lllllllllllllIlllIlIlllIIlIIllII, 0, this.quadSprites, 0, Math.min(lllllllllllllIlllIlIlllIIlIIllII.length, this.quadSprites.length));
                this.quadSpritesPrev = null;
            }
        }
    }
    
    public BufferBuilder tex(double lllllllllllllIlllIlIllIllIlIIIII, double lllllllllllllIlllIlIllIllIIlllll) {
        if (this.quadSprite != null && this.quadSprites != null) {
            lllllllllllllIlllIlIllIllIlIIIII = this.quadSprite.toSingleU((float)lllllllllllllIlllIlIllIllIlIIIII);
            lllllllllllllIlllIlIllIllIIlllll = this.quadSprite.toSingleV((float)lllllllllllllIlllIlIllIllIIlllll);
            this.quadSprites[this.vertexCount / 4] = this.quadSprite;
        }
        final int lllllllllllllIlllIlIllIllIlIIIlI = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
            case 1: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIllIlIIIlI, (float)lllllllllllllIlllIlIllIllIlIIIII);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIllIlIIIlI + 4, (float)lllllllllllllIlllIlIllIllIIlllll);
                break;
            }
            case 6:
            case 7: {
                this.byteBuffer.putInt(lllllllllllllIlllIlIllIllIlIIIlI, (int)lllllllllllllIlllIlIllIllIlIIIII);
                this.byteBuffer.putInt(lllllllllllllIlllIlIllIllIlIIIlI + 4, (int)lllllllllllllIlllIlIllIllIIlllll);
                break;
            }
            case 4:
            case 5: {
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIllIlIIIlI, (short)(int)lllllllllllllIlllIlIllIllIIlllll);
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIllIlIIIlI + 2, (short)lllllllllllllIlllIlIllIllIlIIIII);
                break;
            }
            case 2:
            case 3: {
                this.byteBuffer.put(lllllllllllllIlllIlIllIllIlIIIlI, (byte)(int)lllllllllllllIlllIlIllIllIIlllll);
                this.byteBuffer.put(lllllllllllllIlllIlIllIllIlIIIlI + 1, (byte)lllllllllllllIlllIlIllIllIlIIIII);
                break;
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }
    
    public void putColorRGBA(final int lllllllllllllIlllIlIllIlIIIIIIIl, final int lllllllllllllIlllIlIllIIlllllIll, final int lllllllllllllIlllIlIllIIlllllIlI, final int lllllllllllllIlllIlIllIIlllllIIl) {
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this.rawIntBuffer.put(lllllllllllllIlllIlIllIlIIIIIIIl, 0xFF000000 | lllllllllllllIlllIlIllIIlllllIIl << 16 | lllllllllllllIlllIlIllIIlllllIlI << 8 | lllllllllllllIlllIlIllIIlllllIll);
        }
        else {
            this.rawIntBuffer.put(lllllllllllllIlllIlIllIlIIIIIIIl, lllllllllllllIlllIlIllIIlllllIll << 24 | lllllllllllllIlllIlIllIIlllllIlI << 16 | lllllllllllllIlllIlIllIIlllllIIl << 8 | 0xFF);
        }
    }
    
    public State getVertexState() {
        this.rawIntBuffer.rewind();
        final int lllllllllllllIlllIlIlllIIIIIlIIl = this.getBufferSize();
        this.rawIntBuffer.limit(lllllllllllllIlllIlIlllIIIIIlIIl);
        final int[] lllllllllllllIlllIlIlllIIIIIlIII = new int[lllllllllllllIlllIlIlllIIIIIlIIl];
        this.rawIntBuffer.get(lllllllllllllIlllIlIlllIIIIIlIII);
        this.rawIntBuffer.limit(this.rawIntBuffer.capacity());
        this.rawIntBuffer.position(lllllllllllllIlllIlIlllIIIIIlIIl);
        TextureAtlasSprite[] lllllllllllllIlllIlIlllIIIIIIlll = null;
        if (this.quadSprites != null) {
            final int lllllllllllllIlllIlIlllIIIIIIllI = this.vertexCount / 4;
            lllllllllllllIlllIlIlllIIIIIIlll = new TextureAtlasSprite[lllllllllllllIlllIlIlllIIIIIIllI];
            System.arraycopy(this.quadSprites, 0, lllllllllllllIlllIlIlllIIIIIIlll, 0, lllllllllllllIlllIlIlllIIIIIIllI);
        }
        return new State(lllllllllllllIlllIlIlllIIIIIlIII, new VertexFormat(this.vertexFormat), lllllllllllllIlllIlIlllIIIIIIlll);
    }
    
    public double getXOffset() {
        return this.xOffset;
    }
    
    public VertexFormat getVertexFormat() {
        return this.vertexFormat;
    }
    
    public boolean isDrawing() {
        return this.isDrawing;
    }
    
    public void putColor4(final int lllllllllllllIlllIlIllIIIllIIlll) {
        for (int lllllllllllllIlllIlIllIIIllIIllI = 0; lllllllllllllIlllIlIllIIIllIIllI < 4; ++lllllllllllllIlllIlIllIIIllIIllI) {
            this.func_192836_a(lllllllllllllIlllIlIllIIIllIIlll, lllllllllllllIlllIlIllIIIllIIllI + 1);
        }
    }
    
    public void sortVertexData(final float lllllllllllllIlllIlIlllIIIllIIlI, final float lllllllllllllIlllIlIlllIIIllIIIl, final float lllllllllllllIlllIlIlllIIIllIIII) {
        final int lllllllllllllIlllIlIlllIIIlIllll = this.vertexCount / 4;
        final float[] lllllllllllllIlllIlIlllIIIlIlllI = new float[lllllllllllllIlllIlIlllIIIlIllll];
        for (int lllllllllllllIlllIlIlllIIIlIllIl = 0; lllllllllllllIlllIlIlllIIIlIllIl < lllllllllllllIlllIlIlllIIIlIllll; ++lllllllllllllIlllIlIlllIIIlIllIl) {
            lllllllllllllIlllIlIlllIIIlIlllI[lllllllllllllIlllIlIlllIIIlIllIl] = getDistanceSq(this.rawFloatBuffer, (float)(lllllllllllllIlllIlIlllIIIllIIlI + this.xOffset), (float)(lllllllllllllIlllIlIlllIIIllIIIl + this.yOffset), (float)(lllllllllllllIlllIlIlllIIIllIIII + this.zOffset), this.vertexFormat.getIntegerSize(), lllllllllllllIlllIlIlllIIIlIllIl * this.vertexFormat.getNextOffset());
        }
        final Integer[] lllllllllllllIlllIlIlllIIIlIllII = new Integer[lllllllllllllIlllIlIlllIIIlIllll];
        for (int lllllllllllllIlllIlIlllIIIlIlIll = 0; lllllllllllllIlllIlIlllIIIlIlIll < lllllllllllllIlllIlIlllIIIlIllII.length; ++lllllllllllllIlllIlIlllIIIlIlIll) {
            lllllllllllllIlllIlIlllIIIlIllII[lllllllllllllIlllIlIlllIIIlIlIll] = lllllllllllllIlllIlIlllIIIlIlIll;
        }
        Arrays.sort(lllllllllllllIlllIlIlllIIIlIllII, new Comparator<Integer>() {
            @Override
            public int compare(final Integer lllllllllllIlIlIllIIIllllllllIlI, final Integer lllllllllllIlIlIllIIIlllllllIllI) {
                return Floats.compare(lllllllllllllIlllIlIlllIIIlIlllI[lllllllllllIlIlIllIIIlllllllIllI], lllllllllllllIlllIlIlllIIIlIlllI[lllllllllllIlIlIllIIIllllllllIlI]);
            }
        });
        final BitSet lllllllllllllIlllIlIlllIIIlIlIlI = new BitSet();
        final int lllllllllllllIlllIlIlllIIIlIlIIl = this.vertexFormat.getNextOffset();
        final int[] lllllllllllllIlllIlIlllIIIlIlIII = new int[lllllllllllllIlllIlIlllIIIlIlIIl];
        for (int lllllllllllllIlllIlIlllIIIlIIlll = lllllllllllllIlllIlIlllIIIlIlIlI.nextClearBit(0); lllllllllllllIlllIlIlllIIIlIIlll < lllllllllllllIlllIlIlllIIIlIllII.length; lllllllllllllIlllIlIlllIIIlIIlll = lllllllllllllIlllIlIlllIIIlIlIlI.nextClearBit(lllllllllllllIlllIlIlllIIIlIIlll + 1)) {
            final int lllllllllllllIlllIlIlllIIIlIIllI = lllllllllllllIlllIlIlllIIIlIllII[lllllllllllllIlllIlIlllIIIlIIlll];
            if (lllllllllllllIlllIlIlllIIIlIIllI != lllllllllllllIlllIlIlllIIIlIIlll) {
                this.rawIntBuffer.limit(lllllllllllllIlllIlIlllIIIlIIllI * lllllllllllllIlllIlIlllIIIlIlIIl + lllllllllllllIlllIlIlllIIIlIlIIl);
                this.rawIntBuffer.position(lllllllllllllIlllIlIlllIIIlIIllI * lllllllllllllIlllIlIlllIIIlIlIIl);
                this.rawIntBuffer.get(lllllllllllllIlllIlIlllIIIlIlIII);
                for (int lllllllllllllIlllIlIlllIIIlIIlIl = lllllllllllllIlllIlIlllIIIlIIllI, lllllllllllllIlllIlIlllIIIlIIlII = lllllllllllllIlllIlIlllIIIlIllII[lllllllllllllIlllIlIlllIIIlIIllI]; lllllllllllllIlllIlIlllIIIlIIlIl != lllllllllllllIlllIlIlllIIIlIIlll; lllllllllllllIlllIlIlllIIIlIIlIl = lllllllllllllIlllIlIlllIIIlIIlII, lllllllllllllIlllIlIlllIIIlIIlII = lllllllllllllIlllIlIlllIIIlIllII[lllllllllllllIlllIlIlllIIIlIIlII]) {
                    this.rawIntBuffer.limit(lllllllllllllIlllIlIlllIIIlIIlII * lllllllllllllIlllIlIlllIIIlIlIIl + lllllllllllllIlllIlIlllIIIlIlIIl);
                    this.rawIntBuffer.position(lllllllllllllIlllIlIlllIIIlIIlII * lllllllllllllIlllIlIlllIIIlIlIIl);
                    final IntBuffer lllllllllllllIlllIlIlllIIIlIIIll = this.rawIntBuffer.slice();
                    this.rawIntBuffer.limit(lllllllllllllIlllIlIlllIIIlIIlIl * lllllllllllllIlllIlIlllIIIlIlIIl + lllllllllllllIlllIlIlllIIIlIlIIl);
                    this.rawIntBuffer.position(lllllllllllllIlllIlIlllIIIlIIlIl * lllllllllllllIlllIlIlllIIIlIlIIl);
                    this.rawIntBuffer.put(lllllllllllllIlllIlIlllIIIlIIIll);
                    lllllllllllllIlllIlIlllIIIlIlIlI.set(lllllllllllllIlllIlIlllIIIlIIlIl);
                }
                this.rawIntBuffer.limit(lllllllllllllIlllIlIlllIIIlIIlll * lllllllllllllIlllIlIlllIIIlIlIIl + lllllllllllllIlllIlIlllIIIlIlIIl);
                this.rawIntBuffer.position(lllllllllllllIlllIlIlllIIIlIIlll * lllllllllllllIlllIlIlllIIIlIlIIl);
                this.rawIntBuffer.put(lllllllllllllIlllIlIlllIIIlIlIII);
            }
            lllllllllllllIlllIlIlllIIIlIlIlI.set(lllllllllllllIlllIlIlllIIIlIIlll);
        }
        this.rawIntBuffer.limit(this.rawIntBuffer.capacity());
        this.rawIntBuffer.position(this.getBufferSize());
        if (this.quadSprites != null) {
            final TextureAtlasSprite[] lllllllllllllIlllIlIlllIIIlIIIlI = new TextureAtlasSprite[this.vertexCount / 4];
            final int lllllllllllllIlllIlIlllIIIlIIIIl = this.vertexFormat.getNextOffset() / 4 * 4;
            for (int lllllllllllllIlllIlIlllIIIlIIIII = 0; lllllllllllllIlllIlIlllIIIlIIIII < lllllllllllllIlllIlIlllIIIlIllII.length; ++lllllllllllllIlllIlIlllIIIlIIIII) {
                final int lllllllllllllIlllIlIlllIIIIlllll = lllllllllllllIlllIlIlllIIIlIllII[lllllllllllllIlllIlIlllIIIlIIIII];
                lllllllllllllIlllIlIlllIIIlIIIlI[lllllllllllllIlllIlIlllIIIlIIIII] = this.quadSprites[lllllllllllllIlllIlIlllIIIIlllll];
            }
            System.arraycopy(lllllllllllllIlllIlIlllIIIlIIIlI, 0, this.quadSprites, 0, lllllllllllllIlllIlIlllIIIlIIIlI.length);
        }
    }
    
    public BufferBuilder lightmap(final int lllllllllllllIlllIlIllIllIIlIlII, final int lllllllllllllIlllIlIllIllIIlIIll) {
        final int lllllllllllllIlllIlIllIllIIlIllI = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
            case 1: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIllIIlIllI, (float)lllllllllllllIlllIlIllIllIIlIlII);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIllIIlIllI + 4, (float)lllllllllllllIlllIlIllIllIIlIIll);
                break;
            }
            case 6:
            case 7: {
                this.byteBuffer.putInt(lllllllllllllIlllIlIllIllIIlIllI, lllllllllllllIlllIlIllIllIIlIlII);
                this.byteBuffer.putInt(lllllllllllllIlllIlIllIllIIlIllI + 4, lllllllllllllIlllIlIllIllIIlIIll);
                break;
            }
            case 4:
            case 5: {
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIllIIlIllI, (short)lllllllllllllIlllIlIllIllIIlIIll);
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIllIIlIllI + 2, (short)lllllllllllllIlllIlIllIllIIlIlII);
                break;
            }
            case 2:
            case 3: {
                this.byteBuffer.put(lllllllllllllIlllIlIllIllIIlIllI, (byte)lllllllllllllIlllIlIllIllIIlIIll);
                this.byteBuffer.put(lllllllllllllIlllIlIllIllIIlIllI + 1, (byte)lllllllllllllIlllIlIllIllIIlIlII);
                break;
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }
    
    public boolean isColorDisabled() {
        return this.noColor;
    }
    
    public void putColorRGB_F(final float lllllllllllllIlllIlIllIlIIIIllll, final float lllllllllllllIlllIlIllIlIIIlIlll, final float lllllllllllllIlllIlIllIlIIIIllIl, final int lllllllllllllIlllIlIllIlIIIlIlIl) {
        final int lllllllllllllIlllIlIllIlIIIlIlII = this.getColorIndex(lllllllllllllIlllIlIllIlIIIlIlIl);
        final int lllllllllllllIlllIlIllIlIIIlIIll = MathHelper.clamp((int)(lllllllllllllIlllIlIllIlIIIIllll * 255.0f), 0, 255);
        final int lllllllllllllIlllIlIllIlIIIlIIlI = MathHelper.clamp((int)(lllllllllllllIlllIlIllIlIIIlIlll * 255.0f), 0, 255);
        final int lllllllllllllIlllIlIllIlIIIlIIIl = MathHelper.clamp((int)(lllllllllllllIlllIlIllIlIIIIllIl * 255.0f), 0, 255);
        this.putColorRGBA(lllllllllllllIlllIlIllIlIIIlIlII, lllllllllllllIlllIlIllIlIIIlIIll, lllllllllllllIlllIlIllIlIIIlIIlI, lllllllllllllIlllIlIllIlIIIlIIIl);
    }
    
    public RenderEnv getRenderEnv(final IBlockAccess lllllllllllllIlllIlIlIlllllIlIlI, final IBlockState lllllllllllllIlllIlIlIlllllIllIl, final BlockPos lllllllllllllIlllIlIlIlllllIlIII) {
        if (this.renderEnv == null) {
            this.renderEnv = new RenderEnv(lllllllllllllIlllIlIlIlllllIlIlI, lllllllllllllIlllIlIlIlllllIllIl, lllllllllllllIlllIlIlIlllllIlIII);
            return this.renderEnv;
        }
        this.renderEnv.reset(lllllllllllllIlllIlIlIlllllIlIlI, lllllllllllllIlllIlIlIlllllIllIl, lllllllllllllIlllIlIlIlllllIlIII);
        return this.renderEnv;
    }
    
    public void reset() {
        this.vertexCount = 0;
        this.vertexFormatElement = null;
        this.vertexFormatIndex = 0;
        this.quadSprite = null;
    }
    
    public BufferBuilder(int lllllllllllllIlllIlIlllIIlIllIll) {
        this.blockLayer = null;
        this.drawnIcons = new boolean[256];
        this.quadSprites = null;
        this.quadSpritesPrev = null;
        this.quadSprite = null;
        this.renderEnv = null;
        if (Config.isShaders()) {
            lllllllllllllIlllIlIlllIIlIllIll *= 2;
        }
        this.byteBuffer = GLAllocation.createDirectByteBuffer((int)(lllllllllllllIlllIlIlllIIlIllIll * 4));
        this.rawIntBuffer = this.byteBuffer.asIntBuffer();
        this.rawShortBuffer = this.byteBuffer.asShortBuffer();
        this.rawFloatBuffer = this.byteBuffer.asFloatBuffer();
        SVertexBuilder.initVertexBuilder(this);
    }
    
    public void putColorRGBA(final int lllllllllllllIlllIlIlIllllIIlllI, final int lllllllllllllIlllIlIlIllllIlIIll, final int lllllllllllllIlllIlIlIllllIlIIlI, final int lllllllllllllIlllIlIlIllllIIlIll, final int lllllllllllllIlllIlIlIllllIlIIII) {
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this.rawIntBuffer.put(lllllllllllllIlllIlIlIllllIIlllI, lllllllllllllIlllIlIlIllllIlIIII << 24 | lllllllllllllIlllIlIlIllllIIlIll << 16 | lllllllllllllIlllIlIlIllllIlIIlI << 8 | lllllllllllllIlllIlIlIllllIlIIll);
        }
        else {
            this.rawIntBuffer.put(lllllllllllllIlllIlIlIllllIIlllI, lllllllllllllIlllIlIlIllllIlIIll << 24 | lllllllllllllIlllIlIlIllllIlIIlI << 16 | lllllllllllllIlllIlIlIllllIIlIll << 8 | lllllllllllllIlllIlIlIllllIlIIII);
        }
    }
    
    public int getColorIndex(final int lllllllllllllIlllIlIllIlIlIllIll) {
        return ((this.vertexCount - lllllllllllllIlllIlIllIlIlIllIll) * this.vertexFormat.getNextOffset() + this.vertexFormat.getColorOffset()) / 4;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType = BufferBuilder.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType;
        if ($switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType != null) {
            return $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType;
        }
        final int lllllllllllllIlllIlIlIllllIIIlIl = (Object)new int[VertexFormatElement.EnumType.values().length];
        try {
            lllllllllllllIlllIlIlIllllIIIlIl[VertexFormatElement.EnumType.BYTE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlllIlIlIllllIIIlIl[VertexFormatElement.EnumType.FLOAT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlllIlIlIllllIIIlIl[VertexFormatElement.EnumType.INT.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlllIlIlIllllIIIlIl[VertexFormatElement.EnumType.SHORT.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlllIlIlIllllIIIlIl[VertexFormatElement.EnumType.UBYTE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlllIlIlIllllIIIlIl[VertexFormatElement.EnumType.UINT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllIlllIlIlIllllIIIlIl[VertexFormatElement.EnumType.USHORT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return BufferBuilder.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType = (int[])(Object)lllllllllllllIlllIlIlIllllIIIlIl;
    }
    
    public BufferBuilder normal(final float lllllllllllllIlllIlIllIIlIIIlIlI, final float lllllllllllllIlllIlIllIIlIIIlllI, final float lllllllllllllIlllIlIllIIlIIIllIl) {
        final int lllllllllllllIlllIlIllIIlIIIllII = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
            case 1: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIlIIIllII, lllllllllllllIlllIlIllIIlIIIlIlI);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIlIIIllII + 4, lllllllllllllIlllIlIllIIlIIIlllI);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIlIIIllII + 8, lllllllllllllIlllIlIllIIlIIIllIl);
                break;
            }
            case 6:
            case 7: {
                this.byteBuffer.putInt(lllllllllllllIlllIlIllIIlIIIllII, (int)lllllllllllllIlllIlIllIIlIIIlIlI);
                this.byteBuffer.putInt(lllllllllllllIlllIlIllIIlIIIllII + 4, (int)lllllllllllllIlllIlIllIIlIIIlllI);
                this.byteBuffer.putInt(lllllllllllllIlllIlIllIIlIIIllII + 8, (int)lllllllllllllIlllIlIllIIlIIIllIl);
                break;
            }
            case 4:
            case 5: {
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIIlIIIllII, (short)((int)(lllllllllllllIlllIlIllIIlIIIlIlI * 32767.0f) & 0xFFFF));
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIIlIIIllII + 2, (short)((int)(lllllllllllllIlllIlIllIIlIIIlllI * 32767.0f) & 0xFFFF));
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIIlIIIllII + 4, (short)((int)(lllllllllllllIlllIlIllIIlIIIllIl * 32767.0f) & 0xFFFF));
                break;
            }
            case 2:
            case 3: {
                this.byteBuffer.put(lllllllllllllIlllIlIllIIlIIIllII, (byte)((int)(lllllllllllllIlllIlIllIIlIIIlIlI * 127.0f) & 0xFF));
                this.byteBuffer.put(lllllllllllllIlllIlIllIIlIIIllII + 1, (byte)((int)(lllllllllllllIlllIlIllIIlIIIlllI * 127.0f) & 0xFF));
                this.byteBuffer.put(lllllllllllllIlllIlIllIIlIIIllII + 2, (byte)((int)(lllllllllllllIlllIlIllIIlIIIllIl * 127.0f) & 0xFF));
                break;
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }
    
    public BufferBuilder color(final float lllllllllllllIlllIlIllIIlllIllll, final float lllllllllllllIlllIlIllIIlllIlllI, final float lllllllllllllIlllIlIllIIlllIlIII, final float lllllllllllllIlllIlIllIIlllIllII) {
        return this.color((int)(lllllllllllllIlllIlIllIIlllIllll * 255.0f), (int)(lllllllllllllIlllIlIllIIlllIlllI * 255.0f), (int)(lllllllllllllIlllIlIllIIlllIlIII * 255.0f), (int)(lllllllllllllIlllIlIllIIlllIllII * 255.0f));
    }
    
    private void draw(final int lllllllllllllIlllIlIllIIIIIIlIlI, final int lllllllllllllIlllIlIllIIIIIIlIIl) {
        final int lllllllllllllIlllIlIllIIIIIIlIII = lllllllllllllIlllIlIllIIIIIIlIIl - lllllllllllllIlllIlIllIIIIIIlIlI;
        if (lllllllllllllIlllIlIllIIIIIIlIII > 0) {
            final int lllllllllllllIlllIlIllIIIIIIIlll = lllllllllllllIlllIlIllIIIIIIlIlI * 4;
            final int lllllllllllllIlllIlIllIIIIIIIllI = lllllllllllllIlllIlIllIIIIIIlIII * 4;
            GL11.glDrawArrays(this.drawMode, lllllllllllllIlllIlIllIIIIIIIlll, lllllllllllllIlllIlIllIIIIIIIllI);
        }
    }
    
    private int drawForIcon(final TextureAtlasSprite lllllllllllllIlllIlIllIIIIlIIIII, final int lllllllllllllIlllIlIllIIIIIlllll) {
        GL11.glBindTexture(3553, lllllllllllllIlllIlIllIIIIlIIIII.glSpriteTextureId);
        int lllllllllllllIlllIlIllIIIIIllllI = -1;
        int lllllllllllllIlllIlIllIIIIIlllIl = -1;
        final int lllllllllllllIlllIlIllIIIIIlllII = this.vertexCount / 4;
        for (int lllllllllllllIlllIlIllIIIIIllIll = lllllllllllllIlllIlIllIIIIIlllll; lllllllllllllIlllIlIllIIIIIllIll < lllllllllllllIlllIlIllIIIIIlllII; ++lllllllllllllIlllIlIllIIIIIllIll) {
            final TextureAtlasSprite lllllllllllllIlllIlIllIIIIIllIlI = this.quadSprites[lllllllllllllIlllIlIllIIIIIllIll];
            if (lllllllllllllIlllIlIllIIIIIllIlI == lllllllllllllIlllIlIllIIIIlIIIII) {
                if (lllllllllllllIlllIlIllIIIIIlllIl < 0) {
                    lllllllllllllIlllIlIllIIIIIlllIl = lllllllllllllIlllIlIllIIIIIllIll;
                }
            }
            else if (lllllllllllllIlllIlIllIIIIIlllIl >= 0) {
                this.draw(lllllllllllllIlllIlIllIIIIIlllIl, lllllllllllllIlllIlIllIIIIIllIll);
                if (this.blockLayer == BlockRenderLayer.TRANSLUCENT) {
                    return lllllllllllllIlllIlIllIIIIIllIll;
                }
                lllllllllllllIlllIlIllIIIIIlllIl = -1;
                if (lllllllllllllIlllIlIllIIIIIllllI < 0) {
                    lllllllllllllIlllIlIllIIIIIllllI = lllllllllllllIlllIlIllIIIIIllIll;
                }
            }
        }
        if (lllllllllllllIlllIlIllIIIIIlllIl >= 0) {
            this.draw(lllllllllllllIlllIlIllIIIIIlllIl, lllllllllllllIlllIlIllIIIIIlllII);
        }
        if (lllllllllllllIlllIlIllIIIIIllllI < 0) {
            lllllllllllllIlllIlIllIIIIIllllI = lllllllllllllIlllIlIllIIIIIlllII;
        }
        return lllllllllllllIlllIlIllIIIIIllllI;
    }
    
    public double getYOffset() {
        return this.yOffset;
    }
    
    public int getBufferSize() {
        return this.vertexCount * this.vertexFormat.getIntegerSize();
    }
    
    private void nextVertexFormatIndex() {
        ++this.vertexFormatIndex;
        this.vertexFormatIndex %= this.vertexFormat.getElementCount();
        this.vertexFormatElement = this.vertexFormat.getElement(this.vertexFormatIndex);
        if (this.vertexFormatElement.getUsage() == VertexFormatElement.EnumUsage.PADDING) {
            this.nextVertexFormatIndex();
        }
    }
    
    public boolean isMultiTexture() {
        return this.quadSprites != null;
    }
    
    public int getDrawMode() {
        return this.drawMode;
    }
    
    private static float getDistanceSq(final FloatBuffer lllllllllllllIlllIlIllIlllIlIIll, final float lllllllllllllIlllIlIllIlllIlIIlI, final float lllllllllllllIlllIlIllIlllIlIIIl, final float lllllllllllllIlllIlIllIlllIlIIII, final int lllllllllllllIlllIlIllIllllIIlII, final int lllllllllllllIlllIlIllIlllIIlllI) {
        final float lllllllllllllIlllIlIllIllllIIIlI = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 0 + 0);
        final float lllllllllllllIlllIlIllIllllIIIIl = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 0 + 1);
        final float lllllllllllllIlllIlIllIllllIIIII = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 0 + 2);
        final float lllllllllllllIlllIlIllIlllIlllll = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 1 + 0);
        final float lllllllllllllIlllIlIllIlllIllllI = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 1 + 1);
        final float lllllllllllllIlllIlIllIlllIlllIl = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 1 + 2);
        final float lllllllllllllIlllIlIllIlllIlllII = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 2 + 0);
        final float lllllllllllllIlllIlIllIlllIllIll = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 2 + 1);
        final float lllllllllllllIlllIlIllIlllIllIlI = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 2 + 2);
        final float lllllllllllllIlllIlIllIlllIllIIl = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 3 + 0);
        final float lllllllllllllIlllIlIllIlllIllIII = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 3 + 1);
        final float lllllllllllllIlllIlIllIlllIlIlll = lllllllllllllIlllIlIllIlllIlIIll.get(lllllllllllllIlllIlIllIlllIIlllI + lllllllllllllIlllIlIllIllllIIlII * 3 + 2);
        final float lllllllllllllIlllIlIllIlllIlIllI = (lllllllllllllIlllIlIllIllllIIIlI + lllllllllllllIlllIlIllIlllIlllll + lllllllllllllIlllIlIllIlllIlllII + lllllllllllllIlllIlIllIlllIllIIl) * 0.25f - lllllllllllllIlllIlIllIlllIlIIlI;
        final float lllllllllllllIlllIlIllIlllIlIlIl = (lllllllllllllIlllIlIllIllllIIIIl + lllllllllllllIlllIlIllIlllIllllI + lllllllllllllIlllIlIllIlllIllIll + lllllllllllllIlllIlIllIlllIllIII) * 0.25f - lllllllllllllIlllIlIllIlllIlIIIl;
        final float lllllllllllllIlllIlIllIlllIlIlII = (lllllllllllllIlllIlIllIllllIIIII + lllllllllllllIlllIlIllIlllIlllIl + lllllllllllllIlllIlIllIlllIllIlI + lllllllllllllIlllIlIllIlllIlIlll) * 0.25f - lllllllllllllIlllIlIllIlllIlIIII;
        return lllllllllllllIlllIlIllIlllIlIllI * lllllllllllllIlllIlIllIlllIlIllI + lllllllllllllIlllIlIllIlllIlIlIl * lllllllllllllIlllIlIllIlllIlIlIl + lllllllllllllIlllIlIllIlllIlIlII * lllllllllllllIlllIlIllIlllIlIlII;
    }
    
    public void setBlockLayer(final BlockRenderLayer lllllllllllllIlllIlIlIlllllllIlI) {
        this.blockLayer = lllllllllllllIlllIlIlIlllllllIlI;
        if (lllllllllllllIlllIlIlIlllllllIlI == null) {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
            this.quadSprite = null;
        }
    }
    
    public void addVertexData(final int[] lllllllllllllIlllIlIllIIllIIlIIl) {
        if (Config.isShaders()) {
            SVertexBuilder.beginAddVertexData(this, lllllllllllllIlllIlIllIIllIIlIIl);
        }
        this.growBuffer(lllllllllllllIlllIlIllIIllIIlIIl.length * 4);
        this.rawIntBuffer.position(this.getBufferSize());
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIIllIIlIIl);
        this.vertexCount += lllllllllllllIlllIlIllIIllIIlIIl.length / this.vertexFormat.getIntegerSize();
        if (Config.isShaders()) {
            SVertexBuilder.endAddVertexData(this);
        }
    }
    
    public double getZOffset() {
        return this.zOffset;
    }
    
    public void setSprite(final TextureAtlasSprite lllllllllllllIlllIlIllIIIlIIIlll) {
        if (this.quadSprites != null) {
            this.quadSprite = lllllllllllllIlllIlIllIIIlIIIlll;
        }
    }
    
    public void drawMultiTexture() {
        if (this.quadSprites != null) {
            final int lllllllllllllIlllIlIllIIIIlllIII = Config.getMinecraft().getTextureMapBlocks().getCountRegisteredSprites();
            if (this.drawnIcons.length <= lllllllllllllIlllIlIllIIIIlllIII) {
                this.drawnIcons = new boolean[lllllllllllllIlllIlIllIIIIlllIII + 1];
            }
            Arrays.fill(this.drawnIcons, false);
            int lllllllllllllIlllIlIllIIIIllIlll = 0;
            int lllllllllllllIlllIlIllIIIIllIllI = -1;
            for (int lllllllllllllIlllIlIllIIIIllIlIl = this.vertexCount / 4, lllllllllllllIlllIlIllIIIIllIlII = 0; lllllllllllllIlllIlIllIIIIllIlII < lllllllllllllIlllIlIllIIIIllIlIl; ++lllllllllllllIlllIlIllIIIIllIlII) {
                final TextureAtlasSprite lllllllllllllIlllIlIllIIIIllIIll = this.quadSprites[lllllllllllllIlllIlIllIIIIllIlII];
                if (lllllllllllllIlllIlIllIIIIllIIll != null) {
                    final int lllllllllllllIlllIlIllIIIIllIIlI = lllllllllllllIlllIlIllIIIIllIIll.getIndexInMap();
                    if (!this.drawnIcons[lllllllllllllIlllIlIllIIIIllIIlI]) {
                        if (lllllllllllllIlllIlIllIIIIllIIll == TextureUtils.iconGrassSideOverlay) {
                            if (lllllllllllllIlllIlIllIIIIllIllI < 0) {
                                lllllllllllllIlllIlIllIIIIllIllI = lllllllllllllIlllIlIllIIIIllIlII;
                            }
                        }
                        else {
                            lllllllllllllIlllIlIllIIIIllIlII = this.drawForIcon(lllllllllllllIlllIlIllIIIIllIIll, lllllllllllllIlllIlIllIIIIllIlII) - 1;
                            ++lllllllllllllIlllIlIllIIIIllIlll;
                            if (this.blockLayer != BlockRenderLayer.TRANSLUCENT) {
                                this.drawnIcons[lllllllllllllIlllIlIllIIIIllIIlI] = true;
                            }
                        }
                    }
                }
            }
            if (lllllllllllllIlllIlIllIIIIllIllI >= 0) {
                this.drawForIcon(TextureUtils.iconGrassSideOverlay, lllllllllllllIlllIlIllIIIIllIllI);
                ++lllllllllllllIlllIlIllIIIIllIlll;
            }
            if (lllllllllllllIlllIlIllIIIIllIlll > 0) {}
        }
    }
    
    public void setTranslation(final double lllllllllllllIlllIlIllIIIlllllIl, final double lllllllllllllIlllIlIllIIIlllllII, final double lllllllllllllIlllIlIllIIIllllIll) {
        this.xOffset = lllllllllllllIlllIlIllIIIlllllIl;
        this.yOffset = lllllllllllllIlllIlIllIIIlllllII;
        this.zOffset = lllllllllllllIlllIlIllIIIllllIll;
    }
    
    public BufferBuilder color(final int lllllllllllllIlllIlIllIIlllIIIll) {
        return this.color(lllllllllllllIlllIlIllIIlllIIIll >> 16 & 0xFF, lllllllllllllIlllIlIllIIlllIIIll >> 8 & 0xFF, lllllllllllllIlllIlIllIIlllIIIll & 0xFF, lllllllllllllIlllIlIllIIlllIIIll >> 24 & 0xFF);
    }
    
    public void putColorMultiplier(final float lllllllllllllIlllIlIllIlIlIIIIII, final float lllllllllllllIlllIlIllIlIIllllll, final float lllllllllllllIlllIlIllIlIIlllllI, final int lllllllllllllIlllIlIllIlIIllllIl) {
        final int lllllllllllllIlllIlIllIlIlIIlIIl = this.getColorIndex(lllllllllllllIlllIlIllIlIIllllIl);
        int lllllllllllllIlllIlIllIlIlIIlIII = -1;
        if (!this.noColor) {
            lllllllllllllIlllIlIllIlIlIIlIII = this.rawIntBuffer.get(lllllllllllllIlllIlIllIlIlIIlIIl);
            if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                final int lllllllllllllIlllIlIllIlIlIIIlll = (int)((lllllllllllllIlllIlIllIlIlIIlIII & 0xFF) * lllllllllllllIlllIlIllIlIlIIIIII);
                final int lllllllllllllIlllIlIllIlIlIIIllI = (int)((lllllllllllllIlllIlIllIlIlIIlIII >> 8 & 0xFF) * lllllllllllllIlllIlIllIlIIllllll);
                final int lllllllllllllIlllIlIllIlIlIIIlIl = (int)((lllllllllllllIlllIlIllIlIlIIlIII >> 16 & 0xFF) * lllllllllllllIlllIlIllIlIIlllllI);
                lllllllllllllIlllIlIllIlIlIIlIII &= 0xFF000000;
                lllllllllllllIlllIlIllIlIlIIlIII = (lllllllllllllIlllIlIllIlIlIIlIII | lllllllllllllIlllIlIllIlIlIIIlIl << 16 | lllllllllllllIlllIlIllIlIlIIIllI << 8 | lllllllllllllIlllIlIllIlIlIIIlll);
            }
            else {
                final int lllllllllllllIlllIlIllIlIlIIIlII = (int)((lllllllllllllIlllIlIllIlIlIIlIII >> 24 & 0xFF) * lllllllllllllIlllIlIllIlIlIIIIII);
                final int lllllllllllllIlllIlIllIlIlIIIIll = (int)((lllllllllllllIlllIlIllIlIlIIlIII >> 16 & 0xFF) * lllllllllllllIlllIlIllIlIIllllll);
                final int lllllllllllllIlllIlIllIlIlIIIIlI = (int)((lllllllllllllIlllIlIllIlIlIIlIII >> 8 & 0xFF) * lllllllllllllIlllIlIllIlIIlllllI);
                lllllllllllllIlllIlIllIlIlIIlIII &= 0xFF;
                lllllllllllllIlllIlIllIlIlIIlIII = (lllllllllllllIlllIlIllIlIlIIlIII | lllllllllllllIlllIlIllIlIlIIIlII << 24 | lllllllllllllIlllIlIllIlIlIIIIll << 16 | lllllllllllllIlllIlIllIlIlIIIIlI << 8);
            }
        }
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIlIlIIlIIl, lllllllllllllIlllIlIllIlIlIIlIII);
    }
    
    public void endVertex() {
        ++this.vertexCount;
        this.growBuffer(this.vertexFormat.getNextOffset());
        this.vertexFormatIndex = 0;
        this.vertexFormatElement = this.vertexFormat.getElement(this.vertexFormatIndex);
        if (Config.isShaders()) {
            SVertexBuilder.endAddVertex(this);
        }
    }
    
    private int getBufferQuadSize() {
        final int lllllllllllllIlllIlIlIllllllIllI = this.rawIntBuffer.capacity() * 4 / (this.vertexFormat.getIntegerSize() * 4);
        return lllllllllllllIlllIlIlIllllllIllI;
    }
    
    public void begin(final int lllllllllllllIlllIlIllIllIlIlIll, final VertexFormat lllllllllllllIlllIlIllIllIlIllIl) {
        if (this.isDrawing) {
            throw new IllegalStateException("Already building!");
        }
        this.isDrawing = true;
        this.reset();
        this.drawMode = lllllllllllllIlllIlIllIllIlIlIll;
        this.vertexFormat = lllllllllllllIlllIlIllIllIlIllIl;
        this.vertexFormatElement = lllllllllllllIlllIlIllIllIlIllIl.getElement(this.vertexFormatIndex);
        this.noColor = false;
        this.byteBuffer.limit(this.byteBuffer.capacity());
        if (Config.isShaders()) {
            SVertexBuilder.endSetVertexFormat(this);
        }
        if (Config.isMultiTexture()) {
            if (this.blockLayer != null) {
                if (this.quadSprites == null) {
                    this.quadSprites = this.quadSpritesPrev;
                }
                if (this.quadSprites == null || this.quadSprites.length < this.getBufferQuadSize()) {
                    this.quadSprites = new TextureAtlasSprite[this.getBufferQuadSize()];
                }
            }
        }
        else {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
        }
    }
    
    public void noColor() {
        this.noColor = true;
    }
    
    public int getVertexCount() {
        return this.vertexCount;
    }
    
    public void finishDrawing() {
        if (!this.isDrawing) {
            throw new IllegalStateException("Not building!");
        }
        this.isDrawing = false;
        this.byteBuffer.position(0);
        this.byteBuffer.limit(this.getBufferSize() * 4);
    }
    
    private void func_192836_a(final int lllllllllllllIlllIlIllIlIIlIlIII, final int lllllllllllllIlllIlIllIlIIlIlllI) {
        final int lllllllllllllIlllIlIllIlIIlIllIl = this.getColorIndex(lllllllllllllIlllIlIllIlIIlIlllI);
        final int lllllllllllllIlllIlIllIlIIlIllII = lllllllllllllIlllIlIllIlIIlIlIII >> 16 & 0xFF;
        final int lllllllllllllIlllIlIllIlIIlIlIll = lllllllllllllIlllIlIllIlIIlIlIII >> 8 & 0xFF;
        final int lllllllllllllIlllIlIllIlIIlIlIlI = lllllllllllllIlllIlIllIlIIlIlIII & 0xFF;
        this.putColorRGBA(lllllllllllllIlllIlIllIlIIlIllIl, lllllllllllllIlllIlIllIlIIlIllII, lllllllllllllIlllIlIllIlIIlIlIll, lllllllllllllIlllIlIllIlIIlIlIlI);
    }
    
    public void putBrightness4(final int lllllllllllllIlllIlIllIllIIIlIIl, final int lllllllllllllIlllIlIllIllIIIIIIl, final int lllllllllllllIlllIlIllIllIIIIIII, final int lllllllllllllIlllIlIllIllIIIIllI) {
        final int lllllllllllllIlllIlIllIllIIIIlIl = (this.vertexCount - 4) * this.vertexFormat.getIntegerSize() + this.vertexFormat.getUvOffsetById(1) / 4;
        final int lllllllllllllIlllIlIllIllIIIIlII = this.vertexFormat.getNextOffset() >> 2;
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIllIIIIlIl, lllllllllllllIlllIlIllIllIIIlIIl);
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIllIIIIlIl + lllllllllllllIlllIlIllIllIIIIlII, lllllllllllllIlllIlIllIllIIIIIIl);
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIllIIIIlIl + lllllllllllllIlllIlIllIllIIIIlII * 2, lllllllllllllIlllIlIllIllIIIIIII);
        this.rawIntBuffer.put(lllllllllllllIlllIlIllIllIIIIlIl + lllllllllllllIlllIlIllIllIIIIlII * 3, lllllllllllllIlllIlIllIllIIIIllI);
    }
    
    public void putPosition(final double lllllllllllllIlllIlIllIlIllIIlll, final double lllllllllllllIlllIlIllIlIllIIllI, final double lllllllllllllIlllIlIllIlIllIIlIl) {
        final int lllllllllllllIlllIlIllIlIllIlllI = this.vertexFormat.getIntegerSize();
        final int lllllllllllllIlllIlIllIlIllIllIl = (this.vertexCount - 4) * lllllllllllllIlllIlIllIlIllIlllI;
        for (int lllllllllllllIlllIlIllIlIllIllII = 0; lllllllllllllIlllIlIllIlIllIllII < 4; ++lllllllllllllIlllIlIllIlIllIllII) {
            final int lllllllllllllIlllIlIllIlIllIlIll = lllllllllllllIlllIlIllIlIllIllIl + lllllllllllllIlllIlIllIlIllIllII * lllllllllllllIlllIlIllIlIllIlllI;
            final int lllllllllllllIlllIlIllIlIllIlIlI = lllllllllllllIlllIlIllIlIllIlIll + 1;
            final int lllllllllllllIlllIlIllIlIllIlIIl = lllllllllllllIlllIlIllIlIllIlIlI + 1;
            this.rawIntBuffer.put(lllllllllllllIlllIlIllIlIllIlIll, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIllIlIllIIlll + this.xOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(lllllllllllllIlllIlIllIlIllIlIll))));
            this.rawIntBuffer.put(lllllllllllllIlllIlIllIlIllIlIlI, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIllIlIllIIllI + this.yOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(lllllllllllllIlllIlIllIlIllIlIlI))));
            this.rawIntBuffer.put(lllllllllllllIlllIlIllIlIllIlIIl, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIllIlIllIIlIl + this.zOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(lllllllllllllIlllIlIllIlIllIlIIl))));
        }
    }
    
    public BufferBuilder pos(final double lllllllllllllIlllIlIllIIlIlllIlI, final double lllllllllllllIlllIlIllIIlIlllllI, final double lllllllllllllIlllIlIllIIlIlllIII) {
        if (Config.isShaders()) {
            SVertexBuilder.beginAddVertex(this);
        }
        final int lllllllllllllIlllIlIllIIlIllllII = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
            case 1: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIlIllllII, (float)(lllllllllllllIlllIlIllIIlIlllIlI + this.xOffset));
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIlIllllII + 4, (float)(lllllllllllllIlllIlIllIIlIlllllI + this.yOffset));
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIlIllllII + 8, (float)(lllllllllllllIlllIlIllIIlIlllIII + this.zOffset));
                break;
            }
            case 6:
            case 7: {
                this.byteBuffer.putInt(lllllllllllllIlllIlIllIIlIllllII, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIllIIlIlllIlI + this.xOffset)));
                this.byteBuffer.putInt(lllllllllllllIlllIlIllIIlIllllII + 4, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIllIIlIlllllI + this.yOffset)));
                this.byteBuffer.putInt(lllllllllllllIlllIlIllIIlIllllII + 8, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIllIIlIlllIII + this.zOffset)));
                break;
            }
            case 4:
            case 5: {
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIIlIllllII, (short)(lllllllllllllIlllIlIllIIlIlllIlI + this.xOffset));
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIIlIllllII + 2, (short)(lllllllllllllIlllIlIllIIlIlllllI + this.yOffset));
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIIlIllllII + 4, (short)(lllllllllllllIlllIlIllIIlIlllIII + this.zOffset));
                break;
            }
            case 2:
            case 3: {
                this.byteBuffer.put(lllllllllllllIlllIlIllIIlIllllII, (byte)(lllllllllllllIlllIlIllIIlIlllIlI + this.xOffset));
                this.byteBuffer.put(lllllllllllllIlllIlIllIIlIllllII + 1, (byte)(lllllllllllllIlllIlIllIIlIlllllI + this.yOffset));
                this.byteBuffer.put(lllllllllllllIlllIlIllIIlIllllII + 2, (byte)(lllllllllllllIlllIlIllIIlIlllIII + this.zOffset));
                break;
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }
    
    public void putSprite(final TextureAtlasSprite lllllllllllllIlllIlIllIIIlIIllll) {
        if (this.quadSprites != null) {
            final int lllllllllllllIlllIlIllIIIlIIlllI = this.vertexCount / 4;
            this.quadSprites[lllllllllllllIlllIlIllIIIlIIlllI - 1] = lllllllllllllIlllIlIllIIIlIIllll;
        }
    }
    
    public BufferBuilder color(final int lllllllllllllIlllIlIllIIllIllIIl, final int lllllllllllllIlllIlIllIIllIlIIlI, final int lllllllllllllIlllIlIllIIllIlIlll, final int lllllllllllllIlllIlIllIIllIlIIII) {
        if (this.noColor) {
            return this;
        }
        final int lllllllllllllIlllIlIllIIllIlIlIl = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
            case 1: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIllIlIlIl, lllllllllllllIlllIlIllIIllIllIIl / 255.0f);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIllIlIlIl + 4, lllllllllllllIlllIlIllIIllIlIIlI / 255.0f);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIllIlIlIl + 8, lllllllllllllIlllIlIllIIllIlIlll / 255.0f);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIllIlIlIl + 12, lllllllllllllIlllIlIllIIllIlIIII / 255.0f);
                break;
            }
            case 6:
            case 7: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIllIlIlIl, (float)lllllllllllllIlllIlIllIIllIllIIl);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIllIlIlIl + 4, (float)lllllllllllllIlllIlIllIIllIlIIlI);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIllIlIlIl + 8, (float)lllllllllllllIlllIlIllIIllIlIlll);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIllIIllIlIlIl + 12, (float)lllllllllllllIlllIlIllIIllIlIIII);
                break;
            }
            case 4:
            case 5: {
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIIllIlIlIl, (short)lllllllllllllIlllIlIllIIllIllIIl);
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIIllIlIlIl + 2, (short)lllllllllllllIlllIlIllIIllIlIIlI);
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIIllIlIlIl + 4, (short)lllllllllllllIlllIlIllIIllIlIlll);
                this.byteBuffer.putShort(lllllllllllllIlllIlIllIIllIlIlIl + 6, (short)lllllllllllllIlllIlIllIIllIlIIII);
                break;
            }
            case 2:
            case 3: {
                if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                    this.byteBuffer.put(lllllllllllllIlllIlIllIIllIlIlIl, (byte)lllllllllllllIlllIlIllIIllIllIIl);
                    this.byteBuffer.put(lllllllllllllIlllIlIllIIllIlIlIl + 1, (byte)lllllllllllllIlllIlIllIIllIlIIlI);
                    this.byteBuffer.put(lllllllllllllIlllIlIllIIllIlIlIl + 2, (byte)lllllllllllllIlllIlIllIIllIlIlll);
                    this.byteBuffer.put(lllllllllllllIlllIlIllIIllIlIlIl + 3, (byte)lllllllllllllIlllIlIllIIllIlIIII);
                    break;
                }
                this.byteBuffer.put(lllllllllllllIlllIlIllIIllIlIlIl, (byte)lllllllllllllIlllIlIllIIllIlIIII);
                this.byteBuffer.put(lllllllllllllIlllIlIllIIllIlIlIl + 1, (byte)lllllllllllllIlllIlIllIIllIlIlll);
                this.byteBuffer.put(lllllllllllllIlllIlIllIIllIlIlIl + 2, (byte)lllllllllllllIlllIlIllIIllIlIIlI);
                this.byteBuffer.put(lllllllllllllIlllIlIllIIllIlIlIl + 3, (byte)lllllllllllllIlllIlIllIIllIllIIl);
                break;
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }
    
    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }
    
    public class State
    {
        private final /* synthetic */ int[] stateRawBuffer;
        private final /* synthetic */ VertexFormat stateVertexFormat;
        private /* synthetic */ TextureAtlasSprite[] stateQuadSprites;
        
        public State(final int[] llllllllllIlllIIIlIIIlIlIIIIlIlI, final VertexFormat llllllllllIlllIIIlIIIlIlIIIIlIIl, final TextureAtlasSprite[] llllllllllIlllIIIlIIIlIlIIIIlIII) {
            this.stateRawBuffer = llllllllllIlllIIIlIIIlIlIIIIlIlI;
            this.stateVertexFormat = llllllllllIlllIIIlIIIlIlIIIIlIIl;
            this.stateQuadSprites = llllllllllIlllIIIlIIIlIlIIIIlIII;
        }
        
        public int getVertexCount() {
            return this.stateRawBuffer.length / this.stateVertexFormat.getIntegerSize();
        }
        
        public State(final int[] llllllllllIlllIIIlIIIlIIlllllllI, final VertexFormat llllllllllIlllIIIlIIIlIIllllllIl) {
            this.stateRawBuffer = llllllllllIlllIIIlIIIlIIlllllllI;
            this.stateVertexFormat = llllllllllIlllIIIlIIIlIIllllllIl;
        }
        
        public VertexFormat getVertexFormat() {
            return this.stateVertexFormat;
        }
        
        public int[] getRawBuffer() {
            return this.stateRawBuffer;
        }
    }
}
