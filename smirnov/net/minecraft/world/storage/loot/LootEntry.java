// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.item.ItemStack;
import java.util.Collection;
import net.minecraft.world.storage.loot.conditions.LootCondition;

public abstract class LootEntry
{
    protected final /* synthetic */ int quality;
    protected final /* synthetic */ int weight;
    protected final /* synthetic */ LootCondition[] conditions;
    
    public abstract void addLoot(final Collection<ItemStack> p0, final Random p1, final LootContext p2);
    
    protected LootEntry(final int lllllllllllllIIlIIllIlIlIIlIlIlI, final int lllllllllllllIIlIIllIlIlIIlIllIl, final LootCondition[] lllllllllllllIIlIIllIlIlIIlIllII) {
        this.weight = lllllllllllllIIlIIllIlIlIIlIlIlI;
        this.quality = lllllllllllllIIlIIllIlIlIIlIllIl;
        this.conditions = lllllllllllllIIlIIllIlIlIIlIllII;
    }
    
    public int getEffectiveWeight(final float lllllllllllllIIlIIllIlIlIIlIIIlI) {
        return Math.max(MathHelper.floor(this.weight + this.quality * lllllllllllllIIlIIllIlIlIIlIIIlI), 0);
    }
    
    protected abstract void serialize(final JsonObject p0, final JsonSerializationContext p1);
    
    public static class Serializer implements JsonDeserializer<LootEntry>, JsonSerializer<LootEntry>
    {
        public LootEntry deserialize(final JsonElement lllllllllllIIIIlIIIlIlIIllllIIIl, final Type lllllllllllIIIIlIIIlIlIIlllllIIl, final JsonDeserializationContext lllllllllllIIIIlIIIlIlIIlllllIII) throws JsonParseException {
            final JsonObject lllllllllllIIIIlIIIlIlIIllllIlll = JsonUtils.getJsonObject(lllllllllllIIIIlIIIlIlIIllllIIIl, "loot item");
            final String lllllllllllIIIIlIIIlIlIIllllIllI = JsonUtils.getString(lllllllllllIIIIlIIIlIlIIllllIlll, "type");
            final int lllllllllllIIIIlIIIlIlIIllllIlIl = JsonUtils.getInt(lllllllllllIIIIlIIIlIlIIllllIlll, "weight", 1);
            final int lllllllllllIIIIlIIIlIlIIllllIlII = JsonUtils.getInt(lllllllllllIIIIlIIIlIlIIllllIlll, "quality", 0);
            LootCondition[] lllllllllllIIIIlIIIlIlIIllllIIlI = null;
            if (lllllllllllIIIIlIIIlIlIIllllIlll.has("conditions")) {
                final LootCondition[] lllllllllllIIIIlIIIlIlIIllllIIll = JsonUtils.deserializeClass(lllllllllllIIIIlIIIlIlIIllllIlll, "conditions", lllllllllllIIIIlIIIlIlIIlllllIII, (Class<? extends LootCondition[]>)LootCondition[].class);
            }
            else {
                lllllllllllIIIIlIIIlIlIIllllIIlI = new LootCondition[0];
            }
            if ("item".equals(lllllllllllIIIIlIIIlIlIIllllIllI)) {
                return LootEntryItem.deserialize(lllllllllllIIIIlIIIlIlIIllllIlll, lllllllllllIIIIlIIIlIlIIlllllIII, lllllllllllIIIIlIIIlIlIIllllIlIl, lllllllllllIIIIlIIIlIlIIllllIlII, lllllllllllIIIIlIIIlIlIIllllIIlI);
            }
            if ("loot_table".equals(lllllllllllIIIIlIIIlIlIIllllIllI)) {
                return LootEntryTable.deserialize(lllllllllllIIIIlIIIlIlIIllllIlll, lllllllllllIIIIlIIIlIlIIlllllIII, lllllllllllIIIIlIIIlIlIIllllIlIl, lllllllllllIIIIlIIIlIlIIllllIlII, lllllllllllIIIIlIIIlIlIIllllIIlI);
            }
            if ("empty".equals(lllllllllllIIIIlIIIlIlIIllllIllI)) {
                return LootEntryEmpty.deserialize(lllllllllllIIIIlIIIlIlIIllllIlll, lllllllllllIIIIlIIIlIlIIlllllIII, lllllllllllIIIIlIIIlIlIIllllIlIl, lllllllllllIIIIlIIIlIlIIllllIlII, lllllllllllIIIIlIIIlIlIIllllIIlI);
            }
            throw new JsonSyntaxException("Unknown loot entry type '" + lllllllllllIIIIlIIIlIlIIllllIllI + "'");
        }
        
        public JsonElement serialize(final LootEntry lllllllllllIIIIlIIIlIlIIlllIIIlI, final Type lllllllllllIIIIlIIIlIlIIlllIIlIl, final JsonSerializationContext lllllllllllIIIIlIIIlIlIIlllIIIIl) {
            final JsonObject lllllllllllIIIIlIIIlIlIIlllIIIll = new JsonObject();
            lllllllllllIIIIlIIIlIlIIlllIIIll.addProperty("weight", (Number)lllllllllllIIIIlIIIlIlIIlllIIIlI.weight);
            lllllllllllIIIIlIIIlIlIIlllIIIll.addProperty("quality", (Number)lllllllllllIIIIlIIIlIlIIlllIIIlI.quality);
            if (lllllllllllIIIIlIIIlIlIIlllIIIlI.conditions.length > 0) {
                lllllllllllIIIIlIIIlIlIIlllIIIll.add("conditions", lllllllllllIIIIlIIIlIlIIlllIIIIl.serialize((Object)lllllllllllIIIIlIIIlIlIIlllIIIlI.conditions));
            }
            if (lllllllllllIIIIlIIIlIlIIlllIIIlI instanceof LootEntryItem) {
                lllllllllllIIIIlIIIlIlIIlllIIIll.addProperty("type", "item");
            }
            else if (lllllllllllIIIIlIIIlIlIIlllIIIlI instanceof LootEntryTable) {
                lllllllllllIIIIlIIIlIlIIlllIIIll.addProperty("type", "loot_table");
            }
            else {
                if (!(lllllllllllIIIIlIIIlIlIIlllIIIlI instanceof LootEntryEmpty)) {
                    throw new IllegalArgumentException("Don't know how to serialize " + lllllllllllIIIIlIIIlIlIIlllIIIlI);
                }
                lllllllllllIIIIlIIIlIlIIlllIIIll.addProperty("type", "empty");
            }
            lllllllllllIIIIlIIIlIlIIlllIIIlI.serialize(lllllllllllIIIIlIIIlIlIIlllIIIll, lllllllllllIIIIlIIIlIlIIlllIIIIl);
            return (JsonElement)lllllllllllIIIIlIIIlIlIIlllIIIll;
        }
    }
}
