// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features;

import java.util.List;
import java.util.Comparator;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.features.impl.display.Notifications;
import ru.rockstar.client.features.impl.display.ClientFont;
import ru.rockstar.client.features.impl.display.Hotbar;
import ru.rockstar.client.features.impl.display.ArreyList;
import ru.rockstar.client.features.impl.display.ClickGUI;
import ru.rockstar.client.features.impl.display.Watermark;
import ru.rockstar.client.features.impl.display.Indicators;
import ru.rockstar.client.features.impl.display.DamageInfo;
import ru.rockstar.client.features.impl.misc.TimerIndicator;
import ru.rockstar.client.features.impl.display.DamageFlyIndicator;
import ru.rockstar.client.features.impl.display.KeyBinds;
import ru.rockstar.client.features.impl.display.Keystrokes;
import ru.rockstar.client.features.impl.display.InventoryPreview;
import ru.rockstar.client.features.impl.misc.MCF;
import ru.rockstar.client.features.impl.misc.Panic;
import ru.rockstar.client.features.impl.misc.Disabler;
import ru.rockstar.client.features.impl.misc.AutoAccept;
import ru.rockstar.client.features.impl.misc.DuelAccept;
import ru.rockstar.client.features.impl.misc.Teleport;
import ru.rockstar.client.features.impl.misc.FastWorldLoad;
import ru.rockstar.client.features.impl.misc.ModuleSoundAlert;
import ru.rockstar.client.features.impl.misc.StaffAlert;
import ru.rockstar.client.features.impl.misc.DiscordRPC;
import ru.rockstar.client.features.impl.player.NoClip;
import ru.rockstar.client.features.impl.player.NoPush;
import ru.rockstar.client.features.impl.player.Scaffold;
import ru.rockstar.client.features.impl.player.AutoFarm;
import ru.rockstar.client.features.impl.player.NoServerRotation;
import ru.rockstar.client.features.impl.player.AutoAuth;
import ru.rockstar.client.features.impl.misc.FreeCam;
import ru.rockstar.client.features.impl.player.DeathCoordinates;
import ru.rockstar.client.features.impl.player.SpeedMine;
import ru.rockstar.client.features.impl.player.ItemScroller;
import ru.rockstar.client.features.impl.player.Spider;
import ru.rockstar.client.features.impl.player.XCarry;
import ru.rockstar.client.features.impl.player.NoDelay;
import ru.rockstar.client.features.impl.player.NoInteract;
import ru.rockstar.client.features.impl.player.ChestStealer;
import ru.rockstar.client.features.impl.player.KeepSprint;
import ru.rockstar.client.features.impl.player.MiddleClickPearl;
import ru.rockstar.client.features.impl.player.DetectPlayer;
import ru.rockstar.client.features.impl.player.BedBreaker;
import ru.rockstar.client.features.impl.player.InventoryManager;
import ru.rockstar.client.features.impl.player.FastEat;
import ru.rockstar.client.features.impl.visuals.Chams;
import ru.rockstar.client.features.impl.visuals.ESP;
import ru.rockstar.client.features.impl.visuals.Tracers;
import ru.rockstar.client.features.impl.visuals.NoRender;
import ru.rockstar.client.features.impl.visuals.NameTags;
import ru.rockstar.client.features.impl.visuals.ChinaHat;
import ru.rockstar.client.features.impl.visuals.TargetESP;
import ru.rockstar.client.features.impl.visuals.ViewModel;
import ru.rockstar.client.features.impl.visuals.Weather;
import ru.rockstar.client.features.impl.visuals.FogColor;
import ru.rockstar.client.features.impl.visuals.ItemESP;
import ru.rockstar.client.features.impl.visuals.PenisESP;
import ru.rockstar.client.features.impl.visuals.XRay;
import ru.rockstar.client.features.impl.visuals.CustomModel;
import ru.rockstar.client.features.impl.visuals.ArmorHUD;
import ru.rockstar.client.features.impl.visuals.ScoreBoard;
import ru.rockstar.client.features.impl.visuals.JumpCircle;
import ru.rockstar.client.features.impl.visuals.FullBright;
import ru.rockstar.client.features.impl.movement.WaterLeave;
import ru.rockstar.client.features.impl.visuals.Crosshair;
import ru.rockstar.client.features.impl.visuals.EnchantmentColor;
import ru.rockstar.client.features.impl.visuals.PearlESP;
import ru.rockstar.client.features.impl.visuals.ChestEsp;
import ru.rockstar.client.features.impl.visuals.NightMode;
import ru.rockstar.client.features.impl.visuals.NameProtect;
import ru.rockstar.client.features.impl.visuals.Breadcrumbs;
import ru.rockstar.client.features.impl.visuals.SwingAnimations;
import ru.rockstar.client.features.impl.visuals.Nimb;
import ru.rockstar.client.features.impl.visuals.Wings;
import ru.rockstar.client.features.impl.visuals.DamageMarkers;
import ru.rockstar.client.features.impl.visuals.BeaconRadius;
import ru.rockstar.client.features.impl.misc.SelfDamage;
import ru.rockstar.client.features.impl.movement.BedrockClip;
import ru.rockstar.client.features.impl.movement.Strafe;
import ru.rockstar.client.features.impl.movement.Step;
import ru.rockstar.client.features.impl.movement.Jesus;
import ru.rockstar.client.features.impl.movement.Speed;
import ru.rockstar.client.features.impl.movement.Timer;
import ru.rockstar.client.features.impl.movement.Flight;
import ru.rockstar.client.features.impl.movement.LongJump;
import ru.rockstar.client.features.impl.movement.NoWeb;
import ru.rockstar.client.features.impl.movement.FastClimb;
import ru.rockstar.client.features.impl.movement.NoFall;
import ru.rockstar.client.features.impl.player.GuiMove;
import ru.rockstar.client.features.impl.movement.AirJump;
import ru.rockstar.client.features.impl.movement.SafeWalk;
import ru.rockstar.client.features.impl.movement.AutoSprint;
import ru.rockstar.client.features.impl.movement.WaterSpeed;
import ru.rockstar.client.features.impl.movement.NoSlowDown;
import ru.rockstar.client.features.impl.movement.DamageFly;
import ru.rockstar.client.features.impl.movement.HighJump;
import ru.rockstar.client.features.impl.combat.Reach;
import ru.rockstar.client.features.impl.combat.PushAttack;
import ru.rockstar.client.features.impl.movement.TargetStrafe;
import ru.rockstar.client.features.impl.combat.FastBow;
import ru.rockstar.client.features.impl.combat.AntiCrystal;
import ru.rockstar.client.features.impl.combat.HitBox;
import ru.rockstar.client.features.impl.combat.Velocity;
import ru.rockstar.client.features.impl.combat.HitSounds;
import ru.rockstar.client.features.impl.combat.AutoPotion;
import ru.rockstar.client.features.impl.combat.AntiBot;
import ru.rockstar.client.features.impl.combat.KillAura;
import ru.rockstar.client.features.impl.combat.AutoTotem;
import ru.rockstar.client.features.impl.combat.AutoGapple;
import ru.rockstar.client.features.impl.combat.AutoShield;
import ru.rockstar.client.features.impl.combat.CrystalAura;
import ru.rockstar.client.features.impl.combat.ShieldDesync;
import ru.rockstar.client.features.impl.combat.AutoArmor;
import ru.rockstar.client.features.impl.combat.TriggerBot;
import ru.rockstar.client.features.impl.combat.SuperKnockBack;
import ru.rockstar.client.features.impl.combat.NoFriendDamage;
import ru.rockstar.client.features.impl.combat.AntiAim;
import ru.rockstar.client.features.impl.combat.AimBot;
import java.util.ArrayList;

