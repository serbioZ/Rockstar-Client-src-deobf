// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.GameType;
import net.minecraft.world.WorldType;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketJoinGame implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ WorldType worldType;
    private /* synthetic */ int playerId;
    private /* synthetic */ int maxPlayers;
    private /* synthetic */ GameType gameType;
    private /* synthetic */ boolean hardcoreMode;
    private /* synthetic */ EnumDifficulty difficulty;
    private /* synthetic */ int dimension;
    private /* synthetic */ boolean reducedDebugInfo;
    
    public SPacketJoinGame() {
    }
    
    public boolean isHardcoreMode() {
        return this.hardcoreMode;
    }
    
    public EnumDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    public boolean isReducedDebugInfo() {
        return this.reducedDebugInfo;
    }
    
    public SPacketJoinGame(final int llllllllllllllIlllIIIIIllIIllIlI, final GameType llllllllllllllIlllIIIIIllIIlIIII, final boolean llllllllllllllIlllIIIIIllIIllIII, final int llllllllllllllIlllIIIIIllIIIlllI, final EnumDifficulty llllllllllllllIlllIIIIIllIIlIllI, final int llllllllllllllIlllIIIIIllIIIllII, final WorldType llllllllllllllIlllIIIIIllIIIlIll, final boolean llllllllllllllIlllIIIIIllIIIlIlI) {
        this.playerId = llllllllllllllIlllIIIIIllIIllIlI;
        this.dimension = llllllllllllllIlllIIIIIllIIIlllI;
        this.difficulty = llllllllllllllIlllIIIIIllIIlIllI;
        this.gameType = llllllllllllllIlllIIIIIllIIlIIII;
        this.maxPlayers = llllllllllllllIlllIIIIIllIIIllII;
        this.hardcoreMode = llllllllllllllIlllIIIIIllIIllIII;
        this.worldType = llllllllllllllIlllIIIIIllIIIlIll;
        this.reducedDebugInfo = llllllllllllllIlllIIIIIllIIIlIlI;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlllIIIIIlIlllllII) throws IOException {
        llllllllllllllIlllIIIIIlIlllllII.writeInt(this.playerId);
        int llllllllllllllIlllIIIIIlIllllIll = this.gameType.getID();
        if (this.hardcoreMode) {
            llllllllllllllIlllIIIIIlIllllIll |= 0x8;
        }
        llllllllllllllIlllIIIIIlIlllllII.writeByte(llllllllllllllIlllIIIIIlIllllIll);
        llllllllllllllIlllIIIIIlIlllllII.writeInt(this.dimension);
        llllllllllllllIlllIIIIIlIlllllII.writeByte(this.difficulty.getDifficultyId());
        llllllllllllllIlllIIIIIlIlllllII.writeByte(this.maxPlayers);
        llllllllllllllIlllIIIIIlIlllllII.writeString(this.worldType.getWorldTypeName());
        llllllllllllllIlllIIIIIlIlllllII.writeBoolean(this.reducedDebugInfo);
    }
    
    public GameType getGameType() {
        return this.gameType;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlllIIIIIllIIIIlIl) throws IOException {
        this.playerId = llllllllllllllIlllIIIIIllIIIIlIl.readInt();
        int llllllllllllllIlllIIIIIllIIIIlII = llllllllllllllIlllIIIIIllIIIIlIl.readUnsignedByte();
        this.hardcoreMode = ((llllllllllllllIlllIIIIIllIIIIlII & 0x8) == 0x8);
        llllllllllllllIlllIIIIIllIIIIlII &= 0xFFFFFFF7;
        this.gameType = GameType.getByID(llllllllllllllIlllIIIIIllIIIIlII);
        this.dimension = llllllllllllllIlllIIIIIllIIIIlIl.readInt();
        this.difficulty = EnumDifficulty.getDifficultyEnum(llllllllllllllIlllIIIIIllIIIIlIl.readUnsignedByte());
        this.maxPlayers = llllllllllllllIlllIIIIIllIIIIlIl.readUnsignedByte();
        this.worldType = WorldType.parseWorldType(llllllllllllllIlllIIIIIllIIIIlIl.readStringFromBuffer(16));
        if (this.worldType == null) {
            this.worldType = WorldType.DEFAULT;
        }
        this.reducedDebugInfo = llllllllllllllIlllIIIIIllIIIIlIl.readBoolean();
    }
    
    public WorldType getWorldType() {
        return this.worldType;
    }
    
    public int getPlayerId() {
        return this.playerId;
    }
    
    public int getMaxPlayers() {
        return this.maxPlayers;
    }
    
    public int getDimension() {
        return this.dimension;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlllIIIIIlIlllIlII) {
        llllllllllllllIlllIIIIIlIlllIlII.handleJoinGame(this);
    }
}
