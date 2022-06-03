// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot;

import java.util.Iterator;
import com.google.gson.JsonParseException;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import org.apache.commons.lang3.ArrayUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import net.minecraft.util.math.MathHelper;
import java.util.List;
import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import com.google.common.collect.Lists;
import java.util.Random;
import net.minecraft.item.ItemStack;
import java.util.Collection;
import net.minecraft.world.storage.loot.conditions.LootCondition;

public class LootPool
{
    private final /* synthetic */ LootEntry[] lootEntries;
    private final /* synthetic */ LootCondition[] poolConditions;
    private final /* synthetic */ RandomValueRange rolls;
    private final /* synthetic */ RandomValueRange bonusRolls;
    
    protected void createLootRoll(final Collection<ItemStack> llllllllllllIllIIIIlIIlIIlIllllI, final Random llllllllllllIllIIIIlIIlIIlIlIIll, final LootContext llllllllllllIllIIIIlIIlIIlIlllII) {
        final List<LootEntry> llllllllllllIllIIIIlIIlIIlIllIll = (List<LootEntry>)Lists.newArrayList();
        int llllllllllllIllIIIIlIIlIIlIllIlI = 0;
        final char llllllllllllIllIIIIlIIlIIlIIllII;
        double llllllllllllIllIIIIlIIlIIlIIllIl = ((LootEntry[])(Object)(llllllllllllIllIIIIlIIlIIlIIllII = (char)(Object)this.lootEntries)).length;
        for (Exception llllllllllllIllIIIIlIIlIIlIIlllI = (Exception)0; llllllllllllIllIIIIlIIlIIlIIlllI < llllllllllllIllIIIIlIIlIIlIIllIl; ++llllllllllllIllIIIIlIIlIIlIIlllI) {
            final LootEntry llllllllllllIllIIIIlIIlIIlIllIIl = llllllllllllIllIIIIlIIlIIlIIllII[llllllllllllIllIIIIlIIlIIlIIlllI];
            if (LootConditionManager.testAllConditions(llllllllllllIllIIIIlIIlIIlIllIIl.conditions, llllllllllllIllIIIIlIIlIIlIlIIll, llllllllllllIllIIIIlIIlIIlIlllII)) {
                final int llllllllllllIllIIIIlIIlIIlIllIII = llllllllllllIllIIIIlIIlIIlIllIIl.getEffectiveWeight(llllllllllllIllIIIIlIIlIIlIlllII.getLuck());
                if (llllllllllllIllIIIIlIIlIIlIllIII > 0) {
                    llllllllllllIllIIIIlIIlIIlIllIll.add(llllllllllllIllIIIIlIIlIIlIllIIl);
                    llllllllllllIllIIIIlIIlIIlIllIlI += llllllllllllIllIIIIlIIlIIlIllIII;
                }
            }
        }
        if (llllllllllllIllIIIIlIIlIIlIllIlI != 0 && !llllllllllllIllIIIIlIIlIIlIllIll.isEmpty()) {
            int llllllllllllIllIIIIlIIlIIlIlIlll = llllllllllllIllIIIIlIIlIIlIlIIll.nextInt(llllllllllllIllIIIIlIIlIIlIllIlI);
            llllllllllllIllIIIIlIIlIIlIIllIl = (double)llllllllllllIllIIIIlIIlIIlIllIll.iterator();
            while (((Iterator)llllllllllllIllIIIIlIIlIIlIIllIl).hasNext()) {
                final LootEntry llllllllllllIllIIIIlIIlIIlIlIllI = ((Iterator<LootEntry>)llllllllllllIllIIIIlIIlIIlIIllIl).next();
                llllllllllllIllIIIIlIIlIIlIlIlll -= llllllllllllIllIIIIlIIlIIlIlIllI.getEffectiveWeight(llllllllllllIllIIIIlIIlIIlIlllII.getLuck());
                if (llllllllllllIllIIIIlIIlIIlIlIlll < 0) {
                    llllllllllllIllIIIIlIIlIIlIlIllI.addLoot(llllllllllllIllIIIIlIIlIIlIllllI, llllllllllllIllIIIIlIIlIIlIlIIll, llllllllllllIllIIIIlIIlIIlIlllII);
                }
            }
        }
    }
    
    public LootPool(final LootEntry[] llllllllllllIllIIIIlIIlIIllIlllI, final LootCondition[] llllllllllllIllIIIIlIIlIIlllIIlI, final RandomValueRange llllllllllllIllIIIIlIIlIIlllIIIl, final RandomValueRange llllllllllllIllIIIIlIIlIIllIlIll) {
        this.lootEntries = llllllllllllIllIIIIlIIlIIllIlllI;
        this.poolConditions = llllllllllllIllIIIIlIIlIIlllIIlI;
        this.rolls = llllllllllllIllIIIIlIIlIIlllIIIl;
        this.bonusRolls = llllllllllllIllIIIIlIIlIIllIlIll;
    }
    
