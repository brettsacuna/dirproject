package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Defecto_constructivo;

public class Defecto_constructivoDao implements Intermetodos<Defecto_constructivo>{

	@Override
	public void Grabar(Defecto_constructivo o) throws Exception {
	Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();			
			cn.setAutoCommit(false);
			
			String sql = " insert into defecto_constructivo ("					
					+ "id_contrato_proceso_seleccion_item, "
					+ "asiento_cuaderno_obra,"
					+ "defecto_constructivo,"
					+ " fecha_encontrado, "
					+ "estado_defecto, "
					+ "acciones, "
					+ "usuario, "
					+ "fecha_registro, "					
					+ "activo) "
					+ "values(?,?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getAsiento_cuaderno_obra());	
			pstm.setString(3, o.getDefecto_constructivo());
			pstm.setString(4, o.getFecha_encontrado());
			pstm.setString(5, o.getEstado_defecto());
			pstm.setString(6, o.getAcciones());
			pstm.setString(7, o.getUsuario());
			
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
	public void Eliminar(Defecto_constructivo o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update defecto_constructivo set activo = 0, fecha_ultima_modificacion = sysdate() where id_defecto_constructivo = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_defecto_constructivo());
			
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
	public void Modificar(Defecto_constructivo o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " update defecto_constructivo  set "					
					+ " asiento_cuaderno_obra = ?, "
					+ " defecto_constructivo = ?, "
					+ " fecha_encontrado = ?, "
					+ " estado_defecto = ?, "
					+ " acciones = ?, "
					+ " usuario = ?,"
					+ " fecha_ultima_modificacion = sysdate()"
					+ " where id_defecto_constructivo = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getAsiento_cuaderno_obra());
			pstm.setString(2, o.getDefecto_constructivo());
			pstm.setString(3, o.getFecha_encontrado());
			pstm.setString(4, o.getEstado_defecto());
			pstm.setString(5, o.getAcciones());
			pstm.setString(6, o.getUsuario());
			
			pstm.setInt(7, o.getId_defecto_constructivo());

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
	public List<Defecto_constructivo> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Defecto_constructivo> Filtrar(Defecto_constructivo o) throws Exception {
		 Connection cn = null;
	        List<Defecto_constructivo> lista = new ArrayList<Defecto_constructivo>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ "id_defecto_constructivo,"
	            		+ "id_contrato_proceso_seleccion_item, "
	            		+ "asiento_cuaderno_obra,"
	            		+ "defecto_constructivo,"
	            		+ " fecha_encontrado, "
	            		+ "estado_defecto, "
	            		+ "acciones, "
	            		+ "usuario"	            		 
	            		+ " from defecto_constructivo "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_defecto_constructivo asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Defecto_constructivo dc = new Defecto_constructivo();
		
					dc.setId_defecto_constructivo(rs.getInt("id_defecto_constructivo"));
					dc.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					dc.setAsiento_cuaderno_obra(rs.getString("asiento_cuaderno_obra"));
					dc.setDefecto_constructivo(rs.getString("defecto_constructivo"));
					dc.setFecha_encontrado(rs.getString("fecha_encontrado"));
					dc.setEstado_defecto(rs.getString("estado_defecto"));
					dc.setAcciones(rs.getString("acciones"));
					dc.setUsuario(rs.getString("usuario"));

					lista.add(dc);
	            }
	            // cerrar cursor
	            rs.close();
	            pstm.close();
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            try {
	                cn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return lista;
	}

	@Override
	public Defecto_constructivo Buscar(Defecto_constructivo o) throws Exception {
		 Connection cn = null;

	        Defecto_constructivo dc = new Defecto_constructivo();
	     
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_defecto_constructivo,"
	            		+ " asiento_cuaderno_obra,"
	            		+ " defecto_constructivo,"
	            		+ " date_format(fecha_encontrado, '%m/%d/%Y') as fecha_encontrado, "
	            		+ " estado_defecto, "
	            		+ " acciones "
	            		+ " from defecto_constructivo "
	            		+ " where id_defecto_constructivo = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_defecto_constructivo());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	dc.setId_defecto_constructivo(rs.getInt("id_defecto_constructivo"));
	            	dc.setAsiento_cuaderno_obra(rs.getString("asiento_cuaderno_obra"));
	            	dc.setDefecto_constructivo(rs.getString("defecto_constructivo"));
	            	dc.setFecha_encontrado(rs.getString("fecha_encontrado"));
	            	dc.setEstado_defecto(rs.getString("estado_defecto"));
	            	dc.setAcciones(rs.getString("acciones"));
	            }
	            rs.close();
	            pstm.close();
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            try {
	                cn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return dc;
	}

}
