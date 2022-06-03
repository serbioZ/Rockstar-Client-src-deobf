// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToByteEncoder;

public class NettyEncryptingEncoder extends MessageToByteEncoder<ByteBuf>
{
    private final /* synthetic */ NettyEncryptionTranslator encryptionCodec;
    
    protected void encode(final ChannelHandlerContext llllllllllllIIIIllIIlllllllIIllI, final ByteBuf llllllllllllIIIIllIIlllllllIIlIl, final ByteBuf llllllllllllIIIIllIIlllllllIIIIl) throws Exception, ShortBufferException {
        this.encryptionCodec.cipher(llllllllllllIIIIllIIlllllllIIlIl, llllllllllllIIIIllIIlllllllIIIIl);
    }
    
    public NettyEncryptingEncoder(final Cipher llllllllllllIIIIllIIlllllllIllIl) {
        this.encryptionCodec = new NettyEncryptionTranslator(llllllllllllIIIIllIIlllllllIllIl);
    }
}
