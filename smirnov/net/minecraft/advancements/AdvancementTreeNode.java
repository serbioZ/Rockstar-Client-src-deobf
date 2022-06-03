// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import java.util.List;

public class AdvancementTreeNode
{
    private /* synthetic */ AdvancementTreeNode field_192333_f;
    private /* synthetic */ float field_192339_l;
    private /* synthetic */ AdvancementTreeNode field_192334_g;
    private final /* synthetic */ AdvancementTreeNode field_192329_b;
    private final /* synthetic */ List<AdvancementTreeNode> field_192332_e;
    private final /* synthetic */ AdvancementTreeNode field_192330_c;
    private /* synthetic */ float field_192338_k;
    private /* synthetic */ float field_192337_j;
    private /* synthetic */ int field_192335_h;
    private final /* synthetic */ Advancement field_192328_a;
    private /* synthetic */ float field_192336_i;
    private final /* synthetic */ int field_192331_d;
    
    @Nullable
    private AdvancementTreeNode func_192322_a(final Advancement llllllllllllIlIllllIlIllIIlIIIII, @Nullable AdvancementTreeNode llllllllllllIlIllllIlIllIIIlllll) {
        if (llllllllllllIlIllllIlIllIIlIIIII.func_192068_c() != null) {
            llllllllllllIlIllllIlIllIIIlllll = new AdvancementTreeNode(llllllllllllIlIllllIlIllIIlIIIII, this, (AdvancementTreeNode)llllllllllllIlIllllIlIllIIIlllll, this.field_192332_e.size() + 1, this.field_192335_h + 1);
            this.field_192332_e.add((AdvancementTreeNode)llllllllllllIlIllllIlIllIIIlllll);
        }
        else {
            for (final Advancement llllllllllllIlIllllIlIllIIlIIIlI : llllllllllllIlIllllIlIllIIlIIIII.func_192069_e()) {
                llllllllllllIlIllllIlIllIIIlllll = this.func_192322_a(llllllllllllIlIllllIlIllIIlIIIlI, (AdvancementTreeNode)llllllllllllIlIllllIlIllIIIlllll);
            }
        }
        return (AdvancementTreeNode)llllllllllllIlIllllIlIllIIIlllll;
    }
    
    private void func_192320_a() {
        if (this.field_192332_e.isEmpty()) {
            if (this.field_192330_c != null) {
                this.field_192336_i = this.field_192330_c.field_192336_i + 1.0f;
            }
            else {
                this.field_192336_i = 0.0f;
            }
        }
        else {
            AdvancementTreeNode llllllllllllIlIllllIlIllIIIlIlll = null;
            for (final AdvancementTreeNode llllllllllllIlIllllIlIllIIIlIllI : this.field_192332_e) {
                llllllllllllIlIllllIlIllIIIlIllI.func_192320_a();
                llllllllllllIlIllllIlIllIIIlIlll = llllllllllllIlIllllIlIllIIIlIllI.func_192324_a((llllllllllllIlIllllIlIllIIIlIlll == null) ? llllllllllllIlIllllIlIllIIIlIllI : llllllllllllIlIllllIlIllIIIlIlll);
            }
            this.func_192325_b();
            final float llllllllllllIlIllllIlIllIIIlIlIl = (this.field_192332_e.get(0).field_192336_i + this.field_192332_e.get(this.field_192332_e.size() - 1).field_192336_i) / 2.0f;
            if (this.field_192330_c != null) {
                this.field_192336_i = this.field_192330_c.field_192336_i + 1.0f;
                this.field_192337_j = this.field_192336_i - llllllllllllIlIllllIlIllIIIlIlIl;
            }
            else {
                this.field_192336_i = llllllllllllIlIllllIlIllIIIlIlIl;
            }
        }
    }
    
