// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.functions;

import com.google.gson.JsonPrimitive;
import com.google.gson.JsonArray;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonElement;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import java.util.Collections;
import javax.annotation.Nullable;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import org.apache.logging.log4j.LogManager;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.util.math.MathHelper;
import net.minecraft.init.Items;
import com.google.common.collect.Lists;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Logger;
import net.minecraft.enchantment.Enchantment;
import java.util.List;

public class EnchantRandomly extends LootFunction
{
    private final /* synthetic */ List<Enchantment> enchantments;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public ItemStack apply(ItemStack llllllllllllIIllIlllIIllIlllIIll, final Random llllllllllllIIllIlllIIllIllllIll, final LootContext llllllllllllIIllIlllIIllIllllIlI) {
        Enchantment llllllllllllIIllIlllIIllIllllIII = null;
        if (this.enchantments.isEmpty()) {
            final List<Enchantment> llllllllllllIIllIlllIIllIlllIlll = (List<Enchantment>)Lists.newArrayList();
            for (final Enchantment llllllllllllIIllIlllIIllIlllIllI : Enchantment.REGISTRY) {
                if (llllllllllllIIllIlllIIllIlllIIll.getItem() == Items.BOOK || llllllllllllIIllIlllIIllIlllIllI.canApply(llllllllllllIIllIlllIIllIlllIIll)) {
                    llllllllllllIIllIlllIIllIlllIlll.add(llllllllllllIIllIlllIIllIlllIllI);
                }
            }
            if (llllllllllllIIllIlllIIllIlllIlll.isEmpty()) {
                EnchantRandomly.LOGGER.warn("Couldn't find a compatible enchantment for {}", (Object)llllllllllllIIllIlllIIllIlllIIll);
                return llllllllllllIIllIlllIIllIlllIIll;
            }
            final Enchantment llllllllllllIIllIlllIIllIllllIIl = llllllllllllIIllIlllIIllIlllIlll.get(llllllllllllIIllIlllIIllIllllIll.nextInt(llllllllllllIIllIlllIIllIlllIlll.size()));
        }
        else {
            llllllllllllIIllIlllIIllIllllIII = this.enchantments.get(llllllllllllIIllIlllIIllIllllIll.nextInt(this.enchantments.size()));
        }
        final int llllllllllllIIllIlllIIllIlllIlIl = MathHelper.getInt(llllllllllllIIllIlllIIllIllllIll, llllllllllllIIllIlllIIllIllllIII.getMinLevel(), llllllllllllIIllIlllIIllIllllIII.getMaxLevel());
        if (llllllllllllIIllIlllIIllIlllIIll.getItem() == Items.BOOK) {
            llllllllllllIIllIlllIIllIlllIIll = new ItemStack(Items.ENCHANTED_BOOK);
            ItemEnchantedBook.addEnchantment(llllllllllllIIllIlllIIllIlllIIll, new EnchantmentData(llllllllllllIIllIlllIIllIllllIII, llllllllllllIIllIlllIIllIlllIlIl));
        }
        else {
            llllllllllllIIllIlllIIllIlllIIll.addEnchantment(llllllllllllIIllIlllIIllIllllIII, llllllllllllIIllIlllIIllIlllIlIl);
        }
        return llllllllllllIIllIlllIIllIlllIIll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public EnchantRandomly(final LootCondition[] llllllllllllIIllIlllIIlllIIIlIIl, @Nullable final List<Enchantment> llllllllllllIIllIlllIIlllIIIIlIl) {
        super(llllllllllllIIllIlllIIlllIIIlIIl);
        this.enchantments = ((llllllllllllIIllIlllIIlllIIIIlIl == null) ? Collections.emptyList() : llllllllllllIIllIlllIIlllIIIIlIl);
    }
    
    public static class Serializer extends LootFunction.Serializer<EnchantRandomly>
    {
        @Override
        public EnchantRandomly deserialize(final JsonObject lllllllllllIlIllIIIIllIIllllIIlI, final JsonDeserializationContext lllllllllllIlIllIIIIllIIllllIIIl, final LootCondition[] lllllllllllIlIllIIIIllIIlllIlIlI) {
            final List<Enchantment> lllllllllllIlIllIIIIllIIlllIllll = (List<Enchantment>)Lists.newArrayList();
            if (lllllllllllIlIllIIIIllIIllllIIlI.has("enchantments")) {
                for (final JsonElement lllllllllllIlIllIIIIllIIlllIlllI : JsonUtils.getJsonArray(lllllllllllIlIllIIIIllIIllllIIlI, "enchantments")) {
                    final String lllllllllllIlIllIIIIllIIlllIllIl = JsonUtils.getString(lllllllllllIlIllIIIIllIIlllIlllI, "enchantment");
                    final Enchantment lllllllllllIlIllIIIIllIIlllIllII = Enchantment.REGISTRY.getObject(new ResourceLocation(lllllllllllIlIllIIIIllIIlllIllIl));
                    if (lllllllllllIlIllIIIIllIIlllIllII == null) {
                        throw new JsonSyntaxException("Unknown enchantment '" + lllllllllllIlIllIIIIllIIlllIllIl + "'");
                    }
                    lllllllllllIlIllIIIIllIIlllIllll.add(lllllllllllIlIllIIIIllIIlllIllII);
                }
            }
            return new EnchantRandomly(lllllllllllIlIllIIIIllIIlllIlIlI, lllllllllllIlIllIIIIllIIlllIllll);
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllIlIllIIIIllIlIIIIIllI, final EnchantRandomly lllllllllllIlIllIIIIllIIllllllll, final JsonSerializationContext lllllllllllIlIllIIIIllIlIIIIIlII) {
            if (!lllllllllllIlIllIIIIllIIllllllll.enchantments.isEmpty()) {
                final JsonArray lllllllllllIlIllIIIIllIlIIIIIIll = new JsonArray();
                for (final Enchantment lllllllllllIlIllIIIIllIlIIIIIIlI : lllllllllllIlIllIIIIllIIllllllll.enchantments) {
                    final ResourceLocation lllllllllllIlIllIIIIllIlIIIIIIIl = Enchantment.REGISTRY.getNameForObject(lllllllllllIlIllIIIIllIlIIIIIIlI);
                    if (lllllllllllIlIllIIIIllIlIIIIIIIl == null) {
                        throw new IllegalArgumentException("Don't know how to serialize enchantment " + lllllllllllIlIllIIIIllIlIIIIIIlI);
                    }
                    lllllllllllIlIllIIIIllIlIIIIIIll.add((JsonElement)new JsonPrimitive(lllllllllllIlIllIIIIllIlIIIIIIIl.toString()));
                }
                lllllllllllIlIllIIIIllIlIIIIIllI.add("enchantments", (JsonElement)lllllllllllIlIllIIIIllIlIIIIIIll);
            }
        }
        
        public Serializer() {
            super(new ResourceLocation("enchant_randomly"), EnchantRandomly.class);
        }
    }
}
