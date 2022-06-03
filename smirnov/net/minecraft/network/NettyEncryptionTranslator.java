// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import io.netty.channel.ChannelHandlerContext;
import javax.crypto.ShortBufferException;
import io.netty.buffer.ByteBuf;
import javax.crypto.Cipher;

public class NettyEncryptionTranslator
{
    private /* synthetic */ byte[] outputBuffer;
    private /* synthetic */ byte[] inputBuffer;
    private final /* synthetic */ Cipher cipher;
    
    protected void cipher(final ByteBuf llllllllllllIIIIIllIlIIlIIllIlIl, final ByteBuf llllllllllllIIIIIllIlIIlIIllIlII) throws ShortBufferException {
        final int llllllllllllIIIIIllIlIIlIIlllIIl = llllllllllllIIIIIllIlIIlIIllIlIl.readableBytes();
        final byte[] llllllllllllIIIIIllIlIIlIIlllIII = this.bufToBytes(llllllllllllIIIIIllIlIIlIIllIlIl);
        final int llllllllllllIIIIIllIlIIlIIllIlll = this.cipher.getOutputSize(llllllllllllIIIIIllIlIIlIIlllIIl);
        if (this.outputBuffer.length < llllllllllllIIIIIllIlIIlIIllIlll) {
            this.outputBuffer = new byte[llllllllllllIIIIIllIlIIlIIllIlll];
        }
        llllllllllllIIIIIllIlIIlIIllIlII.writeBytes(this.outputBuffer, 0, this.cipher.update(llllllllllllIIIIIllIlIIlIIlllIII, 0, llllllllllllIIIIIllIlIIlIIlllIIl, this.outputBuffer));
    }
    
    protected NettyEncryptionTranslator(final Cipher llllllllllllIIIIIllIlIIlIlIllllI) {
        this.inputBuffer = new byte[0];
        this.outputBuffer = new byte[0];
        this.cipher = llllllllllllIIIIIllIlIIlIlIllllI;
    }
    
    private byte[] bufToBytes(final ByteBuf llllllllllllIIIIIllIlIIlIlIlIllI) {
        final int llllllllllllIIIIIllIlIIlIlIllIII = llllllllllllIIIIIllIlIIlIlIlIllI.readableBytes();
        if (this.inputBuffer.length < llllllllllllIIIIIllIlIIlIlIllIII) {
            this.inputBuffer = new byte[llllllllllllIIIIIllIlIIlIlIllIII];
        }
        llllllllllllIIIIIllIlIIlIlIlIllI.readBytes(this.inputBuffer, 0, llllllllllllIIIIIllIlIIlIlIllIII);
        return this.inputBuffer;
    }
    
    protected ByteBuf decipher(final ChannelHandlerContext llllllllllllIIIIIllIlIIlIlIIllIl, final ByteBuf llllllllllllIIIIIllIlIIlIlIIllII) throws ShortBufferException {
        final int llllllllllllIIIIIllIlIIlIlIIlIll = llllllllllllIIIIIllIlIIlIlIIllII.readableBytes();
        final byte[] llllllllllllIIIIIllIlIIlIlIIlIlI = this.bufToBytes(llllllllllllIIIIIllIlIIlIlIIllII);
        final ByteBuf llllllllllllIIIIIllIlIIlIlIIlIIl = llllllllllllIIIIIllIlIIlIlIIllIl.alloc().heapBuffer(this.cipher.getOutputSize(llllllllllllIIIIIllIlIIlIlIIlIll));
        llllllllllllIIIIIllIlIIlIlIIlIIl.writerIndex(this.cipher.update(llllllllllllIIIIIllIlIIlIlIIlIlI, 0, llllllllllllIIIIIllIlIIlIlIIlIll, llllllllllllIIIIIllIlIIlIlIIlIIl.array(), llllllllllllIIIIIllIlIIlIlIIlIIl.arrayOffset()));
        return llllllllllllIIIIIllIlIIlIlIIlIIl;
    }
}
