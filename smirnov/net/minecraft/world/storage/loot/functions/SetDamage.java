// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.functions;

import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.storage.loot.RandomValueRange;

public class SetDamage extends LootFunction
{
    private final /* synthetic */ RandomValueRange damageRange;
    private static final /* synthetic */ Logger LOGGER;
    
    public SetDamage(final LootCondition[] lllllllllllllIllIIIIIllIIIIlllll, final RandomValueRange lllllllllllllIllIIIIIllIIIIllIll) {
        super(lllllllllllllIllIIIIIllIIIIlllll);
        this.damageRange = lllllllllllllIllIIIIIllIIIIllIll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllllIllIIIIIllIIIIlIIII, final Random lllllllllllllIllIIIIIllIIIIIllll, final LootContext lllllllllllllIllIIIIIllIIIIlIIll) {
        if (lllllllllllllIllIIIIIllIIIIlIIII.isItemStackDamageable()) {
            final float lllllllllllllIllIIIIIllIIIIlIIlI = 1.0f - this.damageRange.generateFloat(lllllllllllllIllIIIIIllIIIIIllll);
            lllllllllllllIllIIIIIllIIIIlIIII.setItemDamage(MathHelper.floor(lllllllllllllIllIIIIIllIIIIlIIlI * lllllllllllllIllIIIIIllIIIIlIIII.getMaxDamage()));
        }
        else {
            SetDamage.LOGGER.warn("Couldn't set damage of loot item {}", (Object)lllllllllllllIllIIIIIllIIIIlIIII);
        }
        return lllllllllllllIllIIIIIllIIIIlIIII;
    }
    
    public static class Serializer extends LootFunction.Serializer<SetDamage>
    {
        @Override
        public void serialize(final JsonObject lllllllllllllIIIlIIlllllIlllIIIl, final SetDamage lllllllllllllIIIlIIlllllIlllIIII, final JsonSerializationContext lllllllllllllIIIlIIlllllIllIllII) {
            lllllllllllllIIIlIIlllllIlllIIIl.add("damage", lllllllllllllIIIlIIlllllIllIllII.serialize((Object)lllllllllllllIIIlIIlllllIlllIIII.damageRange));
        }
        
        protected Serializer() {
            super(new ResourceLocation("set_damage"), SetDamage.class);
        }
        
        @Override
        public SetDamage deserialize(final JsonObject lllllllllllllIIIlIIlllllIllIIlII, final JsonDeserializationContext lllllllllllllIIIlIIlllllIllIIllI, final LootCondition[] lllllllllllllIIIlIIlllllIllIIIlI) {
            return new SetDamage(lllllllllllllIIIlIIlllllIllIIIlI, JsonUtils.deserializeClass(lllllllllllllIIIlIIlllllIllIIlII, "damage", lllllllllllllIIIlIIlllllIllIIllI, (Class<? extends RandomValueRange>)RandomValueRange.class));
        }
    }
}
