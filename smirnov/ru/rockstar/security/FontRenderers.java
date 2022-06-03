// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.security;

import java.util.Arrays;
import java.awt.datatransfer.Clipboard;
import java.io.IOException;
import javax.swing.UIManager;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import ru.rockstar.api.utils.other.SoundHelper;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import net.minecraft.client.Minecraft;

public class FontRenderers
{
    static /* synthetic */ String h;
    private static /* synthetic */ Minecraft mc;
    public static /* synthetic */ boolean currectVersion;
    static /* synthetic */ String username;
    public static /* synthetic */ String status;
    
    public static void neverlose_500() {
        try {
            if (CFonts.isInternetAvailable()) {
                try {
                    final HttpsURLConnection lllllllllllIllIllIIlIIlIIllIIIII = (HttpsURLConnection)new URL("https://www.rockstarclient.xyz/hwid/" + FontRenderers.h).openConnection();
                    lllllllllllIllIllIIlIIlIIllIIIII.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36");
                    final BufferedReader lllllllllllIllIllIIlIIlIIlIlllll = new BufferedReader(new InputStreamReader(lllllllllllIllIllIIlIIlIIllIIIII.getInputStream()));
                    final String lllllllllllIllIllIIlIIlIIlIllllI = lllllllllllIllIllIIlIIlIIlIlllll.readLine();
                    if (lllllllllllIllIllIIlIIlIIlIllllI != null && lllllllllllIllIllIIlIIlIIlIllllI.equals("1") && FontRenderers.currectVersion) {
                        FontRenderers.status = "User";
                        SoundHelper.playSound("hwid2.wav");
                    }
                    else if (lllllllllllIllIllIIlIIlIIlIllllI != null && lllllllllllIllIllIIlIIlIIlIllllI.equals("2")) {
                        FontRenderers.status = "BetaUser";
                        SoundHelper.playSound("hwid2.wav");
                    }
                    else if (lllllllllllIllIllIIlIIlIIlIllllI != null && lllllllllllIllIllIIlIIlIIlIllllI.equals("3")) {
                        FontRenderers.status = "YouTuber";
                        SoundHelper.playSound("hwid2.wav");
                    }
                    else if (lllllllllllIllIllIIlIIlIIlIllllI != null && lllllllllllIllIllIIlIIlIIlIllllI.equals("4")) {
                        FontRenderers.status = "Moderator";
                        SoundHelper.playSound("hwid2.wav");
                    }
                    else if (lllllllllllIllIllIIlIIlIIlIllllI != null && lllllllllllIllIllIIlIIlIIlIllllI.equals("5")) {
                        FontRenderers.status = "Developer";
                        SoundHelper.playSound("hwid2.wav");
                    }
                    else {
                        SoundHelper.playSound("hwid1.wav");
                        final StringSelection lllllllllllIllIllIIlIIlIIlIlllIl = new StringSelection(FontRenderers.h);
                        final Clipboard lllllllllllIllIllIIlIIlIIlIlllII = Toolkit.getDefaultToolkit().getSystemClipboard();
                        lllllllllllIllIllIIlIIlIIlIlllII.setContents(lllllllllllIllIllIIlIIlIIlIlllIl, null);
                        Minecraft.getMinecraft().shutdown();
                    }
                }
                catch (Exception lllllllllllIllIllIIlIIlIIlIllIll) {
                    SoundHelper.playSound("hwid1.wav");
                    final StringSelection lllllllllllIllIllIIlIIlIIlIllIlI = new StringSelection(FontRenderers.h);
                    final Clipboard lllllllllllIllIllIIlIIlIIlIllIIl = Toolkit.getDefaultToolkit().getSystemClipboard();
                    lllllllllllIllIllIIlIIlIIlIllIIl.setContents(lllllllllllIllIllIIlIIlIIlIllIlI, null);
                    Minecraft.getMinecraft().shutdown();
                }
            }
            else {
                SoundHelper.playSound("hwid1.wav");
                final StringSelection lllllllllllIllIllIIlIIlIIlIllIII = new StringSelection(FontRenderers.h);
                final Clipboard lllllllllllIllIllIIlIIlIIlIlIlll = Toolkit.getDefaultToolkit().getSystemClipboard();
                lllllllllllIllIllIIlIIlIIlIlIlll.setContents(lllllllllllIllIllIIlIIlIIlIllIII, null);
                Minecraft.getMinecraft().shutdown();
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                catch (Exception lllllllllllIllIllIIlIIlIIlIlIllI) {
                    lllllllllllIllIllIIlIIlIIlIlIllI.printStackTrace();
                }
                lllllllllllIllIllIIlIIlIIlIlIlll.setContents(lllllllllllIllIllIIlIIlIIlIllIII, null);
            }
        }
        catch (IOException lllllllllllIllIllIIlIIlIIlIlIlIl) {
            lllllllllllIllIllIIlIIlIIlIlIlIl.printStackTrace();
        }
    }
    
    public static void neverlose_500_18() {
        try {
            if (CFonts.isInternetAvailable()) {
                try {
                    final HttpsURLConnection lllllllllllIllIllIIlIIlIIllIlllI = (HttpsURLConnection)new URL("https://www.rockstarclient.xyz/version").openConnection();
                    lllllllllllIllIllIIlIIlIIllIlllI.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36");
                    final BufferedReader lllllllllllIllIllIIlIIlIIllIllIl = new BufferedReader(new InputStreamReader(lllllllllllIllIllIIlIIlIIllIlllI.getInputStream()));
                    final String lllllllllllIllIllIIlIIlIIllIllII = lllllllllllIllIllIIlIIlIIllIllIl.readLine();
                    if (lllllllllllIllIllIIlIIlIIllIllII != null && lllllllllllIllIllIIlIIlIIllIllII.equals("2.0.1")) {
                        FontRenderers.currectVersion = true;
                    }
                    else {
                        Minecraft.getMinecraft().shutdown();
                        FontRenderers.currectVersion = false;
                    }
                }
                catch (Exception lllllllllllIllIllIIlIIlIIllIlIll) {
                    Minecraft.getMinecraft().shutdown();
                    FontRenderers.currectVersion = false;
                }
            }
            else {
                Minecraft.getMinecraft().shutdown();
                FontRenderers.currectVersion = false;
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                catch (Exception lllllllllllIllIllIIlIIlIIllIlIlI) {
                    lllllllllllIllIllIIlIIlIIllIlIlI.printStackTrace();
                }
            }
        }
        catch (IOException lllllllllllIllIllIIlIIlIIllIlIIl) {
            lllllllllllIllIllIIlIIlIIllIlIIl.printStackTrace();
        }
    }
    
    static {
        FontRenderers.mc = Minecraft.getMinecraft();
        FontRenderers.h = Fonts.hashInput("SHA-1", Arrays.toString(CFont.generateHWID()));
        FontRenderers.username = System.getProperty("user.name");
        FontRenderers.status = null;
        FontRenderers.currectVersion = false;
    }
}
