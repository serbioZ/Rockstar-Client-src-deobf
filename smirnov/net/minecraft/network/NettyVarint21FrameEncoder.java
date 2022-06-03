// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.Sharable
public class NettyVarint21FrameEncoder extends MessageToByteEncoder<ByteBuf>
{
    protected void encode(final ChannelHandlerContext llllllllllllIIlIIlIlIIIIlIIIlIIl, final ByteBuf llllllllllllIIlIIlIlIIIIlIIIlIII, final ByteBuf llllllllllllIIlIIlIlIIIIlIIIIlll) throws Exception {
        final int llllllllllllIIlIIlIlIIIIlIIIIllI = llllllllllllIIlIIlIlIIIIlIIIlIII.readableBytes();
        final int llllllllllllIIlIIlIlIIIIlIIIIlIl = PacketBuffer.getVarIntSize(llllllllllllIIlIIlIlIIIIlIIIIllI);
        if (llllllllllllIIlIIlIlIIIIlIIIIlIl > 3) {
            throw new IllegalArgumentException("unable to fit " + llllllllllllIIlIIlIlIIIIlIIIIllI + " into " + 3);
        }
        final PacketBuffer llllllllllllIIlIIlIlIIIIlIIIIlII = new PacketBuffer(llllllllllllIIlIIlIlIIIIlIIIIlll);
        llllllllllllIIlIIlIlIIIIlIIIIlII.ensureWritable(llllllllllllIIlIIlIlIIIIlIIIIlIl + llllllllllllIIlIIlIlIIIIlIIIIllI);
        llllllllllllIIlIIlIlIIIIlIIIIlII.writeVarIntToBuffer(llllllllllllIIlIIlIlIIIIlIIIIllI);
        llllllllllllIIlIIlIlIIIIlIIIIlII.writeBytes(llllllllllllIIlIIlIlIIIIlIIIlIII, llllllllllllIIlIIlIlIIIIlIIIlIII.readerIndex(), llllllllllllIIlIIlIlIIIIlIIIIllI);
    }
}
