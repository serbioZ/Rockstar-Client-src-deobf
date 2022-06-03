// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.util;

import it.unimi.dsi.fastutil.ints.IntListIterator;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntCollection;
import it.unimi.dsi.fastutil.ints.IntAVLTreeSet;
import java.util.Collection;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import com.google.common.collect.Lists;
import net.minecraft.item.crafting.Ingredient;
import java.util.List;
import java.util.BitSet;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import javax.annotation.Nullable;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import it.unimi.dsi.fastutil.ints.Int2IntMap;

public class RecipeItemHelper
{
    public final /* synthetic */ Int2IntMap field_194124_a;
    
    public void func_194112_a(final ItemStack llllllllllllIlIIllIIlIlIIllIIlll) {
        if (!llllllllllllIlIIllIIlIlIIllIIlll.func_190926_b() && !llllllllllllIlIIllIIlIlIIllIIlll.isItemDamaged() && !llllllllllllIlIIllIIlIlIIllIIlll.isItemEnchanted() && !llllllllllllIlIIllIIlIlIIllIIlll.hasDisplayName()) {
            final int llllllllllllIlIIllIIlIlIIllIlIlI = func_194113_b(llllllllllllIlIIllIIlIlIIllIIlll);
            final int llllllllllllIlIIllIIlIlIIllIlIIl = llllllllllllIlIIllIIlIlIIllIIlll.func_190916_E();
            this.func_194117_b(llllllllllllIlIIllIIlIlIIllIlIlI, llllllllllllIlIIllIIlIlIIllIlIIl);
        }
    }
    
    public void func_194119_a() {
        this.field_194124_a.clear();
    }
    
    public static ItemStack func_194115_b(final int llllllllllllIlIIllIIlIlIIIIlIlII) {
        return (llllllllllllIlIIllIIlIlIIIIlIlII == 0) ? ItemStack.field_190927_a : new ItemStack(Item.getItemById(llllllllllllIlIIllIIlIlIIIIlIlII >> 16 & 0xFFFF), 1, llllllllllllIlIIllIIlIlIIIIlIlII & 0xFFFF);
    }
    
    public int func_194122_a(final int llllllllllllIlIIllIIlIlIIlIlIIII, final int llllllllllllIlIIllIIlIlIIlIIlIll) {
        final int llllllllllllIlIIllIIlIlIIlIIlllI = this.field_194124_a.get(llllllllllllIlIIllIIlIlIIlIlIIII);
        if (llllllllllllIlIIllIIlIlIIlIIlllI >= llllllllllllIlIIllIIlIlIIlIIlIll) {
            this.field_194124_a.put(llllllllllllIlIIllIIlIlIIlIlIIII, llllllllllllIlIIllIIlIlIIlIIlllI - llllllllllllIlIIllIIlIlIIlIIlIll);
            return llllllllllllIlIIllIIlIlIIlIlIIII;
        }
        return 0;
    }
    
    public int func_194114_b(final IRecipe llllllllllllIlIIllIIlIlIIIlIIlII, @Nullable final IntList llllllllllllIlIIllIIlIlIIIlIIllI) {
        return this.func_194121_a(llllllllllllIlIIllIIlIlIIIlIIlII, Integer.MAX_VALUE, llllllllllllIlIIllIIlIlIIIlIIllI);
    }
    
    public boolean func_194118_a(final IRecipe llllllllllllIlIIllIIlIlIIIllIIlI, @Nullable final IntList llllllllllllIlIIllIIlIlIIIllIIIl, final int llllllllllllIlIIllIIlIlIIIllIIII) {
        return new RecipePicker(llllllllllllIlIIllIIlIlIIIllIIlI).func_194092_a(llllllllllllIlIIllIIlIlIIIllIIII, llllllllllllIlIIllIIlIlIIIllIIIl);
    }
    
    public RecipeItemHelper() {
        this.field_194124_a = (Int2IntMap)new Int2IntOpenHashMap();
    }
    
