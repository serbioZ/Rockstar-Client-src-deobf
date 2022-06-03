// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum DimensionType
{
    NETHER(-1, "the_nether", "_nether", (Class<? extends WorldProvider>)WorldProviderHell.class), 
    OVERWORLD(0, "overworld", "", (Class<? extends WorldProvider>)WorldProviderSurface.class);
    
    private final /* synthetic */ int id;
    private final /* synthetic */ Class<? extends WorldProvider> clazz;
    
    THE_END(1, "the_end", "_end", (Class<? extends WorldProvider>)WorldProviderEnd.class);
    
    private final /* synthetic */ String suffix;
    private final /* synthetic */ String name;
    
    public int getId() {
        return this.id;
    }
    
    private DimensionType(final int llllllllllllIllIlllIIIIIllIlIlII, final String llllllllllllIllIlllIIIIIllIIllII, final String llllllllllllIllIlllIIIIIllIIlIll, final Class<? extends WorldProvider> llllllllllllIllIlllIIIIIllIlIIIl) {
        this.id = llllllllllllIllIlllIIIIIllIlIlII;
        this.name = llllllllllllIllIlllIIIIIllIIllII;
        this.suffix = llllllllllllIllIlllIIIIIllIIlIll;
        this.clazz = llllllllllllIllIlllIIIIIllIlIIIl;
    }
    
    public String getName() {
        return this.name;
    }
    
    public WorldProvider createDimension() {
        try {
            final Constructor<? extends WorldProvider> llllllllllllIllIlllIIIIIlIllllIl = this.clazz.getConstructor((Class<?>[])new Class[0]);
            return (WorldProvider)llllllllllllIllIlllIIIIIlIllllIl.newInstance(new Object[0]);
        }
        catch (NoSuchMethodException llllllllllllIllIlllIIIIIlIllllII) {
            throw new Error("Could not create new dimension", llllllllllllIllIlllIIIIIlIllllII);
        }
        catch (InvocationTargetException llllllllllllIllIlllIIIIIlIlllIll) {
            throw new Error("Could not create new dimension", llllllllllllIllIlllIIIIIlIlllIll);
        }
        catch (InstantiationException llllllllllllIllIlllIIIIIlIlllIlI) {
            throw new Error("Could not create new dimension", llllllllllllIllIlllIIIIIlIlllIlI);
        }
        catch (IllegalAccessException llllllllllllIllIlllIIIIIlIlllIIl) {
            throw new Error("Could not create new dimension", llllllllllllIllIlllIIIIIlIlllIIl);
        }
    }
    
    public static DimensionType getById(final int llllllllllllIllIlllIIIIIlIlIllll) {
        final double llllllllllllIllIlllIIIIIlIlIlIll;
        final float llllllllllllIllIlllIIIIIlIlIllII = ((DimensionType[])(Object)(llllllllllllIllIlllIIIIIlIlIlIll = (double)(Object)values())).length;
        for (final DimensionType llllllllllllIllIlllIIIIIlIllIIII : llllllllllllIllIlllIIIIIlIlIlIll) {
            if (llllllllllllIllIlllIIIIIlIllIIII.getId() == llllllllllllIllIlllIIIIIlIlIllll) {
                return llllllllllllIllIlllIIIIIlIllIIII;
            }
        }
        throw new IllegalArgumentException("Invalid dimension id " + llllllllllllIllIlllIIIIIlIlIllll);
    }
    
    public static DimensionType func_193417_a(final String llllllllllllIllIlllIIIIIlIlIIlIl) {
        final double llllllllllllIllIlllIIIIIlIIlllll;
        final double llllllllllllIllIlllIIIIIlIlIIIII = ((DimensionType[])(Object)(llllllllllllIllIlllIIIIIlIIlllll = (double)(Object)values())).length;
        for (boolean llllllllllllIllIlllIIIIIlIlIIIIl = false; (llllllllllllIllIlllIIIIIlIlIIIIl ? 1 : 0) < llllllllllllIllIlllIIIIIlIlIIIII; ++llllllllllllIllIlllIIIIIlIlIIIIl) {
            final DimensionType llllllllllllIllIlllIIIIIlIlIIlII = llllllllllllIllIlllIIIIIlIIlllll[llllllllllllIllIlllIIIIIlIlIIIIl];
            if (llllllllllllIllIlllIIIIIlIlIIlII.getName().equals(llllllllllllIllIlllIIIIIlIlIIlIl)) {
                return llllllllllllIllIlllIIIIIlIlIIlII;
            }
        }
        throw new IllegalArgumentException("Invalid dimension " + llllllllllllIllIlllIIIIIlIlIIlIl);
    }
    
    public String getSuffix() {
        return this.suffix;
    }
}
