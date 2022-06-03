// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event;

import java.util.HashMap;
import java.util.Iterator;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

public class EventManager
{
    private static final /* synthetic */ Map<Class<? extends Event>, ArrayHelper<Data>> REGISTRY_MAP;
    
    private static boolean isMethodBad(final Method lllllllllllIlllIIlllIlIIIlIIllIl) {
        return lllllllllllIlllIIlllIlIIIlIIllIl.getParameterTypes().length != 1 || !lllllllllllIlllIIlllIlIIIlIIllIl.isAnnotationPresent(EventTarget.class);
    }
    
    public static void cleanMap(final boolean lllllllllllIlllIIlllIlIIIllIllIl) {
        final Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> lllllllllllIlllIIlllIlIIIllIllII = EventManager.REGISTRY_MAP.entrySet().iterator();
        while (lllllllllllIlllIIlllIlIIIllIllII.hasNext()) {
            if (!lllllllllllIlllIIlllIlIIIllIllIl || lllllllllllIlllIIlllIlIIIllIllII.next().getValue().isEmpty()) {
                lllllllllllIlllIIlllIlIIIllIllII.remove();
            }
        }
    }
    
    static {
        REGISTRY_MAP = new HashMap<Class<? extends Event>, ArrayHelper<Data>>();
    }
    
    public static void unregister(final Object lllllllllllIlllIIlllIlIIIlllIIll, final Class<? extends Event> lllllllllllIlllIIlllIlIIIlllIlIl) {
        if (EventManager.REGISTRY_MAP.containsKey(lllllllllllIlllIIlllIlIIIlllIlIl)) {
            for (final Data lllllllllllIlllIIlllIlIIIlllIlII : EventManager.REGISTRY_MAP.get(lllllllllllIlllIIlllIlIIIlllIlIl)) {
                if (lllllllllllIlllIIlllIlIIIlllIlII.source.equals(lllllllllllIlllIIlllIlIIIlllIIll)) {
                    EventManager.REGISTRY_MAP.get(lllllllllllIlllIIlllIlIIIlllIlIl).remove(lllllllllllIlllIIlllIlIIIlllIlII);
                }
            }
            cleanMap(true);
        }
    }
    
    private static void sortListValue(final Class<? extends Event> lllllllllllIlllIIlllIlIIIlIlIlll) {
        final ArrayHelper<Data> lllllllllllIlllIIlllIlIIIlIllIlI = new ArrayHelper<Data>();
        final char lllllllllllIlllIIlllIlIIIlIlIIlI;
        final Exception lllllllllllIlllIIlllIlIIIlIlIIll = (Exception)((byte[])(Object)(lllllllllllIlllIIlllIlIIIlIlIIlI = (char)(Object)Priority.VALUE_ARRAY)).length;
        for (char lllllllllllIlllIIlllIlIIIlIlIlII = '\0'; lllllllllllIlllIIlllIlIIIlIlIlII < lllllllllllIlllIIlllIlIIIlIlIIll; ++lllllllllllIlllIIlllIlIIIlIlIlII) {
            final byte lllllllllllIlllIIlllIlIIIlIllIIl = lllllllllllIlllIIlllIlIIIlIlIIlI[lllllllllllIlllIIlllIlIIIlIlIlII];
            for (final Data lllllllllllIlllIIlllIlIIIlIllIII : EventManager.REGISTRY_MAP.get(lllllllllllIlllIIlllIlIIIlIlIlll)) {
                if (lllllllllllIlllIIlllIlIIIlIllIII.priority == lllllllllllIlllIIlllIlIIIlIllIIl) {
                    lllllllllllIlllIIlllIlIIIlIllIlI.add(lllllllllllIlllIIlllIlIIIlIllIII);
                }
            }
        }
        EventManager.REGISTRY_MAP.put(lllllllllllIlllIIlllIlIIIlIlIlll, lllllllllllIlllIIlllIlIIIlIllIlI);
    }
    
    public static void register(final Object lllllllllllIlllIIlllIlIIlIlIIlll) {
        final long lllllllllllIlllIIlllIlIIlIlIIIll;
        final boolean lllllllllllIlllIIlllIlIIlIlIIlII = ((Method[])(Object)(lllllllllllIlllIIlllIlIIlIlIIIll = (long)(Object)lllllllllllIlllIIlllIlIIlIlIIlll.getClass().getDeclaredMethods())).length != 0;
        for (Exception lllllllllllIlllIIlllIlIIlIlIIlIl = (Exception)0; lllllllllllIlllIIlllIlIIlIlIIlIl < lllllllllllIlllIIlllIlIIlIlIIlII; ++lllllllllllIlllIIlllIlIIlIlIIlIl) {
            final Method lllllllllllIlllIIlllIlIIlIlIlIII = lllllllllllIlllIIlllIlIIlIlIIIll[lllllllllllIlllIIlllIlIIlIlIIlIl];
            if (!isMethodBad(lllllllllllIlllIIlllIlIIlIlIlIII)) {
                register(lllllllllllIlllIIlllIlIIlIlIlIII, lllllllllllIlllIIlllIlIIlIlIIlll);
            }
        }
    }
    
