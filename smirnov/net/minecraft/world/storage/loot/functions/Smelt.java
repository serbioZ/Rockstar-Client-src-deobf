// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.functions;

import com.google.gson.JsonDeserializationContext;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Logger;

public class Smelt extends LootFunction
{
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllllIIIIIIIlIIllllllllI, final Random lllllllllllllIIIIIIIlIlIIIIIIIlI, final LootContext lllllllllllllIIIIIIIlIlIIIIIIIIl) {
        if (lllllllllllllIIIIIIIlIIllllllllI.func_190926_b()) {
            return lllllllllllllIIIIIIIlIIllllllllI;
        }
        final ItemStack lllllllllllllIIIIIIIlIlIIIIIIIII = FurnaceRecipes.instance().getSmeltingResult(lllllllllllllIIIIIIIlIIllllllllI);
        if (lllllllllllllIIIIIIIlIlIIIIIIIII.func_190926_b()) {
            Smelt.LOGGER.warn("Couldn't smelt {} because there is no smelting recipe", (Object)lllllllllllllIIIIIIIlIIllllllllI);
            return lllllllllllllIIIIIIIlIIllllllllI;
        }
        final ItemStack lllllllllllllIIIIIIIlIIlllllllll = lllllllllllllIIIIIIIlIlIIIIIIIII.copy();
        lllllllllllllIIIIIIIlIIlllllllll.func_190920_e(lllllllllllllIIIIIIIlIIllllllllI.func_190916_E());
        return lllllllllllllIIIIIIIlIIlllllllll;
    }
    
    public Smelt(final LootCondition[] lllllllllllllIIIIIIIlIlIIIIIlIlI) {
        super(lllllllllllllIIIIIIIlIlIIIIIlIlI);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public static class Serializer extends LootFunction.Serializer<Smelt>
    {
        @Override
        public void serialize(final JsonObject lllllllllllIlIIllIIIlllIlIlIIIIl, final Smelt lllllllllllIlIIllIIIlllIlIlIIIII, final JsonSerializationContext lllllllllllIlIIllIIIlllIlIIlllll) {
        }
        
        protected Serializer() {
            super(new ResourceLocation("furnace_smelt"), Smelt.class);
        }
        
        @Override
        public Smelt deserialize(final JsonObject lllllllllllIlIIllIIIlllIlIIlllII, final JsonDeserializationContext lllllllllllIlIIllIIIlllIlIIllIll, final LootCondition[] lllllllllllIlIIllIIIlllIlIIllIIl) {
            return new Smelt(lllllllllllIlIIllIIIlllIlIIllIIl);
        }
    }
}
