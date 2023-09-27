package br.com.amanda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import br.com.amanda.domain.Cliente;
import org.junit.Test;

import br.com.amanda.dao.ClienteDAO;
import br.com.amanda.dao.IClienteDAO;

import java.util.List;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteTest {

	@Test
	public void testCadastrar() throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Amanda Lins");
		
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
	}

    @Test
    public void testExcluir() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Amanda Lins");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void testBuscar() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Amanda Lins");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void testBuscarTodos() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        ClienteDAO clienteDao = new ClienteDAO();

        Cliente cliente1 = new Cliente();
        cliente1.setCodigo("01");
        cliente1.setNome("Amanda Lins");

        Integer qtdCli1 = dao.cadastrar(cliente1);
        assertTrue(qtdCli1 == 1);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("02");
        cliente2.setNome("Maria Jose");

        Integer qtdCli2 = dao.cadastrar(cliente2);
        assertTrue(qtdCli2 == 1);

        List<Cliente> clientes = clienteDao.buscarTodos();
        assertNotNull(clientes);
        assertEquals(2, clientes.size());

        int countDel = 0;
        for(Cliente cli : clientes) {
            clienteDao.excluir(cli);
            countDel++;
        }
        assertEquals(clientes.size(), countDel);
    }
}
