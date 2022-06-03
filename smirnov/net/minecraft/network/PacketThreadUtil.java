// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import net.minecraft.util.IThreadListener;

public class PacketThreadUtil
{
    public static <T extends INetHandler> void checkThreadAndEnqueue(final Packet<T> lllllllllllIIIIIlIllllIIlIIlllIl, final T lllllllllllIIIIIlIllllIIlIIlllII, final IThreadListener lllllllllllIIIIIlIllllIIlIIllllI) throws ThreadQuickExitException {
        if (!lllllllllllIIIIIlIllllIIlIIllllI.isCallingFromMinecraftThread()) {
            lllllllllllIIIIIlIllllIIlIIllllI.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    lllllllllllIIIIIlIllllIIlIIlllIl.processPacket(lllllllllllIIIIIlIllllIIlIIlllII);
                }
            });
            throw ThreadQuickExitException.INSTANCE;
        }
    }
}