    private void func_192325_b() {
        float llllllllllllIlIllllIlIlIlllIlllI = 0.0f;
        float llllllllllllIlIllllIlIlIlllIllIl = 0.0f;
        for (int llllllllllllIlIllllIlIlIlllIllII = this.field_192332_e.size() - 1; llllllllllllIlIllllIlIlIlllIllII >= 0; --llllllllllllIlIllllIlIlIlllIllII) {
            final AdvancementTreeNode advancementTreeNode;
            final AdvancementTreeNode llllllllllllIlIllllIlIlIlllIlIll = advancementTreeNode = this.field_192332_e.get(llllllllllllIlIllllIlIlIlllIllII);
            advancementTreeNode.field_192336_i += llllllllllllIlIllllIlIlIlllIlllI;
            final AdvancementTreeNode advancementTreeNode2 = llllllllllllIlIllllIlIlIlllIlIll;
            advancementTreeNode2.field_192337_j += llllllllllllIlIllllIlIlIlllIlllI;
            llllllllllllIlIllllIlIlIlllIllIl += llllllllllllIlIllllIlIlIlllIlIll.field_192338_k;
            llllllllllllIlIllllIlIlIlllIlllI += llllllllllllIlIllllIlIlIlllIlIll.field_192339_l + llllllllllllIlIllllIlIlIlllIllIl;
        }
    }
    
    public AdvancementTreeNode(final Advancement llllllllllllIlIllllIlIllIIllIIlI, @Nullable final AdvancementTreeNode llllllllllllIlIllllIlIllIIllIIIl, @Nullable final AdvancementTreeNode llllllllllllIlIllllIlIllIIlllIII, final int llllllllllllIlIllllIlIllIIlIllll, final int llllllllllllIlIllllIlIllIIllIllI) {
        this.field_192332_e = (List<AdvancementTreeNode>)Lists.newArrayList();
        if (llllllllllllIlIllllIlIllIIllIIlI.func_192068_c() == null) {
            throw new IllegalArgumentException("Can't position an invisible advancement!");
        }
        this.field_192328_a = llllllllllllIlIllllIlIllIIllIIlI;
        this.field_192329_b = llllllllllllIlIllllIlIllIIllIIIl;
        this.field_192330_c = llllllllllllIlIllllIlIllIIlllIII;
        this.field_192331_d = llllllllllllIlIllllIlIllIIlIllll;
        this.field_192333_f = this;
        this.field_192335_h = llllllllllllIlIllllIlIllIIllIllI;
        this.field_192336_i = -1.0f;
        AdvancementTreeNode llllllllllllIlIllllIlIllIIllIlIl = null;
        for (final Advancement llllllllllllIlIllllIlIllIIllIlII : llllllllllllIlIllllIlIllIIllIIlI.func_192069_e()) {
            llllllllllllIlIllllIlIllIIllIlIl = this.func_192322_a(llllllllllllIlIllllIlIllIIllIlII, llllllllllllIlIllllIlIllIIllIlIl);
        }
    }
    
    @Nullable
    private AdvancementTreeNode func_192317_d() {
        if (this.field_192334_g != null) {
            return this.field_192334_g;
        }
        return this.field_192332_e.isEmpty() ? null : this.field_192332_e.get(this.field_192332_e.size() - 1);
    }
    
    private AdvancementTreeNode func_192326_a(final AdvancementTreeNode llllllllllllIlIllllIlIlIlIlIlllI, final AdvancementTreeNode llllllllllllIlIllllIlIlIlIlIllIl) {
        return (this.field_192333_f != null && llllllllllllIlIllllIlIlIlIlIlllI.field_192329_b.field_192332_e.contains(this.field_192333_f)) ? this.field_192333_f : llllllllllllIlIllllIlIlIlIlIllIl;
    }
    
    private float func_192319_a(final float llllllllllllIlIllllIlIllIIIIlIIl, final int llllllllllllIlIllllIlIllIIIIlIII, float llllllllllllIlIllllIlIllIIIIIIlI) {
        this.field_192336_i += llllllllllllIlIllllIlIllIIIIlIIl;
        this.field_192335_h = llllllllllllIlIllllIlIllIIIIlIII;
        if (this.field_192336_i < llllllllllllIlIllllIlIllIIIIIIlI) {
            llllllllllllIlIllllIlIllIIIIIIlI = this.field_192336_i;
        }
        for (final AdvancementTreeNode llllllllllllIlIllllIlIllIIIIIllI : this.field_192332_e) {
            llllllllllllIlIllllIlIllIIIIIIlI = llllllllllllIlIllllIlIllIIIIIllI.func_192319_a(llllllllllllIlIllllIlIllIIIIlIIl + this.field_192337_j, llllllllllllIlIllllIlIllIIIIlIII + 1, llllllllllllIlIllllIlIllIIIIIIlI);
        }
        return llllllllllllIlIllllIlIllIIIIIIlI;
    }
    
