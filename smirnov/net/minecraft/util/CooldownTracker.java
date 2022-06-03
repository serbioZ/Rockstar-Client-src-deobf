// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import java.util.Iterator;
import com.google.common.collect.Maps;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.Item;
import java.util.Map;

public class CooldownTracker
{
    private /* synthetic */ int ticks;
    private final /* synthetic */ Map<Item, Cooldown> cooldowns;
    
    protected void notifyOnSet(final Item lllllllllllllIlIlIIllIlIllIlIlll, final int lllllllllllllIlIlIIllIlIllIlIllI) {
    }
    
    public float getCooldown(final Item lllllllllllllIlIlIIllIlIllllIlIl, final float lllllllllllllIlIlIIllIlIllllIlII) {
        final Cooldown lllllllllllllIlIlIIllIlIlllllIIl = this.cooldowns.get(lllllllllllllIlIlIIllIlIllllIlIl);
        if (lllllllllllllIlIlIIllIlIlllllIIl != null) {
            final float lllllllllllllIlIlIIllIlIlllllIII = (float)(lllllllllllllIlIlIIllIlIlllllIIl.expireTicks - lllllllllllllIlIlIIllIlIlllllIIl.createTicks);
            final float lllllllllllllIlIlIIllIlIllllIlll = lllllllllllllIlIlIIllIlIlllllIIl.expireTicks - (this.ticks + lllllllllllllIlIlIIllIlIllllIlII);
            return MathHelper.clamp(lllllllllllllIlIlIIllIlIllllIlll / lllllllllllllIlIlIIllIlIlllllIII, 0.0f, 1.0f);
        }
        return 0.0f;
    }
    
    public boolean hasCooldown(final Item lllllllllllllIlIlIIllIllIIIIIlIl) {
        return this.getCooldown(lllllllllllllIlIlIIllIllIIIIIlIl, 0.0f) > 0.0f;
    }
    
    public CooldownTracker() {
        this.cooldowns = (Map<Item, Cooldown>)Maps.newHashMap();
    }
    
    public void tick() {
        ++this.ticks;
        if (!this.cooldowns.isEmpty()) {
            final Iterator<Map.Entry<Item, Cooldown>> lllllllllllllIlIlIIllIlIlllIllII = this.cooldowns.entrySet().iterator();
            while (lllllllllllllIlIlIIllIlIlllIllII.hasNext()) {
                final Map.Entry<Item, Cooldown> lllllllllllllIlIlIIllIlIlllIlIll = lllllllllllllIlIlIIllIlIlllIllII.next();
                if (lllllllllllllIlIlIIllIlIlllIlIll.getValue().expireTicks <= this.ticks) {
                    lllllllllllllIlIlIIllIlIlllIllII.remove();
                    this.notifyOnRemove(lllllllllllllIlIlIIllIlIlllIlIll.getKey());
                }
            }
        }
    }
    
    protected void notifyOnRemove(final Item lllllllllllllIlIlIIllIlIllIlIlII) {
    }
    
    public void removeCooldown(final Item lllllllllllllIlIlIIllIlIllIllIIl) {
        this.cooldowns.remove(lllllllllllllIlIlIIllIlIllIllIIl);
        this.notifyOnRemove(lllllllllllllIlIlIIllIlIllIllIIl);
    }
    
    public void setCooldown(final Item lllllllllllllIlIlIIllIlIlllIIIII, final int lllllllllllllIlIlIIllIlIllIlllll) {
        this.cooldowns.put(lllllllllllllIlIlIIllIlIlllIIIII, new Cooldown(this.ticks, this.ticks + lllllllllllllIlIlIIllIlIllIlllll, (Cooldown)null));
        this.notifyOnSet(lllllllllllllIlIlIIllIlIlllIIIII, lllllllllllllIlIlIIllIlIllIlllll);
    }
    
    class Cooldown
    {
        final /* synthetic */ int expireTicks;
        final /* synthetic */ int createTicks;
        
        private Cooldown(final int lllllllllllIlIIllIlIllIIIllIIIll, final int lllllllllllIlIIllIlIllIIIllIIIlI) {
            this.createTicks = lllllllllllIlIIllIlIllIIIllIIIll;
            this.expireTicks = lllllllllllIlIIllIlIllIIIllIIIlI;
        }
    }
}
