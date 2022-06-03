// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.stats;

import net.minecraft.item.crafting.CraftingManager;
import javax.annotation.Nullable;
import net.minecraft.item.crafting.IRecipe;
import java.util.BitSet;

public class RecipeBook
{
    protected final /* synthetic */ BitSet field_194077_a;
    protected final /* synthetic */ BitSet field_194078_b;
    protected /* synthetic */ boolean field_192819_c;
    protected /* synthetic */ boolean field_192818_b;
    
    public boolean func_192812_b() {
        return this.field_192818_b;
    }
    
    public void func_194074_f(final IRecipe lllllllllllllIllIlllIlIlllllIIII) {
        this.field_194078_b.clear(func_194075_d(lllllllllllllIllIlllIlIlllllIIII));
    }
    
    public void func_194073_a(final IRecipe lllllllllllllIllIlllIllIIIIIllII) {
        if (!lllllllllllllIllIlllIllIIIIIllII.func_192399_d()) {
            this.field_194077_a.set(func_194075_d(lllllllllllllIllIlllIllIIIIIllII));
        }
    }
    
    public boolean func_194076_e(final IRecipe lllllllllllllIllIlllIlIlllllIlII) {
        return this.field_194078_b.get(func_194075_d(lllllllllllllIllIlllIlIlllllIlII));
    }
    
    public RecipeBook() {
        this.field_194077_a = new BitSet();
        this.field_194078_b = new BitSet();
    }
    
    protected static int func_194075_d(@Nullable final IRecipe lllllllllllllIllIlllIlIllllllIll) {
        return CraftingManager.field_193380_a.getIDForObject(lllllllllllllIllIlllIlIllllllIll);
    }
    
    public void func_193831_b(final IRecipe lllllllllllllIllIlllIlIllllllllI) {
        final int lllllllllllllIllIlllIllIIIIIIIII = func_194075_d(lllllllllllllIllIlllIlIllllllllI);
        this.field_194077_a.clear(lllllllllllllIllIlllIllIIIIIIIII);
        this.field_194078_b.clear(lllllllllllllIllIlllIllIIIIIIIII);
    }
    
    public boolean func_192815_c() {
        return this.field_192819_c;
    }
    
    public boolean func_193830_f(@Nullable final IRecipe lllllllllllllIllIlllIllIIIIIIllI) {
        return this.field_194077_a.get(func_194075_d(lllllllllllllIllIlllIllIIIIIIllI));
    }
    
    public void func_192813_a(final boolean lllllllllllllIllIlllIlIllllIIIIl) {
        this.field_192818_b = lllllllllllllIllIlllIlIllllIIIIl;
    }
    
    public void func_193824_a(final RecipeBook lllllllllllllIllIlllIllIIIIlIIlI) {
        this.field_194077_a.clear();
        this.field_194078_b.clear();
        this.field_194077_a.or(lllllllllllllIllIlllIllIIIIlIIlI.field_194077_a);
        this.field_194078_b.or(lllllllllllllIllIlllIllIIIIlIIlI.field_194078_b);
    }
    
    public void func_193825_e(final IRecipe lllllllllllllIllIlllIlIllllIlIlI) {
        this.field_194078_b.set(func_194075_d(lllllllllllllIllIlllIlIllllIlIlI));
    }
    
    public void func_192810_b(final boolean lllllllllllllIllIlllIlIlllIllIII) {
        this.field_192819_c = lllllllllllllIllIlllIlIlllIllIII;
    }
}
