// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import com.mojang.authlib.Agent;
import com.mojang.authlib.ProfileLookupCallback;
import java.util.Locale;
import java.util.Calendar;
import java.io.BufferedReader;
import org.apache.commons.io.IOUtils;
import com.google.gson.JsonParseException;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.io.Reader;
import net.minecraft.util.JsonUtils;
import com.google.common.io.Files;
import java.nio.charset.StandardCharsets;
import com.google.gson.GsonBuilder;
import com.google.common.collect.Maps;
import java.util.Date;
import javax.annotation.Nullable;
import java.util.Iterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.List;
import java.io.File;
import java.text.SimpleDateFormat;
import com.mojang.authlib.GameProfile;
import java.util.Deque;
import java.util.UUID;
import java.util.Map;
import com.google.gson.Gson;
import com.mojang.authlib.GameProfileRepository;
import java.lang.reflect.ParameterizedType;

public class PlayerProfileCache
{
    private static final /* synthetic */ ParameterizedType TYPE;
    private final /* synthetic */ GameProfileRepository profileRepo;
    private static /* synthetic */ boolean onlineMode;
    protected final /* synthetic */ Gson gson;
    private final /* synthetic */ Map<UUID, ProfileEntry> uuidToProfileEntryMap;
    private final /* synthetic */ Deque<GameProfile> gameProfiles;
    private final /* synthetic */ Map<String, ProfileEntry> usernameToProfileEntryMap;
    public static final /* synthetic */ SimpleDateFormat DATE_FORMAT;
    private final /* synthetic */ File usercacheFile;
    
    private List<ProfileEntry> getEntriesWithLimit(final int llllllllllIllllllIIIlIIIllIlIIIl) {
        final List<ProfileEntry> llllllllllIllllllIIIlIIIllIlIIII = (List<ProfileEntry>)Lists.newArrayList();
        for (final GameProfile llllllllllIllllllIIIlIIIllIIllll : Lists.newArrayList(Iterators.limit((Iterator)this.gameProfiles.iterator(), llllllllllIllllllIIIlIIIllIlIIIl))) {
            final ProfileEntry llllllllllIllllllIIIlIIIllIIlllI = this.getByUUID(llllllllllIllllllIIIlIIIllIIllll.getId());
            if (llllllllllIllllllIIIlIIIllIIlllI != null) {
                llllllllllIllllllIIIlIIIllIlIIII.add(llllllllllIllllllIIIlIIIllIIlllI);
            }
        }
        return llllllllllIllllllIIIlIIIllIlIIII;
    }
    
    private ProfileEntry getByUUID(final UUID llllllllllIllllllIIIlIIIlllllIIl) {
        final ProfileEntry llllllllllIllllllIIIlIIIllllllII = this.uuidToProfileEntryMap.get(llllllllllIllllllIIIlIIIlllllIIl);
        if (llllllllllIllllllIIIlIIIllllllII != null) {
            final GameProfile llllllllllIllllllIIIlIIIlllllIll = llllllllllIllllllIIIlIIIllllllII.getGameProfile();
            this.gameProfiles.remove(llllllllllIllllllIIIlIIIlllllIll);
            this.gameProfiles.addFirst(llllllllllIllllllIIIlIIIlllllIll);
        }
        return llllllllllIllllllIIIlIIIllllllII;
    }
    
    @Nullable
    public GameProfile getProfileByUUID(final UUID llllllllllIllllllIIIlIIlIIIIIlII) {
        final ProfileEntry llllllllllIllllllIIIlIIlIIIIIllI = this.uuidToProfileEntryMap.get(llllllllllIllllllIIIlIIlIIIIIlII);
        return (llllllllllIllllllIIIlIIlIIIIIllI == null) ? null : llllllllllIllllllIIIlIIlIIIIIllI.getGameProfile();
    }
    
    private static boolean isOnlineMode() {
        return PlayerProfileCache.onlineMode;
    }
    
    public void addEntry(final GameProfile llllllllllIllllllIIIlIIlIIlllIII) {
        this.addEntry(llllllllllIllllllIIIlIIlIIlllIII, null);
    }
    
