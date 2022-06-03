// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import paulscode.sound.Source;
import paulscode.sound.SoundSystem;
import com.google.common.collect.Sets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.MarkerManager;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Random;
import net.minecraft.util.math.MathHelper;
import io.netty.util.internal.ThreadLocalRandom;
import java.util.Iterator;
import net.minecraft.util.SoundEvent;
import paulscode.sound.SoundSystemLogger;
import java.net.MalformedURLException;
import net.minecraft.client.Minecraft;
import java.io.InputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URL;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.util.SoundCategory;
import com.google.common.collect.Multimap;
import net.minecraft.client.settings.GameSettings;
import org.apache.logging.log4j.Marker;
import net.minecraft.util.ResourceLocation;
import java.util.Set;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Map;

public class SoundManager
{
    private final /* synthetic */ Map<String, ISound> playingSounds;
    private /* synthetic */ SoundSystemStarterThread sndSystem;
    private final /* synthetic */ List<ITickableSound> tickableSounds;
    private /* synthetic */ boolean loaded;
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ Set<ResourceLocation> UNABLE_TO_PLAY;
    private final /* synthetic */ Map<String, Integer> playingSoundsStopTime;
    private static final /* synthetic */ Marker LOG_MARKER;
    private /* synthetic */ int playTime;
    private final /* synthetic */ GameSettings options;
    private final /* synthetic */ List<String> pausedChannels;
    private final /* synthetic */ Map<ISound, String> invPlayingSounds;
    private final /* synthetic */ List<ISoundEventListener> listeners;
    private final /* synthetic */ Map<ISound, Integer> delayedSounds;
    private final /* synthetic */ Multimap<SoundCategory, String> categorySounds;
    private final /* synthetic */ SoundHandler sndHandler;
    
    public SoundManager(final SoundHandler lllllllllllIlIlIlIIIIlIIllIlIlll, final GameSettings lllllllllllIlIlIlIIIIlIIllIllIlI) {
        this.playingSounds = (Map<String, ISound>)HashBiMap.create();
        this.invPlayingSounds = (Map<ISound, String>)((BiMap)this.playingSounds).inverse();
        this.categorySounds = (Multimap<SoundCategory, String>)HashMultimap.create();
        this.tickableSounds = (List<ITickableSound>)Lists.newArrayList();
        this.delayedSounds = (Map<ISound, Integer>)Maps.newHashMap();
        this.playingSoundsStopTime = (Map<String, Integer>)Maps.newHashMap();
        this.listeners = (List<ISoundEventListener>)Lists.newArrayList();
        this.pausedChannels = (List<String>)Lists.newArrayList();
        this.sndHandler = lllllllllllIlIlIlIIIIlIIllIlIlll;
        this.options = lllllllllllIlIlIlIIIIlIIllIllIlI;
        try {
            SoundSystemConfig.addLibrary((Class)LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", (Class)CodecJOrbis.class);
        }
        catch (SoundSystemException lllllllllllIlIlIlIIIIlIIllIllIIl) {
            SoundManager.LOGGER.error(SoundManager.LOG_MARKER, "Error linking with the LibraryJavaSound plug-in", (Throwable)lllllllllllIlIlIlIIIIlIIllIllIIl);
        }
    }
    
    public boolean isSoundPlaying(final ISound lllllllllllIlIlIlIIIIlIIIllIllll) {
        if (!this.loaded) {
            return false;
        }
        final String lllllllllllIlIlIlIIIIlIIIlllIIIl = this.invPlayingSounds.get(lllllllllllIlIlIlIIIIlIIIllIllll);
        return lllllllllllIlIlIlIIIIlIIIlllIIIl != null && (this.sndSystem.playing(lllllllllllIlIlIlIIIIlIIIlllIIIl) || (this.playingSoundsStopTime.containsKey(lllllllllllIlIlIlIIIIlIIIlllIIIl) && this.playingSoundsStopTime.get(lllllllllllIlIlIlIIIIlIIIlllIIIl) <= this.playTime));
    }
    
    private static URL getURLForSoundResource(final ResourceLocation lllllllllllIlIlIlIIIIlIIIIIIllll) {
        final String lllllllllllIlIlIlIIIIlIIIIIIlllI = String.format("%s:%s:%s", "mcsounddomain", lllllllllllIlIlIlIIIIlIIIIIIllll.getResourceDomain(), lllllllllllIlIlIlIIIIlIIIIIIllll.getResourcePath());
        final URLStreamHandler lllllllllllIlIlIlIIIIlIIIIIIllIl = new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(final URL llllllllllllllllIIlIIIIIlIllIlIl) {
                return new URLConnection(llllllllllllllllIIlIIIIIlIllIlIl) {
                    @Override
                    public void connect() throws IOException {
                    }
                    
                    @Override
                    public InputStream getInputStream() throws IOException {
                        return Minecraft.getMinecraft().getResourceManager().getResource(lllllllllllIlIlIlIIIIlIIIIIIllll).getInputStream();
                    }
                };
            }
        };
        try {
            return new URL(null, lllllllllllIlIlIlIIIIlIIIIIIlllI, lllllllllllIlIlIlIIIIlIIIIIIllIl);
        }
        catch (MalformedURLException lllllllllllIlIlIlIIIIlIIIIIIllII) {
            throw new Error("TODO: Sanely handle url exception! :D");
        }
    }
    
