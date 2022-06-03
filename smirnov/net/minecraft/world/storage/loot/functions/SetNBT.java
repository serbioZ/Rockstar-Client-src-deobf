// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.functions;

import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.NBTException;
import com.google.gson.JsonSyntaxException;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.nbt.NBTTagCompound;

public class SetNBT extends LootFunction
{
    private final /* synthetic */ NBTTagCompound tag;
    
    public SetNBT(final LootCondition[] lllllllllllIlIlIlIIlllIIlIlIlIll, final NBTTagCompound lllllllllllIlIlIlIIlllIIlIlIlIlI) {
        super(lllllllllllIlIlIlIIlllIIlIlIlIll);
        this.tag = lllllllllllIlIlIlIIlllIIlIlIlIlI;
    }
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllIlIlIlIIlllIIlIlIIlIl, final Random lllllllllllIlIlIlIIlllIIlIlIIlII, final LootContext lllllllllllIlIlIlIIlllIIlIlIIIll) {
        NBTTagCompound lllllllllllIlIlIlIIlllIIlIlIIIlI = lllllllllllIlIlIlIIlllIIlIlIIlIl.getTagCompound();
        if (lllllllllllIlIlIlIIlllIIlIlIIIlI == null) {
            lllllllllllIlIlIlIIlllIIlIlIIIlI = this.tag.copy();
        }
        else {
            lllllllllllIlIlIlIIlllIIlIlIIIlI.merge(this.tag);
        }
        lllllllllllIlIlIlIIlllIIlIlIIlIl.setTagCompound(lllllllllllIlIlIlIIlllIIlIlIIIlI);
        return lllllllllllIlIlIlIIlllIIlIlIIlIl;
    }
    
    public static class Serializer extends LootFunction.Serializer<SetNBT>
    {
        @Override
        public void serialize(final JsonObject lllllllllllIIlIllllIIIIllIlllllI, final SetNBT lllllllllllIIlIllllIIIIllIllllIl, final JsonSerializationContext lllllllllllIIlIllllIIIIllIllllII) {
            lllllllllllIIlIllllIIIIllIlllllI.addProperty("tag", lllllllllllIIlIllllIIIIllIllllIl.tag.toString());
        }
        
        @Override
        public SetNBT deserialize(final JsonObject lllllllllllIIlIllllIIIIllIllIIII, final JsonDeserializationContext lllllllllllIIlIllllIIIIllIllIlII, final LootCondition[] lllllllllllIIlIllllIIIIllIlIllll) {
            try {
                final NBTTagCompound lllllllllllIIlIllllIIIIllIllIIlI = JsonToNBT.getTagFromJson(JsonUtils.getString(lllllllllllIIlIllllIIIIllIllIIII, "tag"));
                return new SetNBT(lllllllllllIIlIllllIIIIllIlIllll, lllllllllllIIlIllllIIIIllIllIIlI);
            }
            catch (NBTException lllllllllllIIlIllllIIIIllIllIIIl) {
                throw new JsonSyntaxException((Throwable)lllllllllllIIlIllllIIIIllIllIIIl);
            }
        }
        
        public Serializer() {
            super(new ResourceLocation("set_nbt"), SetNBT.class);
        }
    }
}
