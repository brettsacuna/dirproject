package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import database.DataAccess;

import entity.Usuario;
import entity.UsuarioView;

public class UsuarioDao implements Intermetodos<Usuario> {

	public UsuarioView Autenticar(Usuario o) throws Exception {
		Connection cn = null;
		UsuarioView usuarioView = new UsuarioView();

		try {
			cn = DataAccess.getConnection();
			String query = "select usuario.id_usuario," + " usuario.nombrecompleto," + " usuario.usuario,"
					+ " usuario.email," + " usuario.id_tipo_usuario," + " tipo_usuario.tipo_usuario"
					+ " from usuario, tipo_usuario "
					+ " where usuario.id_tipo_usuario=tipo_usuario.id_tipo_usuario and "
					+ " usuario.usuario = ? and usuario.contrasena = ? and " + " usuario.activo = 1 ";

			PreparedStatement pstm = cn.prepareStatement(query);

			pstm.setString(1, o.getUsuario());
			pstm.setString(2, o.getContrasena());

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				usuarioView.setId_usuario(rs.getInt("id_usuario"));
				usuarioView.setNombrecompleto(rs.getString("nombrecompleto"));
				usuarioView.setUsuario(rs.getString("usuario"));
				usuarioView.setEmail(rs.getString("email"));
				usuarioView.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
				usuarioView.setTipo_usuario(rs.getString("tipo_usuario"));
			}
			rs.close();
			pstm.close();

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return usuarioView;
	}

	@Override
	public void Grabar(Usuario o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " insert into usuario(nombrecompleto,usuario,email,contrasena,id_tipo_usuario) "
					+ " values(?,?,?,?,?) ";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getNombrecompleto());
			pstm.setString(2, o.getUsuario());
			pstm.setString(3, o.getEmail());
			pstm.setString(4, o.getContrasena());
			pstm.setInt(5, o.getId_tipo_usuario());

			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void Eliminar(Usuario o) throws Exception {
		Connection cn = null;

		try {
			cn = DataAccess.getConnection();

			cn.setAutoCommit(false);

			String sql = "update usuario set activo = 0 where id_usuario = ? ";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_usuario());

			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	@Override
	public void Modificar(Usuario o) throws Exception {

		Connection cn = null;

		try {
			cn = DataAccess.getConnection();

			cn.setAutoCommit(false);

			String sql = "update usuario set nombrecompleto = ?, usuario = ?, contrasena = ?, "
					+ " email = ?, id_tipo_usuario = ? where id_usuario = ? ";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getNombrecompleto());
			pstm.setString(2, o.getUsuario());
			pstm.setString(3, o.getContrasena());
			pstm.setString(4, o.getEmail());
			pstm.setInt(5, o.getId_tipo_usuario());
			pstm.setInt(6, o.getId_usuario());

			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}
	
	public void CambiarContrasena(Usuario o) throws Exception {

		Connection cn = null;

		try {
			cn = DataAccess.getConnection();

			cn.setAutoCommit(false);

			String sql = "update usuario set contrasena = ? "
					+ "  where id_usuario = ? ";

			PreparedStatement pstm = cn.prepareStatement(sql);

			
			pstm.setString(1, o.getContrasena());			
			pstm.setInt(2, o.getId_usuario());

			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	@Override
	public List<Usuario> Listar() throws Exception {
		Connection cn = null;
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = " select id_usuario, nombrecompleto, usuario, email from usuario "
					+ " where activo = 1 order by id_usuario asc";
			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Usuario usuario = new Usuario();
				// asignar valores al objeto r
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNombrecompleto(rs.getString("nombrecompleto"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setEmail(rs.getString("email"));
				lista.add(usuario);
			}
			// cerrar cursor
			rs.close();
			stm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}
	
	public List<UsuarioView> ListarView() throws Exception {
		Connection cn = null;
		List<UsuarioView> lista = new ArrayList<UsuarioView>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = " select usuario.id_usuario, usuario.nombrecompleto, usuario.usuario, usuario.email, tipo_usuario.tipo_usuario from usuario, tipo_usuario "
					+ " where usuario.id_tipo_usuario = tipo_usuario.id_tipo_usuario and usuario.activo = 1 order by usuario.id_usuario asc";
			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				UsuarioView usuario = new UsuarioView();
				// asignar valores al objeto r
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNombrecompleto(rs.getString("nombrecompleto"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTipo_usuario(rs.getString("tipo_usuario"));
				lista.add(usuario);
			}
			// cerrar cursor
			rs.close();
			stm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

	@Override
	public List<Usuario> Filtrar(Usuario o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario Buscar(Usuario o) throws Exception {
		Connection cn = null;
		Usuario usuario = new Usuario();
		try {
			cn = DataAccess.getConnection();

			String sql = " select id_usuario,nombrecompleto,usuario,contrasena,email,id_tipo_usuario "
					+ " from usuario where id_usuario = ? and activo = 1 ";

			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1, o.getId_usuario());
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {

				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNombrecompleto(rs.getString("nombrecompleto"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setContrasena(rs.getString("contrasena"));
				usuario.setEmail(rs.getString("email"));
				usuario.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));

			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return usuario;
	}

	public String ValidaUsuario(Usuario o) throws Exception {
		Connection cn = null;
		Usuario usuario = new Usuario();
		try {
			cn = DataAccess.getConnection();

			String sql = " select usuario " + " from usuario where usuario = ? and activo = 1 ";

			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, o.getUsuario());

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {

				usuario.setUsuario(rs.getString("usuario"));

			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return usuario.getUsuario();

	}

	public String ValidaEmail(Usuario o) throws Exception {
		Connection cn = null;
		Usuario usuario = new Usuario();
		try {
			cn = DataAccess.getConnection();

			String sql = " select email " + " from usuario where email = ? and activo = 1 ";

			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, o.getEmail());

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {

				usuario.setEmail(rs.getString("email"));

			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return usuario.getEmail();

	}

}
