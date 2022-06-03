// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

public class Language implements Comparable<Language>
{
    private final /* synthetic */ String name;
    private final /* synthetic */ String region;
    private final /* synthetic */ String languageCode;
    private final /* synthetic */ boolean bidirectional;
    
    @Override
    public int hashCode() {
        return this.languageCode.hashCode();
    }
    
    public String getLanguageCode() {
        return this.languageCode;
    }
    
    @Override
    public boolean equals(final Object lllllllllllIIIlllIIIlIllIIlIIllI) {
        return this == lllllllllllIIIlllIIIlIllIIlIIllI || (lllllllllllIIIlllIIIlIllIIlIIllI instanceof Language && this.languageCode.equals(((Language)lllllllllllIIIlllIIIlIllIIlIIllI).languageCode));
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s)", this.name, this.region);
    }
    
    @Override
    public int compareTo(final Language lllllllllllIIIlllIIIlIllIIIlllll) {
        return this.languageCode.compareTo(lllllllllllIIIlllIIIlIllIIIlllll.languageCode);
    }
    
    public boolean isBidirectional() {
        return this.bidirectional;
    }
    
    public Language(final String lllllllllllIIIlllIIIlIllIIllllIl, final String lllllllllllIIIlllIIIlIllIIllIlll, final String lllllllllllIIIlllIIIlIllIIllIllI, final boolean lllllllllllIIIlllIIIlIllIIllIlIl) {
        this.languageCode = lllllllllllIIIlllIIIlIllIIllllIl;
        this.region = lllllllllllIIIlllIIIlIllIIllIlll;
        this.name = lllllllllllIIIlllIIIlIllIIllIllI;
        this.bidirectional = lllllllllllIIIlllIIIlIllIIllIlIl;
    }
}
