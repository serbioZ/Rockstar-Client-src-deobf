// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.ModelZombieVillager;
import net.minecraft.client.renderer.entity.RenderLivingBase;

public class LayerVillagerArmor extends LayerBipedArmor
{
    public LayerVillagerArmor(final RenderLivingBase<?> lllllllllllllIIllllIlIllIIIIlIII) {
        super(lllllllllllllIIllllIlIllIIIIlIII);
    }
    
    @Override
    protected void initArmor() {
        this.modelLeggings = (T)new ModelZombieVillager(0.5f, 0.0f, true);
        this.modelArmor = (T)new ModelZombieVillager(1.0f, 0.0f, true);
    }
}
