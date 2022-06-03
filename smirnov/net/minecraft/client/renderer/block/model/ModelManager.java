// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.util.registry.IRegistry;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class ModelManager implements IResourceManagerReloadListener
{
    private /* synthetic */ IBakedModel defaultModel;
    private final /* synthetic */ TextureMap texMap;
    private /* synthetic */ IRegistry<ModelResourceLocation, IBakedModel> modelRegistry;
    private final /* synthetic */ BlockModelShapes modelProvider;
    
    public IBakedModel getModel(final ModelResourceLocation llllllllllllllllIlllIIIIllIIIIlI) {
        if (llllllllllllllllIlllIIIIllIIIIlI == null) {
            return this.defaultModel;
        }
        final IBakedModel llllllllllllllllIlllIIIIllIIIlII = this.modelRegistry.getObject(llllllllllllllllIlllIIIIllIIIIlI);
        return (llllllllllllllllIlllIIIIllIIIlII == null) ? this.defaultModel : llllllllllllllllIlllIIIIllIIIlII;
    }
    
    public TextureMap getTextureMap() {
        return this.texMap;
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllllllIlllIIIIllIIlllI) {
        final ModelBakery llllllllllllllllIlllIIIIllIIllIl = new ModelBakery(llllllllllllllllIlllIIIIllIIlllI, this.texMap, this.modelProvider);
        this.modelRegistry = llllllllllllllllIlllIIIIllIIllIl.setupModelRegistry();
        this.defaultModel = this.modelRegistry.getObject(ModelBakery.MODEL_MISSING);
        this.modelProvider.reloadModels();
    }
    
    public ModelManager(final TextureMap llllllllllllllllIlllIIIIllIlIIll) {
        this.texMap = llllllllllllllllIlllIIIIllIlIIll;
        this.modelProvider = new BlockModelShapes(this);
    }
    
    public BlockModelShapes getBlockModelShapes() {
        return this.modelProvider;
    }
    
    public IBakedModel getMissingModel() {
        return this.defaultModel;
    }
}
