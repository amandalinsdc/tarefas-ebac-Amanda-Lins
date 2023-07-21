package mod23.Testes;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsTest {

    @Test
    public void getTodosDoGeneroFemininoTest() {
        List<String> pessoas = Arrays.asList("Amanda (f)", "José (m)", "Pedro (M)", "Paula (F)", "Neide (f)");
        List<String> generoFeminino = pessoas.stream().filter(p -> p.contains("f") || p.contains("F")).collect(Collectors.toList());

        Assert.assertEquals(3, generoFeminino.size());
        for(String f : generoFeminino) {
            Assert.assertTrue(f.toLowerCase().contains("f"));
        }
    }
}
