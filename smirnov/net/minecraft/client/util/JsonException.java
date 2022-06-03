// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.util;

import org.apache.commons.lang3.StringUtils;
import java.io.FileNotFoundException;
import com.google.common.collect.Lists;
import java.util.List;
import java.io.IOException;

public class JsonException extends IOException
{
    private final /* synthetic */ List<Entry> entries;
    private final /* synthetic */ String message;
    
    public void prependJsonKey(final String llllllllllllllIlIlIIllllIllIIIlI) {
        this.entries.get(0).addJsonKey(llllllllllllllIlIlIIllllIllIIIlI);
    }
    
    public JsonException(final String llllllllllllllIlIlIIllllIlllIIIl) {
        this.entries = (List<Entry>)Lists.newArrayList();
        this.entries.add(new Entry(null));
        this.message = llllllllllllllIlIlIIllllIlllIIIl;
    }
    
    public JsonException(final String llllllllllllllIlIlIIllllIllIllII, final Throwable llllllllllllllIlIlIIllllIllIlIII) {
        super(llllllllllllllIlIlIIllllIllIlIII);
        this.entries = (List<Entry>)Lists.newArrayList();
        this.entries.add(new Entry(null));
        this.message = llllllllllllllIlIlIIllllIllIllII;
    }
    
    public static JsonException forException(final Exception llllllllllllllIlIlIIllllIlIlIlII) {
        if (llllllllllllllIlIlIIllllIlIlIlII instanceof JsonException) {
            return (JsonException)llllllllllllllIlIlIIllllIlIlIlII;
        }
        String llllllllllllllIlIlIIllllIlIlIlIl = llllllllllllllIlIlIIllllIlIlIlII.getMessage();
        if (llllllllllllllIlIlIIllllIlIlIlII instanceof FileNotFoundException) {
            llllllllllllllIlIlIIllllIlIlIlIl = "File not found";
        }
        return new JsonException(llllllllllllllIlIlIIllllIlIlIlIl, llllllllllllllIlIlIIllllIlIlIlII);
    }
    
    public void setFilenameAndFlush(final String llllllllllllllIlIlIIllllIlIlllII) {
        Entry.access$2(this.entries.get(0), llllllllllllllIlIlIIllllIlIlllII);
        this.entries.add(0, new Entry(null));
    }
    
    @Override
    public String getMessage() {
        return "Invalid " + this.entries.get(this.entries.size() - 1) + ": " + this.message;
    }
    
    public static class Entry
    {
        private final /* synthetic */ List<String> jsonKeys;
        private /* synthetic */ String filename;
        
        private Entry() {
            this.jsonKeys = (List<String>)Lists.newArrayList();
        }
        
        static /* synthetic */ void access$2(final Entry llllllllllllIllIIlIlIIIIlIllllII, final String llllllllllllIllIIlIlIIIIlIlllIll) {
            llllllllllllIllIIlIlIIIIlIllllII.filename = llllllllllllIllIIlIlIIIIlIlllIll;
        }
        
        @Override
        public String toString() {
            if (this.filename != null) {
                return this.jsonKeys.isEmpty() ? this.filename : (String.valueOf(this.filename) + " " + this.getJsonKeys());
            }
            return this.jsonKeys.isEmpty() ? "(Unknown file)" : ("(Unknown file) " + this.getJsonKeys());
        }
        
        private void addJsonKey(final String llllllllllllIllIIlIlIIIIllIIllIl) {
            this.jsonKeys.add(0, llllllllllllIllIIlIlIIIIllIIllIl);
        }
        
        public String getJsonKeys() {
            return StringUtils.join((Iterable)this.jsonKeys, "->");
        }
    }
}
