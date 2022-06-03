// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.util;

import com.google.common.collect.Table;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.CraftingManager;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import net.minecraft.creativetab.CreativeTabs;
import java.util.Map;
import net.minecraft.client.gui.recipebook.RecipeList;
import java.util.List;
import net.minecraft.stats.RecipeBook;

public class RecipeBookClient extends RecipeBook
{
    public static final /* synthetic */ List<RecipeList> field_194087_f;
    public static final /* synthetic */ Map<CreativeTabs, List<RecipeList>> field_194086_e;
    
    private static RecipeList func_194082_a(final CreativeTabs lllllllllllIIllIIlIlIIlIIIIIIIll) {
        final RecipeList lllllllllllIIllIIlIlIIlIIIIIIlII = new RecipeList();
        RecipeBookClient.field_194087_f.add(lllllllllllIIllIIlIlIIlIIIIIIlII);
        RecipeBookClient.field_194086_e.computeIfAbsent(lllllllllllIIllIIlIlIIlIIIIIIIll, lllllllllllIIllIIlIlIIIllllllIll -> new ArrayList()).add(lllllllllllIIllIIlIlIIlIIIIIIlII);
        RecipeBookClient.field_194086_e.computeIfAbsent(CreativeTabs.SEARCH, lllllllllllIIllIIlIlIIIllllllIlI -> new ArrayList()).add(lllllllllllIIllIIlIlIIlIIIIIIlII);
        return lllllllllllIIllIIlIlIIlIIIIIIlII;
    }
    
    private static CreativeTabs func_194084_a(final ItemStack lllllllllllIIllIIlIlIIIlllllllll) {
        final CreativeTabs lllllllllllIIllIIlIlIIIllllllllI = lllllllllllIIllIIlIlIIIlllllllll.getItem().getCreativeTab();
        if (lllllllllllIIllIIlIlIIIllllllllI != CreativeTabs.BUILDING_BLOCKS && lllllllllllIIllIIlIlIIIllllllllI != CreativeTabs.TOOLS && lllllllllllIIllIIlIlIIIllllllllI != CreativeTabs.REDSTONE) {
            return (lllllllllllIIllIIlIlIIIllllllllI == CreativeTabs.COMBAT) ? CreativeTabs.TOOLS : CreativeTabs.MISC;
        }
        return lllllllllllIIllIIlIlIIIllllllllI;
    }
    
    static {
        field_194086_e = Maps.newHashMap();
        field_194087_f = Lists.newArrayList();
        final Table<CreativeTabs, String, RecipeList> lllllllllllIIllIIlIlIIlIIIIlIllI = (Table<CreativeTabs, String, RecipeList>)HashBasedTable.create();
        for (final IRecipe lllllllllllIIllIIlIlIIlIIIIlIlIl : CraftingManager.field_193380_a) {
            if (!lllllllllllIIllIIlIlIIlIIIIlIlIl.func_192399_d()) {
                final CreativeTabs lllllllllllIIllIIlIlIIlIIIIlIlII = func_194084_a(lllllllllllIIllIIlIlIIlIIIIlIlIl.getRecipeOutput());
                final String lllllllllllIIllIIlIlIIlIIIIlIIll = lllllllllllIIllIIlIlIIlIIIIlIlIl.func_193358_e();
                RecipeList lllllllllllIIllIIlIlIIlIIIIlIIIl = null;
                if (lllllllllllIIllIIlIlIIlIIIIlIIll.isEmpty()) {
                    final RecipeList lllllllllllIIllIIlIlIIlIIIIlIIlI = func_194082_a(lllllllllllIIllIIlIlIIlIIIIlIlII);
                }
                else {
                    lllllllllllIIllIIlIlIIlIIIIlIIIl = (RecipeList)lllllllllllIIllIIlIlIIlIIIIlIllI.get((Object)lllllllllllIIllIIlIlIIlIIIIlIlII, (Object)lllllllllllIIllIIlIlIIlIIIIlIIll);
                    if (lllllllllllIIllIIlIlIIlIIIIlIIIl == null) {
                        lllllllllllIIllIIlIlIIlIIIIlIIIl = func_194082_a(lllllllllllIIllIIlIlIIlIIIIlIlII);
                        lllllllllllIIllIIlIlIIlIIIIlIllI.put((Object)lllllllllllIIllIIlIlIIlIIIIlIlII, (Object)lllllllllllIIllIIlIlIIlIIIIlIIll, (Object)lllllllllllIIllIIlIlIIlIIIIlIIIl);
                    }
                }
                lllllllllllIIllIIlIlIIlIIIIlIIIl.func_192709_a(lllllllllllIIllIIlIlIIlIIIIlIlIl);
            }
        }
    }
}