    public static int func_194113_b(final ItemStack llllllllllllIlIIllIIlIlIIllIIIIl) {
        final Item llllllllllllIlIIllIIlIlIIllIIIII = llllllllllllIlIIllIIlIlIIllIIIIl.getItem();
        final int llllllllllllIlIIllIIlIlIIlIlllll = llllllllllllIlIIllIIlIlIIllIIIII.getHasSubtypes() ? llllllllllllIlIIllIIlIlIIllIIIIl.getMetadata() : 0;
        return Item.REGISTRY.getIDForObject(llllllllllllIlIIllIIlIlIIllIIIII) << 16 | (llllllllllllIlIIllIIlIlIIlIlllll & 0xFFFF);
    }
    
    public boolean func_194120_a(final int llllllllllllIlIIllIIlIlIIlIllIII) {
        return this.field_194124_a.get(llllllllllllIlIIllIIlIlIIlIllIII) > 0;
    }
    
    private void func_194117_b(final int llllllllllllIlIIllIIlIlIIlIIIIlI, final int llllllllllllIlIIllIIlIlIIlIIIIIl) {
        this.field_194124_a.put(llllllllllllIlIIllIIlIlIIlIIIIlI, this.field_194124_a.get(llllllllllllIlIIllIIlIlIIlIIIIlI) + llllllllllllIlIIllIIlIlIIlIIIIIl);
    }
    
    public int func_194121_a(final IRecipe llllllllllllIlIIllIIlIlIIIIlllIl, final int llllllllllllIlIIllIIlIlIIIIlllII, @Nullable final IntList llllllllllllIlIIllIIlIlIIIIlIlll) {
        return new RecipePicker(llllllllllllIlIIllIIlIlIIIIlllIl).func_194102_b(llllllllllllIlIIllIIlIlIIIIlllII, llllllllllllIlIIllIIlIlIIIIlIlll);
    }
    
    public boolean func_194116_a(final IRecipe llllllllllllIlIIllIIlIlIIIllllII, @Nullable final IntList llllllllllllIlIIllIIlIlIIIlllIll) {
        return this.func_194118_a(llllllllllllIlIIllIIlIlIIIllllII, llllllllllllIlIIllIIlIlIIIlllIll, 1);
    }
    
    class RecipePicker
    {
        private final /* synthetic */ int field_194107_d;
        private final /* synthetic */ BitSet field_194110_g;
        private /* synthetic */ IntList field_194111_h;
        private final /* synthetic */ int field_194109_f;
        private final /* synthetic */ int[] field_194108_e;
        private final /* synthetic */ IRecipe field_194105_b;
        private final /* synthetic */ List<Ingredient> field_194106_c;
        
        private void func_194088_a(final boolean lllllllllllIIIIIIllIIlIlIlIlIlll, final int lllllllllllIIIIIIllIIlIlIlIlIllI) {
            this.field_194110_g.set(this.func_194099_c(lllllllllllIIIIIIllIIlIlIlIlIlll, lllllllllllIIIIIIllIIlIlIlIlIllI));
            this.field_194111_h.add(lllllllllllIIIIIIllIIlIlIlIlIllI);
        }
        
        public int func_194102_b(final int lllllllllllIIIIIIllIIlIlIIllllII, @Nullable final IntList lllllllllllIIIIIIllIIlIlIIllIlIl) {
            int lllllllllllIIIIIIllIIlIlIIlllIlI = 0;
            int lllllllllllIIIIIIllIIlIlIIlllIIl = Math.min(lllllllllllIIIIIIllIIlIlIIllllII, this.func_194090_b()) + 1;
            int lllllllllllIIIIIIllIIlIlIIlllIII;
            while (true) {
                lllllllllllIIIIIIllIIlIlIIlllIII = (lllllllllllIIIIIIllIIlIlIIlllIlI + lllllllllllIIIIIIllIIlIlIIlllIIl) / 2;
                if (this.func_194092_a(lllllllllllIIIIIIllIIlIlIIlllIII, null)) {
                    if (lllllllllllIIIIIIllIIlIlIIlllIIl - lllllllllllIIIIIIllIIlIlIIlllIlI <= 1) {
                        break;
                    }
                    lllllllllllIIIIIIllIIlIlIIlllIlI = lllllllllllIIIIIIllIIlIlIIlllIII;
                }
                else {
                    lllllllllllIIIIIIllIIlIlIIlllIIl = lllllllllllIIIIIIllIIlIlIIlllIII;
                }
            }
            if (lllllllllllIIIIIIllIIlIlIIlllIII > 0) {
                this.func_194092_a(lllllllllllIIIIIIllIIlIlIIlllIII, lllllllllllIIIIIIllIIlIlIIllIlIl);
            }
            return lllllllllllIIIIIIllIIlIlIIlllIII;
        }
        
