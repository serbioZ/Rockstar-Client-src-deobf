// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelParrot;
import net.minecraft.client.renderer.entity.RenderParrot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.NBTTagCompound;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import java.util.UUID;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;

public class LayerEntityOnShoulder implements LayerRenderer<EntityPlayer>
{
    private /* synthetic */ ModelBase field_192868_d;
    protected /* synthetic */ RenderLivingBase<? extends EntityLivingBase> field_192866_b;
    private /* synthetic */ ModelBase field_192872_h;
    private /* synthetic */ Class<?> field_192871_g;
    private /* synthetic */ UUID field_192870_f;
    protected /* synthetic */ RenderLivingBase<? extends EntityLivingBase> field_192865_a;
    private /* synthetic */ ResourceLocation field_192869_e;
    private final /* synthetic */ RenderManager field_192867_c;
    private /* synthetic */ ResourceLocation field_192873_i;
    private /* synthetic */ UUID field_192874_j;
    private /* synthetic */ Class<?> field_192875_k;
    
    private DataHolder func_192864_a(final EntityPlayer llllllllllllIIIlIlIllIIlIlIIIIII, @Nullable UUID llllllllllllIIIlIlIllIIlIIlIllIl, final NBTTagCompound llllllllllllIIIlIlIllIIlIIlIllII, RenderLivingBase<? extends EntityLivingBase> llllllllllllIIIlIlIllIIlIIlIlIll, ModelBase llllllllllllIIIlIlIllIIlIIlIlIlI, ResourceLocation llllllllllllIIIlIlIllIIlIIlIlIIl, Class<?> llllllllllllIIIlIlIllIIlIIlllIlI, final float llllllllllllIIIlIlIllIIlIIlIIlll, final float llllllllllllIIIlIlIllIIlIIlIIllI, final float llllllllllllIIIlIlIllIIlIIlIIlIl, float llllllllllllIIIlIlIllIIlIIlIIlII, final float llllllllllllIIIlIlIllIIlIIlIIIll, final float llllllllllllIIIlIlIllIIlIIlIIIlI, final float llllllllllllIIIlIlIllIIlIIlIIIIl, final boolean llllllllllllIIIlIlIllIIlIIllIIlI) {
        if (llllllllllllIIIlIlIllIIlIIlIllIl == null || !llllllllllllIIIlIlIllIIlIIlIllIl.equals(llllllllllllIIIlIlIllIIlIIlIllII.getUniqueId("UUID"))) {
            llllllllllllIIIlIlIllIIlIIlIllIl = llllllllllllIIIlIlIllIIlIIlIllII.getUniqueId("UUID");
            llllllllllllIIIlIlIllIIlIIlllIlI = EntityList.func_192839_a(llllllllllllIIIlIlIllIIlIIlIllII.getString("id"));
            if (llllllllllllIIIlIlIllIIlIIlllIlI == EntityParrot.class) {
                llllllllllllIIIlIlIllIIlIIlIlIll = new RenderParrot(this.field_192867_c);
                llllllllllllIIIlIlIllIIlIIlIlIlI = new ModelParrot();
                llllllllllllIIIlIlIllIIlIIlIlIIl = RenderParrot.field_192862_a[llllllllllllIIIlIlIllIIlIIlIllII.getInteger("Variant")];
            }
        }
        llllllllllllIIIlIlIllIIlIIlIlIll.bindTexture(llllllllllllIIIlIlIllIIlIIlIlIIl);
        GlStateManager.pushMatrix();
        final float llllllllllllIIIlIlIllIIlIIllIIIl = llllllllllllIIIlIlIllIIlIlIIIIII.isSneaking() ? -1.3f : -1.5f;
        final float llllllllllllIIIlIlIllIIlIIllIIII = llllllllllllIIIlIlIllIIlIIllIIlI ? 0.4f : -0.4f;
        GlStateManager.translate(llllllllllllIIIlIlIllIIlIIllIIII, llllllllllllIIIlIlIllIIlIIllIIIl, 0.0f);
        if (llllllllllllIIIlIlIllIIlIIlllIlI == EntityParrot.class) {
            llllllllllllIIIlIlIllIIlIIlIIlII = 0.0f;
        }
        ((ModelBase)llllllllllllIIIlIlIllIIlIIlIlIlI).setLivingAnimations(llllllllllllIIIlIlIllIIlIlIIIIII, llllllllllllIIIlIlIllIIlIIlIIlll, llllllllllllIIIlIlIllIIlIIlIIllI, llllllllllllIIIlIlIllIIlIIlIIlIl);
        ((ModelBase)llllllllllllIIIlIlIllIIlIIlIlIlI).setRotationAngles(llllllllllllIIIlIlIllIIlIIlIIlll, llllllllllllIIIlIlIllIIlIIlIIllI, llllllllllllIIIlIlIllIIlIIlIIlII, llllllllllllIIIlIlIllIIlIIlIIIll, llllllllllllIIIlIlIllIIlIIlIIIlI, llllllllllllIIIlIlIllIIlIIlIIIIl, llllllllllllIIIlIlIllIIlIlIIIIII);
        ((ModelBase)llllllllllllIIIlIlIllIIlIIlIlIlI).render(llllllllllllIIIlIlIllIIlIlIIIIII, llllllllllllIIIlIlIllIIlIIlIIlll, llllllllllllIIIlIlIllIIlIIlIIllI, llllllllllllIIIlIlIllIIlIIlIIlII, llllllllllllIIIlIlIllIIlIIlIIIll, llllllllllllIIIlIlIllIIlIIlIIIlI, llllllllllllIIIlIlIllIIlIIlIIIIl);
        GlStateManager.popMatrix();
        return new DataHolder(llllllllllllIIIlIlIllIIlIIlIllIl, llllllllllllIIIlIlIllIIlIIlIlIll, (ModelBase)llllllllllllIIIlIlIllIIlIIlIlIlI, llllllllllllIIIlIlIllIIlIIlIlIIl, llllllllllllIIIlIlIllIIlIIlllIlI);
    }
    
