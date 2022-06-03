// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import com.google.gson.JsonParseException;
import net.minecraft.item.crafting.IRecipe;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.crafting.CraftingManager;
import com.google.gson.JsonArray;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializer;
import java.util.Arrays;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraft.command.CommandResultStats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.command.FunctionObject;
import net.minecraft.util.ResourceLocation;

public class AdvancementRewards
{
    private final /* synthetic */ ResourceLocation[] field_192117_d;
    private final /* synthetic */ ResourceLocation[] field_192116_c;
    private final /* synthetic */ int field_192115_b;
    private final /* synthetic */ FunctionObject.CacheableFunction field_193129_e;
    
    public AdvancementRewards(final int lllllllllllIIlIlllIlllllIllIIIll, final ResourceLocation[] lllllllllllIIlIlllIlllllIllIIIlI, final ResourceLocation[] lllllllllllIIlIlllIlllllIlIlllII, final FunctionObject.CacheableFunction lllllllllllIIlIlllIlllllIllIIIII) {
        this.field_192115_b = lllllllllllIIlIlllIlllllIllIIIll;
        this.field_192116_c = lllllllllllIIlIlllIlllllIllIIIlI;
        this.field_192117_d = lllllllllllIIlIlllIlllllIlIlllII;
        this.field_193129_e = lllllllllllIIlIlllIlllllIllIIIII;
    }
    