    static /* synthetic */ void access$2(final SoundManager lllllllllllIlIlIlIIIIIlllIlllIIl, final boolean lllllllllllIlIlIlIIIIIlllIlllIII) {
        lllllllllllIlIlIlIIIIIlllIlllIIl.loaded = lllllllllllIlIlIlIIIIIlllIlllIII;
    }
    
    public void setVolume(final SoundCategory lllllllllllIlIlIlIIIIlIIlIlIllll, final float lllllllllllIlIlIlIIIIlIIlIlIlllI) {
        if (this.loaded) {
            if (lllllllllllIlIlIlIIIIlIIlIlIllll == SoundCategory.MASTER) {
                this.sndSystem.setMasterVolume(lllllllllllIlIlIlIIIIlIIlIlIlllI);
            }
            else {
                for (final String lllllllllllIlIlIlIIIIlIIlIllIIll : this.categorySounds.get((Object)lllllllllllIlIlIlIIIIlIIlIlIllll)) {
                    final ISound lllllllllllIlIlIlIIIIlIIlIllIIlI = this.playingSounds.get(lllllllllllIlIlIlIIIIlIIlIllIIll);
                    final float lllllllllllIlIlIlIIIIlIIlIllIIIl = this.getClampedVolume(lllllllllllIlIlIlIIIIlIIlIllIIlI);
                    if (lllllllllllIlIlIlIIIIlIIlIllIIIl <= 0.0f) {
                        this.stopSound(lllllllllllIlIlIlIIIIlIIlIllIIlI);
                    }
                    else {
                        this.sndSystem.setVolume(lllllllllllIlIlIlIIIIlIIlIllIIll, lllllllllllIlIlIlIIIIlIIlIllIIIl);
                    }
                }
            }
        }
    }
    
    static /* synthetic */ void access$1(final SoundManager lllllllllllIlIlIlIIIIIlllIllllIl, final SoundSystemStarterThread lllllllllllIlIlIlIIIIIlllIllllII) {
        lllllllllllIlIlIlIIIIIlllIllllIl.sndSystem = lllllllllllIlIlIlIIIIIlllIllllII;
    }
    