    public void generateLoot(final Collection<ItemStack> llllllllllllIllIIIIlIIlIIIllllIl, final Random llllllllllllIllIIIIlIIlIIIllllII, final LootContext llllllllllllIllIIIIlIIlIIlIIIIIl) {
        if (LootConditionManager.testAllConditions(this.poolConditions, llllllllllllIllIIIIlIIlIIIllllII, llllllllllllIllIIIIlIIlIIlIIIIIl)) {
            for (int llllllllllllIllIIIIlIIlIIlIIIIII = this.rolls.generateInt(llllllllllllIllIIIIlIIlIIIllllII) + MathHelper.floor(this.bonusRolls.generateFloat(llllllllllllIllIIIIlIIlIIIllllII) * llllllllllllIllIIIIlIIlIIlIIIIIl.getLuck()), llllllllllllIllIIIIlIIlIIIllllll = 0; llllllllllllIllIIIIlIIlIIIllllll < llllllllllllIllIIIIlIIlIIlIIIIII; ++llllllllllllIllIIIIlIIlIIIllllll) {
                this.createLootRoll(llllllllllllIllIIIIlIIlIIIllllIl, llllllllllllIllIIIIlIIlIIIllllII, llllllllllllIllIIIIlIIlIIlIIIIIl);
            }
        }
    }
    
    public static class Serializer implements JsonDeserializer<LootPool>, JsonSerializer<LootPool>
    {
        public JsonElement serialize(final LootPool lllllllllllIllIllllIIlIlllIIIIll, final Type lllllllllllIllIllllIIlIlllIIIllI, final JsonSerializationContext lllllllllllIllIllllIIlIlllIIIIlI) {
            final JsonObject lllllllllllIllIllllIIlIlllIIIlII = new JsonObject();
            lllllllllllIllIllllIIlIlllIIIlII.add("entries", lllllllllllIllIllllIIlIlllIIIIlI.serialize((Object)lllllllllllIllIllllIIlIlllIIIIll.lootEntries));
            lllllllllllIllIllllIIlIlllIIIlII.add("rolls", lllllllllllIllIllllIIlIlllIIIIlI.serialize((Object)lllllllllllIllIllllIIlIlllIIIIll.rolls));
            if (lllllllllllIllIllllIIlIlllIIIIll.bonusRolls.getMin() != 0.0f && lllllllllllIllIllllIIlIlllIIIIll.bonusRolls.getMax() != 0.0f) {
                lllllllllllIllIllllIIlIlllIIIlII.add("bonus_rolls", lllllllllllIllIllllIIlIlllIIIIlI.serialize((Object)lllllllllllIllIllllIIlIlllIIIIll.bonusRolls));
            }
            if (!ArrayUtils.isEmpty((Object[])lllllllllllIllIllllIIlIlllIIIIll.poolConditions)) {
                lllllllllllIllIllllIIlIlllIIIlII.add("conditions", lllllllllllIllIllllIIlIlllIIIIlI.serialize((Object)lllllllllllIllIllllIIlIlllIIIIll.poolConditions));
            }
            return (JsonElement)lllllllllllIllIllllIIlIlllIIIlII;
        }
        
        public LootPool deserialize(final JsonElement lllllllllllIllIllllIIlIlllIlIIlI, final Type lllllllllllIllIllllIIlIlllIllIIl, final JsonDeserializationContext lllllllllllIllIllllIIlIlllIllIII) throws JsonParseException {
            final JsonObject lllllllllllIllIllllIIlIlllIlIlll = JsonUtils.getJsonObject(lllllllllllIllIllllIIlIlllIlIIlI, "loot pool");
            final LootEntry[] lllllllllllIllIllllIIlIlllIlIllI = JsonUtils.deserializeClass(lllllllllllIllIllllIIlIlllIlIlll, "entries", lllllllllllIllIllllIIlIlllIllIII, (Class<? extends LootEntry[]>)LootEntry[].class);
            final LootCondition[] lllllllllllIllIllllIIlIlllIlIlIl = JsonUtils.deserializeClass(lllllllllllIllIllllIIlIlllIlIlll, "conditions", new LootCondition[0], lllllllllllIllIllllIIlIlllIllIII, LootCondition[].class);
            final RandomValueRange lllllllllllIllIllllIIlIlllIlIlII = JsonUtils.deserializeClass(lllllllllllIllIllllIIlIlllIlIlll, "rolls", lllllllllllIllIllllIIlIlllIllIII, (Class<? extends RandomValueRange>)RandomValueRange.class);
            final RandomValueRange lllllllllllIllIllllIIlIlllIlIIll = JsonUtils.deserializeClass(lllllllllllIllIllllIIlIlllIlIlll, "bonus_rolls", new RandomValueRange(0.0f, 0.0f), lllllllllllIllIllllIIlIlllIllIII, RandomValueRange.class);
            return new LootPool(lllllllllllIllIllllIIlIlllIlIllI, lllllllllllIllIllllIIlIlllIlIlIl, lllllllllllIllIllllIIlIlllIlIlII, lllllllllllIllIllllIIlIlllIlIIll);
        }
    }
}
