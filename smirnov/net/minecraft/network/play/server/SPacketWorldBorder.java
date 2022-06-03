// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketWorldBorder implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ double targetSize;
    private /* synthetic */ double centerZ;
    private /* synthetic */ int size;
    private /* synthetic */ long timeUntilTarget;
    private /* synthetic */ double diameter;
    private /* synthetic */ int warningTime;
    private /* synthetic */ int warningDistance;
    private /* synthetic */ double centerX;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action;
    private /* synthetic */ Action action;
    
    public void apply(final WorldBorder lllllllllllIIllIIIllIlIIllIllllI) {
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action()[this.action.ordinal()]) {
            case 1: {
                lllllllllllIIllIIIllIlIIllIllllI.setTransition(this.targetSize);
                break;
            }
            case 2: {
                lllllllllllIIllIIIllIlIIllIllllI.setTransition(this.diameter, this.targetSize, this.timeUntilTarget);
                break;
            }
            case 3: {
                lllllllllllIIllIIIllIlIIllIllllI.setCenter(this.centerX, this.centerZ);
                break;
            }
            case 6: {
                lllllllllllIIllIIIllIlIIllIllllI.setWarningDistance(this.warningDistance);
                break;
            }
            case 5: {
                lllllllllllIIllIIIllIlIIllIllllI.setWarningTime(this.warningTime);
                break;
            }
            case 4: {
                lllllllllllIIllIIIllIlIIllIllllI.setCenter(this.centerX, this.centerZ);
                if (this.timeUntilTarget > 0L) {
                    lllllllllllIIllIIIllIlIIllIllllI.setTransition(this.diameter, this.targetSize, this.timeUntilTarget);
                }
                else {
                    lllllllllllIIllIIIllIlIIllIllllI.setTransition(this.targetSize);
                }
                lllllllllllIIllIIIllIlIIllIllllI.setSize(this.size);
                lllllllllllIIllIIIllIlIIllIllllI.setWarningDistance(this.warningDistance);
                lllllllllllIIllIIIllIlIIllIllllI.setWarningTime(this.warningTime);
                break;
            }
        }
    }
    
    public SPacketWorldBorder(final WorldBorder lllllllllllIIllIIIllIlIIlllllIII, final Action lllllllllllIIllIIIllIlIIllllIlll) {
        this.action = lllllllllllIIllIIIllIlIIllllIlll;
        this.centerX = lllllllllllIIllIIIllIlIIlllllIII.getCenterX();
        this.centerZ = lllllllllllIIllIIIllIlIIlllllIII.getCenterZ();
        this.diameter = lllllllllllIIllIIIllIlIIlllllIII.getDiameter();
        this.targetSize = lllllllllllIIllIIIllIlIIlllllIII.getTargetSize();
        this.timeUntilTarget = lllllllllllIIllIIIllIlIIlllllIII.getTimeUntilTarget();
        this.size = lllllllllllIIllIIIllIlIIlllllIII.getSize();
        this.warningDistance = lllllllllllIIllIIIllIlIIlllllIII.getWarningDistance();
        this.warningTime = lllllllllllIIllIIIllIlIIlllllIII.getWarningTime();
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIllIIIllIlIIlllIlllI) throws IOException {
        this.action = lllllllllllIIllIIIllIlIIlllIlllI.readEnumValue(Action.class);
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action()[this.action.ordinal()]) {
            case 1: {
                this.targetSize = lllllllllllIIllIIIllIlIIlllIlllI.readDouble();
                break;
            }
            case 2: {
                this.diameter = lllllllllllIIllIIIllIlIIlllIlllI.readDouble();
                this.targetSize = lllllllllllIIllIIIllIlIIlllIlllI.readDouble();
                this.timeUntilTarget = lllllllllllIIllIIIllIlIIlllIlllI.readVarLong();
                break;
            }
            case 3: {
                this.centerX = lllllllllllIIllIIIllIlIIlllIlllI.readDouble();
                this.centerZ = lllllllllllIIllIIIllIlIIlllIlllI.readDouble();
                break;
            }
            case 6: {
                this.warningDistance = lllllllllllIIllIIIllIlIIlllIlllI.readVarIntFromBuffer();
                break;
            }
            case 5: {
                this.warningTime = lllllllllllIIllIIIllIlIIlllIlllI.readVarIntFromBuffer();
                break;
            }
            case 4: {
                this.centerX = lllllllllllIIllIIIllIlIIlllIlllI.readDouble();
                this.centerZ = lllllllllllIIllIIIllIlIIlllIlllI.readDouble();
                this.diameter = lllllllllllIIllIIIllIlIIlllIlllI.readDouble();
                this.targetSize = lllllllllllIIllIIIllIlIIlllIlllI.readDouble();
                this.timeUntilTarget = lllllllllllIIllIIIllIlIIlllIlllI.readVarLong();
                this.size = lllllllllllIIllIIIllIlIIlllIlllI.readVarIntFromBuffer();
                this.warningDistance = lllllllllllIIllIIIllIlIIlllIlllI.readVarIntFromBuffer();
                this.warningTime = lllllllllllIIllIIIllIlIIlllIlllI.readVarIntFromBuffer();
                break;
            }
        }
    }
    
    public SPacketWorldBorder() {
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action = SPacketWorldBorder.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action;
        }
        final String lllllllllllIIllIIIllIlIIllIlIllI = (Object)new int[Action.values().length];
        try {
            lllllllllllIIllIIIllIlIIllIlIllI[Action.INITIALIZE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIllIIIllIlIIllIlIllI[Action.LERP_SIZE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIllIIIllIlIIllIlIllI[Action.SET_CENTER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIllIIIllIlIIllIlIllI[Action.SET_SIZE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIllIIIllIlIIllIlIllI[Action.SET_WARNING_BLOCKS.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIllIIIllIlIIllIlIllI[Action.SET_WARNING_TIME.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return SPacketWorldBorder.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action = (int[])(Object)lllllllllllIIllIIIllIlIIllIlIllI;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIllIIIllIlIIlllIIlII) {
        lllllllllllIIllIIIllIlIIlllIIlII.handleWorldBorder(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIllIIIllIlIIlllIlIII) throws IOException {
        lllllllllllIIllIIIllIlIIlllIlIII.writeEnumValue(this.action);
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action()[this.action.ordinal()]) {
            case 1: {
                lllllllllllIIllIIIllIlIIlllIlIII.writeDouble(this.targetSize);
                break;
            }
            case 2: {
                lllllllllllIIllIIIllIlIIlllIlIII.writeDouble(this.diameter);
                lllllllllllIIllIIIllIlIIlllIlIII.writeDouble(this.targetSize);
                lllllllllllIIllIIIllIlIIlllIlIII.writeVarLong(this.timeUntilTarget);
                break;
            }
            case 3: {
                lllllllllllIIllIIIllIlIIlllIlIII.writeDouble(this.centerX);
                lllllllllllIIllIIIllIlIIlllIlIII.writeDouble(this.centerZ);
                break;
            }
            case 6: {
                lllllllllllIIllIIIllIlIIlllIlIII.writeVarIntToBuffer(this.warningDistance);
                break;
            }
            case 5: {
                lllllllllllIIllIIIllIlIIlllIlIII.writeVarIntToBuffer(this.warningTime);
                break;
            }
            case 4: {
                lllllllllllIIllIIIllIlIIlllIlIII.writeDouble(this.centerX);
                lllllllllllIIllIIIllIlIIlllIlIII.writeDouble(this.centerZ);
                lllllllllllIIllIIIllIlIIlllIlIII.writeDouble(this.diameter);
                lllllllllllIIllIIIllIlIIlllIlIII.writeDouble(this.targetSize);
                lllllllllllIIllIIIllIlIIlllIlIII.writeVarLong(this.timeUntilTarget);
                lllllllllllIIllIIIllIlIIlllIlIII.writeVarIntToBuffer(this.size);
                lllllllllllIIllIIIllIlIIlllIlIII.writeVarIntToBuffer(this.warningDistance);
                lllllllllllIIllIIIllIlIIlllIlIII.writeVarIntToBuffer(this.warningTime);
                break;
            }
        }
    }
    
    public enum Action
    {
        SET_CENTER("SET_CENTER", 2), 
        LERP_SIZE("LERP_SIZE", 1), 
        SET_WARNING_TIME("SET_WARNING_TIME", 4), 
        SET_SIZE("SET_SIZE", 0), 
        SET_WARNING_BLOCKS("SET_WARNING_BLOCKS", 5), 
        INITIALIZE("INITIALIZE", 3);
        
        private Action(final String lllllllllllllIllIllIIIIIlIllllII, final int lllllllllllllIllIllIIIIIlIlllIll) {
        }
    }
}