    public PlayerProfileCache(final GameProfileRepository llllllllllIllllllIIIlIIlIlIlIlIl, final File llllllllllIllllllIIIlIIlIlIllIII) {
        this.usernameToProfileEntryMap = (Map<String, ProfileEntry>)Maps.newHashMap();
        this.uuidToProfileEntryMap = (Map<UUID, ProfileEntry>)Maps.newHashMap();
        this.gameProfiles = (Deque<GameProfile>)Lists.newLinkedList();
        this.profileRepo = llllllllllIllllllIIIlIIlIlIlIlIl;
        this.usercacheFile = llllllllllIllllllIIIlIIlIlIllIII;
        final GsonBuilder llllllllllIllllllIIIlIIlIlIlIlll = new GsonBuilder();
        llllllllllIllllllIIIlIIlIlIlIlll.registerTypeHierarchyAdapter((Class)ProfileEntry.class, (Object)new Serializer((Serializer)null));
        this.gson = llllllllllIllllllIIIlIIlIlIlIlll.create();
        this.load();
    }
    
    public void load() {
        BufferedReader llllllllllIllllllIIIlIIIlllIllll = null;
        try {
            llllllllllIllllllIIIlIIIlllIllll = Files.newReader(this.usercacheFile, StandardCharsets.UTF_8);
            final List<ProfileEntry> llllllllllIllllllIIIlIIIlllIlllI = JsonUtils.func_193841_a(this.gson, llllllllllIllllllIIIlIIIlllIllll, PlayerProfileCache.TYPE);
            this.usernameToProfileEntryMap.clear();
            this.uuidToProfileEntryMap.clear();
            this.gameProfiles.clear();
            if (llllllllllIllllllIIIlIIIlllIlllI != null) {
                for (final ProfileEntry llllllllllIllllllIIIlIIIlllIllIl : Lists.reverse((List)llllllllllIllllllIIIlIIIlllIlllI)) {
                    if (llllllllllIllllllIIIlIIIlllIllIl != null) {
                        this.addEntry(llllllllllIllllllIIIlIIIlllIllIl.getGameProfile(), llllllllllIllllllIIIlIIIlllIllIl.getExpirationDate());
                    }
                }
            }
        }
        catch (FileNotFoundException llllllllllIllllllIIIlIIIlllIlIlI) {}
        catch (JsonParseException llllllllllIllllllIIIlIIIlllIlIlI) {}
        finally {
            IOUtils.closeQuietly((Reader)llllllllllIllllllIIIlIIIlllIllll);
        }
        IOUtils.closeQuietly((Reader)llllllllllIllllllIIIlIIIlllIllll);
    }
    
    private void addEntry(final GameProfile llllllllllIllllllIIIlIIlIIlIllll, Date llllllllllIllllllIIIlIIlIIlIIllI) {
        final UUID llllllllllIllllllIIIlIIlIIlIllIl = llllllllllIllllllIIIlIIlIIlIllll.getId();
        if (llllllllllIllllllIIIlIIlIIlIIllI == null) {
            final Calendar llllllllllIllllllIIIlIIlIIlIllII = Calendar.getInstance();
            llllllllllIllllllIIIlIIlIIlIllII.setTime(new Date());
            llllllllllIllllllIIIlIIlIIlIllII.add(2, 1);
            llllllllllIllllllIIIlIIlIIlIIllI = llllllllllIllllllIIIlIIlIIlIllII.getTime();
        }
        final String llllllllllIllllllIIIlIIlIIlIlIll = llllllllllIllllllIIIlIIlIIlIllll.getName().toLowerCase(Locale.ROOT);
        final ProfileEntry llllllllllIllllllIIIlIIlIIlIlIlI = new ProfileEntry(llllllllllIllllllIIIlIIlIIlIllll, llllllllllIllllllIIIlIIlIIlIIllI, (ProfileEntry)null);
        if (this.uuidToProfileEntryMap.containsKey(llllllllllIllllllIIIlIIlIIlIllIl)) {
            final ProfileEntry llllllllllIllllllIIIlIIlIIlIlIIl = this.uuidToProfileEntryMap.get(llllllllllIllllllIIIlIIlIIlIllIl);
            this.usernameToProfileEntryMap.remove(llllllllllIllllllIIIlIIlIIlIlIIl.getGameProfile().getName().toLowerCase(Locale.ROOT));
            this.gameProfiles.remove(llllllllllIllllllIIIlIIlIIlIllll);
        }
        this.usernameToProfileEntryMap.put(llllllllllIllllllIIIlIIlIIlIllll.getName().toLowerCase(Locale.ROOT), llllllllllIllllllIIIlIIlIIlIlIlI);
        this.uuidToProfileEntryMap.put(llllllllllIllllllIIIlIIlIIlIllIl, llllllllllIllllllIIIlIIlIIlIlIlI);
        this.gameProfiles.addFirst(llllllllllIllllllIIIlIIlIIlIllll);
        this.save();
    }
    
