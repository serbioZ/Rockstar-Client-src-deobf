// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.functions;

import com.google.gson.JsonSerializationContext;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.RandomValueRange;

public class SetCount extends LootFunction
{
    private final /* synthetic */ RandomValueRange countRange;
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllIIlIllIllIIlIllIllllI, final Random lllllllllllIIlIllIllIIlIllIlllIl, final LootContext lllllllllllIIlIllIllIIlIlllIIIII) {
        lllllllllllIIlIllIllIIlIllIllllI.func_190920_e(this.countRange.generateInt(lllllllllllIIlIllIllIIlIllIlllIl));
        return lllllllllllIIlIllIllIIlIllIllllI;
    }
    
    public SetCount(final LootCondition[] lllllllllllIIlIllIllIIlIlllIlIII, final RandomValueRange lllllllllllIIlIllIllIIlIlllIlIlI) {
        super(lllllllllllIIlIllIllIIlIlllIlIII);
        this.countRange = lllllllllllIIlIllIllIIlIlllIlIlI;
    }
    
    public static class Serializer extends LootFunction.Serializer<SetCount>
    {
        protected Serializer() {
            super(new ResourceLocation("set_count"), SetCount.class);
        }
        
        @Override
        public SetCount deserialize(final JsonObject lllllllllllIIlllIlIIIIllIlIIlIII, final JsonDeserializationContext lllllllllllIIlllIlIIIIllIlIIIlll, final LootCondition[] lllllllllllIIlllIlIIIIllIlIIIllI) {
            return new SetCount(lllllllllllIIlllIlIIIIllIlIIIllI, JsonUtils.deserializeClass(lllllllllllIIlllIlIIIIllIlIIlIII, "count", lllllllllllIIlllIlIIIIllIlIIIlll, (Class<? extends RandomValueRange>)RandomValueRange.class));
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllIIlllIlIIIIllIlIIllll, final SetCount lllllllllllIIlllIlIIIIllIlIlIIIl, final JsonSerializationContext lllllllllllIIlllIlIIIIllIlIIllIl) {
            lllllllllllIIlllIlIIIIllIlIIllll.add("count", lllllllllllIIlllIlIIIIllIlIIllIl.serialize((Object)lllllllllllIIlllIlIIIIllIlIlIIIl.countRange));
        }
    }
}
