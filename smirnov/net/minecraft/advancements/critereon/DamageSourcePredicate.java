// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import javax.annotation.Nullable;
import com.google.gson.JsonElement;

public class DamageSourcePredicate
{
    private final /* synthetic */ EntityPredicate field_193420_j;
    private final /* synthetic */ Boolean field_192455_g;
    private final /* synthetic */ Boolean field_192454_f;
    private final /* synthetic */ Boolean field_192452_d;
    private final /* synthetic */ Boolean field_192450_b;
    private final /* synthetic */ Boolean field_192451_c;
    private final /* synthetic */ Boolean field_192453_e;
    public static /* synthetic */ DamageSourcePredicate field_192449_a;
    private final /* synthetic */ EntityPredicate field_193419_i;
    private final /* synthetic */ Boolean field_192456_h;
    
    public static DamageSourcePredicate func_192447_a(@Nullable final JsonElement lllllllllllIlllIlIlllllIlIIllIlI) {
        if (lllllllllllIlllIlIlllllIlIIllIlI != null && !lllllllllllIlllIlIlllllIlIIllIlI.isJsonNull()) {
            final JsonObject lllllllllllIlllIlIlllllIlIIllIIl = JsonUtils.getJsonObject(lllllllllllIlllIlIlllllIlIIllIlI, "damage type");
            final Boolean lllllllllllIlllIlIlllllIlIIllIII = func_192448_a(lllllllllllIlllIlIlllllIlIIllIIl, "is_projectile");
            final Boolean lllllllllllIlllIlIlllllIlIIlIlll = func_192448_a(lllllllllllIlllIlIlllllIlIIllIIl, "is_explosion");
            final Boolean lllllllllllIlllIlIlllllIlIIlIllI = func_192448_a(lllllllllllIlllIlIlllllIlIIllIIl, "bypasses_armor");
            final Boolean lllllllllllIlllIlIlllllIlIIlIlIl = func_192448_a(lllllllllllIlllIlIlllllIlIIllIIl, "bypasses_invulnerability");
            final Boolean lllllllllllIlllIlIlllllIlIIlIlII = func_192448_a(lllllllllllIlllIlIlllllIlIIllIIl, "bypasses_magic");
            final Boolean lllllllllllIlllIlIlllllIlIIlIIll = func_192448_a(lllllllllllIlllIlIlllllIlIIllIIl, "is_fire");
            final Boolean lllllllllllIlllIlIlllllIlIIlIIlI = func_192448_a(lllllllllllIlllIlIlllllIlIIllIIl, "is_magic");
            final EntityPredicate lllllllllllIlllIlIlllllIlIIlIIIl = EntityPredicate.func_192481_a(lllllllllllIlllIlIlllllIlIIllIIl.get("direct_entity"));
            final EntityPredicate lllllllllllIlllIlIlllllIlIIlIIII = EntityPredicate.func_192481_a(lllllllllllIlllIlIlllllIlIIllIIl.get("source_entity"));
            return new DamageSourcePredicate(lllllllllllIlllIlIlllllIlIIllIII, lllllllllllIlllIlIlllllIlIIlIlll, lllllllllllIlllIlIlllllIlIIlIllI, lllllllllllIlllIlIlllllIlIIlIlIl, lllllllllllIlllIlIlllllIlIIlIlII, lllllllllllIlllIlIlllllIlIIlIIll, lllllllllllIlllIlIlllllIlIIlIIlI, lllllllllllIlllIlIlllllIlIIlIIIl, lllllllllllIlllIlIlllllIlIIlIIII);
        }
        return DamageSourcePredicate.field_192449_a;
    }
    
    static {
        DamageSourcePredicate.field_192449_a = new DamageSourcePredicate();
    }
    