    private synchronized void loadSoundSystem() {
        if (!this.loaded) {
            try {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SoundSystemConfig.setLogger((SoundSystemLogger)new SoundSystemLogger() {
                            public void message(final String llllllllllllllIlllllIllIlIlIlIII, final int llllllllllllllIlllllIllIlIlIlIIl) {
                                if (!llllllllllllllIlllllIllIlIlIlIII.isEmpty()) {
                                    SoundManager.LOGGER.info(llllllllllllllIlllllIllIlIlIlIII);
                                }
                            }
                            
                            public void errorMessage(final String llllllllllllllIlllllIllIlIIlllll, final String llllllllllllllIlllllIllIlIIllIll, final int llllllllllllllIlllllIllIlIIlllIl) {
                                if (!llllllllllllllIlllllIllIlIIllIll.isEmpty()) {
                                    SoundManager.LOGGER.error("Error in class '{}'", (Object)llllllllllllllIlllllIllIlIIlllll);
                                    SoundManager.LOGGER.error(llllllllllllllIlllllIllIlIIllIll);
                                }
                            }
                            
                            public void importantMessage(final String llllllllllllllIlllllIllIlIlIIlIl, final int llllllllllllllIlllllIllIlIlIIlII) {
                                if (!llllllllllllllIlllllIllIlIlIIlIl.isEmpty()) {
                                    SoundManager.LOGGER.warn(llllllllllllllIlllllIllIlIlIIlIl);
                                }
                            }
                        });
                        SoundManager.access$1(SoundManager.this, new SoundSystemStarterThread((SoundSystemStarterThread)null));
                        SoundManager.access$2(SoundManager.this, true);
                        SoundManager.this.sndSystem.setMasterVolume(SoundManager.this.options.getSoundLevel(SoundCategory.MASTER));
                        SoundManager.LOGGER.info(SoundManager.LOG_MARKER, "Sound engine started");
                    }
                }, "Sound Library Loader").start();
            }
            catch (RuntimeException lllllllllllIlIlIlIIIIlIIllIIIllI) {
                SoundManager.LOGGER.error(SoundManager.LOG_MARKER, "Error starting SoundSystem. Turning off sounds & music", (Throwable)lllllllllllIlIlIlIIIIlIIllIIIllI);
                this.options.setSoundLevel(SoundCategory.MASTER, 0.0f);
                this.options.saveOptions();
            }
        }
    }
    
    public void reloadSoundSystem() {
        SoundManager.UNABLE_TO_PLAY.clear();
        for (final SoundEvent lllllllllllIlIlIlIIIIlIIllIIllll : SoundEvent.REGISTRY) {
            final ResourceLocation lllllllllllIlIlIlIIIIlIIllIIlllI = lllllllllllIlIlIlIIIIlIIllIIllll.getSoundName();
            if (this.sndHandler.getAccessor(lllllllllllIlIlIlIIIIlIIllIIlllI) == null) {
                SoundManager.LOGGER.warn("Missing sound for event: {}", (Object)SoundEvent.REGISTRY.getNameForObject(lllllllllllIlIlIlIIIIlIIllIIllll));
                SoundManager.UNABLE_TO_PLAY.add(lllllllllllIlIlIlIIIIlIIllIIlllI);
            }
        }
        this.unloadSoundSystem();
        this.loadSoundSystem();
    }
    
    public void addListener(final ISoundEventListener lllllllllllIlIlIlIIIIlIIlIIllIIl) {
        this.listeners.add(lllllllllllIlIlIlIIIIlIIlIIllIIl);
    }
    
    public void playDelayedSound(final ISound lllllllllllIlIlIlIIIIlIIIIIllIII, final int lllllllllllIlIlIlIIIIlIIIIIlIlII) {
        this.delayedSounds.put(lllllllllllIlIlIlIIIIlIIIIIllIII, this.playTime + lllllllllllIlIlIlIIIIlIIIIIlIlII);
    }
    
    public void updateAllSounds() {
        ++this.playTime;
        for (final ITickableSound lllllllllllIlIlIlIIIIlIIlIIIlIIl : this.tickableSounds) {
            lllllllllllIlIlIlIIIIlIIlIIIlIIl.update();
            if (lllllllllllIlIlIlIIIIlIIlIIIlIIl.isDonePlaying()) {
                this.stopSound(lllllllllllIlIlIlIIIIlIIlIIIlIIl);
            }
            else {
                final String lllllllllllIlIlIlIIIIlIIlIIIlIII = this.invPlayingSounds.get(lllllllllllIlIlIlIIIIlIIlIIIlIIl);
                this.sndSystem.setVolume(lllllllllllIlIlIlIIIIlIIlIIIlIII, this.getClampedVolume(lllllllllllIlIlIlIIIIlIIlIIIlIIl));
                this.sndSystem.setPitch(lllllllllllIlIlIlIIIIlIIlIIIlIII, this.getClampedPitch(lllllllllllIlIlIlIIIIlIIlIIIlIIl));
                this.sndSystem.setPosition(lllllllllllIlIlIlIIIIlIIlIIIlIII, lllllllllllIlIlIlIIIIlIIlIIIlIIl.getXPosF(), lllllllllllIlIlIlIIIIlIIlIIIlIIl.getYPosF(), lllllllllllIlIlIlIIIIlIIlIIIlIIl.getZPosF());
            }
        }
        final Iterator<Map.Entry<String, ISound>> lllllllllllIlIlIlIIIIlIIlIIIIlll = this.playingSounds.entrySet().iterator();
        while (lllllllllllIlIlIlIIIIlIIlIIIIlll.hasNext()) {
            final Map.Entry<String, ISound> lllllllllllIlIlIlIIIIlIIlIIIIllI = lllllllllllIlIlIlIIIIlIIlIIIIlll.next();
            final String lllllllllllIlIlIlIIIIlIIlIIIIlIl = lllllllllllIlIlIlIIIIlIIlIIIIllI.getKey();
            final ISound lllllllllllIlIlIlIIIIlIIlIIIIlII = lllllllllllIlIlIlIIIIlIIlIIIIllI.getValue();
            if (!this.sndSystem.playing(lllllllllllIlIlIlIIIIlIIlIIIIlIl)) {
                final int lllllllllllIlIlIlIIIIlIIlIIIIIll = this.playingSoundsStopTime.get(lllllllllllIlIlIlIIIIlIIlIIIIlIl);
                if (lllllllllllIlIlIlIIIIlIIlIIIIIll > this.playTime) {
                    continue;
                }
                final int lllllllllllIlIlIlIIIIlIIlIIIIIlI = lllllllllllIlIlIlIIIIlIIlIIIIlII.getRepeatDelay();
                if (lllllllllllIlIlIlIIIIlIIlIIIIlII.canRepeat() && lllllllllllIlIlIlIIIIlIIlIIIIIlI > 0) {
                    this.delayedSounds.put(lllllllllllIlIlIlIIIIlIIlIIIIlII, this.playTime + lllllllllllIlIlIlIIIIlIIlIIIIIlI);
                }
                lllllllllllIlIlIlIIIIlIIlIIIIlll.remove();
                SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Removed channel {} because it's not playing anymore", (Object)lllllllllllIlIlIlIIIIlIIlIIIIlIl);
                this.sndSystem.removeSource(lllllllllllIlIlIlIIIIlIIlIIIIlIl);
                this.playingSoundsStopTime.remove(lllllllllllIlIlIlIIIIlIIlIIIIlIl);
                try {
                    this.categorySounds.remove((Object)lllllllllllIlIlIlIIIIlIIlIIIIlII.getCategory(), (Object)lllllllllllIlIlIlIIIIlIIlIIIIlIl);
                }
                catch (RuntimeException ex) {}
                if (!(lllllllllllIlIlIlIIIIlIIlIIIIlII instanceof ITickableSound)) {
                    continue;
                }
                this.tickableSounds.remove(lllllllllllIlIlIlIIIIlIIlIIIIlII);
            }
        }
        final Iterator<Map.Entry<ISound, Integer>> lllllllllllIlIlIlIIIIlIIlIIIIIIl = this.delayedSounds.entrySet().iterator();
        while (lllllllllllIlIlIlIIIIlIIlIIIIIIl.hasNext()) {
            final Map.Entry<ISound, Integer> lllllllllllIlIlIlIIIIlIIlIIIIIII = lllllllllllIlIlIlIIIIlIIlIIIIIIl.next();
            if (this.playTime >= lllllllllllIlIlIlIIIIlIIlIIIIIII.getValue()) {
                final ISound lllllllllllIlIlIlIIIIlIIIlllllll = lllllllllllIlIlIlIIIIlIIlIIIIIII.getKey();
                if (lllllllllllIlIlIlIIIIlIIIlllllll instanceof ITickableSound) {
                    ((ITickableSound)lllllllllllIlIlIlIIIIlIIIlllllll).update();
                }
                this.playSound(lllllllllllIlIlIlIIIIlIIIlllllll);
                lllllllllllIlIlIlIIIIlIIlIIIIIIl.remove();
            }
        }
    }
    
    public void playSound(final ISound lllllllllllIlIlIlIIIIlIIIlIIlIII) {
        if (this.loaded) {
            final SoundEventAccessor lllllllllllIlIlIlIIIIlIIIlIlIlIl = lllllllllllIlIlIlIIIIlIIIlIIlIII.createAccessor(this.sndHandler);
            final ResourceLocation lllllllllllIlIlIlIIIIlIIIlIlIlII = lllllllllllIlIlIlIIIIlIIIlIIlIII.getSoundLocation();
            if (lllllllllllIlIlIlIIIIlIIIlIlIlIl == null) {
                if (SoundManager.UNABLE_TO_PLAY.add(lllllllllllIlIlIlIIIIlIIIlIlIlII)) {
                    SoundManager.LOGGER.warn(SoundManager.LOG_MARKER, "Unable to play unknown soundEvent: {}", (Object)lllllllllllIlIlIlIIIIlIIIlIlIlII);
                }
            }
            else {
                if (!this.listeners.isEmpty()) {
                    for (final ISoundEventListener lllllllllllIlIlIlIIIIlIIIlIlIIll : this.listeners) {
                        lllllllllllIlIlIlIIIIlIIIlIlIIll.soundPlay(lllllllllllIlIlIlIIIIlIIIlIIlIII, lllllllllllIlIlIlIIIIlIIIlIlIlIl);
                    }
                }
                if (this.sndSystem.getMasterVolume() <= 0.0f) {
                    SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Skipped playing soundEvent: {}, master volume was zero", (Object)lllllllllllIlIlIlIIIIlIIIlIlIlII);
                }
                else {
                    final Sound lllllllllllIlIlIlIIIIlIIIlIlIIlI = lllllllllllIlIlIlIIIIlIIIlIIlIII.getSound();
                    if (lllllllllllIlIlIlIIIIlIIIlIlIIlI == SoundHandler.MISSING_SOUND) {
                        if (SoundManager.UNABLE_TO_PLAY.add(lllllllllllIlIlIlIIIIlIIIlIlIlII)) {
                            SoundManager.LOGGER.warn(SoundManager.LOG_MARKER, "Unable to play empty soundEvent: {}", (Object)lllllllllllIlIlIlIIIIlIIIlIlIlII);
                        }
                    }
                    else {
                        final float lllllllllllIlIlIlIIIIlIIIlIlIIIl = lllllllllllIlIlIlIIIIlIIIlIIlIII.getVolume();
                        float lllllllllllIlIlIlIIIIlIIIlIlIIII = 16.0f;
                        if (lllllllllllIlIlIlIIIIlIIIlIlIIIl > 1.0f) {
                            lllllllllllIlIlIlIIIIlIIIlIlIIII *= lllllllllllIlIlIlIIIIlIIIlIlIIIl;
                        }
                        final SoundCategory lllllllllllIlIlIlIIIIlIIIlIIllll = lllllllllllIlIlIlIIIIlIIIlIIlIII.getCategory();
                        final float lllllllllllIlIlIlIIIIlIIIlIIlllI = this.getClampedVolume(lllllllllllIlIlIlIIIIlIIIlIIlIII);
                        final float lllllllllllIlIlIlIIIIlIIIlIIllIl = this.getClampedPitch(lllllllllllIlIlIlIIIIlIIIlIIlIII);
                        if (lllllllllllIlIlIlIIIIlIIIlIIlllI == 0.0f) {
                            SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Skipped playing sound {}, volume was zero.", (Object)lllllllllllIlIlIlIIIIlIIIlIlIIlI.getSoundLocation());
                        }
                        else {
                            final boolean lllllllllllIlIlIlIIIIlIIIlIIllII = lllllllllllIlIlIlIIIIlIIIlIIlIII.canRepeat() && lllllllllllIlIlIlIIIIlIIIlIIlIII.getRepeatDelay() == 0;
                            final String lllllllllllIlIlIlIIIIlIIIlIIlIll = MathHelper.getRandomUUID((Random)ThreadLocalRandom.current()).toString();
                            final ResourceLocation lllllllllllIlIlIlIIIIlIIIlIIlIlI = lllllllllllIlIlIlIIIIlIIIlIlIIlI.getSoundAsOggLocation();
                            if (lllllllllllIlIlIlIIIIlIIIlIlIIlI.isStreaming()) {
                                this.sndSystem.newStreamingSource(false, lllllllllllIlIlIlIIIIlIIIlIIlIll, getURLForSoundResource(lllllllllllIlIlIlIIIIlIIIlIIlIlI), lllllllllllIlIlIlIIIIlIIIlIIlIlI.toString(), lllllllllllIlIlIlIIIIlIIIlIIllII, lllllllllllIlIlIlIIIIlIIIlIIlIII.getXPosF(), lllllllllllIlIlIlIIIIlIIIlIIlIII.getYPosF(), lllllllllllIlIlIlIIIIlIIIlIIlIII.getZPosF(), lllllllllllIlIlIlIIIIlIIIlIIlIII.getAttenuationType().getTypeInt(), lllllllllllIlIlIlIIIIlIIIlIlIIII);
                            }
                            else {
                                this.sndSystem.newSource(false, lllllllllllIlIlIlIIIIlIIIlIIlIll, getURLForSoundResource(lllllllllllIlIlIlIIIIlIIIlIIlIlI), lllllllllllIlIlIlIIIIlIIIlIIlIlI.toString(), lllllllllllIlIlIlIIIIlIIIlIIllII, lllllllllllIlIlIlIIIIlIIIlIIlIII.getXPosF(), lllllllllllIlIlIlIIIIlIIIlIIlIII.getYPosF(), lllllllllllIlIlIlIIIIlIIIlIIlIII.getZPosF(), lllllllllllIlIlIlIIIIlIIIlIIlIII.getAttenuationType().getTypeInt(), lllllllllllIlIlIlIIIIlIIIlIlIIII);
                            }
                            SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Playing sound {} for event {} as channel {}", (Object)lllllllllllIlIlIlIIIIlIIIlIlIIlI.getSoundLocation(), (Object)lllllllllllIlIlIlIIIIlIIIlIlIlII, (Object)lllllllllllIlIlIlIIIIlIIIlIIlIll);
                            this.sndSystem.setPitch(lllllllllllIlIlIlIIIIlIIIlIIlIll, lllllllllllIlIlIlIIIIlIIIlIIllIl);
                            this.sndSystem.setVolume(lllllllllllIlIlIlIIIIlIIIlIIlIll, lllllllllllIlIlIlIIIIlIIIlIIlllI);
                            this.sndSystem.play(lllllllllllIlIlIlIIIIlIIIlIIlIll);
                            this.playingSoundsStopTime.put(lllllllllllIlIlIlIIIIlIIIlIIlIll, this.playTime + 20);
                            this.playingSounds.put(lllllllllllIlIlIlIIIIlIIIlIIlIll, lllllllllllIlIlIlIIIIlIIIlIIlIII);
                            this.categorySounds.put((Object)lllllllllllIlIlIlIIIIlIIIlIIllll, (Object)lllllllllllIlIlIlIIIIlIIIlIIlIll);
                            if (lllllllllllIlIlIlIIIIlIIIlIIlIII instanceof ITickableSound) {
                                this.tickableSounds.add((ITickableSound)lllllllllllIlIlIlIIIIlIIIlIIlIII);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private float getClampedPitch(final ISound lllllllllllIlIlIlIIIIlIIIIlllIIl) {
        return MathHelper.clamp(lllllllllllIlIlIlIIIIlIIIIlllIIl.getPitch(), 0.5f, 2.0f);
    }
    
    public void stop(final String lllllllllllIlIlIlIIIIIllllIIIlII, final SoundCategory lllllllllllIlIlIlIIIIIllllIIlIIl) {
        if (lllllllllllIlIlIlIIIIIllllIIlIIl != null) {
            for (final String lllllllllllIlIlIlIIIIIllllIIlIII : this.categorySounds.get((Object)lllllllllllIlIlIlIIIIIllllIIlIIl)) {
                final ISound lllllllllllIlIlIlIIIIIllllIIIlll = this.playingSounds.get(lllllllllllIlIlIlIIIIIllllIIlIII);
                if (lllllllllllIlIlIlIIIIIllllIIIlII.isEmpty()) {
                    this.stopSound(lllllllllllIlIlIlIIIIIllllIIIlll);
                }
                else {
                    if (!lllllllllllIlIlIlIIIIIllllIIIlll.getSoundLocation().equals(new ResourceLocation(lllllllllllIlIlIlIIIIIllllIIIlII))) {
                        continue;
                    }
                    this.stopSound(lllllllllllIlIlIlIIIIIllllIIIlll);
                }
            }
        }
        else if (lllllllllllIlIlIlIIIIIllllIIIlII.isEmpty()) {
            this.stopAllSounds();
        }
        else {
            for (final ISound lllllllllllIlIlIlIIIIIllllIIIllI : this.playingSounds.values()) {
                if (lllllllllllIlIlIlIIIIIllllIIIllI.getSoundLocation().equals(new ResourceLocation(lllllllllllIlIlIlIIIIIllllIIIlII))) {
                    this.stopSound(lllllllllllIlIlIlIIIIIllllIIIllI);
                }
            }
        }
    }
    
    private float getVolume(final SoundCategory lllllllllllIlIlIlIIIIlIIlIlllllI) {
        return (lllllllllllIlIlIlIIIIlIIlIlllllI != null && lllllllllllIlIlIlIIIIlIIlIlllllI != SoundCategory.MASTER) ? this.options.getSoundLevel(lllllllllllIlIlIlIIIIlIIlIlllllI) : 1.0f;
    }
    
    public void unloadSoundSystem() {
        if (this.loaded) {
            this.stopAllSounds();
            this.sndSystem.cleanup();
            this.loaded = false;
        }
    }
    
    public void removeListener(final ISoundEventListener lllllllllllIlIlIlIIIIlIIlIIlIIll) {
        this.listeners.remove(lllllllllllIlIlIlIIIIlIIlIIlIIll);
    }
    
    public void stopSound(final ISound lllllllllllIlIlIlIIIIlIIIllIIllI) {
        if (this.loaded) {
            final String lllllllllllIlIlIlIIIIlIIIllIlIII = this.invPlayingSounds.get(lllllllllllIlIlIlIIIIlIIIllIIllI);
            if (lllllllllllIlIlIlIIIIlIIIllIlIII != null) {
                this.sndSystem.stop(lllllllllllIlIlIlIIIIlIIIllIlIII);
            }
        }
    }
    
    private float getClampedVolume(final ISound lllllllllllIlIlIlIIIIlIIIIllIlIl) {
        return MathHelper.clamp(lllllllllllIlIlIlIIIIlIIIIllIlIl.getVolume() * this.getVolume(lllllllllllIlIlIlIIIIlIIIIllIlIl.getCategory()), 0.0f, 1.0f);
    }
    
    public void stopAllSounds() {
        if (this.loaded) {
            for (final String lllllllllllIlIlIlIIIIlIIlIlIIIlI : this.playingSounds.keySet()) {
                this.sndSystem.stop(lllllllllllIlIlIlIIIIlIIlIlIIIlI);
            }
            this.playingSounds.clear();
            this.delayedSounds.clear();
            this.tickableSounds.clear();
            this.categorySounds.clear();
            this.playingSoundsStopTime.clear();
        }
    }
    
    public void setListener(final EntityPlayer lllllllllllIlIlIlIIIIIlllllIIIlI, final float lllllllllllIlIlIlIIIIIllllllIIll) {
        if (this.loaded && lllllllllllIlIlIlIIIIIlllllIIIlI != null) {
            final float lllllllllllIlIlIlIIIIIllllllIIlI = lllllllllllIlIlIlIIIIIlllllIIIlI.prevRotationPitch + (lllllllllllIlIlIlIIIIIlllllIIIlI.rotationPitch - lllllllllllIlIlIlIIIIIlllllIIIlI.prevRotationPitch) * lllllllllllIlIlIlIIIIIllllllIIll;
            final float lllllllllllIlIlIlIIIIIllllllIIIl = lllllllllllIlIlIlIIIIIlllllIIIlI.prevRotationYaw + (lllllllllllIlIlIlIIIIIlllllIIIlI.rotationYaw - lllllllllllIlIlIlIIIIIlllllIIIlI.prevRotationYaw) * lllllllllllIlIlIlIIIIIllllllIIll;
            final double lllllllllllIlIlIlIIIIIllllllIIII = lllllllllllIlIlIlIIIIIlllllIIIlI.prevPosX + (lllllllllllIlIlIlIIIIIlllllIIIlI.posX - lllllllllllIlIlIlIIIIIlllllIIIlI.prevPosX) * lllllllllllIlIlIlIIIIIllllllIIll;
            final double lllllllllllIlIlIlIIIIIlllllIllll = lllllllllllIlIlIlIIIIIlllllIIIlI.prevPosY + (lllllllllllIlIlIlIIIIIlllllIIIlI.posY - lllllllllllIlIlIlIIIIIlllllIIIlI.prevPosY) * lllllllllllIlIlIlIIIIIllllllIIll + lllllllllllIlIlIlIIIIIlllllIIIlI.getEyeHeight();
            final double lllllllllllIlIlIlIIIIIlllllIlllI = lllllllllllIlIlIlIIIIIlllllIIIlI.prevPosZ + (lllllllllllIlIlIlIIIIIlllllIIIlI.posZ - lllllllllllIlIlIlIIIIIlllllIIIlI.prevPosZ) * lllllllllllIlIlIlIIIIIllllllIIll;
            final float lllllllllllIlIlIlIIIIIlllllIllIl = MathHelper.cos((lllllllllllIlIlIlIIIIIllllllIIIl + 90.0f) * 0.017453292f);
            final float lllllllllllIlIlIlIIIIIlllllIllII = MathHelper.sin((lllllllllllIlIlIlIIIIIllllllIIIl + 90.0f) * 0.017453292f);
            final float lllllllllllIlIlIlIIIIIlllllIlIll = MathHelper.cos(-lllllllllllIlIlIlIIIIIllllllIIlI * 0.017453292f);
            final float lllllllllllIlIlIlIIIIIlllllIlIlI = MathHelper.sin(-lllllllllllIlIlIlIIIIIllllllIIlI * 0.017453292f);
            final float lllllllllllIlIlIlIIIIIlllllIlIIl = MathHelper.cos((-lllllllllllIlIlIlIIIIIllllllIIlI + 90.0f) * 0.017453292f);
            final float lllllllllllIlIlIlIIIIIlllllIlIII = MathHelper.sin((-lllllllllllIlIlIlIIIIIllllllIIlI + 90.0f) * 0.017453292f);
            final float lllllllllllIlIlIlIIIIIlllllIIlll = lllllllllllIlIlIlIIIIIlllllIllIl * lllllllllllIlIlIlIIIIIlllllIlIll;
            final float lllllllllllIlIlIlIIIIIlllllIIllI = lllllllllllIlIlIlIIIIIlllllIllII * lllllllllllIlIlIlIIIIIlllllIlIll;
            final float lllllllllllIlIlIlIIIIIlllllIIlIl = lllllllllllIlIlIlIIIIIlllllIllIl * lllllllllllIlIlIlIIIIIlllllIlIIl;
            final float lllllllllllIlIlIlIIIIIlllllIIlII = lllllllllllIlIlIlIIIIIlllllIllII * lllllllllllIlIlIlIIIIIlllllIlIIl;
            this.sndSystem.setListenerPosition((float)lllllllllllIlIlIlIIIIIllllllIIII, (float)lllllllllllIlIlIlIIIIIlllllIllll, (float)lllllllllllIlIlIlIIIIIlllllIlllI);
            this.sndSystem.setListenerOrientation(lllllllllllIlIlIlIIIIIlllllIIlll, lllllllllllIlIlIlIIIIIlllllIlIlI, lllllllllllIlIlIlIIIIIlllllIIllI, lllllllllllIlIlIlIIIIIlllllIIlIl, lllllllllllIlIlIlIIIIIlllllIlIII, lllllllllllIlIlIlIIIIIlllllIIlII);
        }
    }
    
    public void resumeAllSounds() {
        for (final String lllllllllllIlIlIlIIIIlIIIIlIIIII : this.pausedChannels) {
            SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Resuming channel {}", (Object)lllllllllllIlIlIlIIIIlIIIIlIIIII);
            this.sndSystem.play(lllllllllllIlIlIlIIIIlIIIIlIIIII);
        }
        this.pausedChannels.clear();
    }
    
    public void pauseAllSounds() {
        for (final Map.Entry<String, ISound> lllllllllllIlIlIlIIIIlIIIIlIllII : this.playingSounds.entrySet()) {
            final String lllllllllllIlIlIlIIIIlIIIIlIlIll = lllllllllllIlIlIlIIIIlIIIIlIllII.getKey();
            final boolean lllllllllllIlIlIlIIIIlIIIIlIlIlI = this.isSoundPlaying(lllllllllllIlIlIlIIIIlIIIIlIllII.getValue());
            if (lllllllllllIlIlIlIIIIlIIIIlIlIlI) {
                SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Pausing channel {}", (Object)lllllllllllIlIlIlIIIIlIIIIlIlIll);
                this.sndSystem.pause(lllllllllllIlIlIlIIIIlIIIIlIlIll);
                this.pausedChannels.add(lllllllllllIlIlIlIIIIlIIIIlIlIll);
            }
        }
    }
    
    static {
        LOG_MARKER = MarkerManager.getMarker("SOUNDS");
        LOGGER = LogManager.getLogger();
        UNABLE_TO_PLAY = Sets.newHashSet();
    }
    
    class SoundSystemStarterThread extends SoundSystem
    {
        private SoundSystemStarterThread() {
        }
        
        public boolean playing(final String lllllllllllllIIlIIlIIllIlIlIIllI) {
            synchronized (SoundSystemConfig.THREAD_SYNC) {
                if (this.soundLibrary == null) {
                    // monitorexit(SoundSystemConfig.THREAD_SYNC)
                    return false;
                }
                final Source lllllllllllllIIlIIlIIllIlIlIlIII = this.soundLibrary.getSources().get(lllllllllllllIIlIIlIIllIlIlIIllI);
                if (lllllllllllllIIlIIlIIllIlIlIlIII == null) {
                    // monitorexit(SoundSystemConfig.THREAD_SYNC)
                    return false;
                }
                // monitorexit(SoundSystemConfig.THREAD_SYNC)
                return lllllllllllllIIlIIlIIllIlIlIlIII.playing() || lllllllllllllIIlIIlIIllIlIlIlIII.paused() || lllllllllllllIIlIIlIIllIlIlIlIII.preLoad;
            }
        }
    }
}
