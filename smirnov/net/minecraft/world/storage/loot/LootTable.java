// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot;

import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import org.apache.logging.log4j.LogManager;
import java.util.Iterator;
import net.minecraft.util.math.MathHelper;
import java.util.Collection;
import net.minecraft.item.ItemStack;
import java.util.Collections;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import net.minecraft.inventory.IInventory;
import org.apache.logging.log4j.Logger;

public class LootTable
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ LootPool[] pools;
    
    private List<Integer> getEmptySlotsRandomized(final IInventory llllllllllllllllllllllIIIIIIlIII, final Random llllllllllllllllllllllIIIIIIIIll) {
        final List<Integer> llllllllllllllllllllllIIIIIIIllI = (List<Integer>)Lists.newArrayList();
        for (int llllllllllllllllllllllIIIIIIIlIl = 0; llllllllllllllllllllllIIIIIIIlIl < llllllllllllllllllllllIIIIIIlIII.getSizeInventory(); ++llllllllllllllllllllllIIIIIIIlIl) {
            if (llllllllllllllllllllllIIIIIIlIII.getStackInSlot(llllllllllllllllllllllIIIIIIIlIl).func_190926_b()) {
                llllllllllllllllllllllIIIIIIIllI.add(llllllllllllllllllllllIIIIIIIlIl);
            }
        }
        Collections.shuffle(llllllllllllllllllllllIIIIIIIllI, llllllllllllllllllllllIIIIIIIIll);
        return llllllllllllllllllllllIIIIIIIllI;
    }
    
    public List<ItemStack> generateLootForPools(final Random llllllllllllllllllllllIIIlIIlIlI, final LootContext llllllllllllllllllllllIIIlIIIlII) {
        final List<ItemStack> llllllllllllllllllllllIIIlIIlIII = (List<ItemStack>)Lists.newArrayList();
        if (llllllllllllllllllllllIIIlIIIlII.addLootTable(this)) {
            final char llllllllllllllllllllllIIIIllllll;
            final boolean llllllllllllllllllllllIIIlIIIIII = ((LootPool[])(Object)(llllllllllllllllllllllIIIIllllll = (char)(Object)this.pools)).length != 0;
            for (char llllllllllllllllllllllIIIlIIIIIl = '\0'; llllllllllllllllllllllIIIlIIIIIl < (llllllllllllllllllllllIIIlIIIIII ? 1 : 0); ++llllllllllllllllllllllIIIlIIIIIl) {
                final LootPool llllllllllllllllllllllIIIlIIIlll = llllllllllllllllllllllIIIIllllll[llllllllllllllllllllllIIIlIIIIIl];
                llllllllllllllllllllllIIIlIIIlll.generateLoot(llllllllllllllllllllllIIIlIIlIII, llllllllllllllllllllllIIIlIIlIlI, llllllllllllllllllllllIIIlIIIlII);
            }
            llllllllllllllllllllllIIIlIIIlII.removeLootTable(this);
        }
        else {
            LootTable.LOGGER.warn("Detected infinite loop in loot tables");
        }
        return llllllllllllllllllllllIIIlIIlIII;
    }
    
    public void fillInventory(final IInventory llllllllllllllllllllllIIIIllIlIl, final Random llllllllllllllllllllllIIIIlIllIl, final LootContext llllllllllllllllllllllIIIIllIIll) {
        final List<ItemStack> llllllllllllllllllllllIIIIllIIlI = this.generateLootForPools(llllllllllllllllllllllIIIIlIllIl, llllllllllllllllllllllIIIIllIIll);
        final List<Integer> llllllllllllllllllllllIIIIllIIIl = this.getEmptySlotsRandomized(llllllllllllllllllllllIIIIllIlIl, llllllllllllllllllllllIIIIlIllIl);
        this.shuffleItems(llllllllllllllllllllllIIIIllIIlI, llllllllllllllllllllllIIIIllIIIl.size(), llllllllllllllllllllllIIIIlIllIl);
        for (final ItemStack llllllllllllllllllllllIIIIllIIII : llllllllllllllllllllllIIIIllIIlI) {
            if (llllllllllllllllllllllIIIIllIIIl.isEmpty()) {
                LootTable.LOGGER.warn("Tried to over-fill a container");
                return;
            }
            if (llllllllllllllllllllllIIIIllIIII.func_190926_b()) {
                llllllllllllllllllllllIIIIllIlIl.setInventorySlotContents(llllllllllllllllllllllIIIIllIIIl.remove(llllllllllllllllllllllIIIIllIIIl.size() - 1), ItemStack.field_190927_a);
            }
            else {
                llllllllllllllllllllllIIIIllIlIl.setInventorySlotContents(llllllllllllllllllllllIIIIllIIIl.remove(llllllllllllllllllllllIIIIllIIIl.size() - 1), llllllllllllllllllllllIIIIllIIII);
            }
        }
    }
    
    private void shuffleItems(final List<ItemStack> llllllllllllllllllllllIIIIIlIlIl, int llllllllllllllllllllllIIIIIlIlII, final Random llllllllllllllllllllllIIIIIlllII) {
        final List<ItemStack> llllllllllllllllllllllIIIIIllIll = (List<ItemStack>)Lists.newArrayList();
        final Iterator<ItemStack> llllllllllllllllllllllIIIIIllIlI = llllllllllllllllllllllIIIIIlIlIl.iterator();
        while (llllllllllllllllllllllIIIIIllIlI.hasNext()) {
            final ItemStack llllllllllllllllllllllIIIIIllIIl = llllllllllllllllllllllIIIIIllIlI.next();
            if (llllllllllllllllllllllIIIIIllIIl.func_190926_b()) {
                llllllllllllllllllllllIIIIIllIlI.remove();
            }
            else {
                if (llllllllllllllllllllllIIIIIllIIl.func_190916_E() <= 1) {
                    continue;
                }
                llllllllllllllllllllllIIIIIllIll.add(llllllllllllllllllllllIIIIIllIIl);
                llllllllllllllllllllllIIIIIllIlI.remove();
            }
        }
        llllllllllllllllllllllIIIIIlIlII -= llllllllllllllllllllllIIIIIlIlIl.size();
        while (llllllllllllllllllllllIIIIIlIlII > 0 && !llllllllllllllllllllllIIIIIllIll.isEmpty()) {
            final ItemStack llllllllllllllllllllllIIIIIllIII = llllllllllllllllllllllIIIIIllIll.remove(MathHelper.getInt(llllllllllllllllllllllIIIIIlllII, 0, llllllllllllllllllllllIIIIIllIll.size() - 1));
            final int llllllllllllllllllllllIIIIIlIlll = MathHelper.getInt(llllllllllllllllllllllIIIIIlllII, 1, llllllllllllllllllllllIIIIIllIII.func_190916_E() / 2);
            final ItemStack llllllllllllllllllllllIIIIIlIllI = llllllllllllllllllllllIIIIIllIII.splitStack(llllllllllllllllllllllIIIIIlIlll);
            if (llllllllllllllllllllllIIIIIllIII.func_190916_E() > 1 && llllllllllllllllllllllIIIIIlllII.nextBoolean()) {
                llllllllllllllllllllllIIIIIllIll.add(llllllllllllllllllllllIIIIIllIII);
            }
            else {
                llllllllllllllllllllllIIIIIlIlIl.add(llllllllllllllllllllllIIIIIllIII);
            }
            if (llllllllllllllllllllllIIIIIlIllI.func_190916_E() > 1 && llllllllllllllllllllllIIIIIlllII.nextBoolean()) {
                llllllllllllllllllllllIIIIIllIll.add(llllllllllllllllllllllIIIIIlIllI);
            }
            else {
                llllllllllllllllllllllIIIIIlIlIl.add(llllllllllllllllllllllIIIIIlIllI);
            }
        }
        llllllllllllllllllllllIIIIIlIlIl.addAll(llllllllllllllllllllllIIIIIllIll);
        Collections.shuffle(llllllllllllllllllllllIIIIIlIlIl, llllllllllllllllllllllIIIIIlllII);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        EMPTY_LOOT_TABLE = new LootTable(new LootPool[0]);
    }
    
    public LootTable(final LootPool[] llllllllllllllllllllllIIIlIlIlII) {
        this.pools = llllllllllllllllllllllIIIlIlIlII;
    }
    
    public static class Serializer implements JsonDeserializer<LootTable>, JsonSerializer<LootTable>
    {
        public LootTable deserialize(final JsonElement llllllllllllIlIIllIlIIllIlllIlIl, final Type llllllllllllIlIIllIlIIllIlllIlII, final JsonDeserializationContext llllllllllllIlIIllIlIIllIlllIIll) throws JsonParseException {
            final JsonObject llllllllllllIlIIllIlIIllIlllIIlI = JsonUtils.getJsonObject(llllllllllllIlIIllIlIIllIlllIlIl, "loot table");
            final LootPool[] llllllllllllIlIIllIlIIllIlllIIIl = JsonUtils.deserializeClass(llllllllllllIlIIllIlIIllIlllIIlI, "pools", new LootPool[0], llllllllllllIlIIllIlIIllIlllIIll, LootPool[].class);
            return new LootTable(llllllllllllIlIIllIlIIllIlllIIIl);
        }
        
        public JsonElement serialize(final LootTable llllllllllllIlIIllIlIIllIllIlIII, final Type llllllllllllIlIIllIlIIllIllIIlll, final JsonSerializationContext llllllllllllIlIIllIlIIllIllIIIll) {
            final JsonObject llllllllllllIlIIllIlIIllIllIIlIl = new JsonObject();
            llllllllllllIlIIllIlIIllIllIIlIl.add("pools", llllllllllllIlIIllIlIIllIllIIIll.serialize((Object)llllllllllllIlIIllIlIIllIllIlIII.pools));
            return (JsonElement)llllllllllllIlIIllIlIIllIllIIlIl;
        }
    }
}
