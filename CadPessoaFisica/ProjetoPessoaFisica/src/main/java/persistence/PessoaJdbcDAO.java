package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.PessoaFisica;;

public class PessoaJdbcDAO {

	private Connection conn;
	
	public PessoaJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(PessoaFisica p) throws SQLException {
		String sql = "insert into tb_pessoas values ('"+p.getNome()+"','"+p.getEndereco()+"','"+p.getBairro()+"','"+p.getCep()+
		"','"+p.getCidade()+"','"+p.getEstado()+"','"+p.getTelefone()+"','"+p.getCelular()+"','"+p.getRg()+"','"+p.getCpf()+"','"+p.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
                prepareStatement.close();
	}
}
