// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.lang3.ArrayUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.network.PacketBuffer;
import java.util.function.Function;
import java.util.Arrays;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.util.text.TextComponentString;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import java.util.Set;
import java.util.Map;

public class Advancement
{
    private final /* synthetic */ Map<String, Criterion> field_192080_e;
    private final /* synthetic */ String[][] field_192081_f;
    private final /* synthetic */ Advancement field_192076_a;
    private final /* synthetic */ AdvancementRewards field_192078_c;
    private final /* synthetic */ Set<Advancement> field_192082_g;
    private final /* synthetic */ DisplayInfo field_192077_b;
    private final /* synthetic */ ResourceLocation field_192079_d;
    private final /* synthetic */ ITextComponent field_193125_h;
    
    @Override
    public int hashCode() {
        return this.field_192079_d.hashCode();
    }
    
    public Advancement(final ResourceLocation lllllllllllIIlIlIllIIllllIlllIII, @Nullable final Advancement lllllllllllIIlIlIllIIlllllIIIIIl, @Nullable final DisplayInfo lllllllllllIIlIlIllIIlllllIIIIII, final AdvancementRewards lllllllllllIIlIlIllIIllllIllIlIl, final Map<String, Criterion> lllllllllllIIlIlIllIIllllIlllllI, final String[][] lllllllllllIIlIlIllIIllllIllllIl) {
        this.field_192082_g = (Set<Advancement>)Sets.newLinkedHashSet();
        this.field_192079_d = lllllllllllIIlIlIllIIllllIlllIII;
        this.field_192077_b = lllllllllllIIlIlIllIIlllllIIIIII;
        this.field_192080_e = (Map<String, Criterion>)ImmutableMap.copyOf((Map)lllllllllllIIlIlIllIIllllIlllllI);
        this.field_192076_a = lllllllllllIIlIlIllIIlllllIIIIIl;
        this.field_192078_c = lllllllllllIIlIlIllIIllllIllIlIl;
        this.field_192081_f = lllllllllllIIlIlIllIIllllIllllIl;
        if (lllllllllllIIlIlIllIIlllllIIIIIl != null) {
            lllllllllllIIlIlIllIIlllllIIIIIl.func_192071_a(this);
        }
        if (lllllllllllIIlIlIllIIlllllIIIIII == null) {
            this.field_193125_h = new TextComponentString(lllllllllllIIlIlIllIIllllIlllIII.toString());
        }
        else {
            this.field_193125_h = new TextComponentString("[");
            this.field_193125_h.getStyle().setColor(lllllllllllIIlIlIllIIlllllIIIIII.func_192291_d().func_193229_c());
            final ITextComponent lllllllllllIIlIlIllIIllllIllllII = lllllllllllIIlIlIllIIlllllIIIIII.func_192297_a().createCopy();
            final ITextComponent lllllllllllIIlIlIllIIllllIlllIll = new TextComponentString("");
            final ITextComponent lllllllllllIIlIlIllIIllllIlllIlI = lllllllllllIIlIlIllIIllllIllllII.createCopy();
            lllllllllllIIlIlIllIIllllIlllIlI.getStyle().setColor(lllllllllllIIlIlIllIIlllllIIIIII.func_192291_d().func_193229_c());
            lllllllllllIIlIlIllIIllllIlllIll.appendSibling(lllllllllllIIlIlIllIIllllIlllIlI);
            lllllllllllIIlIlIllIIllllIlllIll.appendText("\n");
            lllllllllllIIlIlIllIIllllIlllIll.appendSibling(lllllllllllIIlIlIllIIlllllIIIIII.func_193222_b());
            lllllllllllIIlIlIllIIllllIllllII.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, lllllllllllIIlIlIllIIllllIlllIll));
            this.field_193125_h.appendSibling(lllllllllllIIlIlIllIIllllIllllII);
            this.field_193125_h.appendText("]");
        }
    }
    
    public Builder func_192075_a() {
        return new Builder((this.field_192076_a == null) ? null : this.field_192076_a.func_192067_g(), this.field_192077_b, this.field_192078_c, this.field_192080_e, this.field_192081_f);
    }
    
    public String[][] func_192074_h() {
        return this.field_192081_f;
    }
    
    public Iterable<Advancement> func_192069_e() {
        return this.field_192082_g;
    }
    
    public int func_193124_g() {
        return this.field_192081_f.length;
    }
    
    @Nullable
    public Advancement func_192070_b() {
        return this.field_192076_a;
    }
    
    @Override
    public String toString() {
        return "SimpleAdvancement{id=" + this.func_192067_g() + ", parent=" + ((this.field_192076_a == null) ? "null" : this.field_192076_a.func_192067_g()) + ", display=" + this.field_192077_b + ", rewards=" + this.field_192078_c + ", criteria=" + this.field_192080_e + ", requirements=" + Arrays.deepToString(this.field_192081_f) + '}';
    }
    
    @Nullable
    public DisplayInfo func_192068_c() {
        return this.field_192077_b;
    }
    
    public void func_192071_a(final Advancement lllllllllllIIlIlIllIIllllIIlIIlI) {
        this.field_192082_g.add(lllllllllllIIlIlIllIIllllIIlIIlI);
    }
    
    @Override
    public boolean equals(final Object lllllllllllIIlIlIllIIllllIIIlIlI) {
        if (this == lllllllllllIIlIlIllIIllllIIIlIlI) {
            return true;
        }
        if (!(lllllllllllIIlIlIllIIllllIIIlIlI instanceof Advancement)) {
            return false;
        }
        final Advancement lllllllllllIIlIlIllIIllllIIIlIIl = (Advancement)lllllllllllIIlIlIllIIllllIIIlIlI;
        return this.field_192079_d.equals(lllllllllllIIlIlIllIIllllIIIlIIl.field_192079_d);
    }
    
    public ResourceLocation func_192067_g() {
        return this.field_192079_d;
    }
    
    public Map<String, Criterion> func_192073_f() {
        return this.field_192080_e;
    }
    
    public ITextComponent func_193123_j() {
        return this.field_193125_h;
    }
    
    public AdvancementRewards func_192072_d() {
        return this.field_192078_c;
    }
    
    public static class Builder
    {
        private final /* synthetic */ DisplayInfo field_192063_c;
        private final /* synthetic */ AdvancementRewards field_192064_d;
        private final /* synthetic */ Map<String, Criterion> field_192065_e;
        private /* synthetic */ Advancement field_192062_b;
        private final /* synthetic */ String[][] field_192066_f;
        private final /* synthetic */ ResourceLocation field_192061_a;
        
        public boolean func_192058_a(final Function<ResourceLocation, Advancement> lllllllllllIlIllllIllIlllIIlIIIl) {
            if (this.field_192061_a == null) {
                return true;
            }
            this.field_192062_b = lllllllllllIlIllllIllIlllIIlIIIl.apply(this.field_192061_a);
            return this.field_192062_b != null;
        }
        
        public Advancement func_192056_a(final ResourceLocation lllllllllllIlIllllIllIlllIIIlIll) {
            return new Advancement(lllllllllllIlIllllIllIlllIIIlIll, this.field_192062_b, this.field_192063_c, this.field_192064_d, this.field_192065_e, this.field_192066_f);
        }
        
        @Override
        public String toString() {
            return "Task Advancement{parentId=" + this.field_192061_a + ", display=" + this.field_192063_c + ", rewards=" + this.field_192064_d + ", criteria=" + this.field_192065_e + ", requirements=" + Arrays.deepToString(this.field_192066_f) + '}';
        }
        
        public void func_192057_a(final PacketBuffer lllllllllllIlIllllIllIllIllllIIl) {
            if (this.field_192061_a == null) {
                lllllllllllIlIllllIllIllIllllIIl.writeBoolean(false);
            }
            else {
                lllllllllllIlIllllIllIllIllllIIl.writeBoolean(true);
                lllllllllllIlIllllIllIllIllllIIl.func_192572_a(this.field_192061_a);
            }
            if (this.field_192063_c == null) {
                lllllllllllIlIllllIllIllIllllIIl.writeBoolean(false);
            }
            else {
                lllllllllllIlIllllIllIllIllllIIl.writeBoolean(true);
                this.field_192063_c.func_192290_a(lllllllllllIlIllllIllIllIllllIIl);
            }
            Criterion.func_192141_a(this.field_192065_e, lllllllllllIlIllllIllIllIllllIIl);
            lllllllllllIlIllllIllIllIllllIIl.writeVarIntToBuffer(this.field_192066_f.length);
            final String lllllllllllIlIllllIllIllIlllIlIl;
            final char lllllllllllIlIllllIllIllIlllIllI = (char)((String[][])(Object)(lllllllllllIlIllllIllIllIlllIlIl = (String)(Object)this.field_192066_f)).length;
            for (float lllllllllllIlIllllIllIllIlllIlll = 0; lllllllllllIlIllllIllIllIlllIlll < lllllllllllIlIllllIllIllIlllIllI; ++lllllllllllIlIllllIllIllIlllIlll) {
                final String[] lllllllllllIlIllllIllIllIlllllII = lllllllllllIlIllllIllIllIlllIlIl[lllllllllllIlIllllIllIllIlllIlll];
                lllllllllllIlIllllIllIllIllllIIl.writeVarIntToBuffer(lllllllllllIlIllllIllIllIlllllII.length);
                long lllllllllllIlIllllIllIllIlllIIIl;
                for (float lllllllllllIlIllllIllIllIlllIIlI = ((String[])(Object)(lllllllllllIlIllllIllIllIlllIIIl = (long)(Object)lllllllllllIlIllllIllIllIlllllII)).length, lllllllllllIlIllllIllIllIlllIIll = 0; lllllllllllIlIllllIllIllIlllIIll < lllllllllllIlIllllIllIllIlllIIlI; ++lllllllllllIlIllllIllIllIlllIIll) {
                    final String lllllllllllIlIllllIllIllIllllIll = lllllllllllIlIllllIllIllIlllIIIl[lllllllllllIlIllllIllIllIlllIIll];
                    lllllllllllIlIllllIllIllIllllIIl.writeString(lllllllllllIlIllllIllIllIllllIll);
                }
            }
        }
        
        public static Builder func_192059_a(final JsonObject lllllllllllIlIllllIllIllIlIIlIll, final JsonDeserializationContext lllllllllllIlIllllIllIllIlIlllII) {
            final ResourceLocation lllllllllllIlIllllIllIllIlIllIll = lllllllllllIlIllllIllIllIlIIlIll.has("parent") ? new ResourceLocation(JsonUtils.getString(lllllllllllIlIllllIllIllIlIIlIll, "parent")) : null;
            final DisplayInfo lllllllllllIlIllllIllIllIlIllIlI = lllllllllllIlIllllIllIllIlIIlIll.has("display") ? DisplayInfo.func_192294_a(JsonUtils.getJsonObject(lllllllllllIlIllllIllIllIlIIlIll, "display"), lllllllllllIlIllllIllIllIlIlllII) : null;
            final AdvancementRewards lllllllllllIlIllllIllIllIlIllIIl = JsonUtils.deserializeClass(lllllllllllIlIllllIllIllIlIIlIll, "rewards", AdvancementRewards.field_192114_a, lllllllllllIlIllllIllIllIlIlllII, AdvancementRewards.class);
            final Map<String, Criterion> lllllllllllIlIllllIllIllIlIllIII = Criterion.func_192144_b(JsonUtils.getJsonObject(lllllllllllIlIllllIllIllIlIIlIll, "criteria"), lllllllllllIlIllllIllIllIlIlllII);
            if (lllllllllllIlIllllIllIllIlIllIII.isEmpty()) {
                throw new JsonSyntaxException("Advancement criteria cannot be empty");
            }
            final JsonArray lllllllllllIlIllllIllIllIlIlIlll = JsonUtils.getJsonArray(lllllllllllIlIllllIllIllIlIIlIll, "requirements", new JsonArray());
            String[][] lllllllllllIlIllllIllIllIlIlIllI = new String[lllllllllllIlIllllIllIllIlIlIlll.size()][];
            for (int lllllllllllIlIllllIllIllIlIlIlIl = 0; lllllllllllIlIllllIllIllIlIlIlIl < lllllllllllIlIllllIllIllIlIlIlll.size(); ++lllllllllllIlIllllIllIllIlIlIlIl) {
                final JsonArray lllllllllllIlIllllIllIllIlIlIlII = JsonUtils.getJsonArray(lllllllllllIlIllllIllIllIlIlIlll.get(lllllllllllIlIllllIllIllIlIlIlIl), "requirements[" + lllllllllllIlIllllIllIllIlIlIlIl + "]");
                lllllllllllIlIllllIllIllIlIlIllI[lllllllllllIlIllllIllIllIlIlIlIl] = new String[lllllllllllIlIllllIllIllIlIlIlII.size()];
                for (int lllllllllllIlIllllIllIllIlIlIIll = 0; lllllllllllIlIllllIllIllIlIlIIll < lllllllllllIlIllllIllIllIlIlIlII.size(); ++lllllllllllIlIllllIllIllIlIlIIll) {
                    lllllllllllIlIllllIllIllIlIlIllI[lllllllllllIlIllllIllIllIlIlIlIl][lllllllllllIlIllllIllIllIlIlIIll] = JsonUtils.getString(lllllllllllIlIllllIllIllIlIlIlII.get(lllllllllllIlIllllIllIllIlIlIIll), "requirements[" + lllllllllllIlIllllIllIllIlIlIlIl + "][" + lllllllllllIlIllllIllIllIlIlIIll + "]");
                }
            }
            if (lllllllllllIlIllllIllIllIlIlIllI.length == 0) {
                lllllllllllIlIllllIllIllIlIlIllI = new String[lllllllllllIlIllllIllIllIlIllIII.size()][];
                int lllllllllllIlIllllIllIllIlIlIIlI = 0;
                for (final String lllllllllllIlIllllIllIllIlIlIIIl : lllllllllllIlIllllIllIllIlIllIII.keySet()) {
                    lllllllllllIlIllllIllIllIlIlIllI[lllllllllllIlIllllIllIllIlIlIIlI++] = new String[] { lllllllllllIlIllllIllIllIlIlIIIl };
                }
            }
            String[][] array;
            for (int length = (array = lllllllllllIlIllllIllIllIlIlIllI).length, i = 0; i < length; ++i) {
                final String[] lllllllllllIlIllllIllIllIlIlIIII = array[i];
                if (lllllllllllIlIllllIllIllIlIlIIII.length == 0 && lllllllllllIlIllllIllIllIlIllIII.isEmpty()) {
                    throw new JsonSyntaxException("Requirement entry cannot be empty");
                }
                final double lllllllllllIlIllllIllIllIIllllII;
                final String lllllllllllIlIllllIllIllIIllllIl = (String)((String[])(Object)(lllllllllllIlIllllIllIllIIllllII = (double)(Object)lllllllllllIlIllllIllIllIlIlIIII)).length;
                for (short lllllllllllIlIllllIllIllIIlllllI = 0; lllllllllllIlIllllIllIllIIlllllI < lllllllllllIlIllllIllIllIIllllIl; ++lllllllllllIlIllllIllIllIIlllllI) {
                    final String lllllllllllIlIllllIllIllIlIIllll = lllllllllllIlIllllIllIllIIllllII[lllllllllllIlIllllIllIllIIlllllI];
                    if (!lllllllllllIlIllllIllIllIlIllIII.containsKey(lllllllllllIlIllllIllIllIlIIllll)) {
                        throw new JsonSyntaxException("Unknown required criterion '" + lllllllllllIlIllllIllIllIlIIllll + "'");
                    }
                }
            }
            for (final String lllllllllllIlIllllIllIllIlIIlllI : lllllllllllIlIllllIllIllIlIllIII.keySet()) {
                boolean lllllllllllIlIllllIllIllIlIIllIl = false;
                final String lllllllllllIlIllllIllIllIIllllIl;
                final short lllllllllllIlIllllIllIllIIlllllI = (short)((String[][])(Object)(lllllllllllIlIllllIllIllIIllllIl = (String)(Object)lllllllllllIlIllllIllIllIlIlIllI)).length;
                for (Exception lllllllllllIlIllllIllIllIIllllll = (Exception)0; lllllllllllIlIllllIllIllIIllllll < lllllllllllIlIllllIllIllIIlllllI; ++lllllllllllIlIllllIllIllIIllllll) {
                    final String[] lllllllllllIlIllllIllIllIlIIllII = lllllllllllIlIllllIllIllIIllllIl[lllllllllllIlIllllIllIllIIllllll];
                    if (ArrayUtils.contains((Object[])lllllllllllIlIllllIllIllIlIIllII, (Object)lllllllllllIlIllllIllIllIlIIlllI)) {
                        lllllllllllIlIllllIllIllIlIIllIl = true;
                        break;
                    }
                }
                if (!lllllllllllIlIllllIllIllIlIIllIl) {
                    throw new JsonSyntaxException("Criterion '" + lllllllllllIlIllllIllIllIlIIlllI + "' isn't a requirement for completion. This isn't supported behaviour, all criteria must be required.");
                }
            }
            return new Builder(lllllllllllIlIllllIllIllIlIllIll, lllllllllllIlIllllIllIllIlIllIlI, lllllllllllIlIllllIllIllIlIllIIl, lllllllllllIlIllllIllIllIlIllIII, lllllllllllIlIllllIllIllIlIlIllI);
        }
        
        Builder(@Nullable final ResourceLocation lllllllllllIlIllllIllIlllIIllIIl, @Nullable final DisplayInfo lllllllllllIlIllllIllIlllIIllllI, final AdvancementRewards lllllllllllIlIllllIllIlllIIlllIl, final Map<String, Criterion> lllllllllllIlIllllIllIlllIIlllII, final String[][] lllllllllllIlIllllIllIlllIIllIll) {
            this.field_192061_a = lllllllllllIlIllllIllIlllIIllIIl;
            this.field_192063_c = lllllllllllIlIllllIllIlllIIllllI;
            this.field_192064_d = lllllllllllIlIllllIllIlllIIlllIl;
            this.field_192065_e = lllllllllllIlIllllIllIlllIIlllII;
            this.field_192066_f = lllllllllllIlIllllIllIlllIIllIll;
        }
        
        public static Builder func_192060_b(final PacketBuffer lllllllllllIlIllllIllIllIIlIllIl) throws IOException {
            final ResourceLocation lllllllllllIlIllllIllIllIIllIIll = lllllllllllIlIllllIllIllIIlIllIl.readBoolean() ? lllllllllllIlIllllIllIllIIlIllIl.func_192575_l() : null;
            final DisplayInfo lllllllllllIlIllllIllIllIIllIIlI = lllllllllllIlIllllIllIllIIlIllIl.readBoolean() ? DisplayInfo.func_192295_b(lllllllllllIlIllllIllIllIIlIllIl) : null;
            final Map<String, Criterion> lllllllllllIlIllllIllIllIIllIIIl = Criterion.func_192142_c(lllllllllllIlIllllIllIllIIlIllIl);
            final String[][] lllllllllllIlIllllIllIllIIllIIII = new String[lllllllllllIlIllllIllIllIIlIllIl.readVarIntFromBuffer()][];
            for (int lllllllllllIlIllllIllIllIIlIllll = 0; lllllllllllIlIllllIllIllIIlIllll < lllllllllllIlIllllIllIllIIllIIII.length; ++lllllllllllIlIllllIllIllIIlIllll) {
                lllllllllllIlIllllIllIllIIllIIII[lllllllllllIlIllllIllIllIIlIllll] = new String[lllllllllllIlIllllIllIllIIlIllIl.readVarIntFromBuffer()];
                for (int lllllllllllIlIllllIllIllIIlIlllI = 0; lllllllllllIlIllllIllIllIIlIlllI < lllllllllllIlIllllIllIllIIllIIII[lllllllllllIlIllllIllIllIIlIllll].length; ++lllllllllllIlIllllIllIllIIlIlllI) {
                    lllllllllllIlIllllIllIllIIllIIII[lllllllllllIlIllllIllIllIIlIllll][lllllllllllIlIllllIllIllIIlIlllI] = lllllllllllIlIllllIllIllIIlIllIl.readStringFromBuffer(32767);
                }
            }
            return new Builder(lllllllllllIlIllllIllIllIIllIIll, lllllllllllIlIllllIllIllIIllIIlI, AdvancementRewards.field_192114_a, lllllllllllIlIllllIllIllIIllIIIl, lllllllllllIlIllllIllIllIIllIIII);
        }
    }
}