public class FeatureDirector
{
    public static /* synthetic */ ArrayList<Feature> features;
    
    public FeatureDirector() {
        FeatureDirector.features.add(new AimBot());
        FeatureDirector.features.add(new AntiAim());
        FeatureDirector.features.add(new NoFriendDamage());
        FeatureDirector.features.add(new SuperKnockBack());
        FeatureDirector.features.add(new TriggerBot());
        FeatureDirector.features.add(new AutoArmor());
        FeatureDirector.features.add(new ShieldDesync());
        FeatureDirector.features.add(new CrystalAura());
        FeatureDirector.features.add(new AutoShield());
        FeatureDirector.features.add(new AutoGapple());
        FeatureDirector.features.add(new AutoTotem());
        FeatureDirector.features.add(new KillAura());
        FeatureDirector.features.add(new AntiBot());
        FeatureDirector.features.add(new AutoPotion());
        FeatureDirector.features.add(new HitSounds());
        FeatureDirector.features.add(new Velocity());
        FeatureDirector.features.add(new HitBox());
        FeatureDirector.features.add(new AntiCrystal());
        FeatureDirector.features.add(new FastBow());
        FeatureDirector.features.add(new TargetStrafe());
        FeatureDirector.features.add(new PushAttack());
        FeatureDirector.features.add(new Reach());
        FeatureDirector.features.add(new HighJump());
        FeatureDirector.features.add(new DamageFly());
        FeatureDirector.features.add(new NoSlowDown());
        FeatureDirector.features.add(new WaterSpeed());
        FeatureDirector.features.add(new AutoSprint());
        FeatureDirector.features.add(new SafeWalk());
        FeatureDirector.features.add(new AirJump());
        FeatureDirector.features.add(new GuiMove());
        FeatureDirector.features.add(new NoFall());
        FeatureDirector.features.add(new FastClimb());
        FeatureDirector.features.add(new NoWeb());
        FeatureDirector.features.add(new LongJump());
        FeatureDirector.features.add(new Flight());
        FeatureDirector.features.add(new Timer());
        FeatureDirector.features.add(new Speed());
        FeatureDirector.features.add(new Jesus());
        FeatureDirector.features.add(new Step());
        FeatureDirector.features.add(new Strafe());
        FeatureDirector.features.add(new BedrockClip());
        FeatureDirector.features.add(new SelfDamage());
        FeatureDirector.features.add(new BeaconRadius());
        FeatureDirector.features.add(new DamageMarkers());
        FeatureDirector.features.add(new Wings());
        FeatureDirector.features.add(new Nimb());
        FeatureDirector.features.add(new SwingAnimations());
        FeatureDirector.features.add(new Breadcrumbs());
        FeatureDirector.features.add(new NameProtect());
        FeatureDirector.features.add(new NightMode());
        FeatureDirector.features.add(new ChestEsp());
        FeatureDirector.features.add(new PearlESP());
        FeatureDirector.features.add(new EnchantmentColor());
        FeatureDirector.features.add(new Crosshair());
        FeatureDirector.features.add(new WaterLeave());
        FeatureDirector.features.add(new FullBright());
        FeatureDirector.features.add(new JumpCircle());
        FeatureDirector.features.add(new ScoreBoard());
        FeatureDirector.features.add(new ArmorHUD());
        FeatureDirector.features.add(new CustomModel());
        FeatureDirector.features.add(new XRay());
        FeatureDirector.features.add(new PenisESP());
        FeatureDirector.features.add(new ItemESP());
        FeatureDirector.features.add(new FogColor());
        FeatureDirector.features.add(new Weather());
        FeatureDirector.features.add(new ViewModel());
        FeatureDirector.features.add(new TargetESP());
        FeatureDirector.features.add(new ChinaHat());
        FeatureDirector.features.add(new NameTags());
        FeatureDirector.features.add(new NoRender());
        FeatureDirector.features.add(new Tracers());
        FeatureDirector.features.add(new ESP());
        FeatureDirector.features.add(new Chams());
        FeatureDirector.features.add(new FastEat());
        FeatureDirector.features.add(new InventoryManager());
        FeatureDirector.features.add(new BedBreaker());
        FeatureDirector.features.add(new DetectPlayer());
        FeatureDirector.features.add(new MiddleClickPearl());
        FeatureDirector.features.add(new KeepSprint());
        FeatureDirector.features.add(new ChestStealer());
        FeatureDirector.features.add(new NoInteract());
        FeatureDirector.features.add(new NoDelay());
        FeatureDirector.features.add(new XCarry());
        FeatureDirector.features.add(new Spider());
        FeatureDirector.features.add(new ItemScroller());
        FeatureDirector.features.add(new SpeedMine());
        FeatureDirector.features.add(new DeathCoordinates());
        FeatureDirector.features.add(new FreeCam());
        FeatureDirector.features.add(new AutoAuth());
        FeatureDirector.features.add(new NoServerRotation());
        FeatureDirector.features.add(new AutoFarm());
        FeatureDirector.features.add(new Scaffold());
        FeatureDirector.features.add(new NoPush());
        FeatureDirector.features.add(new NoClip());
        FeatureDirector.features.add(new DiscordRPC());
        FeatureDirector.features.add(new StaffAlert());
        FeatureDirector.features.add(new ModuleSoundAlert());
        FeatureDirector.features.add(new FastWorldLoad());
        FeatureDirector.features.add(new Teleport());
        FeatureDirector.features.add(new DuelAccept());
        FeatureDirector.features.add(new AutoAccept());
        FeatureDirector.features.add(new Disabler());
        FeatureDirector.features.add(new Panic());
        FeatureDirector.features.add(new MCF());
        FeatureDirector.features.add(new InventoryPreview());
        FeatureDirector.features.add(new Keystrokes());
        FeatureDirector.features.add(new KeyBinds());
        FeatureDirector.features.add(new DamageFlyIndicator());
        FeatureDirector.features.add(new TimerIndicator());
        FeatureDirector.features.add(new DamageInfo());
        FeatureDirector.features.add(new Indicators());
        FeatureDirector.features.add(new Watermark());
        FeatureDirector.features.add(new ClickGUI());
        FeatureDirector.features.add(new ArreyList());
        FeatureDirector.features.add(new Hotbar());
        FeatureDirector.features.add(new ClientFont());
        FeatureDirector.features.add(new Notifications());
        FeatureDirector.features.sort(Comparator.comparingInt(lllllllllllllIIIIIIlIIIIIIIIIIlI -> Minecraft.getMinecraft().neverlose500_15.getStringWidth(lllllllllllllIIIIIIlIIIIIIIIIIlI.getLabel())).reversed());
    }
    
