package br.com.rpires.service;

import br.com.rpires.dao.IContratoDao;

/**
 * @author rodrigo.pires
 */
public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar() {
        contratoDao.buscar();
        return "Sucesso na busca";
    }

    @Override
    public String excluir() {
        contratoDao.excluir();
        return "Sucesso na exclusão";
    }

    @Override
    public String atualizar() {
        contratoDao.atualizar();
        return "Sucesso na atualização";
    }
}
