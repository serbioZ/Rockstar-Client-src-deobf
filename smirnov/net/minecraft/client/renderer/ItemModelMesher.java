// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import javax.annotation.Nullable;
import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import java.util.Map;

public class ItemModelMesher
{
    private final /* synthetic */ Map<Integer, ModelResourceLocation> simpleShapes;
    private final /* synthetic */ Map<Item, ItemMeshDefinition> shapers;
    private final /* synthetic */ ModelManager modelManager;
    private final /* synthetic */ Map<Integer, IBakedModel> simpleShapesCache;
    
    public TextureAtlasSprite getParticleIcon(final Item lllllllllllIIlIIIIllIlIllllllIII, final int lllllllllllIIlIIIIllIlIlllllIlll) {
        return this.getItemModel(new ItemStack(lllllllllllIIlIIIIllIlIllllllIII, 1, lllllllllllIIlIIIIllIlIlllllIlll)).getParticleTexture();
    }
    
    protected int getMetadata(final ItemStack lllllllllllIIlIIIIllIlIllllIIIIl) {
        return (lllllllllllIIlIIIIllIlIllllIIIIl.getMaxDamage() > 0) ? 0 : lllllllllllIIlIIIIllIlIllllIIIIl.getMetadata();
    }
    
    public void register(final Item lllllllllllIIlIIIIllIlIllIllllIl, final ItemMeshDefinition lllllllllllIIlIIIIllIlIllIllllII) {
        this.shapers.put(lllllllllllIIlIIIIllIlIllIllllIl, lllllllllllIIlIIIIllIlIllIllllII);
    }
    
    public ItemModelMesher(final ModelManager lllllllllllIIlIIIIllIllIIIIIIIll) {
        this.simpleShapes = (Map<Integer, ModelResourceLocation>)Maps.newHashMap();
        this.simpleShapesCache = (Map<Integer, IBakedModel>)Maps.newHashMap();
        this.shapers = (Map<Item, ItemMeshDefinition>)Maps.newHashMap();
        this.modelManager = lllllllllllIIlIIIIllIllIIIIIIIll;
    }
    
    private int getIndex(final Item lllllllllllIIlIIIIllIlIlllIlIIlI, final int lllllllllllIIlIIIIllIlIlllIlIIIl) {
        return Item.getIdFromItem(lllllllllllIIlIIIIllIlIlllIlIIlI) << 16 | lllllllllllIIlIIIIllIlIlllIlIIIl;
    }
    
    public ModelManager getModelManager() {
        return this.modelManager;
    }
    
    public void rebuildCache() {
        this.simpleShapesCache.clear();
        for (final Map.Entry<Integer, ModelResourceLocation> lllllllllllIIlIIIIllIlIllIllIlII : this.simpleShapes.entrySet()) {
            this.simpleShapesCache.put(lllllllllllIIlIIIIllIlIllIllIlII.getKey(), this.modelManager.getModel(lllllllllllIIlIIIIllIlIllIllIlII.getValue()));
        }
    }
    
    public void register(final Item lllllllllllIIlIIIIllIlIlllIIlIll, final int lllllllllllIIlIIIIllIlIlllIIIllI, final ModelResourceLocation lllllllllllIIlIIIIllIlIlllIIIlIl) {
        this.simpleShapes.put(this.getIndex(lllllllllllIIlIIIIllIlIlllIIlIll, lllllllllllIIlIIIIllIlIlllIIIllI), lllllllllllIIlIIIIllIlIlllIIIlIl);
        this.simpleShapesCache.put(this.getIndex(lllllllllllIIlIIIIllIlIlllIIlIll, lllllllllllIIlIIIIllIlIlllIIIllI), this.modelManager.getModel(lllllllllllIIlIIIIllIlIlllIIIlIl));
    }
    
    @Nullable
    protected IBakedModel getItemModel(final Item lllllllllllIIlIIIIllIlIlllIllIIl, final int lllllllllllIIlIIIIllIlIlllIllIll) {
        return this.simpleShapesCache.get(this.getIndex(lllllllllllIIlIIIIllIlIlllIllIIl, lllllllllllIIlIIIIllIlIlllIllIll));
    }
    
    public TextureAtlasSprite getParticleIcon(final Item lllllllllllIIlIIIIllIlIlllllllll) {
        return this.getParticleIcon(lllllllllllIIlIIIIllIlIlllllllll, 0);
    }
    
    public IBakedModel getItemModel(final ItemStack lllllllllllIIlIIIIllIlIllllIlIII) {
        final Item lllllllllllIIlIIIIllIlIllllIllII = lllllllllllIIlIIIIllIlIllllIlIII.getItem();
        IBakedModel lllllllllllIIlIIIIllIlIllllIlIll = this.getItemModel(lllllllllllIIlIIIIllIlIllllIllII, this.getMetadata(lllllllllllIIlIIIIllIlIllllIlIII));
        if (lllllllllllIIlIIIIllIlIllllIlIll == null) {
            final ItemMeshDefinition lllllllllllIIlIIIIllIlIllllIlIlI = this.shapers.get(lllllllllllIIlIIIIllIlIllllIllII);
            if (lllllllllllIIlIIIIllIlIllllIlIlI != null) {
                lllllllllllIIlIIIIllIlIllllIlIll = this.modelManager.getModel(lllllllllllIIlIIIIllIlIllllIlIlI.getModelLocation(lllllllllllIIlIIIIllIlIllllIlIII));
            }
        }
        if (lllllllllllIIlIIIIllIlIllllIlIll == null) {
            lllllllllllIIlIIIIllIlIllllIlIll = this.modelManager.getMissingModel();
        }
        return lllllllllllIIlIIIIllIlIllllIlIll;
    }
}
