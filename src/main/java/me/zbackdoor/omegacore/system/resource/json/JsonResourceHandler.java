package me.zbackdoor.omegacore.system.resource.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import me.zbackdoor.omegacore.system.resource.Extension;
import me.zbackdoor.omegacore.system.resource.ResourceHandler;
import me.zbackdoor.omegacore.system.resource.ResourceProvider;
import me.zbackdoor.omegacore.system.resource.ResourceReference;
import me.zbackdoor.omegacore.system.util.logging.StaticLog;

import java.io.*;
import java.util.List;

/**
 * @author zBackDo_or_
 */
public class JsonResourceHandler implements ResourceHandler<ResourceJson> {

    private static final JsonParser parser = new JsonParser();
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    @Override
    public ResourceJson load(ResourceProvider provider, ResourceReference reference) {
        ResourceJson resource = new ResourceJson(new File(provider.getDataFolder() + reference.getSeparatorPathStart(), reference.getChild()), reference, this);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(resource.getFile())))) {
            resource.setConfiguration(parser.parse(in).getAsJsonObject());
        } catch (Exception e) {
            // Ignored
        }

        return resource;
    }

    @Override
    public void save(ResourceJson resource) {
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(resource.getFile()));
            out.write(gson.toJson(resource.getConfiguration()));
            out.close();
        } catch (IOException e) {
            StaticLog.error("An IOException occurred when trying to save [&c" + resource.getReference() + "&r]:");
            StaticLog.exception(e);
        }
    }

    @Override
    public List<? extends CharSequence> getExtensions() {
        return Extension.JSON.getExtensions();
    }
}