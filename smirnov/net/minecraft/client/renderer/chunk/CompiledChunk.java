// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Lists;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.tileentity.TileEntity;
import java.util.List;
import net.minecraft.client.renderer.BufferBuilder;

public class CompiledChunk
{
    private final /* synthetic */ boolean[] layersStarted;
    private /* synthetic */ SetVisibility setVisibility;
    private final /* synthetic */ boolean[] layersUsed;
    private /* synthetic */ boolean empty;
    private /* synthetic */ BufferBuilder.State state;
    private final /* synthetic */ List<TileEntity> tileEntities;
    
    public boolean isLayerStarted(final BlockRenderLayer lllllllllllIIlIIlIIIIlIllIlIllll) {
        return this.layersStarted[lllllllllllIIlIIlIIIIlIllIlIllll.ordinal()];
    }
    
    public void setVisibility(final SetVisibility lllllllllllIIlIIlIIIIlIllIIllIIl) {
        this.setVisibility = lllllllllllIIlIIlIIIIlIllIIllIIl;
    }
    
    static {
        DUMMY = new CompiledChunk() {
            @Override
            public void setLayerStarted(final BlockRenderLayer lllllllllllIlIIlIllIllllIlIIlIII) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            protected void setLayerUsed(final BlockRenderLayer lllllllllllIlIIlIllIllllIlIIlIlI) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean isVisible(final EnumFacing lllllllllllIlIIlIllIllllIlIIIllI, final EnumFacing lllllllllllIlIIlIllIllllIlIIIlIl) {
                return false;
            }
        };
    }
    
    public boolean isEmpty() {
        return this.empty;
    }
    
    protected void setLayerUsed(final BlockRenderLayer lllllllllllIIlIIlIIIIlIlllIIIIll) {
        this.empty = false;
        this.layersUsed[lllllllllllIIlIIlIIIIlIlllIIIIll.ordinal()] = true;
    }
    
    public BufferBuilder.State getState() {
        return this.state;
    }
    
    public void setLayerStarted(final BlockRenderLayer lllllllllllIIlIIlIIIIlIllIllIlIl) {
        this.layersStarted[lllllllllllIIlIIlIIIIlIllIllIlIl.ordinal()] = true;
    }
    
    public void setState(final BufferBuilder.State lllllllllllIIlIIlIIIIlIllIIlIIII) {
        this.state = lllllllllllIIlIIlIIIIlIllIIlIIII;
    }
    
    public boolean isVisible(final EnumFacing lllllllllllIIlIIlIIIIlIllIlIIIIl, final EnumFacing lllllllllllIIlIIlIIIIlIllIlIIIII) {
        return this.setVisibility.isVisible(lllllllllllIIlIIlIIIIlIllIlIIIIl, lllllllllllIIlIIlIIIIlIllIlIIIII);
    }
    
    public void addTileEntity(final TileEntity lllllllllllIIlIIlIIIIlIllIlIIllI) {
        this.tileEntities.add(lllllllllllIIlIIlIIIIlIllIlIIllI);
    }
    
    public CompiledChunk() {
        this.layersUsed = new boolean[BlockRenderLayer.values().length];
        this.layersStarted = new boolean[BlockRenderLayer.values().length];
        this.empty = true;
        this.tileEntities = (List<TileEntity>)Lists.newArrayList();
        this.setVisibility = new SetVisibility();
    }
    
    public List<TileEntity> getTileEntities() {
        return this.tileEntities;
    }
    
    public boolean isLayerEmpty(final BlockRenderLayer lllllllllllIIlIIlIIIIlIllIllllIl) {
        return !this.layersUsed[lllllllllllIIlIIlIIIIlIllIllllIl.ordinal()];
    }
}
