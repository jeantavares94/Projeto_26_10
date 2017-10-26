package br.sceweb.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.data_builder.ObtemConfiguraDB;
import br.sceweb.data_builder.ObtemEmpresa;
import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC01CadastrarEmpresa_v2 {

	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO(ObtemConfiguraDB.configuracaoFIP());
		empresa = ObtemEmpresa.comDadosValidos();
		
	}
	@After
	public void tearDownAfter() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * ID - CT01UC01FBCadastra_com_sucesso
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa com 
	 * sucesso
	 * Pré-condiçao - O cnpj 89424232000180 nao esta cadastrado.
	 */
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
				assertEquals(1,empresaDAO.adiciona(empresa));
	}

}
