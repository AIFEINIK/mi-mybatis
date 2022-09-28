package com.example.type;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author ZhangPengFei
 * @description 类型别名注册机
 */
public class TypeAliasRegistry {

    private final Map<String, Class<?>> TYPE_ALIASES = new HashMap<>();

    public TypeAliasRegistry() {
        registryAlias("string", String.class);
        registryAlias("byte", Byte.class);
        registryAlias("long", Long.class);
        registryAlias("short", Short.class);
        registryAlias("int", Integer.class);
        registryAlias("integer", Integer.class);
        registryAlias("double", Double.class);
        registryAlias("boolean", Boolean.class);
    }

    public <T> Class<T> registryAlias(String alias, Class<?> value) {
        String key = alias.toLowerCase(Locale.ENGLISH);
        return (Class<T>) TYPE_ALIASES.put(key, value);
    }

    public <T> Class<T> resolveAlias(String alias) {
        String key = alias.toLowerCase(Locale.ENGLISH);
        return (Class<T>) TYPE_ALIASES.get(key);
    }
}
