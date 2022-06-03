// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.TextComponentString;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketCombatEvent implements Packet<INetHandlerPlayClient>
{
    public /* synthetic */ int playerId;
    public /* synthetic */ int duration;
    public /* synthetic */ int entityId;
    public /* synthetic */ Event eventType;
    public /* synthetic */ ITextComponent deathMessage;
    
    public SPacketCombatEvent(final CombatTracker lllllllllllIIlIIlIlIIlIllIlllIlI, final Event lllllllllllIIlIIlIlIIlIllIlllIIl) {
        this(lllllllllllIIlIIlIlIIlIllIlllIlI, lllllllllllIIlIIlIlIIlIllIlllIIl, true);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIlIIlIlIIlIllIIllIll) throws IOException {
        lllllllllllIIlIIlIlIIlIllIIllIll.writeEnumValue(this.eventType);
        if (this.eventType == Event.END_COMBAT) {
            lllllllllllIIlIIlIlIIlIllIIllIll.writeVarIntToBuffer(this.duration);
            lllllllllllIIlIIlIlIIlIllIIllIll.writeInt(this.entityId);
        }
        else if (this.eventType == Event.ENTITY_DIED) {
            lllllllllllIIlIIlIlIIlIllIIllIll.writeVarIntToBuffer(this.playerId);
            lllllllllllIIlIIlIlIIlIllIIllIll.writeInt(this.entityId);
            lllllllllllIIlIIlIlIIlIllIIllIll.writeTextComponent(this.deathMessage);
        }
    }
    
    public SPacketCombatEvent() {
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event = SPacketCombatEvent.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event;
        }
        final Exception lllllllllllIIlIIlIlIIlIllIIIllll = (Object)new int[Event.values().length];
        try {
            lllllllllllIIlIIlIlIIlIllIIIllll[Event.END_COMBAT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlIIlIlIIlIllIIIllll[Event.ENTER_COMBAT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlIIlIlIIlIllIIIllll[Event.ENTITY_DIED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return SPacketCombatEvent.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event = (int[])(Object)lllllllllllIIlIIlIlIIlIllIIIllll;
    }
    
    public SPacketCombatEvent(final CombatTracker lllllllllllIIlIIlIlIIlIllIlIllll, final Event lllllllllllIIlIIlIlIIlIllIlIlllI, final boolean lllllllllllIIlIIlIlIIlIllIlIlIII) {
        this.eventType = lllllllllllIIlIIlIlIIlIllIlIlllI;
        final EntityLivingBase lllllllllllIIlIIlIlIIlIllIlIllII = lllllllllllIIlIIlIlIIlIllIlIllll.getBestAttacker();
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event()[lllllllllllIIlIIlIlIIlIllIlIlllI.ordinal()]) {
            case 2: {
                this.duration = lllllllllllIIlIIlIlIIlIllIlIllll.getCombatDuration();
                this.entityId = ((lllllllllllIIlIIlIlIIlIllIlIllII == null) ? -1 : lllllllllllIIlIIlIlIIlIllIlIllII.getEntityId());
                break;
            }
            case 3: {
                this.playerId = lllllllllllIIlIIlIlIIlIllIlIllll.getFighter().getEntityId();
                this.entityId = ((lllllllllllIIlIIlIlIIlIllIlIllII == null) ? -1 : lllllllllllIIlIIlIlIIlIllIlIllII.getEntityId());
                if (lllllllllllIIlIIlIlIIlIllIlIlIII) {
                    this.deathMessage = lllllllllllIIlIIlIlIIlIllIlIllll.getDeathMessage();
                    break;
                }
                this.deathMessage = new TextComponentString("");
                break;
            }
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIlIIlIlIIlIllIIlIlIl) {
        lllllllllllIIlIIlIlIIlIllIIlIlIl.handleCombatEvent(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIlIIlIlIIlIllIlIIIll) throws IOException {
        this.eventType = lllllllllllIIlIIlIlIIlIllIlIIIll.readEnumValue(Event.class);
        if (this.eventType == Event.END_COMBAT) {
            this.duration = lllllllllllIIlIIlIlIIlIllIlIIIll.readVarIntFromBuffer();
            this.entityId = lllllllllllIIlIIlIlIIlIllIlIIIll.readInt();
        }
        else if (this.eventType == Event.ENTITY_DIED) {
            this.playerId = lllllllllllIIlIIlIlIIlIllIlIIIll.readVarIntFromBuffer();
            this.entityId = lllllllllllIIlIIlIlIIlIllIlIIIll.readInt();
            this.deathMessage = lllllllllllIIlIIlIlIIlIllIlIIIll.readTextComponent();
        }
    }
    
    public enum Event
    {
        END_COMBAT("END_COMBAT", 1), 
        ENTITY_DIED("ENTITY_DIED", 2), 
        ENTER_COMBAT("ENTER_COMBAT", 0);
        
        private Event(final String llllllllllllIllllIlIIlllllIIIIll, final int llllllllllllIllllIlIIlllllIIIIlI) {
        }
    }
}
