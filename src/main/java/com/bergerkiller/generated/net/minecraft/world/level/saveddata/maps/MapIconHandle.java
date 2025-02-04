package com.bergerkiller.generated.net.minecraft.world.level.saveddata.maps;

import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.bukkit.common.wrappers.ChatText;
import org.bukkit.map.MapCursor;

/**
 * Instance wrapper handle for type <b>net.minecraft.world.level.saveddata.maps.MapIcon</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
@Template.InstanceType("net.minecraft.world.level.saveddata.maps.MapIcon")
public abstract class MapIconHandle extends Template.Handle {
    /** @See {@link MapIconClass} */
    public static final MapIconClass T = Template.Class.create(MapIconClass.class, com.bergerkiller.bukkit.common.Common.TEMPLATE_RESOLVER);
    /* ============================================================================== */

    public static MapIconHandle createHandle(Object handleInstance) {
        return T.createHandle(handleInstance);
    }

    /* ============================================================================== */

    public static MapIconHandle createNew(byte type, byte x, byte y, byte direction, ChatText title) {
        return T.createNew.invoke(type, x, y, direction, title);
    }

    public static MapIconHandle fromCursor(MapCursor cursor) {
        return T.fromCursor.invoke(cursor);
    }

    public abstract MapCursor toCursor();
    public abstract byte getTypeId();
    public abstract byte getX();
    public abstract byte getY();
    public abstract byte getDirection();

    public static MapIconHandle createNew(byte type, byte x, byte y, byte direction) {
        return createNew(type, x, y, direction, null);
    }
    /**
     * Stores class members for <b>net.minecraft.world.level.saveddata.maps.MapIcon</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class MapIconClass extends Template.Class<MapIconHandle> {
        public final Template.StaticMethod.Converted<MapIconHandle> createNew = new Template.StaticMethod.Converted<MapIconHandle>();
        public final Template.StaticMethod.Converted<MapIconHandle> fromCursor = new Template.StaticMethod.Converted<MapIconHandle>();

        public final Template.Method<MapCursor> toCursor = new Template.Method<MapCursor>();
        public final Template.Method<Byte> getTypeId = new Template.Method<Byte>();
        public final Template.Method<Byte> getX = new Template.Method<Byte>();
        public final Template.Method<Byte> getY = new Template.Method<Byte>();
        public final Template.Method<Byte> getDirection = new Template.Method<Byte>();

    }


    /**
     * Instance wrapper handle for type <b>net.minecraft.world.level.saveddata.maps.MapIcon.Type</b>.
     * To access members without creating a handle type, use the static {@link #T} member.
     * New handles can be created from raw instances using {@link #createHandle(Object)}.
     */
    @Template.Optional
    @Template.InstanceType("net.minecraft.world.level.saveddata.maps.MapIcon.Type")
    public abstract static class TypeHandle extends Template.Handle {
        /** @See {@link TypeClass} */
        public static final TypeClass T = Template.Class.create(TypeClass.class, com.bergerkiller.bukkit.common.Common.TEMPLATE_RESOLVER);
        /* ============================================================================== */

        public static TypeHandle createHandle(Object handleInstance) {
            return T.createHandle(handleInstance);
        }

        /* ============================================================================== */

        public static TypeHandle fromId(byte id) {
            return T.fromId.invoke(id);
        }

        /**
         * Stores class members for <b>net.minecraft.world.level.saveddata.maps.MapIcon.Type</b>.
         * Methods, fields, and constructors can be used without using Handle Objects.
         */
        public static final class TypeClass extends Template.Class<TypeHandle> {
            public final Template.StaticMethod.Converted<TypeHandle> fromId = new Template.StaticMethod.Converted<TypeHandle>();

        }

    }

}

