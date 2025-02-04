package com.bergerkiller.bukkit.common.bases;

import com.bergerkiller.bukkit.common.utils.MathUtil;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Represents a class containing three immutable integer coordinates: x, y and z
 */
public class IntVector3 implements Comparable<IntVector3> {

    public static final IntVector3 ZERO = new IntVector3(0, 0, 0);
    public final int x, y, z;

    public IntVector3(Block block) {
        this(block.getX(), block.getY(), block.getZ());
    }

    public IntVector3(Location loc) {
        this(loc.getX(), loc.getY(), loc.getZ());
    }

    public IntVector3(final double x, final double y, final double z) {
        this(MathUtil.floor(x), MathUtil.floor(y), MathUtil.floor(z));
    }

    public IntVector3(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + ", " + z + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (object instanceof IntVector3) {
            IntVector3 other = (IntVector3) object;
            return this.x == other.x && this.y == other.y && this.z == other.z;
        } else {
            return false;
        }
    }

    /**
     * Version of {@link #equals(Object)} that eliminates reference equality and
     * type casting.
     *
     * @param other Other vector, can not be null or a NPE is thrown
     * @return True if this and the other IntVector are the same
     */
    public boolean isSame(IntVector3 other) {
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

    @Override
    public int hashCode() {
        return this.x + (this.z << 8) + (this.y << 16);
    }

    @Override
    public int compareTo(IntVector3 other) {
        return this.y == other.y ? (this.z == other.z ? this.x - other.x : this.z - other.z) : this.y - other.y;
    }

    public IntVector3 subtract(int x, int y, int z) {
        return new IntVector3(this.x - x, this.y - y, this.z - z);
    }

    public IntVector3 subtract(IntVector3 other) {
        return subtract(other.x, other.y, other.z);
    }

    public IntVector3 subtract(BlockFace face, int length) {
        return subtract(face.getModX() * length, face.getModY() * length, face.getModZ() * length);
    }

    public IntVector3 subtract(BlockFace face) {
        return subtract(face.getModX(), face.getModY(), face.getModZ());
    }

    public IntVector3 add(int x, int y, int z) {
        return new IntVector3(this.x + x, this.y + y, this.z + z);
    }

    public IntVector3 add(IntVector3 other) {
        return add(other.x, other.y, other.z);
    }

    public IntVector3 add(BlockFace face, int length) {
        return add(face.getModX() * length, face.getModY() * length, face.getModZ() * length);
    }

    public IntVector3 add(BlockFace face) {
        return add(face.getModX(), face.getModY(), face.getModZ());
    }

    public IntVector3 multiply(int x, int y, int z) {
        return new IntVector3(this.x * x, this.y * y, this.z * z);
    }

    public IntVector3 multiply(double x, double y, double z) {
        return new IntVector3((double) this.x * x, (double) this.y * y, (double) this.z * z);
    }

    public IntVector3 multiply(int factor) {
        return multiply(factor, factor, factor);
    }

    public IntVector3 multiply(double factor) {
        return multiply(factor, factor, factor);
    }

    public IntVector3 multiply(IntVector3 other) {
        return multiply(other.x, other.y, other.z);
    }

    public IntVector3 abs() {
        return new IntVector3(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    /**
     * Checks whether the x, y or z coordinate is greater than the value
     * specified
     *
     * @param value to check
     * @return True if x/y/z > value, False otherwise
     */
    public boolean greaterThan(int value) {
        return x > value || y > value || z > value;
    }

    /**
     * Checks whether the x, y or z coordinate is greater/equal than the value
     * specified
     *
     * @param value to check
     * @return True if x/y/z >= value, False otherwise
     */
    public boolean greaterEqualThan(int value) {
        return x >= value || y >= value || z >= value;
    }

    public int getChunkX() {
        return x >> 4;
    }

    public int getChunkY() {
        return y >> 4;
    }

    public int getChunkZ() {
        return z >> 4;
    }

    /**
     * Gets the block at the coordinates of this IntVector3 on the world
     * specified
     *
     * @param world to get a block of
     * @return block at the world
     */
    public Block toBlock(World world) {
        return world.getBlockAt(x, y, z);
    }

    /**
     * Obtains the chunk coordinates, treating this IntVector3 as block
     * coordinates
     *
     * @return chunk coordinates
     */
    public IntVector2 toChunkCoordinates() {
        return new IntVector2(getChunkX(), getChunkZ());
    }

    /**
     * Gets the position Vector of the middle of 'the' block
     *
     * @return block middle position Vector
     */
    public Vector midVector() {
        return new Vector(midX(), midY(), midZ());
    }

    /**
     * Gets the X-coordinate of the middle of 'the' block
     *
     * @return block middle X
     */
    public double midX() {
        return (double) x + 0.5;
    }

    /**
     * Gets the Y-coordinate of the middle of 'the' block
     *
     * @return block middle Y
     */
    public double midY() {
        return (double) y + 0.5;
    }

    /**
     * Gets the Z-coordinate of the middle of 'the' block
     *
     * @return block middle Z
     */
    public double midZ() {
        return (double) z + 0.5;
    }

    /**
     * Converts this IntVector3 into an IntVector2 using the x/z coordinates
     *
     * @return new IntVector2
     */
    public IntVector2 toIntVector2() {
        return new IntVector2(x, z);
    }

    public static IntVector3 read(DataInputStream stream) throws IOException {
        return new IntVector3(stream.readInt(), stream.readInt(), stream.readInt());
    }

    public void write(DataOutputStream stream) throws IOException {
        stream.writeInt(this.x);
        stream.writeInt(this.y);
        stream.writeInt(this.z);
    }

    /**
     * Creates an IntVector3 with the specified x/y/z coordinates
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     * @param z Z-coordinate
     * @return new IntVector3
     */
    public static IntVector3 of(int x, int y, int z) {
        return new IntVector3(x, y, z);
    }

    /**
     * Creates an IntVector3 with the coordinates of a Block
     *
     * @param block Block to get the coordinates of
     * @return new IntVector3
     */
    public static IntVector3 coordinatesOf(Block block) {
        return new IntVector3(block.getX(), block.getY(), block.getZ());
    }

    /**
     * Creates an IntVector3 of the Block coordinates of the specified
     * double x/y/z position coordinates
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     * @param z Z-coordinate
     * @return new IntVector3
     */
    public static IntVector3 blockOf(double x, double y, double z) {
        return new IntVector3(MathUtil.floor(x), MathUtil.floor(y), MathUtil.floor(z));
    }

    /**
     * Creates an IntVector3 of the Block coordinates of the specified
     * Vector position
     *
     * @param position Position Vector
     * @return new IntVector3
     */
    public static IntVector3 blockOf(Vector position) {
        return new IntVector3(position.getBlockX(), position.getBlockY(), position.getBlockZ());
    }

    /**
     * Creates an IntVector3 of the Block coordinates of the specified
     * Location position
     *
     * @param position Position Location
     * @return new IntVector3
     */
    public static IntVector3 blockOf(Location location) {
        return new IntVector3(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }
}