    public void func_192113_a(final EntityPlayerMP lllllllllllIIlIlllIlllllIlIIlllI) {
        lllllllllllIIlIlllIlllllIlIIlllI.addExperience(this.field_192115_b);
        final LootContext lllllllllllIIlIlllIlllllIlIIllIl = new LootContext.Builder(lllllllllllIIlIlllIlllllIlIIlllI.getServerWorld()).withLootedEntity(lllllllllllIIlIlllIlllllIlIIlllI).build();
        boolean lllllllllllIIlIlllIlllllIlIIllII = false;
        final int lllllllllllIIlIlllIlllllIIlllllI;
        final char lllllllllllIIlIlllIlllllIIllllll = (char)((ResourceLocation[])(Object)(lllllllllllIIlIlllIlllllIIlllllI = (int)(Object)this.field_192116_c)).length;
        for (float lllllllllllIIlIlllIlllllIlIIIIII = 0; lllllllllllIIlIlllIlllllIlIIIIII < lllllllllllIIlIlllIlllllIIllllll; ++lllllllllllIIlIlllIlllllIlIIIIII) {
            final ResourceLocation lllllllllllIIlIlllIlllllIlIIlIll = lllllllllllIIlIlllIlllllIIlllllI[lllllllllllIIlIlllIlllllIlIIIIII];
            for (final ItemStack lllllllllllIIlIlllIlllllIlIIlIlI : lllllllllllIIlIlllIlllllIlIIlllI.world.getLootTableManager().getLootTableFromLocation(lllllllllllIIlIlllIlllllIlIIlIll).generateLootForPools(lllllllllllIIlIlllIlllllIlIIlllI.getRNG(), lllllllllllIIlIlllIlllllIlIIllIl)) {
                if (lllllllllllIIlIlllIlllllIlIIlllI.func_191521_c(lllllllllllIIlIlllIlllllIlIIlIlI)) {
                    lllllllllllIIlIlllIlllllIlIIlllI.world.playSound(null, lllllllllllIIlIlllIlllllIlIIlllI.posX, lllllllllllIIlIlllIlllllIlIIlllI.posY, lllllllllllIIlIlllIlllllIlIIlllI.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2f, ((lllllllllllIIlIlllIlllllIlIIlllI.getRNG().nextFloat() - lllllllllllIIlIlllIlllllIlIIlllI.getRNG().nextFloat()) * 0.7f + 1.0f) * 2.0f);
                    lllllllllllIIlIlllIlllllIlIIllII = true;
                }
                else {
                    final EntityItem lllllllllllIIlIlllIlllllIlIIlIIl = lllllllllllIIlIlllIlllllIlIIlllI.dropItem(lllllllllllIIlIlllIlllllIlIIlIlI, false);
                    if (lllllllllllIIlIlllIlllllIlIIlIIl == null) {
                        continue;
                    }
                    lllllllllllIIlIlllIlllllIlIIlIIl.setNoPickupDelay();
                    lllllllllllIIlIlllIlllllIlIIlIIl.setOwner(lllllllllllIIlIlllIlllllIlIIlllI.getName());
                }
            }
        }
        if (lllllllllllIIlIlllIlllllIlIIllII) {
            lllllllllllIIlIlllIlllllIlIIlllI.inventoryContainer.detectAndSendChanges();
        }
        if (this.field_192117_d.length > 0) {
            lllllllllllIIlIlllIlllllIlIIlllI.func_193102_a(this.field_192117_d);
        }
        final MinecraftServer lllllllllllIIlIlllIlllllIlIIlIII = lllllllllllIIlIlllIlllllIlIIlllI.mcServer;
        final FunctionObject lllllllllllIIlIlllIlllllIlIIIlll = this.field_193129_e.func_193518_a(lllllllllllIIlIlllIlllllIlIIlIII.func_193030_aL());
        if (lllllllllllIIlIlllIlllllIlIIIlll != null) {
            final ICommandSender lllllllllllIIlIlllIlllllIlIIIllI = new ICommandSender() {
                @Override
                public BlockPos getPosition() {
                    return lllllllllllIIlIlllIlllllIlIIlllI.getPosition();
                }
                
                @Override
                public boolean sendCommandFeedback() {
                    return lllllllllllIIlIlllIlllllIlIIlIII.worldServers[0].getGameRules().getBoolean("commandBlockOutput");
                }
                
                @Override
                public void setCommandStat(final CommandResultStats.Type llllllllllllllIIlIIIllIIIIlIllll, final int llllllllllllllIIlIIIllIIIIllIIIl) {
                    lllllllllllIIlIlllIlllllIlIIlllI.setCommandStat(llllllllllllllIIlIIIllIIIIlIllll, llllllllllllllIIlIIIllIIIIllIIIl);
                }
                
                @Override
                public World getEntityWorld() {
                    return lllllllllllIIlIlllIlllllIlIIlllI.world;
                }
                
                @Override
                public ITextComponent getDisplayName() {
                    return lllllllllllIIlIlllIlllllIlIIlllI.getDisplayName();
                }
                
                @Override
                public Vec3d getPositionVector() {
                    return lllllllllllIIlIlllIlllllIlIIlllI.getPositionVector();
                }
                
                @Override
                public boolean canCommandSenderUseCommand(final int llllllllllllllIIlIIIllIIIlIIlIII, final String llllllllllllllIIlIIIllIIIlIIIlll) {
                    return llllllllllllllIIlIIIllIIIlIIlIII <= 2;
                }
                
                @Override
                public Entity getCommandSenderEntity() {
                    return lllllllllllIIlIlllIlllllIlIIlllI;
                }
                
                @Override
                public String getName() {
                    return lllllllllllIIlIlllIlllllIlIIlllI.getName();
                }
                
                @Override
                public void addChatMessage(final ITextComponent llllllllllllllIIlIIIllIIIlIIlIll) {
                }
                
                @Override
                public MinecraftServer getServer() {
                    return lllllllllllIIlIlllIlllllIlIIlllI.getServer();
                }
            };
            lllllllllllIIlIlllIlllllIlIIlIII.func_193030_aL().func_194019_a(lllllllllllIIlIlllIlllllIlIIIlll, lllllllllllIIlIlllIlllllIlIIIllI);
        }
    }
    
    @Override
    public String toString() {
        return "AdvancementRewards{experience=" + this.field_192115_b + ", loot=" + Arrays.toString(this.field_192116_c) + ", recipes=" + Arrays.toString(this.field_192117_d) + ", function=" + this.field_193129_e + '}';
    }
    
    static {
        field_192114_a = new AdvancementRewards(0, new ResourceLocation[0], new ResourceLocation[0], FunctionObject.CacheableFunction.field_193519_a);
    }
    
