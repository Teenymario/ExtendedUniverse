package teenymario123.extuniverse.objects.tileEntity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static teenymario123.extuniverse.util.statics.THROTTLE;

public class basicEngineTE extends TileEntity {

    private int throttle = this.world.getBlockState(getPos()).getValue(THROTTLE);

    public int getThrottle() {
        return throttle;
    }

    public void setThrottle(int throttle) {
        this.throttle = throttle;
        markDirty();
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if(compound.hasKey("throttle")) {
            throttle = compound.getInteger("throttle");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("throttle", throttle);
        return compound;
    }

    @Override
    public boolean shouldRefresh(World worldIn, BlockPos pos, IBlockState oldState, IBlockState newState) {
        throttle = newState.getValue(THROTTLE);
        //if(!newState.getBlock().getLocalizedName().equals(oldState.getBlock().getLocalizedName())) {
        //  this.invalidate();
        //}
        Minecraft.getMinecraft().player.sendChatMessage(("Throttle value of " + throttle));
        return true;
    }

    @Override
    public boolean hasFastRenderer() {
        return true;
    }
}
