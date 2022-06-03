// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import java.util.zip.DataFormatException;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderException;
import java.util.List;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.zip.Inflater;
import io.netty.handler.codec.ByteToMessageDecoder;

public class NettyCompressionDecoder extends ByteToMessageDecoder
{
    private final /* synthetic */ Inflater inflater;
    private /* synthetic */ int threshold;
    
    public NettyCompressionDecoder(final int lllllllllllllllIIllIlIlllIlIllll) {
        this.threshold = lllllllllllllllIIllIlIlllIlIllll;
        this.inflater = new Inflater();
    }
    
    protected void decode(final ChannelHandlerContext lllllllllllllllIIllIlIlllIlIIlII, final ByteBuf lllllllllllllllIIllIlIlllIIlllII, final List<Object> lllllllllllllllIIllIlIlllIIllIll) throws DataFormatException, Exception {
        if (lllllllllllllllIIllIlIlllIIlllII.readableBytes() != 0) {
            final PacketBuffer lllllllllllllllIIllIlIlllIlIIIIl = new PacketBuffer(lllllllllllllllIIllIlIlllIIlllII);
            final int lllllllllllllllIIllIlIlllIlIIIII = lllllllllllllllIIllIlIlllIlIIIIl.readVarIntFromBuffer();
            if (lllllllllllllllIIllIlIlllIlIIIII == 0) {
                lllllllllllllllIIllIlIlllIIllIll.add(lllllllllllllllIIllIlIlllIlIIIIl.readBytes(lllllllllllllllIIllIlIlllIlIIIIl.readableBytes()));
            }
            else {
                if (lllllllllllllllIIllIlIlllIlIIIII < this.threshold) {
                    throw new DecoderException("Badly compressed packet - size of " + lllllllllllllllIIllIlIlllIlIIIII + " is below server threshold of " + this.threshold);
                }
                if (lllllllllllllllIIllIlIlllIlIIIII > 2097152) {
                    throw new DecoderException("Badly compressed packet - size of " + lllllllllllllllIIllIlIlllIlIIIII + " is larger than protocol maximum of " + 2097152);
                }
                final byte[] lllllllllllllllIIllIlIlllIIlllll = new byte[lllllllllllllllIIllIlIlllIlIIIIl.readableBytes()];
                lllllllllllllllIIllIlIlllIlIIIIl.readBytes(lllllllllllllllIIllIlIlllIIlllll);
                this.inflater.setInput(lllllllllllllllIIllIlIlllIIlllll);
                final byte[] lllllllllllllllIIllIlIlllIIllllI = new byte[lllllllllllllllIIllIlIlllIlIIIII];
                this.inflater.inflate(lllllllllllllllIIllIlIlllIIllllI);
                lllllllllllllllIIllIlIlllIIllIll.add(Unpooled.wrappedBuffer(lllllllllllllllIIllIlIlllIIllllI));
                this.inflater.reset();
            }
        }
    }
    
    public void setCompressionThreshold(final int lllllllllllllllIIllIlIlllIIlIIll) {
        this.threshold = lllllllllllllllIIllIlIlllIIlIIll;
    }
}
