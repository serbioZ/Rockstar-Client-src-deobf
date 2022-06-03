// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import com.google.gson.JsonParseException;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import java.util.Iterator;
import java.util.Set;
import java.util.Date;
import net.minecraft.network.PacketBuffer;
import java.util.Arrays;
import javax.annotation.Nullable;
import com.google.common.collect.Maps;
import java.util.List;
import com.google.common.collect.Lists;
import java.util.Map;

public class AdvancementProgress implements Comparable<AdvancementProgress>
{
    private final /* synthetic */ Map<String, CriterionProgress> field_192110_a;
    private /* synthetic */ String[][] field_192111_b;
    
    public Iterable<String> func_192107_d() {
        final List<String> lllllllllllIllIIlIlllllIlIIIIlIl = (List<String>)Lists.newArrayList();
        for (final Map.Entry<String, CriterionProgress> lllllllllllIllIIlIlllllIlIIIIlII : this.field_192110_a.entrySet()) {
            if (!lllllllllllIllIIlIlllllIlIIIIlII.getValue().func_192151_a()) {
                lllllllllllIllIIlIlllllIlIIIIlIl.add(lllllllllllIllIIlIlllllIlIIIIlII.getKey());
            }
        }
        return lllllllllllIllIIlIlllllIlIIIIlIl;
    }
    
    public boolean func_192105_a() {
        if (this.field_192111_b.length == 0) {
            return false;
        }
        final short lllllllllllIllIIlIlllllIlllllIll;
        final byte lllllllllllIllIIlIlllllIllllllII = (byte)((String[][])(Object)(lllllllllllIllIIlIlllllIlllllIll = (short)(Object)this.field_192111_b)).length;
        for (boolean lllllllllllIllIIlIlllllIllllllIl = false; (lllllllllllIllIIlIlllllIllllllIl ? 1 : 0) < lllllllllllIllIIlIlllllIllllllII; ++lllllllllllIllIIlIlllllIllllllIl) {
            final String[] lllllllllllIllIIlIllllllIIIIIIll = lllllllllllIllIIlIlllllIlllllIll[lllllllllllIllIIlIlllllIllllllIl];
            boolean lllllllllllIllIIlIllllllIIIIIIlI = false;
            final double lllllllllllIllIIlIlllllIllllIllI;
            final long lllllllllllIllIIlIlllllIllllIlll = ((String[])(Object)(lllllllllllIllIIlIlllllIllllIllI = (double)(Object)lllllllllllIllIIlIllllllIIIIIIll)).length;
            for (final String lllllllllllIllIIlIllllllIIIIIIIl : lllllllllllIllIIlIlllllIllllIllI) {
                final CriterionProgress lllllllllllIllIIlIllllllIIIIIIII = this.func_192106_c(lllllllllllIllIIlIllllllIIIIIIIl);
                if (lllllllllllIllIIlIllllllIIIIIIII != null && lllllllllllIllIIlIllllllIIIIIIII.func_192151_a()) {
                    lllllllllllIllIIlIllllllIIIIIIlI = true;
                    break;
                }
            }
            if (!lllllllllllIllIIlIllllllIIIIIIlI) {
                return false;
            }
        }
        return true;
    }
    
    public AdvancementProgress() {
        this.field_192110_a = (Map<String, CriterionProgress>)Maps.newHashMap();
        this.field_192111_b = new String[0][];
    }
    
    @Nullable
    public String func_193126_d() {
        if (this.field_192110_a.isEmpty()) {
            return null;
        }
        final int lllllllllllIllIIlIlllllIlIlIllIl = this.field_192111_b.length;
        if (lllllllllllIllIIlIlllllIlIlIllIl <= 1) {
            return null;
        }
        final int lllllllllllIllIIlIlllllIlIlIllII = this.func_194032_h();
        return String.valueOf(lllllllllllIllIIlIlllllIlIlIllII) + "/" + lllllllllllIllIIlIlllllIlIlIllIl;
    }
    
    public float func_192103_c() {
        if (this.field_192110_a.isEmpty()) {
            return 0.0f;
        }
        final float lllllllllllIllIIlIlllllIlIllIllI = (float)this.field_192111_b.length;
        final float lllllllllllIllIIlIlllllIlIllIlIl = (float)this.func_194032_h();
        return lllllllllllIllIIlIlllllIlIllIlIl / lllllllllllIllIIlIlllllIlIllIllI;
    }
    