    private static GameProfile lookupProfile(final GameProfileRepository llllllllllIllllllIIIlIIlIlIIIllI, final String llllllllllIllllllIIIlIIlIlIIlIll) {
        final GameProfile[] llllllllllIllllllIIIlIIlIlIIlIlI = { null };
        final ProfileLookupCallback llllllllllIllllllIIIlIIlIlIIlIIl = (ProfileLookupCallback)new ProfileLookupCallback() {
            public void onProfileLookupSucceeded(final GameProfile llllllllllIlllIlIllIlIIllIlllllI) {
                llllllllllIllllllIIIlIIlIlIIlIlI[0] = llllllllllIlllIlIllIlIIllIlllllI;
            }
            
            public void onProfileLookupFailed(final GameProfile llllllllllIlllIlIllIlIIllIlllIll, final Exception llllllllllIlllIlIllIlIIllIlllIlI) {
                llllllllllIllllllIIIlIIlIlIIlIlI[0] = null;
            }
        };
        llllllllllIllllllIIIlIIlIlIIIllI.findProfilesByNames(new String[] { llllllllllIllllllIIIlIIlIlIIlIll }, Agent.MINECRAFT, llllllllllIllllllIIIlIIlIlIIlIIl);
        if (!isOnlineMode() && llllllllllIllllllIIIlIIlIlIIlIlI[0] == null) {
            final UUID llllllllllIllllllIIIlIIlIlIIlIII = EntityPlayer.getUUID(new GameProfile((UUID)null, llllllllllIllllllIIIlIIlIlIIlIll));
            final GameProfile llllllllllIllllllIIIlIIlIlIIIlll = new GameProfile(llllllllllIllllllIIIlIIlIlIIlIII, llllllllllIllllllIIIlIIlIlIIlIll);
            llllllllllIllllllIIIlIIlIlIIlIIl.onProfileLookupSucceeded(llllllllllIllllllIIIlIIlIlIIIlll);
        }
        return llllllllllIllllllIIIlIIlIlIIlIlI[0];
    }
    
    public static void setOnlineMode(final boolean llllllllllIllllllIIIlIIlIIlllllI) {
        PlayerProfileCache.onlineMode = llllllllllIllllllIIIlIIlIIlllllI;
    }
    
    @Nullable
    public GameProfile getGameProfileForUsername(final String llllllllllIllllllIIIlIIlIIIlIlIl) {
        final String llllllllllIllllllIIIlIIlIIIllIlI = llllllllllIllllllIIIlIIlIIIlIlIl.toLowerCase(Locale.ROOT);
        ProfileEntry llllllllllIllllllIIIlIIlIIIllIIl = this.usernameToProfileEntryMap.get(llllllllllIllllllIIIlIIlIIIllIlI);
        if (llllllllllIllllllIIIlIIlIIIllIIl != null && new Date().getTime() >= llllllllllIllllllIIIlIIlIIIllIIl.expirationDate.getTime()) {
            this.uuidToProfileEntryMap.remove(llllllllllIllllllIIIlIIlIIIllIIl.getGameProfile().getId());
            this.usernameToProfileEntryMap.remove(llllllllllIllllllIIIlIIlIIIllIIl.getGameProfile().getName().toLowerCase(Locale.ROOT));
            this.gameProfiles.remove(llllllllllIllllllIIIlIIlIIIllIIl.getGameProfile());
            llllllllllIllllllIIIlIIlIIIllIIl = null;
        }
        if (llllllllllIllllllIIIlIIlIIIllIIl != null) {
            final GameProfile llllllllllIllllllIIIlIIlIIIllIII = llllllllllIllllllIIIlIIlIIIllIIl.getGameProfile();
            this.gameProfiles.remove(llllllllllIllllllIIIlIIlIIIllIII);
            this.gameProfiles.addFirst(llllllllllIllllllIIIlIIlIIIllIII);
        }
        else {
            final GameProfile llllllllllIllllllIIIlIIlIIIlIlll = lookupProfile(this.profileRepo, llllllllllIllllllIIIlIIlIIIllIlI);
            if (llllllllllIllllllIIIlIIlIIIlIlll != null) {
                this.addEntry(llllllllllIllllllIIIlIIlIIIlIlll);
                llllllllllIllllllIIIlIIlIIIllIIl = this.usernameToProfileEntryMap.get(llllllllllIllllllIIIlIIlIIIllIlI);
            }
        }
        this.save();
        return (llllllllllIllllllIIIlIIlIIIllIIl == null) ? null : llllllllllIllllllIIIlIIlIIIllIIl.getGameProfile();
    }
    