    private void func_192327_e() {
        if (this.field_192328_a.func_192068_c() != null) {
            this.field_192328_a.func_192068_c().func_192292_a((float)this.field_192335_h, this.field_192336_i);
        }
        if (!this.field_192332_e.isEmpty()) {
            for (final AdvancementTreeNode llllllllllllIlIllllIlIlIlIlIIlIl : this.field_192332_e) {
                llllllllllllIlIllllIlIlIlIlIIlIl.func_192327_e();
            }
        }
    }
    
    private AdvancementTreeNode func_192324_a(AdvancementTreeNode llllllllllllIlIllllIlIlIllIIlIII) {
        if (this.field_192330_c == null) {
            return llllllllllllIlIllllIlIlIllIIlIII;
        }
        AdvancementTreeNode llllllllllllIlIllllIlIlIllIlIIlI = this;
        AdvancementTreeNode llllllllllllIlIllllIlIlIllIlIIIl = this;
        AdvancementTreeNode llllllllllllIlIllllIlIlIllIlIIII = this.field_192330_c;
        AdvancementTreeNode llllllllllllIlIllllIlIlIllIIllll = this.field_192329_b.field_192332_e.get(0);
        float llllllllllllIlIllllIlIlIllIIlllI = this.field_192337_j;
        float llllllllllllIlIllllIlIlIllIIllIl = this.field_192337_j;
        float llllllllllllIlIllllIlIlIllIIllII = llllllllllllIlIllllIlIlIllIlIIII.field_192337_j;
        float llllllllllllIlIllllIlIlIllIIlIll = llllllllllllIlIllllIlIlIllIIllll.field_192337_j;
        while (llllllllllllIlIllllIlIlIllIlIIII.func_192317_d() != null && llllllllllllIlIllllIlIlIllIlIIlI.func_192321_c() != null) {
            llllllllllllIlIllllIlIlIllIlIIII = llllllllllllIlIllllIlIlIllIlIIII.func_192317_d();
            llllllllllllIlIllllIlIlIllIlIIlI = llllllllllllIlIllllIlIlIllIlIIlI.func_192321_c();
            llllllllllllIlIllllIlIlIllIIllll = llllllllllllIlIllllIlIlIllIIllll.func_192321_c();
            llllllllllllIlIllllIlIlIllIlIIIl = llllllllllllIlIllllIlIlIllIlIIIl.func_192317_d();
            llllllllllllIlIllllIlIlIllIlIIIl.field_192333_f = this;
            final float llllllllllllIlIllllIlIlIllIIlIlI = llllllllllllIlIllllIlIlIllIlIIII.field_192336_i + llllllllllllIlIllllIlIlIllIIllII - (llllllllllllIlIllllIlIlIllIlIIlI.field_192336_i + llllllllllllIlIllllIlIlIllIIlllI) + 1.0f;
            if (llllllllllllIlIllllIlIlIllIIlIlI > 0.0f) {
                llllllllllllIlIllllIlIlIllIlIIII.func_192326_a(this, llllllllllllIlIllllIlIlIllIIlIII).func_192316_a(this, llllllllllllIlIllllIlIlIllIIlIlI);
                llllllllllllIlIllllIlIlIllIIlllI += llllllllllllIlIllllIlIlIllIIlIlI;
                llllllllllllIlIllllIlIlIllIIllIl += llllllllllllIlIllllIlIlIllIIlIlI;
            }
            llllllllllllIlIllllIlIlIllIIllII += llllllllllllIlIllllIlIlIllIlIIII.field_192337_j;
            llllllllllllIlIllllIlIlIllIIlllI += llllllllllllIlIllllIlIlIllIlIIlI.field_192337_j;
            llllllllllllIlIllllIlIlIllIIlIll += llllllllllllIlIllllIlIlIllIIllll.field_192337_j;
            llllllllllllIlIllllIlIlIllIIllIl += llllllllllllIlIllllIlIlIllIlIIIl.field_192337_j;
        }
        if (llllllllllllIlIllllIlIlIllIlIIII.func_192317_d() != null && llllllllllllIlIllllIlIlIllIlIIIl.func_192317_d() == null) {
            llllllllllllIlIllllIlIlIllIlIIIl.field_192334_g = llllllllllllIlIllllIlIlIllIlIIII.func_192317_d();
            final AdvancementTreeNode advancementTreeNode = llllllllllllIlIllllIlIlIllIlIIIl;
            advancementTreeNode.field_192337_j += llllllllllllIlIllllIlIlIllIIllII - llllllllllllIlIllllIlIlIllIIllIl;
        }
        else {
            if (llllllllllllIlIllllIlIlIllIlIIlI.func_192321_c() != null && llllllllllllIlIllllIlIlIllIIllll.func_192321_c() == null) {
                llllllllllllIlIllllIlIlIllIIllll.field_192334_g = llllllllllllIlIllllIlIlIllIlIIlI.func_192321_c();
                final AdvancementTreeNode advancementTreeNode2 = llllllllllllIlIllllIlIlIllIIllll;
                advancementTreeNode2.field_192337_j += llllllllllllIlIllllIlIlIllIIlllI - llllllllllllIlIllllIlIlIllIIlIll;
            }
            llllllllllllIlIllllIlIlIllIIlIII = this;
        }
        return llllllllllllIlIllllIlIlIllIIlIII;
    }
    
