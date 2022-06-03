// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.functions;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import org.apache.logging.log4j.LogManager;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.storage.loot.RandomValueRange;

public class SetMetadata extends LootFunction
{
    private final /* synthetic */ RandomValueRange metaRange;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public ItemStack apply(final ItemStack llllllllllllIIIlllIIlllIIlIlIlll, final Random llllllllllllIIIlllIIlllIIlIllIlI, final LootContext llllllllllllIIIlllIIlllIIlIllIIl) {
        if (llllllllllllIIIlllIIlllIIlIlIlll.isItemStackDamageable()) {
            SetMetadata.LOGGER.warn("Couldn't set data of loot item {}", (Object)llllllllllllIIIlllIIlllIIlIlIlll);
        }
        else {
            llllllllllllIIIlllIIlllIIlIlIlll.setItemDamage(this.metaRange.generateInt(llllllllllllIIIlllIIlllIIlIllIlI));
        }
        return llllllllllllIIIlllIIlllIIlIlIlll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public SetMetadata(final LootCondition[] llllllllllllIIIlllIIlllIIllIIIIl, final RandomValueRange llllllllllllIIIlllIIlllIIllIIIII) {
        super(llllllllllllIIIlllIIlllIIllIIIIl);
        this.metaRange = llllllllllllIIIlllIIlllIIllIIIII;
    }
    
    public static class Serializer extends LootFunction.Serializer<SetMetadata>
    {
        @Override
        public SetMetadata deserialize(final JsonObject lllllllllllIIIllIlIlIllIIllIlIII, final JsonDeserializationContext lllllllllllIIIllIlIlIllIIllIIlII, final LootCondition[] lllllllllllIIIllIlIlIllIIllIIIll) {
            return new SetMetadata(lllllllllllIIIllIlIlIllIIllIIIll, JsonUtils.deserializeClass(lllllllllllIIIllIlIlIllIIllIlIII, "data", lllllllllllIIIllIlIlIllIIllIIlII, (Class<? extends RandomValueRange>)RandomValueRange.class));
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllIIIllIlIlIllIIllIllll, final SetMetadata lllllllllllIIIllIlIlIllIIllIlllI, final JsonSerializationContext lllllllllllIIIllIlIlIllIIlllIIII) {
            lllllllllllIIIllIlIlIllIIllIllll.add("data", lllllllllllIIIllIlIlIllIIlllIIII.serialize((Object)lllllllllllIIIllIlIlIllIIllIlllI.metaRange));
        }
        
        protected Serializer() {
            super(new ResourceLocation("set_data"), SetMetadata.class);
        }
    }
}
