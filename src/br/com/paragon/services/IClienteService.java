package br.com.paragon.services;

import br.com.paragon.domain.Cliente;

public interface IClienteService {
    Boolean salvar(Cliente cliente);

    Cliente buscarPorCpf(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente);
}
