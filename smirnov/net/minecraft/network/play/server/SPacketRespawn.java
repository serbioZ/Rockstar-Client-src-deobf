// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.WorldType;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.GameType;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketRespawn implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ GameType gameType;
    private /* synthetic */ int dimensionID;
    private /* synthetic */ EnumDifficulty difficulty;
    private /* synthetic */ WorldType worldType;
    
    public int getDimensionID() {
        return this.dimensionID;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIllIlllllllIIllI) {
        lllllllllllllllIIllIlllllllIIllI.handleRespawn(this);
    }
    
    public SPacketRespawn() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIllIllllllIllIlI) throws IOException {
        lllllllllllllllIIllIllllllIllIlI.writeInt(this.dimensionID);
        lllllllllllllllIIllIllllllIllIlI.writeByte(this.difficulty.getDifficultyId());
        lllllllllllllllIIllIllllllIllIlI.writeByte(this.gameType.getID());
        lllllllllllllllIIllIllllllIllIlI.writeString(this.worldType.getWorldTypeName());
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIllIllllllIllllI) throws IOException {
        this.dimensionID = lllllllllllllllIIllIllllllIllllI.readInt();
        this.difficulty = EnumDifficulty.getDifficultyEnum(lllllllllllllllIIllIllllllIllllI.readUnsignedByte());
        this.gameType = GameType.getByID(lllllllllllllllIIllIllllllIllllI.readUnsignedByte());
        this.worldType = WorldType.parseWorldType(lllllllllllllllIIllIllllllIllllI.readStringFromBuffer(16));
        if (this.worldType == null) {
            this.worldType = WorldType.DEFAULT;
        }
    }
    
    public SPacketRespawn(final int lllllllllllllllIIllIlllllllIllIl, final EnumDifficulty lllllllllllllllIIllIlllllllIllII, final WorldType lllllllllllllllIIllIllllllllIIII, final GameType lllllllllllllllIIllIlllllllIllll) {
        this.dimensionID = lllllllllllllllIIllIlllllllIllIl;
        this.difficulty = lllllllllllllllIIllIlllllllIllII;
        this.gameType = lllllllllllllllIIllIlllllllIllll;
        this.worldType = lllllllllllllllIIllIllllllllIIII;
    }
    
    public EnumDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    public WorldType getWorldType() {
        return this.worldType;
    }
    
    public GameType getGameType() {
        return this.gameType;
    }
}
