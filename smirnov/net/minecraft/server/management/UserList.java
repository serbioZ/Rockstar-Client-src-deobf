// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;
import com.google.common.collect.Maps;
import java.io.BufferedWriter;
import java.util.Collection;
import java.io.Writer;
import org.apache.commons.io.IOUtils;
import com.google.common.io.Files;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.lang.reflect.Type;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import com.google.gson.JsonObject;
import java.io.File;
import com.google.gson.Gson;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.ParameterizedType;

public class UserList<K, V extends UserListEntry<K>>
{
    protected static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Map<String, V> values;
    protected final /* synthetic */ Gson gson;
    private /* synthetic */ boolean lanServer;
    private final /* synthetic */ File saveFile;
    
    protected UserListEntry<K> createEntry(final JsonObject lllllllllllIlIlIlIIIIIllIIIIIIlI) {
        return new UserListEntry<K>(null, lllllllllllIlIlIlIIIIIllIIIIIIlI);
    }
    
    public void removeEntry(final K lllllllllllIlIlIlIIIIIllIIIlllll) {
        this.values.remove(this.getObjectKey(lllllllllllIlIlIlIIIIIllIIIlllll));
        try {
            this.writeChanges();
        }
        catch (IOException lllllllllllIlIlIlIIIIIllIIlIIIIl) {
            UserList.LOGGER.warn("Could not save the list after removing a user.", (Throwable)lllllllllllIlIlIlIIIIIllIIlIIIIl);
        }
    }
    
    protected boolean hasEntry(final K lllllllllllIlIlIlIIIIIllIIIlIIll) {
        return this.values.containsKey(this.getObjectKey(lllllllllllIlIlIlIIIIIllIIIlIIll));
    }
    
    static {
        LOGGER = LogManager.getLogger();
        USER_LIST_ENTRY_TYPE = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { UserListEntry.class };
            }
            
            @Override
            public Type getOwnerType() {
                return null;
            }
            
            @Override
            public Type getRawType() {
                return List.class;
            }
        };
    }
    
    public void addEntry(final V lllllllllllIlIlIlIIIIIllIIllIIIl) {
        this.values.put(this.getObjectKey(lllllllllllIlIlIlIIIIIllIIllIIIl.getValue()), lllllllllllIlIlIlIIIIIllIIllIIIl);
        try {
            this.writeChanges();
        }
        catch (IOException lllllllllllIlIlIlIIIIIllIIllIIII) {
            UserList.LOGGER.warn("Could not save the list after adding a user.", (Throwable)lllllllllllIlIlIlIIIIIllIIllIIII);
        }
    }
    
    public boolean isLanServer() {
        return this.lanServer;
    }
    
    public void setLanServer(final boolean lllllllllllIlIlIlIIIIIllIIllIllI) {
        this.lanServer = lllllllllllIlIlIlIIIIIllIIllIllI;
    }
    
    public void writeChanges() throws IOException {
        final Collection<V> lllllllllllIlIlIlIIIIIlIllllIlll = this.values.values();
        final String lllllllllllIlIlIlIIIIIlIllllIllI = this.gson.toJson((Object)lllllllllllIlIlIlIIIIIlIllllIlll);
        BufferedWriter lllllllllllIlIlIlIIIIIlIllllIlIl = null;
        try {
            lllllllllllIlIlIlIIIIIlIllllIlIl = Files.newWriter(this.saveFile, StandardCharsets.UTF_8);
            lllllllllllIlIlIlIIIIIlIllllIlIl.write(lllllllllllIlIlIlIIIIIlIllllIllI);
        }
        finally {
            IOUtils.closeQuietly((Writer)lllllllllllIlIlIlIIIIIlIllllIlIl);
        }
        IOUtils.closeQuietly((Writer)lllllllllllIlIlIlIIIIIlIllllIlIl);
    }
    
    public UserList(final File lllllllllllIlIlIlIIIIIllIlIIIIll) {
        this.values = (Map<String, V>)Maps.newHashMap();
        this.lanServer = true;
        this.saveFile = lllllllllllIlIlIlIIIIIllIlIIIIll;
        final GsonBuilder lllllllllllIlIlIlIIIIIllIlIIIIlI = new GsonBuilder().setPrettyPrinting();
        lllllllllllIlIlIlIIIIIllIlIIIIlI.registerTypeHierarchyAdapter((Class)UserListEntry.class, (Object)new Serializer((Serializer)null));
        this.gson = lllllllllllIlIlIlIIIIIllIlIIIIlI.create();
    }
    
    private void removeExpired() {
        final List<K> lllllllllllIlIlIlIIIIIllIIIIlIll = (List<K>)Lists.newArrayList();
        for (final V lllllllllllIlIlIlIIIIIllIIIIlIlI : this.values.values()) {
            if (lllllllllllIlIlIlIIIIIllIIIIlIlI.hasBanExpired()) {
                lllllllllllIlIlIlIIIIIllIIIIlIll.add(lllllllllllIlIlIlIIIIIllIIIIlIlI.getValue());
            }
        }
        for (final K lllllllllllIlIlIlIIIIIllIIIIlIIl : lllllllllllIlIlIlIIIIIllIIIIlIll) {
            this.values.remove(lllllllllllIlIlIlIIIIIllIIIIlIIl);
        }
    }
    
    public V getEntry(final K lllllllllllIlIlIlIIIIIllIIlIIlll) {
        this.removeExpired();
        return this.values.get(this.getObjectKey(lllllllllllIlIlIlIIIIIllIIlIIlll));
    }
    
    public String[] getKeys() {
        return this.values.keySet().toArray(new String[this.values.size()]);
    }
    
    protected String getObjectKey(final K lllllllllllIlIlIlIIIIIllIIIlIlll) {
        return lllllllllllIlIlIlIIIIIllIIIlIlll.toString();
    }
    
    protected Map<String, V> getValues() {
        return this.values;
    }
    
    class Serializer implements JsonDeserializer<UserListEntry<K>>, JsonSerializer<UserListEntry<K>>
    {
        public UserListEntry<K> deserialize(final JsonElement lllllllllllIIllllIlIlIIlIIIIlIIl, final Type lllllllllllIIllllIlIlIIlIIIIllIl, final JsonDeserializationContext lllllllllllIIllllIlIlIIlIIIIllII) throws JsonParseException {
            if (lllllllllllIIllllIlIlIIlIIIIlIIl.isJsonObject()) {
                final JsonObject lllllllllllIIllllIlIlIIlIIIIlIll = lllllllllllIIllllIlIlIIlIIIIlIIl.getAsJsonObject();
                return UserList.this.createEntry(lllllllllllIIllllIlIlIIlIIIIlIll);
            }
            return null;
        }
        
        private Serializer() {
        }
        
        public JsonElement serialize(final UserListEntry<K> lllllllllllIIllllIlIlIIlIIIlIlII, final Type lllllllllllIIllllIlIlIIlIIIlIlll, final JsonSerializationContext lllllllllllIIllllIlIlIIlIIIlIllI) {
            final JsonObject lllllllllllIIllllIlIlIIlIIIlIlIl = new JsonObject();
            lllllllllllIIllllIlIlIIlIIIlIlII.onSerialization(lllllllllllIIllllIlIlIIlIIIlIlIl);
            return (JsonElement)lllllllllllIIllllIlIlIIlIIIlIlIl;
        }
    }
}
