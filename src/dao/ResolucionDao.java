package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Resolucion;

public class ResolucionDao implements Intermetodos<Resolucion> {

	@Override
	public void Grabar(Resolucion o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			
			cn.setAutoCommit(false);
			
			String sql = " insert into resolucion("				
					+ " id_contrato_proceso_seleccion_item, "
					+ " resolucion_conformacion_comite, "
					+ " fecha_resolucion, "
					+ " miembros, "
					+ " motivo_generado, "
					+ " usuario, "
					+ " fecha_registro, "
					+ " activo) "
					+ "values(?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getResolucion_conformacion_comite());
			pstm.setString(3, o.getFecha_resolucion());
			pstm.setString(4, o.getMiembros());
			pstm.setString(5, o.getMotivo_generado());			
			pstm.setString(6, o.getUsuario());
			
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
	public void Eliminar(Resolucion o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();
			
			cn.setAutoCommit(false);
			
			String sql = " update resolucion set activo = 0, fecha_ultima_modificacion = sysdate() where id_resolucion = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_resolucion());
			
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
	public void Modificar(Resolucion o) throws Exception {
		
	Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();
			
			cn.setAutoCommit(false);
			
			String sql = " update resolucion  set "				
					+ " resolucion_conformacion_comite = ?, "
					+ " fecha_resolucion = ?, "
					+ " miembros = ?, "
					+ " motivo_generado = ?, "
					+ " usuario = ?,"
					+ " fecha_ultima_modificacion = sysdate()"
					+ " where id_resolucion = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getResolucion_conformacion_comite());
			pstm.setString(2, o.getFecha_resolucion());
			pstm.setString(3, o.getMiembros());
			pstm.setString(4, o.getMotivo_generado());
			pstm.setString(5, o.getUsuario());
			
			pstm.setInt(6, o.getId_resolucion());
						
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
	public List<Resolucion> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resolucion> Filtrar(Resolucion o) throws Exception {
		
		 Connection cn = null;
	        
		 List<Resolucion> lista = new ArrayList<Resolucion>();
	     
		 try {
	           
	            cn = DataAccess.getConnection();
	            
	            String sql =" select "
	            		+ " id_resolucion,"
	            		+ " id_contrato_proceso_seleccion_item,"
	            		+ " resolucion_conformacion_comite, "
						+ " fecha_resolucion, "
						+ " miembros, "
						+ " motivo_generado, "
	            		+ " usuario "
	            		+ "   from resolucion "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_resolucion asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
	           
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Resolucion r = new Resolucion();
		
					r.setId_resolucion(rs.getInt("id_resolucion"));
					r.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					r.setResolucion_conformacion_comite(rs.getString("resolucion_conformacion_comite"));
					r.setFecha_resolucion(rs.getString("fecha_resolucion"));
					r.setMiembros(rs.getString("miembros"));
					r.setMotivo_generado(rs.getString("motivo_generado"));
					r.setUsuario(rs.getString("usuario"));
									
					lista.add(r);
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
	        return lista;
	}

	@Override
	public Resolucion Buscar(Resolucion o) throws Exception {
		
		 Connection cn = null;
	       
		 Resolucion r = new Resolucion();
	     
		 try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_resolucion,"	            		
	            		+ " resolucion_conformacion_comite, "
						+ " date_format(fecha_resolucion, '%m/%d/%Y') as fecha_resolucion, "
						+ " miembros, "
						+ " motivo_generado "
	            		+ " 	from resolucion "
	            		+ " where id_resolucion = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_resolucion());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	r.setId_resolucion(rs.getInt("id_resolucion"));					
					r.setResolucion_conformacion_comite(rs.getString("resolucion_conformacion_comite"));
					r.setFecha_resolucion(rs.getString("fecha_resolucion"));
					r.setMiembros(rs.getString("miembros"));
					r.setMotivo_generado(rs.getString("motivo_generado"));
				
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
	        return r;
	}

}
