// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import com.google.gson.stream.JsonWriter;
import javax.annotation.Nullable;
import java.io.IOException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import java.util.Map;
import com.google.common.collect.Maps;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.Locale;
import com.google.gson.TypeAdapterFactory;

public class EnumTypeAdapterFactory implements TypeAdapterFactory
{
    private String getName(final Object lllllllllllIlIlIllllllIIIllIIIII) {
        return (lllllllllllIlIlIllllllIIIllIIIII instanceof Enum) ? ((Enum)lllllllllllIlIlIllllllIIIllIIIII).name().toLowerCase(Locale.ROOT) : lllllllllllIlIlIllllllIIIllIIIII.toString().toLowerCase(Locale.ROOT);
    }
    
    @Nullable
    public <T> TypeAdapter<T> create(final Gson lllllllllllIlIlIllllllIIIllIllll, final TypeToken<T> lllllllllllIlIlIllllllIIIllIlIIl) {
        final Class<T> lllllllllllIlIlIllllllIIIllIllIl = (Class<T>)lllllllllllIlIlIllllllIIIllIlIIl.getRawType();
        if (!lllllllllllIlIlIllllllIIIllIllIl.isEnum()) {
            return null;
        }
        final Map<String, T> lllllllllllIlIlIllllllIIIllIllII = (Map<String, T>)Maps.newHashMap();
        Exception lllllllllllIlIlIllllllIIIllIIIll;
        for (long lllllllllllIlIlIllllllIIIllIIlII = ((T[])(Object)(lllllllllllIlIlIllllllIIIllIIIll = (Exception)(Object)lllllllllllIlIlIllllllIIIllIllIl.getEnumConstants())).length, lllllllllllIlIlIllllllIIIllIIlIl = 0; lllllllllllIlIlIllllllIIIllIIlIl < lllllllllllIlIlIllllllIIIllIIlII; ++lllllllllllIlIlIllllllIIIllIIlIl) {
            final T lllllllllllIlIlIllllllIIIllIlIll = lllllllllllIlIlIllllllIIIllIIIll[lllllllllllIlIlIllllllIIIllIIlIl];
            lllllllllllIlIlIllllllIIIllIllII.put(this.getName(lllllllllllIlIlIllllllIIIllIlIll), lllllllllllIlIlIllllllIIIllIlIll);
        }
        return new TypeAdapter<T>() {
            @Nullable
            public T read(final JsonReader llllllllllllIllllIIllIIlllllIllI) throws IOException {
                if (llllllllllllIllllIIllIIlllllIllI.peek() == JsonToken.NULL) {
                    llllllllllllIllllIIllIIlllllIllI.nextNull();
                    return null;
                }
                return lllllllllllIlIlIllllllIIIllIllII.get(llllllllllllIllllIIllIIlllllIllI.nextString());
            }
            
            public void write(final JsonWriter llllllllllllIllllIIllIIllllllllI, final T llllllllllllIllllIIllIIlllllllIl) throws IOException {
                if (llllllllllllIllllIIllIIlllllllIl == null) {
                    llllllllllllIllllIIllIIllllllllI.nullValue();
                }
                else {
                    llllllllllllIllllIIllIIllllllllI.value(EnumTypeAdapterFactory.this.getName(llllllllllllIllllIIllIIlllllllIl));
                }
            }
        };
    }
}
