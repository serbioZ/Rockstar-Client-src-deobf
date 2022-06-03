// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import io.netty.handler.codec.CorruptedFrameException;
import io.netty.buffer.Unpooled;
import java.util.List;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class NettyVarint21FrameDecoder extends ByteToMessageDecoder
{
    protected void decode(final ChannelHandlerContext lllllllllllIlllIllIllIllIIIlIlll, final ByteBuf lllllllllllIlllIllIllIllIIIlIIII, final List<Object> lllllllllllIlllIllIllIllIIIlIlIl) throws Exception {
        lllllllllllIlllIllIllIllIIIlIIII.markReaderIndex();
        final byte[] lllllllllllIlllIllIllIllIIIlIlII = new byte[3];
        for (int lllllllllllIlllIllIllIllIIIlIIll = 0; lllllllllllIlllIllIllIllIIIlIIll < lllllllllllIlllIllIllIllIIIlIlII.length; ++lllllllllllIlllIllIllIllIIIlIIll) {
            if (!lllllllllllIlllIllIllIllIIIlIIII.isReadable()) {
                lllllllllllIlllIllIllIllIIIlIIII.resetReaderIndex();
                return;
            }
            lllllllllllIlllIllIllIllIIIlIlII[lllllllllllIlllIllIllIllIIIlIIll] = lllllllllllIlllIllIllIllIIIlIIII.readByte();
            if (lllllllllllIlllIllIllIllIIIlIlII[lllllllllllIlllIllIllIllIIIlIIll] >= 0) {
                final PacketBuffer lllllllllllIlllIllIllIllIIIlIIlI = new PacketBuffer(Unpooled.wrappedBuffer(lllllllllllIlllIllIllIllIIIlIlII));
                try {
                    final int lllllllllllIlllIllIllIllIIIlIIIl = lllllllllllIlllIllIllIllIIIlIIlI.readVarIntFromBuffer();
                    if (lllllllllllIlllIllIllIllIIIlIIII.readableBytes() >= lllllllllllIlllIllIllIllIIIlIIIl) {
                        lllllllllllIlllIllIllIllIIIlIlIl.add(lllllllllllIlllIllIllIllIIIlIIII.readBytes(lllllllllllIlllIllIllIllIIIlIIIl));
                        return;
                    }
                    lllllllllllIlllIllIllIllIIIlIIII.resetReaderIndex();
                }
                finally {
                    lllllllllllIlllIllIllIllIIIlIIlI.release();
                }
                lllllllllllIlllIllIllIllIIIlIIlI.release();
                return;
            }
        }
        throw new CorruptedFrameException("length wider than 21-bit");
    }
}
