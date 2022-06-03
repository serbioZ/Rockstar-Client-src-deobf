// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import javax.annotation.Nullable;
import com.google.common.base.MoreObjects;
import net.minecraft.network.INetHandler;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.GameType;
import com.mojang.authlib.GameProfile;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;
import java.io.IOException;
import com.mojang.authlib.properties.Property;
import net.minecraft.network.PacketBuffer;
import java.util.List;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketPlayerListItem implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ Action action;
    private final /* synthetic */ List<AddPlayerData> players;
    
    public Action getAction() {
        return this.action;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action = SPacketPlayerListItem.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action;
        }
        final long llllllllllllIIlllllllllIlIlIIlll = (Object)new int[Action.values().length];
        try {
            llllllllllllIIlllllllllIlIlIIlll[Action.ADD_PLAYER.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIlllllllllIlIlIIlll[Action.REMOVE_PLAYER.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIlllllllllIlIlIIlll[Action.UPDATE_DISPLAY_NAME.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIIlllllllllIlIlIIlll[Action.UPDATE_GAME_MODE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIIlllllllllIlIlIIlll[Action.UPDATE_LATENCY.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return SPacketPlayerListItem.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action = (int[])(Object)llllllllllllIIlllllllllIlIlIIlll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIlllllllllIllIIIlII) throws IOException {
        llllllllllllIIlllllllllIllIIIlII.writeEnumValue(this.action);
        llllllllllllIIlllllllllIllIIIlII.writeVarIntToBuffer(this.players.size());
        for (final AddPlayerData llllllllllllIIlllllllllIllIIIIll : this.players) {
            switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action()[this.action.ordinal()]) {
                case 1: {
                    llllllllllllIIlllllllllIllIIIlII.writeUuid(llllllllllllIIlllllllllIllIIIIll.getProfile().getId());
                    llllllllllllIIlllllllllIllIIIlII.writeString(llllllllllllIIlllllllllIllIIIIll.getProfile().getName());
                    llllllllllllIIlllllllllIllIIIlII.writeVarIntToBuffer(llllllllllllIIlllllllllIllIIIIll.getProfile().getProperties().size());
                    for (final Property llllllllllllIIlllllllllIllIIIIlI : llllllllllllIIlllllllllIllIIIIll.getProfile().getProperties().values()) {
                        llllllllllllIIlllllllllIllIIIlII.writeString(llllllllllllIIlllllllllIllIIIIlI.getName());
                        llllllllllllIIlllllllllIllIIIlII.writeString(llllllllllllIIlllllllllIllIIIIlI.getValue());
                        if (llllllllllllIIlllllllllIllIIIIlI.hasSignature()) {
                            llllllllllllIIlllllllllIllIIIlII.writeBoolean(true);
                            llllllllllllIIlllllllllIllIIIlII.writeString(llllllllllllIIlllllllllIllIIIIlI.getSignature());
                        }
                        else {
                            llllllllllllIIlllllllllIllIIIlII.writeBoolean(false);
                        }
                    }
                    llllllllllllIIlllllllllIllIIIlII.writeVarIntToBuffer(llllllllllllIIlllllllllIllIIIIll.getGameMode().getID());
                    llllllllllllIIlllllllllIllIIIlII.writeVarIntToBuffer(llllllllllllIIlllllllllIllIIIIll.getPing());
                    if (llllllllllllIIlllllllllIllIIIIll.getDisplayName() == null) {
                        llllllllllllIIlllllllllIllIIIlII.writeBoolean(false);
                        continue;
                    }
                    llllllllllllIIlllllllllIllIIIlII.writeBoolean(true);
                    llllllllllllIIlllllllllIllIIIlII.writeTextComponent(llllllllllllIIlllllllllIllIIIIll.getDisplayName());
                    continue;
                }
                case 4: {
                    llllllllllllIIlllllllllIllIIIlII.writeUuid(llllllllllllIIlllllllllIllIIIIll.getProfile().getId());
                    if (llllllllllllIIlllllllllIllIIIIll.getDisplayName() == null) {
                        llllllllllllIIlllllllllIllIIIlII.writeBoolean(false);
                        continue;
                    }
                    llllllllllllIIlllllllllIllIIIlII.writeBoolean(true);
                    llllllllllllIIlllllllllIllIIIlII.writeTextComponent(llllllllllllIIlllllllllIllIIIIll.getDisplayName());
                    continue;
                }
                default: {
                    continue;
                }
                case 2: {
                    llllllllllllIIlllllllllIllIIIlII.writeUuid(llllllllllllIIlllllllllIllIIIIll.getProfile().getId());
                    llllllllllllIIlllllllllIllIIIlII.writeVarIntToBuffer(llllllllllllIIlllllllllIllIIIIll.getGameMode().getID());
                    continue;
                }
                case 3: {
                    llllllllllllIIlllllllllIllIIIlII.writeUuid(llllllllllllIIlllllllllIllIIIIll.getProfile().getId());
                    llllllllllllIIlllllllllIllIIIlII.writeVarIntToBuffer(llllllllllllIIlllllllllIllIIIIll.getPing());
                    continue;
                }
                case 5: {
                    llllllllllllIIlllllllllIllIIIlII.writeUuid(llllllllllllIIlllllllllIllIIIIll.getProfile().getId());
                    continue;
                }
            }
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIIlllllllllIlIllIllI) {
        llllllllllllIIlllllllllIlIllIllI.handlePlayerListItem(this);
    }
    
    public SPacketPlayerListItem(final Action llllllllllllIIlllllllllIllllIlll, final Iterable<EntityPlayerMP> llllllllllllIIlllllllllIllllIllI) {
        this.players = (List<AddPlayerData>)Lists.newArrayList();
        this.action = llllllllllllIIlllllllllIllllIlll;
        for (final EntityPlayerMP llllllllllllIIlllllllllIllllIlIl : llllllllllllIIlllllllllIllllIllI) {
            this.players.add(new AddPlayerData(llllllllllllIIlllllllllIllllIlIl.getGameProfile(), llllllllllllIIlllllllllIllllIlIl.ping, llllllllllllIIlllllllllIllllIlIl.interactionManager.getGameType(), llllllllllllIIlllllllllIllllIlIl.getTabListDisplayName()));
        }
    }
    
    public List<AddPlayerData> getEntries() {
        return this.players;
    }
    
    public SPacketPlayerListItem() {
        this.players = (List<AddPlayerData>)Lists.newArrayList();
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIlllllllllIllIlIllI) throws IOException {
        this.action = llllllllllllIIlllllllllIllIlIllI.readEnumValue(Action.class);
        for (int llllllllllllIIlllllllllIlllIIIIl = llllllllllllIIlllllllllIllIlIllI.readVarIntFromBuffer(), llllllllllllIIlllllllllIlllIIIII = 0; llllllllllllIIlllllllllIlllIIIII < llllllllllllIIlllllllllIlllIIIIl; ++llllllllllllIIlllllllllIlllIIIII) {
            GameProfile llllllllllllIIlllllllllIllIlllll = null;
            int llllllllllllIIlllllllllIllIllllI = 0;
            GameType llllllllllllIIlllllllllIllIlllIl = null;
            ITextComponent llllllllllllIIlllllllllIllIlllII = null;
            switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action()[this.action.ordinal()]) {
                case 1: {
                    llllllllllllIIlllllllllIllIlllll = new GameProfile(llllllllllllIIlllllllllIllIlIllI.readUuid(), llllllllllllIIlllllllllIllIlIllI.readStringFromBuffer(16));
                    for (int llllllllllllIIlllllllllIllIllIll = llllllllllllIIlllllllllIllIlIllI.readVarIntFromBuffer(), llllllllllllIIlllllllllIllIllIlI = 0; llllllllllllIIlllllllllIllIllIlI < llllllllllllIIlllllllllIllIllIll; ++llllllllllllIIlllllllllIllIllIlI) {
                        final String llllllllllllIIlllllllllIllIllIIl = llllllllllllIIlllllllllIllIlIllI.readStringFromBuffer(32767);
                        final String llllllllllllIIlllllllllIllIllIII = llllllllllllIIlllllllllIllIlIllI.readStringFromBuffer(32767);
                        if (llllllllllllIIlllllllllIllIlIllI.readBoolean()) {
                            llllllllllllIIlllllllllIllIlllll.getProperties().put((Object)llllllllllllIIlllllllllIllIllIIl, (Object)new Property(llllllllllllIIlllllllllIllIllIIl, llllllllllllIIlllllllllIllIllIII, llllllllllllIIlllllllllIllIlIllI.readStringFromBuffer(32767)));
                        }
                        else {
                            llllllllllllIIlllllllllIllIlllll.getProperties().put((Object)llllllllllllIIlllllllllIllIllIIl, (Object)new Property(llllllllllllIIlllllllllIllIllIIl, llllllllllllIIlllllllllIllIllIII));
                        }
                    }
                    llllllllllllIIlllllllllIllIlllIl = GameType.getByID(llllllllllllIIlllllllllIllIlIllI.readVarIntFromBuffer());
                    llllllllllllIIlllllllllIllIllllI = llllllllllllIIlllllllllIllIlIllI.readVarIntFromBuffer();
                    if (llllllllllllIIlllllllllIllIlIllI.readBoolean()) {
                        llllllllllllIIlllllllllIllIlllII = llllllllllllIIlllllllllIllIlIllI.readTextComponent();
                        break;
                    }
                    break;
                }
                case 2: {
                    llllllllllllIIlllllllllIllIlllll = new GameProfile(llllllllllllIIlllllllllIllIlIllI.readUuid(), (String)null);
                    llllllllllllIIlllllllllIllIlllIl = GameType.getByID(llllllllllllIIlllllllllIllIlIllI.readVarIntFromBuffer());
                    break;
                }
                case 3: {
                    llllllllllllIIlllllllllIllIlllll = new GameProfile(llllllllllllIIlllllllllIllIlIllI.readUuid(), (String)null);
                    llllllllllllIIlllllllllIllIllllI = llllllllllllIIlllllllllIllIlIllI.readVarIntFromBuffer();
                    break;
                }
                case 4: {
                    llllllllllllIIlllllllllIllIlllll = new GameProfile(llllllllllllIIlllllllllIllIlIllI.readUuid(), (String)null);
                    if (llllllllllllIIlllllllllIllIlIllI.readBoolean()) {
                        llllllllllllIIlllllllllIllIlllII = llllllllllllIIlllllllllIllIlIllI.readTextComponent();
                        break;
                    }
                    break;
                }
                case 5: {
                    llllllllllllIIlllllllllIllIlllll = new GameProfile(llllllllllllIIlllllllllIllIlIllI.readUuid(), (String)null);
                    break;
                }
            }
            this.players.add(new AddPlayerData(llllllllllllIIlllllllllIllIlllll, llllllllllllIIlllllllllIllIllllI, llllllllllllIIlllllllllIllIlllIl, llllllllllllIIlllllllllIllIlllII));
        }
    }
    
    public SPacketPlayerListItem(final Action llllllllllllIIllllllllllIIIIIIll, final EntityPlayerMP... llllllllllllIIllllllllllIIIIIllI) {
        this.players = (List<AddPlayerData>)Lists.newArrayList();
        this.action = llllllllllllIIllllllllllIIIIIIll;
        final int llllllllllllIIlllllllllIlllllllI = (Object)llllllllllllIIllllllllllIIIIIllI;
        final short llllllllllllIIlllllllllIllllllll = (short)llllllllllllIIllllllllllIIIIIllI.length;
        for (final EntityPlayerMP llllllllllllIIllllllllllIIIIIlIl : llllllllllllIIlllllllllIlllllllI) {
            this.players.add(new AddPlayerData(llllllllllllIIllllllllllIIIIIlIl.getGameProfile(), llllllllllllIIllllllllllIIIIIlIl.ping, llllllllllllIIllllllllllIIIIIlIl.interactionManager.getGameType(), llllllllllllIIllllllllllIIIIIlIl.getTabListDisplayName()));
        }
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("action", (Object)this.action).add("entries", (Object)this.players).toString();
    }
    
    public enum Action
    {
        UPDATE_DISPLAY_NAME("UPDATE_DISPLAY_NAME", 3), 
        ADD_PLAYER("ADD_PLAYER", 0), 
        UPDATE_GAME_MODE("UPDATE_GAME_MODE", 1), 
        REMOVE_PLAYER("REMOVE_PLAYER", 4), 
        UPDATE_LATENCY("UPDATE_LATENCY", 2);
        
        private Action(final String llllllllllIllllIllIllIIllIlIlIII, final int llllllllllIllllIllIllIIllIlIIlll) {
        }
    }
    
    public class AddPlayerData
    {
        private final /* synthetic */ ITextComponent displayName;
        private final /* synthetic */ GameProfile profile;
        private final /* synthetic */ int ping;
        private final /* synthetic */ GameType gamemode;
        
        public GameProfile getProfile() {
            return this.profile;
        }
        
        @Override
        public String toString() {
            return MoreObjects.toStringHelper((Object)this).add("latency", this.ping).add("gameMode", (Object)this.gamemode).add("profile", (Object)this.profile).add("displayName", (Object)((this.displayName == null) ? null : ITextComponent.Serializer.componentToJson(this.displayName))).toString();
        }
        
        @Nullable
        public ITextComponent getDisplayName() {
            return this.displayName;
        }
        
        public AddPlayerData(final GameProfile lllllllllllllIIIIIIIllIIlllllIlI, final int lllllllllllllIIIIIIIllIIllllIIll, @Nullable final GameType lllllllllllllIIIIIIIllIIlllllIII, final ITextComponent lllllllllllllIIIIIIIllIIllllIIIl) {
            this.profile = lllllllllllllIIIIIIIllIIlllllIlI;
            this.ping = lllllllllllllIIIIIIIllIIllllIIll;
            this.gamemode = lllllllllllllIIIIIIIllIIlllllIII;
            this.displayName = lllllllllllllIIIIIIIllIIllllIIIl;
        }
        
        public GameType getGameMode() {
            return this.gamemode;
        }
        
        public int getPing() {
            return this.ping;
        }
    }
}
