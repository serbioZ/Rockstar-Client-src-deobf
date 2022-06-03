// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.settings;

import java.util.function.Supplier;
import org.lwjgl.input.Keyboard;
import com.google.common.collect.Sets;
import com.google.common.collect.Maps;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.IntHashMap;
import java.util.Set;
import java.util.Map;

public class KeyBinding implements Comparable<KeyBinding>
{
    private /* synthetic */ int pressTime;
    private static final /* synthetic */ Map<String, Integer> field_193627_d;
    private final /* synthetic */ int keyCodeDefault;
    private final /* synthetic */ String keyDescription;
    private static final /* synthetic */ Set<String> KEYBIND_SET;
    public /* synthetic */ boolean pressed;
    private final /* synthetic */ String keyCategory;
    private static final /* synthetic */ Map<String, KeyBinding> KEYBIND_ARRAY;
    private /* synthetic */ int keyCode;
    private static final /* synthetic */ IntHashMap<KeyBinding> HASH;
    
    public boolean isKeyDown() {
        return this.pressed;
    }
    
    public static Set<String> getKeybinds() {
        return KeyBinding.KEYBIND_SET;
    }
    
    public KeyBinding(final String llllllllllllllIlIIlIlIIllIIIlIlI, final int llllllllllllllIlIIlIlIIllIIIlIIl, final String llllllllllllllIlIIlIlIIllIIIllII) {
        this.keyDescription = llllllllllllllIlIIlIlIIllIIIlIlI;
        this.keyCode = llllllllllllllIlIIlIlIIllIIIlIIl;
        this.keyCodeDefault = llllllllllllllIlIIlIlIIllIIIlIIl;
        this.keyCategory = llllllllllllllIlIIlIlIIllIIIllII;
        KeyBinding.KEYBIND_ARRAY.put(llllllllllllllIlIIlIlIIllIIIlIlI, this);
        KeyBinding.HASH.addKey(llllllllllllllIlIIlIlIIllIIIlIIl, this);
        KeyBinding.KEYBIND_SET.add(llllllllllllllIlIIlIlIIllIIIllII);
    }
    
    @Override
    public int compareTo(final KeyBinding llllllllllllllIlIIlIlIIlIllIIIll) {
        return this.keyCategory.equals(llllllllllllllIlIIlIlIIlIllIIIll.keyCategory) ? I18n.format(this.keyDescription, new Object[0]).compareTo(I18n.format(llllllllllllllIlIIlIlIIlIllIIIll.keyDescription, new Object[0])) : KeyBinding.field_193627_d.get(this.keyCategory).compareTo(KeyBinding.field_193627_d.get(llllllllllllllIlIIlIlIIlIllIIIll.keyCategory));
    }
    
    static {
        KEYBIND_ARRAY = Maps.newHashMap();
        HASH = new IntHashMap<KeyBinding>();
        KEYBIND_SET = Sets.newHashSet();
        (field_193627_d = Maps.newHashMap()).put("key.categories.movement", 1);
        KeyBinding.field_193627_d.put("key.categories.gameplay", 2);
        KeyBinding.field_193627_d.put("key.categories.inventory", 3);
        KeyBinding.field_193627_d.put("key.categories.creative", 4);
        KeyBinding.field_193627_d.put("key.categories.multiplayer", 5);
        KeyBinding.field_193627_d.put("key.categories.ui", 6);
        KeyBinding.field_193627_d.put("key.categories.misc", 7);
    }
    
    public static void resetKeyBindingArrayAndHash() {
        KeyBinding.HASH.clearMap();
        for (final KeyBinding llllllllllllllIlIIlIlIIllIIlIllI : KeyBinding.KEYBIND_ARRAY.values()) {
            KeyBinding.HASH.addKey(llllllllllllllIlIIlIlIIllIIlIllI.keyCode, llllllllllllllIlIIlIlIIllIIlIllI);
        }
    }
    
    public int getKeyCode() {
        return this.keyCode;
    }
    
    public String getKeyDescription() {
        return this.keyDescription;
    }
    
    public static void updateKeyBindState() {
        for (final KeyBinding llllllllllllllIlIIlIlIIllIlIIIIl : KeyBinding.KEYBIND_ARRAY.values()) {
            try {
                setKeyBindState(llllllllllllllIlIIlIlIIllIlIIIIl.keyCode, llllllllllllllIlIIlIlIIllIlIIIIl.keyCode < 256 && Keyboard.isKeyDown(llllllllllllllIlIIlIlIIllIlIIIIl.keyCode));
            }
            catch (IndexOutOfBoundsException ex) {}
        }
    }
    
    public static void unPressAllKeys() {
        for (final KeyBinding llllllllllllllIlIIlIlIIllIIllIll : KeyBinding.KEYBIND_ARRAY.values()) {
            llllllllllllllIlIIlIlIIllIIllIll.unpressKey();
        }
    }
    
    public static void setKeyBindState(final int llllllllllllllIlIIlIlIIllIlIlIlI, final boolean llllllllllllllIlIIlIlIIllIlIIllI) {
        if (llllllllllllllIlIIlIlIIllIlIlIlI != 0) {
            final KeyBinding llllllllllllllIlIIlIlIIllIlIlIII = KeyBinding.HASH.lookup(llllllllllllllIlIIlIlIIllIlIlIlI);
            if (llllllllllllllIlIIlIlIIllIlIlIII != null) {
                llllllllllllllIlIIlIlIIllIlIlIII.pressed = llllllllllllllIlIIlIlIIllIlIIllI;
            }
        }
    }
    
    public void setKeyCode(final int llllllllllllllIlIIlIlIIlIllIlIIl) {
        this.keyCode = llllllllllllllIlIIlIlIIlIllIlIIl;
    }
    
    public static Supplier<String> func_193626_b(final String llllllllllllllIlIIlIlIIlIlIllllI) {
        final KeyBinding llllllllllllllIlIIlIlIIlIlIlllIl = KeyBinding.KEYBIND_ARRAY.get(llllllllllllllIlIIlIlIIlIlIllllI);
        return (llllllllllllllIlIIlIlIIlIlIlllIl == null) ? (() -> llllllllllllllIlIIlIlIIlIlIllllI) : (() -> GameSettings.getKeyDisplayString(llllllllllllllIlIIlIlIIlIlIlllIl.getKeyCode()));
    }
    
    public String getKeyCategory() {
        return this.keyCategory;
    }
    
    private void unpressKey() {
        this.pressTime = 0;
        this.pressed = false;
    }
    
    public boolean isPressed() {
        if (this.pressTime == 0) {
            return false;
        }
        --this.pressTime;
        return true;
    }
    
    public static void onTick(final int llllllllllllllIlIIlIlIIllIllIIIl) {
        if (llllllllllllllIlIIlIlIIllIllIIIl != 0) {
            final KeyBinding llllllllllllllIlIIlIlIIllIllIIII = KeyBinding.HASH.lookup(llllllllllllllIlIIlIlIIllIllIIIl);
            if (llllllllllllllIlIIlIlIIllIllIIII != null) {
                final KeyBinding keyBinding = llllllllllllllIlIIlIlIIllIllIIII;
                ++keyBinding.pressTime;
            }
        }
    }
    
    public int getKeyCodeDefault() {
        return this.keyCodeDefault;
    }
    
    public void setPressed(final boolean llllllllllllllIlIIlIlIIlIllllIll) {
        this.pressed = llllllllllllllIlIIlIlIIlIllllIll;
    }
}
