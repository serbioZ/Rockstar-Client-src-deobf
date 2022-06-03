// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.conditions;

import net.minecraft.util.ResourceLocation;
import java.util.Set;
import com.google.gson.JsonElement;
import com.google.common.collect.Maps;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.entity.Entity;
import java.util.Random;
import net.minecraft.world.storage.loot.RandomValueRange;
import java.util.Map;
import net.minecraft.world.storage.loot.LootContext;

public class EntityHasScore implements LootCondition
{
    private final /* synthetic */ LootContext.EntityTarget target;
    private final /* synthetic */ Map<String, RandomValueRange> scores;
    
    @Override
    public boolean testCondition(final Random lllllllllllIIlIIIllIlIlllIIIIlll, final LootContext lllllllllllIIlIIIllIlIlllIIIIllI) {
        final Entity lllllllllllIIlIIIllIlIlllIIIIlIl = lllllllllllIIlIIIllIlIlllIIIIllI.getEntity(this.target);
        if (lllllllllllIIlIIIllIlIlllIIIIlIl == null) {
            return false;
        }
        final Scoreboard lllllllllllIIlIIIllIlIlllIIIIlII = lllllllllllIIlIIIllIlIlllIIIIlIl.world.getScoreboard();
        for (final Map.Entry<String, RandomValueRange> lllllllllllIIlIIIllIlIlllIIIIIll : this.scores.entrySet()) {
            if (!this.entityScoreMatch(lllllllllllIIlIIIllIlIlllIIIIlIl, lllllllllllIIlIIIllIlIlllIIIIlII, lllllllllllIIlIIIllIlIlllIIIIIll.getKey(), lllllllllllIIlIIIllIlIlllIIIIIll.getValue())) {
                return false;
            }
        }
        return true;
    }
    
    protected boolean entityScoreMatch(final Entity lllllllllllIIlIIIllIlIllIlllIlIl, final Scoreboard lllllllllllIIlIIIllIlIllIlllIlII, final String lllllllllllIIlIIIllIlIllIllIllIl, final RandomValueRange lllllllllllIIlIIIllIlIllIlllIIlI) {
        final ScoreObjective lllllllllllIIlIIIllIlIllIlllIIIl = lllllllllllIIlIIIllIlIllIlllIlII.getObjective(lllllllllllIIlIIIllIlIllIllIllIl);
        if (lllllllllllIIlIIIllIlIllIlllIIIl == null) {
            return false;
        }
        final String lllllllllllIIlIIIllIlIllIlllIIII = (lllllllllllIIlIIIllIlIllIlllIlIl instanceof EntityPlayerMP) ? lllllllllllIIlIIIllIlIllIlllIlIl.getName() : lllllllllllIIlIIIllIlIllIlllIlIl.getCachedUniqueIdString();
        return lllllllllllIIlIIIllIlIllIlllIlII.entityHasObjective(lllllllllllIIlIIIllIlIllIlllIIII, lllllllllllIIlIIIllIlIllIlllIIIl) && lllllllllllIIlIIIllIlIllIlllIIlI.isInRange(lllllllllllIIlIIIllIlIllIlllIlII.getOrCreateScore(lllllllllllIIlIIIllIlIllIlllIIII, lllllllllllIIlIIIllIlIllIlllIIIl).getScorePoints());
    }
    
    public EntityHasScore(final Map<String, RandomValueRange> lllllllllllIIlIIIllIlIlllIIlIIll, final LootContext.EntityTarget lllllllllllIIlIIIllIlIlllIIIllll) {
        this.scores = lllllllllllIIlIIIllIlIlllIIlIIll;
        this.target = lllllllllllIIlIIIllIlIlllIIIllll;
    }
    
    public static class Serializer extends LootCondition.Serializer<EntityHasScore>
    {
        @Override
        public EntityHasScore deserialize(final JsonObject llllllllllIllllIllIlIIIllIIIIllI, final JsonDeserializationContext llllllllllIllllIllIlIIIllIIIIlIl) {
            final Set<Map.Entry<String, JsonElement>> llllllllllIllllIllIlIIIllIIIlIIl = (Set<Map.Entry<String, JsonElement>>)JsonUtils.getJsonObject(llllllllllIllllIllIlIIIllIIIIllI, "scores").entrySet();
            final Map<String, RandomValueRange> llllllllllIllllIllIlIIIllIIIlIII = (Map<String, RandomValueRange>)Maps.newLinkedHashMap();
            for (final Map.Entry<String, JsonElement> llllllllllIllllIllIlIIIllIIIIlll : llllllllllIllllIllIlIIIllIIIlIIl) {
                llllllllllIllllIllIlIIIllIIIlIII.put(llllllllllIllllIllIlIIIllIIIIlll.getKey(), JsonUtils.deserializeClass((JsonElement)llllllllllIllllIllIlIIIllIIIIlll.getValue(), "score", llllllllllIllllIllIlIIIllIIIIlIl, (Class<? extends RandomValueRange>)RandomValueRange.class));
            }
            return new EntityHasScore(llllllllllIllllIllIlIIIllIIIlIII, JsonUtils.deserializeClass(llllllllllIllllIllIlIIIllIIIIllI, "entity", llllllllllIllllIllIlIIIllIIIIlIl, (Class<? extends LootContext.EntityTarget>)LootContext.EntityTarget.class));
        }
        
        @Override
        public void serialize(final JsonObject llllllllllIllllIllIlIIIllIIllIII, final EntityHasScore llllllllllIllllIllIlIIIllIIlIlll, final JsonSerializationContext llllllllllIllllIllIlIIIllIIllIll) {
            final JsonObject llllllllllIllllIllIlIIIllIIllIlI = new JsonObject();
            for (final Map.Entry<String, RandomValueRange> llllllllllIllllIllIlIIIllIIllIIl : llllllllllIllllIllIlIIIllIIlIlll.scores.entrySet()) {
                llllllllllIllllIllIlIIIllIIllIlI.add((String)llllllllllIllllIllIlIIIllIIllIIl.getKey(), llllllllllIllllIllIlIIIllIIllIll.serialize((Object)llllllllllIllllIllIlIIIllIIllIIl.getValue()));
            }
            llllllllllIllllIllIlIIIllIIllIII.add("scores", (JsonElement)llllllllllIllllIllIlIIIllIIllIlI);
            llllllllllIllllIllIlIIIllIIllIII.add("entity", llllllllllIllllIllIlIIIllIIllIll.serialize((Object)llllllllllIllllIllIlIIIllIIlIlll.target));
        }
        
        protected Serializer() {
            super(new ResourceLocation("entity_scores"), EntityHasScore.class);
        }
    }
}
