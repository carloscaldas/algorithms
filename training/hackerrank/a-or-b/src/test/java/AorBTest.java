import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

import com.carloscaldas.testutils.SystemIOGather;

public class AorBTest {

	private void bigIntegerTest(String input, String output, boolean fbi) throws IOException {
		SystemIOGather catcher = new SystemIOGather();
		catcher.readFrom(input);
		if (fbi) {
			Solution.main(null);
		} else {
			SolutionWithBigInteger.main(null);
		}
		catcher.end();
		boolean equalToFile = catcher.isOutputEqualToFile(output);
		Assert.assertTrue(equalToFile);
	}

	public void input01_bigInteger() throws IOException {
		bigIntegerTest("input01.txt", "output01.txt", false);
	}

	public void input13_bigInteger() throws IOException {
		bigIntegerTest("input13.txt", "output13.txt", false);
	}

	@Test
	public void input18_bigInteger() throws IOException {
		bigIntegerTest("input18.txt", "output18.txt", false);
	}

	@Test
	public void input19_bigInteger() throws IOException {
		bigIntegerTest("input19.txt", "output19.txt", false);
	}

	@Test
	public void input20_bigInteger() throws IOException {
		bigIntegerTest("input20.txt", "output20.txt", false);
	}

	@Test
	public void input00_fbi() throws IOException {
		bigIntegerTest("input00.txt", "output00.txt", true);
	}

	@Test
	public void input01_fbi() throws IOException {
		bigIntegerTest("input01.txt", "output01.txt", true);
	}

	@Test
	public void input02_fbi() throws IOException {
		bigIntegerTest("input02.txt", "output02.txt", true);
	}

	@Test
	public void input03_fbi() throws IOException {
		bigIntegerTest("input03.txt", "output03.txt", true);
	}

	@Test
	public void input04_fbi() throws IOException {
		bigIntegerTest("input04.txt", "output04.txt", true);
	}

	@Test
	public void input05_fbi() throws IOException {
		bigIntegerTest("input05.txt", "output05.txt", true);
	}

	@Test
	public void input06_fBI() throws IOException {
		bigIntegerTest("input06.txt", "output06.txt", true);
	}

	@Test
	public void input07_fBI() throws IOException {
		bigIntegerTest("input07.txt", "output07.txt", true);
	}

	@Test
	public void input08_fBI() throws IOException {
		bigIntegerTest("input08.txt", "output08.txt", true);
	}

	@Test
	public void input09_fBI() throws IOException {
		bigIntegerTest("input09.txt", "output09.txt", true);
	}

	@Test
	public void input10_fBI() throws IOException {
		bigIntegerTest("input10.txt", "output10.txt", true);
	}

	@Test
	public void input11_fBI() throws IOException {
		bigIntegerTest("input11.txt", "output11.txt", true);
	}

	@Test
	public void input12_fBI() throws IOException {
		bigIntegerTest("input12.txt", "output12.txt", true);
	}

	@Test
	public void input13_fBI() throws IOException {
		bigIntegerTest("input13.txt", "output13.txt", true);
	}

	@Test
	public void input14_fBI() throws IOException {
		bigIntegerTest("input14.txt", "output14.txt", true);
	}

	@Test
	public void input15_fBI() throws IOException {
		bigIntegerTest("input15.txt", "output15.txt", true);
	}

	@Test
	public void input16_fBI() throws IOException {
		bigIntegerTest("input16.txt", "output16.txt", true);
	}

	@Test
	public void input17_fBI() throws IOException {
		bigIntegerTest("input17.txt", "output17.txt", true);
	}

	@Test
	public void input18_fbi() throws IOException {
		bigIntegerTest("input18.txt", "output18.txt", true);
	}

	@Test
	public void input19_fbi() throws IOException {
		bigIntegerTest("input19.txt", "output19.txt", true);
	}

	@Test
	public void input20_fBI() throws IOException {
		bigIntegerTest("input20.txt", "output20.txt", true);
	}

}
