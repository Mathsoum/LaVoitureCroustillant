package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import applicationSimulateur.VueVoiture;



public class TestVueVoiture {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testTransformationMetrePixels(){
		
		VueVoiture triangle = new VueVoiture();
		
		assertEquals(400, triangle.transformerMetrePixel(800));	
		assertEquals(100, triangle.transformerMetrePixel(201));	
		assertEquals(50, triangle.transformerMetrePixel(100));
	}
	

}
