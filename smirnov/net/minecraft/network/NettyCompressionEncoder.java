// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import io.netty.channel.ChannelHandlerContext;
import java.util.zip.Deflater;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToByteEncoder;

public class NettyCompressionEncoder extends MessageToByteEncoder<ByteBuf>
{
    private /* synthetic */ int threshold;
    private final /* synthetic */ byte[] buffer;
    private final /* synthetic */ Deflater deflater;
    
    public NettyCompressionEncoder(final int lllllllllllIIllIIIIIIIIIllIIIIll) {
        this.buffer = new byte[8192];
        this.threshold = lllllllllllIIllIIIIIIIIIllIIIIll;
        this.deflater = new Deflater();
    }
    
    public void setCompressionThreshold(final int lllllllllllIIllIIIIIIIIIlIlIIlll) {
        this.threshold = lllllllllllIIllIIIIIIIIIlIlIIlll;
    }
    
    protected void encode(final ChannelHandlerContext lllllllllllIIllIIIIIIIIIlIlllIlI, final ByteBuf lllllllllllIIllIIIIIIIIIlIllIIlI, final ByteBuf lllllllllllIIllIIIIIIIIIlIllIIIl) throws Exception {
        final int lllllllllllIIllIIIIIIIIIlIllIlll = lllllllllllIIllIIIIIIIIIlIllIIlI.readableBytes();
        final PacketBuffer lllllllllllIIllIIIIIIIIIlIllIllI = new PacketBuffer(lllllllllllIIllIIIIIIIIIlIllIIIl);
        if (lllllllllllIIllIIIIIIIIIlIllIlll < this.threshold) {
            lllllllllllIIllIIIIIIIIIlIllIllI.writeVarIntToBuffer(0);
            lllllllllllIIllIIIIIIIIIlIllIllI.writeBytes(lllllllllllIIllIIIIIIIIIlIllIIlI);
        }
        else {
            final byte[] lllllllllllIIllIIIIIIIIIlIllIlIl = new byte[lllllllllllIIllIIIIIIIIIlIllIlll];
            lllllllllllIIllIIIIIIIIIlIllIIlI.readBytes(lllllllllllIIllIIIIIIIIIlIllIlIl);
            lllllllllllIIllIIIIIIIIIlIllIllI.writeVarIntToBuffer(lllllllllllIIllIIIIIIIIIlIllIlIl.length);
            this.deflater.setInput(lllllllllllIIllIIIIIIIIIlIllIlIl, 0, lllllllllllIIllIIIIIIIIIlIllIlll);
            this.deflater.finish();
            while (!this.deflater.finished()) {
                final int lllllllllllIIllIIIIIIIIIlIllIlII = this.deflater.deflate(this.buffer);
                lllllllllllIIllIIIIIIIIIlIllIllI.writeBytes(this.buffer, 0, lllllllllllIIllIIIIIIIIIlIllIlII);
            }
            this.deflater.reset();
        }
    }
}