    public boolean func_192108_b() {
        for (final CriterionProgress lllllllllllIllIIlIlllllIllllIIII : this.field_192110_a.values()) {
            if (lllllllllllIllIIlIlllllIllllIIII.func_192151_a()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean func_192101_b(final String lllllllllllIllIIlIlllllIllIlllII) {
        final CriterionProgress lllllllllllIllIIlIlllllIllIllllI = this.field_192110_a.get(lllllllllllIllIIlIlllllIllIlllII);
        if (lllllllllllIllIIlIlllllIllIllllI != null && lllllllllllIllIIlIlllllIllIllllI.func_192151_a()) {
            lllllllllllIllIIlIlllllIllIllllI.func_192154_c();
            return true;
        }
        return false;
    }
    
    @Nullable
    public CriterionProgress func_192106_c(final String lllllllllllIllIIlIlllllIlIllllIl) {
        return this.field_192110_a.get(lllllllllllIllIIlIlllllIlIllllIl);
    }
    
    public boolean func_192109_a(final String lllllllllllIllIIlIlllllIlllIIlIl) {
        final CriterionProgress lllllllllllIllIIlIlllllIlllIIlll = this.field_192110_a.get(lllllllllllIllIIlIlllllIlllIIlIl);
        if (lllllllllllIllIIlIlllllIlllIIlll != null && !lllllllllllIllIIlIlllllIlllIIlll.func_192151_a()) {
            lllllllllllIllIIlIlllllIlllIIlll.func_192153_b();
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "AdvancementProgress{criteria=" + this.field_192110_a + ", requirements=" + Arrays.deepToString(this.field_192111_b) + '}';
    }
    
    public Iterable<String> func_192102_e() {
        final List<String> lllllllllllIllIIlIlllllIIllllIlI = (List<String>)Lists.newArrayList();
        for (final Map.Entry<String, CriterionProgress> lllllllllllIllIIlIlllllIIllllIIl : this.field_192110_a.entrySet()) {
            if (lllllllllllIllIIlIlllllIIllllIIl.getValue().func_192151_a()) {
                lllllllllllIllIIlIlllllIIllllIlI.add(lllllllllllIllIIlIlllllIIllllIIl.getKey());
            }
        }
        return lllllllllllIllIIlIlllllIIllllIlI;
    }
    
    public void func_192104_a(final PacketBuffer lllllllllllIllIIlIlllllIllIIllll) {
        lllllllllllIllIIlIlllllIllIIllll.writeVarIntToBuffer(this.field_192110_a.size());
        for (final Map.Entry<String, CriterionProgress> lllllllllllIllIIlIlllllIllIlIIIl : this.field_192110_a.entrySet()) {
            lllllllllllIllIIlIlllllIllIIllll.writeString(lllllllllllIllIIlIlllllIllIlIIIl.getKey());
            lllllllllllIllIIlIlllllIllIlIIIl.getValue().func_192150_a(lllllllllllIllIIlIlllllIllIIllll);
        }
    }
    
    @Nullable
    public Date func_193128_g() {
        Date lllllllllllIllIIlIlllllIIllIllll = null;
        for (final CriterionProgress lllllllllllIllIIlIlllllIIllIlllI : this.field_192110_a.values()) {
            if (lllllllllllIllIIlIlllllIIllIlllI.func_192151_a() && (lllllllllllIllIIlIlllllIIllIllll == null || lllllllllllIllIIlIlllllIIllIlllI.func_193140_d().before(lllllllllllIllIIlIlllllIIllIllll))) {
                lllllllllllIllIIlIlllllIIllIllll = lllllllllllIllIIlIlllllIIllIlllI.func_193140_d();
            }
        }
        return lllllllllllIllIIlIlllllIIllIllll;
    }
    
    public void func_192099_a(final Map<String, Criterion> lllllllllllIllIIlIllllllIIIlllII, final String[][] lllllllllllIllIIlIllllllIIIlIlII) {
        final Set<String> lllllllllllIllIIlIllllllIIIllIlI = lllllllllllIllIIlIllllllIIIlllII.keySet();
        final Iterator<Map.Entry<String, CriterionProgress>> lllllllllllIllIIlIllllllIIIllIIl = this.field_192110_a.entrySet().iterator();
        while (lllllllllllIllIIlIllllllIIIllIIl.hasNext()) {
            final Map.Entry<String, CriterionProgress> lllllllllllIllIIlIllllllIIIllIII = lllllllllllIllIIlIllllllIIIllIIl.next();
            if (!lllllllllllIllIIlIllllllIIIllIlI.contains(lllllllllllIllIIlIllllllIIIllIII.getKey())) {
                lllllllllllIllIIlIllllllIIIllIIl.remove();
            }
        }
        for (final String lllllllllllIllIIlIllllllIIIlIlll : lllllllllllIllIIlIllllllIIIllIlI) {
            if (!this.field_192110_a.containsKey(lllllllllllIllIIlIllllllIIIlIlll)) {
                this.field_192110_a.put(lllllllllllIllIIlIllllllIIIlIlll, new CriterionProgress(this));
            }
        }
        this.field_192111_b = lllllllllllIllIIlIllllllIIIlIlII;
    }
    
    private int func_194032_h() {
        int lllllllllllIllIIlIlllllIlIIllIll = 0;
        final long lllllllllllIllIIlIlllllIlIIlIIIl;
        final long lllllllllllIllIIlIlllllIlIIlIIlI = ((String[][])(Object)(lllllllllllIllIIlIlllllIlIIlIIIl = (long)(Object)this.field_192111_b)).length;
        for (String lllllllllllIllIIlIlllllIlIIlIIll = (String)0; lllllllllllIllIIlIlllllIlIIlIIll < lllllllllllIllIIlIlllllIlIIlIIlI; ++lllllllllllIllIIlIlllllIlIIlIIll) {
            final String[] lllllllllllIllIIlIlllllIlIIllIlI = lllllllllllIllIIlIlllllIlIIlIIIl[lllllllllllIllIIlIlllllIlIIlIIll];
            boolean lllllllllllIllIIlIlllllIlIIllIIl = false;
            char lllllllllllIllIIlIlllllIlIIIllII;
            for (double lllllllllllIllIIlIlllllIlIIIllIl = ((String[])(Object)(lllllllllllIllIIlIlllllIlIIIllII = (char)(Object)lllllllllllIllIIlIlllllIlIIllIlI)).length, lllllllllllIllIIlIlllllIlIIIlllI = 0; lllllllllllIllIIlIlllllIlIIIlllI < lllllllllllIllIIlIlllllIlIIIllIl; ++lllllllllllIllIIlIlllllIlIIIlllI) {
                final String lllllllllllIllIIlIlllllIlIIllIII = lllllllllllIllIIlIlllllIlIIIllII[lllllllllllIllIIlIlllllIlIIIlllI];
                final CriterionProgress lllllllllllIllIIlIlllllIlIIlIlll = this.func_192106_c(lllllllllllIllIIlIlllllIlIIllIII);
                if (lllllllllllIllIIlIlllllIlIIlIlll != null && lllllllllllIllIIlIlllllIlIIlIlll.func_192151_a()) {
                    lllllllllllIllIIlIlllllIlIIllIIl = true;
                    break;
                }
            }
            if (lllllllllllIllIIlIlllllIlIIllIIl) {
                ++lllllllllllIllIIlIlllllIlIIllIll;
            }
        }
        return lllllllllllIllIIlIlllllIlIIllIll;
    }
    
    @Override
    public int compareTo(final AdvancementProgress lllllllllllIllIIlIlllllIIllIIIII) {
        final Date lllllllllllIllIIlIlllllIIllIIIll = this.func_193128_g();
        final Date lllllllllllIllIIlIlllllIIllIIIlI = lllllllllllIllIIlIlllllIIllIIIII.func_193128_g();
        if (lllllllllllIllIIlIlllllIIllIIIll == null && lllllllllllIllIIlIlllllIIllIIIlI != null) {
            return 1;
        }
        if (lllllllllllIllIIlIlllllIIllIIIll != null && lllllllllllIllIIlIlllllIIllIIIlI == null) {
            return -1;
        }
        return (lllllllllllIllIIlIlllllIIllIIIll == null && lllllllllllIllIIlIlllllIIllIIIlI == null) ? 0 : lllllllllllIllIIlIlllllIIllIIIll.compareTo(lllllllllllIllIIlIlllllIIllIIIlI);
    }
    
    public static AdvancementProgress func_192100_b(final PacketBuffer lllllllllllIllIIlIlllllIllIIlIII) {
        final AdvancementProgress lllllllllllIllIIlIlllllIllIIIlll = new AdvancementProgress();
        for (int lllllllllllIllIIlIlllllIllIIIllI = lllllllllllIllIIlIlllllIllIIlIII.readVarIntFromBuffer(), lllllllllllIllIIlIlllllIllIIIlIl = 0; lllllllllllIllIIlIlllllIllIIIlIl < lllllllllllIllIIlIlllllIllIIIllI; ++lllllllllllIllIIlIlllllIllIIIlIl) {
            lllllllllllIllIIlIlllllIllIIIlll.field_192110_a.put(lllllllllllIllIIlIlllllIllIIlIII.readStringFromBuffer(32767), CriterionProgress.func_192149_a(lllllllllllIllIIlIlllllIllIIlIII, lllllllllllIllIIlIlllllIllIIIlll));
        }
        return lllllllllllIllIIlIlllllIllIIIlll;
    }
    
    public static class Serializer implements JsonDeserializer<AdvancementProgress>, JsonSerializer<AdvancementProgress>
    {
        public JsonElement serialize(final AdvancementProgress lllllllllllIIIIlIlllIIIIIlllIlll, final Type lllllllllllIIIIlIlllIIIIIlllIllI, final JsonSerializationContext lllllllllllIIIIlIlllIIIIIlllIlIl) {
            final JsonObject lllllllllllIIIIlIlllIIIIIlllIlII = new JsonObject();
            final JsonObject lllllllllllIIIIlIlllIIIIIlllIIll = new JsonObject();
            for (final Map.Entry<String, CriterionProgress> lllllllllllIIIIlIlllIIIIIlllIIlI : lllllllllllIIIIlIlllIIIIIlllIlll.field_192110_a.entrySet()) {
                final CriterionProgress lllllllllllIIIIlIlllIIIIIlllIIIl = lllllllllllIIIIlIlllIIIIIlllIIlI.getValue();
                if (lllllllllllIIIIlIlllIIIIIlllIIIl.func_192151_a()) {
                    lllllllllllIIIIlIlllIIIIIlllIIll.add((String)lllllllllllIIIIlIlllIIIIIlllIIlI.getKey(), lllllllllllIIIIlIlllIIIIIlllIIIl.func_192148_e());
                }
            }
            if (!lllllllllllIIIIlIlllIIIIIlllIIll.entrySet().isEmpty()) {
                lllllllllllIIIIlIlllIIIIIlllIlII.add("criteria", (JsonElement)lllllllllllIIIIlIlllIIIIIlllIIll);
            }
            lllllllllllIIIIlIlllIIIIIlllIlII.addProperty("done", Boolean.valueOf(lllllllllllIIIIlIlllIIIIIlllIlll.func_192105_a()));
            return (JsonElement)lllllllllllIIIIlIlllIIIIIlllIlII;
        }
        
        public AdvancementProgress deserialize(final JsonElement lllllllllllIIIIlIlllIIIIIlIllIlI, final Type lllllllllllIIIIlIlllIIIIIllIIIIl, final JsonDeserializationContext lllllllllllIIIIlIlllIIIIIllIIIII) throws JsonParseException {
            final JsonObject lllllllllllIIIIlIlllIIIIIlIlllll = JsonUtils.getJsonObject(lllllllllllIIIIlIlllIIIIIlIllIlI, "advancement");
            final JsonObject lllllllllllIIIIlIlllIIIIIlIllllI = JsonUtils.getJsonObject(lllllllllllIIIIlIlllIIIIIlIlllll, "criteria", new JsonObject());
            final AdvancementProgress lllllllllllIIIIlIlllIIIIIlIlllIl = new AdvancementProgress();
            for (final Map.Entry<String, JsonElement> lllllllllllIIIIlIlllIIIIIlIlllII : lllllllllllIIIIlIlllIIIIIlIllllI.entrySet()) {
                final String lllllllllllIIIIlIlllIIIIIlIllIll = lllllllllllIIIIlIlllIIIIIlIlllII.getKey();
                lllllllllllIIIIlIlllIIIIIlIlllIl.field_192110_a.put(lllllllllllIIIIlIlllIIIIIlIllIll, CriterionProgress.func_192152_a(lllllllllllIIIIlIlllIIIIIlIlllIl, JsonUtils.getString(lllllllllllIIIIlIlllIIIIIlIlllII.getValue(), lllllllllllIIIIlIlllIIIIIlIllIll)));
            }
            return lllllllllllIIIIlIlllIIIIIlIlllIl;
        }
    }
}
