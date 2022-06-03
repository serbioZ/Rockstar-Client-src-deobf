// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import javax.annotation.Nullable;
import com.google.common.collect.Sets;
import com.google.common.collect.Maps;
import org.apache.logging.log4j.LogManager;
import java.util.Iterator;
import java.util.function.Function;
import com.google.common.base.Functions;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import java.util.Set;

public class AdvancementList
{
    private final /* synthetic */ Set<Advancement> field_192094_d;
    private final /* synthetic */ Map<ResourceLocation, Advancement> field_192092_b;
    private static final /* synthetic */ Logger field_192091_a;
    private /* synthetic */ Listener field_192095_e;
    private final /* synthetic */ Set<Advancement> field_192093_c;
    
    public void func_192083_a(final Map<ResourceLocation, Advancement.Builder> lllllllllllIlIIlllIIIIIlIIIlIlll) {
        final Function<ResourceLocation, Advancement> lllllllllllIlIIlllIIIIIlIIIlIllI = (Function<ResourceLocation, Advancement>)Functions.forMap((Map)this.field_192092_b, (Object)null);
        while (!lllllllllllIlIIlllIIIIIlIIIlIlll.isEmpty()) {
            boolean lllllllllllIlIIlllIIIIIlIIIlIlIl = false;
            Iterator<Map.Entry<ResourceLocation, Advancement.Builder>> lllllllllllIlIIlllIIIIIlIIIlIlII = lllllllllllIlIIlllIIIIIlIIIlIlll.entrySet().iterator();
            while (lllllllllllIlIIlllIIIIIlIIIlIlII.hasNext()) {
                final Map.Entry<ResourceLocation, Advancement.Builder> lllllllllllIlIIlllIIIIIlIIIlIIll = lllllllllllIlIIlllIIIIIlIIIlIlII.next();
                final ResourceLocation lllllllllllIlIIlllIIIIIlIIIlIIlI = lllllllllllIlIIlllIIIIIlIIIlIIll.getKey();
                final Advancement.Builder lllllllllllIlIIlllIIIIIlIIIlIIIl = lllllllllllIlIIlllIIIIIlIIIlIIll.getValue();
                if (lllllllllllIlIIlllIIIIIlIIIlIIIl.func_192058_a(lllllllllllIlIIlllIIIIIlIIIlIllI)) {
                    final Advancement lllllllllllIlIIlllIIIIIlIIIlIIII = lllllllllllIlIIlllIIIIIlIIIlIIIl.func_192056_a(lllllllllllIlIIlllIIIIIlIIIlIIlI);
                    this.field_192092_b.put(lllllllllllIlIIlllIIIIIlIIIlIIlI, lllllllllllIlIIlllIIIIIlIIIlIIII);
                    lllllllllllIlIIlllIIIIIlIIIlIlIl = true;
                    lllllllllllIlIIlllIIIIIlIIIlIlII.remove();
                    if (lllllllllllIlIIlllIIIIIlIIIlIIII.func_192070_b() == null) {
                        this.field_192093_c.add(lllllllllllIlIIlllIIIIIlIIIlIIII);
                        if (this.field_192095_e == null) {
                            continue;
                        }
                        this.field_192095_e.func_191931_a(lllllllllllIlIIlllIIIIIlIIIlIIII);
                    }
                    else {
                        this.field_192094_d.add(lllllllllllIlIIlllIIIIIlIIIlIIII);
                        if (this.field_192095_e == null) {
                            continue;
                        }
                        this.field_192095_e.func_191932_c(lllllllllllIlIIlllIIIIIlIIIlIIII);
                    }
                }
            }
            if (!lllllllllllIlIIlllIIIIIlIIIlIlIl) {
                lllllllllllIlIIlllIIIIIlIIIlIlII = lllllllllllIlIIlllIIIIIlIIIlIlll.entrySet().iterator();
                while (lllllllllllIlIIlllIIIIIlIIIlIlII.hasNext()) {
                    final Map.Entry<ResourceLocation, Advancement.Builder> lllllllllllIlIIlllIIIIIlIIIIllll = lllllllllllIlIIlllIIIIIlIIIlIlII.next();
                    AdvancementList.field_192091_a.error("Couldn't load advancement " + lllllllllllIlIIlllIIIIIlIIIIllll.getKey() + ": " + lllllllllllIlIIlllIIIIIlIIIIllll.getValue());
                }
                break;
            }
        }
        AdvancementList.field_192091_a.info("Loaded " + this.field_192092_b.size() + " advancements");
    }
    
