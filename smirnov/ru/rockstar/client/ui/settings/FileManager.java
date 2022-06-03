// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings;

import java.util.Iterator;
import ru.rockstar.Main;
import ru.rockstar.client.ui.HudConfig;
import ru.rockstar.client.ui.altmanager.alt.AltConfig;
import ru.rockstar.client.ui.settings.impls.MacroConfig;
import ru.rockstar.client.ui.settings.impls.FriendConfig;
import java.util.ArrayList;
import java.io.File;

public class FileManager
{
    public static /* synthetic */ File directory;
    public static /* synthetic */ ArrayList<CustomFile> files;
    
    public FileManager() {
        FileManager.files.add(new FriendConfig("FriendConfig", true));
        FileManager.files.add(new MacroConfig("MacroConfig", true));
        FileManager.files.add(new AltConfig("AltConfig", true));
        FileManager.files.add(new HudConfig("HudConfig", true));
    }
    
    static {
        FileManager.directory = new File(Main.instance.name);
        FileManager.files = new ArrayList<CustomFile>();
    }
    
    public void loadFiles() {
        for (final CustomFile llllllllllllIIIIlIllllIlllIIlIll : FileManager.files) {
            try {
                if (!llllllllllllIIIIlIllllIlllIIlIll.loadOnStart()) {
                    continue;
                }
                llllllllllllIIIIlIllllIlllIIlIll.loadFile();
            }
            catch (Exception llllllllllllIIIIlIllllIlllIIlIlI) {
                llllllllllllIIIIlIllllIlllIIlIlI.printStackTrace();
            }
        }
    }
    
    public CustomFile getFile(final Class<?> llllllllllllIIIIlIllllIllIlllIlI) {
        for (final CustomFile llllllllllllIIIIlIllllIllIlllIII : FileManager.files) {
            if (llllllllllllIIIIlIllllIllIlllIII.getClass() == llllllllllllIIIIlIllllIllIlllIlI) {
                return llllllllllllIIIIlIllllIllIlllIII;
            }
        }
        return null;
    }
    
    public void saveFiles() {
        for (final CustomFile llllllllllllIIIIlIllllIlllIIIIlI : FileManager.files) {
            try {
                llllllllllllIIIIlIllllIlllIIIIlI.saveFile();
            }
            catch (Exception ex) {}
        }
    }
    
    public abstract static class CustomFile
    {
        private final /* synthetic */ File file;
        private final /* synthetic */ boolean load;
        private final /* synthetic */ String name;
        
        public CustomFile(final String lllllllllllIIlIlIlIlIIIIIlIIlIII, final boolean lllllllllllIIlIlIlIlIIIIIlIIIlll) {
            this.name = lllllllllllIIlIlIlIlIIIIIlIIlIII;
            this.load = lllllllllllIIlIlIlIlIIIIIlIIIlll;
            this.file = new File(FileManager.directory, String.valueOf(lllllllllllIIlIlIlIlIIIIIlIIlIII) + ".json");
            if (!this.file.exists()) {
                try {
                    this.saveFile();
                }
                catch (Exception ex) {}
            }
        }
        
        public abstract void saveFile() throws Exception;
        
        public abstract void loadFile() throws Exception;
        
        public final String getName() {
            return this.name;
        }
        
        private boolean loadOnStart() {
            return this.load;
        }
        
        public final File getFile() {
            return this.file;
        }
    }
}
