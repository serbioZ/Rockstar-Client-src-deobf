// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot;

import java.util.Random;
import net.minecraft.item.ItemStack;
import java.util.Collection;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.JsonUtils;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;

public class LootEntryTable extends LootEntry
{
    protected final /* synthetic */ ResourceLocation table;
    
    public static LootEntryTable deserialize(final JsonObject lllllllllllIIIIIIlllllIIlIIIIIlI, final JsonDeserializationContext lllllllllllIIIIIIlllllIIlIIIIIIl, final int lllllllllllIIIIIIlllllIIlIIIIIII, final int lllllllllllIIIIIIlllllIIIlllllll, final LootCondition[] lllllllllllIIIIIIlllllIIIllllllI) {
        final ResourceLocation lllllllllllIIIIIIlllllIIIlllllIl = new ResourceLocation(JsonUtils.getString(lllllllllllIIIIIIlllllIIlIIIIIlI, "name"));
        return new LootEntryTable(lllllllllllIIIIIIlllllIIIlllllIl, lllllllllllIIIIIIlllllIIlIIIIIII, lllllllllllIIIIIIlllllIIIlllllll, lllllllllllIIIIIIlllllIIIllllllI);
    }
    
    @Override
    protected void serialize(final JsonObject lllllllllllIIIIIIlllllIIlIIIlIll, final JsonSerializationContext lllllllllllIIIIIIlllllIIlIIIlIlI) {
        lllllllllllIIIIIIlllllIIlIIIlIll.addProperty("name", this.table.toString());
    }
    
    @Override
    public void addLoot(final Collection<ItemStack> lllllllllllIIIIIIlllllIIlIIlIIll, final Random lllllllllllIIIIIIlllllIIlIIlIIlI, final LootContext lllllllllllIIIIIIlllllIIlIIlIIIl) {
        final LootTable lllllllllllIIIIIIlllllIIlIIlIllI = lllllllllllIIIIIIlllllIIlIIlIIIl.getLootTableManager().getLootTableFromLocation(this.table);
        final Collection<ItemStack> lllllllllllIIIIIIlllllIIlIIlIlIl = lllllllllllIIIIIIlllllIIlIIlIllI.generateLootForPools(lllllllllllIIIIIIlllllIIlIIlIIlI, lllllllllllIIIIIIlllllIIlIIlIIIl);
        lllllllllllIIIIIIlllllIIlIIlIIll.addAll(lllllllllllIIIIIIlllllIIlIIlIlIl);
    }
    
    public LootEntryTable(final ResourceLocation lllllllllllIIIIIIlllllIIlIlIlIIl, final int lllllllllllIIIIIIlllllIIlIlIlIII, final int lllllllllllIIIIIIlllllIIlIlIIlll, final LootCondition[] lllllllllllIIIIIIlllllIIlIlIIIIl) {
        super(lllllllllllIIIIIIlllllIIlIlIlIII, lllllllllllIIIIIIlllllIIlIlIIlll, lllllllllllIIIIIIlllllIIlIlIIIIl);
        this.table = lllllllllllIIIIIIlllllIIlIlIlIIl;
    }
}
