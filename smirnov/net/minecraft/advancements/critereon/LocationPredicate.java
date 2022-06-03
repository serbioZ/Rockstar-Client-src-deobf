// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonElement;
import net.minecraft.world.WorldServer;
import net.minecraft.world.DimensionType;
import javax.annotation.Nullable;
import net.minecraft.world.biome.Biome;

public class LocationPredicate
{
    private final /* synthetic */ MinMaxBounds field_193458_d;
    private final /* synthetic */ MinMaxBounds field_193457_c;
    @Nullable
    final /* synthetic */ Biome field_193456_b;
    @Nullable
    private final /* synthetic */ String field_193460_f;
    @Nullable
    private final /* synthetic */ DimensionType field_193461_g;
    private final /* synthetic */ MinMaxBounds field_193459_e;
    public static /* synthetic */ LocationPredicate field_193455_a;
    
    public LocationPredicate(final MinMaxBounds llllllllllIlllllIlIIIIlIIIIIlIll, final MinMaxBounds llllllllllIlllllIlIIIIlIIIIIlIlI, final MinMaxBounds llllllllllIlllllIlIIIIlIIIIlIIII, @Nullable final Biome llllllllllIlllllIlIIIIlIIIIIlIII, @Nullable final String llllllllllIlllllIlIIIIlIIIIIlllI, @Nullable final DimensionType llllllllllIlllllIlIIIIlIIIIIllIl) {
        this.field_193457_c = llllllllllIlllllIlIIIIlIIIIIlIll;
        this.field_193458_d = llllllllllIlllllIlIIIIlIIIIIlIlI;
        this.field_193459_e = llllllllllIlllllIlIIIIlIIIIlIIII;
        this.field_193456_b = llllllllllIlllllIlIIIIlIIIIIlIII;
        this.field_193460_f = llllllllllIlllllIlIIIIlIIIIIlllI;
        this.field_193461_g = llllllllllIlllllIlIIIIlIIIIIllIl;
    }
    
    public boolean func_193452_a(final WorldServer llllllllllIlllllIlIIIIIllllllIlI, final double llllllllllIlllllIlIIIIIllllllllI, final double llllllllllIlllllIlIIIIIllllllIII, final double llllllllllIlllllIlIIIIIlllllllII) {
        return this.func_193453_a(llllllllllIlllllIlIIIIIllllllIlI, (float)llllllllllIlllllIlIIIIIllllllllI, (float)llllllllllIlllllIlIIIIIllllllIII, (float)llllllllllIlllllIlIIIIIlllllllII);
    }
    
    public static LocationPredicate func_193454_a(@Nullable final JsonElement llllllllllIlllllIlIIIIIlllIllIlI) {
        if (llllllllllIlllllIlIIIIIlllIllIlI != null && !llllllllllIlllllIlIIIIIlllIllIlI.isJsonNull()) {
            final JsonObject llllllllllIlllllIlIIIIIlllIllIIl = JsonUtils.getJsonObject(llllllllllIlllllIlIIIIIlllIllIlI, "location");
            final JsonObject llllllllllIlllllIlIIIIIlllIllIII = JsonUtils.getJsonObject(llllllllllIlllllIlIIIIIlllIllIIl, "position", new JsonObject());
            final MinMaxBounds llllllllllIlllllIlIIIIIlllIlIlll = MinMaxBounds.func_192515_a(llllllllllIlllllIlIIIIIlllIllIII.get("x"));
            final MinMaxBounds llllllllllIlllllIlIIIIIlllIlIllI = MinMaxBounds.func_192515_a(llllllllllIlllllIlIIIIIlllIllIII.get("y"));
            final MinMaxBounds llllllllllIlllllIlIIIIIlllIlIlIl = MinMaxBounds.func_192515_a(llllllllllIlllllIlIIIIIlllIllIII.get("z"));
            final DimensionType llllllllllIlllllIlIIIIIlllIlIlII = llllllllllIlllllIlIIIIIlllIllIIl.has("dimension") ? DimensionType.func_193417_a(JsonUtils.getString(llllllllllIlllllIlIIIIIlllIllIIl, "dimension")) : null;
            final String llllllllllIlllllIlIIIIIlllIlIIll = llllllllllIlllllIlIIIIIlllIllIIl.has("feature") ? JsonUtils.getString(llllllllllIlllllIlIIIIIlllIllIIl, "feature") : null;
            Biome llllllllllIlllllIlIIIIIlllIlIIlI = null;
            if (llllllllllIlllllIlIIIIIlllIllIIl.has("biome")) {
                final ResourceLocation llllllllllIlllllIlIIIIIlllIlIIIl = new ResourceLocation(JsonUtils.getString(llllllllllIlllllIlIIIIIlllIllIIl, "biome"));
                llllllllllIlllllIlIIIIIlllIlIIlI = Biome.REGISTRY.getObject(llllllllllIlllllIlIIIIIlllIlIIIl);
                if (llllllllllIlllllIlIIIIIlllIlIIlI == null) {
                    throw new JsonSyntaxException("Unknown biome '" + llllllllllIlllllIlIIIIIlllIlIIIl + "'");
                }
            }
            return new LocationPredicate(llllllllllIlllllIlIIIIIlllIlIlll, llllllllllIlllllIlIIIIIlllIlIllI, llllllllllIlllllIlIIIIIlllIlIlIl, llllllllllIlllllIlIIIIIlllIlIIlI, llllllllllIlllllIlIIIIIlllIlIIll, llllllllllIlllllIlIIIIIlllIlIlII);
        }
        return LocationPredicate.field_193455_a;
    }
    
    public boolean func_193453_a(final WorldServer llllllllllIlllllIlIIIIIllllIllll, final float llllllllllIlllllIlIIIIIllllIlllI, final float llllllllllIlllllIlIIIIIllllIIlll, final float llllllllllIlllllIlIIIIIllllIllII) {
        if (!this.field_193457_c.func_192514_a(llllllllllIlllllIlIIIIIllllIlllI)) {
            return false;
        }
        if (!this.field_193458_d.func_192514_a(llllllllllIlllllIlIIIIIllllIIlll)) {
            return false;
        }
        if (!this.field_193459_e.func_192514_a(llllllllllIlllllIlIIIIIllllIllII)) {
            return false;
        }
        if (this.field_193461_g != null && this.field_193461_g != llllllllllIlllllIlIIIIIllllIllll.provider.getDimensionType()) {
            return false;
        }
        final BlockPos llllllllllIlllllIlIIIIIllllIlIll = new BlockPos(llllllllllIlllllIlIIIIIllllIlllI, llllllllllIlllllIlIIIIIllllIIlll, llllllllllIlllllIlIIIIIllllIllII);
        return (this.field_193456_b == null || this.field_193456_b == llllllllllIlllllIlIIIIIllllIllll.getBiome(llllllllllIlllllIlIIIIIllllIlIll)) && (this.field_193460_f == null || llllllllllIlllllIlIIIIIllllIllll.getChunkProvider().func_193413_a(llllllllllIlllllIlIIIIIllllIllll, this.field_193460_f, llllllllllIlllllIlIIIIIllllIlIll));
    }
    
    static {
        LocationPredicate.field_193455_a = new LocationPredicate(MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a, null, null, null);
    }
}
