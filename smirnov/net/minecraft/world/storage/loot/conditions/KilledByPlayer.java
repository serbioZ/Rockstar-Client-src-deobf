// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.conditions;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;

public class KilledByPlayer implements LootCondition
{
    private final /* synthetic */ boolean inverse;
    
    @Override
    public boolean testCondition(final Random lllllllllllllIlIIIIlIlIllllIIlll, final LootContext lllllllllllllIlIIIIlIlIllllIIllI) {
        final boolean lllllllllllllIlIIIIlIlIllllIIlIl = lllllllllllllIlIIIIlIlIllllIIllI.getKillerPlayer() != null;
        return lllllllllllllIlIIIIlIlIllllIIlIl == !this.inverse;
    }
    
    public KilledByPlayer(final boolean lllllllllllllIlIIIIlIlIllllIlllI) {
        this.inverse = lllllllllllllIlIIIIlIlIllllIlllI;
    }
    
    public static class Serializer extends LootCondition.Serializer<KilledByPlayer>
    {
        @Override
        public void serialize(final JsonObject llllllllllllllIlIlllIllIIllIlIIl, final KilledByPlayer llllllllllllllIlIlllIllIIllIIlIl, final JsonSerializationContext llllllllllllllIlIlllIllIIllIIlll) {
            llllllllllllllIlIlllIllIIllIlIIl.addProperty("inverse", Boolean.valueOf(llllllllllllllIlIlllIllIIllIIlIl.inverse));
        }
        
        @Override
        public KilledByPlayer deserialize(final JsonObject llllllllllllllIlIlllIllIIllIIIlI, final JsonDeserializationContext llllllllllllllIlIlllIllIIllIIIIl) {
            return new KilledByPlayer(JsonUtils.getBoolean(llllllllllllllIlIlllIllIIllIIIlI, "inverse", false));
        }
        
        protected Serializer() {
            super(new ResourceLocation("killed_by_player"), KilledByPlayer.class);
        }
    }
}