    public void func_192085_a(final Set<ResourceLocation> lllllllllllIlIIlllIIIIIlIIlIIlIl) {
        for (final ResourceLocation lllllllllllIlIIlllIIIIIlIIlIlIII : lllllllllllIlIIlllIIIIIlIIlIIlIl) {
            final Advancement lllllllllllIlIIlllIIIIIlIIlIIlll = this.field_192092_b.get(lllllllllllIlIIlllIIIIIlIIlIlIII);
            if (lllllllllllIlIIlllIIIIIlIIlIIlll == null) {
                AdvancementList.field_192091_a.warn("Told to remove advancement " + lllllllllllIlIIlllIIIIIlIIlIlIII + " but I don't know what that is");
            }
            else {
                this.func_192090_a(lllllllllllIlIIlllIIIIIlIIlIIlll);
            }
        }
    }
    
    private void func_192090_a(final Advancement lllllllllllIlIIlllIIIIIlIIllIIlI) {
        for (final Advancement lllllllllllIlIIlllIIIIIlIIllIlII : lllllllllllIlIIlllIIIIIlIIllIIlI.func_192069_e()) {
            this.func_192090_a(lllllllllllIlIIlllIIIIIlIIllIlII);
        }
        AdvancementList.field_192091_a.info("Forgot about advancement " + lllllllllllIlIIlllIIIIIlIIllIIlI.func_192067_g());
        this.field_192092_b.remove(lllllllllllIlIIlllIIIIIlIIllIIlI.func_192067_g());
        if (lllllllllllIlIIlllIIIIIlIIllIIlI.func_192070_b() == null) {
            this.field_192093_c.remove(lllllllllllIlIIlllIIIIIlIIllIIlI);
            if (this.field_192095_e != null) {
                this.field_192095_e.func_191928_b(lllllllllllIlIIlllIIIIIlIIllIIlI);
            }
        }
        else {
            this.field_192094_d.remove(lllllllllllIlIIlllIIIIIlIIllIIlI);
            if (this.field_192095_e != null) {
                this.field_192095_e.func_191929_d(lllllllllllIlIIlllIIIIIlIIllIIlI);
            }
        }
    }
    
    public void func_192087_a() {
        this.field_192092_b.clear();
        this.field_192093_c.clear();
        this.field_192094_d.clear();
        if (this.field_192095_e != null) {
            this.field_192095_e.func_191930_a();
        }
    }
    
    public Iterable<Advancement> func_192088_b() {
        return this.field_192093_c;
    }
    
    static {
        field_192091_a = LogManager.getLogger();
    }
    
    public AdvancementList() {
        this.field_192092_b = (Map<ResourceLocation, Advancement>)Maps.newHashMap();
        this.field_192093_c = (Set<Advancement>)Sets.newLinkedHashSet();
        this.field_192094_d = (Set<Advancement>)Sets.newLinkedHashSet();
    }
    
    public Iterable<Advancement> func_192089_c() {
        return this.field_192092_b.values();
    }
    
    public void func_192086_a(@Nullable final Listener lllllllllllIlIIlllIIIIIIllllIIIl) {
        this.field_192095_e = lllllllllllIlIIlllIIIIIIllllIIIl;
        if (lllllllllllIlIIlllIIIIIIllllIIIl != null) {
            for (final Advancement lllllllllllIlIIlllIIIIIIllllIIII : this.field_192093_c) {
                lllllllllllIlIIlllIIIIIIllllIIIl.func_191931_a(lllllllllllIlIIlllIIIIIIllllIIII);
            }
            for (final Advancement lllllllllllIlIIlllIIIIIIlllIllll : this.field_192094_d) {
                lllllllllllIlIIlllIIIIIIllllIIIl.func_191932_c(lllllllllllIlIIlllIIIIIIlllIllll);
            }
        }
    }
    
    @Nullable
    public Advancement func_192084_a(final ResourceLocation lllllllllllIlIIlllIIIIIIllllIlll) {
        return this.field_192092_b.get(lllllllllllIlIIlllIIIIIIllllIlll);
    }
    
    public interface Listener
    {
        void func_191928_b(final Advancement p0);
        
        void func_191929_d(final Advancement p0);
        
        void func_191930_a();
        
        void func_191931_a(final Advancement p0);
        
        void func_191932_c(final Advancement p0);
    }
}
