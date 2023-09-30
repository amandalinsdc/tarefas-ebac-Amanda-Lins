package br.com.amanda.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amanda.utils.ReplaceUtils;

public class ReplaceUtilsTest {

	@Test
	public void replaceCPF() {
		String cpf = "578.324.242-65";
		String newCpf = ReplaceUtils.replace(cpf, ".", "-");
		
		assertEquals(newCpf, "57832424265");
	}
	
	@Test
	public void replaceTel() {
		String tel = "(85) 98765-1234";
		String newtel = ReplaceUtils.replace(tel, "(", ")", " ", "-");
		
		assertEquals(newtel, "85987651234");
	}
}
