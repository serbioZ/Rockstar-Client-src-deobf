// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.stats;

import java.util.Iterator;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.advancements.CriteriaTriggers;
import java.util.Collections;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.network.Packet;
import org.apache.logging.log4j.LogManager;
import net.minecraft.network.play.server.SPacketRecipeBook;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.crafting.IRecipe;
import java.util.List;
import org.apache.logging.log4j.Logger;

public class RecipeBookServer extends RecipeBook
{
    private static final /* synthetic */ Logger field_192828_d;
    
    public void func_193834_b(final List<IRecipe> lllllllllllIllIlllllllIllIIIlIll, final EntityPlayerMP lllllllllllIllIlllllllIllIIIIlIl) {
        final List<IRecipe> lllllllllllIllIlllllllIllIIIlIIl = (List<IRecipe>)Lists.newArrayList();
        for (final IRecipe lllllllllllIllIlllllllIllIIIlIII : lllllllllllIllIlllllllIllIIIlIll) {
            if (this.field_194077_a.get(RecipeBook.func_194075_d(lllllllllllIllIlllllllIllIIIlIII))) {
                this.func_193831_b(lllllllllllIllIlllllllIllIIIlIII);
                lllllllllllIllIlllllllIllIIIlIIl.add(lllllllllllIllIlllllllIllIIIlIII);
            }
        }
        this.func_194081_a(SPacketRecipeBook.State.REMOVE, lllllllllllIllIlllllllIllIIIIlIl, lllllllllllIllIlllllllIllIIIlIIl);
    }
    
    static {
        field_192828_d = LogManager.getLogger();
    }
    
    public void func_192826_c(final EntityPlayerMP lllllllllllIllIlllllllIlIIllIlII) {
        lllllllllllIllIlllllllIlIIllIlII.connection.sendPacket(new SPacketRecipeBook(SPacketRecipeBook.State.INIT, this.func_194079_d(), this.func_194080_e(), this.field_192818_b, this.field_192819_c));
    }
    
    private List<IRecipe> func_194080_e() {
        final List<IRecipe> lllllllllllIllIlllllllIlIIlllllI = (List<IRecipe>)Lists.newArrayList();
        for (int lllllllllllIllIlllllllIlIIllllIl = this.field_194078_b.nextSetBit(0); lllllllllllIllIlllllllIlIIllllIl >= 0; lllllllllllIllIlllllllIlIIllllIl = this.field_194078_b.nextSetBit(lllllllllllIllIlllllllIlIIllllIl + 1)) {
            lllllllllllIllIlllllllIlIIlllllI.add(CraftingManager.field_193380_a.getObjectById(lllllllllllIllIlllllllIlIIllllIl));
        }
        return lllllllllllIllIlllllllIlIIlllllI;
    }
    
    private void func_194081_a(final SPacketRecipeBook.State lllllllllllIllIlllllllIlIllllIII, final EntityPlayerMP lllllllllllIllIlllllllIlIllllIll, final List<IRecipe> lllllllllllIllIlllllllIlIllllIlI) {
        lllllllllllIllIlllllllIlIllllIll.connection.sendPacket(new SPacketRecipeBook(lllllllllllIllIlllllllIlIllllIII, lllllllllllIllIlllllllIlIllllIlI, Collections.emptyList(), this.field_192818_b, this.field_192819_c));
    }
    
    public void func_193835_a(final List<IRecipe> lllllllllllIllIlllllllIllIIlllII, final EntityPlayerMP lllllllllllIllIlllllllIllIIllIll) {
        final List<IRecipe> lllllllllllIllIlllllllIllIIllIlI = (List<IRecipe>)Lists.newArrayList();
        for (final IRecipe lllllllllllIllIlllllllIllIIllIIl : lllllllllllIllIlllllllIllIIlllII) {
            if (!this.field_194077_a.get(RecipeBook.func_194075_d(lllllllllllIllIlllllllIllIIllIIl)) && !lllllllllllIllIlllllllIllIIllIIl.func_192399_d()) {
                this.func_194073_a(lllllllllllIllIlllllllIllIIllIIl);
                this.func_193825_e(lllllllllllIllIlllllllIllIIllIIl);
                lllllllllllIllIlllllllIllIIllIlI.add(lllllllllllIllIlllllllIllIIllIIl);
                CriteriaTriggers.field_192126_f.func_192225_a(lllllllllllIllIlllllllIllIIllIll, lllllllllllIllIlllllllIllIIllIIl);
            }
        }
        this.func_194081_a(SPacketRecipeBook.State.ADD, lllllllllllIllIlllllllIllIIllIll, lllllllllllIllIlllllllIllIIllIlI);
    }
    