    public List<Feature> getFeatureList() {
        return FeatureDirector.features;
    }
    
    public List<Feature> getFeaturesForCategory(final Category lllllllllllllIIIIIIlIIIIIIIllllI) {
        final List<Feature> lllllllllllllIIIIIIlIIIIIIlIIIIl = new ArrayList<Feature>();
        for (final Feature lllllllllllllIIIIIIlIIIIIIlIIIII : this.getFeatureList()) {
            if (lllllllllllllIIIIIIlIIIIIIlIIIII.getCategory() == lllllllllllllIIIIIIlIIIIIIIllllI) {
                lllllllllllllIIIIIIlIIIIIIlIIIIl.add(lllllllllllllIIIIIIlIIIIIIlIIIII);
            }
        }
        return lllllllllllllIIIIIIlIIIIIIlIIIIl;
    }
    
    public Feature getFeatureByLabel(final String lllllllllllllIIIIIIlIIIIIIIIIlll) {
        for (final Feature lllllllllllllIIIIIIlIIIIIIIIlIIl : this.getFeatureList()) {
            if (lllllllllllllIIIIIIlIIIIIIIIlIIl.getLabel().equals(lllllllllllllIIIIIIlIIIIIIIIIlll)) {
                return lllllllllllllIIIIIIlIIIIIIIIlIIl;
            }
        }
        return null;
    }
    
    public Feature getFeatureByClass(final Class<? extends Feature> lllllllllllllIIIIIIlIIIIIIIlIIlI) {
        for (final Feature lllllllllllllIIIIIIlIIIIIIIlIlII : this.getFeatureList()) {
            if (lllllllllllllIIIIIIlIIIIIIIlIlII != null && lllllllllllllIIIIIIlIIIIIIIlIlII.getClass() == lllllllllllllIIIIIIlIIIIIIIlIIlI) {
                return lllllllllllllIIIIIIlIIIIIIIlIlII;
            }
        }
        return null;
    }
    
    static {
        FeatureDirector.features = new ArrayList<Feature>();
    }
}
