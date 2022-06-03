// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import net.minecraft.util.math.MathHelper;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import javax.annotation.Nullable;
import com.google.gson.JsonElement;

public class DistancePredicate
{
    public static final /* synthetic */ DistancePredicate field_193423_a;
    private final /* synthetic */ MinMaxBounds field_193426_d;
    private final /* synthetic */ MinMaxBounds field_193424_b;
    private final /* synthetic */ MinMaxBounds field_193425_c;
    private final /* synthetic */ MinMaxBounds field_193427_e;
    private final /* synthetic */ MinMaxBounds field_193428_f;
    
    static {
        field_193423_a = new DistancePredicate(MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a);
    }
    
    public static DistancePredicate func_193421_a(@Nullable final JsonElement lllllllllllllIlllllllIIllIIllIII) {
        if (lllllllllllllIlllllllIIllIIllIII != null && !lllllllllllllIlllllllIIllIIllIII.isJsonNull()) {
            final JsonObject lllllllllllllIlllllllIIllIIlIlll = JsonUtils.getJsonObject(lllllllllllllIlllllllIIllIIllIII, "distance");
            final MinMaxBounds lllllllllllllIlllllllIIllIIlIllI = MinMaxBounds.func_192515_a(lllllllllllllIlllllllIIllIIlIlll.get("x"));
            final MinMaxBounds lllllllllllllIlllllllIIllIIlIlIl = MinMaxBounds.func_192515_a(lllllllllllllIlllllllIIllIIlIlll.get("y"));
            final MinMaxBounds lllllllllllllIlllllllIIllIIlIlII = MinMaxBounds.func_192515_a(lllllllllllllIlllllllIIllIIlIlll.get("z"));
            final MinMaxBounds lllllllllllllIlllllllIIllIIlIIll = MinMaxBounds.func_192515_a(lllllllllllllIlllllllIIllIIlIlll.get("horizontal"));
            final MinMaxBounds lllllllllllllIlllllllIIllIIlIIlI = MinMaxBounds.func_192515_a(lllllllllllllIlllllllIIllIIlIlll.get("absolute"));
            return new DistancePredicate(lllllllllllllIlllllllIIllIIlIllI, lllllllllllllIlllllllIIllIIlIlIl, lllllllllllllIlllllllIIllIIlIlII, lllllllllllllIlllllllIIllIIlIIll, lllllllllllllIlllllllIIllIIlIIlI);
        }
        return DistancePredicate.field_193423_a;
    }
    
    public boolean func_193422_a(final double lllllllllllllIlllllllIIllIlIlIII, final double lllllllllllllIlllllllIIllIlIIlll, final double lllllllllllllIlllllllIIllIlIIllI, final double lllllllllllllIlllllllIIllIlIllll, final double lllllllllllllIlllllllIIllIlIlllI, final double lllllllllllllIlllllllIIllIlIIIll) {
        final float lllllllllllllIlllllllIIllIlIllII = (float)(lllllllllllllIlllllllIIllIlIlIII - lllllllllllllIlllllllIIllIlIllll);
        final float lllllllllllllIlllllllIIllIlIlIll = (float)(lllllllllllllIlllllllIIllIlIIlll - lllllllllllllIlllllllIIllIlIlllI);
        final float lllllllllllllIlllllllIIllIlIlIlI = (float)(lllllllllllllIlllllllIIllIlIIllI - lllllllllllllIlllllllIIllIlIIIll);
        return this.field_193424_b.func_192514_a(MathHelper.abs(lllllllllllllIlllllllIIllIlIllII)) && this.field_193425_c.func_192514_a(MathHelper.abs(lllllllllllllIlllllllIIllIlIlIll)) && this.field_193426_d.func_192514_a(MathHelper.abs(lllllllllllllIlllllllIIllIlIlIlI)) && this.field_193427_e.func_192513_a(lllllllllllllIlllllllIIllIlIllII * lllllllllllllIlllllllIIllIlIllII + lllllllllllllIlllllllIIllIlIlIlI * lllllllllllllIlllllllIIllIlIlIlI) && this.field_193428_f.func_192513_a(lllllllllllllIlllllllIIllIlIllII * lllllllllllllIlllllllIIllIlIllII + lllllllllllllIlllllllIIllIlIlIll * lllllllllllllIlllllllIIllIlIlIll + lllllllllllllIlllllllIIllIlIlIlI * lllllllllllllIlllllllIIllIlIlIlI);
    }
    
    public DistancePredicate(final MinMaxBounds lllllllllllllIlllllllIIlllIIlIII, final MinMaxBounds lllllllllllllIlllllllIIlllIIIIIl, final MinMaxBounds lllllllllllllIlllllllIIlllIIIllI, final MinMaxBounds lllllllllllllIlllllllIIlllIIIlIl, final MinMaxBounds lllllllllllllIlllllllIIllIlllllI) {
        this.field_193424_b = lllllllllllllIlllllllIIlllIIlIII;
        this.field_193425_c = lllllllllllllIlllllllIIlllIIIIIl;
        this.field_193426_d = lllllllllllllIlllllllIIlllIIIllI;
        this.field_193427_e = lllllllllllllIlllllllIIlllIIIlIl;
        this.field_193428_f = lllllllllllllIlllllllIIllIlllllI;
    }
}
