// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.ResourceLocation;
import com.google.common.collect.Maps;
import net.minecraft.util.JsonUtils;
import javax.annotation.Nullable;
import com.google.gson.JsonElement;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import java.util.Collections;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import java.util.Map;

public class MobEffectsPredicate
{
    private final /* synthetic */ Map<Potion, InstancePredicate> field_193474_b;
    public static final /* synthetic */ MobEffectsPredicate field_193473_a;
    
    public boolean func_193470_a(final Map<Potion, PotionEffect> lllllllllllIllIIllIlIIIllIIlllll) {
        if (this == MobEffectsPredicate.field_193473_a) {
            return true;
        }
        for (final Map.Entry<Potion, InstancePredicate> lllllllllllIllIIllIlIIIllIIllllI : this.field_193474_b.entrySet()) {
            final PotionEffect lllllllllllIllIIllIlIIIllIIlllIl = lllllllllllIllIIllIlIIIllIIlllll.get(lllllllllllIllIIllIlIIIllIIllllI.getKey());
            if (!lllllllllllIllIIllIlIIIllIIllllI.getValue().func_193463_a(lllllllllllIllIIllIlIIIllIIlllIl)) {
                return false;
            }
        }
        return true;
    }
    
    static {
        field_193473_a = new MobEffectsPredicate(Collections.emptyMap());
    }
    
    public boolean func_193469_a(final Entity lllllllllllIllIIllIlIIIllIlIllII) {
        return this == MobEffectsPredicate.field_193473_a || (lllllllllllIllIIllIlIIIllIlIllII instanceof EntityLivingBase && this.func_193470_a(((EntityLivingBase)lllllllllllIllIIllIlIIIllIlIllII).func_193076_bZ()));
    }
    
    public MobEffectsPredicate(final Map<Potion, InstancePredicate> lllllllllllIllIIllIlIIIllIllIlII) {
        this.field_193474_b = lllllllllllIllIIllIlIIIllIllIlII;
    }
    
    public boolean func_193472_a(final EntityLivingBase lllllllllllIllIIllIlIIIllIlIIllI) {
        return this == MobEffectsPredicate.field_193473_a || this.func_193470_a(lllllllllllIllIIllIlIIIllIlIIllI.func_193076_bZ());
    }
    
    public static MobEffectsPredicate func_193471_a(@Nullable final JsonElement lllllllllllIllIIllIlIIIllIIIllll) {
        if (lllllllllllIllIIllIlIIIllIIIllll != null && !lllllllllllIllIIllIlIIIllIIIllll.isJsonNull()) {
            final JsonObject lllllllllllIllIIllIlIIIllIIIlllI = JsonUtils.getJsonObject(lllllllllllIllIIllIlIIIllIIIllll, "effects");
            final Map<Potion, InstancePredicate> lllllllllllIllIIllIlIIIllIIIllIl = (Map<Potion, InstancePredicate>)Maps.newHashMap();
            for (final Map.Entry<String, JsonElement> lllllllllllIllIIllIlIIIllIIIllII : lllllllllllIllIIllIlIIIllIIIlllI.entrySet()) {
                final ResourceLocation lllllllllllIllIIllIlIIIllIIIlIll = new ResourceLocation(lllllllllllIllIIllIlIIIllIIIllII.getKey());
                final Potion lllllllllllIllIIllIlIIIllIIIlIlI = Potion.REGISTRY.getObject(lllllllllllIllIIllIlIIIllIIIlIll);
                if (lllllllllllIllIIllIlIIIllIIIlIlI == null) {
                    throw new JsonSyntaxException("Unknown effect '" + lllllllllllIllIIllIlIIIllIIIlIll + "'");
                }
                final InstancePredicate lllllllllllIllIIllIlIIIllIIIlIIl = InstancePredicate.func_193464_a(JsonUtils.getJsonObject(lllllllllllIllIIllIlIIIllIIIllII.getValue(), lllllllllllIllIIllIlIIIllIIIllII.getKey()));
                lllllllllllIllIIllIlIIIllIIIllIl.put(lllllllllllIllIIllIlIIIllIIIlIlI, lllllllllllIllIIllIlIIIllIIIlIIl);
            }
            return new MobEffectsPredicate(lllllllllllIllIIllIlIIIllIIIllIl);
        }
        return MobEffectsPredicate.field_193473_a;
    }
    
    public static class InstancePredicate
    {
        @Nullable
        private final /* synthetic */ Boolean field_193467_c;
        private final /* synthetic */ MinMaxBounds field_193465_a;
        @Nullable
        private final /* synthetic */ Boolean field_193468_d;
        private final /* synthetic */ MinMaxBounds field_193466_b;
        
        public boolean func_193463_a(@Nullable final PotionEffect llllllllllllIIIlIllIlIIllllllllI) {
            return llllllllllllIIIlIllIlIIllllllllI != null && this.field_193465_a.func_192514_a((float)llllllllllllIIIlIllIlIIllllllllI.getAmplifier()) && this.field_193466_b.func_192514_a((float)llllllllllllIIIlIllIlIIllllllllI.getDuration()) && (this.field_193467_c == null || this.field_193467_c == llllllllllllIIIlIllIlIIllllllllI.getIsAmbient()) && (this.field_193468_d == null || this.field_193468_d == llllllllllllIIIlIllIlIIllllllllI.doesShowParticles());
        }
        
        public static InstancePredicate func_193464_a(final JsonObject llllllllllllIIIlIllIlIIllllllIII) {
            final MinMaxBounds llllllllllllIIIlIllIlIIlllllIlll = MinMaxBounds.func_192515_a(llllllllllllIIIlIllIlIIllllllIII.get("amplifier"));
            final MinMaxBounds llllllllllllIIIlIllIlIIlllllIllI = MinMaxBounds.func_192515_a(llllllllllllIIIlIllIlIIllllllIII.get("duration"));
            final Boolean llllllllllllIIIlIllIlIIlllllIlIl = llllllllllllIIIlIllIlIIllllllIII.has("ambient") ? Boolean.valueOf(JsonUtils.getBoolean(llllllllllllIIIlIllIlIIllllllIII, "ambient")) : null;
            final Boolean llllllllllllIIIlIllIlIIlllllIlII = llllllllllllIIIlIllIlIIllllllIII.has("visible") ? Boolean.valueOf(JsonUtils.getBoolean(llllllllllllIIIlIllIlIIllllllIII, "visible")) : null;
            return new InstancePredicate(llllllllllllIIIlIllIlIIlllllIlll, llllllllllllIIIlIllIlIIlllllIllI, llllllllllllIIIlIllIlIIlllllIlIl, llllllllllllIIIlIllIlIIlllllIlII);
        }
        
        public InstancePredicate(final MinMaxBounds llllllllllllIIIlIllIlIlIIIIIIlll, final MinMaxBounds llllllllllllIIIlIllIlIlIIIIIIllI, @Nullable final Boolean llllllllllllIIIlIllIlIlIIIIIlIlI, @Nullable final Boolean llllllllllllIIIlIllIlIlIIIIIlIIl) {
            this.field_193465_a = llllllllllllIIIlIllIlIlIIIIIIlll;
            this.field_193466_b = llllllllllllIIIlIllIlIlIIIIIIllI;
            this.field_193467_c = llllllllllllIIIlIllIlIlIIIIIlIlI;
            this.field_193468_d = llllllllllllIIIlIllIlIlIIIIIlIIl;
        }
    }
}
