package micdoodle8.mods.galacticraft.mars.wgen;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.wgen.GCCoreMapGenBaseMeta;
import micdoodle8.mods.galacticraft.moon.blocks.GCMoonBlocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Copyright 2012-2013, micdoodle8
 * 
 * All rights reserved.
 * 
 */
public class GCMarsCavern extends GCCoreMapGenBaseMeta
{
    protected void generateLargeCaveNode(long par1, int origXChunkCoord, int origZChunkCoord, short[] blockIdArray, byte[] metaArray, double xPos, double yPos, double zPos)
    {
        this.generateCaveNode(par1, origXChunkCoord, origZChunkCoord, blockIdArray, metaArray, xPos, yPos, zPos, 1.0F + this.rand.nextFloat() * 6.0F, 10.0F, 10.0F, -1, -1, 0.2D);
    }

    protected void generateCaveNode(long par1, int par3, int par4, short[] blockIdArray, byte[] metaArray, double par6, double par8, double par10, float par12, float par13, float par14, int par15, int par16, double par17)
    {
        final double d4 = par3 * 16 + 8;
        final double d5 = par4 * 16 + 8;
        float f3 = 0.0F;
        float f4 = 0.0F;
        final Random random = new Random(par1);

        if (par16 <= 0)
        {
            final int j1 = this.range * 16 - 16;
            par16 = j1 - random.nextInt(j1 / 4);
        }

        boolean flag = false;

        if (par15 == -1)
        {
            par15 = par16 / 2;
            flag = true;
        }

        final int k1 = random.nextInt(par16 / 2) + par16 / 4;

        for (final boolean flag1 = random.nextInt(6) == 0; par15 < par16; ++par15)
        {
            final double d6 = 1.5D + MathHelper.sin(par15 * (float) Math.PI / par16) * par12 * 1.0F;
            final double d7 = d6 * par17;
            final float f5 = MathHelper.cos(par14);
            final float f6 = MathHelper.sin(par14);
            par6 += MathHelper.cos(par13) * f5;
            par8 += f6;
            par10 += MathHelper.sin(par13) * f5;

            if (flag1)
            {
                par14 *= 0.92F;
            }
            else
            {
                par14 *= 0.7F;
            }

            par14 += f4 * 0.1F;
            par13 += f3 * 0.1F;
            f4 *= 0.9F;
            f3 *= 0.75F;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;

            if (!flag && par15 == k1 && par12 > 1.0F && par16 > 0)
            {
                this.generateCaveNode(random.nextLong(), par3, par4, blockIdArray, metaArray, par6, par8, par10, random.nextFloat() * 0.5F + 0.5F, par13 - (float) Math.PI / 2F, par14 / 3.0F, par15, par16, 1.0D);
                this.generateCaveNode(random.nextLong(), par3, par4, blockIdArray, metaArray, par6, par8, par10, random.nextFloat() * 0.5F + 0.5F, par13 + (float) Math.PI / 2F, par14 / 3.0F, par15, par16, 1.0D);
                return;
            }

            if (flag || random.nextInt(4) != 0)
            {
                final double d8 = par6 - d4;
                final double d9 = par10 - d5;
                final double d10 = par16 - par15;
                final double d11 = par12 + 2.0F + 16.0F;

                if (d8 * d8 + d9 * d9 - d10 * d10 > d11 * d11)
                {
                    return;
                }

                if (par6 >= d4 - 16.0D - d6 * 2.0D && par10 >= d5 - 16.0D - d6 * 2.0D && par6 <= d4 + 16.0D + d6 * 2.0D && par10 <= d5 + 16.0D + d6 * 2.0D)
                {
                    int l1 = MathHelper.floor_double(par6 - d6) - par3 * 16 - 1;
                    int i2 = MathHelper.floor_double(par6 + d6) - par3 * 16 + 1;
                    int j2 = MathHelper.floor_double(par8 - d7) - 1;
                    int k2 = MathHelper.floor_double(par8 + d7) + 1;
                    int l2 = MathHelper.floor_double(par10 - d6) - par4 * 16 - 1;
                    int i3 = MathHelper.floor_double(par10 + d6) - par4 * 16 + 1;

                    if (l1 < 0)
                    {
                        l1 = 0;
                    }

                    if (i2 > 16)
                    {
                        i2 = 16;
                    }

                    if (j2 < 1)
                    {
                        j2 = 1;
                    }

                    if (k2 > 120)
                    {
                        k2 = 120;
                    }

                    if (l2 < 0)
                    {
                        l2 = 0;
                    }

                    if (i3 > 16)
                    {
                        i3 = 16;
                    }

                    final boolean flag2 = false;
                    int j3;
                    for (j3 = l1; !flag2 && j3 < i2; ++j3)
                    {
                        for (int l3 = l2; !flag2 && l3 < i3; ++l3)
                        {
                            for (int i4 = k2 + 1; !flag2 && i4 >= j2 - 1; --i4)
                            {
                                if (i4 >= 0 && i4 < 128)
                                {
                                    if (i4 != j2 - 1 && j3 != l1 && j3 != i2 - 1 && l3 != l2 && l3 != i3 - 1)
                                    {
                                        i4 = j2;
                                    }
                                }
                            }
                        }
                    }

                    if (!flag2)
                    {

                        for (int localY = j2; localY < k2; localY++)
                        {
                            final double yfactor = (localY + 0.5D - par8) / d7;
                            final double yfactorSq = yfactor * yfactor;

                            for (int localZ = l1; localZ < i2; localZ++)
                            {
                                final double zfactor = (localZ + par3 * 16 + 0.5D - par6) / d6;
                                final double zfactorSq = zfactor * zfactor;

                                for (int localX = l2; localX < i3; localX++)
                                {
                                    final double xfactor = (localX + par4 * 16 + 0.5D - par10) / d6;
                                    final double xfactorSq = xfactor * xfactor;

                                    if (xfactorSq + zfactorSq < 1.0D)
                                    {
                                        final int coords = localY << 8 | localZ << 4 | localX;

                                        if (yfactor > -0.7D && xfactorSq + yfactorSq + zfactorSq < 1.0D)
                                        {
                                            if (blockIdArray[coords] == GCMoonBlocks.blockMoon.blockID && (metaArray[coords] == 3 || metaArray[coords] == 4))
                                            {
                                                blockIdArray[coords] = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (flag)
                        {
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void recursiveGenerate(World par1World, int par2, int par3, int par4, int par5, short[] blockIdArray, byte[] metaArray)
    {
        int i1 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(40) + 1) + 1);

        if (this.rand.nextInt(15) != 0)
        {
            i1 = 0;
        }

        for (int j1 = 0; j1 < i1; ++j1)
        {
            final double d0 = par2 * 16 + this.rand.nextInt(16);
            final double d1 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            final double d2 = par3 * 16 + this.rand.nextInt(16);
            int k1 = 1;

            if (this.rand.nextInt(4) == 0)
            {
                this.generateLargeCaveNode(this.rand.nextLong(), par4, par5, blockIdArray, metaArray, d0, d1, d2);
                k1 += this.rand.nextInt(4);
            }

            for (int l1 = 0; l1 < k1; ++l1)
            {
                final float f = this.rand.nextFloat() * (float) Math.PI * 2.0F;
                final float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f2 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();

                if (this.rand.nextInt(10) == 0)
                {
                    f2 *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F;
                }

                this.generateCaveNode(this.rand.nextLong(), par4, par5, blockIdArray, metaArray, d0, d1, d2, f2, f, f1, 0, 0, 1.0D);
            }
        }
    }
}
