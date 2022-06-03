// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.registry.RegistrySimple;
import java.lang.reflect.Type;
import net.minecraft.util.text.ITextComponent;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import java.io.InputStream;
import javax.annotation.Nullable;
import net.minecraft.util.SoundEvent;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Map;
import net.minecraft.util.SoundCategory;
import net.minecraft.client.resources.IResource;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.FileNotFoundException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.settings.GameSettings;
import java.lang.reflect.ParameterizedType;
import net.minecraft.client.resources.IResourceManager;
import com.google.gson.Gson;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.ITickable;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class SoundHandler implements IResourceManagerReloadListener, ITickable
{
    private final /* synthetic */ SoundRegistry soundRegistry;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ SoundManager sndManager;
    private final /* synthetic */ IResourceManager mcResourceManager;
    public static final /* synthetic */ Sound MISSING_SOUND;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$audio$Sound$Type;
    
    public void addListener(final ISoundEventListener lllllllllllllIllIIlIIlllIlllIIlI) {
        this.sndManager.addListener(lllllllllllllIllIIlIIlllIlllIIlI);
    }
    
    public SoundHandler(final IResourceManager lllllllllllllIllIIlIlIIIIIIlllIl, final GameSettings lllllllllllllIllIIlIlIIIIIIlllII) {
        this.soundRegistry = new SoundRegistry();
        this.mcResourceManager = lllllllllllllIllIIlIlIIIIIIlllIl;
        this.sndManager = new SoundManager(this, lllllllllllllIllIIlIlIIIIIIlllII);
    }
    
    public void setListener(final EntityPlayer lllllllllllllIllIIlIIllllIlIIIII, final float lllllllllllllIllIIlIIllllIIlllII) {
        this.sndManager.setListener(lllllllllllllIllIIlIIllllIlIIIII, lllllllllllllIllIIlIIllllIIlllII);
    }
    
    public void playSound(final ISound lllllllllllllIllIIlIIllllIllIIII) {
        this.sndManager.playSound(lllllllllllllIllIIlIIllllIllIIII);
    }
    
    public void resumeSounds() {
        this.sndManager.resumeAllSounds();
    }
    
    private void loadSoundResource(final ResourceLocation lllllllllllllIllIIlIIllllllIIlll, final SoundList lllllllllllllIllIIlIIlllllIlllII) {
        SoundEventAccessor lllllllllllllIllIIlIIllllllIIlIl = this.soundRegistry.getObject(lllllllllllllIllIIlIIllllllIIlll);
        final boolean lllllllllllllIllIIlIIllllllIIlII = lllllllllllllIllIIlIIllllllIIlIl == null;
        if (lllllllllllllIllIIlIIllllllIIlII || lllllllllllllIllIIlIIlllllIlllII.canReplaceExisting()) {
            if (!lllllllllllllIllIIlIIllllllIIlII) {
                SoundHandler.LOGGER.debug("Replaced sound event location {}", (Object)lllllllllllllIllIIlIIllllllIIlll);
            }
            lllllllllllllIllIIlIIllllllIIlIl = new SoundEventAccessor(lllllllllllllIllIIlIIllllllIIlll, lllllllllllllIllIIlIIlllllIlllII.getSubtitle());
            this.soundRegistry.add(lllllllllllllIllIIlIIllllllIIlIl);
        }
        for (final Sound lllllllllllllIllIIlIIllllllIIIll : lllllllllllllIllIIlIIlllllIlllII.getSounds()) {
            final ResourceLocation lllllllllllllIllIIlIIllllllIIIlI = lllllllllllllIllIIlIIllllllIIIll.getSoundLocation();
            switch ($SWITCH_TABLE$net$minecraft$client$audio$Sound$Type()[lllllllllllllIllIIlIIllllllIIIll.getType().ordinal()]) {
                case 1: {
                    if (!this.validateSoundResource(lllllllllllllIllIIlIIllllllIIIll, lllllllllllllIllIIlIIllllllIIlll)) {
                        continue;
                    }
                    final ISoundEventAccessor<Sound> lllllllllllllIllIIlIIllllllIIIIl = lllllllllllllIllIIlIIllllllIIIll;
                    break;
                }
                case 2: {
                    final ISoundEventAccessor<Sound> lllllllllllllIllIIlIIllllllIIIII = new ISoundEventAccessor<Sound>() {
                        @Override
                        public int getWeight() {
                            final SoundEventAccessor lllllllllllllIIIIIIlIlIIlIlIlIIl = SoundHandler.this.soundRegistry.getObject(lllllllllllllIllIIlIIllllllIIIlI);
                            return (lllllllllllllIIIIIIlIlIIlIlIlIIl == null) ? 0 : lllllllllllllIIIIIIlIlIIlIlIlIIl.getWeight();
                        }
                        
                        @Override
                        public Sound cloneEntry() {
                            final SoundEventAccessor lllllllllllllIIIIIIlIlIIlIlIIIlI = SoundHandler.this.soundRegistry.getObject(lllllllllllllIllIIlIIllllllIIIlI);
                            if (lllllllllllllIIIIIIlIlIIlIlIIIlI == null) {
                                return SoundHandler.MISSING_SOUND;
                            }
                            final Sound lllllllllllllIIIIIIlIlIIlIlIIIIl = lllllllllllllIIIIIIlIlIIlIlIIIlI.cloneEntry();
                            return new Sound(lllllllllllllIIIIIIlIlIIlIlIIIIl.getSoundLocation().toString(), lllllllllllllIIIIIIlIlIIlIlIIIIl.getVolume() * lllllllllllllIllIIlIIllllllIIIll.getVolume(), lllllllllllllIIIIIIlIlIIlIlIIIIl.getPitch() * lllllllllllllIllIIlIIllllllIIIll.getPitch(), lllllllllllllIllIIlIIllllllIIIll.getWeight(), Sound.Type.FILE, lllllllllllllIIIIIIlIlIIlIlIIIIl.isStreaming() || lllllllllllllIllIIlIIllllllIIIll.isStreaming());
                        }
                    };
                    break;
                }
                default: {
                    throw new IllegalStateException("Unknown SoundEventRegistration type: " + lllllllllllllIllIIlIIllllllIIIll.getType());
                }
            }
            final ISoundEventAccessor<Sound> lllllllllllllIllIIlIIlllllIlllll;
            lllllllllllllIllIIlIIllllllIIlIl.addSound(lllllllllllllIllIIlIIlllllIlllll);
        }
    }
    
    public boolean isSoundPlaying(final ISound lllllllllllllIllIIlIIlllIllllIlI) {
        return this.sndManager.isSoundPlaying(lllllllllllllIllIIlIIlllIllllIlI);
    }
    
    private boolean validateSoundResource(final Sound lllllllllllllIllIIlIIlllllIIIIIl, final ResourceLocation lllllllllllllIllIIlIIlllllIIIIII) {
        final ResourceLocation lllllllllllllIllIIlIIlllllIIlIIl = lllllllllllllIllIIlIIlllllIIIIIl.getSoundAsOggLocation();
        IResource lllllllllllllIllIIlIIlllllIIlIII = null;
        try {
            lllllllllllllIllIIlIIlllllIIlIII = this.mcResourceManager.getResource(lllllllllllllIllIIlIIlllllIIlIIl);
            lllllllllllllIllIIlIIlllllIIlIII.getInputStream();
            return true;
        }
        catch (FileNotFoundException lllllllllllllIllIIlIIlllllIIIlII) {
            SoundHandler.LOGGER.warn("File {} does not exist, cannot add it to event {}", (Object)lllllllllllllIllIIlIIlllllIIlIIl, (Object)lllllllllllllIllIIlIIlllllIIIIII);
            final boolean lllllllllllllIllIIlIIlllllIIIlll = false;
        }
        catch (IOException lllllllllllllIllIIlIIlllllIIIIll) {
            SoundHandler.LOGGER.warn("Could not load sound file {}, cannot add it to event {}", (Object)lllllllllllllIllIIlIIlllllIIlIIl, (Object)lllllllllllllIllIIlIIlllllIIIIII, (Object)lllllllllllllIllIIlIIlllllIIIIll);
            final float lllllllllllllIllIIlIIllllIlllIlI;
            final boolean lllllllllllllIllIIlIIlllllIIIllI = (lllllllllllllIllIIlIIllllIlllIlI = 0) != 0.0f;
            return lllllllllllllIllIIlIIllllIlllIlI != 0.0f;
        }
        finally {
            IOUtils.closeQuietly((Closeable)lllllllllllllIllIIlIIlllllIIlIII);
        }
        final boolean lllllllllllllIllIIlIIlllllIIIlIl;
        return lllllllllllllIllIIlIIlllllIIIlIl;
    }
    
    public void setSoundLevel(final SoundCategory lllllllllllllIllIIlIIllllIIIlIII, final float lllllllllllllIllIIlIIllllIIIIlll) {
        if (lllllllllllllIllIIlIIllllIIIlIII == SoundCategory.MASTER && lllllllllllllIllIIlIIllllIIIIlll <= 0.0f) {
            this.stopSounds();
        }
        this.sndManager.setVolume(lllllllllllllIllIIlIIllllIIIlIII, lllllllllllllIllIIlIIllllIIIIlll);
    }
    
    public void pauseSounds() {
        this.sndManager.pauseAllSounds();
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllIllIIlIlIIIIIIIIIll) {
        this.soundRegistry.clearMap();
        for (final String lllllllllllllIllIIlIlIIIIIIIllIl : lllllllllllllIllIIlIlIIIIIIIIIll.getResourceDomains()) {
            try {
                for (final IResource lllllllllllllIllIIlIlIIIIIIIllII : lllllllllllllIllIIlIlIIIIIIIIIll.getAllResources(new ResourceLocation(lllllllllllllIllIIlIlIIIIIIIllIl, "sounds.json"))) {
                    try {
                        final Map<String, SoundList> lllllllllllllIllIIlIlIIIIIIIlIll = this.getSoundMap(lllllllllllllIllIIlIlIIIIIIIllII.getInputStream());
                        for (final Map.Entry<String, SoundList> lllllllllllllIllIIlIlIIIIIIIlIlI : lllllllllllllIllIIlIlIIIIIIIlIll.entrySet()) {
                            this.loadSoundResource(new ResourceLocation(lllllllllllllIllIIlIlIIIIIIIllIl, lllllllllllllIllIIlIlIIIIIIIlIlI.getKey()), lllllllllllllIllIIlIlIIIIIIIlIlI.getValue());
                        }
                    }
                    catch (RuntimeException lllllllllllllIllIIlIlIIIIIIIlIIl) {
                        SoundHandler.LOGGER.warn("Invalid sounds.json", (Throwable)lllllllllllllIllIIlIlIIIIIIIlIIl);
                    }
                }
            }
            catch (IOException ex) {}
        }
        for (final ResourceLocation lllllllllllllIllIIlIlIIIIIIIlIII : ((RegistrySimple<ResourceLocation, V>)this.soundRegistry).getKeys()) {
            final SoundEventAccessor lllllllllllllIllIIlIlIIIIIIIIlll = this.soundRegistry.getObject(lllllllllllllIllIIlIlIIIIIIIlIII);
            if (lllllllllllllIllIIlIlIIIIIIIIlll.getSubtitle() instanceof TextComponentTranslation) {
                final String lllllllllllllIllIIlIlIIIIIIIIllI = ((TextComponentTranslation)lllllllllllllIllIIlIlIIIIIIIIlll.getSubtitle()).getKey();
                if (I18n.hasKey(lllllllllllllIllIIlIlIIIIIIIIllI)) {
                    continue;
                }
                SoundHandler.LOGGER.debug("Missing subtitle {} for event: {}", (Object)lllllllllllllIllIIlIlIIIIIIIIllI, (Object)lllllllllllllIllIIlIlIIIIIIIlIII);
            }
        }
        for (final ResourceLocation lllllllllllllIllIIlIlIIIIIIIIlIl : ((RegistrySimple<ResourceLocation, V>)this.soundRegistry).getKeys()) {
            if (SoundEvent.REGISTRY.getObject(lllllllllllllIllIIlIlIIIIIIIIlIl) == null) {
                SoundHandler.LOGGER.debug("Not having sound event for: {}", (Object)lllllllllllllIllIIlIlIIIIIIIIlIl);
            }
        }
        this.sndManager.reloadSoundSystem();
    }
    
    public void stopSounds() {
        this.sndManager.stopAllSounds();
    }
    
    public void unloadSounds() {
        this.sndManager.unloadSoundSystem();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$audio$Sound$Type() {
        final int[] $switch_TABLE$net$minecraft$client$audio$Sound$Type = SoundHandler.$SWITCH_TABLE$net$minecraft$client$audio$Sound$Type;
        if ($switch_TABLE$net$minecraft$client$audio$Sound$Type != null) {
            return $switch_TABLE$net$minecraft$client$audio$Sound$Type;
        }
        final String lllllllllllllIllIIlIIlllIlIlllll = (Object)new int[Sound.Type.values().length];
        try {
            lllllllllllllIllIIlIIlllIlIlllll[Sound.Type.FILE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllIIlIIlllIlIlllll[Sound.Type.SOUND_EVENT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        return SoundHandler.$SWITCH_TABLE$net$minecraft$client$audio$Sound$Type = (int[])(Object)lllllllllllllIllIIlIIlllIlIlllll;
    }
    
    @Nullable
    public SoundEventAccessor getAccessor(final ResourceLocation lllllllllllllIllIIlIIllllIllIlII) {
        return this.soundRegistry.getObject(lllllllllllllIllIIlIIllllIllIlII);
    }
    
    @Nullable
    protected Map<String, SoundList> getSoundMap(final InputStream lllllllllllllIllIIlIIlllllllIlll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: new             Ljava/io/InputStreamReader;
        //     6: dup            
        //     7: aload_1         /* lllllllllllllIllIIlIIlllllllIlII */
        //     8: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //    11: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //    14: getstatic       net/minecraft/client/audio/SoundHandler.TYPE:Ljava/lang/reflect/ParameterizedType;
        //    17: invokestatic    net/minecraft/util/JsonUtils.func_193841_a:(Lcom/google/gson/Gson;Ljava/io/Reader;Ljava/lang/reflect/Type;)Ljava/lang/Object;
        //    20: checkcast       Ljava/util/Map;
        //    23: astore_2        /* lllllllllllllIllIIlIIlllllllIIll */
        //    24: goto            34
        //    27: astore_3        /* lllllllllllllIllIIlIIlllllllIIlI */
        //    28: aload_1         /* lllllllllllllIllIIlIIlllllllIlII */
        //    29: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    32: aload_3         /* lllllllllllllIllIIlIIlllllllIIlI */
        //    33: athrow         
        //    34: aload_1         /* lllllllllllllIllIIlIIlllllllIlII */
        //    35: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    38: aload_2         /* lllllllllllllIllIIlIIlllllllIlIl */
        //    39: areturn        
        //    Signature:
        //  (Ljava/io/InputStream;)Ljava/util/Map<Ljava/lang/String;Lnet/minecraft/client/audio/SoundList;>;
        //    RuntimeVisibleTypeAnnotations: 00 01 14 00 01 D3 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      27     27     34     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void playDelayedSound(final ISound lllllllllllllIllIIlIIllllIlIIllI, final int lllllllllllllIllIIlIIllllIlIlIII) {
        this.sndManager.playDelayedSound(lllllllllllllIllIIlIIllllIlIIllI, lllllllllllllIllIIlIIllllIlIlIII);
    }
    
    @Override
    public void update() {
        this.sndManager.updateAllSounds();
    }
    
    static {
        MISSING_SOUND = new Sound("meta:missing_sound", 1.0f, 1.0f, 1, Sound.Type.FILE, false);
        LOGGER = LogManager.getLogger();
        GSON = new GsonBuilder().registerTypeHierarchyAdapter((Class)ITextComponent.class, (Object)new ITextComponent.Serializer()).registerTypeAdapter((Type)SoundList.class, (Object)new SoundListSerializer()).create();
        TYPE = new ParameterizedType() {
            @Override
            public Type getRawType() {
                return Map.class;
            }
            
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { String.class, SoundList.class };
            }
            
            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }
    
    public void removeListener(final ISoundEventListener lllllllllllllIllIIlIIlllIllIllII) {
        this.sndManager.removeListener(lllllllllllllIllIIlIIlllIllIllII);
    }
    
    public void stop(final String lllllllllllllIllIIlIIlllIllIIlII, final SoundCategory lllllllllllllIllIIlIIlllIllIIllI) {
        this.sndManager.stop(lllllllllllllIllIIlIIlllIllIIlII, lllllllllllllIllIIlIIlllIllIIllI);
    }
    
    public void stopSound(final ISound lllllllllllllIllIIlIIllllIIIIIII) {
        this.sndManager.stopSound(lllllllllllllIllIIlIIllllIIIIIII);
    }
}
