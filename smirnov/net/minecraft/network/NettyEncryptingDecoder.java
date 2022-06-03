// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import javax.crypto.ShortBufferException;
import java.util.List;
import io.netty.channel.ChannelHandlerContext;
import javax.crypto.Cipher;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToMessageDecoder;

public class NettyEncryptingDecoder extends MessageToMessageDecoder<ByteBuf>
{
    private final /* synthetic */ NettyEncryptionTranslator decryptionCodec;
    
    public NettyEncryptingDecoder(final Cipher llllllllllllIIlllIIIlIIIIlllllII) {
        this.decryptionCodec = new NettyEncryptionTranslator(llllllllllllIIlllIIIlIIIIlllllII);
    }
    
    protected void decode(final ChannelHandlerContext llllllllllllIIlllIIIlIIIIlllIllI, final ByteBuf llllllllllllIIlllIIIlIIIIlllIlIl, final List<Object> llllllllllllIIlllIIIlIIIIlllIlII) throws Exception, ShortBufferException {
        llllllllllllIIlllIIIlIIIIlllIlII.add(this.decryptionCodec.decipher(llllllllllllIIlllIIIlIIIIlllIllI, llllllllllllIIlllIIIlIIIIlllIlIl));
    }
}
