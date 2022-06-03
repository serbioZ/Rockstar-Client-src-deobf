// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.impl;

import java.util.function.Supplier;
import ru.rockstar.client.ui.settings.Setting;

public class NumberSetting extends Setting
{
    private /* synthetic */ float maximum;
    private /* synthetic */ float minimum;
    private /* synthetic */ float increment;
    private /* synthetic */ float current;
    private final /* synthetic */ NumberType type;
    private /* synthetic */ String desc;
    
    public NumberSetting(final String llllllllllllIlIlIIIIIIlllIIIllIl, final String llllllllllllIlIlIIIIIIlllIIIllII, final float llllllllllllIlIlIIIIIIlllIIlIIll, final float llllllllllllIlIlIIIIIIlllIIlIIlI, final float llllllllllllIlIlIIIIIIlllIIIlIIl, final float llllllllllllIlIlIIIIIIlllIIlIIII, final Supplier<Boolean> llllllllllllIlIlIIIIIIlllIIIllll) {
        this.name = llllllllllllIlIlIIIIIIlllIIIllIl;
        this.desc = llllllllllllIlIlIIIIIIlllIIIllII;
        this.minimum = llllllllllllIlIlIIIIIIlllIIlIIlI;
        this.current = llllllllllllIlIlIIIIIIlllIIlIIll;
        this.maximum = llllllllllllIlIlIIIIIIlllIIIlIIl;
        this.increment = llllllllllllIlIlIIIIIIlllIIlIIII;
        this.type = NumberType.DEFAULT;
        this.setVisible(llllllllllllIlIlIIIIIIlllIIIllll);
    }
    
    public void setDesc(final String llllllllllllIlIlIIIIIIllIllIIIll) {
        this.desc = llllllllllllIlIlIIIIIIllIllIIIll;
    }
    
    public float getMaxValue() {
        return this.maximum;
    }
    
    public float getMinValue() {
        return this.minimum;
    }
    
    public void setValueNumber(final float llllllllllllIlIlIIIIIIllIlIIlIII) {
        this.current = llllllllllllIlIlIIIIIIllIlIIlIII;
    }
    
    public float getIncrement() {
        return this.increment;
    }
    
    public NumberType getType() {
        return this.type;
    }
    
    public NumberSetting(final String llllllllllllIlIlIIIIIIlllIlIIlIl, final float llllllllllllIlIlIIIIIIlllIlIllII, final float llllllllllllIlIlIIIIIIlllIlIlIll, final float llllllllllllIlIlIIIIIIlllIlIlIlI, final float llllllllllllIlIlIIIIIIlllIlIlIIl, final Supplier<Boolean> llllllllllllIlIlIIIIIIlllIlIIIII, final NumberType llllllllllllIlIlIIIIIIlllIlIIlll) {
        this.name = llllllllllllIlIlIIIIIIlllIlIIlIl;
        this.minimum = llllllllllllIlIlIIIIIIlllIlIlIll;
        this.current = llllllllllllIlIlIIIIIIlllIlIllII;
        this.maximum = llllllllllllIlIlIIIIIIlllIlIlIlI;
        this.increment = llllllllllllIlIlIIIIIIlllIlIlIIl;
        this.type = llllllllllllIlIlIIIIIIlllIlIIlll;
        this.setVisible(llllllllllllIlIlIIIIIIlllIlIIIII);
    }
    
    public void setIncrement(final float llllllllllllIlIlIIIIIIllIIllllll) {
        this.increment = llllllllllllIlIlIIIIIIllIIllllll;
    }
    
    public NumberSetting(final String llllllllllllIlIlIIIIIIllIlllIIll, final String llllllllllllIlIlIIIIIIllIlllIIlI, final float llllllllllllIlIlIIIIIIllIllllIlI, final float llllllllllllIlIlIIIIIIllIlllIIII, final float llllllllllllIlIlIIIIIIllIllIllll, final float llllllllllllIlIlIIIIIIllIlllIlll, final Supplier<Boolean> llllllllllllIlIlIIIIIIllIllIllIl, final NumberType llllllllllllIlIlIIIIIIllIlllIlIl) {
        this.name = llllllllllllIlIlIIIIIIllIlllIIll;
        this.desc = llllllllllllIlIlIIIIIIllIlllIIlI;
        this.minimum = llllllllllllIlIlIIIIIIllIlllIIII;
        this.current = llllllllllllIlIlIIIIIIllIllllIlI;
        this.maximum = llllllllllllIlIlIIIIIIllIllIllll;
        this.increment = llllllllllllIlIlIIIIIIllIlllIlll;
        this.type = llllllllllllIlIlIIIIIIllIlllIlIl;
        this.setVisible(llllllllllllIlIlIIIIIIllIllIllIl);
    }
    
    public String getDesc() {
        return this.desc;
    }
    
    public void setMaxValue(final float llllllllllllIlIlIIIIIIllIlIlIIll) {
        this.maximum = llllllllllllIlIlIIIIIIllIlIlIIll;
    }
    
    public void setMinValue(final float llllllllllllIlIlIIIIIIllIlIlllII) {
        this.minimum = llllllllllllIlIlIIIIIIllIlIlllII;
    }
    
    public float getNumberValue() {
        return this.current;
    }
    
    public NumberSetting(final String llllllllllllIlIlIIIIIIlllIllllII, final float llllllllllllIlIlIIIIIIlllIlllIll, final float llllllllllllIlIlIIIIIIlllIlllIlI, final float llllllllllllIlIlIIIIIIlllIlllIIl, final float llllllllllllIlIlIIIIIIlllIlllIII, final Supplier<Boolean> llllllllllllIlIlIIIIIIlllIllIlll) {
        this.name = llllllllllllIlIlIIIIIIlllIllllII;
        this.minimum = llllllllllllIlIlIIIIIIlllIlllIlI;
        this.current = llllllllllllIlIlIIIIIIlllIlllIll;
        this.maximum = llllllllllllIlIlIIIIIIlllIlllIIl;
        this.increment = llllllllllllIlIlIIIIIIlllIlllIII;
        this.type = NumberType.DEFAULT;
        this.setVisible(llllllllllllIlIlIIIIIIlllIllIlll);
    }
    
    public enum NumberType
    {
        DEFAULT("DEFAULT", 5, "");
        
        /* synthetic */ String name;
        
        DISTANCE("DISTANCE", 4, "Distance"), 
        MS("MS", 0, "Ms"), 
        APS("APS", 1, "Aps"), 
        SIZE("SIZE", 2, "Size"), 
        PERCENTAGE("PERCENTAGE", 3, "Percentage");
        
        private NumberType(final String llllllllllllIIIIIIIlIIlIIIIIIlII, final int llllllllllllIIIIIIIlIIlIIIIIIIll, final String llllllllllllIIIIIIIlIIlIIIIIIIlI) {
            this.name = llllllllllllIIIIIIIlIIlIIIIIIIlI;
        }
        
        public String getName() {
            return this.name;
        }
    }
}
