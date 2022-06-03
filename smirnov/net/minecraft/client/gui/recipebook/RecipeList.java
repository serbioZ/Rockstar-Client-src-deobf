// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.recipebook;

import net.minecraft.item.ItemStack;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.client.util.RecipeItemHelper;
import com.google.common.collect.Lists;
import net.minecraft.stats.RecipeBook;
import net.minecraft.item.crafting.IRecipe;
import java.util.List;
import java.util.BitSet;

public class RecipeList
{
    private /* synthetic */ boolean field_194218_e;
    private final /* synthetic */ BitSet field_194215_b;
    private final /* synthetic */ BitSet field_194216_c;
    private final /* synthetic */ BitSet field_194217_d;
    private /* synthetic */ List<IRecipe> field_192713_b;
    
    public boolean func_194213_a(final IRecipe lllllllllllIlIIllIlIIlIIIIlllIIl) {
        return this.field_194215_b.get(this.field_192713_b.indexOf(lllllllllllIlIIllIlIIlIIIIlllIIl));
    }
    
    public boolean func_194212_c() {
        return !this.field_194216_c.isEmpty();
    }
    
    public void func_194214_a(final RecipeBook lllllllllllIlIIllIlIIlIIIlIllIll) {
        for (int lllllllllllIlIIllIlIIlIIIlIllIlI = 0; lllllllllllIlIIllIlIIlIIIlIllIlI < this.field_192713_b.size(); ++lllllllllllIlIIllIlIIlIIIlIllIlI) {
            this.field_194217_d.set(lllllllllllIlIIllIlIIlIIIlIllIlI, lllllllllllIlIIllIlIIlIIIlIllIll.func_193830_f(this.field_192713_b.get(lllllllllllIlIIllIlIIlIIIlIllIlI)));
        }
    }
    
    public boolean func_194211_e() {
        return this.field_194218_e;
    }
    
    public List<IRecipe> func_194208_a(final boolean lllllllllllIlIIllIlIIlIIIIlIlIlI) {
        final List<IRecipe> lllllllllllIlIIllIlIIlIIIIlIlIIl = (List<IRecipe>)Lists.newArrayList();
        for (int lllllllllllIlIIllIlIIlIIIIlIlIII = this.field_194217_d.nextSetBit(0); lllllllllllIlIIllIlIIlIIIIlIlIII >= 0; lllllllllllIlIIllIlIIlIIIIlIlIII = this.field_194217_d.nextSetBit(lllllllllllIlIIllIlIIlIIIIlIlIII + 1)) {
            if ((lllllllllllIlIIllIlIIlIIIIlIlIlI ? this.field_194215_b : this.field_194216_c).get(lllllllllllIlIIllIlIIlIIIIlIlIII)) {
                lllllllllllIlIIllIlIIlIIIIlIlIIl.add(this.field_192713_b.get(lllllllllllIlIIllIlIIlIIIIlIlIII));
            }
        }
        return lllllllllllIlIIllIlIIlIIIIlIlIIl;
    }
    
    public RecipeList() {
        this.field_192713_b = (List<IRecipe>)Lists.newArrayList();
        this.field_194215_b = new BitSet();
        this.field_194216_c = new BitSet();
        this.field_194217_d = new BitSet();
        this.field_194218_e = true;
    }
    
    public boolean func_194209_a() {
        return !this.field_194217_d.isEmpty();
    }
    
    public List<IRecipe> func_194207_b(final boolean lllllllllllIlIIllIlIIlIIIIIllIlI) {
        final List<IRecipe> lllllllllllIlIIllIlIIlIIIIIlllIl = (List<IRecipe>)Lists.newArrayList();
        for (int lllllllllllIlIIllIlIIlIIIIIlllII = this.field_194217_d.nextSetBit(0); lllllllllllIlIIllIlIIlIIIIIlllII >= 0; lllllllllllIlIIllIlIIlIIIIIlllII = this.field_194217_d.nextSetBit(lllllllllllIlIIllIlIIlIIIIIlllII + 1)) {
            if (this.field_194216_c.get(lllllllllllIlIIllIlIIlIIIIIlllII) && this.field_194215_b.get(lllllllllllIlIIllIlIIlIIIIIlllII) == lllllllllllIlIIllIlIIlIIIIIllIlI) {
                lllllllllllIlIIllIlIIlIIIIIlllIl.add(this.field_192713_b.get(lllllllllllIlIIllIlIIlIIIIIlllII));
            }
        }
        return lllllllllllIlIIllIlIIlIIIIIlllIl;
    }
    
    public List<IRecipe> func_192711_b() {
        return this.field_192713_b;
    }
    
    public boolean func_192708_c() {
        return !this.field_194215_b.isEmpty();
    }
    
    public void func_194210_a(final RecipeItemHelper lllllllllllIlIIllIlIIlIIIlIIIlIl, final int lllllllllllIlIIllIlIIlIIIlIIllII, final int lllllllllllIlIIllIlIIlIIIlIIIIll, final RecipeBook lllllllllllIlIIllIlIIlIIIlIIlIlI) {
        for (int lllllllllllIlIIllIlIIlIIIlIIlIIl = 0; lllllllllllIlIIllIlIIlIIIlIIlIIl < this.field_192713_b.size(); ++lllllllllllIlIIllIlIIlIIIlIIlIIl) {
            final IRecipe lllllllllllIlIIllIlIIlIIIlIIlIII = this.field_192713_b.get(lllllllllllIlIIllIlIIlIIIlIIlIIl);
            final boolean lllllllllllIlIIllIlIIlIIIlIIIlll = lllllllllllIlIIllIlIIlIIIlIIlIII.func_194133_a(lllllllllllIlIIllIlIIlIIIlIIllII, lllllllllllIlIIllIlIIlIIIlIIIIll) && lllllllllllIlIIllIlIIlIIIlIIlIlI.func_193830_f(lllllllllllIlIIllIlIIlIIIlIIlIII);
            this.field_194216_c.set(lllllllllllIlIIllIlIIlIIIlIIlIIl, lllllllllllIlIIllIlIIlIIIlIIIlll);
            this.field_194215_b.set(lllllllllllIlIIllIlIIlIIIlIIlIIl, lllllllllllIlIIllIlIIlIIIlIIIlll && lllllllllllIlIIllIlIIlIIIlIIIlIl.func_194116_a(lllllllllllIlIIllIlIIlIIIlIIlIII, null));
        }
    }
    
    public void func_192709_a(final IRecipe lllllllllllIlIIllIlIIlIIIIIlIIlI) {
        this.field_192713_b.add(lllllllllllIlIIllIlIIlIIIIIlIIlI);
        if (this.field_194218_e) {
            final ItemStack lllllllllllIlIIllIlIIlIIIIIlIIIl = this.field_192713_b.get(0).getRecipeOutput();
            final ItemStack lllllllllllIlIIllIlIIlIIIIIlIIII = lllllllllllIlIIllIlIIlIIIIIlIIlI.getRecipeOutput();
            this.field_194218_e = (ItemStack.areItemsEqual(lllllllllllIlIIllIlIIlIIIIIlIIIl, lllllllllllIlIIllIlIIlIIIIIlIIII) && ItemStack.areItemStackTagsEqual(lllllllllllIlIIllIlIIlIIIIIlIIIl, lllllllllllIlIIllIlIIlIIIIIlIIII));
        }
    }
}
