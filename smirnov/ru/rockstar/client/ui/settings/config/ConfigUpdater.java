// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.config;

import com.google.gson.JsonObject;

public interface ConfigUpdater
{
    void load(final JsonObject p0);
    
    JsonObject save();
}
