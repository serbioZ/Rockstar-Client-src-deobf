// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityPotion;

public class RenderPotion extends RenderSnowball<EntityPotion>
{
    @Override
    public ItemStack getStackToRender(final EntityPotion lllllllllllIlllIlIIlllIIllIllIlI) {
        return lllllllllllIlllIlIIlllIIllIllIlI.getPotion();
    }
    
    public RenderPotion(final RenderManager lllllllllllIlllIlIIlllIIllIlllll, final RenderItem lllllllllllIlllIlIIlllIIllIllllI) {
        super(lllllllllllIlllIlIIlllIIllIlllll, Items.POTIONITEM, lllllllllllIlllIlIIlllIIllIllllI);
    }
}
