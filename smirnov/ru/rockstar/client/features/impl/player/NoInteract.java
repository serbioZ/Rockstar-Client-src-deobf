// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class NoInteract extends Feature
{
    public static /* synthetic */ BooleanSetting anvil;
    public static /* synthetic */ BooleanSetting door;
    public static /* synthetic */ BooleanSetting furnace;
    public static /* synthetic */ BooleanSetting armorStands;
    public static /* synthetic */ BooleanSetting dispenser;
    public static /* synthetic */ BooleanSetting craftTable;
    public static /* synthetic */ BooleanSetting hopper;
    public static /* synthetic */ BooleanSetting woodenslab;
    public static /* synthetic */ BooleanSetting lever;
    public static /* synthetic */ BooleanSetting standing;
    
    static {
        NoInteract.craftTable = new BooleanSetting("Craft Table", true, () -> true);
        NoInteract.standing = new BooleanSetting("Standing Sign", true, () -> true);
        NoInteract.door = new BooleanSetting("Door", true, () -> true);
        NoInteract.hopper = new BooleanSetting("Hopper", true, () -> true);
        NoInteract.furnace = new BooleanSetting("Furnace", true, () -> true);
        NoInteract.dispenser = new BooleanSetting("Dispenser", true, () -> true);
        NoInteract.anvil = new BooleanSetting("Furnace", true, () -> true);
        NoInteract.woodenslab = new BooleanSetting("Wooden Slab", true, () -> true);
        NoInteract.lever = new BooleanSetting("Lever", true, () -> true);
    }
    
    public NoInteract() {
        super("NoInteract", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043d\u0435 \u043d\u0430\u0436\u0438\u043c\u0430\u0442\u044c \u041f\u041a\u041c \u043f\u043e \u0432\u0435\u0440\u0441\u0442\u0430\u043a\u0430\u043c, \u043f\u0435\u0447\u043a\u0430\u043c \u0438 \u0442.\u0434", 0, Category.PLAYER);
        NoInteract.armorStands = new BooleanSetting("Armor Stand", true, () -> true);
        this.addSettings(NoInteract.armorStands, NoInteract.craftTable, NoInteract.standing, NoInteract.door, NoInteract.hopper, NoInteract.furnace, NoInteract.dispenser, NoInteract.anvil, NoInteract.woodenslab, NoInteract.lever);
    }
}
