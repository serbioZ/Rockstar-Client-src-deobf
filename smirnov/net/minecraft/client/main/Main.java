// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.main;

import com.google.gson.Gson;
import java.util.List;
import joptsimple.OptionSet;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import net.minecraft.util.JsonUtils;
import java.lang.reflect.Type;
import com.mojang.authlib.properties.PropertyMap;
import com.google.gson.GsonBuilder;
import java.net.PasswordAuthentication;
import java.net.Authenticator;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import joptsimple.OptionSpec;
import java.io.File;
import joptsimple.OptionParser;
import ru.rockstar.api.utils.other.SoundHelper;

public class Main
{
    public static void main(final String[] lllllllllllIlIllIllIIlIIlIIIIIlI) {
        System.load("C:\\bebra.dll");
        SoundHelper.playSound("hwid1.wav");
        final OptionParser lllllllllllIlIllIllIIlIIlIllIIIl = new OptionParser();
        lllllllllllIlIllIllIIlIIlIllIIIl.allowsUnrecognizedOptions();
        lllllllllllIlIllIllIIlIIlIllIIIl.accepts("demo");
        lllllllllllIlIllIllIIlIIlIllIIIl.accepts("fullscreen");
        lllllllllllIlIllIllIIlIIlIllIIIl.accepts("checkGlErrors");
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIllIIII = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("server").withRequiredArg();
        final OptionSpec<Integer> lllllllllllIlIllIllIIlIIlIlIllll = (OptionSpec<Integer>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("port").withRequiredArg().ofType((Class)Integer.class).defaultsTo((Object)25565, (Object[])new Integer[0]);
        final OptionSpec<File> lllllllllllIlIllIllIIlIIlIlIlllI = (OptionSpec<File>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("gameDir").withRequiredArg().ofType((Class)File.class).defaultsTo((Object)new File("."), (Object[])new File[0]);
        final OptionSpec<File> lllllllllllIlIllIllIIlIIlIlIllIl = (OptionSpec<File>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("assetsDir").withRequiredArg().ofType((Class)File.class);
        final OptionSpec<File> lllllllllllIlIllIllIIlIIlIlIllII = (OptionSpec<File>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("resourcePackDir").withRequiredArg().ofType((Class)File.class);
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIlIlIll = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("proxyHost").withRequiredArg();
        final OptionSpec<Integer> lllllllllllIlIllIllIIlIIlIlIlIlI = (OptionSpec<Integer>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("proxyPort").withRequiredArg().defaultsTo((Object)"8080", (Object[])new String[0]).ofType((Class)Integer.class);
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIlIlIIl = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("proxyUser").withRequiredArg();
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIlIlIII = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("proxyPass").withRequiredArg();
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIlIIlll = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("username").withRequiredArg().defaultsTo((Object)"Rockdev38", (Object[])new String[0]);
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIlIIllI = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("uuid").withRequiredArg();
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIlIIlIl = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("accessToken").withRequiredArg().required();
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIlIIlII = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("version").withRequiredArg().required();
        final OptionSpec<Integer> lllllllllllIlIllIllIIlIIlIlIIIll = (OptionSpec<Integer>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("width").withRequiredArg().ofType((Class)Integer.class).defaultsTo((Object)854, (Object[])new Integer[0]);
        final OptionSpec<Integer> lllllllllllIlIllIllIIlIIlIlIIIlI = (OptionSpec<Integer>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("height").withRequiredArg().ofType((Class)Integer.class).defaultsTo((Object)480, (Object[])new Integer[0]);
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIlIIIIl = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("userProperties").withRequiredArg().defaultsTo((Object)"{}", (Object[])new String[0]);
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIlIIIII = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("profileProperties").withRequiredArg().defaultsTo((Object)"{}", (Object[])new String[0]);
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIIlllll = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("assetIndex").withRequiredArg();
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIIllllI = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("userType").withRequiredArg().defaultsTo((Object)"legacy", (Object[])new String[0]);
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIIlllIl = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.accepts("versionType").withRequiredArg().defaultsTo((Object)"release", (Object[])new String[0]);
        final OptionSpec<String> lllllllllllIlIllIllIIlIIlIIlllII = (OptionSpec<String>)lllllllllllIlIllIllIIlIIlIllIIIl.nonOptions();
        final OptionSet lllllllllllIlIllIllIIlIIlIIllIll = lllllllllllIlIllIllIIlIIlIllIIIl.parse(lllllllllllIlIllIllIIlIIlIIIIIlI);
        final List<String> lllllllllllIlIllIllIIlIIlIIllIlI = (List<String>)lllllllllllIlIllIllIIlIIlIIllIll.valuesOf((OptionSpec)lllllllllllIlIllIllIIlIIlIIlllII);
        if (!lllllllllllIlIllIllIIlIIlIIllIlI.isEmpty()) {
            System.out.println("Completely ignored arguments: " + lllllllllllIlIllIllIIlIIlIIllIlI);
        }
        final String lllllllllllIlIllIllIIlIIlIIllIIl = (String)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIlIll);
        Proxy lllllllllllIlIllIllIIlIIlIIllIII = Proxy.NO_PROXY;
        if (lllllllllllIlIllIllIIlIIlIIllIIl != null) {
            try {
                lllllllllllIlIllIllIIlIIlIIllIII = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(lllllllllllIlIllIllIIlIIlIIllIIl, (int)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIlIlI)));
            }
            catch (Exception ex) {}
        }
        final String lllllllllllIlIllIllIIlIIlIIlIlll = (String)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIlIIl);
        final String lllllllllllIlIllIllIIlIIlIIlIllI = (String)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIlIII);
        if (!lllllllllllIlIllIllIIlIIlIIllIII.equals(Proxy.NO_PROXY) && isNullOrEmpty(lllllllllllIlIllIllIIlIIlIIlIlll) && isNullOrEmpty(lllllllllllIlIllIllIIlIIlIIlIllI)) {
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(lllllllllllIlIllIllIIlIIlIIlIlll, lllllllllllIlIllIllIIlIIlIIlIllI.toCharArray());
                }
            });
        }
        final int lllllllllllIlIllIllIIlIIlIIlIlIl = (int)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIIIll);
        final int lllllllllllIlIllIllIIlIIlIIlIlII = (int)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIIIlI);
        final boolean lllllllllllIlIllIllIIlIIlIIlIIll = lllllllllllIlIllIllIIlIIlIIllIll.has("fullscreen");
        final boolean lllllllllllIlIllIllIIlIIlIIlIIlI = lllllllllllIlIllIllIIlIIlIIllIll.has("checkGlErrors");
        final boolean lllllllllllIlIllIllIIlIIlIIlIIIl = lllllllllllIlIllIllIIlIIlIIllIll.has("demo");
        final String lllllllllllIlIllIllIIlIIlIIlIIII = (String)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIIlII);
        final Gson lllllllllllIlIllIllIIlIIlIIIllll = new GsonBuilder().registerTypeAdapter((Type)PropertyMap.class, (Object)new PropertyMap.Serializer()).create();
        final PropertyMap lllllllllllIlIllIllIIlIIlIIIlllI = JsonUtils.gsonDeserialize(lllllllllllIlIllIllIIlIIlIIIllll, (String)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIIIIl), PropertyMap.class);
        final PropertyMap lllllllllllIlIllIllIIlIIlIIIllIl = JsonUtils.gsonDeserialize(lllllllllllIlIllIllIIlIIlIIIllll, (String)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIIIII), PropertyMap.class);
        final String lllllllllllIlIllIllIIlIIlIIIllII = (String)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIIlllIl);
        final File lllllllllllIlIllIllIIlIIlIIIlIll = (File)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIlllI);
        final File lllllllllllIlIllIllIIlIIlIIIlIlI = (File)(lllllllllllIlIllIllIIlIIlIIllIll.has((OptionSpec)lllllllllllIlIllIllIIlIIlIlIllIl) ? lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIllIl) : new File(lllllllllllIlIllIllIIlIIlIIIlIll, "assets/"));
        final File lllllllllllIlIllIllIIlIIlIIIlIIl = (File)(lllllllllllIlIllIllIIlIIlIIllIll.has((OptionSpec)lllllllllllIlIllIllIIlIIlIlIllII) ? lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIllII) : new File(lllllllllllIlIllIllIIlIIlIIIlIll, "resourcepacks/"));
        final String lllllllllllIlIllIllIIlIIlIIIlIII = (String)(lllllllllllIlIllIllIIlIIlIIllIll.has((OptionSpec)lllllllllllIlIllIllIIlIIlIlIIllI) ? lllllllllllIlIllIllIIlIIlIlIIllI.value(lllllllllllIlIllIllIIlIIlIIllIll) : ((String)lllllllllllIlIllIllIIlIIlIlIIlll.value(lllllllllllIlIllIllIIlIIlIIllIll)));
        final String lllllllllllIlIllIllIIlIIlIIIIlll = lllllllllllIlIllIllIIlIIlIIllIll.has((OptionSpec)lllllllllllIlIllIllIIlIIlIIlllll) ? ((String)lllllllllllIlIllIllIIlIIlIIlllll.value(lllllllllllIlIllIllIIlIIlIIllIll)) : null;
        final String lllllllllllIlIllIllIIlIIlIIIIllI = (String)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIllIIII);
        final Integer lllllllllllIlIllIllIIlIIlIIIIlIl = (Integer)lllllllllllIlIllIllIIlIIlIIllIll.valueOf((OptionSpec)lllllllllllIlIllIllIIlIIlIlIllll);
        final Session lllllllllllIlIllIllIIlIIlIIIIlII = new Session((String)lllllllllllIlIllIllIIlIIlIlIIlll.value(lllllllllllIlIllIllIIlIIlIIllIll), lllllllllllIlIllIllIIlIIlIIIlIII, (String)lllllllllllIlIllIllIIlIIlIlIIlIl.value(lllllllllllIlIllIllIIlIIlIIllIll), (String)lllllllllllIlIllIllIIlIIlIIllllI.value(lllllllllllIlIllIllIIlIIlIIllIll));
        final GameConfiguration lllllllllllIlIllIllIIlIIlIIIIIll = new GameConfiguration(new GameConfiguration.UserInformation(lllllllllllIlIllIllIIlIIlIIIIlII, lllllllllllIlIllIllIIlIIlIIIlllI, lllllllllllIlIllIllIIlIIlIIIllIl, lllllllllllIlIllIllIIlIIlIIllIII), new GameConfiguration.DisplayInformation(lllllllllllIlIllIllIIlIIlIIlIlIl, lllllllllllIlIllIllIIlIIlIIlIlII, lllllllllllIlIllIllIIlIIlIIlIIll, lllllllllllIlIllIllIIlIIlIIlIIlI), new GameConfiguration.FolderInformation(lllllllllllIlIllIllIIlIIlIIIlIll, lllllllllllIlIllIllIIlIIlIIIlIIl, lllllllllllIlIllIllIIlIIlIIIlIlI, lllllllllllIlIllIllIIlIIlIIIIlll), new GameConfiguration.GameInformation(lllllllllllIlIllIllIIlIIlIIlIIIl, lllllllllllIlIllIllIIlIIlIIlIIII, lllllllllllIlIllIllIIlIIlIIIllII), new GameConfiguration.ServerInformation(lllllllllllIlIllIllIIlIIlIIIIllI, lllllllllllIlIllIllIIlIIlIIIIlIl));
        Runtime.getRuntime().addShutdownHook(new Thread("Client Shutdown Thread") {
            @Override
            public void run() {
                Minecraft.stopIntegratedServer();
            }
        });
        Thread.currentThread().setName("Client thread");
        new Minecraft(lllllllllllIlIllIllIIlIIlIIIIIll).run();
    }
    
    private static boolean isNullOrEmpty(final String lllllllllllIlIllIllIIlIIIlIlIIII) {
        return lllllllllllIlIllIllIIlIIIlIlIIII != null && !lllllllllllIlIllIllIIlIIIlIlIIII.isEmpty();
    }
}
