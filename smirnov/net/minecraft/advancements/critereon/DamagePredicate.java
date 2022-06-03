// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonElement;
import javax.annotation.Nullable;

public class DamagePredicate
{
    private final /* synthetic */ MinMaxBounds field_192368_c;
    private final /* synthetic */ Boolean field_192370_e;
    private final /* synthetic */ DamageSourcePredicate field_192371_f;
    private final /* synthetic */ MinMaxBounds field_192367_b;
    private final /* synthetic */ EntityPredicate field_192369_d;
    public static /* synthetic */ DamagePredicate field_192366_a;
    
    public DamagePredicate(final MinMaxBounds llllllllllllIlIIIlllllllIIlIIlII, final MinMaxBounds llllllllllllIlIIIlllllllIIlIIIll, final EntityPredicate llllllllllllIlIIIlllllllIIlIlIII, @Nullable final Boolean llllllllllllIlIIIlllllllIIlIIlll, final DamageSourcePredicate llllllllllllIlIIIlllllllIIlIIIII) {
        this.field_192367_b = llllllllllllIlIIIlllllllIIlIIlII;
        this.field_192368_c = llllllllllllIlIIIlllllllIIlIIIll;
        this.field_192369_d = llllllllllllIlIIIlllllllIIlIlIII;
        this.field_192370_e = llllllllllllIlIIIlllllllIIlIIlll;
        this.field_192371_f = llllllllllllIlIIIlllllllIIlIIIII;
    }
    
    static {
        DamagePredicate.field_192366_a = new DamagePredicate();
    }
    
    public DamagePredicate() {
        this.field_192367_b = MinMaxBounds.field_192516_a;
        this.field_192368_c = MinMaxBounds.field_192516_a;
        this.field_192369_d = EntityPredicate.field_192483_a;
        this.field_192370_e = null;
        this.field_192371_f = DamageSourcePredicate.field_192449_a;
    }
    
    public static DamagePredicate func_192364_a(@Nullable final JsonElement llllllllllllIlIIIlllllllIIIIIllI) {
        if (llllllllllllIlIIIlllllllIIIIIllI != null && !llllllllllllIlIIIlllllllIIIIIllI.isJsonNull()) {
            final JsonObject llllllllllllIlIIIlllllllIIIIIlIl = JsonUtils.getJsonObject(llllllllllllIlIIIlllllllIIIIIllI, "damage");
            final MinMaxBounds llllllllllllIlIIIlllllllIIIIIlII = MinMaxBounds.func_192515_a(llllllllllllIlIIIlllllllIIIIIlIl.get("dealt"));
            final MinMaxBounds llllllllllllIlIIIlllllllIIIIIIll = MinMaxBounds.func_192515_a(llllllllllllIlIIIlllllllIIIIIlIl.get("taken"));
            final Boolean llllllllllllIlIIIlllllllIIIIIIlI = llllllllllllIlIIIlllllllIIIIIlIl.has("blocked") ? Boolean.valueOf(JsonUtils.getBoolean(llllllllllllIlIIIlllllllIIIIIlIl, "blocked")) : null;
            final EntityPredicate llllllllllllIlIIIlllllllIIIIIIIl = EntityPredicate.func_192481_a(llllllllllllIlIIIlllllllIIIIIlIl.get("source_entity"));
            final DamageSourcePredicate llllllllllllIlIIIlllllllIIIIIIII = DamageSourcePredicate.func_192447_a(llllllllllllIlIIIlllllllIIIIIlIl.get("type"));
            return new DamagePredicate(llllllllllllIlIIIlllllllIIIIIlII, llllllllllllIlIIIlllllllIIIIIIll, llllllllllllIlIIIlllllllIIIIIIIl, llllllllllllIlIIIlllllllIIIIIIlI, llllllllllllIlIIIlllllllIIIIIIII);
        }
        return DamagePredicate.field_192366_a;
    }
    
    public boolean func_192365_a(final EntityPlayerMP llllllllllllIlIIIlllllllIIIllIII, final DamageSource llllllllllllIlIIIlllllllIIIlIIIl, final float llllllllllllIlIIIlllllllIIIlIIII, final float llllllllllllIlIIIlllllllIIIIllll, final boolean llllllllllllIlIIIlllllllIIIlIlII) {
        return this == DamagePredicate.field_192366_a || (this.field_192367_b.func_192514_a(llllllllllllIlIIIlllllllIIIlIIII) && this.field_192368_c.func_192514_a(llllllllllllIlIIIlllllllIIIIllll) && this.field_192369_d.func_192482_a(llllllllllllIlIIIlllllllIIIllIII, llllllllllllIlIIIlllllllIIIlIIIl.getEntity()) && (this.field_192370_e == null || this.field_192370_e == llllllllllllIlIIIlllllllIIIlIlII) && this.field_192371_f.func_193418_a(llllllllllllIlIIIlllllllIIIllIII, llllllllllllIlIIIlllllllIIIlIIIl));
    }
}
