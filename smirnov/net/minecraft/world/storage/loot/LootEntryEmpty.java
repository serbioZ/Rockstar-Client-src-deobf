// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot;

import com.google.gson.JsonSerializationContext;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import java.util.Random;
import net.minecraft.item.ItemStack;
import java.util.Collection;

public class LootEntryEmpty extends LootEntry
{
    @Override
    public void addLoot(final Collection<ItemStack> lllllllllllllIIIllllIIlIlllIIlIl, final Random lllllllllllllIIIllllIIlIlllIIlII, final LootContext lllllllllllllIIIllllIIlIlllIIIll) {
    }
    
    public static LootEntryEmpty deserialize(final JsonObject lllllllllllllIIIllllIIlIllIlllII, final JsonDeserializationContext lllllllllllllIIIllllIIlIllIllIll, final int lllllllllllllIIIllllIIlIllIlIlll, final int lllllllllllllIIIllllIIlIllIllIIl, final LootCondition[] lllllllllllllIIIllllIIlIllIllIII) {
        return new LootEntryEmpty(lllllllllllllIIIllllIIlIllIlIlll, lllllllllllllIIIllllIIlIllIllIIl, lllllllllllllIIIllllIIlIllIllIII);
    }
    
    public LootEntryEmpty(final int lllllllllllllIIIllllIIlIlllIllIl, final int lllllllllllllIIIllllIIlIlllIlIII, final LootCondition[] lllllllllllllIIIllllIIlIlllIlIll) {
        super(lllllllllllllIIIllllIIlIlllIllIl, lllllllllllllIIIllllIIlIlllIlIII, lllllllllllllIIIllllIIlIlllIlIll);
    }
    
    @Override
    protected void serialize(final JsonObject lllllllllllllIIIllllIIlIlllIIIIl, final JsonSerializationContext lllllllllllllIIIllllIIlIlllIIIII) {
    }
}