    public static class Deserializer implements JsonDeserializer<AdvancementRewards>
    {
        public AdvancementRewards deserialize(final JsonElement llllllllllllIIIllllIlIIlIIlllIIl, final Type llllllllllllIIIllllIlIIlIIlllIII, final JsonDeserializationContext llllllllllllIIIllllIlIIlIIllIlll) throws JsonParseException {
            final JsonObject llllllllllllIIIllllIlIIlIIllIllI = JsonUtils.getJsonObject(llllllllllllIIIllllIlIIlIIlllIIl, "rewards");
            final int llllllllllllIIIllllIlIIlIIllIlIl = JsonUtils.getInt(llllllllllllIIIllllIlIIlIIllIllI, "experience", 0);
            final JsonArray llllllllllllIIIllllIlIIlIIllIlII = JsonUtils.getJsonArray(llllllllllllIIIllllIlIIlIIllIllI, "loot", new JsonArray());
            final ResourceLocation[] llllllllllllIIIllllIlIIlIIllIIll = new ResourceLocation[llllllllllllIIIllllIlIIlIIllIlII.size()];
            for (int llllllllllllIIIllllIlIIlIIllIIlI = 0; llllllllllllIIIllllIlIIlIIllIIlI < llllllllllllIIIllllIlIIlIIllIIll.length; ++llllllllllllIIIllllIlIIlIIllIIlI) {
                llllllllllllIIIllllIlIIlIIllIIll[llllllllllllIIIllllIlIIlIIllIIlI] = new ResourceLocation(JsonUtils.getString(llllllllllllIIIllllIlIIlIIllIlII.get(llllllllllllIIIllllIlIIlIIllIIlI), "loot[" + llllllllllllIIIllllIlIIlIIllIIlI + "]"));
            }
            final JsonArray llllllllllllIIIllllIlIIlIIllIIIl = JsonUtils.getJsonArray(llllllllllllIIIllllIlIIlIIllIllI, "recipes", new JsonArray());
            final ResourceLocation[] llllllllllllIIIllllIlIIlIIllIIII = new ResourceLocation[llllllllllllIIIllllIlIIlIIllIIIl.size()];
            for (int llllllllllllIIIllllIlIIlIIlIllll = 0; llllllllllllIIIllllIlIIlIIlIllll < llllllllllllIIIllllIlIIlIIllIIII.length; ++llllllllllllIIIllllIlIIlIIlIllll) {
                llllllllllllIIIllllIlIIlIIllIIII[llllllllllllIIIllllIlIIlIIlIllll] = new ResourceLocation(JsonUtils.getString(llllllllllllIIIllllIlIIlIIllIIIl.get(llllllllllllIIIllllIlIIlIIlIllll), "recipes[" + llllllllllllIIIllllIlIIlIIlIllll + "]"));
                final IRecipe llllllllllllIIIllllIlIIlIIlIlllI = CraftingManager.func_193373_a(llllllllllllIIIllllIlIIlIIllIIII[llllllllllllIIIllllIlIIlIIlIllll]);
                if (llllllllllllIIIllllIlIIlIIlIlllI == null) {
                    throw new JsonSyntaxException("Unknown recipe '" + llllllllllllIIIllllIlIIlIIllIIII[llllllllllllIIIllllIlIIlIIlIllll] + "'");
                }
            }
            FunctionObject.CacheableFunction llllllllllllIIIllllIlIIlIIlIllII = null;
            if (llllllllllllIIIllllIlIIlIIllIllI.has("function")) {
                final FunctionObject.CacheableFunction llllllllllllIIIllllIlIIlIIlIllIl = new FunctionObject.CacheableFunction(new ResourceLocation(JsonUtils.getString(llllllllllllIIIllllIlIIlIIllIllI, "function")));
            }
            else {
                llllllllllllIIIllllIlIIlIIlIllII = FunctionObject.CacheableFunction.field_193519_a;
            }
            return new AdvancementRewards(llllllllllllIIIllllIlIIlIIllIlIl, llllllllllllIIIllllIlIIlIIllIIll, llllllllllllIIIllllIlIIlIIllIIII, llllllllllllIIIllllIlIIlIIlIllII);
        }
    }
}