        private boolean func_194093_a(final boolean lllllllllllIIIIIIllIIlIllIIIllII, final int lllllllllllIIIIIIllIIlIllIIIlIll, final int lllllllllllIIIIIIllIIlIllIIIIllI) {
            return this.field_194110_g.get(this.func_194095_d(lllllllllllIIIIIIllIIlIllIIIllII, lllllllllllIIIIIIllIIlIllIIIlIll, lllllllllllIIIIIIllIIlIllIIIIllI));
        }
        
        private boolean func_194091_b(final int lllllllllllIIIIIIllIIlIllIIllllI) {
            return this.field_194110_g.get(this.func_194094_d(lllllllllllIIIIIIllIIlIllIIllllI));
        }
        
        private int func_194094_d(final int lllllllllllIIIIIIllIIlIllIIlIlII) {
            return this.field_194107_d + this.field_194109_f + lllllllllllIIIIIIllIIlIllIIlIlII;
        }
        
        public RecipePicker(final IRecipe lllllllllllIIIIIIllIIlIllllIllll) {
            this.field_194106_c = (List<Ingredient>)Lists.newArrayList();
            this.field_194111_h = (IntList)new IntArrayList();
            this.field_194105_b = lllllllllllIIIIIIllIIlIllllIllll;
            this.field_194106_c.addAll(lllllllllllIIIIIIllIIlIllllIllll.func_192400_c());
            this.field_194106_c.removeIf(lllllllllllIIIIIIllIIlIlIIIllIll -> lllllllllllIIIIIIllIIlIlIIIllIll == Ingredient.field_193370_a);
            this.field_194107_d = this.field_194106_c.size();
            this.field_194108_e = this.func_194097_a();
            this.field_194109_f = this.field_194108_e.length;
            this.field_194110_g = new BitSet(this.field_194107_d + this.field_194109_f + this.field_194107_d + this.field_194107_d * this.field_194109_f);
            for (int lllllllllllIIIIIIllIIlIlllllIlII = 0; lllllllllllIIIIIIllIIlIlllllIlII < this.field_194106_c.size(); ++lllllllllllIIIIIIllIIlIlllllIlII) {
                final IntList lllllllllllIIIIIIllIIlIlllllIIll = this.field_194106_c.get(lllllllllllIIIIIIllIIlIlllllIlII).func_194139_b();
                for (int lllllllllllIIIIIIllIIlIlllllIIlI = 0; lllllllllllIIIIIIllIIlIlllllIIlI < this.field_194109_f; ++lllllllllllIIIIIIllIIlIlllllIIlI) {
                    if (lllllllllllIIIIIIllIIlIlllllIIll.contains(this.field_194108_e[lllllllllllIIIIIIllIIlIlllllIIlI])) {
                        this.field_194110_g.set(this.func_194095_d(true, lllllllllllIIIIIIllIIlIlllllIIlI, lllllllllllIIIIIIllIIlIlllllIlII));
                    }
                }
            }
        }
        
