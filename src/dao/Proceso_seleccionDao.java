package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Proceso_seleccion;

public class Proceso_seleccionDao implements Intermetodos<Proceso_seleccion> {

	@Override
	public void Grabar(Proceso_seleccion o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " insert into proceso_seleccion("
					+ "id_proyecto, "
					+ "proceso_seleccion_pertenencia, "
					+ "numero_proceso, "
					+ "valor_referencial, "
					+ "fecha_valor_referencial, "
					+ "plazo_ejecucion, "
					+ "modalidad_contratacion, "
					+ "usuario, "
					+ "fecha_registro, "
					+ "activo) "
					+ "values(?,?,?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_proyecto());
			pstm.setString(2, o.getProceso_seleccion_pertenencia());
			pstm.setString(3, o.getNumero_proceso());
			pstm.setDouble(4, o.getValor_referencial());
			pstm.setString(5, o.getFecha_valor_referencial());
			pstm.setInt(6, o.getPlazo_ejecucion());
			pstm.setString(7, o.getModalidad_contratacion());
			pstm.setString(8, o.getUsuario());
			
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
	public void Eliminar(Proceso_seleccion o) throws Exception {
		
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update proceso_seleccion set activo = 0, fecha_ultima_modificacion = sysdate() where id_proceso_seleccion = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_proceso_seleccion());
			
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
	public void Modificar(Proceso_seleccion o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " update proceso_seleccion  set "					
					+ " numero_proceso = ?, "
					+ " proceso_seleccion_pertenencia = ?,"
					+ " valor_referencial = ?, "
					+ " fecha_valor_referencial = ?, "
					+ " plazo_ejecucion = ?, "
					+ " modalidad_contratacion = ?, "
					+ " usuario = ?,"
					+ " fecha_ultima_modificacion = sysdate()"
					+ " where id_proceso_seleccion = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getNumero_proceso());
			pstm.setString(2, o.getProceso_seleccion_pertenencia());
			pstm.setDouble(3, o.getValor_referencial());
			pstm.setString(4, o.getFecha_valor_referencial());
			pstm.setInt(5, o.getPlazo_ejecucion());
			pstm.setString(6, o.getModalidad_contratacion());
			pstm.setString(7, o.getUsuario());
			
			pstm.setInt(8, o.getId_proceso_seleccion());

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
	public List<Proceso_seleccion> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Proceso_seleccion> Filtrar(Proceso_seleccion o) throws Exception {
		 Connection cn = null;
	        List<Proceso_seleccion> lista = new ArrayList<Proceso_seleccion>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ "id_proceso_seleccion,"
	            		+ "proceso_seleccion_pertenencia,"
	            		+ "numero_proceso, "
	            		+ "valor_referencial, "
	            		+ "fecha_valor_referencial, "
	            		+ "plazo_ejecucion, "
	            		+ "modalidad_contratacion, "
	            		+ "usuario "
	            		+ "  from proceso_seleccion "
	            		+ " where id_proyecto = ? "
	            		+ " and activo = 1 order by id_proceso_seleccion asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_proyecto());
	           
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Proceso_seleccion ps = new Proceso_seleccion();
		
					ps.setId_proceso_seleccion(rs.getInt("id_proceso_seleccion"));
					ps.setProceso_seleccion_pertenencia(rs.getString("proceso_seleccion_pertenencia"));
					ps.setNumero_proceso(rs.getString("numero_proceso"));
					ps.setValor_referencial(rs.getDouble("valor_referencial"));
					ps.setFecha_valor_referencial(rs.getString("fecha_valor_referencial"));
					ps.setPlazo_ejecucion(rs.getInt("plazo_ejecucion"));
					ps.setModalidad_contratacion(rs.getString("modalidad_contratacion"));
					ps.setUsuario(rs.getString("usuario"));

					lista.add(ps);
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
	
	public List<Proceso_seleccion> FiltrarPorPertenencia(Proceso_seleccion o) throws Exception {
		 Connection cn = null;
	        List<Proceso_seleccion> lista = new ArrayList<Proceso_seleccion>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ "id_proceso_seleccion,"
	            		+ "proceso_seleccion_pertenencia,"
	            		+ "numero_proceso, "
	            		+ "valor_referencial, "
	            		+ "fecha_valor_referencial, "
	            		+ "plazo_ejecucion, "
	            		+ "modalidad_contratacion, "
	            		+ "usuario "
	            		+ "  from proceso_seleccion "
	            		+ " where id_proyecto = ? and proceso_seleccion_pertenencia = ? "
	            		+ " and activo = 1 order by id_proceso_seleccion asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_proyecto());
	            pstm.setString(2, o.getProceso_seleccion_pertenencia());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Proceso_seleccion ps = new Proceso_seleccion();
		
					ps.setId_proceso_seleccion(rs.getInt("id_proceso_seleccion"));
					ps.setProceso_seleccion_pertenencia(rs.getString("proceso_seleccion_pertenencia"));
					ps.setNumero_proceso(rs.getString("numero_proceso"));
					ps.setValor_referencial(rs.getDouble("valor_referencial"));
					ps.setFecha_valor_referencial(rs.getString("fecha_valor_referencial"));
					ps.setPlazo_ejecucion(rs.getInt("plazo_ejecucion"));
					ps.setModalidad_contratacion(rs.getString("modalidad_contratacion"));
					ps.setUsuario(rs.getString("usuario"));

					lista.add(ps);
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
	public Proceso_seleccion Buscar(Proceso_seleccion o) throws Exception {
		 Connection cn = null;
	        Proceso_seleccion ps = new Proceso_seleccion();
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_proceso_seleccion,"
	            		+ " proceso_seleccion_pertenencia,"
	            		+ " numero_proceso, "
	            		+ " valor_referencial, "
	            		+ " date_format(fecha_valor_referencial, '%m/%d/%Y') as fecha_valor_referencial, "
	            		+ " plazo_ejecucion, "
	            		+ " modalidad_contratacion "
	            		+ " from proceso_seleccion "
	            		+ " where id_proceso_seleccion = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_proceso_seleccion());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	ps.setId_proceso_seleccion(rs.getInt("id_proceso_seleccion"));
	            	ps.setNumero_proceso(rs.getString("numero_proceso"));
	            	ps.setProceso_seleccion_pertenencia(rs.getString("proceso_seleccion_pertenencia"));
	            	ps.setValor_referencial(rs.getDouble("valor_referencial"));
	            	ps.setFecha_valor_referencial(rs.getString("fecha_valor_referencial"));
	            	ps.setPlazo_ejecucion(rs.getInt("plazo_ejecucion"));
	            	ps.setModalidad_contratacion(rs.getString("modalidad_contratacion"));

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
	        return ps;
	}

}
