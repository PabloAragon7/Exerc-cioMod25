package br.com.paragon.dao;

import br.com.paragon.domain.Cliente;
import br.com.paragon.services.ClienteService;

public interface IClienteDAO {


    Boolean salvar(Cliente cliente);

    Cliente buscarPorCpf(Long cpf);


    void excluir(Long cpf);

    void alterar(Cliente cliente);
}
