package br.com.paragon;

import br.com.paragon.dao.ClienteDAO;
import br.com.paragon.dao.ClienteDaoMock;
import br.com.paragon.dao.IClienteDAO;
import br.com.paragon.domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTeste {

    private IClienteDAO clienteDao;

    private Cliente cliente;

    public ClienteDAOTeste() {

        clienteDao = new ClienteDaoMock();

    }

    @Before
    public void init() {


        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("pablo");
        cliente.setCidade("são paulo");
        cliente.setEnd("rua domingos");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(44448888L);

        clienteDao.salvar(cliente);

    }


    @Test

    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteDao.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);


    }

    public void salvarCliente() {

        Boolean retorno = clienteDao.salvar(cliente);

        Assert.assertTrue(retorno);

    }

    @Test
    public void excluirCliente() {

        clienteDao.excluir(cliente.getCpf());

    }

    @Test
    public void alterarCliente() {

        cliente.setNome("pablo");
        clienteDao.alterar(cliente);

        Assert.assertEquals("pablo", cliente.getNome());

    }


}
