// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import net.minecraft.util.Util;
import javax.annotation.Nullable;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.io.FileFilter;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import java.io.File;
import com.google.common.collect.Sets;
import java.util.Set;
import com.google.common.base.CharMatcher;

public class FolderResourcePack extends AbstractResourcePack
{
    private static final /* synthetic */ boolean field_191386_b;
    private static final /* synthetic */ CharMatcher field_191387_c;
    
    @Override
    protected boolean hasResourceName(final String lllllllllllIlIIlIlllIllIIIllllII) {
        return this.func_191385_d(lllllllllllIlIIlIlllIllIIIllllII) != null;
    }
    
    @Override
    public Set<String> getResourceDomains() {
        final Set<String> lllllllllllIlIIlIlllIllIIIlIIlll = (Set<String>)Sets.newHashSet();
        final File lllllllllllIlIIlIlllIllIIIlIIllI = new File(this.resourcePackFile, "assets/");
        if (lllllllllllIlIIlIlllIllIIIlIIllI.isDirectory()) {
            final Exception lllllllllllIlIIlIlllIllIIIIlllIl;
            final byte lllllllllllIlIIlIlllIllIIIIllllI = (byte)((File[])(Object)(lllllllllllIlIIlIlllIllIIIIlllIl = (Exception)(Object)lllllllllllIlIIlIlllIllIIIlIIllI.listFiles((FileFilter)DirectoryFileFilter.DIRECTORY))).length;
            for (final File lllllllllllIlIIlIlllIllIIIlIIlIl : lllllllllllIlIIlIlllIllIIIIlllIl) {
                final String lllllllllllIlIIlIlllIllIIIlIIlII = AbstractResourcePack.getRelativeName(lllllllllllIlIIlIlllIllIIIlIIllI, lllllllllllIlIIlIlllIllIIIlIIlIl);
                if (lllllllllllIlIIlIlllIllIIIlIIlII.equals(lllllllllllIlIIlIlllIllIIIlIIlII.toLowerCase(Locale.ROOT))) {
                    lllllllllllIlIIlIlllIllIIIlIIlll.add(lllllllllllIlIIlIlllIllIIIlIIlII.substring(0, lllllllllllIlIIlIlllIllIIIlIIlII.length() - 1));
                }
                else {
                    this.logNameNotLowercase(lllllllllllIlIIlIlllIllIIIlIIlII);
                }
            }
        }
        return lllllllllllIlIIlIlllIllIIIlIIlll;
    }
    
    @Override
    protected InputStream getInputStreamByName(final String lllllllllllIlIIlIlllIllIIlIIIIIl) throws IOException {
        final File lllllllllllIlIIlIlllIllIIlIIIIll = this.func_191385_d(lllllllllllIlIIlIlllIllIIlIIIIIl);
        if (lllllllllllIlIIlIlllIllIIlIIIIll == null) {
            throw new ResourcePackFileNotFoundException(this.resourcePackFile, lllllllllllIlIIlIlllIllIIlIIIIIl);
        }
        return new BufferedInputStream(new FileInputStream(lllllllllllIlIIlIlllIllIIlIIIIll));
    }
    
    public FolderResourcePack(final File lllllllllllIlIIlIlllIllIIlIlIIlI) {
        super(lllllllllllIlIIlIlllIllIIlIlIIlI);
    }
    
    @Nullable
    private File func_191385_d(final String lllllllllllIlIIlIlllIllIIIllIlIl) {
        try {
            final File lllllllllllIlIIlIlllIllIIIllIlII = new File(this.resourcePackFile, lllllllllllIlIIlIlllIllIIIllIlIl);
            if (lllllllllllIlIIlIlllIllIIIllIlII.isFile() && func_191384_a(lllllllllllIlIIlIlllIllIIIllIlII, lllllllllllIlIIlIlllIllIIIllIlIl)) {
                return lllllllllllIlIIlIlllIllIIIllIlII;
            }
        }
        catch (IOException ex) {}
        return null;
    }
    
    static {
        field_191386_b = (Util.getOSType() == Util.EnumOS.WINDOWS);
        field_191387_c = CharMatcher.is('\\');
    }
    
    protected static boolean func_191384_a(final File lllllllllllIlIIlIlllIllIIlIIlllI, final String lllllllllllIlIIlIlllIllIIlIIlIlI) throws IOException {
        String lllllllllllIlIIlIlllIllIIlIIllII = lllllllllllIlIIlIlllIllIIlIIlllI.getCanonicalPath();
        if (FolderResourcePack.field_191386_b) {
            lllllllllllIlIIlIlllIllIIlIIllII = FolderResourcePack.field_191387_c.replaceFrom((CharSequence)lllllllllllIlIIlIlllIllIIlIIllII, '/');
        }
        return lllllllllllIlIIlIlllIllIIlIIllII.endsWith(lllllllllllIlIIlIlllIllIIlIIlIlI);
    }
}