    private static void register(final Method lllllllllllIlllIIlllIlIIlIIIllll, final Object lllllllllllIlllIIlllIlIIlIIIlIlI) {
        final Class<?> lllllllllllIlllIIlllIlIIlIIIllIl = lllllllllllIlllIIlllIlIIlIIIllll.getParameterTypes()[0];
        final Data lllllllllllIlllIIlllIlIIlIIIllII = new Data(lllllllllllIlllIIlllIlIIlIIIlIlI, lllllllllllIlllIIlllIlIIlIIIllll, lllllllllllIlllIIlllIlIIlIIIllll.getAnnotation(EventTarget.class).value());
        if (!lllllllllllIlllIIlllIlIIlIIIllII.target.isAccessible()) {
            lllllllllllIlllIIlllIlIIlIIIllII.target.setAccessible(true);
        }
        if (EventManager.REGISTRY_MAP.containsKey(lllllllllllIlllIIlllIlIIlIIIllIl)) {
            if (!EventManager.REGISTRY_MAP.get(lllllllllllIlllIIlllIlIIlIIIllIl).contains(lllllllllllIlllIIlllIlIIlIIIllII)) {
                EventManager.REGISTRY_MAP.get(lllllllllllIlllIIlllIlIIlIIIllIl).add(lllllllllllIlllIIlllIlIIlIIIllII);
                sortListValue((Class<? extends Event>)lllllllllllIlllIIlllIlIIlIIIllIl);
            }
        }
        else {
            EventManager.REGISTRY_MAP.put((Class<? extends Event>)lllllllllllIlllIIlllIlIIlIIIllIl, new ArrayHelper<Data>(lllllllllllIlllIIlllIlIIlIIIllII) {
                {
                    this.add(llllllllllIlllIlllllIIIIllIIIlIl);
                }
            });
        }
    }
    
    public static void shutdown() {
        EventManager.REGISTRY_MAP.clear();
    }
    
    public static void register(final Object lllllllllllIlllIIlllIlIIlIIllIIl, final Class<? extends Event> lllllllllllIlllIIlllIlIIlIIllIll) {
        final double lllllllllllIlllIIlllIlIIlIIlIlII;
        final String lllllllllllIlllIIlllIlIIlIIlIlIl = (String)((Method[])(Object)(lllllllllllIlllIIlllIlIIlIIlIlII = (double)(Object)lllllllllllIlllIIlllIlIIlIIllIIl.getClass().getDeclaredMethods())).length;
        for (byte lllllllllllIlllIIlllIlIIlIIlIllI = 0; lllllllllllIlllIIlllIlIIlIIlIllI < lllllllllllIlllIIlllIlIIlIIlIlIl; ++lllllllllllIlllIIlllIlIIlIIlIllI) {
            final Method lllllllllllIlllIIlllIlIIlIIllIlI = lllllllllllIlllIIlllIlIIlIIlIlII[lllllllllllIlllIIlllIlIIlIIlIllI];
            if (!isMethodBad(lllllllllllIlllIIlllIlIIlIIllIlI, lllllllllllIlllIIlllIlIIlIIllIll)) {
                register(lllllllllllIlllIIlllIlIIlIIllIlI, lllllllllllIlllIIlllIlIIlIIllIIl);
            }
        }
    }
    
    private static boolean isMethodBad(final Method lllllllllllIlllIIlllIlIIIlIIlIlI, final Class<? extends Event> lllllllllllIlllIIlllIlIIIlIIlIIl) {
        return isMethodBad(lllllllllllIlllIIlllIlIIIlIIlIlI) || lllllllllllIlllIIlllIlIIIlIIlIlI.getParameterTypes()[0].equals(lllllllllllIlllIIlllIlIIIlIIlIIl);
    }
    
    public static ArrayHelper<Data> get(final Class<? extends Event> lllllllllllIlllIIlllIlIIIlIIIlII) {
        return EventManager.REGISTRY_MAP.get(lllllllllllIlllIIlllIlIIIlIIIlII);
    }
    
    public static void unregister(final Object lllllllllllIlllIIlllIlIIlIIIIIlI) {
        for (final ArrayHelper<Data> lllllllllllIlllIIlllIlIIlIIIIIIl : EventManager.REGISTRY_MAP.values()) {
            for (final Data lllllllllllIlllIIlllIlIIlIIIIIII : lllllllllllIlllIIlllIlIIlIIIIIIl) {
                if (lllllllllllIlllIIlllIlIIlIIIIIII.source.equals(lllllllllllIlllIIlllIlIIlIIIIIlI)) {
                    lllllllllllIlllIIlllIlIIlIIIIIIl.remove(lllllllllllIlllIIlllIlIIlIIIIIII);
                }
            }
        }
        cleanMap(true);
    }
    
    public static void removeEnty(final Class<? extends Event> lllllllllllIlllIIlllIlIIIllIIlll) {
        final Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> lllllllllllIlllIIlllIlIIIllIIllI = EventManager.REGISTRY_MAP.entrySet().iterator();
        while (lllllllllllIlllIIlllIlIIIllIIllI.hasNext()) {
            if (lllllllllllIlllIIlllIlIIIllIIllI.next().getKey().equals(lllllllllllIlllIIlllIlIIIllIIlll)) {
                lllllllllllIlllIIlllIlIIIllIIllI.remove();
                break;
            }
        }
    }
}
