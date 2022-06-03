// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.main;

import net.minecraft.client.resources.ResourceIndexFolder;
import net.minecraft.client.resources.ResourceIndex;
import javax.annotation.Nullable;
import java.io.File;
import java.net.Proxy;
import net.minecraft.util.Session;
import com.mojang.authlib.properties.PropertyMap;

public class GameConfiguration
{
    public final /* synthetic */ ServerInformation serverInfo;
    public final /* synthetic */ GameInformation gameInfo;
    public final /* synthetic */ FolderInformation folderInfo;
    public final /* synthetic */ UserInformation userInfo;
    public final /* synthetic */ DisplayInformation displayInfo;
    
    public GameConfiguration(final UserInformation lllllllllllIllllIlllIIIlllIIIlll, final DisplayInformation lllllllllllIllllIlllIIIlllIIIIII, final FolderInformation lllllllllllIllllIlllIIIllIllllll, final GameInformation lllllllllllIllllIlllIIIllIlllllI, final ServerInformation lllllllllllIllllIlllIIIllIllllIl) {
        this.userInfo = lllllllllllIllllIlllIIIlllIIIlll;
        this.displayInfo = lllllllllllIllllIlllIIIlllIIIIII;
        this.folderInfo = lllllllllllIllllIlllIIIllIllllll;
        this.gameInfo = lllllllllllIllllIlllIIIllIlllllI;
        this.serverInfo = lllllllllllIllllIlllIIIllIllllIl;
    }
    
    public static class ServerInformation
    {
        public final /* synthetic */ int serverPort;
        public final /* synthetic */ String serverName;
        
        public ServerInformation(final String llllllllllllIlIIIlIIlIlIIlIIIIII, final int llllllllllllIlIIIlIIlIlIIIllllII) {
            this.serverName = llllllllllllIlIIIlIIlIlIIlIIIIII;
            this.serverPort = llllllllllllIlIIIlIIlIlIIIllllII;
        }
    }
    
    public static class UserInformation
    {
        public final /* synthetic */ PropertyMap userProperties;
        public final /* synthetic */ Session session;
        public final /* synthetic */ PropertyMap profileProperties;
        public final /* synthetic */ Proxy proxy;
        
        public UserInformation(final Session llllllllllIlllIIlIIIlIlIlIllIIII, final PropertyMap llllllllllIlllIIlIIIlIlIlIlIllll, final PropertyMap llllllllllIlllIIlIIIlIlIlIllIIll, final Proxy llllllllllIlllIIlIIIlIlIlIlIllIl) {
            this.session = llllllllllIlllIIlIIIlIlIlIllIIII;
            this.userProperties = llllllllllIlllIIlIIIlIlIlIlIllll;
            this.profileProperties = llllllllllIlllIIlIIIlIlIlIllIIll;
            this.proxy = llllllllllIlllIIlIIIlIlIlIlIllIl;
        }
    }
    
    public static class DisplayInformation
    {
        public final /* synthetic */ boolean checkGlErrors;
        public final /* synthetic */ int width;
        public final /* synthetic */ int height;
        public final /* synthetic */ boolean fullscreen;
        
        public DisplayInformation(final int llllllllllllIIIIIIIllIIIIllIIIlI, final int llllllllllllIIIIIIIllIIIIllIIIIl, final boolean llllllllllllIIIIIIIllIIIIllIIIII, final boolean llllllllllllIIIIIIIllIIIIlIlllll) {
            this.width = llllllllllllIIIIIIIllIIIIllIIIlI;
            this.height = llllllllllllIIIIIIIllIIIIllIIIIl;
            this.fullscreen = llllllllllllIIIIIIIllIIIIllIIIII;
            this.checkGlErrors = llllllllllllIIIIIIIllIIIIlIlllll;
        }
    }
    
    public static class GameInformation
    {
        public final /* synthetic */ boolean isDemo;
        public final /* synthetic */ String versionType;
        public final /* synthetic */ String version;
        
        public GameInformation(final boolean lllllllllllIlllllIIlIlIlllIlllIl, final String lllllllllllIlllllIIlIlIlllIllIII, final String lllllllllllIlllllIIlIlIlllIlIlll) {
            this.isDemo = lllllllllllIlllllIIlIlIlllIlllIl;
            this.version = lllllllllllIlllllIIlIlIlllIllIII;
            this.versionType = lllllllllllIlllllIIlIlIlllIlIlll;
        }
    }
    
    public static class FolderInformation
    {
        public final /* synthetic */ File mcDataDir;
        public final /* synthetic */ String assetIndex;
        public final /* synthetic */ File resourcePacksDir;
        public final /* synthetic */ File assetsDir;
        
        public FolderInformation(final File lllllllllllllIIlIIllIIIlllIlIlll, final File lllllllllllllIIlIIllIIIlllIlIllI, final File lllllllllllllIIlIIllIIIlllIlIlIl, @Nullable final String lllllllllllllIIlIIllIIIlllIllIIl) {
            this.mcDataDir = lllllllllllllIIlIIllIIIlllIlIlll;
            this.resourcePacksDir = lllllllllllllIIlIIllIIIlllIlIllI;
            this.assetsDir = lllllllllllllIIlIIllIIIlllIlIlIl;
            this.assetIndex = lllllllllllllIIlIIllIIIlllIllIIl;
        }
        
        public ResourceIndex getAssetsIndex() {
            return (this.assetIndex == null) ? new ResourceIndexFolder(this.assetsDir) : new ResourceIndex(this.assetsDir, this.assetIndex);
        }
    }
}