    public static void func_192323_a(final Advancement llllllllllllIlIllllIlIlIlIIllllI) {
        if (llllllllllllIlIllllIlIlIlIIllllI.func_192068_c() == null) {
            throw new IllegalArgumentException("Can't position children of an invisible root!");
        }
        final AdvancementTreeNode llllllllllllIlIllllIlIlIlIIlllIl = new AdvancementTreeNode(llllllllllllIlIllllIlIlIlIIllllI, null, null, 1, 0);
        llllllllllllIlIllllIlIlIlIIlllIl.func_192320_a();
        final float llllllllllllIlIllllIlIlIlIIlllII = llllllllllllIlIllllIlIlIlIIlllIl.func_192319_a(0.0f, 0, llllllllllllIlIllllIlIlIlIIlllIl.field_192336_i);
        if (llllllllllllIlIllllIlIlIlIIlllII < 0.0f) {
            llllllllllllIlIllllIlIlIlIIlllIl.func_192318_a(-llllllllllllIlIllllIlIlIlIIlllII);
        }
        llllllllllllIlIllllIlIlIlIIlllIl.func_192327_e();
    }
    
    @Nullable
    private AdvancementTreeNode func_192321_c() {
        if (this.field_192334_g != null) {
            return this.field_192334_g;
        }
        return this.field_192332_e.isEmpty() ? null : this.field_192332_e.get(0);
    }
    
    private void func_192318_a(final float llllllllllllIlIllllIlIlIllllIlll) {
        this.field_192336_i += llllllllllllIlIllllIlIlIllllIlll;
        for (final AdvancementTreeNode llllllllllllIlIllllIlIlIlllllIIl : this.field_192332_e) {
            llllllllllllIlIllllIlIlIlllllIIl.func_192318_a(llllllllllllIlIllllIlIlIllllIlll);
        }
    }
    
    private void func_192316_a(final AdvancementTreeNode llllllllllllIlIllllIlIlIlIllIlIl, final float llllllllllllIlIllllIlIlIlIlllIII) {
        final float llllllllllllIlIllllIlIlIlIllIlll = (float)(llllllllllllIlIllllIlIlIlIllIlIl.field_192331_d - this.field_192331_d);
        if (llllllllllllIlIllllIlIlIlIllIlll != 0.0f) {
            llllllllllllIlIllllIlIlIlIllIlIl.field_192338_k -= llllllllllllIlIllllIlIlIlIlllIII / llllllllllllIlIllllIlIlIlIllIlll;
            this.field_192338_k += llllllllllllIlIllllIlIlIlIlllIII / llllllllllllIlIllllIlIlIlIllIlll;
        }
        llllllllllllIlIllllIlIlIlIllIlIl.field_192339_l += llllllllllllIlIllllIlIlIlIlllIII;
        llllllllllllIlIllllIlIlIlIllIlIl.field_192336_i += llllllllllllIlIllllIlIlIlIlllIII;
        llllllllllllIlIllllIlIlIlIllIlIl.field_192337_j += llllllllllllIlIllllIlIlIlIlllIII;
    }
}
