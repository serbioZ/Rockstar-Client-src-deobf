// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketServerDifficulty implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ EnumDifficulty difficulty;
    private /* synthetic */ boolean difficultyLocked;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIlIllIIlllIllIlllI) throws IOException {
        lllllllllllllIIlIllIIlllIllIlllI.writeByte(this.difficulty.getDifficultyId());
    }
    
    public EnumDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    public SPacketServerDifficulty() {
    }
    
    public SPacketServerDifficulty(final EnumDifficulty lllllllllllllIIlIllIIlllIlllllll, final boolean lllllllllllllIIlIllIIlllIllllllI) {
        this.difficulty = lllllllllllllIIlIllIIlllIlllllll;
        this.difficultyLocked = lllllllllllllIIlIllIIlllIllllllI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIlIllIIlllIlllIlII) throws IOException {
        this.difficulty = EnumDifficulty.getDifficultyEnum(lllllllllllllIIlIllIIlllIlllIlII.readUnsignedByte());
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIlIllIIlllIllllIlI) {
        lllllllllllllIIlIllIIlllIllllIlI.handleServerDifficulty(this);
    }
    
    public boolean isDifficultyLocked() {
        return this.difficultyLocked;
    }
}
