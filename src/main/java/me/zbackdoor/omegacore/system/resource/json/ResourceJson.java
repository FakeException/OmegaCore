package me.zbackdoor.omegacore.system.resource.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import me.zbackdoor.omegacore.system.resource.AbstractResource;
import me.zbackdoor.omegacore.system.resource.ResourceHandler;
import me.zbackdoor.omegacore.system.resource.ResourceReference;
import me.zbackdoor.omegacore.system.resource.ResourceSection;
import me.zbackdoor.omegacore.system.util.reflect.Reflection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zBackDo_or_
 */
public class ResourceJson extends AbstractResource {

    private static final Gson gson = new Gson();

    private JsonObject root = new JsonObject();

    public ResourceJson(File file, ResourceReference reference, ResourceHandler handler) {
        super(file, reference, handler);
    }

    public ResourceJson(ResourceJson resource, JsonObject root) {
        super(resource.getFile(), resource.getReference(), resource.getHandler());
        this.root = root;
    }

    @Override
    public JsonObject getConfiguration() {
        return root;
    }

    @Override
    public void setConfiguration(Object configuration) {
        if (configuration instanceof JsonObject) {
            this.root = (JsonObject) configuration;
        }
    }

    @Override
    public boolean isRoot() {
        return true;
    }

    @Override
    public boolean contains(String path) {
        return root.has(path);
    }

    @Override
    public ResourceSection createSection(String name) {
        JsonObject section = new JsonObject();
        root.add(name, section);

        return new ResourceJson(this, section);
    }

    @Override
    public String getName() {
        return root.getAsString();
    }

    @Override
    public String getCurrentPath() {
        return root.toString();
    }

    @Override
    public ResourceSection getRoot() {
        return this;
    }

    @Override
    public ResourceSection getParent() {
        return this;
    }

    @Override
    public Object get(String path, Class<?> type, Object def) {
        throw new UnsupportedOperationException("use getConfiguration instead");
    }

    @Override
    public Set<String> getKeys(boolean deep) {
        return root.entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public String getString(String path, String def) {
        return contains(path) ? root.get(path).getAsString() : def;
    }

    @Override
    public boolean getBoolean(String path, boolean def) {
        return contains(path) ? root.get(path).getAsBoolean() : def;
    }

    @Override
    public byte getByte(String path, byte def) {
        return contains(path) ? root.get(path).getAsByte() : def;
    }

    @Override
    public char getChar(String path, char def) {
        return contains(path) ? root.get(path).getAsCharacter() : def;
    }

    @Override
    public short getShort(String path, short def) {
        return contains(path) ? root.get(path).getAsShort() : def;
    }

    @Override
    public int getInt(String path, int def) {
        return contains(path) ? root.get(path).getAsInt() : def;
    }

    @Override
    public long getLong(String path, long def) {
        return contains(path) ? root.get(path).getAsLong() : def;
    }

    @Override
    public float getFloat(String path, float def) {
        return contains(path) ? root.get(path).getAsFloat() : def;
    }

    @Override
    public double getDouble(String path, double def) {
        return contains(path) ? root.get(path).getAsDouble() : def;
    }

    @Override
    public <T> List<T> getList(String path, Class<T> clazz) {
        return gson.fromJson(root.getAsJsonArray(path), new TypeToken<ArrayList<T>>(){}.getType());
    }

    @Override
    public ResourceSection getSection(String path) {
        return new ResourceJson(this, root.getAsJsonObject(path));
    }

    @Override
    public void set(String path, Object object) {
        if (object instanceof ResourceJson) {
            set(path, ((ResourceJson) object).getConfiguration());
        } else if (object instanceof JsonObject) {
            root.add(path, (JsonObject) object);
        } else if (object instanceof List) {
            JsonArray array = new JsonArray();

            for (Object obj : (List) object) {
                array.add(newJsonPrimitive(obj));
            }

            root.add(path, array);
        } else {
            root.add(path, object == null ? JsonNull.INSTANCE : newJsonPrimitive(object));
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }

    private final Class[] PARAM_TYPES = new Class[] { Object.class };

    private JsonPrimitive newJsonPrimitive(Object object) {
        return Reflection.newInstance(JsonPrimitive.class, PARAM_TYPES, object);
    }
}
