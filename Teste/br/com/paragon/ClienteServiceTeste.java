package br.com.paragon;

import br.com.paragon.dao.ClienteDaoMock;
import br.com.paragon.dao.IClienteDAO;
import br.com.paragon.domain.Cliente;
import br.com.paragon.services.ClienteService;
import br.com.paragon.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTeste {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTeste(){

        IClienteDAO dao =  new ClienteDaoMock();
        clienteService = new ClienteService(dao);

    }

    @Before
    public void init(){


        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("pablo");
        cliente.setCidade("são paulo");
        cliente.setEnd("rua domingos");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(44448888L);


    }

    @Test

    public void pesquisarCliente() {



        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);

    }

    public void salvarCliente(){

        Boolean retorno = clienteService.salvar(cliente);

        Assert.assertTrue(retorno);

    }
    @Test
    public void excluirCliente() {

        clienteService.excluir(cliente.getCpf());

    }

    @Test
    public void alterarCliente() {

        cliente.setNome("pablo");
        clienteService.alterar(cliente);

        Assert.assertEquals("pablo", cliente.getNome());


    }



    }


