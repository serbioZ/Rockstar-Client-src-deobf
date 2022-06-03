// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import java.util.UUID;
import net.minecraft.world.BossInfo;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketUpdateBossInfo implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ BossInfo.Overlay overlay;
    private /* synthetic */ UUID uniqueId;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation;
    private /* synthetic */ boolean playEndBossMusic;
    private /* synthetic */ boolean darkenSky;
    private /* synthetic */ ITextComponent name;
    private /* synthetic */ Operation operation;
    private /* synthetic */ BossInfo.Color color;
    private /* synthetic */ boolean createFog;
    private /* synthetic */ float percent;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIlllIlIlIlIlIIlllIIIlI) throws IOException {
        llllllllllIlllIlIlIlIlIIlllIIIlI.writeUuid(this.uniqueId);
        llllllllllIlllIlIlIlIlIIlllIIIlI.writeEnumValue(this.operation);
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation()[this.operation.ordinal()]) {
            case 1: {
                llllllllllIlllIlIlIlIlIIlllIIIlI.writeTextComponent(this.name);
                llllllllllIlllIlIlIlIlIIlllIIIlI.writeFloat(this.percent);
                llllllllllIlllIlIlIlIlIIlllIIIlI.writeEnumValue(this.color);
                llllllllllIlllIlIlIlIlIIlllIIIlI.writeEnumValue(this.overlay);
                llllllllllIlllIlIlIlIlIIlllIIIlI.writeByte(this.getFlags());
                break;
            }
            case 3: {
                llllllllllIlllIlIlIlIlIIlllIIIlI.writeFloat(this.percent);
                break;
            }
            case 4: {
                llllllllllIlllIlIlIlIlIIlllIIIlI.writeTextComponent(this.name);
                break;
            }
            case 5: {
                llllllllllIlllIlIlIlIlIIlllIIIlI.writeEnumValue(this.color);
                llllllllllIlllIlIlIlIlIIlllIIIlI.writeEnumValue(this.overlay);
                break;
            }
            case 6: {
                llllllllllIlllIlIlIlIlIIlllIIIlI.writeByte(this.getFlags());
                break;
            }
        }
    }
    
    private int getFlags() {
        int llllllllllIlllIlIlIlIlIIllIllllI = 0;
        if (this.darkenSky) {
            llllllllllIlllIlIlIlIlIIllIllllI |= 0x1;
        }
        if (this.playEndBossMusic) {
            llllllllllIlllIlIlIlIlIIllIllllI |= 0x2;
        }
        if (this.createFog) {
            llllllllllIlllIlIlIlIlIIllIllllI |= 0x2;
        }
        return llllllllllIlllIlIlIlIlIIllIllllI;
    }
    
    public SPacketUpdateBossInfo() {
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    private void setFlags(final int llllllllllIlllIlIlIlIlIIlllIlIlI) {
        this.darkenSky = ((llllllllllIlllIlIlIlIlIIlllIlIlI & 0x1) > 0);
        this.playEndBossMusic = ((llllllllllIlllIlIlIlIlIIlllIlIlI & 0x2) > 0);
        this.createFog = ((llllllllllIlllIlIlIlIlIIlllIlIlI & 0x2) > 0);
    }
    
    public boolean shouldPlayEndBossMusic() {
        return this.playEndBossMusic;
    }
    
    public SPacketUpdateBossInfo(final Operation llllllllllIlllIlIlIlIlIIlllllIII, final BossInfo llllllllllIlllIlIlIlIlIIllllIlII) {
        this.operation = llllllllllIlllIlIlIlIlIIlllllIII;
        this.uniqueId = llllllllllIlllIlIlIlIlIIllllIlII.getUniqueId();
        this.name = llllllllllIlllIlIlIlIlIIllllIlII.getName();
        this.percent = llllllllllIlllIlIlIlIlIIllllIlII.getPercent();
        this.color = llllllllllIlllIlIlIlIlIIllllIlII.getColor();
        this.overlay = llllllllllIlllIlIlIlIlIIllllIlII.getOverlay();
        this.darkenSky = llllllllllIlllIlIlIlIlIIllllIlII.shouldDarkenSky();
        this.playEndBossMusic = llllllllllIlllIlIlIlIlIIllllIlII.shouldPlayEndBossMusic();
        this.createFog = llllllllllIlllIlIlIlIlIIllllIlII.shouldCreateFog();
    }
    
    public boolean shouldDarkenSky() {
        return this.darkenSky;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation = SPacketUpdateBossInfo.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation;
        }
        final byte llllllllllIlllIlIlIlIlIIlIllIlIl = (Object)new int[Operation.values().length];
        try {
            llllllllllIlllIlIlIlIlIIlIllIlIl[Operation.ADD.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllIlllIlIlIlIlIIlIllIlIl[Operation.REMOVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllIlllIlIlIlIlIIlIllIlIl[Operation.UPDATE_NAME.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllIlllIlIlIlIlIIlIllIlIl[Operation.UPDATE_PCT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllIlllIlIlIlIlIIlIllIlIl[Operation.UPDATE_PROPERTIES.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllIlllIlIlIlIlIIlIllIlIl[Operation.UPDATE_STYLE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return SPacketUpdateBossInfo.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation = (int[])(Object)llllllllllIlllIlIlIlIlIIlIllIlIl;
    }
    
    public BossInfo.Color getColor() {
        return this.color;
    }
    
    public ITextComponent getName() {
        return this.name;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIlllIlIlIlIlIIlllIlllI) throws IOException {
        this.uniqueId = llllllllllIlllIlIlIlIlIIlllIlllI.readUuid();
        this.operation = llllllllllIlllIlIlIlIlIIlllIlllI.readEnumValue(Operation.class);
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation()[this.operation.ordinal()]) {
            case 1: {
                this.name = llllllllllIlllIlIlIlIlIIlllIlllI.readTextComponent();
                this.percent = llllllllllIlllIlIlIlIlIIlllIlllI.readFloat();
                this.color = llllllllllIlllIlIlIlIlIIlllIlllI.readEnumValue(BossInfo.Color.class);
                this.overlay = llllllllllIlllIlIlIlIlIIlllIlllI.readEnumValue(BossInfo.Overlay.class);
                this.setFlags(llllllllllIlllIlIlIlIlIIlllIlllI.readUnsignedByte());
                break;
            }
            case 3: {
                this.percent = llllllllllIlllIlIlIlIlIIlllIlllI.readFloat();
                break;
            }
            case 4: {
                this.name = llllllllllIlllIlIlIlIlIIlllIlllI.readTextComponent();
                break;
            }
            case 5: {
                this.color = llllllllllIlllIlIlIlIlIIlllIlllI.readEnumValue(BossInfo.Color.class);
                this.overlay = llllllllllIlllIlIlIlIlIIlllIlllI.readEnumValue(BossInfo.Overlay.class);
                break;
            }
            case 6: {
                this.setFlags(llllllllllIlllIlIlIlIlIIlllIlllI.readUnsignedByte());
                break;
            }
        }
    }
    
    public float getPercent() {
        return this.percent;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllIlllIlIlIlIlIIllIllIII) {
        llllllllllIlllIlIlIlIlIIllIllIII.handleUpdateEntityNBT(this);
    }
    
    public Operation getOperation() {
        return this.operation;
    }
    
    public boolean shouldCreateFog() {
        return this.createFog;
    }
    
    public BossInfo.Overlay getOverlay() {
        return this.overlay;
    }
    
    public enum Operation
    {
        UPDATE_NAME("UPDATE_NAME", 3), 
        UPDATE_PROPERTIES("UPDATE_PROPERTIES", 5), 
        UPDATE_PCT("UPDATE_PCT", 2), 
        UPDATE_STYLE("UPDATE_STYLE", 4), 
        ADD("ADD", 0), 
        REMOVE("REMOVE", 1);
        
        private Operation(final String llllllllllIlllIIIIlIlIIlIIIIIIII, final int llllllllllIlllIIIIlIlIIIllllllll) {
        }
    }
}