    @Override
    public void doRenderLayer(final EntityPlayer llllllllllllIIIlIlIllIIlIllIlIll, final float llllllllllllIIIlIlIllIIlIlIlllIl, final float llllllllllllIIIlIlIllIIlIlIlllII, final float llllllllllllIIIlIlIllIIlIlIllIll, final float llllllllllllIIIlIlIllIIlIlIllIlI, final float llllllllllllIIIlIlIllIIlIlIllIIl, final float llllllllllllIIIlIlIllIIlIlIllIII, final float llllllllllllIIIlIlIllIIlIlIlIlll) {
        if (llllllllllllIIIlIlIllIIlIllIlIll.func_192023_dk() != null || llllllllllllIIIlIlIllIIlIllIlIll.func_192025_dl() != null) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final NBTTagCompound llllllllllllIIIlIlIllIIlIllIIIll = llllllllllllIIIlIlIllIIlIllIlIll.func_192023_dk();
            if (!llllllllllllIIIlIlIllIIlIllIIIll.hasNoTags()) {
                final DataHolder llllllllllllIIIlIlIllIIlIllIIIlI = this.func_192864_a(llllllllllllIIIlIlIllIIlIllIlIll, this.field_192870_f, llllllllllllIIIlIlIllIIlIllIIIll, this.field_192865_a, this.field_192868_d, this.field_192869_e, this.field_192871_g, llllllllllllIIIlIlIllIIlIlIlllIl, llllllllllllIIIlIlIllIIlIlIlllII, llllllllllllIIIlIlIllIIlIlIllIll, llllllllllllIIIlIlIllIIlIlIllIlI, llllllllllllIIIlIlIllIIlIlIllIIl, llllllllllllIIIlIlIllIIlIlIllIII, llllllllllllIIIlIlIllIIlIlIlIlll, true);
                this.field_192870_f = llllllllllllIIIlIlIllIIlIllIIIlI.field_192882_a;
                this.field_192865_a = llllllllllllIIIlIlIllIIlIllIIIlI.field_192883_b;
                this.field_192869_e = llllllllllllIIIlIlIllIIlIllIIIlI.field_192885_d;
                this.field_192868_d = llllllllllllIIIlIlIllIIlIllIIIlI.field_192884_c;
                this.field_192871_g = llllllllllllIIIlIlIllIIlIllIIIlI.field_192886_e;
            }
            final NBTTagCompound llllllllllllIIIlIlIllIIlIllIIIIl = llllllllllllIIIlIlIllIIlIllIlIll.func_192025_dl();
            if (!llllllllllllIIIlIlIllIIlIllIIIIl.hasNoTags()) {
                final DataHolder llllllllllllIIIlIlIllIIlIllIIIII = this.func_192864_a(llllllllllllIIIlIlIllIIlIllIlIll, this.field_192874_j, llllllllllllIIIlIlIllIIlIllIIIIl, this.field_192866_b, this.field_192872_h, this.field_192873_i, this.field_192875_k, llllllllllllIIIlIlIllIIlIlIlllIl, llllllllllllIIIlIlIllIIlIlIlllII, llllllllllllIIIlIlIllIIlIlIllIll, llllllllllllIIIlIlIllIIlIlIllIlI, llllllllllllIIIlIlIllIIlIlIllIIl, llllllllllllIIIlIlIllIIlIlIllIII, llllllllllllIIIlIlIllIIlIlIlIlll, false);
                this.field_192874_j = llllllllllllIIIlIlIllIIlIllIIIII.field_192882_a;
                this.field_192866_b = llllllllllllIIIlIlIllIIlIllIIIII.field_192883_b;
                this.field_192873_i = llllllllllllIIIlIlIllIIlIllIIIII.field_192885_d;
                this.field_192872_h = llllllllllllIIIlIlIllIIlIllIIIII.field_192884_c;
                this.field_192875_k = llllllllllllIIIlIlIllIIlIllIIIII.field_192886_e;
            }
            GlStateManager.disableRescaleNormal();
        }
    }
    
    public LayerEntityOnShoulder(final RenderManager llllllllllllIIIlIlIllIIlIllllIIl) {
        this.field_192867_c = llllllllllllIIIlIlIllIIlIllllIIl;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    class DataHolder
    {
        public /* synthetic */ RenderLivingBase<? extends EntityLivingBase> field_192883_b;
        public /* synthetic */ Class<?> field_192886_e;
        public /* synthetic */ UUID field_192882_a;
        public /* synthetic */ ModelBase field_192884_c;
        public /* synthetic */ ResourceLocation field_192885_d;
        
        public DataHolder(final UUID llllIIllIlIlIll, final RenderLivingBase<? extends EntityLivingBase> llllIIllIlIlIlI, final ModelBase llllIIllIlIIIlI, final ResourceLocation llllIIllIlIlIII, final Class<?> llllIIllIlIIIII) {
            this.field_192882_a = llllIIllIlIlIll;
            this.field_192883_b = llllIIllIlIlIlI;
            this.field_192884_c = llllIIllIlIIIlI;
            this.field_192885_d = llllIIllIlIlIII;
            this.field_192886_e = llllIIllIlIIIII;
        }
    }
}
