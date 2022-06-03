// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import java.util.UUID;
import com.google.gson.JsonArray;
import com.mojang.authlib.GameProfile;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import net.minecraft.util.text.ITextComponent;

public class ServerStatusResponse
{
    private /* synthetic */ ITextComponent description;
    private /* synthetic */ Version version;
    private /* synthetic */ Players players;
    private /* synthetic */ String favicon;
    
    public void setPlayers(final Players llllllllllllIIIIlllIllIlIIlllIII) {
        this.players = llllllllllllIIIIlllIllIlIIlllIII;
    }
    
    public void setFavicon(final String llllllllllllIIIIlllIllIlIIlIIlll) {
        this.favicon = llllllllllllIIIIlllIllIlIIlIIlll;
    }
    
    public void setVersion(final Version llllllllllllIIIIlllIllIlIIlIllll) {
        this.version = llllllllllllIIIIlllIllIlIIlIllll;
    }
    
    public Players getPlayers() {
        return this.players;
    }
    
    public ITextComponent getServerDescription() {
        return this.description;
    }
    
    public String getFavicon() {
        return this.favicon;
    }
    
    public void setServerDescription(final ITextComponent llllllllllllIIIIlllIllIlIlIIIIIl) {
        this.description = llllllllllllIIIIlllIllIlIlIIIIIl;
    }
    
    public Version getVersion() {
        return this.version;
    }
    
    public static class Version
    {
        private final /* synthetic */ String name;
        private final /* synthetic */ int protocol;
        
        public String getName() {
            return this.name;
        }
        
        public Version(final String llllllllllIlllIlllIllllIIIllIlll, final int llllllllllIlllIlllIllllIIIllIllI) {
            this.name = llllllllllIlllIlllIllllIIIllIlll;
            this.protocol = llllllllllIlllIlllIllllIIIllIllI;
        }
        
        public int getProtocol() {
            return this.protocol;
        }
        
        public static class Serializer implements JsonDeserializer<Version>, JsonSerializer<Version>
        {
            public Version deserialize(final JsonElement lllllllllllIIIIIlIlllIllIlIlIIll, final Type lllllllllllIIIIIlIlllIllIlIlIllI, final JsonDeserializationContext lllllllllllIIIIIlIlllIllIlIlIlIl) throws JsonParseException {
                final JsonObject lllllllllllIIIIIlIlllIllIlIlIlII = JsonUtils.getJsonObject(lllllllllllIIIIIlIlllIllIlIlIIll, "version");
                return new Version(JsonUtils.getString(lllllllllllIIIIIlIlllIllIlIlIlII, "name"), JsonUtils.getInt(lllllllllllIIIIIlIlllIllIlIlIlII, "protocol"));
            }
            
            public JsonElement serialize(final Version lllllllllllIIIIIlIlllIllIlIIlllI, final Type lllllllllllIIIIIlIlllIllIlIIllIl, final JsonSerializationContext lllllllllllIIIIIlIlllIllIlIIllII) {
                final JsonObject lllllllllllIIIIIlIlllIllIlIIlIll = new JsonObject();
                lllllllllllIIIIIlIlllIllIlIIlIll.addProperty("name", lllllllllllIIIIIlIlllIllIlIIlllI.getName());
                lllllllllllIIIIIlIlllIllIlIIlIll.addProperty("protocol", (Number)lllllllllllIIIIIlIlllIllIlIIlllI.getProtocol());
                return (JsonElement)lllllllllllIIIIIlIlllIllIlIIlIll;
            }
        }
    }
    
    public static class Players
    {
        private /* synthetic */ GameProfile[] players;
        private final /* synthetic */ int maxPlayers;
        private final /* synthetic */ int onlinePlayerCount;
        
        public int getOnlinePlayerCount() {
            return this.onlinePlayerCount;
        }
        
        public GameProfile[] getPlayers() {
            return this.players;
        }
        
        public int getMaxPlayers() {
            return this.maxPlayers;
        }
        
        public void setPlayers(final GameProfile[] llllllllllllIIIllIIIIllIIIIlllII) {
            this.players = llllllllllllIIIllIIIIllIIIIlllII;
        }
        
        public Players(final int llllllllllllIIIllIIIIllIIIlIllIl, final int llllllllllllIIIllIIIIllIIIlIlIIl) {
            this.maxPlayers = llllllllllllIIIllIIIIllIIIlIllIl;
            this.onlinePlayerCount = llllllllllllIIIllIIIIllIIIlIlIIl;
        }
        