    @Nullable
    private static Boolean func_192448_a(final JsonObject lllllllllllIlllIlIlllllIlIIIIIlI, final String lllllllllllIlllIlIlllllIlIIIIIIl) {
        return lllllllllllIlllIlIlllllIlIIIIIlI.has(lllllllllllIlllIlIlllllIlIIIIIIl) ? Boolean.valueOf(JsonUtils.getBoolean(lllllllllllIlllIlIlllllIlIIIIIlI, lllllllllllIlllIlIlllllIlIIIIIIl)) : null;
    }
    
    public boolean func_193418_a(final EntityPlayerMP lllllllllllIlllIlIlllllIlIlIIlll, final DamageSource lllllllllllIlllIlIlllllIlIlIIllI) {
        return this == DamageSourcePredicate.field_192449_a || ((this.field_192450_b == null || this.field_192450_b == lllllllllllIlllIlIlllllIlIlIIllI.isProjectile()) && (this.field_192451_c == null || this.field_192451_c == lllllllllllIlllIlIlllllIlIlIIllI.isExplosion()) && (this.field_192452_d == null || this.field_192452_d == lllllllllllIlllIlIlllllIlIlIIllI.isUnblockable()) && (this.field_192453_e == null || this.field_192453_e == lllllllllllIlllIlIlllllIlIlIIllI.canHarmInCreative()) && (this.field_192454_f == null || this.field_192454_f == lllllllllllIlllIlIlllllIlIlIIllI.isDamageAbsolute()) && (this.field_192455_g == null || this.field_192455_g == lllllllllllIlllIlIlllllIlIlIIllI.isFireDamage()) && (this.field_192456_h == null || this.field_192456_h == lllllllllllIlllIlIlllllIlIlIIllI.isMagicDamage()) && this.field_193419_i.func_192482_a(lllllllllllIlllIlIlllllIlIlIIlll, lllllllllllIlllIlIlllllIlIlIIllI.getSourceOfDamage()) && this.field_193420_j.func_192482_a(lllllllllllIlllIlIlllllIlIlIIlll, lllllllllllIlllIlIlllllIlIlIIllI.getEntity()));
    }
    
    public DamageSourcePredicate(@Nullable final Boolean lllllllllllIlllIlIlllllIlIllIlll, @Nullable final Boolean lllllllllllIlllIlIlllllIlIllIllI, @Nullable final Boolean lllllllllllIlllIlIlllllIlIllllll, @Nullable final Boolean lllllllllllIlllIlIlllllIlIlllllI, @Nullable final Boolean lllllllllllIlllIlIlllllIlIllllIl, @Nullable final Boolean lllllllllllIlllIlIlllllIlIllIIlI, @Nullable final Boolean lllllllllllIlllIlIlllllIlIlllIll, final EntityPredicate lllllllllllIlllIlIlllllIlIlllIlI, final EntityPredicate lllllllllllIlllIlIlllllIlIlllIIl) {
        this.field_192450_b = lllllllllllIlllIlIlllllIlIllIlll;
        this.field_192451_c = lllllllllllIlllIlIlllllIlIllIllI;
        this.field_192452_d = lllllllllllIlllIlIlllllIlIllllll;
        this.field_192453_e = lllllllllllIlllIlIlllllIlIlllllI;
        this.field_192454_f = lllllllllllIlllIlIlllllIlIllllIl;
        this.field_192455_g = lllllllllllIlllIlIlllllIlIllIIlI;
        this.field_192456_h = lllllllllllIlllIlIlllllIlIlllIll;
        this.field_193419_i = lllllllllllIlllIlIlllllIlIlllIlI;
        this.field_193420_j = lllllllllllIlllIlIlllllIlIlllIIl;
    }
    
    public DamageSourcePredicate() {
        this.field_192450_b = null;
        this.field_192451_c = null;
        this.field_192452_d = null;
        this.field_192453_e = null;
        this.field_192454_f = null;
        this.field_192455_g = null;
        this.field_192456_h = null;
        this.field_193419_i = EntityPredicate.field_192483_a;
        this.field_193420_j = EntityPredicate.field_192483_a;
    }
}
