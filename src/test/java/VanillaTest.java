import com.evilco.mc.nbt.ITag;
import com.evilco.mc.nbt.stream.NBTInputStream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * @auhtor Johannes Donath <johannesd@evil-co.com>
 * @copyright Copyright (C) 2014 Evil-Co <http://www.evil-co.org>
 */
@RunWith (MockitoJUnitRunner.class)
public class VanillaTest {

	/**
	 * Tries to load a gzipped test file.
	 * @throws IOException
	 */
	@Test
	public void testGzip () throws IOException {
		// create NBT stream
		NBTInputStream inputStream = new NBTInputStream (new GZIPInputStream (this.getClass ().getResourceAsStream ("/big.nbt")));

		// read NBT
		ITag tag = inputStream.readTag ();

		// verify result
		Assert.assertNotNull (tag);
	}

	/**
	 * Tries to load a hello world NBT file.
	 * @throws IOException
	 */
	@Test
	public void testHelloWorld () throws IOException {
		// create NBT stream
		NBTInputStream inputStream = new NBTInputStream (this.getClass ().getResourceAsStream ("/helloWorld.nbt"));

		// read NBT
		ITag tag = inputStream.readTag ();

		// verify result
		Assert.assertNotNull (tag);
	}

	/**
	 * Tries to load a vanilla servers.dat
	 */
	@Test
	public void testLoadServers () throws IOException {
		// create NBT stream
		NBTInputStream inputStream = new NBTInputStream (this.getClass ().getResourceAsStream ("/servers.nbt"));

		// read NBT
		ITag tag = inputStream.readTag ();

		// verify result
		Assert.assertNotNull (tag);
	}
}