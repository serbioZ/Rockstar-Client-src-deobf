// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot;

import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonSerializationContext;
import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import java.util.Random;
import net.minecraft.item.ItemStack;
import java.util.Collection;
import net.minecraft.util.JsonUtils;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.item.Item;

public class LootEntryItem extends LootEntry
{
    protected final /* synthetic */ Item item;
    protected final /* synthetic */ LootFunction[] functions;
    
    public static LootEntryItem deserialize(final JsonObject llllllllllllIllllIIlIlIlIllllllI, final JsonDeserializationContext llllllllllllIllllIIlIlIllIIIIlIl, final int llllllllllllIllllIIlIlIllIIIIlII, final int llllllllllllIllllIIlIlIllIIIIIll, final LootCondition[] llllllllllllIllllIIlIlIlIllllIlI) {
        final Item llllllllllllIllllIIlIlIllIIIIIIl = JsonUtils.getItem(llllllllllllIllllIIlIlIlIllllllI, "name");
        LootFunction[] llllllllllllIllllIIlIlIlIlllllll = null;
        if (llllllllllllIllllIIlIlIlIllllllI.has("functions")) {
            final LootFunction[] llllllllllllIllllIIlIlIllIIIIIII = JsonUtils.deserializeClass(llllllllllllIllllIIlIlIlIllllllI, "functions", llllllllllllIllllIIlIlIllIIIIlIl, (Class<? extends LootFunction[]>)LootFunction[].class);
        }
        else {
            llllllllllllIllllIIlIlIlIlllllll = new LootFunction[0];
        }
        return new LootEntryItem(llllllllllllIllllIIlIlIllIIIIIIl, llllllllllllIllllIIlIlIllIIIIlII, llllllllllllIllllIIlIlIllIIIIIll, llllllllllllIllllIIlIlIlIlllllll, llllllllllllIllllIIlIlIlIllllIlI);
    }
    
    public LootEntryItem(final Item llllllllllllIllllIIlIlIllIlllIII, final int llllllllllllIllllIIlIlIllIllllIl, final int llllllllllllIllllIIlIlIllIllIllI, final LootFunction[] llllllllllllIllllIIlIlIllIllIlIl, final LootCondition[] llllllllllllIllllIIlIlIllIllIlII) {
        super(llllllllllllIllllIIlIlIllIllllIl, llllllllllllIllllIIlIlIllIllIllI, llllllllllllIllllIIlIlIllIllIlII);
        this.item = llllllllllllIllllIIlIlIllIlllIII;
        this.functions = llllllllllllIllllIIlIlIllIllIlIl;
    }
    
    @Override
    public void addLoot(final Collection<ItemStack> llllllllllllIllllIIlIlIllIlIIIIl, final Random llllllllllllIllllIIlIlIllIlIIIII, final LootContext llllllllllllIllllIIlIlIllIIlllll) {
        ItemStack llllllllllllIllllIIlIlIllIlIIllI = new ItemStack(this.item);
        final float llllllllllllIllllIIlIlIllIIllIlI;
        final double llllllllllllIllllIIlIlIllIIllIll = ((LootFunction[])(Object)(llllllllllllIllllIIlIlIllIIllIlI = (float)(Object)this.functions)).length;
        for (boolean llllllllllllIllllIIlIlIllIIlllII = false; (llllllllllllIllllIIlIlIllIIlllII ? 1 : 0) < llllllllllllIllllIIlIlIllIIllIll; ++llllllllllllIllllIIlIlIllIIlllII) {
            final LootFunction llllllllllllIllllIIlIlIllIlIIlIl = llllllllllllIllllIIlIlIllIIllIlI[llllllllllllIllllIIlIlIllIIlllII];
            if (LootConditionManager.testAllConditions(llllllllllllIllllIIlIlIllIlIIlIl.getConditions(), llllllllllllIllllIIlIlIllIlIIIII, llllllllllllIllllIIlIlIllIIlllll)) {
                llllllllllllIllllIIlIlIllIlIIllI = llllllllllllIllllIIlIlIllIlIIlIl.apply(llllllllllllIllllIIlIlIllIlIIllI, llllllllllllIllllIIlIlIllIlIIIII, llllllllllllIllllIIlIlIllIIlllll);
            }
        }
        if (!llllllllllllIllllIIlIlIllIlIIllI.func_190926_b()) {
            if (llllllllllllIllllIIlIlIllIlIIllI.func_190916_E() < this.item.getItemStackLimit()) {
                llllllllllllIllllIIlIlIllIlIIIIl.add(llllllllllllIllllIIlIlIllIlIIllI);
            }
            else {
                int llllllllllllIllllIIlIlIllIlIIlII = llllllllllllIllllIIlIlIllIlIIllI.func_190916_E();
                while (llllllllllllIllllIIlIlIllIlIIlII > 0) {
                    final ItemStack llllllllllllIllllIIlIlIllIlIIIll = llllllllllllIllllIIlIlIllIlIIllI.copy();
                    llllllllllllIllllIIlIlIllIlIIIll.func_190920_e(Math.min(llllllllllllIllllIIlIlIllIlIIllI.getMaxStackSize(), llllllllllllIllllIIlIlIllIlIIlII));
                    llllllllllllIllllIIlIlIllIlIIlII -= llllllllllllIllllIIlIlIllIlIIIll.func_190916_E();
                    llllllllllllIllllIIlIlIllIlIIIIl.add(llllllllllllIllllIIlIlIllIlIIIll);
                }
            }
        }
    }
    
    @Override
    protected void serialize(final JsonObject llllllllllllIllllIIlIlIllIIlIIII, final JsonSerializationContext llllllllllllIllllIIlIlIllIIIllll) {
        if (this.functions != null && this.functions.length > 0) {
            llllllllllllIllllIIlIlIllIIlIIII.add("functions", llllllllllllIllllIIlIlIllIIIllll.serialize((Object)this.functions));
        }
        final ResourceLocation llllllllllllIllllIIlIlIllIIlIIlI = Item.REGISTRY.getNameForObject(this.item);
        if (llllllllllllIllllIIlIlIllIIlIIlI == null) {
            throw new IllegalArgumentException("Can't serialize unknown item " + this.item);
        }
        llllllllllllIllllIIlIlIllIIlIIII.addProperty("name", llllllllllllIllllIIlIlIllIIlIIlI.toString());
    }
}
