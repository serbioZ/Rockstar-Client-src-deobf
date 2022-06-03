// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.util;

import net.minecraft.client.resources.IResourceManager;
import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.item.ItemStack;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class SearchTreeManager implements IResourceManagerReloadListener
{
    private final /* synthetic */ Map<Key<?>, SearchTree<?>> field_194013_c;
    
    public SearchTreeManager() {
        this.field_194013_c = (Map<Key<?>, SearchTree<?>>)Maps.newHashMap();
    }
    
    public <T> void func_194009_a(final Key<T> lllllllllllIlIIIlllIIlIlIlIlIIIl, final SearchTree<T> lllllllllllIlIIIlllIIlIlIlIlIIII) {
        this.field_194013_c.put(lllllllllllIlIIIlllIIlIlIlIlIIIl, lllllllllllIlIIIlllIIlIlIlIlIIII);
    }
    
    public <T> ISearchTree<T> func_194010_a(final Key<T> lllllllllllIlIIIlllIIlIlIlIIlIlI) {
        return (ISearchTree<T>)this.field_194013_c.get(lllllllllllIlIIIlllIIlIlIlIIlIlI);
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllIlIIIlllIIlIlIlIlllIl) {
        for (final SearchTree<?> lllllllllllIlIIIlllIIlIlIlIlllII : this.field_194013_c.values()) {
            lllllllllllIlIIIlllIIlIlIlIlllII.func_194040_a();
        }
    }
    
    static {
        field_194011_a = new Key<ItemStack>();
        field_194012_b = new Key<RecipeList>();
    }
    
    public static class Key<T>
    {
    }
}
