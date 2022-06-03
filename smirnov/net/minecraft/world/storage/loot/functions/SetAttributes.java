// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.functions;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSyntaxException;
import javax.annotation.Nullable;
import net.minecraft.world.storage.loot.RandomValueRange;
import org.apache.logging.log4j.LogManager;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import java.util.UUID;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import org.apache.logging.log4j.Logger;

public class SetAttributes extends LootFunction
{
    private final /* synthetic */ Modifier[] modifiers;
    
    public SetAttributes(final LootCondition[] llllllllllllIIIIIIIIlIlllIlIIllI, final Modifier[] llllllllllllIIIIIIIIlIlllIlIIlIl) {
        super(llllllllllllIIIIIIIIlIlllIlIIllI);
        this.modifiers = llllllllllllIIIIIIIIlIlllIlIIlIl;
    }
    
    @Override
    public ItemStack apply(final ItemStack llllllllllllIIIIIIIIlIlllIIlIlll, final Random llllllllllllIIIIIIIIlIlllIIIllll, final LootContext llllllllllllIIIIIIIIlIlllIIlIlIl) {
        int llllllllllllIIIIIIIIlIlllIIIlIll;
        for (byte llllllllllllIIIIIIIIlIlllIIIllII = (byte)((Modifier[])(Object)(llllllllllllIIIIIIIIlIlllIIIlIll = (int)(Object)this.modifiers)).length, llllllllllllIIIIIIIIlIlllIIIllIl = 0; llllllllllllIIIIIIIIlIlllIIIllIl < llllllllllllIIIIIIIIlIlllIIIllII; ++llllllllllllIIIIIIIIlIlllIIIllIl) {
            final Modifier llllllllllllIIIIIIIIlIlllIIlIlII = llllllllllllIIIIIIIIlIlllIIIlIll[llllllllllllIIIIIIIIlIlllIIIllIl];
            UUID llllllllllllIIIIIIIIlIlllIIlIIll = llllllllllllIIIIIIIIlIlllIIlIlII.uuid;
            if (llllllllllllIIIIIIIIlIlllIIlIIll == null) {
                llllllllllllIIIIIIIIlIlllIIlIIll = UUID.randomUUID();
            }
            final EntityEquipmentSlot llllllllllllIIIIIIIIlIlllIIlIIlI = llllllllllllIIIIIIIIlIlllIIlIlII.slots[llllllllllllIIIIIIIIlIlllIIIllll.nextInt(llllllllllllIIIIIIIIlIlllIIlIlII.slots.length)];
            llllllllllllIIIIIIIIlIlllIIlIlll.addAttributeModifier(llllllllllllIIIIIIIIlIlllIIlIlII.attributeName, new AttributeModifier(llllllllllllIIIIIIIIlIlllIIlIIll, llllllllllllIIIIIIIIlIlllIIlIlII.modifierName, llllllllllllIIIIIIIIlIlllIIlIlII.amount.generateFloat(llllllllllllIIIIIIIIlIlllIIIllll), llllllllllllIIIIIIIIlIlllIIlIlII.operation), llllllllllllIIIIIIIIlIlllIIlIIlI);
        }
        return llllllllllllIIIIIIIIlIlllIIlIlll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    static class Modifier
    {
        private final /* synthetic */ EntityEquipmentSlot[] slots;
        private final /* synthetic */ RandomValueRange amount;
        @Nullable
        private final /* synthetic */ UUID uuid;
        private final /* synthetic */ String modifierName;
        private final /* synthetic */ String attributeName;
        private final /* synthetic */ int operation;
        
        private static String getOperationFromStr(final int llllllllllllllllIIlIlllIllIlIlII) {
            switch (llllllllllllllllIIlIlllIllIlIlII) {
                case 0: {
                    return "addition";
                }
                case 1: {
                    return "multiply_base";
                }
                case 2: {
                    return "multiply_total";
                }
                default: {
                    throw new IllegalArgumentException("Unknown operation " + llllllllllllllllIIlIlllIllIlIlII);
                }
            }
        }
        
        private static int getOperationFromInt(final String llllllllllllllllIIlIlllIllIlIIII) {
            if ("addition".equals(llllllllllllllllIIlIlllIllIlIIII)) {
                return 0;
            }
            if ("multiply_base".equals(llllllllllllllllIIlIlllIllIlIIII)) {
                return 1;
            }
            if ("multiply_total".equals(llllllllllllllllIIlIlllIllIlIIII)) {
                return 2;
            }
            throw new JsonSyntaxException("Unknown attribute modifier operation " + llllllllllllllllIIlIlllIllIlIIII);
        }
        
        private Modifier(final String llllllllllllllllIIlIllllIIIlllIl, final String llllllllllllllllIIlIllllIIIlllII, final int llllllllllllllllIIlIllllIIIlIlII, final RandomValueRange llllllllllllllllIIlIllllIIIllIlI, final EntityEquipmentSlot[] llllllllllllllllIIlIllllIIIllIIl, @Nullable final UUID llllllllllllllllIIlIllllIIIlIIIl) {
            this.modifierName = llllllllllllllllIIlIllllIIIlllIl;
            this.attributeName = llllllllllllllllIIlIllllIIIlllII;
            this.operation = llllllllllllllllIIlIllllIIIlIlII;
            this.amount = llllllllllllllllIIlIllllIIIllIlI;
            this.uuid = llllllllllllllllIIlIllllIIIlIIIl;
            this.slots = llllllllllllllllIIlIllllIIIllIIl;
        }
        
        public JsonObject serialize(final JsonSerializationContext llllllllllllllllIIlIllllIIIIIIlI) {
            final JsonObject llllllllllllllllIIlIllllIIIIIllI = new JsonObject();
            llllllllllllllllIIlIllllIIIIIllI.addProperty("name", this.modifierName);
            llllllllllllllllIIlIllllIIIIIllI.addProperty("attribute", this.attributeName);
            llllllllllllllllIIlIllllIIIIIllI.addProperty("operation", getOperationFromStr(this.operation));
            llllllllllllllllIIlIllllIIIIIllI.add("amount", llllllllllllllllIIlIllllIIIIIIlI.serialize((Object)this.amount));
            if (this.uuid != null) {
                llllllllllllllllIIlIllllIIIIIllI.addProperty("id", this.uuid.toString());
            }
            if (this.slots.length == 1) {
                llllllllllllllllIIlIllllIIIIIllI.addProperty("slot", this.slots[0].getName());
            }
            else {
                final JsonArray llllllllllllllllIIlIllllIIIIIlIl = new JsonArray();
                Exception llllllllllllllllIIlIlllIllllllII;
                for (int llllllllllllllllIIlIlllIllllllIl = ((EntityEquipmentSlot[])(Object)(llllllllllllllllIIlIlllIllllllII = (Exception)(Object)this.slots)).length, llllllllllllllllIIlIlllIlllllllI = 0; llllllllllllllllIIlIlllIlllllllI < llllllllllllllllIIlIlllIllllllIl; ++llllllllllllllllIIlIlllIlllllllI) {
                    final EntityEquipmentSlot llllllllllllllllIIlIllllIIIIIlII = llllllllllllllllIIlIlllIllllllII[llllllllllllllllIIlIlllIlllllllI];
                    llllllllllllllllIIlIllllIIIIIlIl.add((JsonElement)new JsonPrimitive(llllllllllllllllIIlIllllIIIIIlII.getName()));
                }
                llllllllllllllllIIlIllllIIIIIllI.add("slot", (JsonElement)llllllllllllllllIIlIllllIIIIIlIl);
            }
            return llllllllllllllllIIlIllllIIIIIllI;
        }
        
        public static Modifier deserialize(final JsonObject llllllllllllllllIIlIlllIlllIIIIl, final JsonDeserializationContext llllllllllllllllIIlIlllIlllIlllI) {
            final String llllllllllllllllIIlIlllIlllIllIl = JsonUtils.getString(llllllllllllllllIIlIlllIlllIIIIl, "name");
            final String llllllllllllllllIIlIlllIlllIllII = JsonUtils.getString(llllllllllllllllIIlIlllIlllIIIIl, "attribute");
            final int llllllllllllllllIIlIlllIlllIlIll = getOperationFromInt(JsonUtils.getString(llllllllllllllllIIlIlllIlllIIIIl, "operation"));
            final RandomValueRange llllllllllllllllIIlIlllIlllIlIlI = JsonUtils.deserializeClass(llllllllllllllllIIlIlllIlllIIIIl, "amount", llllllllllllllllIIlIlllIlllIlllI, (Class<? extends RandomValueRange>)RandomValueRange.class);
            UUID llllllllllllllllIIlIlllIlllIlIIl = null;
            EntityEquipmentSlot[] llllllllllllllllIIlIlllIlllIIlll = null;
            if (JsonUtils.isString(llllllllllllllllIIlIlllIlllIIIIl, "slot")) {
                final EntityEquipmentSlot[] llllllllllllllllIIlIlllIlllIlIII = { EntityEquipmentSlot.fromString(JsonUtils.getString(llllllllllllllllIIlIlllIlllIIIIl, "slot")) };
            }
            else {
                if (!JsonUtils.isJsonArray(llllllllllllllllIIlIlllIlllIIIIl, "slot")) {
                    throw new JsonSyntaxException("Invalid or missing attribute modifier slot; must be either string or array of strings.");
                }
                final JsonArray llllllllllllllllIIlIlllIlllIIllI = JsonUtils.getJsonArray(llllllllllllllllIIlIlllIlllIIIIl, "slot");
                llllllllllllllllIIlIlllIlllIIlll = new EntityEquipmentSlot[llllllllllllllllIIlIlllIlllIIllI.size()];
                int llllllllllllllllIIlIlllIlllIIlIl = 0;
                for (final JsonElement llllllllllllllllIIlIlllIlllIIlII : llllllllllllllllIIlIlllIlllIIllI) {
                    llllllllllllllllIIlIlllIlllIIlll[llllllllllllllllIIlIlllIlllIIlIl++] = EntityEquipmentSlot.fromString(JsonUtils.getString(llllllllllllllllIIlIlllIlllIIlII, "slot"));
                }
                if (llllllllllllllllIIlIlllIlllIIlll.length == 0) {
                    throw new JsonSyntaxException("Invalid attribute modifier slot; must contain at least one entry.");
                }
            }
            if (llllllllllllllllIIlIlllIlllIIIIl.has("id")) {
                final String llllllllllllllllIIlIlllIlllIIIll = JsonUtils.getString(llllllllllllllllIIlIlllIlllIIIIl, "id");
                try {
                    llllllllllllllllIIlIlllIlllIlIIl = UUID.fromString(llllllllllllllllIIlIlllIlllIIIll);
                }
                catch (IllegalArgumentException llllllllllllllllIIlIlllIlllIIIlI) {
                    throw new JsonSyntaxException("Invalid attribute modifier id '" + llllllllllllllllIIlIlllIlllIIIll + "' (must be UUID format, with dashes)");
                }
            }
            return new Modifier(llllllllllllllllIIlIlllIlllIllIl, llllllllllllllllIIlIlllIlllIllII, llllllllllllllllIIlIlllIlllIlIll, llllllllllllllllIIlIlllIlllIlIlI, llllllllllllllllIIlIlllIlllIIlll, llllllllllllllllIIlIlllIlllIlIIl);
        }
    }
    
    public static class Serializer extends LootFunction.Serializer<SetAttributes>
    {
        @Override
        public void serialize(final JsonObject lllllllllllIIlllIlIIlIIIlIIlllII, final SetAttributes lllllllllllIIlllIlIIlIIIlIIllIll, final JsonSerializationContext lllllllllllIIlllIlIIlIIIlIIllIlI) {
            final JsonArray lllllllllllIIlllIlIIlIIIlIIllllI = new JsonArray();
            final String lllllllllllIIlllIlIIlIIIlIIlIlIl;
            final Exception lllllllllllIIlllIlIIlIIIlIIlIllI = (Exception)((Modifier[])(Object)(lllllllllllIIlllIlIIlIIIlIIlIlIl = (String)(Object)lllllllllllIIlllIlIIlIIIlIIllIll.modifiers)).length;
            for (short lllllllllllIIlllIlIIlIIIlIIlIlll = 0; lllllllllllIIlllIlIIlIIIlIIlIlll < lllllllllllIIlllIlIIlIIIlIIlIllI; ++lllllllllllIIlllIlIIlIIIlIIlIlll) {
                final Modifier lllllllllllIIlllIlIIlIIIlIIlllIl = lllllllllllIIlllIlIIlIIIlIIlIlIl[lllllllllllIIlllIlIIlIIIlIIlIlll];
                lllllllllllIIlllIlIIlIIIlIIllllI.add((JsonElement)lllllllllllIIlllIlIIlIIIlIIlllIl.serialize(lllllllllllIIlllIlIIlIIIlIIllIlI));
            }
            lllllllllllIIlllIlIIlIIIlIIlllII.add("modifiers", (JsonElement)lllllllllllIIlllIlIIlIIIlIIllllI);
        }
        
        public Serializer() {
            super(new ResourceLocation("set_attributes"), SetAttributes.class);
        }
        
        @Override
        public SetAttributes deserialize(final JsonObject lllllllllllIIlllIlIIlIIIlIIIlIll, final JsonDeserializationContext lllllllllllIIlllIlIIlIIIlIIIlIlI, final LootCondition[] lllllllllllIIlllIlIIlIIIlIIIlIIl) {
            final JsonArray lllllllllllIIlllIlIIlIIIlIIIlIII = JsonUtils.getJsonArray(lllllllllllIIlllIlIIlIIIlIIIlIll, "modifiers");
            final Modifier[] lllllllllllIIlllIlIIlIIIlIIIIlll = new Modifier[lllllllllllIIlllIlIIlIIIlIIIlIII.size()];
            int lllllllllllIIlllIlIIlIIIlIIIIllI = 0;
            for (final JsonElement lllllllllllIIlllIlIIlIIIlIIIIlIl : lllllllllllIIlllIlIIlIIIlIIIlIII) {
                lllllllllllIIlllIlIIlIIIlIIIIlll[lllllllllllIIlllIlIIlIIIlIIIIllI++] = Modifier.deserialize(JsonUtils.getJsonObject(lllllllllllIIlllIlIIlIIIlIIIIlIl, "modifier"), lllllllllllIIlllIlIIlIIIlIIIlIlI);
            }
            if (lllllllllllIIlllIlIIlIIIlIIIIlll.length == 0) {
                throw new JsonSyntaxException("Invalid attribute modifiers array; cannot be empty");
            }
            return new SetAttributes(lllllllllllIIlllIlIIlIIIlIIIlIIl, lllllllllllIIlllIlIIlIIIlIIIIlll);
        }
    }
}