        private boolean func_194098_a(final int lllllllllllIIIIIIllIIlIllIllIlIl) {
            for (int lllllllllllIIIIIIllIIlIllIllIlII = this.field_194109_f, lllllllllllIIIIIIllIIlIllIllIIll = 0; lllllllllllIIIIIIllIIlIllIllIIll < lllllllllllIIIIIIllIIlIllIllIlII; ++lllllllllllIIIIIIllIIlIllIllIIll) {
                if (RecipeItemHelper.this.field_194124_a.get(this.field_194108_e[lllllllllllIIIIIIllIIlIllIllIIll]) >= lllllllllllIIIIIIllIIlIllIllIlIl) {
                    this.func_194088_a(false, lllllllllllIIIIIIllIIlIllIllIIll);
                    while (!this.field_194111_h.isEmpty()) {
                        final int lllllllllllIIIIIIllIIlIllIllIIlI = this.field_194111_h.size();
                        final boolean lllllllllllIIIIIIllIIlIllIllIIIl = (lllllllllllIIIIIIllIIlIllIllIIlI & 0x1) == 0x1;
                        final int lllllllllllIIIIIIllIIlIllIllIIII = this.field_194111_h.getInt(lllllllllllIIIIIIllIIlIllIllIIlI - 1);
                        if (!lllllllllllIIIIIIllIIlIllIllIIIl && !this.func_194091_b(lllllllllllIIIIIIllIIlIllIllIIII)) {
                            break;
                        }
                        for (int lllllllllllIIIIIIllIIlIllIlIllll = lllllllllllIIIIIIllIIlIllIllIIIl ? this.field_194107_d : lllllllllllIIIIIIllIIlIllIllIlII, lllllllllllIIIIIIllIIlIllIlIlllI = 0; lllllllllllIIIIIIllIIlIllIlIlllI < lllllllllllIIIIIIllIIlIllIlIllll; ++lllllllllllIIIIIIllIIlIllIlIlllI) {
                            if (!this.func_194101_b(lllllllllllIIIIIIllIIlIllIllIIIl, lllllllllllIIIIIIllIIlIllIlIlllI) && this.func_194093_a(lllllllllllIIIIIIllIIlIllIllIIIl, lllllllllllIIIIIIllIIlIllIllIIII, lllllllllllIIIIIIllIIlIllIlIlllI) && this.func_194100_b(lllllllllllIIIIIIllIIlIllIllIIIl, lllllllllllIIIIIIllIIlIllIllIIII, lllllllllllIIIIIIllIIlIllIlIlllI)) {
                                this.func_194088_a(lllllllllllIIIIIIllIIlIllIllIIIl, lllllllllllIIIIIIllIIlIllIlIlllI);
                                break;
                            }
                        }
                        final int lllllllllllIIIIIIllIIlIllIlIllIl = this.field_194111_h.size();
                        if (lllllllllllIIIIIIllIIlIllIlIllIl != lllllllllllIIIIIIllIIlIllIllIIlI) {
                            continue;
                        }
                        this.field_194111_h.removeInt(lllllllllllIIIIIIllIIlIllIlIllIl - 1);
                    }
                    if (!this.field_194111_h.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        private int[] func_194097_a() {
            final IntCollection lllllllllllIIIIIIllIIlIlllIIIllI = (IntCollection)new IntAVLTreeSet();
            for (final Ingredient lllllllllllIIIIIIllIIlIlllIIIlIl : this.field_194106_c) {
                lllllllllllIIIIIIllIIlIlllIIIllI.addAll((IntCollection)lllllllllllIIIIIIllIIlIlllIIIlIl.func_194139_b());
            }
            final IntIterator lllllllllllIIIIIIllIIlIlllIIIlII = lllllllllllIIIIIIllIIlIlllIIIllI.iterator();
            while (lllllllllllIIIIIIllIIlIlllIIIlII.hasNext()) {
                if (!RecipeItemHelper.this.func_194120_a(lllllllllllIIIIIIllIIlIlllIIIlII.nextInt())) {
                    lllllllllllIIIIIIllIIlIlllIIIlII.remove();
                }
            }
            return lllllllllllIIIIIIllIIlIlllIIIllI.toIntArray();
        }
        
        private void func_194096_c(final int lllllllllllIIIIIIllIIlIllIIllIlI) {
            this.field_194110_g.set(this.func_194094_d(lllllllllllIIIIIIllIIlIllIIllIlI));
        }
        
        private boolean func_194101_b(final boolean lllllllllllIIIIIIllIIlIlIlIlIIIl, final int lllllllllllIIIIIIllIIlIlIlIIllIl) {
            return this.field_194110_g.get(this.func_194099_c(lllllllllllIIIIIIllIIlIlIlIlIIIl, lllllllllllIIIIIIllIIlIlIlIIllIl));
        }
        
        private void func_194089_c(final boolean lllllllllllIIIIIIllIIlIlIlllIIII, final int lllllllllllIIIIIIllIIlIlIllIllll, final int lllllllllllIIIIIIllIIlIlIlllIIlI) {
            this.field_194110_g.flip(1 + this.func_194095_d(lllllllllllIIIIIIllIIlIlIlllIIII, lllllllllllIIIIIIllIIlIlIllIllll, lllllllllllIIIIIIllIIlIlIlllIIlI));
        }
        
        private int func_194090_b() {
            int lllllllllllIIIIIIllIIlIlIIlIlIIl = Integer.MAX_VALUE;
            for (final Ingredient lllllllllllIIIIIIllIIlIlIIlIlIII : this.field_194106_c) {
                int lllllllllllIIIIIIllIIlIlIIlIIlll = 0;
                for (final int lllllllllllIIIIIIllIIlIlIIlIIllI : lllllllllllIIIIIIllIIlIlIIlIlIII.func_194139_b()) {
                    lllllllllllIIIIIIllIIlIlIIlIIlll = Math.max(lllllllllllIIIIIIllIIlIlIIlIIlll, RecipeItemHelper.this.field_194124_a.get(lllllllllllIIIIIIllIIlIlIIlIIllI));
                }
                if (lllllllllllIIIIIIllIIlIlIIlIlIIl > 0) {
                    lllllllllllIIIIIIllIIlIlIIlIlIIl = Math.min(lllllllllllIIIIIIllIIlIlIIlIlIIl, lllllllllllIIIIIIllIIlIlIIlIIlll);
                }
            }
            return lllllllllllIIIIIIllIIlIlIIlIlIIl;
        }
        
        private int func_194095_d(final boolean lllllllllllIIIIIIllIIlIlIllIIIlI, final int lllllllllllIIIIIIllIIlIlIllIIIIl, final int lllllllllllIIIIIIllIIlIlIllIIlIl) {
            final int lllllllllllIIIIIIllIIlIlIllIIlII = lllllllllllIIIIIIllIIlIlIllIIIlI ? (lllllllllllIIIIIIllIIlIlIllIIIIl * this.field_194107_d + lllllllllllIIIIIIllIIlIlIllIIlIl) : (lllllllllllIIIIIIllIIlIlIllIIlIl * this.field_194107_d + lllllllllllIIIIIIllIIlIlIllIIIIl);
            return this.field_194107_d + this.field_194109_f + this.field_194107_d + 2 * lllllllllllIIIIIIllIIlIlIllIIlII;
        }
        
        private int func_194099_c(final boolean lllllllllllIIIIIIllIIlIlIlIIIlIl, final int lllllllllllIIIIIIllIIlIlIlIIIlll) {
            return (lllllllllllIIIIIIllIIlIlIlIIIlIl ? 0 : this.field_194107_d) + lllllllllllIIIIIIllIIlIlIlIIIlll;
        }
        
        private boolean func_194100_b(final boolean lllllllllllIIIIIIllIIlIllIIIIIII, final int lllllllllllIIIIIIllIIlIlIlllllll, final int lllllllllllIIIIIIllIIlIlIllllIlI) {
            return lllllllllllIIIIIIllIIlIllIIIIIII ^ this.field_194110_g.get(1 + this.func_194095_d(lllllllllllIIIIIIllIIlIllIIIIIII, lllllllllllIIIIIIllIIlIlIlllllll, lllllllllllIIIIIIllIIlIlIllllIlI));
        }
        
        public boolean func_194092_a(final int lllllllllllIIIIIIllIIlIllllIIIII, @Nullable final IntList lllllllllllIIIIIIllIIlIlllIlIIll) {
            if (lllllllllllIIIIIIllIIlIllllIIIII <= 0) {
                return true;
            }
            int lllllllllllIIIIIIllIIlIlllIllllI = 0;
            while (this.func_194098_a(lllllllllllIIIIIIllIIlIllllIIIII)) {
                RecipeItemHelper.this.func_194122_a(this.field_194108_e[this.field_194111_h.getInt(0)], lllllllllllIIIIIIllIIlIllllIIIII);
                final int lllllllllllIIIIIIllIIlIlllIlllIl = this.field_194111_h.size() - 1;
                this.func_194096_c(this.field_194111_h.getInt(lllllllllllIIIIIIllIIlIlllIlllIl));
                for (int lllllllllllIIIIIIllIIlIlllIlllII = 0; lllllllllllIIIIIIllIIlIlllIlllII < lllllllllllIIIIIIllIIlIlllIlllIl; ++lllllllllllIIIIIIllIIlIlllIlllII) {
                    this.func_194089_c((lllllllllllIIIIIIllIIlIlllIlllII & 0x1) == 0x0, (int)this.field_194111_h.get(lllllllllllIIIIIIllIIlIlllIlllII), (int)this.field_194111_h.get(lllllllllllIIIIIIllIIlIlllIlllII + 1));
                }
                this.field_194111_h.clear();
                this.field_194110_g.clear(0, this.field_194107_d + this.field_194109_f);
                ++lllllllllllIIIIIIllIIlIlllIllllI;
            }
            final boolean lllllllllllIIIIIIllIIlIlllIllIll = lllllllllllIIIIIIllIIlIlllIllllI == this.field_194107_d;
            final boolean lllllllllllIIIIIIllIIlIlllIllIlI = lllllllllllIIIIIIllIIlIlllIllIll && lllllllllllIIIIIIllIIlIlllIlIIll != null;
            if (lllllllllllIIIIIIllIIlIlllIllIlI) {
                lllllllllllIIIIIIllIIlIlllIlIIll.clear();
            }
            this.field_194110_g.clear(0, this.field_194107_d + this.field_194109_f + this.field_194107_d);
            int lllllllllllIIIIIIllIIlIlllIllIIl = 0;
            final List<Ingredient> lllllllllllIIIIIIllIIlIlllIllIII = this.field_194105_b.func_192400_c();
            for (int lllllllllllIIIIIIllIIlIlllIlIlll = 0; lllllllllllIIIIIIllIIlIlllIlIlll < lllllllllllIIIIIIllIIlIlllIllIII.size(); ++lllllllllllIIIIIIllIIlIlllIlIlll) {
                if (lllllllllllIIIIIIllIIlIlllIllIlI && lllllllllllIIIIIIllIIlIlllIllIII.get(lllllllllllIIIIIIllIIlIlllIlIlll) == Ingredient.field_193370_a) {
                    lllllllllllIIIIIIllIIlIlllIlIIll.add(0);
                }
                else {
                    for (int lllllllllllIIIIIIllIIlIlllIlIllI = 0; lllllllllllIIIIIIllIIlIlllIlIllI < this.field_194109_f; ++lllllllllllIIIIIIllIIlIlllIlIllI) {
                        if (this.func_194100_b(false, lllllllllllIIIIIIllIIlIlllIllIIl, lllllllllllIIIIIIllIIlIlllIlIllI)) {
                            this.func_194089_c(true, lllllllllllIIIIIIllIIlIlllIlIllI, lllllllllllIIIIIIllIIlIlllIllIIl);
                            RecipeItemHelper.this.func_194117_b(this.field_194108_e[lllllllllllIIIIIIllIIlIlllIlIllI], lllllllllllIIIIIIllIIlIllllIIIII);
                            if (lllllllllllIIIIIIllIIlIlllIllIlI) {
                                lllllllllllIIIIIIllIIlIlllIlIIll.add(this.field_194108_e[lllllllllllIIIIIIllIIlIlllIlIllI]);
                            }
                        }
                    }
                    ++lllllllllllIIIIIIllIIlIlllIllIIl;
                }
            }
            return lllllllllllIIIIIIllIIlIlllIllIll;
        }
    }
}
