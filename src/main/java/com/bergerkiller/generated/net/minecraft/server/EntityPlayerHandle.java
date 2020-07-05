package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.bukkit.common.bases.IntVector3;
import org.bukkit.World;
import org.bukkit.inventory.InventoryView;
import java.util.Collection;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.EntityPlayer</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public abstract class EntityPlayerHandle extends EntityHumanHandle {
    /** @See {@link EntityPlayerClass} */
    public static final EntityPlayerClass T = new EntityPlayerClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(EntityPlayerHandle.class, "net.minecraft.server.EntityPlayer", com.bergerkiller.bukkit.common.Common.TEMPLATE_RESOLVER);

    /* ============================================================================== */

    public static EntityPlayerHandle createHandle(Object handleInstance) {
        return T.createHandle(handleInstance);
    }

    /* ============================================================================== */

    public abstract World getSpawnWorld();
    public abstract void setSpawnWorld(World world);
    public abstract InventoryView openAnvilWindow();

    public static EntityPlayerHandle fromBukkit(org.bukkit.entity.Player player) {
        return createHandle(com.bergerkiller.bukkit.common.conversion.type.HandleConversion.toEntityHandle(player));
    }
    public abstract PlayerConnectionHandle getPlayerConnection();
    public abstract void setPlayerConnection(PlayerConnectionHandle value);
    public abstract IntVector3 getSpawnCoord();
    public abstract void setSpawnCoord(IntVector3 value);
    public abstract boolean isSpawnForced();
    public abstract void setSpawnForced(boolean value);
    public abstract int getPing();
    public abstract void setPing(int value);
    /**
     * Stores class members for <b>net.minecraft.server.EntityPlayer</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class EntityPlayerClass extends Template.Class<EntityPlayerHandle> {
        public final Template.Field.Converted<PlayerConnectionHandle> playerConnection = new Template.Field.Converted<PlayerConnectionHandle>();
        public final Template.Field.Converted<IntVector3> spawnCoord = new Template.Field.Converted<IntVector3>();
        public final Template.Field.Boolean spawnForced = new Template.Field.Boolean();
        public final Template.Field.Integer ping = new Template.Field.Integer();

        public final Template.Method<World> getSpawnWorld = new Template.Method<World>();
        public final Template.Method<Void> setSpawnWorld = new Template.Method<Void>();
        @Template.Optional
        public final Template.Method<Collection<Integer>> getRemoveQueue = new Template.Method<Collection<Integer>>();
        public final Template.Method<InventoryView> openAnvilWindow = new Template.Method<InventoryView>();

    }

}