    public void save() {
        final String llllllllllIllllllIIIlIIIlllIIIII = this.gson.toJson((Object)this.getEntriesWithLimit(1000));
        BufferedWriter llllllllllIllllllIIIlIIIllIlllll = null;
        try {
            llllllllllIllllllIIIlIIIllIlllll = Files.newWriter(this.usercacheFile, StandardCharsets.UTF_8);
            llllllllllIllllllIIIlIIIllIlllll.write(llllllllllIllllllIIIlIIIlllIIIII);
        }
        catch (FileNotFoundException llllllllllIllllllIIIlIIIllIllIlI) {}
        catch (IOException llllllllllIllllllIIIlIIIllIllllI) {}
        finally {
            IOUtils.closeQuietly((Writer)llllllllllIllllllIIIlIIIllIlllll);
        }
    }
    
    static {
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        TYPE = new ParameterizedType() {
            @Override
            public Type getOwnerType() {
                return null;
            }
            
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { ProfileEntry.class };
            }
            
            @Override
            public Type getRawType() {
                return List.class;
            }
        };
    }
    
    public String[] getUsernames() {
        final List<String> llllllllllIllllllIIIlIIlIIIIlllI = (List<String>)Lists.newArrayList((Iterable)this.usernameToProfileEntryMap.keySet());
        return llllllllllIllllllIIIlIIlIIIIlllI.toArray(new String[llllllllllIllllllIIIlIIlIIIIlllI.size()]);
    }
    
    class ProfileEntry
    {
        private final /* synthetic */ Date expirationDate;
        private final /* synthetic */ GameProfile gameProfile;
        
        public GameProfile getGameProfile() {
            return this.gameProfile;
        }
        
        private ProfileEntry(final GameProfile lllllllllllIIllIlIllllIlIIIIIIII, final Date lllllllllllIIllIlIllllIIlllllIll) {
            this.gameProfile = lllllllllllIIllIlIllllIlIIIIIIII;
            this.expirationDate = lllllllllllIIllIlIllllIIlllllIll;
        }
        
        public Date getExpirationDate() {
            return this.expirationDate;
        }
    }
    
    class Serializer implements JsonDeserializer<ProfileEntry>, JsonSerializer<ProfileEntry>
    {
        public JsonElement serialize(final ProfileEntry llllllllllllIlIlIlIlIIIIIllIIlII, final Type llllllllllllIlIlIlIlIIIIIllIlIII, final JsonSerializationContext llllllllllllIlIlIlIlIIIIIllIIlll) {
            final JsonObject llllllllllllIlIlIlIlIIIIIllIIllI = new JsonObject();
            llllllllllllIlIlIlIlIIIIIllIIllI.addProperty("name", llllllllllllIlIlIlIlIIIIIllIIlII.getGameProfile().getName());
            final UUID llllllllllllIlIlIlIlIIIIIllIIlIl = llllllllllllIlIlIlIlIIIIIllIIlII.getGameProfile().getId();
            llllllllllllIlIlIlIlIIIIIllIIllI.addProperty("uuid", (llllllllllllIlIlIlIlIIIIIllIIlIl == null) ? "" : llllllllllllIlIlIlIlIIIIIllIIlIl.toString());
            llllllllllllIlIlIlIlIIIIIllIIllI.addProperty("expiresOn", PlayerProfileCache.DATE_FORMAT.format(llllllllllllIlIlIlIlIIIIIllIIlII.getExpirationDate()));
            return (JsonElement)llllllllllllIlIlIlIlIIIIIllIIllI;
        }
        
        public ProfileEntry deserialize(final JsonElement llllllllllllIlIlIlIlIIIIIlIlIlIl, final Type llllllllllllIlIlIlIlIIIIIlIlIlII, final JsonDeserializationContext llllllllllllIlIlIlIlIIIIIlIlIIll) throws JsonParseException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: invokevirtual   com/google/gson/JsonElement.isJsonObject:()Z
            //     4: ifeq            152
            //     7: aload_1         /* llllllllllllIlIlIlIlIIIIIlIIIllI */
            //     8: invokevirtual   com/google/gson/JsonElement.getAsJsonObject:()Lcom/google/gson/JsonObject;
            //    11: astore          llllllllllllIlIlIlIlIIIIIlIlIIlI
            //    13: aload           llllllllllllIlIlIlIlIIIIIlIlIIlI
            //    15: ldc             "name"
            //    17: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
            //    20: astore          llllllllllllIlIlIlIlIIIIIlIlIIIl
            //    22: aload           llllllllllllIlIlIlIlIIIIIlIlIIlI
            //    24: ldc             "uuid"
            //    26: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
            //    29: astore          llllllllllllIlIlIlIlIIIIIlIlIIII
            //    31: aload           llllllllllllIlIlIlIlIIIIIlIlIIlI
            //    33: ldc             "expiresOn"
            //    35: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
            //    38: astore          llllllllllllIlIlIlIlIIIIIlIIllll
            //    40: aload           llllllllllllIlIlIlIlIIIIIlIlIIIl
            //    42: ifnull          150
            //    45: aload           llllllllllllIlIlIlIlIIIIIlIlIIII
            //    47: ifnull          150
            //    50: aload           llllllllllllIlIlIlIlIIIIIlIlIIII
            //    52: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
            //    55: astore          llllllllllllIlIlIlIlIIIIIlIIlllI
            //    57: aload           llllllllllllIlIlIlIlIIIIIlIlIIIl
            //    59: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
            //    62: astore          llllllllllllIlIlIlIlIIIIIlIIllIl
            //    64: aconst_null    
            //    65: astore          llllllllllllIlIlIlIlIIIIIlIIllII
            //    67: aload           llllllllllllIlIlIlIlIIIIIlIIllll
            //    69: ifnull          93
            //    72: getstatic       net/minecraft/server/management/PlayerProfileCache.DATE_FORMAT:Ljava/text/SimpleDateFormat;
            //    75: aload           llllllllllllIlIlIlIlIIIIIlIIllll
            //    77: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
            //    80: invokevirtual   java/text/SimpleDateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
            //    83: astore          llllllllllllIlIlIlIlIIIIIlIIllII
            //    85: goto            93
            //    88: astore          llllllllllllIlIlIlIlIIIIIlIIlIll
            //    90: aconst_null    
            //    91: astore          llllllllllllIlIlIlIlIIIIIlIIllII
            //    93: aload           llllllllllllIlIlIlIlIIIIIlIIllIl
            //    95: ifnull          148
            //    98: aload           llllllllllllIlIlIlIlIIIIIlIIlllI
            //   100: ifnull          148
            //   103: aload           llllllllllllIlIlIlIlIIIIIlIIlllI
            //   105: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
            //   108: astore          llllllllllllIlIlIlIlIIIIIlIIlIlI
            //   110: goto            117
            //   113: astore          llllllllllllIlIlIlIlIIIIIlIIlIII
            //   115: aconst_null    
            //   116: areturn        
            //   117: new             Lnet/minecraft/server/management/PlayerProfileCache$ProfileEntry;
            //   120: dup            
            //   121: aload_0         /* llllllllllllIlIlIlIlIIIIIlIlIllI */
            //   122: getfield        net/minecraft/server/management/PlayerProfileCache$Serializer.this$0:Lnet/minecraft/server/management/PlayerProfileCache;
            //   125: dup            
            //   126: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
            //   129: pop            
            //   130: new             Lcom/mojang/authlib/GameProfile;
            //   133: dup            
            //   134: aload           llllllllllllIlIlIlIlIIIIIlIIlIIl
            //   136: aload           llllllllllllIlIlIlIlIIIIIlIIllIl
            //   138: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
            //   141: aload           llllllllllllIlIlIlIlIIIIIlIIllII
            //   143: aconst_null    
            //   144: invokespecial   net/minecraft/server/management/PlayerProfileCache$ProfileEntry.<init>:(Lnet/minecraft/server/management/PlayerProfileCache;Lcom/mojang/authlib/GameProfile;Ljava/util/Date;Lnet/minecraft/server/management/PlayerProfileCache$ProfileEntry;)V
            //   147: areturn        
            //   148: aconst_null    
            //   149: areturn        
            //   150: aconst_null    
            //   151: areturn        
            //   152: aconst_null    
            //   153: areturn        
            //    Exceptions:
            //  throws com.google.gson.JsonParseException
            //    StackMapTable: 00 07 FF 00 58 00 0B 07 00 02 07 00 6F 07 00 5A 07 00 B8 07 00 15 07 00 6F 07 00 6F 07 00 6F 07 00 5E 07 00 5E 07 00 BA 00 01 07 00 6B 04 53 07 00 6D FC 00 03 07 00 33 FA 00 1E F8 00 01 FF 00 01 00 04 07 00 02 07 00 6F 07 00 5A 07 00 B8 00 00
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                      
            //  -----  -----  -----  -----  --------------------------
            //  72     85     88     93     Ljava/text/ParseException;
            //  103    110    113    117    Ljava/lang/Throwable;
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        private Serializer() {
        }
    }
}
