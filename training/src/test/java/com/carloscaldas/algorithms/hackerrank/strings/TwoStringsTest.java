package com.carloscaldas.algorithms.hackerrank.strings;

import org.junit.Assert;
import org.junit.Test;

public class TwoStringsTest {
	@Test
	public void testCase01() {
		Assert.assertEquals("YES", TwoStrings.hasIntersection("dapkqnowwvdrknfvcmanjuroumppajrzklucroxvpfmcsclqa", "ivtnjtgiogmwhqybjaxlktqbwsdhqrwovoavetymkpcco"));
		Assert.assertEquals("YES", TwoStrings.hasIntersection("hrtybirxncuiailznohfawjwipdtupnxnisbwcplozwrzt", "ngdmqotxkpnuhmpfmajthzdtnztrqyugendiublcwp"));
		Assert.assertEquals("NO", TwoStrings.hasIntersection("rmpwlddwttapjzhdldjmuhmgruufltzszprzdcziigc", "bbvvkeqkqekqqennyxqxkxnyxnyqnnybnbvnyqqe"));
		Assert.assertEquals("NO", TwoStrings.hasIntersection("annbjookwtqkoivcgbqckqtvgvktobctktgkkjiac", "zsspfhmzpurrrlurdsdlrfldzyldfhudfedrszdpmsudh"));
		Assert.assertEquals("NO", TwoStrings.hasIntersection("yuuuydwovzawzamvydaaadkakukpynwfmpnmuaazokxkmjxawo", "rqiqbhgscsetgihrrrgsqrlqgcbcbrettlehbeistbiqbisie"));
		Assert.assertEquals("NO", TwoStrings.hasIntersection("ibvmfltfdvlmentbfdemebbnvllfneeefnaamtblt", "gukzzrqruyxsrqhyuggkrjujkwjhqhqsrqgkrkqxpszrzk"));
		Assert.assertEquals("YES", TwoStrings.hasIntersection("nakqzfroqouhgunxqvqbxwtibfodsvoilqrpvhtgzoholxd", "bqluorjgkkrvmiptnxegxwlhrstiiafbfoxodzyguhdwi"));
		Assert.assertEquals("NO", TwoStrings.hasIntersection("oyvgelovlyevhhedoeolyhdevcvhgceydcdehgvoc", "wsqswjnjpiarszzzxpmptrquwbnbzqiqqtzqnbajnpsjfaxr"));
		Assert.assertEquals("NO", TwoStrings.hasIntersection("hvkmgwawagozzabgmdmdvbbaxadawmbazvxohxzv", "sfiltrslqepytjpfffqlrpejiueftrnisnnppnlpuficrjys"));
		Assert.assertEquals("YES", TwoStrings.hasIntersection("nvsovybaljmzenkfgayfoxzcjantbdidxflbkhbixgzk", "qdphnbrjmznztnphhutkdbwjzmjwugtxggxchzcidngplj"));
	}

}