        public static class Serializer implements JsonDeserializer<Players>, JsonSerializer<Players>
        {
            public JsonElement serialize(final Players lllllllllllIlIIIIIIlllllIlIIllll, final Type lllllllllllIlIIIIIIlllllIlIlIllI, final JsonSerializationContext lllllllllllIlIIIIIIlllllIlIlIlIl) {
                final JsonObject lllllllllllIlIIIIIIlllllIlIlIlII = new JsonObject();
                lllllllllllIlIIIIIIlllllIlIlIlII.addProperty("max", (Number)lllllllllllIlIIIIIIlllllIlIIllll.getMaxPlayers());
                lllllllllllIlIIIIIIlllllIlIlIlII.addProperty("online", (Number)lllllllllllIlIIIIIIlllllIlIIllll.getOnlinePlayerCount());
                if (lllllllllllIlIIIIIIlllllIlIIllll.getPlayers() != null && lllllllllllIlIIIIIIlllllIlIIllll.getPlayers().length > 0) {
                    final JsonArray lllllllllllIlIIIIIIlllllIlIlIIll = new JsonArray();
                    for (int lllllllllllIlIIIIIIlllllIlIlIIlI = 0; lllllllllllIlIIIIIIlllllIlIlIIlI < lllllllllllIlIIIIIIlllllIlIIllll.getPlayers().length; ++lllllllllllIlIIIIIIlllllIlIlIIlI) {
                        final JsonObject lllllllllllIlIIIIIIlllllIlIlIIIl = new JsonObject();
                        final UUID lllllllllllIlIIIIIIlllllIlIlIIII = lllllllllllIlIIIIIIlllllIlIIllll.getPlayers()[lllllllllllIlIIIIIIlllllIlIlIIlI].getId();
                        lllllllllllIlIIIIIIlllllIlIlIIIl.addProperty("id", (lllllllllllIlIIIIIIlllllIlIlIIII == null) ? "" : lllllllllllIlIIIIIIlllllIlIlIIII.toString());
                        lllllllllllIlIIIIIIlllllIlIlIIIl.addProperty("name", lllllllllllIlIIIIIIlllllIlIIllll.getPlayers()[lllllllllllIlIIIIIIlllllIlIlIIlI].getName());
                        lllllllllllIlIIIIIIlllllIlIlIIll.add((JsonElement)lllllllllllIlIIIIIIlllllIlIlIIIl);
                    }
                    lllllllllllIlIIIIIIlllllIlIlIlII.add("sample", (JsonElement)lllllllllllIlIIIIIIlllllIlIlIIll);
                }
                return (JsonElement)lllllllllllIlIIIIIIlllllIlIlIlII;
            }
            
            public Players deserialize(final JsonElement lllllllllllIlIIIIIIlllllIlllIIII, final Type lllllllllllIlIIIIIIlllllIllIllll, final JsonDeserializationContext lllllllllllIlIIIIIIlllllIllIlllI) throws JsonParseException {
                final JsonObject lllllllllllIlIIIIIIlllllIllIllIl = JsonUtils.getJsonObject(lllllllllllIlIIIIIIlllllIlllIIII, "players");
                final Players lllllllllllIlIIIIIIlllllIllIllII = new Players(JsonUtils.getInt(lllllllllllIlIIIIIIlllllIllIllIl, "max"), JsonUtils.getInt(lllllllllllIlIIIIIIlllllIllIllIl, "online"));
                if (JsonUtils.isJsonArray(lllllllllllIlIIIIIIlllllIllIllIl, "sample")) {
                    final JsonArray lllllllllllIlIIIIIIlllllIllIlIll = JsonUtils.getJsonArray(lllllllllllIlIIIIIIlllllIllIllIl, "sample");
                    if (lllllllllllIlIIIIIIlllllIllIlIll.size() > 0) {
                        final GameProfile[] lllllllllllIlIIIIIIlllllIllIlIlI = new GameProfile[lllllllllllIlIIIIIIlllllIllIlIll.size()];
                        for (int lllllllllllIlIIIIIIlllllIllIlIIl = 0; lllllllllllIlIIIIIIlllllIllIlIIl < lllllllllllIlIIIIIIlllllIllIlIlI.length; ++lllllllllllIlIIIIIIlllllIllIlIIl) {
                            final JsonObject lllllllllllIlIIIIIIlllllIllIlIII = JsonUtils.getJsonObject(lllllllllllIlIIIIIIlllllIllIlIll.get(lllllllllllIlIIIIIIlllllIllIlIIl), "player[" + lllllllllllIlIIIIIIlllllIllIlIIl + "]");
                            final String lllllllllllIlIIIIIIlllllIllIIlll = JsonUtils.getString(lllllllllllIlIIIIIIlllllIllIlIII, "id");
                            lllllllllllIlIIIIIIlllllIllIlIlI[lllllllllllIlIIIIIIlllllIllIlIIl] = new GameProfile(UUID.fromString(lllllllllllIlIIIIIIlllllIllIIlll), JsonUtils.getString(lllllllllllIlIIIIIIlllllIllIlIII, "name"));
                        }
                        lllllllllllIlIIIIIIlllllIllIllII.setPlayers(lllllllllllIlIIIIIIlllllIllIlIlI);
                    }
                }
                return lllllllllllIlIIIIIIlllllIllIllII;
            }
        }
    }
    
