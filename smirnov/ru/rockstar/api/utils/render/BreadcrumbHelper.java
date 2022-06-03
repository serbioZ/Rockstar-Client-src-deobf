// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.render;

import net.minecraft.util.math.Vec3d;

public class BreadcrumbHelper
{
    /* synthetic */ TimeHelper timer;
    /* synthetic */ Vec3d vector;
    
    public BreadcrumbHelper(final Vec3d lllllllllllllIIIIIlIlllllIIlllIl) {
        this.timer = new TimeHelper();
        this.vector = lllllllllllllIIIIIlIlllllIIlllIl;
    }
    
    public Vec3d getVector() {
        return this.vector;
    }
    
    public TimeHelper getTimer() {
        return this.timer;
    }
    
    public class TimeHelper
    {
        /* synthetic */ long ms;
        
        public boolean hasReached(final long llllllllllllllllIIlIlIlIIIIIIIlI) {
            return System.currentTimeMillis() - this.ms >= llllllllllllllllIIlIlIlIIIIIIIlI;
        }
        
        public void reset() {
            this.ms = System.currentTimeMillis();
        }
        
        public long getMS() {
            return this.ms;
        }
        
        public TimeHelper() {
            this.reset();
        }
    }
}