    public NBTTagCompound func_192824_e() {
        final NBTTagCompound lllllllllllIllIlllllllIlIllIlllI = new NBTTagCompound();
        lllllllllllIllIlllllllIlIllIlllI.setBoolean("isGuiOpen", this.field_192818_b);
        lllllllllllIllIlllllllIlIllIlllI.setBoolean("isFilteringCraftable", this.field_192819_c);
        final NBTTagList lllllllllllIllIlllllllIlIllIllIl = new NBTTagList();
        for (final IRecipe lllllllllllIllIlllllllIlIllIllII : this.func_194079_d()) {
            lllllllllllIllIlllllllIlIllIllIl.appendTag(new NBTTagString(CraftingManager.field_193380_a.getNameForObject(lllllllllllIllIlllllllIlIllIllII).toString()));
        }
        lllllllllllIllIlllllllIlIllIlllI.setTag("recipes", lllllllllllIllIlllllllIlIllIllIl);
        final NBTTagList lllllllllllIllIlllllllIlIllIlIll = new NBTTagList();
        for (final IRecipe lllllllllllIllIlllllllIlIllIlIlI : this.func_194080_e()) {
            lllllllllllIllIlllllllIlIllIlIll.appendTag(new NBTTagString(CraftingManager.field_193380_a.getNameForObject(lllllllllllIllIlllllllIlIllIlIlI).toString()));
        }
        lllllllllllIllIlllllllIlIllIlllI.setTag("toBeDisplayed", lllllllllllIllIlllllllIlIllIlIll);
        return lllllllllllIllIlllllllIlIllIlllI;
    }
    
    private List<IRecipe> func_194079_d() {
        final List<IRecipe> lllllllllllIllIlllllllIlIlIIIlll = (List<IRecipe>)Lists.newArrayList();
        for (int lllllllllllIllIlllllllIlIlIIIllI = this.field_194077_a.nextSetBit(0); lllllllllllIllIlllllllIlIlIIIllI >= 0; lllllllllllIllIlllllllIlIlIIIllI = this.field_194077_a.nextSetBit(lllllllllllIllIlllllllIlIlIIIllI + 1)) {
            lllllllllllIllIlllllllIlIlIIIlll.add(CraftingManager.field_193380_a.getObjectById(lllllllllllIllIlllllllIlIlIIIllI));
        }
        return lllllllllllIllIlllllllIlIlIIIlll;
    }
    
    public void func_192825_a(final NBTTagCompound lllllllllllIllIlllllllIlIlIllIll) {
        this.field_192818_b = lllllllllllIllIlllllllIlIlIllIll.getBoolean("isGuiOpen");
        this.field_192819_c = lllllllllllIllIlllllllIlIlIllIll.getBoolean("isFilteringCraftable");
        final NBTTagList lllllllllllIllIlllllllIlIlIllIlI = lllllllllllIllIlllllllIlIlIllIll.getTagList("recipes", 8);
        for (int lllllllllllIllIlllllllIlIlIllIIl = 0; lllllllllllIllIlllllllIlIlIllIIl < lllllllllllIllIlllllllIlIlIllIlI.tagCount(); ++lllllllllllIllIlllllllIlIlIllIIl) {
            final ResourceLocation lllllllllllIllIlllllllIlIlIllIII = new ResourceLocation(lllllllllllIllIlllllllIlIlIllIlI.getStringTagAt(lllllllllllIllIlllllllIlIlIllIIl));
            final IRecipe lllllllllllIllIlllllllIlIlIlIlll = CraftingManager.func_193373_a(lllllllllllIllIlllllllIlIlIllIII);
            if (lllllllllllIllIlllllllIlIlIlIlll == null) {
                RecipeBookServer.field_192828_d.info("Tried to load unrecognized recipe: {} removed now.", (Object)lllllllllllIllIlllllllIlIlIllIII);
            }
            else {
                this.func_194073_a(lllllllllllIllIlllllllIlIlIlIlll);
            }
        }
        final NBTTagList lllllllllllIllIlllllllIlIlIlIllI = lllllllllllIllIlllllllIlIlIllIll.getTagList("toBeDisplayed", 8);
        for (int lllllllllllIllIlllllllIlIlIlIlIl = 0; lllllllllllIllIlllllllIlIlIlIlIl < lllllllllllIllIlllllllIlIlIlIllI.tagCount(); ++lllllllllllIllIlllllllIlIlIlIlIl) {
            final ResourceLocation lllllllllllIllIlllllllIlIlIlIlII = new ResourceLocation(lllllllllllIllIlllllllIlIlIlIllI.getStringTagAt(lllllllllllIllIlllllllIlIlIlIlIl));
            final IRecipe lllllllllllIllIlllllllIlIlIlIIll = CraftingManager.func_193373_a(lllllllllllIllIlllllllIlIlIlIlII);
            if (lllllllllllIllIlllllllIlIlIlIIll == null) {
                RecipeBookServer.field_192828_d.info("Tried to load unrecognized recipe: {} removed now.", (Object)lllllllllllIllIlllllllIlIlIlIlII);
            }
            else {
                this.func_193825_e(lllllllllllIllIlllllllIlIlIlIIll);
            }
        }
    }
}