    public static class Serializer implements JsonDeserializer<ServerStatusResponse>, JsonSerializer<ServerStatusResponse>
    {
        public ServerStatusResponse deserialize(final JsonElement llllllllllllIllIllIIllllIlllIlII, final Type llllllllllllIllIllIIllllIlllIIll, final JsonDeserializationContext llllllllllllIllIllIIllllIllIlllI) throws JsonParseException {
            final JsonObject llllllllllllIllIllIIllllIlllIIIl = JsonUtils.getJsonObject(llllllllllllIllIllIIllllIlllIlII, "status");
            final ServerStatusResponse llllllllllllIllIllIIllllIlllIIII = new ServerStatusResponse();
            if (llllllllllllIllIllIIllllIlllIIIl.has("description")) {
                llllllllllllIllIllIIllllIlllIIII.setServerDescription((ITextComponent)llllllllllllIllIllIIllllIllIlllI.deserialize(llllllllllllIllIllIIllllIlllIIIl.get("description"), (Type)ITextComponent.class));
            }
            if (llllllllllllIllIllIIllllIlllIIIl.has("players")) {
                llllllllllllIllIllIIllllIlllIIII.setPlayers((Players)llllllllllllIllIllIIllllIllIlllI.deserialize(llllllllllllIllIllIIllllIlllIIIl.get("players"), (Type)Players.class));
            }
            if (llllllllllllIllIllIIllllIlllIIIl.has("version")) {
                llllllllllllIllIllIIllllIlllIIII.setVersion((Version)llllllllllllIllIllIIllllIllIlllI.deserialize(llllllllllllIllIllIIllllIlllIIIl.get("version"), (Type)Version.class));
            }
            if (llllllllllllIllIllIIllllIlllIIIl.has("favicon")) {
                llllllllllllIllIllIIllllIlllIIII.setFavicon(JsonUtils.getString(llllllllllllIllIllIIllllIlllIIIl, "favicon"));
            }
            return llllllllllllIllIllIIllllIlllIIII;
        }
        
        public JsonElement serialize(final ServerStatusResponse llllllllllllIllIllIIllllIllIIIll, final Type llllllllllllIllIllIIllllIllIIllI, final JsonSerializationContext llllllllllllIllIllIIllllIllIIlIl) {
            final JsonObject llllllllllllIllIllIIllllIllIIlII = new JsonObject();
            if (llllllllllllIllIllIIllllIllIIIll.getServerDescription() != null) {
                llllllllllllIllIllIIllllIllIIlII.add("description", llllllllllllIllIllIIllllIllIIlIl.serialize((Object)llllllllllllIllIllIIllllIllIIIll.getServerDescription()));
            }
            if (llllllllllllIllIllIIllllIllIIIll.getPlayers() != null) {
                llllllllllllIllIllIIllllIllIIlII.add("players", llllllllllllIllIllIIllllIllIIlIl.serialize((Object)llllllllllllIllIllIIllllIllIIIll.getPlayers()));
            }
            if (llllllllllllIllIllIIllllIllIIIll.getVersion() != null) {
                llllllllllllIllIllIIllllIllIIlII.add("version", llllllllllllIllIllIIllllIllIIlIl.serialize((Object)llllllllllllIllIllIIllllIllIIIll.getVersion()));
            }
            if (llllllllllllIllIllIIllllIllIIIll.getFavicon() != null) {
                llllllllllllIllIllIIllllIllIIlII.addProperty("favicon", llllllllllllIllIllIIllllIllIIIll.getFavicon());
            }
            return (JsonElement)llllllllllllIllIllIIllllIllIIlII;
        }
    }
}
