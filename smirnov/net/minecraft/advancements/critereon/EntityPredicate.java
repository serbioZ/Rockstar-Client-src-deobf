// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.entity.EntityList;
import net.minecraft.util.JsonUtils;
import javax.annotation.Nullable;
import com.google.gson.JsonElement;
import net.minecraft.util.ResourceLocation;

public class EntityPredicate
{
    private final /* synthetic */ ResourceLocation field_192484_b;
    private final /* synthetic */ NBTPredicate field_193437_f;
    private final /* synthetic */ LocationPredicate field_193435_d;
    private final /* synthetic */ MobEffectsPredicate field_193436_e;
    public static final /* synthetic */ EntityPredicate field_192483_a;
    private final /* synthetic */ DistancePredicate field_192485_c;
    
    public static EntityPredicate func_192481_a(@Nullable final JsonElement lllllllllllIlIllIlIIllIlIlIlIIll) {
        if (lllllllllllIlIllIlIIllIlIlIlIIll != null && !lllllllllllIlIllIlIIllIlIlIlIIll.isJsonNull()) {
            final JsonObject lllllllllllIlIllIlIIllIlIlIlIIlI = JsonUtils.getJsonObject(lllllllllllIlIllIlIIllIlIlIlIIll, "entity");
            ResourceLocation lllllllllllIlIllIlIIllIlIlIlIIIl = null;
            if (lllllllllllIlIllIlIIllIlIlIlIIlI.has("type")) {
                lllllllllllIlIllIlIIllIlIlIlIIIl = new ResourceLocation(JsonUtils.getString(lllllllllllIlIllIlIIllIlIlIlIIlI, "type"));
                if (!EntityList.isStringValidEntityName(lllllllllllIlIllIlIIllIlIlIlIIIl)) {
                    throw new JsonSyntaxException("Unknown entity type '" + lllllllllllIlIllIlIIllIlIlIlIIIl + "', valid types are: " + EntityList.func_192840_b());
                }
            }
            final DistancePredicate lllllllllllIlIllIlIIllIlIlIlIIII = DistancePredicate.func_193421_a(lllllllllllIlIllIlIIllIlIlIlIIlI.get("distance"));
            final LocationPredicate lllllllllllIlIllIlIIllIlIlIIllll = LocationPredicate.func_193454_a(lllllllllllIlIllIlIIllIlIlIlIIlI.get("location"));
            final MobEffectsPredicate lllllllllllIlIllIlIIllIlIlIIlllI = MobEffectsPredicate.func_193471_a(lllllllllllIlIllIlIIllIlIlIlIIlI.get("effects"));
            final NBTPredicate lllllllllllIlIllIlIIllIlIlIIllIl = NBTPredicate.func_193476_a(lllllllllllIlIllIlIIllIlIlIlIIlI.get("nbt"));
            return new EntityPredicate(lllllllllllIlIllIlIIllIlIlIlIIIl, lllllllllllIlIllIlIIllIlIlIlIIII, lllllllllllIlIllIlIIllIlIlIIllll, lllllllllllIlIllIlIIllIlIlIIlllI, lllllllllllIlIllIlIIllIlIlIIllIl);
        }
        return EntityPredicate.field_192483_a;
    }
    
    public EntityPredicate(@Nullable final ResourceLocation lllllllllllIlIllIlIIllIlIllIlllI, final DistancePredicate lllllllllllIlIllIlIIllIlIllIllIl, final LocationPredicate lllllllllllIlIllIlIIllIlIllIllII, final MobEffectsPredicate lllllllllllIlIllIlIIllIlIllIlIll, final NBTPredicate lllllllllllIlIllIlIIllIlIllIlIlI) {
        this.field_192484_b = lllllllllllIlIllIlIIllIlIllIlllI;
        this.field_192485_c = lllllllllllIlIllIlIIllIlIllIllIl;
        this.field_193435_d = lllllllllllIlIllIlIIllIlIllIllII;
        this.field_193436_e = lllllllllllIlIllIlIIllIlIllIlIll;
        this.field_193437_f = lllllllllllIlIllIlIIllIlIllIlIlI;
    }
    
    static {
        field_192483_a = new EntityPredicate(null, DistancePredicate.field_193423_a, LocationPredicate.field_193455_a, MobEffectsPredicate.field_193473_a, NBTPredicate.field_193479_a);
    }
    
    public boolean func_192482_a(final EntityPlayerMP lllllllllllIlIllIlIIllIlIlIlllII, @Nullable final Entity lllllllllllIlIllIlIIllIlIlIllIll) {
        return this == EntityPredicate.field_192483_a || (lllllllllllIlIllIlIIllIlIlIllIll != null && (this.field_192484_b == null || EntityList.isStringEntityName(lllllllllllIlIllIlIIllIlIlIllIll, this.field_192484_b)) && this.field_192485_c.func_193422_a(lllllllllllIlIllIlIIllIlIlIlllII.posX, lllllllllllIlIllIlIIllIlIlIlllII.posY, lllllllllllIlIllIlIIllIlIlIlllII.posZ, lllllllllllIlIllIlIIllIlIlIllIll.posX, lllllllllllIlIllIlIIllIlIlIllIll.posY, lllllllllllIlIllIlIIllIlIlIllIll.posZ) && this.field_193435_d.func_193452_a(lllllllllllIlIllIlIIllIlIlIlllII.getServerWorld(), lllllllllllIlIllIlIIllIlIlIllIll.posX, lllllllllllIlIllIlIIllIlIlIllIll.posY, lllllllllllIlIllIlIIllIlIlIllIll.posZ) && this.field_193436_e.func_193469_a(lllllllllllIlIllIlIIllIlIlIllIll) && this.field_193437_f.func_193475_a(lllllllllllIlIllIlIIllIlIlIllIll));
    }
}
